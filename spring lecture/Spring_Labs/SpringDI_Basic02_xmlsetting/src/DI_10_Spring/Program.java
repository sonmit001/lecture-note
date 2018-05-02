package DI_10_Spring;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		/*BookClient bookclient = new BookClient();
		//Collection Framework = list,set,map,properties(String,String)
		Properties prop = new Properties();
		prop.setProperty("server","192.168.0.26");
		prop.setProperty("connectiontimeout","20000");
		bookclient.setConfig(prop);
		bookclient.connect();
		*/
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_10_Spring/DI_10.xml");
		BookClient booklist = context.getBean("bookclient",BookClient.class);
		booklist.connect();
	}

}
