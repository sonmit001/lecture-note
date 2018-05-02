package homework;

import java.util.Calendar;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ReceiptFinal implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {

		Object result = method.proceed(); // 주업무 실제 함수 호출
		
		return result;
	}
	
}
