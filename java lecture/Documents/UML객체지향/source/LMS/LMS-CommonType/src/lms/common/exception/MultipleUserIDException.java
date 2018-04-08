/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class MultipleUserIDException extends Exception {
    private String id ;
    
    public MultipleUserIDException(String id) {
        this.id = id ;
    }

    @Override
    public String toString() {
        return "Multiple User ID: " + id ;
    }

}
