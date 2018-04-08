/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.book.publication;

import java.util.Collection;
import javax.ejb.Remote;
import lms.common.entity.BookItem;
import lms.common.exception.MultipleBookItemIDException;
import lms.common.exception.UnknownBookItemIDException;
import lms.common.type.BookItemInfo;
import lms.common.type.PeriodicalItemInfo;
import lms.common.type.PublicationInfo;
import lms.common.type.PublicationType;

/**
 *
 * @author chae
 */
@Remote
public interface PublicationSearchRemote {

    Collection<PublicationInfo> findPublicationInfos(PublicationType type, String title, String author, String isbn, String publisher);
    
     Collection<PublicationInfo> findPublicationInfosByTitle(String title);
     
     Collection<BookItemInfo> findBookItemInfosByID(String isbn);
     
     Collection<PeriodicalItemInfo> findPeriodicalItemInfosByID(String isbn);

    PublicationInfo findPublicationInfoByKey(PublicationType type, String isbn);

    int getBookPage(String isbn);

    boolean isPeriodicalSubscribed(String issn);
    
    public PublicationInfo findPublicationInfoByBookItemID(String registrationNumber) ;

    String getPublicationItemLocation(String registrationNumber);
}
