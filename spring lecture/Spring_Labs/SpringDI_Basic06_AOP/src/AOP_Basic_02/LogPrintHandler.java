package AOP_Basic_02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.util.StopWatch;

/*
보조관심 구현
하나의 함수가 여러개의 함수를 대리해야한다. : invoke 
*/
public class LogPrintHandler implements InvocationHandler {
	private Object target;
	public LogPrintHandler(Object target) {
		System.out.println("LogPrintHandler 보조관심사 생성자 호출");
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Invoke 함수 호출(start)");
		System.out.println("Method : " + method);
		System.out.println("args : " + Arrays.toString(args));
		
		
		//보조 업무
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		//주업무 -> Calc에서 구현된 실함수를 호출(parameter 정보 가지고)
		int result = (int)method.invoke(this.target,args); //=public LogPrintHandler(Object target) {} 실객체의 주소
		
		//보조 업무
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[TIME LOG] Method : ADD");
		log.info("[TIME LOG] Method : Time " + sw.getTotalTimeMillis());
		
		return result;
		
		
	}
	
	
}
