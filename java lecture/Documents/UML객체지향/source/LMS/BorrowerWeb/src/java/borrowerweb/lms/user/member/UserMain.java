/*
 * UserMain.java
 *
 * Created on 2008. 6. 27, 오후 4:35:51
 */
 
package borrowerweb.lms.user.member;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.PasswordField;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TextField;
import javax.faces.FacesException;
import borrowerweb.SessionBean1;
import borrowerweb.RequestBean1;
import borrowerweb.ApplicationBean1;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.convert.DateTimeConverter;
import lms.borrowandreturn.borrow.BookBorrowMgtRemote;
import lms.common.exception.UnknownUserIDException;
import lms.common.type.BookBorrowInfo;
import lms.common.type.BookBorrowStatus;
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
public class UserMain extends AbstractPageBean {
    @EJB
    private UserMgtRemote userMgtBean;
    
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
    private StaticText requestedBookCountStaticText = new StaticText();

    public StaticText getRequestedBookCountStaticText() {
        return requestedBookCountStaticText;
    }

    public void setRequestedBookCountStaticText(StaticText st) {
        this.requestedBookCountStaticText = st;
    }
    private StaticText borrowedBookCountStaticText = new StaticText();

    public StaticText getBorrowedBookCountStaticText() {
        return borrowedBookCountStaticText;
    }

    public void setBorrowedBookCountStaticText(StaticText st) {
        this.borrowedBookCountStaticText = st;
    }
    private StaticText overDuedBookCountStaticText = new StaticText();

    public StaticText getOverDuedBookCountStaticText() {
        return overDuedBookCountStaticText;
    }

    public void setOverDuedBookCountStaticText(StaticText st) {
        this.overDuedBookCountStaticText = st;
    }
    private StaticText userCancelledReqestCountStaticText = new StaticText();

    public StaticText getUserCancelledReqestCountStaticText() {
        return userCancelledReqestCountStaticText;
    }

    public void setUserCancelledReqestCountStaticText(StaticText st) {
        this.userCancelledReqestCountStaticText = st;
    }
    private StaticText systemCancelledReqestCountStaticText = new StaticText();

    public StaticText getSystemCancelledReqestCountStaticText() {
        return systemCancelledReqestCountStaticText;
    }

    public void setSystemCancelledReqestCountStaticText(StaticText st) {
        this.systemCancelledReqestCountStaticText = st;
    }
    private StaticText finishedBorrowedBookCountStaticText = new StaticText();

    public StaticText getFinishedBorrowedBookCountStaticText() {
        return finishedBorrowedBookCountStaticText;
    }

    public void setFinishedBorrowedBookCountStaticText(StaticText st) {
        this.finishedBorrowedBookCountStaticText = st;
    }
    private StaticText userIDStaticText = new StaticText();

    public StaticText getUserIDStaticText() {
        return userIDStaticText;
    }

    public void setUserIDStaticText(StaticText st) {
        this.userIDStaticText = st;
    }
    private TextField emailTextField = new TextField();

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(TextField tf) {
        this.emailTextField = tf;
    }
    private TextField phoneNumberTextField = new TextField();

    public TextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    public void setPhoneNumberTextField(TextField tf) {
        this.phoneNumberTextField = tf;
    }
    private PasswordField password1PasswordField = new PasswordField();

    public PasswordField getPassword1PasswordField() {
        return password1PasswordField;
    }

    public void setPassword1PasswordField(PasswordField pf) {
        this.password1PasswordField = pf;
    }
    private PasswordField password2PasswordField = new PasswordField();

    public PasswordField getPassword2PasswordField() {
        return password2PasswordField;
    }

    public void setPassword2PasswordField(PasswordField pf) {
        this.password2PasswordField = pf;
    }
    private StaticText nameStaticText = new StaticText();

    public StaticText getNameStaticText() {
        return nameStaticText;
    }

    public void setNameStaticText(StaticText st) {
        this.nameStaticText = st;
    }
    private StaticText organizationStaticText = new StaticText();

    public StaticText getOrganizationStaticText() {
        return organizationStaticText;
    }

    public void setOrganizationStaticText(StaticText st) {
        this.organizationStaticText = st;
    }
    private StaticText departmentStaticText = new StaticText();

