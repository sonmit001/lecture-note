package DI_Annotation_05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 Configcontext를 Spring의 설정파일로 사용한다. (xml파일 대체한다.)
 
 @Configuration
 @Bean
 (함수기반의 처리)
 
 xml파일 이라면
 <Bean id="user" class="DI_Annotation_05.User">
 <Bean id="user2" class="DI_Annotation_05.User2">
 Java 파일에서는 함수를 생성해서 객체 주소 리턴하는 형태
  
  */
@Configuration
public class Configcontext {
	
	@Bean
	public User user() { //<Bean id="user" class="DI_Annotation_05.User">과 똑같다.
		return new User();
	}
	@Bean
	public User2 user2() { //<Bean id="user2" class="DI_Annotation_05.User2">과 똑같다.
		return new User2();
	}
}
