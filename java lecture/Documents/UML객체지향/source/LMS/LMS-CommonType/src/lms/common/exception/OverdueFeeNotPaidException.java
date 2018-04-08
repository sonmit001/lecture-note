/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class OverdueFeeNotPaidException  extends Exception {
    private String userID ;
    private Long bookBorrowID ;
    private int fee ;
    
    public OverdueFeeNotPaidException(String userID, Long bookBorrowID, int fee) {
        this.userID = userID ;
        this.bookBorrowID = bookBorrowID ;
        this.fee = fee ;
    }

    @Override
    public String toString() {
        return "UserID: " + userID + " Overdue Fee Not PaidD: " + fee + " about bookBorrowID: " + bookBorrowID ;
    }
}