    public StaticText getDepartmentStaticText() {
        return departmentStaticText;
    }

    public void setDepartmentStaticText(StaticText st) {
        this.departmentStaticText = st;
    }
    private StaticText userTypeStaticText = new StaticText();

    public StaticText getUserTypeStaticText() {
        return userTypeStaticText;
    }

    public void setUserTypeStaticText(StaticText st) {
        this.userTypeStaticText = st;
    }
    private DateTimeConverter dateTimeConverter1 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter1() {
        return dateTimeConverter1;
    }

    public void setDateTimeConverter1(DateTimeConverter dtc) {
        this.dateTimeConverter1 = dtc;
    }
    private Button cancelRequestButton = new Button();

    public Button getCancelRequestButton() {
        return cancelRequestButton;
    }

    public void setCancelRequestButton(Button b) {
        this.cancelRequestButton = b;
    }
    private StaticText bookBorrowIDStaticText = new StaticText();

    public StaticText getBookBorrowIDStaticText() {
        return bookBorrowIDStaticText;
    }

    public void setBookBorrowIDStaticText(StaticText st) {
        this.bookBorrowIDStaticText = st;
    }
    private Button extendReturnButton = new Button();

    public Button getExtendReturnButton() {
        return extendReturnButton;
    }

    public void setExtendReturnButton(Button b) {
        this.extendReturnButton = b;
    }
    private TextField nameTextField = new TextField();

