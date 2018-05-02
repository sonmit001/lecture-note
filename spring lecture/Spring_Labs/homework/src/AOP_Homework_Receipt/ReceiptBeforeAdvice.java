package AOP_Homework_Receipt;

import java.lang.reflect.Method;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.MethodBeforeAdvice;
@Aspect
public class ReceiptBeforeAdvice implements MethodBeforeAdvice {
	
	@Override
	@Before(value = "")
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("=============================\n"
						 + "번호 :            02-3486-9600\n"
						 + "학원명 :                 비트캠프\n"
						 + "주소:    서초구 비트아카데미 빌딩 3층\n"
						 + "=============================\n"
						 + "소득공제 신청은\n"
						 + "http://현금영수증.kr\n"
						 + "주문번호 : #ORD 37479\n"
						 + "감사합니다!\n");
	}
	
}
