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
public class PublicationInfo implements Serializable {
    public PublicationType type ;
    public String title ;
    public String author ;
    public String publicationNumber ;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublicationNumber() {
        return publicationNumber;
    }

    public void setPublicationNumber(String publicationNumber) {
        this.publicationNumber = publicationNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }
    public String publisher ;
    public Date publicationDate ;
    
    public PublicationInfo() {}
    
    public PublicationInfo(PublicationType type, String author, String title, String publicationNumber, String publisher, Date publicationDate) {
        this.type = type ;
        this.author = author ;
        this.title = title ;
        this.publicationNumber = publicationNumber ;
        this.publisher = publisher ;
        this.publicationDate = publicationDate ;
    }

    @Override
    public String toString() {
        return title + " " + author + " " + publicationNumber + " " + publisher + " " + publicationDate ;
    }
    
    
}
