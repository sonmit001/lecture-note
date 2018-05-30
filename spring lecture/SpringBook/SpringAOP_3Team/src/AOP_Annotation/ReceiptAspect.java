package AOP_Annotation;
import java.util.Calendar;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ReceiptAspect {
	
	@Before("execution(* AOP_Annotation.Receipt.print(..))")
	public void printBefore(){
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
	
	
	@After("execution(* AOP_Annotation.Receipt.print(..))")
	public void printAfter(JoinPoint joinPoint){
		
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
