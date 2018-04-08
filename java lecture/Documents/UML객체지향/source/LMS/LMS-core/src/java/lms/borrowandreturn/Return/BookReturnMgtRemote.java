/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.borrowandreturn.Return;

import java.util.Date;
import javax.ejb.Remote;
import lms.common.exception.UnknownBookBorrowIDException;
import lms.common.exception.UnknownBookIDException;

/**
 *
 * @author chae
 */
@Remote
public interface BookReturnMgtRemote {

    void returnBookItem(String registrationNumber) throws UnknownBookIDException, UnknownBookBorrowIDException ;
    Date getReturnExpectedDate(Long bookBorrowID ) throws UnknownBookBorrowIDException ;
    int getOverdueFee(Long bookBorrowID) throws UnknownBookBorrowIDException ;
    void payOverdueFee(Long bookBorrowID) throws UnknownBookBorrowIDException ;
}
