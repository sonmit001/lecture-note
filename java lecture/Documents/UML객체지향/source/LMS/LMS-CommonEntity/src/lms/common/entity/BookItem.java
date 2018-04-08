/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lms.common.type.BookItemStatus;

/**
 *
 * @author chae
 */
@Entity
public class BookItem extends PublicationItem implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public BookItem() { status = BookItemStatus.Borrowable ; }
    public BookItem(Publication publication, String registrationNumber, String location, Date registrationDate) {
        super(publication, registrationNumber, location, registrationDate) ;
        status = BookItemStatus.Borrowable ;
    }
    
    private BookItemStatus status ;
    @Column(nullable=false)
    public BookItemStatus getStatus() { return status; }
    public void setStatus(BookItemStatus status) { this.status = status; }
    
    private Collection<BookBorrow> bookBorrows ;  
   @OneToMany(mappedBy="bookItem", cascade={CascadeType.ALL})
    public Collection<BookBorrow> getBookBorrows() {
        return bookBorrows;
    }
    public void setBookBorrows(Collection<BookBorrow> bookBorrows) {
        this.bookBorrows = bookBorrows;
    }
    
    @Override
    public String toString() {
        return "lms.common.entity.BookItem: " + super.toString() + " status: " + status ;
    }
}
