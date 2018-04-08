/*
 * PublicationDetailedView.java
 *
 * Created on 2008. 6. 22, 오후 10:21:06
 */
 
package borrowerweb.lms.book.search;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.StaticText;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.convert.DateTimeConverter;
import borrowerweb.RequestBean1;
import borrowerweb.ApplicationBean1;
import borrowerweb.SessionBean1;
import lms.book.publication.PublicationSearchRemote;
import lms.common.type.BookItemInfo;
import lms.common.type.BookItemStatus;
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
public class BookDetailedView extends AbstractPageBean {
    @EJB
    private PublicationSearchRemote publicationSearchBean;
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
    private StaticText publicationDateStaticText = new StaticText();

    public StaticText getPublicationDateStaticText() {
        return publicationDateStaticText;
    }

    public void setPublicationDateStaticText(StaticText st) {
        this.publicationDateStaticText = st;
    }
    private StaticText totalNumberStaticText = new StaticText();

    public StaticText getTotalNumberStaticText() {
        return totalNumberStaticText;
    }

    public void setTotalNumberStaticText(StaticText st) {
        this.totalNumberStaticText = st;
    }
    private Button borrowRequestButton = new Button();

    public Button getBorrowRequestButton() {
        return borrowRequestButton;
    }

    public void setBorrowRequestButton(Button b) {
        this.borrowRequestButton = b;
    }
    private StaticText registrationNumberStaticText = new StaticText();

    public StaticText getRegistrationNumberStaticText() {
        return registrationNumberStaticText;
    }

    public void setRegistrationNumberStaticText(StaticText st) {
        this.registrationNumberStaticText = st;
    }
    private StaticText bookItemStatusStaticText = new StaticText();

    public StaticText getBookItemStatusStaticText() {
        return bookItemStatusStaticText;
    }

    public void setBookItemStatusStaticText(StaticText st) {
        this.bookItemStatusStaticText = st;
    }
    private DateTimeConverter dateTimeConverter1 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter1() {
        return dateTimeConverter1;
    }

    public void setDateTimeConverter1(DateTimeConverter dtc) {
        this.dateTimeConverter1 = dtc;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public BookDetailedView() {
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
            log("PublicationDetailedView Initialization Failure", e);
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
            
            String number = (String) getRequestBean1().getRequestValue("PublicationNumber") ;
        
            ISBNStaticText.setValue(number) ;
         }

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

    public String searchButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return "searchList" ;
    }
    
     private void renderInputs() {
         
         String number = (String) ISBNStaticText.getValue() ;
        
        log("BookDetailedView for: " + "ISBN: " + number) ;
        
        PublicationInfo publicationInfo = publicationSearchBean.findPublicationInfoByKey(PublicationType.Book, number) ;

         authorStaticText.setValue(publicationInfo.getAuthor()) ;
         titleStaticText.setValue(publicationInfo.getTitle()) ;
         publisherStaticText.setValue(publicationInfo.getPublisher()) ;
         publicationDateStaticText.setValue(publicationInfo.getPublicationDate());
         
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

    public String borrowRequestButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        // login 성공하면 이것을 대출신청으로 전달할 수 있도록 해야 한다.
        
        String registrationNumber = (String) registrationNumberStaticText.getValue() ;
        getRequestBean1().putRequestValue("RegistrationNumber", registrationNumber);    
        
        String id = (String) getSessionBean1().getUserID() ;
        
        // 아직 로그인을 하지 않은 것임; 로그인을 하도록 함
        if ( id == null || id.isEmpty() ) {
            // 로그인이 성공하면 대출신청화면으로 이동함
            getSessionBean1().setAfterLoginPageOutput("borrowRequest");
            return "login" ;
        }
        // 로그인을 한 상태이므로 도서대출신청 화면으로 이동함
        else {
            // 해당 도서의 식별자(등록번호)를 구하고 이 개별도서를 대출신청할 수 있도록
            // BorrowRequest 화면을 보여 준다.
            // 이미 위에서 registrationNumber를 RequestBean에 넣었음.
            return "borrowRequest" ;
        }
    }
}

