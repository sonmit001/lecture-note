/*
 * BorrowRequest.java
 *
 * Created on 2008. 6. 23, 오전 12:23:13
 */
 
package borrowerweb.lms.borrowandreturn;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.StaticText;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.FacesException;
import borrowerweb.RequestBean1;
import borrowerweb.ApplicationBean1;
import borrowerweb.SessionBean1;
import lms.book.publication.PublicationSearchRemote;
import lms.borrowandreturn.borrow.BookBorrowMgtRemote;
import lms.common.exception.UnknownBookIDException;
import lms.common.exception.UnknownUserIDException;
import lms.common.type.PublicationInfo;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author chae
 */
public class BorrowRequest extends AbstractPageBean {
    @EJB
    private BookBorrowMgtRemote bookBorrowMgtBean;
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
    private StaticText locationStaticText = new StaticText();

    public StaticText getLocationStaticText() {
        return locationStaticText;
    }

    public void setLocationStaticText(StaticText st) {
        this.locationStaticText = st;
    }
    private StaticText borrowDueStaticText = new StaticText();

    public StaticText getBorrowDueStaticText() {
        return borrowDueStaticText;
    }

    public void setBorrowDueStaticText(StaticText st) {
        this.borrowDueStaticText = st;
    }
    private Button borrowRequestButton = new Button();

    public Button getBorrowRequestButton() {
        return borrowRequestButton;
    }

    public void setBorrowRequestButton(Button b) {
        this.borrowRequestButton = b;
    }
    private Button gotoBookDetailedViewPageButton = new Button();

    public Button getGotoBookDetailedViewPageButton() {
        return gotoBookDetailedViewPageButton;
    }

    public void setGotoBookDetailedViewPageButton(Button b) {
        this.gotoBookDetailedViewPageButton = b;
    }
    private StaticText registrationNumberStaticText = new StaticText();

    public StaticText getRegistrationNumberStaticText() {
        return registrationNumberStaticText;
    }

    public void setRegistrationNumberStaticText(StaticText st) {
        this.registrationNumberStaticText = st;
    }
    private StaticText resultStaticText = new StaticText();

    public StaticText getResultStaticText() {
        return resultStaticText;
    }

    public void setResultStaticText(StaticText st) {
        this.resultStaticText = st;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public BorrowRequest() {
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
            log("BorrowRequest Initialization Failure", e);
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
         
        String registrationNumber = (String) getRequestBean1().getRequestValue("RegistrationNumber") ;   
        try {
            PublicationInfo info = publicationSearchBean.findPublicationInfoByBookItemID(registrationNumber) ;
            
            ISBNStaticText.setValue(info.getPublicationNumber()) ;
            titleStaticText.setValue(info.getTitle());
            authorStaticText.setValue(info.getAuthor());
            publisherStaticText.setValue(info.getPublisher()) ;
            publicationDateStaticText.setValue(info.getPublicationDate());
            
            registrationNumberStaticText.setValue(registrationNumber);
            String location = publicationSearchBean.getPublicationItemLocation(registrationNumber) ;
            locationStaticText.setValue(location);
            
            Calendar today  = Calendar.getInstance();
            Date requestedDate = today.getTime() ;
            Date expectedDate = bookBorrowMgtBean.getBorrowExpectedDate(requestedDate) ;
            borrowDueStaticText.setValue(expectedDate) ;
        }
        catch ( Exception e ) {
            log("Failed to get publication info by registration number: " + registrationNumber + ": " + e.getMessage()) ;
        }
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

    public String borrowRequestButton_action() {
        
        // 대출신청을 한다.
        
        String userID = (String) getSessionBean1().getUserID() ;
        assert userID != null && userID.isEmpty() ;
        
        if ( userID == null || userID.isEmpty() ) {
            log("borrowRequestButton_action: Not logged Yet") ;
            return null ;
        }
        
        String registrationNumber = (String) registrationNumberStaticText.getValue() ;
        assert registrationNumber != null && registrationNumber.isEmpty() ;
        
        try {
            bookBorrowMgtBean.requestBorrow(userID, registrationNumber) ;
            resultStaticText.setValue((String) "대출 신청 성공 !");
        }
        catch (Exception e) {
            resultStaticText.setValue((String) e.getMessage());
        }
        finally {
        
            // 다시 현재화면을 보여 준다. 현재 화면에 표시될 도서등록번호를 RequestBean에 넘긴다.
            getRequestBean1().putRequestValue("RegistrationNumber", registrationNumber) ;   
            
            return null ;
        }
    }

    public String gotoBookDetailedViewPageButton_action() {
        String ISBN = (String) ISBNStaticText.getValue() ;
        getRequestBean1().putRequestValue("PublicationNumber", ISBN);
        
        return "bookDetailedView";
    }
    
}

