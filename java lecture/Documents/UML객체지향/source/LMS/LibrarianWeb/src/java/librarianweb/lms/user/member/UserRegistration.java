/*
 * UserRegistration.java
 *
 * Created on 2008. 6. 23, 오전 1:12:33
 */
 
package librarianweb.lms.user.member;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.RadioButtonGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import librarianweb.RequestBean1;
import librarianweb.ApplicationBean1;
import librarianweb.SessionBean1;
import lms.common.type.UserInfo;
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
public class UserRegistration extends AbstractPageBean {
    @EJB
    private UserMgtRemote userMgtBean;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        userTypeRadioButtonGroupDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("학생", "학생"), new com.sun.webui.jsf.model.Option("직원", "직원"), new com.sun.webui.jsf.model.Option("교수", "교수")});
    }
    private SingleSelectOptionsList userTypeRadioButtonGroupDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUserTypeRadioButtonGroupDefaultOptions() {
        return userTypeRadioButtonGroupDefaultOptions;
    }

    public void setUserTypeRadioButtonGroupDefaultOptions(SingleSelectOptionsList ssol) {
        this.userTypeRadioButtonGroupDefaultOptions = ssol;
    }
    private RadioButtonGroup userTypeRadioButtonGroup = new RadioButtonGroup();

    public RadioButtonGroup getUserTypeRadioButtonGroup() {
        return userTypeRadioButtonGroup;
    }

    public void setUserTypeRadioButtonGroup(RadioButtonGroup rbg) {
        this.userTypeRadioButtonGroup = rbg;
    }
    private TextField idTextField = new TextField();

    public TextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(TextField tf) {
        this.idTextField = tf;
    }
    private TextField password1TextField = new TextField();

    public TextField getPassword1TextField() {
        return password1TextField;
    }

    public void setPassword1TextField(TextField tf) {
        this.password1TextField = tf;
    }
    private TextField password2TextField = new TextField();

    public TextField getPassword2TextField() {
        return password2TextField;
    }

    public void setPassword2TextField(TextField tf) {
        this.password2TextField = tf;
    }
    private TextField nameTextField = new TextField();

    public TextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(TextField tf) {
        this.nameTextField = tf;
    }
    private TextField deptTextField = new TextField();

    public TextField getDeptTextField() {
        return deptTextField;
    }

    public void setDeptTextField(TextField tf) {
        this.deptTextField = tf;
    }
    private TextField phoneTextField = new TextField();

    public TextField getPhoneTextField() {
        return phoneTextField;
    }

    public void setPhoneTextField(TextField tf) {
        this.phoneTextField = tf;
    }
    private TextField addressTextField = new TextField();

    public TextField getAddressTextField() {
        return addressTextField;
    }

    public void setAddressTextField(TextField tf) {
        this.addressTextField = tf;
    }
    private TextField emailTextField = new TextField();

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(TextField tf) {
        this.emailTextField = tf;
    }
    private TextField organizationTextField = new TextField();

    public TextField getOrganizationTextField() {
        return organizationTextField;
    }

    public void setOrganizationTextField(TextField tf) {
        this.organizationTextField = tf;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public UserRegistration() {
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
            log("UserRegistration Initialization Failure", e);
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
        
        userTypeRadioButtonGroup.setValue("학생");
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

    public void typeRadioButtonGroup_processValueChange(ValueChangeEvent vce) {
    }

    public String registerButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        String typeStr = (String) userTypeRadioButtonGroup.getValue() ;
        UserType type ;
        
        if ( typeStr.compareToIgnoreCase("학생")==0)
            type = UserType.Student ;
        else if ( typeStr.compareToIgnoreCase("직원")==0)
            type = UserType.Staff ;
        else if ( typeStr.compareToIgnoreCase("교수")==0)
            type = UserType.Professor ;
        else
            type = UserType.Student ;
            
        
        String id = (String) idTextField.getValue() ;
        String password = (String) password1TextField.getValue() ;
        String name = (String) nameTextField.getValue() ;
        
        String email = (String) emailTextField.getValue() ;
        String address = (String) addressTextField.getValue() ;
        String phone = (String) phoneTextField.getValue() ;
        
        String dept = (String) deptTextField.getValue() ;
        String organization = (String) organizationTextField.getValue() ;
        
        UserInfo userInfo = new UserInfo() ;
        userInfo.setId(id);
        userInfo.setUserType(type) ;
        userInfo.setPassword(password);
        userInfo.setName(name);
        userInfo.setEmail(email);
        userInfo.setAddress(address); ;
        userInfo.setPhone(phone);
        userInfo.setDept(dept);
        userInfo.setOrganization(organization);
        
        try {
            
            userMgtBean.registerUser(userInfo);
        }
        catch (Exception e) {
            log("Register User: " + e.getMessage()) ;
        }
        
        return "userList";
    }

    public String gotoUserListPage_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return "userList" ;
    }
    
}

