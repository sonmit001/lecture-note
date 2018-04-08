/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.book.publication;

import java.util.Collection;
import javax.ejb.EJBException;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lms.common.entity.Book;
import lms.common.entity.BookItem;
import lms.common.entity.Periodical;
import lms.common.entity.Publication;
import lms.common.entity.PublicationItem;
import lms.common.entity.PublicationKey;

import lms.common.type.BookInfo;
import lms.common.type.BookItemInfo;
import lms.common.type.PeriodicalInfo;
import lms.common.type.PublicationInfo;
import lms.common.type.PublicationType;

/**
 *
 * @author chae
 */
@Stateless
public class PublicationMgtBean implements PublicationMgtRemote {
    @PersistenceContext(unitName="LMS-corePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    

    private void setPublicationInfo(Publication p, PublicationInfo info) {
        
        p.setAuthorName(info.author); ;
        p.setPublicationDate(info.publicationDate); ;
        p.setPublisherName(info.publisher) ;
        p.setTitle(info.title);
        p.setPublicationNumber(info.publicationNumber) ;
        
    }
    public void registerBook(BookInfo bookInfo) {
     
        System.out.println("PublicationMgtBean::registerBook invoked with: " + bookInfo) ;
        
        try {
            Book newBook = new Book() ;
            
            setPublicationInfo(newBook, bookInfo) ;
            newBook.setPage(bookInfo.page) ;
            
            em.persist(newBook);
            em.flush();
        }
        catch ( Exception e ) {
            e.printStackTrace();
            
            throw new EJBException(e) ;
        }
        
    }

    public void registerPeriodical(PeriodicalInfo periodicalInfo) {
        
        System.out.println("PublicationMgtBean::registerPeriodical invoked with: " + periodicalInfo) ;
        
        try {
            Periodical newPeriodical = new Periodical() ;
            
            
            setPublicationInfo(newPeriodical, periodicalInfo) ;
            newPeriodical.setIsSubscribed(periodicalInfo.isSubscribed) ;
            
            em.persist(newPeriodical);
            em.flush();
        }
        catch ( Exception e ) {
            
            throw new EJBException(e) ;
        }
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    
    public void updateBook(BookInfo bookInfo) {
     
        System.out.println("PublicationMgtBean::updateBook invoked with: " + bookInfo) ;
        
        try {
            PublicationKey key = new PublicationKey(bookInfo.getType(), bookInfo.getPublicationNumber()) ;
            Book book = em.find(Book.class, key) ;
            em.refresh(book) ;
            
            setPublicationInfo(book, bookInfo) ;
            book.setPage(bookInfo.page) ;
            
            em.persist(book);       
            em.flush(); ;
            
        }
        catch ( Exception e ) {
            
            throw new EJBException(e) ;
        }
        
    }

    public void updatePeriodical(PeriodicalInfo periodicalInfo) {
        
        System.out.println("PublicationMgtBean::updatePeriodical invoked with: " + periodicalInfo) ;
        
        try {
            
            PublicationKey key = new PublicationKey(periodicalInfo.getType(), periodicalInfo.getPublicationNumber()) ;
            Periodical periodical = em.find(Periodical.class, key) ;
            em.refresh(periodical) ;
            
            setPublicationInfo(periodical, periodicalInfo) ;
            periodical.setIsSubscribed(periodicalInfo.isSubscribed) ;
            
            em.persist(periodical);
            em.flush();
        }
        catch ( Exception e ) {
            
            throw new EJBException(e) ;
        }
    }
    
    public void removePublication(PublicationType type, String publicationNumber) {
     
        System.out.println("PublicationMgtBean::removePublication invoked with: " +  publicationNumber ) ;
        
        try {
            PublicationKey key = new PublicationKey(type, publicationNumber) ;
            
            switch ( type ) {
                case Book  : {
                    Book book = em.find(Book.class, key) ;
                    em.remove(book) ;
                    em.flush();
                    break ;
                }
                case Periodical  : {
                    Periodical periodical = em.find(Periodical.class, key) ;
                    em.remove(periodical) ;
                    em.flush();
                    break ;
                }
                default: break ;
            }
            
        }
        catch ( Exception e ) {
            
            throw new EJBException(e) ;
        }
        
    }
     
    public void removePublicationItem(String registrationNumber) {
     
        System.out.println("PublicationMgtBean::removePublicationItem invoked with: " +  registrationNumber ) ;
        
        try {
            Query query = em.createNamedQuery("RemovePublicationItemByID").setParameter("id", registrationNumber) ;
            
            query.executeUpdate();
            
        }
        
        catch ( Exception e ) {
            
            throw new EJBException(e) ;
        }
        
    }

    public void registerBookItem(String isbn, BookItemInfo bookInfo) {
     
        System.out.println("PublicationMgtBean::registerBookItem invoked with: " + isbn + " for " + bookInfo) ;
        
        try {
            
            PublicationKey key = new PublicationKey(PublicationType.Book, isbn) ;
            Publication publication = em.find(Publication.class, key) ;
            em.refresh(publication) ;
            
            BookItem newBookItem = new BookItem(publication, bookInfo.getRegistrationNumber(), bookInfo.getLocation(), bookInfo.getRegistrationDate()) ;
            em.persist(newBookItem);
            
            Collection<PublicationItem> items = publication.getItems() ;
            System.out.println("Before add Book Item: size: " + items.size() ) ;
            
            items.add(newBookItem) ;
            
            em.persist(publication) ;
            em.flush() ;
            
            items = publication.getItems() ;
            System.out.println("After add Book Item: size: " + items.size() ) ;
           
        }
        catch ( Exception e ) {   
            throw new EJBException(e) ;
        }
        
    }
 
}
