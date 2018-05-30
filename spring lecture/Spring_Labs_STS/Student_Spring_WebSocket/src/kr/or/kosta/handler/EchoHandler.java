package kr.or.kosta.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{
	//WebSocketHandler를 직접구현하지 않고 그것을 구현하고 있는 클래스를 상속받아서 원하는 것만 구현
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {//소켓통신연결
	//WebSocketSession-웹 소켓 클라이언트와 통신을 하는데 필요한 기능을 제공하고 있다
		System.out.printf("%s 연결 됨\n", session.getId());
	}

	@Override
	protected void handleTextMessage(//통신서버로부터 메세지를 받아온다
			WebSocketSession session, TextMessage message) throws Exception {
		System.out.printf("%s로부터 [%s] 받음\n",
				session.getId(), message.getPayload());
		session.sendMessage(new TextMessage("echo: " + message.getPayload()));//echo붙여서 값 주입
	}

	@Override
	public void afterConnectionClosed(//소켓통신끝나고 호출
			WebSocketSession session, CloseStatus status) throws Exception {
		System.out.printf("%s 연결 끊김\n", session.getId());
	}
}
