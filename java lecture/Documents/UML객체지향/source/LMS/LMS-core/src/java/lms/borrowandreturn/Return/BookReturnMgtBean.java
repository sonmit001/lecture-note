/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.borrowandreturn.Return;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lms.common.entity.Book;
import lms.common.entity.BookBorrow;
import lms.common.entity.BookItem;
import lms.common.entity.LibraryUser;
import lms.common.entity.PublicationKey;
import lms.common.exception.UnknownBookBorrowIDException;
import lms.common.exception.UnknownBookIDException;
import lms.common.type.BookBorrowStatus;
import lms.common.type.BookItemStatus;
import lms.common.type.PublicationType;
import lms.externalsystem.smssystem.SMSSIRemote;

/**
 *
 * @author chae
 */
@Stateless
public class BookReturnMgtBean implements BookReturnMgtRemote {

    @EJB
    private SMSSIRemote sMSSIBean;
    @PersistenceContext(unitName="LMS-corePU")
    private EntityManager em;
    
    
    private static int ReturnExpectedDayDelta = 14 ;
    private static int ReturnExtendDay = 7 ;
    private static int OverDuePayPerDay = 100 ;

    private  void returnBookItem(Long bookBorrowID) throws UnknownBookBorrowIDException {
        
        try {
            BookBorrow bookBorrow = em.find(BookBorrow.class, bookBorrowID) ;
            
            if ( bookBorrow == null ) {
                throw new UnknownBookBorrowIDException(bookBorrowID) ;
            }
            
            em.refresh(bookBorrow) ;
            
            System.out.println("BookItem to return: " + bookBorrow) ;
            
            bookBorrow.setStatus(BookBorrowStatus.Returned);
            Calendar today  = Calendar.getInstance();
            Date returnDate = today.getTime() ;
            bookBorrow.setReturnDate(returnDate) ;
            
            bookBorrow.getBookItem().setStatus(BookItemStatus.Borrowable) ;
            em.persist(bookBorrow);
            em.flush();
            
            // 늦게 반환된 것이면 연체료을 부과하여 전달하도록 한다.    
            issueOverdueFee(bookBorrowID) ;
            
            // 대기자가 있으면 대기자에게 대출신청이 가능함을 통보한다.
            Book book = (Book) bookBorrow.getBookItem().getPublication() ;
            notifyBookAvailability(book.getPublicationNumber()) ;
            
        }
        catch (Exception e) {
            throw new EJBException(e) ;
        }
    }

