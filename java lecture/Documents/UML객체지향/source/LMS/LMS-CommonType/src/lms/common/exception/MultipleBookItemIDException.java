/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class MultipleBookItemIDException extends Exception {
    private String id ;
    
    public MultipleBookItemIDException(String id) {
        this.id = id ;
    }

    @Override
    public String toString() {
        return "Multiple Book Item ID: " + id ;
    }

}
