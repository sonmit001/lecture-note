/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.entity;

import lms.common.type.PublicationType;
import java.io.Serializable;

/**
 *
 * @author chae
 */



public class PublicationKey implements Serializable {
    
    
    private String publicationNumber;
    private  PublicationType type ;

    public PublicationKey() {}
    public PublicationKey(PublicationType type, String publicationNumber) {
        this.type = type ;
        this.publicationNumber = publicationNumber ;
    }
    public int hashCode() {
        int typeValue = ( this.getType() == PublicationType.Book ) ? 0 : 1 ;
       
        return (((this.getPublicationNumber() == null) ? 0
                                                : this.getPublicationNumber()
                                                      .hashCode())
        ^ typeValue );
    }

    public boolean equals(Object otherOb) {
        if (this == otherOb) {
            return true;
        }

        if (!(otherOb instanceof PublicationKey)) {
            return false;
        }

        PublicationKey other = (PublicationKey) otherOb;

        return (((this.getPublicationNumber() == null) ? (other.getPublicationNumber() == null)
                                                : this.getPublicationNumber()
                                                      .equals(
                other.getPublicationNumber()))
        && (getType() == other.getType()));
    }

    public String toString() {
        return getPublicationNumber() + ":" + this.getType();
    }

    public String getPublicationNumber() {
        return publicationNumber;
    }

    public void setPublicationNumber(String publicationNumber) {
        this.publicationNumber = publicationNumber;
    }

    public PublicationType getType() {
        return type ;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }
}
