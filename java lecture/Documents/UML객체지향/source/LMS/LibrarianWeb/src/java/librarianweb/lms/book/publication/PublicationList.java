/*
 * PublicationList.java
 *
 * Created on 2008. 6. 21, 오후 7:15:55
 */
 
package librarianweb.lms.book.publication;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TextField;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import librarianweb.SessionBean1;
import librarianweb.ApplicationBean1;
import librarianweb.RequestBean1;
import lms.book.publication.PublicationMgtRemote;
import lms.book.publication.PublicationSearchRemote;
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
public class PublicationList extends AbstractPageBean {
    
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
    private Table searchListTable = new Table();

    public Table getSearchListTable() {
        return searchListTable;
    }

    public void setSearchListTable(Table t) {
        this.searchListTable = t;
    }
    private Hyperlink bookNameHyperlink = new Hyperlink();

    public Hyperlink getBookNameHyperlink() {
        return bookNameHyperlink;
    }

    public void setBookNameHyperlink(Hyperlink h) {
        this.bookNameHyperlink = h;
    }
    private Button removeButton = new Button();

    public Button getRemoveButton() {
        return removeButton;
    }

    public void setRemoveButton(Button b) {
        this.removeButton = b;
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

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PublicationList() {
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
            log("PublicationList Initialization Failure", e);
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
        
        // 기존의 검색어가 있으면 다시 자동으로 검색을 하도록 한다.
                
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

    public void typeRadioButtonGroup_processValueChange(ValueChangeEvent vce) {
    }

    public String registerButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return "register";
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
        

        log("Trying to search") ;
        String output ;
        
        getSessionBean1().getPublicationDataProvider().getList().clear(); 
        
        try {
            
           Collection<PublicationInfo> publications = publicationSearchBean.findPublicationInfos(type, title, author, isbn, publisher) ;
            
            for ( PublicationInfo p : publications ) {
                //log("Found: " + p) ;
                
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
        
        log("cliked:" + (String)bookNameHyperlink.getText()) ;
        
        
        PublicationType type = (PublicationType) typeStaticText.getValue() ;
        String ISBN = (String) ISBNStaticText.getValue() ;
        
         log("Trying to navigate:" + ISBN ) ;    

         getRequestBean1().putRequestValue("PublicationType", type == PublicationType.Book ? "단행본" : "연속간행물") ;
         getRequestBean1().putRequestValue("PublicationNumber", ISBN);
         getRequestBean1().putRequestValue("editable", false);
         
         return "view" ;
    }

    public String removeButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        PublicationType type = (PublicationType) typeStaticText.getValue() ;
        String ISBN = (String) ISBNStaticText.getValue() ;
        
         log("Trying to remove:" + ISBN ) ;
         
         try {
             
             // 지금은 관련된 개별도서도 모두 삭제된다.
             // 관련된 개별 도서가 없을 때만 확인하도록 수정할 필요가 있다.
            publicationMgtBean.removePublication(type, ISBN) ;
         }
         catch ( Exception e ) {
                log(e.getMessage()) ;
        
        }
         
         // 현재 화면을 다시 표시한다.
         
        searchButton_action() ;
        
        return null;
    }

    public String itemListButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.        
        
        PublicationType type = (PublicationType) typeStaticText.getValue() ;
        String ISBN = (String) ISBNStaticText.getValue() ;
        
         log("Trying to list items:" + ISBN) ;
         
         getRequestBean1().putRequestValue("PublicationType", type);
         getRequestBean1().putRequestValue("PublicationNumber", ISBN);
         
        return "itemList";
    }

    public String newItemButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        PublicationType type = (PublicationType) typeStaticText.getValue() ;
        String ISBN = (String) ISBNStaticText.getValue() ;
        
         log("Trying to insert item for: " + ISBN) ;
         
         getRequestBean1().putRequestValue("PublicationType", type);
         getRequestBean1().putRequestValue("PublicationNumber", ISBN);
         
        return "newItem";
       
    }
    
}