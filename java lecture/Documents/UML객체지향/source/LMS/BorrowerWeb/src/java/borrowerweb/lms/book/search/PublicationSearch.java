/*
 * PublicationSearch.java
 *
 * Created on 2008. 6. 22, 오후 10:20:42
 */
 
package borrowerweb.lms.book.search;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.FacesException;
import borrowerweb.RequestBean1;
import borrowerweb.ApplicationBean1;
import borrowerweb.SessionBean1;
import lms.book.publication.PublicationSearchRemote;
import lms.common.type.PublicationInfo;
import lms.common.type.PublicationType;
import lms.common.type.UserType;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author chae
 */
public class PublicationSearch extends AbstractPageBean {
    @EJB
    private PublicationSearchRemote publicationSearchBean;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private Checkbox bookCheckBox = new Checkbox();

    public Checkbox getBookCheckBox() {
        return bookCheckBox;
    }

    public void setBookCheckBox(Checkbox c) {
        this.bookCheckBox = c;
    }
    private Checkbox periodicalCheckBox = new Checkbox();

    public Checkbox getPeriodicalCheckBox() {
        return periodicalCheckBox;
    }

    public void setPeriodicalCheckBox(Checkbox c) {
        this.periodicalCheckBox = c;
    }
    private TextField ISBNTextField = new TextField();

    public TextField getISBNTextField() {
        return ISBNTextField;
    }

    public void setISBNTextField(TextField tf) {
        this.ISBNTextField = tf;
    }
    private TextField titleTextField = new TextField();

    public TextField getTitleTextField() {
        return titleTextField;
    }

    public void setTitleTextField(TextField tf) {
        this.titleTextField = tf;
    }
    private TextField authorTextField = new TextField();

    public TextField getAuthorTextField() {
        return authorTextField;
    }

    public void setAuthorTextField(TextField tf) {
        this.authorTextField = tf;
    }
    private TextField publisherTextField = new TextField();

    public TextField getPublisherTextField() {
        return publisherTextField;
    }

    public void setPublisherTextField(TextField tf) {
        this.publisherTextField = tf;
    }
    private Button searchButton = new Button();

    public Button getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(Button b) {
        this.searchButton = b;
    }
    private Hyperlink bookNameHyperlink = new Hyperlink();

    public Hyperlink getBookNameHyperlink() {
        return bookNameHyperlink;
    }

    public void setBookNameHyperlink(Hyperlink h) {
        this.bookNameHyperlink = h;
    }
    private StaticText typeStaticText = new StaticText();

    public StaticText getTypeStaticText() {
        return typeStaticText;
    }

    public void setTypeStaticText(StaticText st) {
        this.typeStaticText = st;
    }
    private StaticText ISBNStaticText = new StaticText();

    public StaticText getISBNStaticText() {
        return ISBNStaticText;
    }

    public void setISBNStaticText(StaticText st) {
        this.ISBNStaticText = st;
    }
    private Table searchListTable = new Table();

    public Table getSearchListTable() {
        return searchListTable;
    }

    public void setSearchListTable(Table t) {
        this.searchListTable = t;
    }
    private DefaultTableDataProvider defaultTableDataProvider = new DefaultTableDataProvider();

    public DefaultTableDataProvider getDefaultTableDataProvider() {
        return defaultTableDataProvider;
    }

    public void setDefaultTableDataProvider(DefaultTableDataProvider dtdp) {
        this.defaultTableDataProvider = dtdp;
    }
    private Button loginButton = new Button();

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button b) {
        this.loginButton = b;
    }
    private Button logoutButton = new Button();

    public Button getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(Button b) {
        this.logoutButton = b;
    }
    private Button userMainButton = new Button();

    public Button getUserMainButton() {
        return userMainButton;
    }

    public void setUserMainButton(Button b) {
        this.userMainButton = b;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PublicationSearch() {
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
            log("PublicationSearch Initialization Failure", e);
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
        
        // session에서 사용자 id를 구한다.
        String userID = getSessionBean1().getUserID() ;
        
        // 아직 로그인 한 상태가 아니면
        if ( userID == null ) {
            logoutButton.setText("로그아웃");

        }
        // 로그인을 한 상태이면
        else {
            logoutButton.setText(userID + " 로그아웃");
        }
        
        loginButton.setRendered(userID == null);
        logoutButton.setRendered(userID != null);
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public String searchButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
            
        // 도서를 검색하여 목록을 갱신한다.
        
        String title = (String) titleTextField.getValue() ;
        if ( title == null ) title = "" ;
        
        String author = (String) authorTextField.getValue() ;
        if ( author == null ) author = "" ;
        
        String publisher = (String) publisherTextField.getValue() ;
        if ( publisher == null ) publisher = "" ;
        
        String isbn = (String) ISBNTextField.getValue() ;
        if ( isbn == null ) isbn = "" ;
        
        boolean isBook = bookCheckBox.isChecked();
        boolean isPeriodical = periodicalCheckBox.isChecked() ;
        
        PublicationType type ;
        if ( isBook && isPeriodical )
            type = PublicationType.All ;
        else if ( isBook )
            type = PublicationType.Book ;
        else if ( isPeriodical )
            type = PublicationType.Periodical ;
        else
            type = PublicationType.All ;
        
        String output ;
        
        getSessionBean1().getPublicationDataProvider().getList().clear(); 
        
        try {
            
            Collection<PublicationInfo> publications = publicationSearchBean.findPublicationInfos(type, title, author, isbn, publisher) ;
            
            for ( PublicationInfo p : publications ) {
                
                getSessionBean1().getPublicationDataProvider().getList().add(p);
                
            }
            output = null ;
        }
        
        catch ( Exception e ) {
            log("PublicationList::searchButton_action: " + e.getMessage()) ;
            output = null ;
        }
        
        return output ;
    }

    public String bookNameHyperlink_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        // 단행본, 정기간행물에 따라서 다른 화면을 보여 준다.
        
        PublicationType type = (PublicationType) typeStaticText.getValue() ;
        
        String ISBN = (String) ISBNStaticText.getValue() ;
         
         log("Trying to navigate:" + ISBN) ;

         getRequestBean1().putRequestValue("PublicationNumber", ISBN);
         
        if ( type == PublicationType.Book )
            return "bookDetailedView" ;
        else
            return "periodicalDetailedView" ;

    }

    public String loginButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        
        // 로그인화면으로 이동한다.
        // 로그인성공 후의 화면은 다시 도서검색화면이다.
        getSessionBean1().setAfterLoginPageOutput("searchList") ;
        
        return "login" ;
    }

    public String userMainButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
          
        log("cliked:" + (String)userMainButton.getText()) ;
        
        String id = (String) getSessionBean1().getUserID() ;
        
        // 아직 로그인을 하지 않은 것임; 로그인을 하도록 함
        if ( id == null || id.isEmpty() ) {
            log("Not yet logged on. Move to Login page") ;
            
            getSessionBean1().setAfterLoginPageOutput("userMain") ;
            
            return "login" ;
        }
        // 로그인을 한 상태이므로 개인정보관리 메인화면으로 이동함
        else {
            log("logged on already. Move to UserMain page") ;
            return "userMain" ;
        }
    }

    public String logoutButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        // 로그아웃을 한다.
        getSessionBean1().setUserID(null) ;
        
        // 다시 현재 화면을 보여 준다.
        return null;
    }
    
}

