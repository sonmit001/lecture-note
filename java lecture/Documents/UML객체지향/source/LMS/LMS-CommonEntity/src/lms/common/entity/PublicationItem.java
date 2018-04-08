/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author chae
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries(
    {
        @NamedQuery(name="RemovePublicationItemByID",
            query="DELETE FROM PublicationItem pi WHERE pi.registrationNumber = :id"),
        @NamedQuery(name="GetPublicationItemByID",
            query="SELECT pi FROM PublicationItem pi WHERE pi.registrationNumber = :id")
            
    }
)        
public  abstract class PublicationItem implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String location ;
    private Date registrationDate ;
    private Date unregistrationDate ;
    private String registrationNumber ;

    public PublicationItem() { }
    
    public PublicationItem(Publication publication, String registrationNumber, String location, Date registrationDate) {
        this.publication = publication ;
        this.location = location;
        this.registrationDate = registrationDate;
        this.registrationNumber = registrationNumber;
    }
    
    @Id
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    
    private Publication publication ;
    
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="TYPE", referencedColumnName="TYPE"),
        @JoinColumn(name="PUBLICATIONNUMBER", referencedColumnName="PUBLICATIONNUMBER")
        }
    )
    public Publication getPublication() { return publication ; }
    public void setPublication(Publication publication) { this.publication = publication ; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable=false)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getUnregistrationDate() {
        return unregistrationDate;
    }

    public void setUnregistrationDate(Date unregistrationDate) {
        this.unregistrationDate = unregistrationDate;
    }

    @Override
    public String toString() {
        return "lms.common.entity.PublicationItem[id=" + registrationNumber + "] : of " + getPublication() ;
    }

}
