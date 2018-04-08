/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.borrowandreturn.borrow;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lms.borrowandreturn.Return.BookReturnMgtRemote;
import lms.common.entity.BookBorrow;
import lms.common.entity.BookItem;
import lms.common.entity.LibraryUser;
import lms.common.exception.AlreadyBorrowRequestedBookItemException;
import lms.common.exception.NotBorrowRequestedBookException;
import lms.common.exception.OverdueFeeNotPaidException;
import lms.common.exception.TooManyBorrowRequestedException;
import lms.common.exception.TooManyReturnExtensionException;
import lms.common.exception.UnknownBookBorrowIDException;
import lms.common.exception.UnknownBookIDException;
import lms.common.exception.UnknownBookItemIDException;
import lms.common.exception.UnknownUserIDException;
import lms.common.type.BookBorrowInfo;
import lms.common.type.BookBorrowStatus;
import lms.common.type.BookItemStatus;

/**
 *
 * @author chae
 */
@Stateless
//@Local(BookBorrowMain.class)
public class BookBorrowMainBean implements BookBorrowMain  {
    
    private static int BorrowExpectedDayDelta = 2 ;
    
    @PersistenceContext(unitName="LMS-corePU")
    private EntityManager em;
    
    private BookBorrowTimer timer ;
    private BookBorrowRequestAutoCancel timeoutHandler ;
    private BookReturnMgtRemote bookReturnMgtBean ;
    
    public void setBookBorrowTimer(BookBorrowTimer timer) {
        this.timer = timer ;
    }
    public void setBookBorrowRequestAutoCancel(BookBorrowRequestAutoCancel handler) {
        this.timeoutHandler = handler ;
    }
    public void setBookReturnMgtBean(BookReturnMgtRemote bookReturnMgtBean) {
        this.bookReturnMgtBean = bookReturnMgtBean ;
    }
        
    public void handle(Long bookBorrowID) {
        timeoutHandler.handle(bookBorrowID) ;
    }
    
    public Long requestBorrow(String userID, String registrationNumber) {
        
        System.out.println("BookBorrowMainBean::requestBorrow invoked with: " + userID + " for " + registrationNumber) ;
        
        try {
                   
            // 대출신청가능 여부를 확인한다.
            canRequestBorrow(userID, registrationNumber) ;
            
            // 대출신청일(오늘)을 구한다.
            Calendar today  = Calendar.getInstance();
            Date registrationDate = today.getTime() ;
            // 도서대출신청정보 <<JPAEntity>>를 생성한다.
            BookBorrow bookBorrow = new BookBorrow(registrationDate) ;
            
            BookItem bookItem = em.find(BookItem.class, registrationNumber) ;
            LibraryUser user = em.find(LibraryUser.class, userID) ;
            
            // 대출신청 정보를 설정한다.
            bookBorrow.setBorrower(user);
            bookBorrow.setBookItem(bookItem);
            bookItem.setStatus(BookItemStatus.Requested);
            
            // 데이터베이스 저장한다.
            em.persist(bookBorrow);
            em.persist(bookItem) ;
            em.flush();
            
            // 대출예정일 경과에 따른 자동 대출 신청 취소를 위한 타이머를 설정한다.
            Long bookBorrowID = bookBorrow.getId() ;
            timer.setup(bookBorrowID); 
            
            return bookBorrowID ;
        }
        
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
        
    }

    public void persist(Object object) {
        //EntityManager em = getEntityManager() ;
        
        em.persist(object);
    }

