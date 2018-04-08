/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.book.publication;

import javax.ejb.Remote;
import lms.common.type.BookInfo;
import lms.common.type.BookItemInfo;
import lms.common.type.PeriodicalInfo;
import lms.common.type.PublicationType;

/**
 *
 * @author chae
 */
@Remote
public interface PublicationMgtRemote {

    //String registerPublication(String name, String author);

    //Collection<PublicationKey> findPublicationByTitle(String title);

    //String getTitle(PublicationKey key);

    void registerBook(BookInfo bookInfo);

    void registerPeriodical(PeriodicalInfo bookInfo);

   
    void updateBook(BookInfo bookInfo);

    void updatePeriodical(PeriodicalInfo bookInfo);
    
     void removePublication(PublicationType type, String publicationNumber) ;
     void removePublicationItem(String registrationNumber) ;
     
     public void registerBookItem(String isbn, BookItemInfo bookInfo) ;
}