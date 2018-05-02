package AOP_Homework_Receipt;

import java.lang.reflect.Method;
import java.util.Calendar;

import org.aspectj.lang.annotation.After;
import org.springframework.aop.AfterReturningAdvice;

public class ReceiptAfterAdvice implements AfterReturningAdvice{
	
	@Override
	@After
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		Calendar cal = Calendar.getInstance();
		
		System.out.println("             3조\n"
						 + "     3조 AOP 예시를 위한 영수증\n"
						 + "조별과제                                    [AOP]\n"
						 + "=============================\n"
						 + "    물품 구입에 의한 영수증 예시\n"
						 + "    거래일시 \n"
						 + cal.get(Calendar.YEAR)+"/"
						 + (cal.get(Calendar.MONTH)+1) + "/"
						 + cal.get(Calendar.DATE) + "   "
						 + cal.get(Calendar.HOUR) + ":"
						 + cal.get(Calendar.MINUTE) + ":"
						 + cal.get(Calendar.SECOND) + "\n"
						 + "=============================");
	}

}
