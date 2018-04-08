/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package borrowerweb.lms.user.member;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import lms.common.type.UserInfo;

/**
 *
 * @author chae
 */
public class UserDataProvider  extends ObjectListDataProvider  {
    private ArrayList userList = new ArrayList();
 
    public UserDataProvider() {
        setList( userList );
        setObjectType( UserInfo.class );
    }
}
