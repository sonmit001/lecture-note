/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.borrowandreturn.borrow;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import lms.common.entity.LibraryUser;

/**
 *
 * @author chae
 */
@Stateless
public class BookBorrowTimerBean implements BookBorrowTimer {

    @Resource private SessionContext ctx ;
    
    private BookBorrowMain handler ;
    private Long bookBorrowID ;
    
    public void setTimeoutHandler(BookBorrowMain handler) {
        this.handler = handler ;
    }
    
    public void setup(Long bookBorrowID) {
        this.bookBorrowID = bookBorrowID ;
        TimerService timerService = ctx.getTimerService() ;
        
        int day = LibraryUser.ExpectedBorrowDay ;
        
        // 1/1000 초 단위로 지정한다.
        long start = 1000 * day * 24 * 60 * 60 ;
        //long start = 3000 ; // 3초후에 자동 취소됨
        Timer timer = timerService.createTimer(start, bookBorrowID) ;
    }
    
    @Timeout
    public void handleTimeout(Timer timer) {
        System.out.println("Timeout occurred.") ;
        handler.handle(bookBorrowID) ;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
