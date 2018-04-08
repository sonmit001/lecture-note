/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.borrowandreturn.borrow;


import java.util.Collection;
import java.util.Date;
import javax.ejb.Remote;
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

/**
 *
 * @author chae
 */
@Remote
public interface BookBorrowMain {
 
    boolean canRequestBorrow(String userID, String registrationNumber) throws UnknownUserIDException, UnknownBookItemIDException, UnknownBookBorrowIDException, AlreadyBorrowRequestedBookItemException, TooManyBorrowRequestedException, OverdueFeeNotPaidException ;
    Long requestBorrow(String userID, String registrationNumber) ;
    Date getBorrowExpectedDate(Date borrowRequestedDate);
    
    void cancelBorrowRequest(Long bookBorrowID) throws UnknownBookBorrowIDException ;
    void borrowBookItem(Long bookBorrowID) throws UnknownBookBorrowIDException;
    
    boolean canExtendReturnDate(Long bookBorrowID) throws UnknownBookBorrowIDException, TooManyReturnExtensionException ;
    void extendReturnDate(Long bookBorrowID) throws UnknownBookBorrowIDException, TooManyReturnExtensionException ;   
    
    Collection<BookBorrowInfo> findBookBorrowInfosByUserID(String userID) throws UnknownUserIDException;
    
    int getReturnedBookCountByUserID(String userID) throws UnknownUserIDException  ;

    int getUserCancelledRequestCountByUserID(String userID) throws UnknownUserIDException  ;

    int getSystemCancelledRequestCountByUserID(String userID) throws UnknownUserIDException  ;

    int getOngoingOverduedBookCountByUserID(String userID) throws UnknownUserIDException   ;
    
    int getRequestedBookCountByUserID(String userID) throws UnknownUserIDException ;
    
    int getBorrowedBookCountByUserID(String userID) throws UnknownUserIDException ;
    
    void handle(Long bookBorrowID) ;
    void setBookBorrowTimer(BookBorrowTimer timer) ;
    void setBookBorrowRequestAutoCancel(BookBorrowRequestAutoCancel handler) ;

    void setBookReturnMgtBean(BookReturnMgtRemote bookReturnMgtBean);

    void borrowBookItem(String userID, String registrationNumber) throws UnknownUserIDException, UnknownBookIDException, UnknownBookBorrowIDException, NotBorrowRequestedBookException ;
    
}
