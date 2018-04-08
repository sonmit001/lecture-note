/*
 * PublicationItemList.java
 *
 * Created on 2008. 6. 22, 오후 1:53:11
 */
 
package librarianweb.lms.book.publication;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.StaticText;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.FacesException;
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
public class PublicationItemList extends AbstractPageBean {
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
    private Button listButton = new Button();

    public Button getListButton() {
        return listButton;
    }

    public void setListButton(Button b) {
        this.listButton = b;
    }
    private Button registerButton = new Button();

    public Button getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(Button b) {
        this.registerButton = b;
    }
    private StaticText totalNumberStaticText = new StaticText();

    public StaticText getTotalNumberStaticText() {
        return totalNumberStaticText;
    }

    public void setTotalNumberStaticText(StaticText st) {
        this.totalNumberStaticText = st;
    }
    private StaticText ISBNTextField = new StaticText();

    public StaticText getISBNTextField() {
        return ISBNTextField;
    }

    public void setISBNTextField(StaticText st) {
        this.ISBNTextField = st;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PublicationItemList() {
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
            log("PublicationItemList Initialization Failure", e);
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
        
        if ( typeStaticText.getValue() ==  null ) {
            PublicationType type = (PublicationType) getRequestBean1().getRequestValue("PublicationType") ;
            String number = (String) getRequestBean1().getRequestValue("PublicationNumber") ;
        
             typeStaticText.setValue(type) ;
            ISBNStaticText.setValue(number) ;
         }

        log("PublicationItemList rendering start...") ;
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
        
        PublicationType type = (PublicationType) typeStaticText.getValue() ;
        String isbn = (String) ISBNStaticText.getValue() ;
        
        String author  = (String)authorStaticText.getValue() ;
        String title = (String)titleStaticText.getValue() ;
        String publisher = (String) publisherStaticText.getValue() ;
        
        getRequestBean1().putRequestValue("PublicationType", type);
         getRequestBean1().putRequestValue("PublicationNumber", isbn);
         getRequestBean1().putRequestValue("Author", author);
         getRequestBean1().putRequestValue("Title", title);
         getRequestBean1().putRequestValue("Publisher", publisher);
         
        // 개별도서등록 화면으로 이동한다.
        return "newItem";
    }

    public String searchButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        // 개별 도서 목록을 갱신시킨다.
        
        renderInputs( );
        
        return null;
    }

    public String removeButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        // 해당 개별 도서를 삭제한다.
        
        String isbn = (String) ISBNTextField.getValue() ;
        
        try {
            publicationMgtBean.removePublicationItem(isbn);
        }
        catch ( Exception e ) {
            log("Failed to remove Book Item " + isbn + " " + e.getMessage()) ;
        }
        
        // 목록이 갱신되고 있다.
        return null;
    }
    
    
    void renderInputs() {
        
         PublicationType type = (PublicationType) typeStaticText.getValue() ;
         String number = (String) ISBNStaticText.getValue() ;
        
        //log("PublicationItemList for: " + "type: " + type + "ISBN: " + number) ;
        
        PublicationInfo publicationInfo = publicationSearchBean.findPublicationInfoByKey(type, number) ;

         authorStaticText.setValue(publicationInfo.getAuthor()) ;
         titleStaticText.setValue(publicationInfo.getTitle()) ;
         publisherStaticText.setValue(publicationInfo.getPublisher()) ;
         
        int numberOfItems = 0 ;
        
        try {
            Collection<BookItemInfo> bookItemInfos = publicationSearchBean.findBookItemInfosByID(number) ;
            
            numberOfItems = bookItemInfos.size() ;
                     
            getSessionBean1().getBookItemDataProvider().getList().clear(); 
            
            for ( BookItemInfo bi : bookItemInfos ) {
                //log("Book Item Found: " + bi) ;
                
                getSessionBean1().getBookItemDataProvider().getList().add(bi);
            }  
        }
        
        catch ( Exception e ) {
            log(e.getMessage()) ;
        }
         
         totalNumberStaticText.setValue(numberOfItems);

    }
    
    
}