    private void notifyBookAvailability(String publicationNumber) {
        
        try {
            PublicationKey key  = new PublicationKey(PublicationType.Book, publicationNumber) ;
            
            Book theBook = em.find(Book.class, key) ;
            
            assert theBook != null ;
           
            em.refresh(theBook) ;
            
            System.out.println("Book to to be notified: " + theBook) ;
            Collection<LibraryUser> waiters = theBook.getWaiters() ;
            
            for ( Iterator it = waiters.iterator() ; it.hasNext(); ) {
                
                LibraryUser waiter = (LibraryUser) it.next() ;
                
                String phoneNumber = waiter.getPhoneNumber() ;
            
                String msg = "대기 중인 저자: " + theBook.getAuthorName() + " 의 도서: " + theBook.getTitle() + " 에 대한 대출신청이 가능합니다." ;
                sMSSIBean.requestMessage(phoneNumber, msg);
            }
            // 대기자 목록을 초기화 시킨다.
            theBook.setWaiters(null);
        }
        catch (Exception e) {
            throw new EJBException(e) ;
        }
        
        
    }
    private void issueOverdueFee(Long bookBorrowID) throws UnknownBookBorrowIDException {
        
        try {
            // 연체료를 계산한다.
            int overdueFee = getOverdueFee(bookBorrowID) ;
        
            // 연체료가 부과됨을 SMS로 통보한다.
            BookBorrow bookBorrow = em.find(BookBorrow.class, bookBorrowID) ;
            
            if ( bookBorrow == null ) {
                throw new UnknownBookBorrowIDException(bookBorrowID) ;
            }
            em.refresh(bookBorrow) ;
            
            String phoneNumber = bookBorrow.getBorrower().getPhoneNumber() ;
            
            String msg = "도서 반납이 연체되어 연체료가 부과되었읍니다. 연체 금액: " + overdueFee ;
            sMSSIBean.requestMessage(phoneNumber, msg);
        
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
        
    }
    public void persist(Object object) {
        em.persist(object);
    }

    public void returnBookItem(String registrationNumber)
        throws UnknownBookIDException, UnknownBookBorrowIDException {
        
        // registrationNumber로부터 bookBorrowID를 찾는다.
        // 그리고 returnBookItem(bookBorrowID)를 호출한다.
        
        BookItem bi = em.find(BookItem.class, registrationNumber) ;
        if ( bi == null ) {
            throw new UnknownBookIDException(registrationNumber) ;
        }
        
        em.refresh(bi) ;
        Collection<BookBorrow> bbs = bi.getBookBorrows() ;
        System.out.println("List of book borrows for book item: " + registrationNumber) ;
        
        for ( Iterator it = bbs.iterator() ; it.hasNext() ; ) {     
            BookBorrow bb = (BookBorrow) it.next() ;
            
            System.out.println("\tTitle:  " + bb.getBookItem().getPublication().getTitle()) ;
            System.out.println("\tBorrowed Date: " + bb.getBorrowDate()) ;
            System.out.println("\tStatus: " + bb.getStatus()) ;
            
            if ( bb.getStatus() == BookBorrowStatus.Borrowed ) {
                
                returnBookItem(bb.getId()) ;
                return ;
                
            }
        }
    }
    
    private  Date getReturnExpectedDate(Date borrowDate, int extendCount) {
        if ( borrowDate == null ) return null ;
        
        Calendar expectedDate = new GregorianCalendar() ;
        expectedDate.setTime(borrowDate) ;
        expectedDate.add(Calendar.DAY_OF_MONTH, ReturnExpectedDayDelta + extendCount*ReturnExtendDay ) ;
            
        return expectedDate.getTime() ; 
    }
    
    public Date getReturnExpectedDate(Long bookBorrowID ) throws UnknownBookBorrowIDException {
        
        try {
            BookBorrow bookBorrow = em.find(BookBorrow.class, bookBorrowID) ;
            
            if ( bookBorrow == null ) {
                throw new UnknownBookBorrowIDException(bookBorrowID) ;
            }
            em.refresh(bookBorrow) ;
            
            Date borrowDate = bookBorrow.getBorrowDate() ;
            int extendCount = bookBorrow.getReturnExtendNumber() ;
            
            return getReturnExpectedDate(borrowDate, extendCount) ;
            
        }
        catch (Exception e) {
            throw new EJBException(e) ;
        }
        
    }

    public int getOverdueFee(Long bookBorrowID) throws UnknownBookBorrowIDException  {
        
        try {
            BookBorrow bookBorrow = em.find(BookBorrow.class, bookBorrowID) ;
            
            if ( bookBorrow == null ) {
                throw new UnknownBookBorrowIDException(bookBorrowID) ;
            }
            em.refresh(bookBorrow) ;
            
            Date returnExpectedDate = getReturnExpectedDate(bookBorrowID) ;
            Date returnDate = bookBorrow.getReturnDate() ;
            
            int overdueFee = getOverdueFee(returnExpectedDate, returnDate) ;
            
            return overdueFee ;
                    
            }
        catch (Exception e) {
            throw new EJBException(e) ;
        }
            
    }
    private int getOverdueFee(Date expectedDate, Date actualDate) {
        
        //System.out.println("BookReturnMgtBean::getOverDueFee for expected: " + expectedDate + " and actual: " + actualDate) ;
        
        if ( expectedDate == null || actualDate == null ) return 0 ;
        
        if ( actualDate.before(expectedDate) ) return 0 ;
        
        Calendar expected = new GregorianCalendar() ;
        expected.setTime(expectedDate) ;
        
        Calendar actual = new GregorianCalendar() ;
        actual.setTime(actualDate) ;
        
        long expectedInMilli = expected.getTimeInMillis() ;
        long actualInMilli = actual.getTimeInMillis() ;
        
        long diffInMilli = actualInMilli - expectedInMilli ;
        
        //int lateDays = diff.get(Calendar.DAY_OF_MONTH) ;
        int lateDays = (int) (diffInMilli / ( 24 * 60 * 60 * 1000 ) );
        
        //System.out.println("delays in milisec: " + diffInMilli + " and in days: " + lateDays) ;
        
        return lateDays * OverDuePayPerDay ;
        
    }

    public void payOverdueFee(Long bookBorrowID) throws UnknownBookBorrowIDException {
        
        try {
            BookBorrow bookBorrow = em.find(BookBorrow.class, bookBorrowID) ;
            
            if ( bookBorrow == null ) {
                throw new UnknownBookBorrowIDException(bookBorrowID) ;
            }
            
            em.refresh(bookBorrow) ;
            
            //System.out.println("BookItem to pay for overdue fee: " + bookBorrow) ;
            
            bookBorrow.setOverDueFeePaid(true) ;

            em.persist(bookBorrow);
            em.flush();
            
        }
        catch (Exception e) {
            throw new EJBException(e) ;
        }
        
    } 
}
