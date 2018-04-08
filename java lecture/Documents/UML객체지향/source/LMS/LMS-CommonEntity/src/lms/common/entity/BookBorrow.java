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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import lms.common.type.BookBorrowStatus;

/**
 *
 * @author chae
 */
@Entity
@NamedQueries(
    {
        @NamedQuery(name="FindBookBorrowByUserID",
            query="SELECT bb FROM BookBorrow bb WHERE bb.borrower.userID LIKE :id")
    }
)
public class BookBorrow implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private BookBorrowStatus status ;
    private Date borrowRequestedDate ;
    private Date borrowCancelledDate ;
    private boolean isRequestCancelledBySystem = false ;
    private Date borrowDate ;
    private Date returnDate ;
    
    private int returnExtendNumber  ;
    private boolean overDueFeePaid ;    

    public BookBorrow() {}
    public BookBorrow(Date requestedDate ) {        
        this.status = BookBorrowStatus.Requested ;
        this.borrowRequestedDate = requestedDate ;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {  return id; }
    public void setId(Long id) { this.id = id; }
    
    @Column(nullable=false)
    public BookBorrowStatus getStatus() { return status; }
    public void setStatus(BookBorrowStatus status) { this.status = status; }
    
    private BookItem bookItem ;
    @ManyToOne
    public BookItem getBookItem() { return bookItem; }
    public void setBookItem(BookItem bookItem) { this.bookItem = bookItem; }

    private LibraryUser borrower ;
    @ManyToOne
    public LibraryUser getBorrower() { return borrower; }

    public void setBorrower(LibraryUser borrower) { this.borrower = borrower; }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getBorrowCancelledDate() {
        return borrowCancelledDate;
    }
    public void setBorrowCancelledDate(Date borrowCancelledDate) {
        this.borrowCancelledDate = borrowCancelledDate;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getBorrowRequestedDate() {
        return borrowRequestedDate;
    }
    public void setBorrowRequestedDate(Date borrowRequestedDate) {
        this.borrowRequestedDate = borrowRequestedDate;
    }

    public boolean isIsRequestCancelledBySystem() {
        return isRequestCancelledBySystem;
    }
    public void setIsRequestCancelledBySystem(boolean isRequestCancelledBySystem) {
        this.isRequestCancelledBySystem = isRequestCancelledBySystem;
    }

    public boolean isOverDueFeePaid() {
        return overDueFeePaid;
    }
    public void setOverDueFeePaid(boolean overDueFeePaid) {
        this.overDueFeePaid = overDueFeePaid;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getReturnExtendNumber() {
        return returnExtendNumber;
    }
    public void setReturnExtendNumber(int returnExtendNumber) {
        this.returnExtendNumber = returnExtendNumber;
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
        if (!(object instanceof BookBorrow)) {
            return false;
        }
        BookBorrow other = (BookBorrow) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lms.common.entity.BookBorrow[id=" + id + "]" ;
    }    
}
