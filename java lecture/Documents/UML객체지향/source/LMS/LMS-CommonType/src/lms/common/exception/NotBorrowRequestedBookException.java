/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class NotBorrowRequestedBookException extends Exception {
    private String userID  ;
    private String registrationNumber  ;
    
    public NotBorrowRequestedBookException(String userID, String registrationNumber) {
        this.userID = userID ;
        this.registrationNumber = registrationNumber ;
    }

    @Override
    public String toString() {
        return "User: " + userID + " has not requested the borrow of the book:  " + registrationNumber ;
    }

}
