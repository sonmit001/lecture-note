package DI_04_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		//java 코드
		/*MessageBeanImpl messagebean = new MessageBeanImpl("hong"); //생성자 초기화
		messagebean.setGreeting("hello"); // setter함수에서 초기화 
		
		messagebean.sayHello();*/
		
		//위 코드를 Spring을 통해서 (IOC 컨테이너 안에 객체 만들고 주입을 하고 ) > xml파일 or annotation을 통해서 할 수 있다.
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_04_Spring/DI_04.xml");
		MessageBean messagebean = context.getBean("m1",MessageBean.class);
		messagebean.sayHello();
	}

}
