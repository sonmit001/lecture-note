/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lms.common.type.PublicationType;

/**
 *
 * @author chae
 */
@Entity
public class Periodical extends Publication implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private boolean subscribed ;

    
    public Periodical() {super(); this.setType(PublicationType.Periodical);}
    
    
    public boolean isIsSubscribed() {
        return subscribed;
    }

    public void setIsSubscribed(boolean isSubscribed) {
        this.subscribed = isSubscribed;
    }
    
    @Override
    public String toString() {
        return "lms.common.entity.Periodical: " + super.toString() ;
    }

}
