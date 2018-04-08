/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class TooManyBorrowRequestedException extends Exception {
    private int currentCount ;
    
    public TooManyBorrowRequestedException(int currentCount) {
        this.currentCount = currentCount ;
    }
    @Override
    public String toString() {
        return "Too Many Borrow Requested: Current book count " + currentCount ;
    }
}
