package DI_01;

public class HelloApp {

	public static void main(String[] args) {
		MessageBean messagebean = new MessageBean();
		messagebean.sayHello("hong");

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
