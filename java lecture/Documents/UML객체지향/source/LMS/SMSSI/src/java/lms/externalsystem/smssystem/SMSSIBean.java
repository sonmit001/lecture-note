/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.externalsystem.smssystem;

import javax.ejb.Stateless;

/**
 *
 * @author chae
 */
@Stateless
public class SMSSIBean implements SMSSIRemote {

    public void requestMessage(String phoneNumber, String msg) {
        System.out.println("SMSSIBean::requestMessage() invoked with phoneNumber: " + phoneNumber + " and message: " + msg) ;
        
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
