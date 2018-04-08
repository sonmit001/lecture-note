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
public class PeriodicalInfo extends PublicationInfo {
    public boolean isSubscribed ;
    
    public PeriodicalInfo() {}
    
    public PeriodicalInfo(String author, String title, String publicationNumber, String publisher, Date publicationDate, boolean isSubscribed) {
        super(PublicationType.Periodical, author, title, publicationNumber, publisher, publicationDate) ;
        this.isSubscribed = isSubscribed ;
    }

    @Override
    public String toString() {
        return super.toString() + isSubscribed ;
    }
}
