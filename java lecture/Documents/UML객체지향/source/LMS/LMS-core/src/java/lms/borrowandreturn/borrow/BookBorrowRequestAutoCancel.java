/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.borrowandreturn.borrow;

import javax.ejb.Remote;
import lms.externalsystem.smssystem.SMSSIRemote;

/**
 *
 * @author chae
 */
@Remote
public interface BookBorrowRequestAutoCancel {

    void handle(Long bookBorrowID);
    
    void setSMSSIBean(SMSSIRemote smsSMBean) ;
    
}
