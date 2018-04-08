/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class UnknownBookIDException extends Exception {
    private String id ;
    
    public UnknownBookIDException(String id) {
        this.id = id ;
    }

    @Override
    public String toString() {
        return "Unknown Book ID: " + id ;
    }
}
