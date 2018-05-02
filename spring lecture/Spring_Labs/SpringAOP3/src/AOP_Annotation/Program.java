package AOP_Annotation;

import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) throws Exception {
		NewReceipt newReceipt = new NewReceipt();
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:AOP/ApplicationContext.xml");
		List<Product> list = newReceipt.AddProduct();
		Receipt receipt = (Receipt)context.getBean("NewReceipt");
		receipt.print(list);
	
	}

}
