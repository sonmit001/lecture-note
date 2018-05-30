<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- onkeydown을 통해서 엔터키로도 입력되도록 설정. -->
<input id="inputMessage" type="text" 	onkeydown="if(event.keyCode==13){sendMessage();}" />
<input type="button" id="sendBtn" value="전송"/>
<div id="messageWindow2" style="padding:10px 0;height: 20em; overflow: auto; background-color: #a0c0d7;"></div>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
		$('#sendBtn').click(function() { sendMessage(); });
	});
	
	var wsocket;
	function sendMessage() {//전송버튼눌렀을때
		wsocket = new WebSocket("ws://192.168.0.20:8090/Student_Spring_WebSocket/echo-ws");
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
		wsocket.onopen = function() {//웹소켓오픈
			wsocket.send($('#inputMessage').val());//웹소켓을통해 id가message인곳의 val값을 전달
		};
	}
	function onMessage(evt) {//웹소켓을통해 값을 전달받음
		var data = evt.data;
		alert("서버에서 데이터 받음: " + data);
		wsocket.close();//웹소켓을 닫음
	}
	function onClose(evt) {//웹소켓이 닫혔을때 호출
		alert("연결 끊김");
	}
</script>