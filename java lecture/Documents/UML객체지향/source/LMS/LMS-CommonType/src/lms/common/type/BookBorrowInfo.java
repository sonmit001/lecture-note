/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.type;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author chae
 */
public class BookBorrowInfo  implements Serializable {
    private Long bookBorrowID ;
    private String userID ;
    private String userName ;
    
    private String title ;
    private String publicationNumber ;
    
    
    private String author ;
    
    public BookBorrowInfo(Long bookBorrowID) {
        this.bookBorrowID = bookBorrowID ;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getBookBorrowID() {
        return bookBorrowID;
    }

    public void setBookBorrowID(Long bookBorrowID) {
        this.bookBorrowID = bookBorrowID;
    }

    public Date getBorrowCancelledDate() {
        return borrowCancelledDate;
    }

    public void setBorrowCancelledDate(Date borrowCancelledDate) {
        this.borrowCancelledDate = borrowCancelledDate;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getBorrowExpectedDate() {
        return borrowExpectedDate;
    }

    public void setBorrowExpectedDate(Date borrowExpectedDate) {
        this.borrowExpectedDate = borrowExpectedDate;
    }

    public Date getBorrowRequestedDate() {
        return borrowRequestedDate;
    }

    public void setBorrowRequestedDate(Date borrowRequestedDate) {
        this.borrowRequestedDate = borrowRequestedDate;
    }

    public boolean isIsRequestCancelledBySystem() {
        return isRequestCancelledBySystem;
    }

    public void setIsRequestCancelledBySystem(boolean isRequestCancelledBySystem) {
        this.isRequestCancelledBySystem = isRequestCancelledBySystem;
    }

    public int getOverDueFee() {
        return overDueFee;
    }

    public void setOverDueFee(int overDueFee) {
        this.overDueFee = overDueFee;
    }

    public boolean isOverDueFeePaid() {
        return overDueFeePaid;
    }

    public void setOverDueFeePaid(boolean overDueFeePaid) {
        this.overDueFeePaid = overDueFeePaid;
    }

    public String getPublicationNumber() {
        return publicationNumber;
    }

    public void setPublicationNumber(String publicationNumber) {
        this.publicationNumber = publicationNumber;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getReturnExpectedDate() {
        return returnExpectedDate;
    }

    public void setReturnExpectedDate(Date returnExpectedDate) {
        this.returnExpectedDate = returnExpectedDate;
    }

    public int getReturnExtendCount() {
        return returnExtendCount;
    }

    public void setReturnExtendCount(int returnExtendCount) {
        this.returnExtendCount = returnExtendCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    private Date borrowRequestedDate ;
    private Date borrowExpectedDate ;
    
    private Date borrowCancelledDate ;
    private boolean isRequestCancelledBySystem ;
    private Date borrowDate ;
    
    private Date returnExpectedDate ;
    private Date returnDate ;
    
    private int returnExtendCount ;
    
    private boolean canExtendReturn ;

    public boolean isCanExtendReturn() {
        return canExtendReturn;
    }

    public void setCanExtendReturn(boolean canExtendReturn) {
        this.canExtendReturn = canExtendReturn;
    }
    
    private int overDueFee ;
    private boolean overDueFeePaid ;
    
    private BookBorrowStatus status ;

    private String registrationNumber ;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    
    public BookBorrowStatus getStatus() {
        return status;
    }

    public void setStatus(BookBorrowStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + bookBorrowID + " regNumber: " + registrationNumber + " title: " + title + " author: " + author + " user: " + userName + " status: " + status +
                " requested: " + borrowRequestedDate + " cancelledDate: " + borrowCancelledDate + " borrowExpectedDate:  " + borrowExpectedDate +
                " BorrowDate: " + borrowDate + " returnDate: " + returnDate + " returnExtendCount: " + returnExtendCount +
                " overdueFee: " + overDueFee  + " returnExtendCount: " + returnExtendCount + " canExtendReturn: " + canExtendReturn ;
    }
    
}
