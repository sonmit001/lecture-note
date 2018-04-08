/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package borrowerweb.lms.book.publication;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import lms.common.type.BookItemInfo;

/**
 *
 * @author chae
 */
public class BookItemDataProvider extends ObjectListDataProvider  {
    private ArrayList bookItemList = new ArrayList();
    
    public BookItemDataProvider() {
    setList( bookItemList );
    setObjectType( BookItemInfo.class );
  }
}
