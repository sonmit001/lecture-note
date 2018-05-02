package AOP_Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:AOP/ApplicationContext.xml");
		Customer customer = (Customer)context.getBean("customerimpl");
		customer.addCustomerBefore();
		customer.addCustomerAfter();
		
	}

}
