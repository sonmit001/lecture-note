/*
 * PublicationItemRegistration.java
 *
 * Created on 2008. 6. 22, 오후 1:46:51
 */
 
package librarianweb.lms.book.publication;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Alert;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.MessageGroup;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TextField;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import librarianweb.RequestBean1;
import librarianweb.ApplicationBean1;
import librarianweb.SessionBean1;
import lms.book.publication.PublicationMgtRemote;
import lms.book.publication.PublicationSearchRemote;
import lms.common.type.BookItemInfo;
import lms.common.type.PublicationInfo;
import lms.common.type.PublicationType;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author chae
 */
public class PublicationItemRegistration extends AbstractPageBean {
    @EJB
    private PublicationSearchRemote publicationSearchBean;
    @EJB
    private PublicationMgtRemote publicationMgtBean;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
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
    private StaticText titleStaticText = new StaticText();

    public StaticText getTitleStaticText() {
        return titleStaticText;
    }

    public void setTitleStaticText(StaticText st) {
        this.titleStaticText = st;
    }
    private StaticText authorStaticText = new StaticText();

    public StaticText getAuthorStaticText() {
        return authorStaticText;
    }

    public void setAuthorStaticText(StaticText st) {
        this.authorStaticText = st;
    }
    private StaticText publisherStaticText = new StaticText();

    public StaticText getPublisherStaticText() {
        return publisherStaticText;
    }

    public void setPublisherStaticText(StaticText st) {
        this.publisherStaticText = st;
    }
    private TextField registrationNumberTextField = new TextField();

    public TextField getRegistrationNumberTextField() {
        return registrationNumberTextField;
    }

    public void setRegistrationNumberTextField(TextField tf) {
        this.registrationNumberTextField = tf;
    }
    private TextField locationTextField = new TextField();

    public TextField getLocationTextField() {
        return locationTextField;
    }

    public void setLocationTextField(TextField tf) {
        this.locationTextField = tf;
    }
    private Calendar registrationDateCalendar = new Calendar();

    public Calendar getRegistrationDateCalendar() {
        return registrationDateCalendar;
    }

    public void setRegistrationDateCalendar(Calendar c) {
        this.registrationDateCalendar = c;
    }
    private Button registerButton = new Button();

    public Button getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(Button b) {
        this.registerButton = b;
    }
    private Alert alert = new Alert();

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert a) {
        this.alert = a;
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
    public PublicationItemRegistration() {
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
            log("PublicationItemRegistration Initialization Failure", e);
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
        
        PublicationType type = (PublicationType) getRequestBean1().getRequestValue("PublicationType") ;
        String number = (String) getRequestBean1().getRequestValue("PublicationNumber") ;

        assert number != null ;
        
        PublicationInfo info = publicationSearchBean.findPublicationInfoByKey(type, number) ;
        
        
         String author = info.getAuthor() ;
         String title = info.getTitle() ;
         String publisher = info.getPublisher() ;
        
        
         typeStaticText.setValue(type) ;
         ISBNStaticText.setValue(number) ;
         
         authorStaticText.setValue(author);
         titleStaticText.setValue(title); 
         publisherStaticText.setValue(publisher);
         
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
        
        // 새 개별 도서를 등록한다.
        // typeStaticText 값에 따라서 도서 또는 정기간행물이다.
        
        PublicationType type = (PublicationType) typeStaticText.getValue() ;
        String isbn = (String) ISBNStaticText.getValue() ;
        
        String registrationNumber = (String) registrationNumberTextField.getValue() ;
        Date registrationDate = (Date) registrationDateCalendar.getSelectedDate() ;
        String location = (String) locationTextField.getValue() ;
        
        BookItemInfo newBookItem = new BookItemInfo(registrationNumber,  location,  registrationDate) ;
        
        log("Trying to register book item" + newBookItem + "with " + type + isbn) ;
        
        try {
            publicationMgtBean.registerBookItem(isbn, newBookItem);
        }
        catch ( Exception e ) {
            log("Failed to register book item" + newBookItem + "with " + type + isbn + ": " + e ) ;
        }
        
        log("Navigating to PublicationItemList with type: " + type + " ISBN: " + isbn) ;
        
        // PublicationItemList 화면으로 간다.
        getRequestBean1().putRequestValue("PublicationType", type);
        getRequestBean1().putRequestValue("PublicationNumber", isbn);
         
        return "itemList";
    }

    public String publicationItemListButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        PublicationType type = (PublicationType) typeStaticText.getValue() ;
        String isbn = (String) ISBNStaticText.getValue() ;
        
        log("Navigating to PublicationItemList with type: " + type + " ISBN: " + isbn) ;
        
        // PublicationItemList 화면으로 간다.
        getRequestBean1().putRequestValue("PublicationType", type);
        getRequestBean1().putRequestValue("PublicationNumber", isbn);
        
        return "itemList";
    }
    
}

