/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class UnknownBookBorrowIDException extends Exception {
    private Long id ;
    
    public UnknownBookBorrowIDException(Long id) {
        this.id = id ;
    }

    @Override
    public String toString() {
        return "Unknown Book Borrow ID: " + id ;
    }

}
