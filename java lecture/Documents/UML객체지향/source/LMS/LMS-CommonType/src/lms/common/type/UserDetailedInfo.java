/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.type;

/**
 *
 * @author chae
 */
public class UserDetailedInfo extends UserInfo {
    
    private int borrowRequestedBookCount ;
    private int borrowedBookCount ;
    private int overduedBookCount ;

    public UserDetailedInfo() {}
    
    public UserDetailedInfo(UserType userType, String id, String name) {
        super(userType, id, name) ;   
    }
            
    public int getBorrowRequestedBookCount() {
        return borrowRequestedBookCount;
    }

    public void setBorrowRequestedBookCount(int borrowRequestedBookCount) {
        this.borrowRequestedBookCount = borrowRequestedBookCount;
    }

    public int getBorrowedBookCount() {
        return borrowedBookCount;
    }

    public void setBorrowedBookCount(int borrowedBookCount) {
        this.borrowedBookCount = borrowedBookCount;
    }

    public int getOverduedBookCount() {
        return overduedBookCount;
    }

    public void setOverduedBookCount(int overduedBookCount) {
        this.overduedBookCount = overduedBookCount;
    }
}
