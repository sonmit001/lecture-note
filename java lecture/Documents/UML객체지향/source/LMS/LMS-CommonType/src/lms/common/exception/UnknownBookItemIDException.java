/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class UnknownBookItemIDException extends Exception {
    private String id ;
    
    public UnknownBookItemIDException(String id) {
        this.id = id ;
    }

    @Override
    public String toString() {
        return "Unknown Book Item ID: " + id ;
    }

}
