/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.book.publication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import lms.common.type.BookItemInfo;
import lms.common.type.PeriodicalItemInfo;
import lms.common.type.PublicationInfo;
import lms.common.type.PublicationType;

/**
 *
 * @author chae
 */
@Stateless
public class PublicationSearchBean implements PublicationSearchRemote {
    @PersistenceContext(unitName="PublicationSearchPU")
    private EntityManager em;

    public Collection<PublicationInfo> findPublicationInfos(PublicationType type, String title, String author, String isbn, String publisher) {
        
        System.out.println("PublicationSearchBean::findPublication invoked with:\n\t" + title + " " + author + " " + isbn + " " + publisher ) ;
        
        Collection<PublicationInfo> publications = new ArrayList<PublicationInfo>() ;
        
        try {
            StringBuffer queryString = new StringBuffer() ;
            queryString.append("SELECT p.type, p.authorName, p.title, p.publicationNumber, p.publisherName, p.publicationDate  FROM Publication p ") ;
           
            boolean ANDNeeded = false ;
            boolean WHERENeeded = true ;
            if ( type != PublicationType.All ) {
                if ( WHERENeeded ) {
                    queryString.append((" WHERE ")) ;
                    WHERENeeded  = false ;
                }
                
                queryString.append(" p.type = :type " ) ;
                ANDNeeded = true ;
                
                
            }
            if ( title != null && ! title.isEmpty() ) {
                if ( WHERENeeded ) {
                    queryString.append((" WHERE ")) ;
                    WHERENeeded  = false ;
                }
                
                if ( ANDNeeded ) queryString.append(" AND ") ;
                queryString.append(" p.title LIKE :title") ;
                ANDNeeded = true ;
            }
            if ( author != null && ! author.isEmpty()) {
                if ( WHERENeeded ) {
                    queryString.append((" WHERE ")) ;
                    WHERENeeded  = false ;
                }
                if ( ANDNeeded ) queryString.append(" AND ") ;
                queryString.append(" p.authorName LIKE :author") ;
                
                ANDNeeded = true ;
            }
            if ( isbn != null && ! isbn.isEmpty()) {
                if ( WHERENeeded ) {
                    queryString.append((" WHERE ")) ;
                    WHERENeeded  = false ;
                }
                if ( ANDNeeded ) queryString.append(" AND ") ;
                queryString.append(" p.publicationNumber LIKE :isbn") ;
                
                ANDNeeded = true ;
            }
            if ( publisher != null && ! publisher.isEmpty()) {
                if ( WHERENeeded ) {
                    queryString.append((" WHERE ")) ;
                    WHERENeeded  = false ;
                }
                if ( ANDNeeded ) queryString.append(" AND ") ;
                queryString.append(" p.publisherName LIKE :publisher") ;
                
                ANDNeeded = true ;
            }
           
            
            System.out.println("\tQuery requested: " + queryString) ;
                    
            Query query = em.createQuery(new String(queryString)) ;
                    
            if ( type != PublicationType.All ) query.setParameter("type", type) ;
            
            if ( title != null && ! title.isEmpty() ) query.setParameter("title", "%"+title+"%") ;
            if ( author != null && ! author.isEmpty()) query.setParameter("author", "%"+author+"%") ;
            if ( isbn != null && ! isbn.isEmpty()) query.setParameter("isbn", "%"+isbn+"%") ;
            if ( publisher != null && ! publisher.isEmpty()) query.setParameter("publisher", "%"+publisher+"%") ;
              
            List results = query.getResultList() ;
            
            System.out.println("\tFound publications: " + results.size()) ;
            
            resultList2PublicationInfoList(results, publications);
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }        
        return publications ;        
    }

    public Collection<PublicationKey> findPublicationByTitle(String title) {
        
        Query query = em.createNamedQuery("findPublicationKeysByTitle").setParameter("title", "%" + title + "%") ;
                
        List publications = query.getResultList() ;
        
        Collection<PublicationKey> keys = new ArrayList<PublicationKey>() ;
        
        System.out.println("Found publications: " + publications.size()) ;
        
        for ( int i = 0 ; i < publications.size() ; i ++ ) {
            
            Object[] elem = (Object[]) publications.get(i) ;
            
            System.out.println(elem[0].getClass()) ;
            System.out.println(elem[1].getClass()) ;
            
            PublicationType type = (PublicationType) elem[0] ;
            String number = (String) elem[1] ;
                   
            PublicationKey key = new PublicationKey(type, number);
            
            keys.add(key);
        }
        return keys ;
    }

    public String getTitle(PublicationKey key) {
        
        String title ;
        try {
            Publication publication = em.find(Publication.class, key) ;
            em.refresh(publication) ;
        
            title = publication.getTitle() ;
        
        }
        catch ( Exception e ) {
            System.out.println("No Such book exists" + key ) ;
            return "NOT FOUND" ;
        }
        return title ;
    }
    
    public Collection<PublicationInfo> findPublicationInfosByTitle(String key) {

        System.out.println("PublicationSearchBean::findPublicationInFoByTile invoked with: " + key) ;
                
        Collection<PublicationInfo> publications = new ArrayList<PublicationInfo>() ;
        
        try {
            Query query = em.createNamedQuery("findPublicationInfosByTitle").setParameter("title", "%" + key + "%") ;
            
            List results = query.getResultList() ;
            
            System.out.println("Found publications: " + results.size()) ;
            
            resultList2PublicationInfoList(results, publications);
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }        
        return publications ;
    }