    public TextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(TextField tf) {
        this.nameTextField = tf;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public UserMain() {
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
            log("UserMain Initialization Failure", e);
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
        
        String userID = (String) getSessionBean1().getUserID() ;
        
        assert userID != null ;
        
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

    
    void renderInputs() {
        
        String userID = (String) getSessionBean1().getUserID() ;
        assert userID != null ;
        
        log("Trying to render book borrow information for " + userID) ;
        
        
        try {
            
            initUserInfo(userID) ;    
            initOngoingBorrowInfoTab(userID);
            initFinishedBorrowInfoTab(userID);
        }
        catch ( Exception e ) {
            log("UserMain: " + e.getMessage()) ;
        }
    }

    private void initFinishedBorrowInfoTab(String userID) throws UnknownUserIDException {

        // 완료된 대출 조회 초기화

        // 대출/반납 도서 수
        int finishedBookCount = bookBorrowMgtBean.getReturnedBookCountByUserID(userID);
        finishedBorrowedBookCountStaticText.setValue(finishedBookCount);

        int systemCancelledRequestCount = bookBorrowMgtBean.getSystemCancelledRequestCountByUserID(userID);
        systemCancelledReqestCountStaticText.setValue(systemCancelledRequestCount);

        int userCancelledRequestCount = bookBorrowMgtBean.getUserCancelledRequestCountByUserID(userID);
        userCancelledReqestCountStaticText.setValue(userCancelledRequestCount);
        
        getSessionBean1().getFinishedBookBorrowDataProvider().getList().clear(); 
        
        Collection<BookBorrowInfo> bookBorrowInfos = bookBorrowMgtBean.findBookBorrowInfosByUserID(userID);

        for (BookBorrowInfo bb : bookBorrowInfos) {
            //log("Found: " + bb);

            // 대출 완료된 정보만 출력한다. 즉 BorrowBorrowStatus가 Cancelled, Returned 것만 표시한다.
            if (bb.getStatus() == BookBorrowStatus.Cancelled || bb.getStatus() == BookBorrowStatus.Returned) {
                getSessionBean1().getFinishedBookBorrowDataProvider().getList().add(bb);
            }
        }
        
    }

    private void initOngoingBorrowInfoTab(String userID) throws UnknownUserIDException {
        // 진행 중인 대출 조회 초기화
        
        // 대출신청 중인 도서 수
        int requestedBookCount = bookBorrowMgtBean.getRequestedBookCountByUserID(userID);
        requestedBookCountStaticText.setValue(requestedBookCount);
        
        // 대출 중인 도서 수
        int borrowedBookCount = bookBorrowMgtBean.getBorrowedBookCountByUserID(userID);
        borrowedBookCountStaticText.setValue(borrowedBookCount);
        
        // 연체도서 수
        
        int overduedBookCount = bookBorrowMgtBean.getOngoingOverduedBookCountByUserID(userID);
        overDuedBookCountStaticText.setValue(overduedBookCount);

        getSessionBean1().getOnGoingBookBorrowDataProvider().getList().clear(); 
        
        Collection<BookBorrowInfo> bookBorrowInfos = bookBorrowMgtBean.findBookBorrowInfosByUserID(userID);

        for (BookBorrowInfo bb : bookBorrowInfos) {
            //log("Found: " + bb);

            // 대출 진행 중인 정보만 출력한다. 즉 BorrowBorrowStatus가 Requested, Borrowed인 것만 표시한다.
            if (bb.getStatus() == BookBorrowStatus.Requested || bb.getStatus() == BookBorrowStatus.Borrowed) {
                getSessionBean1().getOnGoingBookBorrowDataProvider().getList().add(bb);
            }
        }

    }

    private void initUserInfo(String userID) {

        userIDStaticText.setValue(userID);

        try {     
            UserInfo info = userMgtBean.getUserInfo(userID) ;
            
            nameStaticText.setValue(info.getName()) ;
            organizationStaticText.setValue(info.getOrganization()) ;
            departmentStaticText.setValue(info.getDept()) ;
            userTypeStaticText.setValue(info.getUserType()) ;
            
            nameTextField.setValue(info.getName()) ;
            emailTextField.setValue(info.getEmail()); 
            phoneNumberTextField.setValue(info.getPhone());
            
        }
        catch ( Exception e ) {
            log("UserMain: " + e.getMessage()) ;
        }
        
    }

    public String updateUserInfoButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        String name = (String) nameTextField.getValue() ;
        String email = (String) emailTextField.getValue() ;
        String phoneNumber = (String) phoneNumberTextField.getValue() ;
        
        try {
            String userID = (String) userIDStaticText.getValue() ;
            
            if ( name != null && ! name.isEmpty() )
                userMgtBean.updateName(userID, name);
            
            if ( email != null && ! email.isEmpty() )
                userMgtBean.updateEmail(userID, email);
            
            if ( phoneNumber != null && ! phoneNumber.isEmpty() )
                userMgtBean.updatePhoneNumber(userID, phoneNumber);
        }
        catch ( Exception e ) {
            log("UserMain: " + e.getMessage()) ;
        }   
        return null;
    }

    public String updatePasswordButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        String pw1 = (String) password1PasswordField.getValue() ;
        String pw2 = (String) password2PasswordField.getValue() ;
        
        if ( pw1 == null || pw2 == null || ! pw1.equals(pw2) ) {
                // popup error message
            return null ;
        }
        try {
            String userID = (String) userIDStaticText.getValue() ;
            userMgtBean.updatePassword(userID, pw1) ;
        }
        catch ( Exception e ) {
            log("UserMain: " + e.getMessage()) ;
        }   
        return null;
    }

    public String logoutButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        

        // 로그아웃으로서 세션에 사용자ID를 제거한다.
        getSessionBean1().setUserID(null);
        
        // 다시 도서 검색 페이지로 간다.
        return "searchList" ;
    }

    public String searchButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return "searchList" ;
    }

    public String helpHyperlink_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String userInfoTab_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String onGoingBorrowInfoTab_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String finishedBorrowInfoTab_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String cancelRequestButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        Long bookBorrowID = (Long) bookBorrowIDStaticText.getValue() ;

        log("clicked: UserMain::cancelRequestButton() for bookBorrowID " + bookBorrowID );
        
        try {
           bookBorrowMgtBean.cancelBorrowRequest(bookBorrowID);
        }
        catch ( Exception e) {
            
            log("requestCancelButton Exception: " + e.getMessage()) ;
        }
        
        return null;
        
    }

    public String extendReturnButon_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        Long bookBorrowID = (Long) bookBorrowIDStaticText.getValue() ;

        log("clicked: UserMain::extendReturnButon() for bookBorrowID " + bookBorrowID );
        
        try {
           bookBorrowMgtBean.extendReturnDate(bookBorrowID);
        }
        catch ( Exception e) {
            
            log("extendReturnButon Exception: " + e.getMessage()) ;
        }
        
        return null;
    }
    
}

