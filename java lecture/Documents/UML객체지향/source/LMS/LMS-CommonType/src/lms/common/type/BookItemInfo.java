/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.type;

import java.util.Date;

/**
 *
 * @author chae
 */
public class BookItemInfo extends PublicationItemInfo {
    private BookItemStatus status ;

    public BookItemInfo(String registrationNumber, String location, Date registrationDate) {
        super(registrationNumber, location, registrationDate) ;
        this.status = BookItemStatus.Borrowable ;
    }
    
    public BookItemInfo(String registrationNumber, String location, Date registrationDate, Date unregistrationDate, BookItemStatus status) {
        super(registrationNumber, location, registrationDate) ;
        this.setUnregistrationDate(unregistrationDate);
        this.status = status ;
    }
    
    public BookItemStatus getStatus() {
        return status;
    }

    public void setStatus(BookItemStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + "Status: " + status ;
    }
    
    
}
