/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import lms.common.type.BookOrderStatus;

/**
 *
 * @author chae
 */
@Entity
public class BookOrder implements Serializable {
    private LibraryUser libraryUser;
    private static final long serialVersionUID = 1L;
    private Long id;
    
    private Date requestDate ;
    private Date requestCancelDate ;
    private Date orderDate ;
    private Date orderCancelDate ;
    private Date bookArrivalDate ;
    private BookOrderStatus orderStatus = BookOrderStatus.Requested ;
    
    
    private Publication publication ;
    
    @ManyToOne
    public Publication getPublication() { return publication ; }
    public void setPublication(Publication publication) { this.publication = publication ; }

    @Column(nullable=false)
    public BookOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(BookOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getBookArrivalDate() {
        return bookArrivalDate;
    }

    public void setBookArrivalDate(Date bookArrivalDate) {
        this.bookArrivalDate = bookArrivalDate;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getOrderCancelDate() {
        return orderCancelDate;
    }

    public void setOrderCancelDate(Date orderCancelDate) {
        this.orderCancelDate = orderCancelDate;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getRequestCancelDate() {
        return requestCancelDate;
    }

    public void setRequestCancelDate(Date requestCancelDate) {
        this.requestCancelDate = requestCancelDate;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    
    private String bookOrderID ;

    public String getBookOrderID() {
        return bookOrderID;
    }

    public void setBookOrderID(String bookOrderID) {
        this.bookOrderID = bookOrderID;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookOrder)) {
            return false;
        }
        BookOrder other = (BookOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lms.common.entity.BookOrder[id=" + id + "]";
    }

    @ManyToOne
   
    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    public void setLibraryUser(LibraryUser libraryUser) {
        this.libraryUser = libraryUser;
    }
}
