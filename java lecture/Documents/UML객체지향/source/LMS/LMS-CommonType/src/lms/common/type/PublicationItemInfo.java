/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.type;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author chae
 */
public abstract class PublicationItemInfo implements Serializable {
    
    private String registrationNumber ;
    private String location ;
    private Date registrationDate ;
    private Date unregistrationDate ;

    PublicationItemInfo() {}
    
    public PublicationItemInfo(String registrationNumber, String location, Date registrationDate) {
        this.registrationNumber = registrationNumber;
        this.location = location;
        this.registrationDate = registrationDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getUnregistrationDate() {
        return unregistrationDate;
    }

    public void setUnregistrationDate(Date unregistrationDate) {
        this.unregistrationDate = unregistrationDate;
    }

    @Override
    public String toString() {
        return "ID: " + registrationNumber + " location: " + location + " registrationDate: " + registrationDate + " unregistrationDate: " + unregistrationDate ;
    }

    

}
