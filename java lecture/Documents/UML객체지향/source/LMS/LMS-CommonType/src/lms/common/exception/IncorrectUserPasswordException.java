/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.exception;

/**
 *
 * @author chae
 */
public class IncorrectUserPasswordException extends Exception {
    private String id ;
    private String password ;
    
    public IncorrectUserPasswordException(String id, String password) {
        this.id = id ;
        this.password = password ;
    }

    @Override
    public String toString() {
        return "Incorrect Password " + password + " for User " + id ;
    }

}
