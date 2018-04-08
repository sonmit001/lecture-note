/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package borrowerweb.lms.borrowandreturn;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import lms.common.type.BookBorrowInfo;

/**
 *
 * @author chae
 */
public class BookBorrowDataProvider extends ObjectListDataProvider {

  private ArrayList bookBorrowList = new ArrayList();
  
  /** Creates a new instance of AddressDataProvider */
  public BookBorrowDataProvider() {
    setList( bookBorrowList );
    setObjectType( BookBorrowInfo.class );
  }

}
