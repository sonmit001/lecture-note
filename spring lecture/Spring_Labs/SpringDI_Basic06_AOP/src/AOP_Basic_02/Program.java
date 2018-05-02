package AOP_Basic_02;

import java.lang.reflect.Proxy;

public class Program {

	public static void main(String[] args) {
		Cal2 cal2 = new NewCal2();
		//cal2.ADD(100,200);
		
		//Proxy 객체를 통해서 처리해야한다.(가짜)
		Cal2 cal = (Cal2) Proxy.newProxyInstance(cal2.getClass().getClassLoader(), //실제 클래스의 meta정보
							   cal2.getClass().getInterfaces(), //실제 클래스의 행위정보
							   new LogPrintHandler(cal2)); //Handler = 보조관심
		//Proxy를 통해서 처리하지만 사용자는 실제 Cal2객체를 사용하는 것 처럼 보인다.
		//ADD,MUL,SUB >> 어떤함수를 불러도 LogPrintHandler 객체의 invoke함수 호출(대리함수)
		int result = cal.ADD(1000,2000);
		System.out.println("main : " + result);
		int result2 = cal.MUL(1000,2000);
		System.out.println("main : " + result2);
		
		
	} 
}