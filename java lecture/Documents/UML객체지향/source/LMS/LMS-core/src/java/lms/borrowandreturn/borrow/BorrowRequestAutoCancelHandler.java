/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.borrowandreturn.borrow;

/**
 *
 * @author chae
 */
public class BorrowRequestAutoCancelHandler implements BorrowRequestTimeoutHandler {
    public void handle() {
        System.out.println("BorrowRequestAutoCancelHandler: ") ;
    }
}
