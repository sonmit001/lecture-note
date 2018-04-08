/*
 * UserList.java
 *
 * Created on 2008. 6. 23, 오전 12:45:39
 */
 
package librarianweb.lms.user.member;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TextField;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.FacesException;
import librarianweb.RequestBean1;
import librarianweb.ApplicationBean1;
import librarianweb.SessionBean1;
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
public class UserList extends AbstractPageBean {
    @EJB
    private UserMgtRemote userMgtBean;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private TextField idTextField = new TextField();

    public TextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(TextField tf) {
        this.idTextField = tf;
    }
    private TextField nameTextField = new TextField();

    public TextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(TextField tf) {
        this.nameTextField = tf;
    }
    private Button removeButton = new Button();

    public Button getRemoveButton() {
        return removeButton;
    }

    public void setRemoveButton(Button b) {
        this.removeButton = b;
    }
    private TableColumn tableColumn6 = new TableColumn();

    public TableColumn getTableColumn6() {
        return tableColumn6;
    }

    public void setTableColumn6(TableColumn tc) {
        this.tableColumn6 = tc;
    }
    private StaticText searchedUserIDStaticText = new StaticText();

    public StaticText getSearchedUserIDStaticText() {
        return searchedUserIDStaticText;
    }

    public void setSearchedUserIDStaticText(StaticText st) {
        this.searchedUserIDStaticText = st;
    }
    private Button bookBorrowStatusButton = new Button();

    public Button getBookBorrowStatusButton() {
        return bookBorrowStatusButton;
    }

    public void setBookBorrowStatusButton(Button b) {
        this.bookBorrowStatusButton = b;
    }
    private StaticText searchedUserNameStaticText = new StaticText();

    public StaticText getSearchedUserNameStaticText() {
        return searchedUserNameStaticText;
    }

    public void setSearchedUserNameStaticText(StaticText st) {
        this.searchedUserNameStaticText = st;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public UserList() {
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
            log("UserList Initialization Failure", e);
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

    public String registerButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return "newUser";
    }

    public String searchButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        
        String  id = (String) idTextField.getValue() ;
        if ( id == null ) id = "" ;
        
        String name = (String) nameTextField.getValue() ;
        if ( name == null ) name = "" ;
        
        try {
            
            Collection<UserInfo> users = userMgtBean.findUserInfosByNameAndID(name, id) ;
                     
            getSessionBean1().getUserDataProvider().getList().clear(); 

         for ( UserInfo u : users ) {
                
                getSessionBean1().getUserDataProvider().getList().add(u);
                
            }
        }
        
        catch ( Exception e ) {
            log("UserList::searchButton_action: " + e.getMessage()) ;
            
        }
        
        return null;
    }

    public String removeButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        // 선택된 사용자를 삭제한다.
        
        String searchedUserID = (String) searchedUserIDStaticText.getValue() ;
         
         try {
             
             // 지금은 관련된 대출정보, 도서주문정보도 삭제된다.
             // 향후에 관련된 대출정보, 도서주문정보가 있는 지를 확인하도록 보완되어야 한다.
            userMgtBean.removeUser(searchedUserID) ;
         }
         catch ( Exception e ) {
                log(e.getMessage()) ;
        
        }

        return null;
    }

    public String bookBorrowStatusButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        // 해당 사용자의 대출 상황 정보를 보여 준다.
        
        String searchedUserID = (String) searchedUserIDStaticText.getValue() ;
        String searchedUserName = (String) searchedUserNameStaticText.getValue() ;

        getRequestBean1().putRequestValue("userID", searchedUserID) ;
        getRequestBean1().putRequestValue("userName", searchedUserName) ;
        
        // 해당 사용자에 대한 도서대출정보 화면을 보여준다.
        return "bookBorrowStatus" ;
    }

   
}

