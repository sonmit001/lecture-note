/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lms.user.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lms.common.entity.LibraryUser;
import lms.common.exception.IncorrectUserPasswordException;
import lms.common.exception.MultipleUserIDException;
import lms.common.exception.UnknownUserIDException;
import lms.common.type.UserInfo;
import lms.common.type.UserType;

/**
 *
 * @author chae
 */
@Stateless
public class UserMgtBean implements UserMgtRemote {
    @PersistenceContext(unitName="LMS-corePU")
    private EntityManager em;

    public void registerUser(UserType type, String id, String password, String name) {
        
        System.out.println("UserMgtBean::registerUser called: id: " + id + " password: " + password + " name: " + name ) ;
        
        try {
            
            LibraryUser user = new LibraryUser(type, id, password, name) ;
            em.persist(user);
            em.flush() ;
            
        }
        catch ( Exception e ) {
            throw new EJBException(e.getMessage()) ;
        }
        
    }
    
    
    public Collection<UserInfo> findUserInfosByNameAndID(String nameKey, String idKey) {

        System.out.println("UserMgtBean::findUserInfosByNameAndID invoked with name " + nameKey + " and id " + idKey) ;
                
        Collection<UserInfo> users = new ArrayList<UserInfo>() ;
        
        try {
            Query query = em.createNamedQuery("FindUserInfosByNameAndID")
                    .setParameter("name", "%" + nameKey + "%")
                    .setParameter("id", "%" + idKey + "%") ;
            
            List results = query.getResultList() ;
            
            System.out.println("Found users: " + results.size()) ;

            for ( int i = 0 ; i < results.size() ; i ++ ) {

                Object[] elem = (Object[]) results.get(i) ;

                // SELECT u.userType, u.userID, u.name, u.password, u.email, u.organization, u.department, u.phoneNumber  FROM LibraryUser u WHERE u.name LIKE :name")
                
                UserType type = (UserType) elem[0] ;
                String userID = (String) elem[1] ;
                String name = (String) elem[2] ;
                String password = (String) elem[3] ;
                String email = (String) elem[4] ;
                String organization = (String) elem[5] ;
                String department = (String) elem[6] ;
                String phone = (String) elem[7] ;

                UserInfo userInfo = new UserInfo(type, userID, name) ;
                
                userInfo.setPassword(password);
                userInfo.setOrganization(organization) ;
                userInfo.setDept(department) ;
                userInfo.setPhone(phone) ;
                userInfo.setEmail(email) ;
                
                users.add(userInfo);
            }
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }        
        return users ;
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")

    public void persist(Object object) {
        em.persist(object);
    }

    public void removeUser(String userID) throws UnknownUserIDException {
        
        System.out.println("UserMgtBean::removeUser invoked with: " +  userID ) ;
        
        try {
        
           LibraryUser user = em.find(LibraryUser.class, userID) ;
        
            if ( user == null ) {
                throw new UnknownUserIDException(userID) ;
            }
           
           em.remove(user) ;
           em.flush() ;
            
        }
        catch ( Exception e ) {   
            throw new EJBException(e) ;
        }
    }

    public boolean login(String userID, String password)
            throws UnknownUserIDException, MultipleUserIDException, IncorrectUserPasswordException {
        
        // LibraryUser의 id, password와의 일치 여부를 확인한다.
        
        try {
            
            LibraryUser user = em.find(LibraryUser.class, userID) ;
            
            String correctPassword = user.getPassword() ;
            
            if ( correctPassword.compareTo(password) != 0 ) {
                throw new IncorrectUserPasswordException(userID, password) ;   
            }
            
            // 만약 시스템에 로그인한 것을 엔티티로서 기록하려면 여기서 하면 된다.
        }
        catch ( Exception e ) {
            throw new EJBException(e) ;
        }
        
        return true ;
    }
    public boolean CheckUserID(String userID) throws UnknownUserIDException{
        
        LibraryUser user = em.find(LibraryUser.class, userID) ;
        
        if ( user == null ) {
            throw new UnknownUserIDException(userID) ;
        }
        return true ;
    }


    public boolean exceedBorrowMaxCount(String userID) throws UnknownUserIDException {
        return false;
    }

    public boolean checkNotPaidOverdueFee(String userID) throws UnknownUserIDException {
        return false;
    }

    public UserInfo getUserInfo(String userID) throws UnknownUserIDException  {

         LibraryUser user = em.find(LibraryUser.class, userID) ;
        
        if ( user == null ) {
            throw new UnknownUserIDException(userID) ;
        }
        
         em.refresh(user) ;
         
         UserInfo info = new UserInfo() ;
         info.setId(userID);
         info.setName(user.getName());
         info.setUserType(user.getUserType());
         info.setPassword(user.getPassword());
         info.setAddress(user.getAddress());
         info.setOrganization(user.getOrganization());
         info.setDept(user.getDepartment());
         info.setPhone(user.getPhoneNumber());
         info.setEmail(user.getEmail());
         
        return info ;
    }

    public void updatePassword(String userID, String password)  throws UnknownUserIDException {
        
        try {   
           LibraryUser user = em.find(LibraryUser.class, userID) ;
        
            if ( user == null ) {
                throw new UnknownUserIDException(userID) ;
            }
           user.setPassword(password) ;
           em.persist(user) ;
           
           em.flush() ; 
        }
        catch ( Exception e ) { 
            throw new EJBException(e) ;
        }
    }

    public void updateEmail(String userID, String email) throws UnknownUserIDException  {
        try {   
           LibraryUser user = em.find(LibraryUser.class, userID) ;
        
            if ( user == null ) {
                throw new UnknownUserIDException(userID) ;
            }
           user.setEmail(email) ;
           em.persist(user) ;
           
           em.flush() ; 
        }
        catch ( Exception e ) { 
            throw new EJBException(e) ;
        }
    }
    
    public void updateName(String userID, String name) throws UnknownUserIDException  {
        try {   
           LibraryUser user = em.find(LibraryUser.class, userID) ;
        
            if ( user == null ) {
                throw new UnknownUserIDException(userID) ;
            }
           user.setName(name) ;
           em.persist(user) ;
           
           em.flush() ; 
        }
        catch ( Exception e ) { 
            throw new EJBException(e) ;
        }
    }

    public void updatePhoneNumber(String userID, String phoneNumber) throws UnknownUserIDException  {
        try {   
           LibraryUser user = em.find(LibraryUser.class, userID) ;
        
            if ( user == null ) {
                throw new UnknownUserIDException(userID) ;
            }
           user.setPhoneNumber(phoneNumber) ;
           em.persist(user) ;
           
           em.flush() ; 
        }
        catch ( Exception e ) { 
            throw new EJBException(e) ;
        }
    }

    public String getPhoneNumber(String userID) throws UnknownUserIDException {
        try {   
           LibraryUser user = em.find(LibraryUser.class, userID) ;
        
            if ( user == null ) {
                throw new UnknownUserIDException(userID) ;
            }
           
           String phoneNumber = user.getPhoneNumber() ;
           
           return phoneNumber ;
        }
        catch ( Exception e ) { 
            throw new EJBException(e) ;
        }
    }

    public void registerUser(UserInfo userInfo) {
        
        System.out.println("UserMgtBean::registerUser called with: " + userInfo ) ;
        
        try {
            
            LibraryUser user = new LibraryUser(userInfo.getUserType(), userInfo.getId(), userInfo.getPassword(), userInfo.getName()) ;
            
            user.setAddress(userInfo.getAddress()) ;
            user.setEmail(userInfo.getEmail()) ;
            user.setOrganization(userInfo.getOrganization()) ;
            user.setDepartment(userInfo.getDept()) ;
            user.setPhoneNumber(userInfo.getPhone()) ;
            
            em.persist(user);
            em.flush() ; 
        }
        catch ( Exception e ) {
            throw new EJBException(e.getMessage()) ;
        }
    }
}
