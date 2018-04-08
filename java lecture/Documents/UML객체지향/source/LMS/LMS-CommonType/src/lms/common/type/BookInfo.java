/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.type;

import java.util.Date;

/**
 *
 * @author chae
 */
public class BookInfo extends PublicationInfo {
    public int page ;
    
    public BookInfo() {}
    
    public BookInfo(String author, String title, String publicationNumber, String publisher, Date publicationDate, int page) {
        super(PublicationType.Book, author, title, publicationNumber, publisher, publicationDate) ;
        this.page = page ;
    }

    @Override
    public String toString() {
        return super.toString() + page ;
    }
}
