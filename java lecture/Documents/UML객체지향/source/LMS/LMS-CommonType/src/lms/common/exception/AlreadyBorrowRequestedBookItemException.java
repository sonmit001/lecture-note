/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class AlreadyBorrowRequestedBookItemException extends Exception {
    private String title ;
    private String registrationNumber  ;
    
    public AlreadyBorrowRequestedBookItemException(String title, String registrationNumber) {
        this.title = title ;
        this.registrationNumber = registrationNumber ;
    }

    @Override
    public String toString() {
        return "Already Borrow Requested: " + title + ":  " + registrationNumber ;
    }
}
