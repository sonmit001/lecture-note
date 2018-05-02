package DI_02;

public class HelloApp {

	public static void main(String[] args) {
		/*
		//영문
		MessageBean_eng messageBean_eng = new MessageBean_eng();
		messageBean_eng.sayHello("hong");
		
		//한글
		MessageBean_kr messageBean_kr = new MessageBean_kr();
		messageBean_kr.sayHello("hong");*/
		
		//Interface type으로 다형성을 적용
		MessageBean messageBean_kr = new MessageBean_kr();
		messageBean_kr.sayHello("hong");
		MessageBean messageBean_eng = new MessageBean_eng();
		messageBean_eng.sayHello("hong");
	}

}
/*
요구사항
MessageBean
영문버전(hong) -> Hellohong!
한글버전(hong) -> 안녕hong!
결과를 나누어서 출력
인터페이스로 구현 되었으면 좋겠다.
MessageBean_kr 과 MessageBean_eng로
*/
