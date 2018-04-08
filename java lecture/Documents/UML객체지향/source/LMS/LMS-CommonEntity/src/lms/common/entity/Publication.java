/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

import lms.common.type.PublicationType;

/**
 *
 * @author chae
 */


@IdClass(lms.common.entity.PublicationKey.class)

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries(
    {
        @NamedQuery(name="findPublicationKeysByTitle",
            query="SELECT p.type, p.publicationNumber FROM Publication p WHERE p.title LIKE :title"),
        @NamedQuery(name="findPublicationInfosByTitle",
            query="SELECT p.type, p.authorName, p.title, p.publicationNumber, p.publisherName, p.publicationDate  FROM Publication p WHERE p.title LIKE :title"),
        @NamedQuery(name="findPublicationInfoByKey",
            query="SELECT p.type, p.authorName, p.title, p.publicationNumber, p.publisherName, p.publicationDate FROM Publication p WHERE p.type = :type and p.publicationNumber = :publicationNumber"),
        @NamedQuery(name="findPublicationInfoByBookItemID",
            query="SELECT p.type, p.authorName, p.title, p.publicationNumber, p.publisherName, p.publicationDate " +
            "FROM Publication p, PublicationItem pi " +
            "WHERE pi.registrationNumber = :id")
    }
)
public  abstract class Publication implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String publicationNumber ;
    private PublicationType type ;
    
    private Collection<BookOrder> orders ;
    
    public Publication() {}
    
    public Publication(String author, String name) {
        this.authorName = author ;
        this.title = name ;
    }
    @Id
    public String getPublicationNumber() { return publicationNumber ; }
    public void setPublicationNumber(String publicationNumber) {
        this.publicationNumber = publicationNumber ;
    }
    @Id
    public PublicationType getType() { return type ; }
    public void setType(PublicationType type) {
        this.type = type ;
    }
    
    @OneToMany(mappedBy="publication", cascade={CascadeType.ALL})
    public Collection<BookOrder> getOrders() { return orders ; }
    public void setOrders(Collection<BookOrder> orders) { this.orders = orders ; }



    
    private Collection<PublicationItem> items ;

    // 도서정보가 수정되면 개별도서도 영향을 받는다
    @OneToMany(mappedBy="publication", cascade={CascadeType.ALL})
    public Collection<PublicationItem> getItems() { return items ; }
    public void setItems(Collection<PublicationItem> items) { this.items = items ; }
    
    
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    private String title ;
    private String authorName ;
    private String publisherName ;
    private Date publicationDate ;
    

    @Override
    public String toString() {
        return "lms.common.entity.Publication[id=" + getPublicationNumber()  + "]" + this.getTitle() + " " + this.getAuthorName() ;
    }

}
