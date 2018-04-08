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
public class PeriodicalItemInfo extends PublicationItemInfo {
    private int volume ;
    private int number ;
    private Date publishDate ;

    public PeriodicalItemInfo() {}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    public PeriodicalItemInfo(String registrationNumber, String location, Date registrationDate, int volume, int number, Date publishDate ) {
        super(registrationNumber, location, registrationDate) ;
        this.volume = volume ;
        this.number = number ;
        this.publishDate = publishDate ;
    }
}
