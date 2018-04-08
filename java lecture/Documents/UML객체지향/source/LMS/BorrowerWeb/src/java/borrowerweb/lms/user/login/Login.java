/*
 * Login.java
 *
 * Created on 2008. 6. 24, 오전 2:04:41
 */
 
package borrowerweb.lms.user.login;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.HiddenField;
import com.sun.webui.jsf.component.MessageGroup;
import com.sun.webui.jsf.component.PasswordField;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TextField;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import borrowerweb.ApplicationBean1;
import borrowerweb.SessionBean1;
import borrowerweb.RequestBean1;
import lms.common.type.UserType;
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
public class Login extends AbstractPageBean {
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
    private HiddenField registrationNumberHiddenField = new HiddenField();

    public HiddenField getRegistrationNumberHiddenField() {
        return registrationNumberHiddenField;
    }

    public void setRegistrationNumberHiddenField(HiddenField hf) {
        this.registrationNumberHiddenField = hf;
    }
    private PasswordField passwordPassword = new PasswordField();

    public PasswordField getPasswordPassword() {
        return passwordPassword;
    }

    public void setPasswordPassword(PasswordField pf) {
        this.passwordPassword = pf;
    }
    private MessageGroup msgGroup = new MessageGroup();

    public MessageGroup getMsgGroup() {
        return msgGroup;
    }

    public void setMsgGroup(MessageGroup mg) {
        this.msgGroup = mg;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Login() {
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
            log("Login Initialization Failure", e);
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
        // 도서 검색 후에 대출 신청을 하다가 로그인을 할 경우
        String registrationNumber = (String) getRequestBean1().getRequestValue("RegistrationNumber") ;
        System.out.println(registrationNumber) ;
        registrationNumberHiddenField.setValue(registrationNumber);
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public String loginButton_action() {   
        String id = (String) idTextField.getValue() ;
        String password = (String) passwordPassword.getValue() ;
        
        try {           
            boolean success = userMgtBean.login(id, password);

            if ( success ) {
                log("Login Success for user ID: " + id + " with password: " + password) ;
                
                // session에 기록을 한다.
                getSessionBean1().setUserID(id);
            
                String nextPageOutput = getSessionBean1().getAfterLoginPageOutput() ;
                log("Next Page Output after Successful Login" +  nextPageOutput) ;
                assert nextPageOutput != null ;
        
                
                // 도서 검색 후에 대출 신청을 하는 중이었음; 대출신청화면으로 이동함
                if ( nextPageOutput.equals("borrowRequest") ) {
                    String registrationNumber = (String) registrationNumberHiddenField.getValue() ;
                    assert registrationNumber != null ;
                   
                     log("Move to the BorrowRequest Page with " + registrationNumber) ;
                    getRequestBean1().putRequestValue("RegistrationNumber", registrationNumber); 
                }
                // 그렇지 않으면 nextPageOutput에 따라서 다음 페이지로 이동함
                else {
                    log("No registration Number. So, move to next Page by " + nextPageOutput) ;
                }
                
                return nextPageOutput ;
            }
            // 로그인 실패이면 다시 현재 화면을 보여 준다.
            else {
                return null ;
            }
        }
        
        catch ( Exception e ) {
            log("Login Failed for user ID: " + id + " with password: " + password + e.getMessage()) ;
            return null ;
        }
    }

    public String btnReset_action() {
        idTextField.setValue(("")) ;
        passwordPassword.setValue("") ;
        return null;
    }

}