    public PublicationInfo findPublicationInfoByKey(PublicationType type, String isbn) {
        
        System.out.println("PublicationSearchBean::findPublicationInfoByKey invoked with: " + isbn) ;
        
        assert isbn != null && ! isbn.isEmpty() ;
        PublicationInfo publicationInfo = new PublicationInfo() ;
        
        try {
            
            Query query = em.createNamedQuery("findPublicationInfoByKey").setParameter("publicationNumber", isbn) ;
            
            query.setParameter("type", type) ;
                    
            List results = query.getResultList() ;
            System.out.println("Query Result: " + results.size()) ;
            
            Object[] elem = (Object[]) query.getSingleResult() ;
            
            // query="SELECT p.type, p.authorName, p.title, p.publicationNumber, p.publisherName, p.publicationDate FROM Publication p WHERE p.type = :type and p.publicationNumber = :publicationNumber")
            
            type = (PublicationType) elem[0] ;
            String author = (String) elem[1] ;
            String title = (String) elem[2] ;
            String number = (String) elem[3] ;
            String publisher = (String) elem[4] ;
            Date publicationDate = (Date) elem[5] ;    

            publicationInfo = new PublicationInfo(type, author,  title,  number,  publisher,  publicationDate) ;
            
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
        
        return publicationInfo ;
    }
    
    public PublicationInfo findPublicationInfoByBookItemID(String registrationNumber) {
        
        System.out.println("PublicationSearchBean::findPublicationInfoByBookItemID invoked with: " + registrationNumber) ;
        
        PublicationInfo publicationInfo = new PublicationInfo() ;
        
        try {
            
            Query query = em.createNamedQuery("FindBookByBookItemID").setParameter("id", registrationNumber) ;  
            
            Book publication = (Book) query.getSingleResult() ;
            
            PublicationType type = publication.getType() ;
            String author = publication.getAuthorName() ;
            String title = publication.getTitle() ;
            String number = publication.getPublicationNumber() ;
            String publisher = publication.getPublisherName() ;
            Date publicationDate = publication.getPublicationDate() ;
            
            publicationInfo = new PublicationInfo(type, author,  title,  number,  publisher,  publicationDate) ;
            
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
        
        return publicationInfo ;
    }
    
    public Collection<BookItemInfo> findBookItemInfosByID(String isbn) {

        System.out.println("PublicationSearchBean::findBookItemInfosByID invoked with ISBN: " + isbn) ;
                
        Collection<BookItemInfo> books = new ArrayList<BookItemInfo>() ;
        
        try {
    
            PublicationKey key = new PublicationKey(PublicationType.Book, isbn) ;
            
            Book book = em.find(Book.class, key) ;
            em.refresh(book) ;
            
            System.out.println("\tBook found: " + book.getTitle() ) ;
            
            Collection<PublicationItem> items = book.getItems() ;
            
            System.out.println("\tRelated Book Items found: " + items.size()) ;
            
            for ( Iterator it = items.iterator() ; it.hasNext() ; ) {
            
                PublicationItem item = (PublicationItem) it.next() ;
                if ( item instanceof BookItem ) {
                    BookItem bookItem = (BookItem) item ;
                    
                    em.refresh(bookItem) ;
                    
                    System.out.println("\t\tRegistration Number: " + bookItem.getRegistrationNumber()) ;
                    
                    BookItemInfo bookItemInfo = new BookItemInfo(
                            bookItem.getRegistrationNumber(),
                            bookItem.getLocation(),
                            bookItem.getRegistrationDate(),
                            bookItem.getUnregistrationDate(),
                            bookItem.getStatus()) ;

                    books.add(bookItemInfo) ;
                }
                
            }
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }        
        return books  ;
    }
    
        public Collection<PeriodicalItemInfo> findPeriodicalItemInfosByID(String isbn) {
            return null ;
        }
    
    public void persist(Object object) {
        em.persist(object);
    }

    public int getBookPage(String isbn) {        
        try {
            PublicationKey key = new PublicationKey(PublicationType.Book, isbn) ;
            
            Book book = em.find(Book.class, key) ;
            em.refresh(book) ;
            
            //System.out.println("Book found: " + book.getTitle() ) ;
            
            return book.getPage() ;
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
        
    }

    public boolean isPeriodicalSubscribed(String issn) {
        try {
            PublicationKey key = new PublicationKey(PublicationType.Periodical, issn) ;
            
            Periodical periodical = em.find(Periodical.class, key) ;
            em.refresh(periodical) ;
            
            //System.out.println("Periodical found: " + periodical.getTitle() ) ;
            
            return periodical.isIsSubscribed() ;
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
    }

    private void resultList2PublicationInfoList(List results, Collection<PublicationInfo> publications) {

        for (int i = 0; i < results.size(); i++) {

            Object[] elem = (Object[]) results.get(i);

            // SELECT p.type, p.authorName, p.title, p.publicationNumber, p.publisherName, p.publicationDate
            PublicationType type = (PublicationType) elem[0];
            String author = (String) elem[1];
            String title = (String) elem[2];
            String number = (String) elem[3];
            String publisher = (String) elem[4];
            Date publicationDate = (Date) elem[5];

            //System.out.println("\t\tTitle: " + title + ", author: " + author) ;
            
            PublicationInfo info = new PublicationInfo(type, author, title, number, publisher, publicationDate);
            publications.add(info);
        }
    }

    public String getPublicationItemLocation(String registrationNumber) {
                        
        String location ;
        try {
            
            Query query = em.createNamedQuery("GetPublicationItemByID").setParameter("id", registrationNumber) ;        
            
            PublicationItem item = (PublicationItem) query.getSingleResult() ;
            
            location = item.getLocation() ;
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
        return location ;
    }
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
