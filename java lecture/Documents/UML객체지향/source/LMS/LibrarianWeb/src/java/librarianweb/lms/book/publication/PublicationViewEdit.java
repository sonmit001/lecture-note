/*
 * PublicationDetail.java
 *
 * Created on 2008. 6. 22, 오전 1:17:31
 */
 
package librarianweb.lms.book.publication;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Alert;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.HiddenField;
import com.sun.webui.jsf.component.MessageGroup;
import com.sun.webui.jsf.component.RadioButtonGroup;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import librarianweb.SessionBean1;
import librarianweb.RequestBean1;
import librarianweb.ApplicationBean1;
import lms.book.publication.PublicationMgtRemote;
import lms.book.publication.PublicationSearchRemote;
import lms.common.type.BookInfo;
import lms.common.type.PeriodicalInfo;
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
public class PublicationViewEdit extends AbstractPageBean {
    @EJB
    private PublicationMgtRemote publicationMgtBean;
    @EJB
    private PublicationSearchRemote publicationSearchBean;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        subscribedRadioButtonGroupDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("true", "구독 함"), new com.sun.webui.jsf.model.Option("false", "구독 안함")});
    }
    private SingleSelectOptionsList subscribedRadioButtonGroupDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getSubscribedRadioButtonGroupDefaultOptions() {
        return subscribedRadioButtonGroupDefaultOptions;
    }

    public void setSubscribedRadioButtonGroupDefaultOptions(SingleSelectOptionsList ssol) {
        this.subscribedRadioButtonGroupDefaultOptions = ssol;
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
    private Alert alert = new Alert();

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert a) {
        this.alert = a;
    }
    private Button okButton = new Button();

    public Button getOkButton() {
        return okButton;
    }

    public void setOkButton(Button b) {
        this.okButton = b;
    }
    private Button cancelButton = new Button();

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button b) {
        this.cancelButton = b;
    }
    private MessageGroup msgGroup = new MessageGroup();

    public MessageGroup getMsgGroup() {
        return msgGroup;
    }

    public void setMsgGroup(MessageGroup mg) {
        this.msgGroup = mg;
    }
    private StaticText pageTitleStaticText = new StaticText();

    public StaticText getPageTitleStaticText() {
        return pageTitleStaticText;
    }

    public void setPageTitleStaticText(StaticText st) {
        this.pageTitleStaticText = st;
    }
    private HiddenField editableHidden = new HiddenField();

    public HiddenField getEditableHidden() {
        return editableHidden;
    }

    public void setEditableHidden(HiddenField hf) {
        this.editableHidden = hf;
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
    public PublicationViewEdit() {
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
            log("PublicationDetail Initialization Failure", e);
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
        
        boolean editable = (Boolean) getRequestBean1().getRequestValue("editable") ;
        
        //log("Editable Value at prerender: " + editable ) ;
        
        
        if ( typeStaticText.getValue() ==  null ) {
            String type = (String) getRequestBean1().getRequestValue("PublicationType") ;
            String number = (String) getRequestBean1().getRequestValue("PublicationNumber") ;
        
            typeStaticText.setValue(type) ;
            ISBNStaticText.setValue(number) ;
         }        
        
        renderInputs(editable) ;
        
        editableHidden.setText(editable); 
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

    public void typeRadioButtonGroup_processValueChange(ValueChangeEvent vce) {
    }

    public String okButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        boolean editable = (Boolean) editableHidden.getText() ;
        
        //log("Editable Value Before OK: " +  editable  ) ;
        
         
        String type = (String) typeStaticText.getValue() ;
        String number = (String) ISBNStaticText.getText() ;
        
        getRequestBean1().putRequestValue("PublicationType", type);
        getRequestBean1().putRequestValue("PublicationNumber", number);
        
        if ( editable ) {
            // 수정 화면에서 확인을 누르면 수정을 한 후에 다시 조회를 해 준다.
            // 먼저 수정을 해야 한다.
            
            
            String title = (String) titleTextField.getText() ;
            String author = (String) authorTextField.getText() ;
            String publicationNumber = (String) ISBNStaticText.getText() ;
            String publisher = (String) publisherTextField.getText() ;
            Date publicationDate = (Date) publicationDateCalendar.getSelectedDate() ;
               
            try {
                if ( type.compareToIgnoreCase("단행본")==0) {
                    
                    int page = (Integer) pageTextField.getValue() ;

                    BookInfo info = new BookInfo(author, title, publicationNumber, publisher, publicationDate, page) ;

                    log("Trying to update  book: " + info) ;
                    publicationMgtBean.updateBook(info) ;
                }
                else {

                    String subscribed = (String) subscribedRadioButtonGroup.getValue() ;
                    boolean isSubscribed = subscribed.compareToIgnoreCase("true") == 0 ? true : false ;

                    PeriodicalInfo info = new PeriodicalInfo(author, title, publicationNumber, publisher, publicationDate, isSubscribed) ;

                    log("Trying to update  Periodical: " + info) ;

                    publicationMgtBean.updatePeriodical(info) ;
                }
            }
            catch ( Exception e ) {
                alert.setSummary(e.getMessage()) ;

            }
            
        }
        else {
            // 조회화면에서 "확인"을 누르면 수정 화면을 보여 준다.
        }
        
        // 수정 <--> 조회
        editable = ! editable ;
        getRequestBean1().putRequestValue("editable", editable);
        
        //log("Editable Value After OK: " +  (Boolean) getRequestBean1().getRequestValue("editable")  ) ;
        
        // 현재 화면을 다시 표시한다.
        return null  ;
        
    }

    public String cancelButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        boolean editable = (Boolean) editableHidden.getText() ;
        
        if ( editable ) {
            // 수정 화면에서 취소를 누르면 목록으로 간다.
            
            return "list" ;
        }
        else {
            // 조회화면에서 취소를 누르면 목록으로 간다.
            
            return "list" ;
            
        }
        
    }
    
    void renderInputs(boolean editable) {
        
        String type = (String) typeStaticText.getValue() ;
        String number = (String) ISBNStaticText.getText() ;

        //log("ViewEdit page for: " + "type: " + type + "ISBN: " + number + " for " + editable) ;
        
        // 을 바탕으로 Publication 정보를 구한다.
        
        PublicationType typeEnum = type.compareToIgnoreCase("단행본") == 0 ? PublicationType.Book : PublicationType.Periodical ;
        PublicationInfo info = publicationSearchBean.findPublicationInfoByKey(typeEnum, number) ;
        
        log("Search Result: " + info) ;

        
        titleTextField.setText(info.getTitle()) ;
        authorTextField.setText(info.getAuthor()) ;
        publisherTextField.setText(info.getPublisher()) ;
        publicationDateCalendar.setSelectedDate(info.getPublicationDate()) ;
        
        // 단행본, 연속간행물에 따라서 페이지수와 구동 여부를 추가적으로 구한다.
        
        if ( typeEnum == PublicationType.Book ) {
            
            int page = publicationSearchBean.getBookPage(number) ;
            pageTextField.setValue(page);
            
        }
        if ( typeEnum == PublicationType.Periodical ) {
            boolean isSubscribed = publicationSearchBean.isPeriodicalSubscribed(number) ;
            subscribedRadioButtonGroup.setValid(isSubscribed);
            
            pageTextField.setDisabled(false); ;
            subscribedRadioButtonGroup.setDisabled(true);
        }
                
        titleTextField.setDisabled(! editable); 
        authorTextField.setDisabled(! editable); 
        publisherTextField.setDisabled(! editable);         
        publicationDateCalendar.setDisabled(! editable); 
        
        pageTextField.setDisabled(!editable || typeEnum != PublicationType.Book);
        subscribedRadioButtonGroup.setDisabled(!editable || typeEnum != PublicationType.Periodical);
            
        
        if ( editable ) {
            pageTitleStaticText.setText("도서 정보 수정 화면") ;
            
            okButton.setText("수정 확인");
            cancelButton.setText("수정 취소") ;
        }
        else {
            pageTitleStaticText.setText("도서 정보 조회 화면") ;
            
            okButton.setText("도서 정보 수정");
            cancelButton.setText("도서 정보 관리 화면") ;
        }
        
        //log("AFTER ViewEdit page for: " + "type: " + type + "ISBN: " + number + " for " + editable) ;
    }
    
    
}

