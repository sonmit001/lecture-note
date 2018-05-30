package AOP_Basic_Spring_08;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;


@Aspect
public class Factory {
	@Pointcut("bean(*mech)")		//~mech로 끝나는 빈에만 적용
	private void pointcutMethod(){
	}
	@Pointcut("bean(*rine)")		//Marine 빈에만 적용
	private void pointcutMethod2(){
	}
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		
		String signatureStr = joinpoint.getTarget().getClass().getName();
		String ckunit = signatureStr.substring(5);
		
		
		int maxhp = 0;
		if(ckunit.equals("Tank")) {
			maxhp = 150;	
		}else if(ckunit.equals("Command")) {
			maxhp = 1500;	
		}else if(ckunit.equals("Battle")){
			maxhp = 300;	
		}
		
		Object[] hp= joinpoint.getArgs();
		
		System.out.println("scv 수리 준비중....");
		System.out.println("수리 대상 : " + ckunit);
		System.out.println("max hp : " + maxhp);
		System.out.println("현재 hp : " + hp[0]);
		
		Log log =	LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[수리 시작]"); //console 출력
		
		///////////////////////////////////////////////////////////////////
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
		///////////////////////////////////////////////////////////////////

		sw.stop();
		log.info("[수리 종료]");
		log.info("총 수리 시간 : " + sw.getTotalTimeSeconds()+"초");
			
		}
	}
	
	@Before("pointcutMethod2()")
	public void beforAdvice() {
		System.out.println("scv가 수리 준비중");
	}
}
