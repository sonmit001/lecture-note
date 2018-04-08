/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.borrowandreturn.borrowandreturnsystem;

import javax.ejb.EJB;
import lms.borrowandreturn.Return.BookReturnMgtRemote;
import lms.borrowandreturn.borrow.BookBorrowMgtRemote;

/**
 *
 * @author chae
 */
public class Main {

   @EJB
    private static BookBorrowMgtRemote bookBorrowMgtBean;
    
   @EJB
    private static BookReturnMgtRemote bookReturnMgtBean;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main() ;
        MainFrame mainFrame = new MainFrame(main) ;
        
        mainFrame.setVisible(true);
    }
    
    public String  borrowHandler(String userID, String registrationNumber) {
        
        System.out.println("Trying to borrow  book item of registration number: " + registrationNumber + " by userID: " + userID) ;
        
        try {
            bookBorrowMgtBean.borrowBookItem(userID, registrationNumber);
        
            return "도서 대출 성공 !" ;
        
        }
        catch ( Exception e ) {
            e.printStackTrace(); 
            return "도서 대출 실패 !" ;
            
        }  
    }
    
    public String  returnHandler(String registrationNumber) {
        
        System.out.println("Trying to return  book item of registration number: " + registrationNumber) ;
        
        try {
            bookReturnMgtBean.returnBookItem(registrationNumber);
        
            return "도서 반납 성공 !" ;
        
        }
        catch ( Exception e ) {
            e.printStackTrace(); 
            
            return "도서 반납 실패 !" ;
        }  
    }
}
