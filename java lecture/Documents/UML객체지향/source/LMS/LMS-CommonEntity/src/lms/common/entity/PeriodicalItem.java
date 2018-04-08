/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author chae
 */
@Entity
public class PeriodicalItem extends PublicationItem implements Serializable  {
    private static final long serialVersionUID = 1L;

    private int volume ;
    private int number ;
    private Date publishDate ;

    public PeriodicalItem() {}
    
    public PeriodicalItem(Publication publication, String registrationNumber, String location, Date registrationDate) {
        super(publication, registrationNumber, location, registrationDate) ;
    }
    
    @Column(nullable=false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Column(nullable=false)
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volumn) {
        this.volume = volumn;
    }
    

    @Override
    public String toString() {
        return "lms.common.entity.PeriodicalItem:" + super.toString() + " volume: " + volume + " no: " + number + " publish Date: " + publishDate ;
    }


}
