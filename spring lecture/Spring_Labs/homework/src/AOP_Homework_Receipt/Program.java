package AOP_Homework_Receipt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;





public class Program {

	public static void main(String[] args) {
		//proxy 객체 생성하고 
		//proxy 통해서 실행
		//xml 설정넘겨서 작업
		
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:AOP_Homework_Receipt/ApplicationContext.xml");
		Receipt receipt = (Receipt)context.getBean("proxy");
		
		NewReceipt newRecipt = new NewReceipt();
		
		receipt.print(newRecipt.AddProduct());
	}

}
