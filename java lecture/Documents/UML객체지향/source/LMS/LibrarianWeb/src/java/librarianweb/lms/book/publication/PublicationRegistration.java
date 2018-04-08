/*
 * PublicationMain.java
 *
 * Created on 2008. 6. 21, 오후 3:01:56
 */
 
package librarianweb.lms.book.publication;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Alert;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.MessageGroup;
import com.sun.webui.jsf.component.RadioButtonGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import librarianweb.ApplicationBean1;
import librarianweb.RequestBean1;
import librarianweb.SessionBean1;
import lms.book.publication.PublicationMgtRemote;
import lms.common.type.BookInfo;
import lms.common.type.PeriodicalInfo;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author chae
 */
public class PublicationRegistration extends AbstractPageBean {
    @EJB
    private PublicationMgtRemote publicationMgtBean;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        typeRadioButtonGroupDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("단행본", "단행본"), new com.sun.webui.jsf.model.Option("연속간행물", "연속간행물")});
        subscribedRadioButtonGroupDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("true", "구독 함"), new com.sun.webui.jsf.model.Option("false", "구독 안함")});
        typeRadioButtonGroupDefaultOptions.setSelectedValue("연속간행물");
        subscribedRadioButtonGroupDefaultOptions.setSelectedValue("true");
    }
    private SingleSelectOptionsList typeRadioButtonGroupDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getTypeRadioButtonGroupDefaultOptions() {
        return typeRadioButtonGroupDefaultOptions;
    }

    public void setTypeRadioButtonGroupDefaultOptions(SingleSelectOptionsList ssol) {
        this.typeRadioButtonGroupDefaultOptions = ssol;
    }
    private SingleSelectOptionsList subscribedRadioButtonGroupDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getSubscribedRadioButtonGroupDefaultOptions() {
        return subscribedRadioButtonGroupDefaultOptions;
    }

    public void setSubscribedRadioButtonGroupDefaultOptions(SingleSelectOptionsList ssol) {
        this.subscribedRadioButtonGroupDefaultOptions = ssol;
    }
    private RadioButtonGroup typeRadioButtonGroup = new RadioButtonGroup();

    public RadioButtonGroup getTypeRadioButtonGroup() {
        return typeRadioButtonGroup;
    }

    public void setTypeRadioButtonGroup(RadioButtonGroup rbg) {
        this.typeRadioButtonGroup = rbg;
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
    private TextField pageTextField = new TextField();

    public TextField getPageTextField() {
        return pageTextField;
    }

    public void setPageTextField(TextField tf) {
        this.pageTextField = tf;
    }
    private RadioButtonGroup subscribedRadioButtonGroup = new RadioButtonGroup();

    public RadioButtonGroup getSubscribedRadioButtonGroup() {
        return subscribedRadioButtonGroup;
    }

    public void setSubscribedRadioButtonGroup(RadioButtonGroup rbg) {
        this.subscribedRadioButtonGroup = rbg;
    }
    private TextField publisherTextField = new TextField();

    public TextField getPublisherTextField() {
        return publisherTextField;
    }

    public void setPublisherTextField(TextField tf) {
        this.publisherTextField = tf;
    }
    private MessageGroup msgGroup = new MessageGroup();

    public MessageGroup getMsgGroup() {
        return msgGroup;
    }

    public void setMsgGroup(MessageGroup mg) {
        this.msgGroup = mg;
    }
    private Calendar publicationDateCalendar = new Calendar();

    public Calendar getPublicationDateCalendar() {
        return publicationDateCalendar;
    }

    public void setPublicationDateCalendar(Calendar c) {
        this.publicationDateCalendar = c;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PublicationRegistration() {
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
            log("PublicationMain Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        
        typeRadioButtonGroup.setValue("단행본") ;
        subscribedRadioButtonGroup.setValue("true") ;
        
        subscribedRadioButtonGroup.setDisabled(true);
        pageTextField.setDisabled(false) ;        
                
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
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }
    
    public String registerButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        String title = (String) titleTextField.getValue() ;
        String author = (String) authorTextField.getValue() ;
        String publicationNumber = (String) ISBNTextField.getValue() ;
        String publisher = (String) publisherTextField.getValue() ;
        Date publicationDate = (Date) publicationDateCalendar.getSelectedDate() ;
          
        String type = (String) typeRadioButtonGroup.getValue() ;
        
        String output ;
        try {
            if ( type.compareToIgnoreCase("단행본") == 0 ) {
                int page = new Integer((String) pageTextField.getText()).intValue() ;

                BookInfo info = new BookInfo(author, title, publicationNumber, publisher, publicationDate, page) ;
                
                log("Trying to register book: " + info) ;
                publicationMgtBean.registerBook(info) ;
            }
            else {

                String subscribed = (String) subscribedRadioButtonGroup.getValue() ;
                boolean isSubscribed = subscribed.compareToIgnoreCase("true") == 0 ? true : false ;

                PeriodicalInfo info = new PeriodicalInfo(author, title, publicationNumber, publisher, publicationDate, isSubscribed) ;
                
                log("Trying to register Periodical: " + info) ;
                
                publicationMgtBean.registerPeriodical(info) ;
            }
            
            // 도서 등록이 성공하면 등록된 도서 정보를 표시하도록 한다.
                
             getRequestBean1().putRequestValue("PublicationType", type);
             getRequestBean1().putRequestValue("PublicationNumber", publicationNumber);
             getRequestBean1().putRequestValue("editable", false);
             
             return "view" ;

        }
        catch ( Exception e ) {
            //alert.setSummary(e.getMessage()) ;
            log("Failed to register publication" + author + publicationNumber) ;
            output = null ;
        }
        
        return output ;
    }

    public void typeRadioButtonGroup_processValueChange(ValueChangeEvent vce) {
        
        
         String type = (String) typeRadioButtonGroup.getValue() ;
         
        
        if ( type.compareToIgnoreCase("단행본") == 0 ) {
         
            subscribedRadioButtonGroup.setDisabled(true);
            pageTextField.setDisabled(false);
        }
        else {
             
            subscribedRadioButtonGroup.setDisabled(false);
            pageTextField.setDisabled(true);
        }
        
    }
    
}

