/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.common.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import lms.common.type.UserType;

/**
 *
 * @author chae
 */
@Entity
@NamedQueries(
    {
        @NamedQuery(name="FindUserInfosByName",
            query="SELECT u.userType, u.userID, u.name, u.password, u.email, u.organization, u.department, u.phoneNumber  FROM LibraryUser u WHERE u.name LIKE :name"),
        @NamedQuery(name="FindUserInfosByNameAndID",
            query="SELECT u.userType, u.userID, u.name, u.password, u.email, u.organization, u.department, u.phoneNumber  FROM LibraryUser u WHERE u.name LIKE :name and u.userID LIKE :id"),
        @NamedQuery(name="RemoveUserByUserID",
            query="DELETE FROM LibraryUser u WHERE u.userID = :id"),
        @NamedQuery(name="FindUserByUserID",
            query="SELECT u FROM LibraryUser u WHERE u.userID = :id"),
        @NamedQuery(name="GetBookBorrowCountByUserIDAndStatus",
            query="SELECT bb.id FROM LibraryUser u, IN (u.bookBorrows) bb WHERE bb.status = :status AND u.userID = :id")
    }
)        
public class LibraryUser implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static int StudentBorrowMaxNumber = 5 ;
    private static int StudentReturnExtendMaxNumber = 1 ;
    
    private static int ProfessorBorrowMaxNumber = 10 ;
    private static int ProfessorReturnExtendMaxNumber = 1 ;
    
    private static int StaffBorrowMaxNumber = 5 ;
    private static int StaffReturnExtendMaxNumber = 1 ;
    
    public static int ExpectedBorrowDay = 2 ;
    
    private UserType userType ;
    
    private Collection<BookOrder> orders ;
    private String userID ;
    private String name ;
    
    
    private String address ;
    private String email ;
    private String phoneNumber ;
    private String organization ;
    private String department ;

    private Collection<BookBorrow> bookBorrows ;

    @OneToMany(mappedBy="borrower", cascade={CascadeType.ALL})
    public Collection<BookBorrow> getBookBorrows() {
        return bookBorrows;
    }

    public void setBookBorrows(Collection<BookBorrow> bookBorrows) {
        this.bookBorrows = bookBorrows;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBorrowMaxNumber() {
        return borrowMaxNumber;
    }

    public void setBorrowMaxNumber(int borrowMaxNumber) {
        this.borrowMaxNumber = borrowMaxNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getReturnExtendMaxNumber() {
        return returnExtendMaxNumber;
    }

    public void setReturnExtendMaxNumber(int returnExtendMaxNumber) {
        this.returnExtendMaxNumber = returnExtendMaxNumber;
    }
    
    private int borrowMaxNumber ;
    private int returnExtendMaxNumber ;
      

    @Id
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public LibraryUser() {
    }
    
    public LibraryUser(UserType userType, String userId, String password, String name) {
        
        this.userID = userId ;
        this.password = password ;
        this.name = name ;
        this.userType = userType ;
        
        setBorrowInfo() ;
        
    }
    
    private void setBorrowInfo() {
        
        switch ( this.userType ) {
            case Student:
                this.borrowMaxNumber = StudentBorrowMaxNumber ;
                this.returnExtendMaxNumber = StudentReturnExtendMaxNumber ;
                break ;
            case Professor:
                this.borrowMaxNumber = ProfessorBorrowMaxNumber ;
                this.returnExtendMaxNumber = ProfessorReturnExtendMaxNumber ;
                break ;
            case Staff:
                this.borrowMaxNumber = StaffBorrowMaxNumber ;
                this.returnExtendMaxNumber = StaffReturnExtendMaxNumber ;
                break ;
            default:
                this.borrowMaxNumber = StudentBorrowMaxNumber ;
                this.returnExtendMaxNumber = StudentReturnExtendMaxNumber ;
                break ;
        }    
    }
    
    @Column(nullable=false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
        setBorrowInfo() ;
    }

    @OneToMany(mappedBy = "libraryUser", cascade={CascadeType.ALL})
    public Collection<BookOrder> getOrders() {
        return orders;
    }

    public void setOrders(Collection<BookOrder> orders) {
        this.orders = orders;
    }

    @Column(nullable=false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String password ;

    
    private Collection<Book> books = new ArrayList<Book> () ;
    @ManyToMany(mappedBy="waiters")
    public Collection<Book> geBooks() {
        return books;
    }
    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
    
    @Override
    public String toString() {
        return "lms.common.entity.LibraryUser[id=" + userID + "]" ;
    }

}