    public Collection<BookBorrowInfo> findBookBorrowInfosByUserID(String userID) throws UnknownUserIDException {

        System.out.println("BookBorrowMgtBean::findBookBorrowInfosByUserID invoked with userID: " + userID) ;
        
        Collection<BookBorrowInfo> infos = new ArrayList<BookBorrowInfo>() ;
        
        try {
            String userIDKey  ;
            if ( userID == null || userID.isEmpty() ) {
                userIDKey = "%" ;
            }
            else {
                  
                LibraryUser user = em.find(LibraryUser.class, userID) ;
                if ( user == null ) {
                    throw new UnknownUserIDException(userID) ;
                }
                userIDKey = userID ;
            }
         
            Query query = em.createNamedQuery("FindBookBorrowByUserID").setParameter("id", userIDKey) ;        
            

            List results = query.getResultList() ;
            System.out.println("Query Result: " + results.size()) ;
            
            for ( Iterator it = results.iterator() ; it.hasNext(); ) {
                
                BookBorrow bb = (BookBorrow) it.next() ;

                BookBorrowInfo info = new BookBorrowInfo(bb.getId()) ;

                info.setStatus(bb.getStatus()) ;
                
                info.setRegistrationNumber(bb.getBookItem().getRegistrationNumber());
                
                info.setUserID(bb.getBorrower().getUserID()) ;
                info.setUserName(bb.getBorrower().getName()) ;

                info.setAuthor(bb.getBookItem().getPublication().getAuthorName());
                info.setTitle(bb.getBookItem().getPublication().getTitle());

                info.setBorrowRequestedDate(bb.getBorrowRequestedDate());

                info.setBorrowExpectedDate(getBorrowExpectedDate(bb.getBorrowRequestedDate())) ;

                info.setBorrowCancelledDate(bb.getBorrowCancelledDate());
                info.setIsRequestCancelledBySystem(bb.isIsRequestCancelledBySystem()) ;

                info.setBorrowDate(bb.getBorrowDate());
                
                info.setReturnExpectedDate(bookReturnMgtBean.getReturnExpectedDate(bb.getId())) ;
                
                info.setReturnDate(bb.getReturnDate());
                info.setReturnExtendCount(bb.getReturnExtendNumber());
        
                int returnExtendMax = bb.getBorrower().getReturnExtendMaxNumber() ;
            
                info.setCanExtendReturn(bb.getReturnExtendNumber() < returnExtendMax ) ;
                
                
                int overdueFee = bookReturnMgtBean.getOverdueFee(bb.getId()) ;
                info.setOverDueFee(overdueFee);

                info.setOverDueFeePaid(bb.isOverDueFeePaid()) ;

                //System.out.println(info) ;
                
                infos.add(info);
            }
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
           
        return infos;
    }

    public Date getBorrowExpectedDate(Date borrowRequestedDate) {
        
        if ( borrowRequestedDate == null ) return null ;
        
        Calendar expectedDate = new GregorianCalendar() ;
        expectedDate.setTime(borrowRequestedDate) ;
        expectedDate.add(Calendar.DAY_OF_MONTH, BorrowExpectedDayDelta) ;
            
        return expectedDate.getTime() ;   
    }

    public void cancelBorrowRequest(Long bookBorrowID) throws UnknownBookBorrowIDException {
                
        try {
            BookBorrow bookBorrow = em.find(BookBorrow.class, bookBorrowID) ;
            
            if ( bookBorrow == null ) {
                throw new UnknownBookBorrowIDException(bookBorrowID) ;
            }
            
            em.refresh(bookBorrow) ;
            
            bookBorrow.setStatus(BookBorrowStatus.Cancelled);
            Calendar today  = Calendar.getInstance();
            Date cancelledDate = today.getTime() ;
            bookBorrow.setBorrowCancelledDate(cancelledDate) ;
            
            bookBorrow.getBookItem().setStatus(BookItemStatus.Borrowable) ;
            em.persist(bookBorrow);
            
            em.flush();
            
        }
        catch (Exception e) {
            throw new EJBException(e) ;
        }
        
    }

    public  void borrowBookItem(Long bookBorrowID) throws UnknownBookBorrowIDException {
            
        try {
            // 식별자에 해당되는 도서대출정보를 구한다.
            BookBorrow bookBorrow = em.find(BookBorrow.class, bookBorrowID) ;
            
            if ( bookBorrow == null ) {
                throw new UnknownBookBorrowIDException(bookBorrowID) ;
            }
            
            em.refresh(bookBorrow) ;
            
            // "대출중"으로 상태를 갱신한다.
            bookBorrow.setStatus(BookBorrowStatus.Borrowed);
            
            // 대출일자를 기록한다.
            Calendar today  = Calendar.getInstance();
            Date borrowDate = today.getTime() ;
            bookBorrow.setBorrowDate(borrowDate) ;
            
            // 해당 개별 도서의 상태를 "대출중"으로 갱신한다.
            bookBorrow.getBookItem().setStatus(BookItemStatus.Borrowed) ;
            
            // 도서대출정보를 저장한다.
            // BookItem의 getBookBorrows()
            // @OneToMany(mappedBy="bookItem", cascade={CascadeType.ALL})
            // 이므로 bookBorrow가 persiste하게 되면 BookItem도 함께 persiste하게 된다.
            
            em.persist(bookBorrow);
            em.flush();
        }
        catch (Exception e) {
            throw new EJBException(e) ;
        }
    }

    public boolean canExtendReturnDate(Long bookBorrowID) throws UnknownBookBorrowIDException, TooManyReturnExtensionException {
        
        try {
            BookBorrow bookBorrow = em.find(BookBorrow.class, bookBorrowID) ;
            
            if ( bookBorrow == null ) {
                throw new UnknownBookBorrowIDException(bookBorrowID) ;
            }
            
            em.refresh(bookBorrow);
            
            if ( bookBorrow.getStatus() != BookBorrowStatus.Borrowed )
                return false ;
            
            int currentExtendCount = bookBorrow.getReturnExtendNumber() ;
        
            int returnExtendMax = bookBorrow.getBorrower().getReturnExtendMaxNumber() ;
            
            return currentExtendCount < returnExtendMax  ;
        
        }
        catch (Exception e) {
            throw new EJBException(e) ;
        }
    }
    public void extendReturnDate(Long bookBorrowID) throws UnknownBookBorrowIDException, TooManyReturnExtensionException {
        
        
        try {
            BookBorrow bookBorrow = em.find(BookBorrow.class, bookBorrowID) ;
            
            if ( bookBorrow == null ) {
                throw new UnknownBookBorrowIDException(bookBorrowID) ;
            }
            
            em.refresh(bookBorrow);
            
            if ( bookBorrow.getStatus() != BookBorrowStatus.Borrowed )
                return ;
            
            int currentExtendCount = bookBorrow.getReturnExtendNumber() ;
        
            int returnExtendMax = bookBorrow.getBorrower().getReturnExtendMaxNumber() ;
            
            if ( currentExtendCount >= returnExtendMax ) {
                throw new TooManyReturnExtensionException(currentExtendCount) ;
            }
        
            bookBorrow.setReturnExtendNumber(currentExtendCount+1) ;
            em.persist(bookBorrow);
            em.flush();
            
        }
        catch (Exception e) {
            throw new EJBException(e) ;
        }
        
    }

    public boolean canRequestBorrow(String userID, String registrationNumber)
            throws UnknownUserIDException, UnknownBookItemIDException, UnknownBookBorrowIDException, AlreadyBorrowRequestedBookItemException, TooManyBorrowRequestedException, OverdueFeeNotPaidException {

        // 대출 신청 대상인 개별 단행본을 찾는다.
        BookItem bookItem = em.find(BookItem.class, registrationNumber) ;
        if ( bookItem == null ) {
            throw new UnknownBookItemIDException(registrationNumber) ;
        }

        em.refresh(bookItem);
        
        // 개별 단행본이 대출가능 상태가 아니면 예외를 발생시킨다.
        if ( bookItem.getStatus() != BookItemStatus.Borrowable ) {
            //System.out.println("The requested Book Item is not borrowable, The status is: " + bookItem.getStatus() ) ;
            throw new AlreadyBorrowRequestedBookItemException(bookItem.getPublication().getTitle(), registrationNumber);
        }

        LibraryUser user = em.find(LibraryUser.class, userID) ;
        if ( user == null ) {
            throw new UnknownUserIDException(userID) ;
        }

        em.refresh(user);
        
        // 대출한도를 초과하였는 지를 확인한다.            
        int requestedBookCount = getRequestedBookCountByUserID(userID) ;
        if ( requestedBookCount >= user.getBorrowMaxNumber() ) {
            throw new TooManyBorrowRequestedException( requestedBookCount);
        }

        // 미납된 연체료가 있는 지를 확인한다.
        Collection<BookBorrow> bbs = user.getBookBorrows() ;
        for ( Iterator it = bbs.iterator() ; it.hasNext() ; ) {     
            BookBorrow bb = (BookBorrow) it.next() ;

            int overdueFee = bookReturnMgtBean.getOverdueFee(bb.getId()) ;
            if ( overdueFee > 0 && ! bb.isOverDueFeePaid() )
                throw new OverdueFeeNotPaidException(userID, bb.getId(), overdueFee) ;
        }            
        return true ;
    }

    public int getReturnedBookCountByUserID(String userID) throws UnknownUserIDException  {
        // 대출/반납을 한 건수를 구한다.
        
        LibraryUser user = em.find(LibraryUser.class, userID) ;
        
        if ( user == null ) {
            throw new UnknownUserIDException(userID) ;
        }
        
        em.refresh(user);
        
        int count = 0 ;
        Collection<BookBorrow> bbs = user.getBookBorrows() ;
        
        for ( Iterator it = bbs.iterator() ; it.hasNext() ; ) {     
            BookBorrow bb = (BookBorrow) it.next() ;
            
            System.out.println(bb) ;
            
            if ( bb.getStatus() == BookBorrowStatus.Returned ) count ++ ;
        }
        
        return count ;
    }

    public int getUserCancelledRequestCountByUserID(String userID) throws UnknownUserIDException   {
        // 사용자 스스로 취소한 대출신청 건수를 구한다.
        
        try {
            LibraryUser user = em.find(LibraryUser.class, userID) ;

            if ( user == null ) {
                throw new UnknownUserIDException(userID) ;
            }

            em.refresh(user);
            
            int count = 0 ;
            Collection<BookBorrow> bbs = user.getBookBorrows() ;
            
            for ( Iterator it = bbs.iterator() ; it.hasNext() ; ) {     
                BookBorrow bb = (BookBorrow) it.next() ;

                System.out.println(bb) ;

                if ( bb.getStatus() == BookBorrowStatus.Cancelled ) {

                    if ( ! bb.isIsRequestCancelledBySystem() ) count ++ ;
                }
            }

            return count ;
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
    }

    public int getSystemCancelledRequestCountByUserID(String userID) throws UnknownUserIDException   {
        // 시스템에 의해서 자동으로 취소된 대출신청 건수를 구한다.        
        
        try {
            LibraryUser user = em.find(LibraryUser.class, userID) ;

            if ( user == null ) {
                throw new UnknownUserIDException(userID) ;
            }

            em.refresh(user);
            
            int count = 0 ;
            Collection<BookBorrow> bbs = user.getBookBorrows() ;
            
            for ( Iterator it = bbs.iterator() ; it.hasNext() ; ) {     
                BookBorrow bb = (BookBorrow) it.next() ;

                System.out.println(bb) ;

                if ( bb.getStatus() == BookBorrowStatus.Cancelled ) {

                    if ( bb.isIsRequestCancelledBySystem() ) count ++ ;
                }
            }

            return count ;
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
    }

    public int getOngoingOverduedBookCountByUserID(String userID) throws UnknownUserIDException  {
        
        // 연체된 대출 중인 건수를 구한다. 즉 반납 예정일을 지난 대출을 구한다.
        
        try {
            LibraryUser user = em.find(LibraryUser.class, userID) ;

            if ( user == null ) {
                throw new UnknownUserIDException(userID) ;
            }

            em.refresh(user);
            
            int count = 0 ;
            Collection<BookBorrow> bbs = user.getBookBorrows() ;

            
            Calendar today  = Calendar.getInstance();
            Date todayDate = today.getTime() ;
                    
            for ( Iterator it = bbs.iterator() ; it.hasNext() ; ) {     
                BookBorrow bb = (BookBorrow) it.next() ;

                System.out.println(bb) ;

                if ( bb.getStatus() == BookBorrowStatus.Borrowed ) {

                    Date returnExpectedDate = bookReturnMgtBean.getReturnExpectedDate(bb.getId()) ;        
                    if ( todayDate.after(returnExpectedDate) ) {
                        count ++ ;
                    }
                }
            }

            return count ;
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }

    }
    
    public int getRequestedBookCountByUserID(String userID) throws UnknownUserIDException {
        
        // 대출신청된 도서수를 구한다. 
        // 아래 처럼할 수도 있고 EJB-QL을 이용해서 한번에 구할 수도 있다.
        
        LibraryUser user = em.find(LibraryUser.class, userID) ;
        
        if ( user == null ) {
            throw new UnknownUserIDException(userID) ;
        }
        
        em.refresh(user); 
        
        int count = 0 ;
        Collection<BookBorrow> bbs = user.getBookBorrows() ;
        
        for ( Iterator it = bbs.iterator() ; it.hasNext() ; ) {     
            BookBorrow bb = (BookBorrow) it.next() ;
            
            if ( bb.getStatus() == BookBorrowStatus.Requested ) count ++ ;
        }
        return count ;
    }
    
    public int getBorrowedBookCountByUserID(String userID) throws UnknownUserIDException {
        
        //EntityManager em = getEntityManager() ;
        
        LibraryUser user = em.find(LibraryUser.class, userID) ;
        
        if ( user == null ) {
            throw new UnknownUserIDException(userID) ;
        }
        
        em.refresh(user);
        
        int count = 0 ;
        Collection<BookBorrow> bbs = user.getBookBorrows() ;
        
        for ( Iterator it = bbs.iterator() ; it.hasNext() ; ) {     
            BookBorrow bb = (BookBorrow) it.next() ;
            
            System.out.println(bb) ;
            
            if ( bb.getStatus() == BookBorrowStatus.Borrowed ) count ++ ;
        }
        
        return count ;
    }



    public void borrowBookItem(String userID, String registrationNumber) throws UnknownUserIDException, UnknownBookIDException, UnknownBookBorrowIDException, NotBorrowRequestedBookException  {
        
        // userID 사용자의 registrationNumber 도서에 대한 대출을 기록한다.
        
        System.out.println("BookBorrowMainBean::borrowBookItem invoked with: " + userID + " for " + registrationNumber) ;
        
        
        // 대출을 하고자 하는 도서관 사용자를 구한다.
        LibraryUser user = em.find(LibraryUser.class, userID) ;
        if ( user == null ) {
            throw new UnknownUserIDException(userID) ;
        }
        
        em.refresh(user) ;
        
        // 대출 대상 개별 도서를 구한다.
        BookItem bi = em.find(BookItem.class, registrationNumber) ;
        if ( bi == null ) {
            throw new UnknownBookIDException(registrationNumber) ;
        }
        
        em.refresh(bi) ;
        
        // 사용자와 관련된 모든 도서 대출 정보를 구한다.
        Collection<BookBorrow> bbs = user.getBookBorrows() ;
        System.out.println("List of book borrows for user: " + userID) ;
        for ( Iterator it = bbs.iterator() ; it.hasNext() ; ) {     
            BookBorrow bb = (BookBorrow) it.next() ;
            
            System.out.println("\tTitle:  " + bb.getBookItem().getPublication().getTitle()) ;
            System.out.println("\tRequested Date: " + bb.getBorrowRequestedDate()) ;
            System.out.println("\tStatus: " + bb.getStatus()) ;
            
            // 대출신청 중인 도서 대출 정보 중에서
            if ( bb.getStatus() == BookBorrowStatus.Requested ) {
                
                // 대출 대상인 개별 도서가 발견되면 도서대출정보(BookBorrow)의 식별자를 구한다.
                // 이 식별자를 이용해서 borrowBookItem()을 호출한다.
                if ( bb.getBookItem().getRegistrationNumber().equals(registrationNumber) ) {
                    borrowBookItem(bb.getId()) ;
                    return ;
                }
            }
        }
        // 대출을 하려는 도서가 발견되지 않았다. 즉 대출 신청하지 않은 도서를
        // 대출하려고 하고 있다.
        throw  new NotBorrowRequestedBookException(userID, registrationNumber) ;

    }
 
}
