/*
 * SessionBean1.java
 *
 * Created on 2008. 6. 20, 오후 3:13:41
 */
 
package librarianweb;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import javax.faces.FacesException;
import librarianweb.lms.book.publication.BookItemDataProvider;
import librarianweb.lms.book.publication.PublicationDataProvider;
import librarianweb.lms.borrowandreturn.BookBorrowDataProvider;
import librarianweb.lms.user.member.UserDataProvider;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @author chae
 */
public class SessionBean1 extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SessionBean1() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     * 
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("SessionBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     * 
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    @Override
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     * 
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    @Override
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    private PublicationDataProvider publicationDataProvider = new PublicationDataProvider();

    public PublicationDataProvider getPublicationDataProvider() {
        return publicationDataProvider;
    }

    public void setPublicationDataProvider(PublicationDataProvider publicationDataProvider) {
        this.publicationDataProvider = publicationDataProvider;
    }
    
    private BookItemDataProvider bookItemDataProvider = new BookItemDataProvider();

    public BookItemDataProvider getBookItemDataProvider() {
        return bookItemDataProvider;
    }

    public void setBookItemDataProvider(BookItemDataProvider bookItemDataProvider) {
        this.bookItemDataProvider = bookItemDataProvider;
    }

    public UserDataProvider getUserDataProvider() {
        return userDataProvider;
    }

    public void setUserDataProvider(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
    }
    
    private UserDataProvider userDataProvider = new UserDataProvider();
    
    private BookBorrowDataProvider bookBorrowDataProvider = new BookBorrowDataProvider() ;

    public BookBorrowDataProvider getBookBorrowDataProvider() {
        return bookBorrowDataProvider;
    }

    public void setBookBorrowDataProvider(BookBorrowDataProvider bookBorrowDataProvider) {
        this.bookBorrowDataProvider = bookBorrowDataProvider;
    }
    
    
    private String userID ;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
}
