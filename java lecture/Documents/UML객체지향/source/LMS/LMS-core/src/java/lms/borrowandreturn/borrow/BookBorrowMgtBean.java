/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.borrowandreturn.borrow;

import java.util.Collection;
import java.util.Date;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import lms.borrowandreturn.Return.BookReturnMgtRemote;
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
import lms.externalsystem.smssystem.SMSSIRemote;


/**
 *
 * @author chae
 */
@Stateless
public class BookBorrowMgtBean implements BookBorrowMgtRemote {
   
    private BookBorrowMain mgr ;
    private BookBorrowTimer borrowTimer ;
    private BookBorrowRequestAutoCancel autoCancelHandler ;
    
    private BookReturnMgtRemote bookReturnMgtBean ;
    private SMSSIRemote sMSSIBean ;
         

    public BookBorrowMgtBean() {
        // creating parts
        
        
        try {
            Context ctx = new InitialContext() ;
            borrowTimer = (BookBorrowTimer)
                ctx.lookup("lms.borrowandreturn.borrow.BookBorrowTimer") ;
        
            autoCancelHandler = (BookBorrowRequestAutoCancel)
                ctx.lookup("lms.borrowandreturn.borrow.BookBorrowRequestAutoCancel") ;
            
            mgr = (BookBorrowMain)
                ctx.lookup("lms.borrowandreturn.borrow.BookBorrowMain") ;
            
            bookReturnMgtBean = (BookReturnMgtRemote)
                ctx.lookup("lms.borrowandreturn.Return.BookReturnMgtRemote") ;
            
            sMSSIBean = (SMSSIRemote)
                ctx.lookup("lms.externalsystem.smssystem.SMSSIRemote") ;
            
        }
        catch ( Exception e) {
            throw new EJBException(e) ;
        }
        
        
         // connector between mgr and borrowTimer
         mgr.setBookBorrowTimer(borrowTimer); 
         borrowTimer.setTimeoutHandler(mgr);
         
         // connector from mgr to autoCancelHandler
         mgr.setBookBorrowRequestAutoCancel(autoCancelHandler);
         
         // connector from mgr to bookReturnMgtBean
         mgr.setBookReturnMgtBean(bookReturnMgtBean);
         
         autoCancelHandler.setSMSSIBean(sMSSIBean);
         
    }

    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
     public boolean canRequestBorrow(String userID, String registrationNumber) throws UnknownUserIDException, UnknownBookItemIDException, UnknownBookBorrowIDException, AlreadyBorrowRequestedBookItemException, TooManyBorrowRequestedException, OverdueFeeNotPaidException {
         
         return mgr.canRequestBorrow(userID, registrationNumber);
     }
    public Long requestBorrow(String userID, String registrationNumber)
            throws UnknownUserIDException, UnknownBookIDException, TooManyBorrowRequestedException, AlreadyBorrowRequestedBookItemException {
        
        return mgr.requestBorrow(userID, registrationNumber) ;
         
    }
    
    public Date getBorrowExpectedDate(Date borrowRequestedDate) {
         
         return mgr.getBorrowExpectedDate(borrowRequestedDate) ;
    }
    
    public void cancelBorrowRequest(Long bookBorrowID) throws UnknownBookBorrowIDException {
         
         mgr.cancelBorrowRequest(bookBorrowID);
    }
    
    public void borrowBookItem(String userID, String registrationNumber) throws UnknownUserIDException, UnknownBookIDException, UnknownBookBorrowIDException, NotBorrowRequestedBookException  {
        mgr.borrowBookItem(userID, registrationNumber);
    }

    public void borrowBookItem(Long bookBorrowID) throws UnknownBookBorrowIDException {
        mgr.borrowBookItem(bookBorrowID);
    }
    
    public boolean canExtendReturnDate(Long bookBorrowID) throws UnknownBookBorrowIDException, TooManyReturnExtensionException {
         
         return mgr.canExtendReturnDate(bookBorrowID); 
    }
    
    public void extendReturnDate(Long bookBorrowID) throws UnknownBookBorrowIDException, TooManyReturnExtensionException {
         
         mgr.extendReturnDate(bookBorrowID);
    }    
    
    public Collection<BookBorrowInfo> findBookBorrowInfosByUserID(String userID) throws UnknownUserIDException {
        
         return mgr.findBookBorrowInfosByUserID(userID) ;
    }
    
    public int getReturnedBookCountByUserID(String userID) throws UnknownUserIDException  {
        return mgr.getReturnedBookCountByUserID(userID) ;
    }

    public int getUserCancelledRequestCountByUserID(String userID) throws UnknownUserIDException  {
        return mgr.getUserCancelledRequestCountByUserID(userID) ;
    }

    public int getSystemCancelledRequestCountByUserID(String userID) throws UnknownUserIDException  {
        return mgr.getSystemCancelledRequestCountByUserID(userID) ;
    }

    public int getOngoingOverduedBookCountByUserID(String userID) throws UnknownUserIDException   {
        return mgr.getOngoingOverduedBookCountByUserID(userID) ;
    }
    
    public int getRequestedBookCountByUserID(String userID) throws UnknownUserIDException {
        return mgr.getRequestedBookCountByUserID(userID) ;
    }
    
    public int getBorrowedBookCountByUserID(String userID) throws UnknownUserIDException {
        return mgr.getBorrowedBookCountByUserID(userID) ;
    }
    
}
