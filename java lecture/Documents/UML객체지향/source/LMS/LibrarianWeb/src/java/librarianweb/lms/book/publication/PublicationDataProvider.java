package librarianweb.lms.book.publication;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import lms.common.type.PublicationInfo;

public class PublicationDataProvider extends ObjectListDataProvider {

  private ArrayList publicationList = new ArrayList();
  
  /** Creates a new instance of AddressDataProvider */
  public PublicationDataProvider() {
    setList( publicationList );
    setObjectType( PublicationInfo.class );
  }
  
  /*
  public void load(InputStream istream ) {
      try {
      InputStreamReader sr = new InputStreamReader( istream );
      BufferedReader br = new BufferedReader( sr );
      
      while ( br.ready() ) {
        String line = br.readLine();
        String[] cols = line.split( ";" );
        
        if ( cols.length == 8 ) {
          Address address = new Address();
          address.setId( cols[0] );
          address.setTitle( cols[1] );
          address.setLastname( cols[2] );
          address.setFirstname( cols[3] );
          address.setStreet( cols[4] );
          address.setCity( cols[5] );
          address.setState( cols[6] );
          address.setCountry( cols[7] );
          getList().add( address );
        }
      }
      
    } catch ( Exception e ) {
      e.printStackTrace();
    }  
  }
  
  public void load(String filename) {
    try {
      FileInputStream fs = new FileInputStream( filename );
      load( fs );
    } catch ( Exception e ) {
      e.printStackTrace();
    }
  }
  */
}
