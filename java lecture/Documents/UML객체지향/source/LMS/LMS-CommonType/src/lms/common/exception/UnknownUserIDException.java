/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class UnknownUserIDException extends Exception {
    private String id ;
    
    public UnknownUserIDException(String id) {
        this.id = id ;
    }

    @Override
    public String toString() {
        return "Unknown User ID: " + id ;
    }
    

}
