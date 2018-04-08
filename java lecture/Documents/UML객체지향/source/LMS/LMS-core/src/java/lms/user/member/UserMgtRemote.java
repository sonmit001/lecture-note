/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.user.member;

import java.util.Collection;
import javax.ejb.Remote;
import lms.common.entity.LibraryUser;
import lms.common.exception.IncorrectUserPasswordException;
import lms.common.exception.MultipleUserIDException;
import lms.common.exception.UnknownUserIDException;
import lms.common.type.UserInfo;
import lms.common.type.UserType;

/**
 *
 * @author chae
 */
@Remote
public interface UserMgtRemote {

    void registerUser(UserType type, String id, String password, String name);
    
    public Collection<UserInfo> findUserInfosByNameAndID(String name, String id) ;

    void removeUser(String userID) throws UnknownUserIDException ;

    boolean login(String userID, String password) throws UnknownUserIDException, MultipleUserIDException, IncorrectUserPasswordException;

    boolean CheckUserID(String userID) throws UnknownUserIDException  ;

    boolean exceedBorrowMaxCount(String userID) throws UnknownUserIDException ;

    boolean checkNotPaidOverdueFee(String userID) throws UnknownUserIDException ;

    UserInfo getUserInfo(String userID) throws UnknownUserIDException ;

    void updatePassword(String userID, String password) throws UnknownUserIDException ;

    void updateEmail(String userID, String email) throws UnknownUserIDException ;
    
    void updateName(String userID, String name) throws UnknownUserIDException ;

    void updatePhoneNumber(String userID, String phoneNumber) throws UnknownUserIDException ;

    String getPhoneNumber(String userID) throws UnknownUserIDException;

    void registerUser(UserInfo userInfo);
    
}
