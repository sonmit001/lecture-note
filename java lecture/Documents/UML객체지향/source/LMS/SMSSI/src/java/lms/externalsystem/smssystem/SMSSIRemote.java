/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.externalsystem.smssystem;

import javax.ejb.Remote;

/**
 *
 * @author chae
 */
@Remote
public interface SMSSIRemote {

    void requestMessage(String phoneNumber, String msg);
    
}
