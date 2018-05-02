package DI_05_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		/*MyBean mybean = new MyBean();
		MyBean mybean2 = new MyBean("kang");

		Singleton single = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		
		//객체변수의 주소값
		
		System.out.println("mybean : " + mybean);
		System.out.println("mybean2 : " + mybean2);
		System.out.println("single : " + single);
		System.out.println("mybean2 : " + mybean2);*/
		
		//KEY POINT : 컨테이너 구성되고 xml read해서 객체 생성 조립
		//필요하다면 : 컨테이너 안에 있는 객체를 사용해야한다. >> getBean()
		//return type은 object이다. casting해서 사용해야한다.
		//IOC 컨테이너의 모든 객체의 타입은 : Singleton이다.
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_05_Spring/DI_05.xml");
		System.out.println("before : mybean객체");
		MyBean mybean = context.getBean("mybean",MyBean.class);
		System.out.println("after : mybean객체 : " + mybean);
		
		MyBean mybean2 = context.getBean("mybean",MyBean.class);
		System.out.println("after : mybean2객체 : " + mybean2);
		
		MyBean mybean3 = context.getBean("mybean2",MyBean.class);
		System.out.println("after : mybean3객체 : " + mybean3);
		
		Singleton single = context.getBean("single",Singleton.class);
		System.out.println("after : single객체 : " + single);
		
		Singleton single2 = context.getBean("single",Singleton.class);
		System.out.println("after : single2객체 : " + single2);
	}

}
