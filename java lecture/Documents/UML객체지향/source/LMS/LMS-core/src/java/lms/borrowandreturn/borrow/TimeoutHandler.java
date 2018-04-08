/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.borrowandreturn.borrow;

import javax.ejb.Remote;

/**
 *
 * @author chae
 */
@Remote
public interface  TimeoutHandler {    
    void handle(Long bookBorrowID) ;
    
    void setTimerSetup(BookBorrowTimer timer) ;
    void setBorrowRequestTimeoutHandler(BookBorrowRequestAutoCancel handler) ;
}
