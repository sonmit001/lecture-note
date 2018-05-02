package DI_08_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {
	public static void main(String[]args) {
		/*
		 JobExcute jobexcute = new JobExcute("kang",100); 
		//생성자 주입 overloading인지하는지 spring에서
		  
		ArticleDao articledao = new ArticleDao();
		jobexcute.setArticledao(articledao); //setter주입 주소
		
		jobexcute.setData(500); // setter주입 값
*/	
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_08_Spring/DI_08.xml");
		
	}
}
