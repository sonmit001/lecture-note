/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.borrowandreturn.borrow;

import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lms.common.entity.BookBorrow;
import lms.common.exception.UnknownBookBorrowIDException;
import lms.common.type.BookBorrowStatus;
import lms.common.type.BookItemStatus;
import lms.externalsystem.smssystem.SMSSIRemote;

/**
 *
 * @author chae
 */
@Stateless
public class BookBorrowRequestAutoCancelBean implements BookBorrowRequestAutoCancel {
    
    @PersistenceContext(unitName="LMS-corePU")
    private EntityManager em;
    
    private SMSSIRemote sMSSIBean;
    
    public void setSMSSIBean(SMSSIRemote smsSMBean) {
        this.sMSSIBean = smsSMBean ;
    }

    public void handle(Long bookBorrowID) {
        System.out.println("BorrowRequestAutoCancelHandler:handled invoked with bookborrow ID " + bookBorrowID) ;
        
        try {
            // 대출예정일이 경과되었으므로 대출 신청을 자동으로 취소시킨다.
            cancelExpiredBorrowRequest(bookBorrowID);
            
            // 자동취소 되었음을 메시지로 전송한다.
            notifyCancelledBorrowRequest(bookBorrowID) ;
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
    }
    
    private void notifyCancelledBorrowRequest(Long bookBorrowID) throws UnknownBookBorrowIDException {
        System.out.println("BorrowRequestAutoCancelHandler::notifyCancelledBorrowRequest invoked with bookborrow ID " + bookBorrowID) ;
        
        try {
            BookBorrow bookBorrow = em.find(BookBorrow.class, bookBorrowID) ;
            
            if ( bookBorrow == null ) {
                throw new UnknownBookBorrowIDException(bookBorrowID) ;
            }
            
            String phoneNumber = bookBorrow.getBorrower().getPhoneNumber() ;
            String title = bookBorrow.getBookItem().getPublication().getTitle() ;
            String author = bookBorrow.getBookItem().getPublication().getAuthorName() ;
            
            String msg = "저자: " + author + " 의 도서: " + title + " 의 대출 기한이 경과하여 대출 신청이 자동으로 취소 되었읍니다. " ;
            sMSSIBean.requestMessage(phoneNumber, msg);
        }
        catch (Exception e) {
            throw new EJBException(e) ;
        }    
    }
    private void cancelExpiredBorrowRequest(Long bookBorrowID) throws UnknownBookBorrowIDException {
        
        System.out.println("BorrowRequestAutoCancelHandler::cancelExpiredBorrowRequest invoked with bookborrow ID " + bookBorrowID) ;
        
        try {
            BookBorrow bookBorrow = em.find(BookBorrow.class, bookBorrowID) ;
            
            if ( bookBorrow == null ) {
                throw new UnknownBookBorrowIDException(bookBorrowID) ;
            }
            bookBorrow.setStatus(BookBorrowStatus.Cancelled);
            bookBorrow.setIsRequestCancelledBySystem(true) ;
            
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

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
