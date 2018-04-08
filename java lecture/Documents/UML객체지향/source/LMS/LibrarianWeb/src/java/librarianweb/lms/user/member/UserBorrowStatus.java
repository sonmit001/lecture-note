/*
 * UserBorrowStatus.java
 *
 * Created on 2008. 6. 27, 오후 6:53:53
 */
 
package librarianweb.lms.user.member;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TableColumn;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.convert.DateTimeConverter;
import librarianweb.SessionBean1;
import librarianweb.RequestBean1;
import librarianweb.ApplicationBean1;
import lms.borrowandreturn.Return.BookReturnMgtRemote;
import lms.borrowandreturn.borrow.BookBorrowMgtRemote;
import lms.common.exception.UnknownUserIDException;
import lms.common.type.BookBorrowInfo;
import lms.common.type.UserInfo;
import lms.user.member.UserMgtRemote;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author chae
 */
public class UserBorrowStatus extends AbstractPageBean {
    @EJB
    private UserMgtRemote userMgtBean;
    @EJB
    private BookReturnMgtRemote bookReturnMgtBean;
    @EJB
    private BookBorrowMgtRemote bookBorrowMgtBean;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        dateTimeConverter1.setTimeZone(null);
        dateTimeConverter1.setDateStyle("short");
    }
    private StaticText userNameStaticText = new StaticText();

    public StaticText getUserNameStaticText() {
        return userNameStaticText;
    }

    public void setUserNameStaticText(StaticText st) {
        this.userNameStaticText = st;
    }
    private StaticText userIDStaticText = new StaticText();

    public StaticText getUserIDStaticText() {
        return userIDStaticText;
    }

    public void setUserIDStaticText(StaticText st) {
        this.userIDStaticText = st;
    }
    private Button requestCancelButton = new Button();

    public Button getRequestCancelButton() {
        return requestCancelButton;
    }

    public void setRequestCancelButton(Button b) {
        this.requestCancelButton = b;
    }
    private TableColumn requestCancelColumn = new TableColumn();

    public TableColumn getRequestCancelColumn() {
        return requestCancelColumn;
    }

    public void setRequestCancelColumn(TableColumn tc) {
        this.requestCancelColumn = tc;
    }
    private TableColumn requestCancelColumn2 = new TableColumn();

    public TableColumn getRequestCancelColumn2() {
        return requestCancelColumn2;
    }

    public void setRequestCancelColumn2(TableColumn tc) {
        this.requestCancelColumn2 = tc;
    }
    private StaticText bookBorrowIDStaticText = new StaticText();

    public StaticText getBookBorrowIDStaticText() {
        return bookBorrowIDStaticText;
    }

    public void setBookBorrowIDStaticText(StaticText st) {
        this.bookBorrowIDStaticText = st;
    }
    private Button returnButton = new Button();

    public Button getReturnButton() {
        return returnButton;
    }

    public void setReturnButton(Button b) {
        this.returnButton = b;
    }
    private DateTimeConverter dateTimeConverter1 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter1() {
        return dateTimeConverter1;
    }

    public void setDateTimeConverter1(DateTimeConverter dtc) {
        this.dateTimeConverter1 = dtc;
    }
    private StaticText userTypeStaticText = new StaticText();

    public StaticText getUserTypeStaticText() {
        return userTypeStaticText;
    }

    public void setUserTypeStaticText(StaticText st) {
        this.userTypeStaticText = st;
    }
    private StaticText emailStaticText = new StaticText();

    public StaticText getEmailStaticText() {
        return emailStaticText;
    }

    public void setEmailStaticText(StaticText st) {
        this.emailStaticText = st;
    }
    private StaticText registrationNumberStaticText = new StaticText();

    public StaticText getRegistrationNumberStaticText() {
        return registrationNumberStaticText;
    }

    public void setRegistrationNumberStaticText(StaticText st) {
        this.registrationNumberStaticText = st;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public UserBorrowStatus() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
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
            log("UserBorrowStatus Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
        
        String userID = (String) userIDStaticText.getValue() ;
        if ( userID == null ) {
            userID = (String) getRequestBean1().getRequestValue("userID") ;
            userIDStaticText.setValue(userID) ;
        }
        
        renderInputs() ;
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    public String gotoUserListPageButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return "userList" ;
    }
    
    void renderInputs() {
        
        String userID = (String) userIDStaticText.getValue() ;
        
        log("Trying to render book borrow information for " + userID) ;
        
        try {
            
            initUserInfo(userID);
            
        
            getSessionBean1().getBookBorrowDataProvider().getList().clear(); 
            Collection<BookBorrowInfo> bookBorrowInfos = bookBorrowMgtBean.findBookBorrowInfosByUserID(userID) ;
            
            for ( BookBorrowInfo bb : bookBorrowInfos ) {
                //log("Found: " + bb) ;
                
                getSessionBean1().getBookBorrowDataProvider().getList().add(bb);
                
            }
        }
        
        catch ( Exception e ) {
            log("UserBorrowStatus: " + e.getMessage()) ;
        }
    }

    public String requestCancelButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        // 해당 대출신청을 취소시킨다.
        // 해당 대출신청식별자를 이용한다.
        
        Long bookBorrowID = (Long) bookBorrowIDStaticText.getValue() ;
        
        try {
            bookBorrowMgtBean.cancelBorrowRequest(bookBorrowID);
        }
        catch ( Exception e) {
            
            log("requestCancelButton Exception: " + e.getMessage()) ;
        }
        
        return null;
    }

    public String borrowButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
         Long bookBorrowID = (Long) bookBorrowIDStaticText.getValue() ;
        
        try {
            bookBorrowMgtBean.borrowBookItem(bookBorrowID);
        }
        catch ( Exception e) {
            
            log("borrowButton  Exception: " + e.getMessage()) ;
        }
        return null;
    }

    public String returnButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
         String registrationNumber = (String) registrationNumberStaticText.getValue() ;
         
        try {
            bookReturnMgtBean.returnBookItem(registrationNumber);
        }
        catch ( Exception e) {
            
            log("returnButton Exception: " + e.getMessage()) ;
        }
         
        return null;
    }

    public String extendReturnButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        Long bookBorrowID = (Long) bookBorrowIDStaticText.getValue() ;
        
        try {
            bookBorrowMgtBean.extendReturnDate(bookBorrowID);
        }
        catch ( Exception e) {
            
            log("extendReturnButton Exception: " + e.getMessage()) ;
        }
        return null;
    }

    private void initUserInfo(String userID) throws UnknownUserIDException {

        try {
            UserInfo userInfo = userMgtBean.getUserInfo(userID);
            
            userNameStaticText.setValue(userInfo.getName());
            userTypeStaticText.setValue(userInfo.getUserType());
            emailStaticText.setValue(userInfo.getEmail());
        }
        catch ( Exception e ) {
            log("UserBorrowStatus::initUserInfo() for userID: " + userID) ;
        }
    }

    public String payFeeButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        // 연체료 납부
        Long bookBorrowID = (Long) bookBorrowIDStaticText.getValue() ;
        
        try {
            bookReturnMgtBean.payOverdueFee(bookBorrowID);
        }
        catch ( Exception e) {
            
            log("UserBorrowStatus::payFeeButton() Exception: " + e.getMessage()) ;
        }        
        
        return null;
    }
    
}

