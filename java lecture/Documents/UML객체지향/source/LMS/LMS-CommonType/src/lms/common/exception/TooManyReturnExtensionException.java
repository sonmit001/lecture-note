/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class TooManyReturnExtensionException extends Exception {
    private int currentCount ;
    
    public TooManyReturnExtensionException(int currentCount) {
        this.currentCount = currentCount ;
    }

    @Override
    public String toString() {
        return "Too Many Borrow Extension: Current extension count : " + currentCount ;
    }

}
