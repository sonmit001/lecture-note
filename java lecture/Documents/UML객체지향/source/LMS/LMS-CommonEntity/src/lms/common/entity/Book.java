/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lms.common.type.PublicationType;


/**
 *
 * @author chae
 */
@Entity
@NamedQueries(
    {
        @NamedQuery(name="FindBookByBookItemID",
            query="SELECT DISTINCT b " +
            "FROM Book b, IN (b.items)  bi " + 
            "WHERE bi.registrationNumber = :id")
    }
)
public class Book extends Publication implements Serializable {
    private static final long serialVersionUID = 1L;

    
    public Book() {super() ; this.setType(PublicationType.Book);}
    
    public int getPage() {
        return page;
    }

    @Override
    public String toString() {
        return "lms.common.entity.Book: " + super.toString() ;
    }

    public void setPage(int page) {
        this.page = page;
    }
    
    private int page ;
    
    private Collection<LibraryUser> waiters = new ArrayList<LibraryUser> () ;
    @ManyToMany
    @JoinTable(name="BOOK_LIBRARYUSER")
    public Collection<LibraryUser> getWaiters() {
        return waiters;
    }
    public void setWaiters(Collection<LibraryUser> waiters) {
        this.waiters = waiters;
    }
    
}
