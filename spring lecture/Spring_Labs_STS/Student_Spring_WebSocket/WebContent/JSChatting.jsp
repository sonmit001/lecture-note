<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- onkeydown을 통해서 엔터키로도 입력되도록 설정. -->
<input id="name" readonly="readonly" type="text"
	value="${sessionScope.nickname}">
<input id="closeBtn" type="button" value="나가기" class="btn">
<input id="inputMessage" type="text"
	onkeydown="if(event.keyCode==13){sendMessage();}" />
<input id="sendBtn" type="button" value="전송" class="btn">
<div id="messageWindow2"
	style="padding: 10px 0; height: 20em; overflow: auto; background-color: #a0c0d7;"></div>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/sockjs-0.3.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#inputMessage').keypress(function(event) {
			var keycode = (event.keyCode ? event.keyCode : event.which);
			if (keycode == '13') {
				sendMessage();
			}
			event.stopPropagation();
		});

		var nick = $('#name').val();
		if (nick != "" || nick != null) {
			connect();
		}

		$('#sendBtn').click(function() {
			sendMessage();
		});
		$('#enterBtn').click(function() {
			connect();
		});
		$('#closeBtn').click(function() {
			disconnect();
		});
	});
	var wsocket;
	function connect() {
		wsocket = new WebSocket("ws://192.168.0.20:8090/Student_Spring_WebSocket/chat.sockjs");
		wsocket.onopen = onOpen;
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
	}
	function disconnect() {
		wsocket.close();
	}
	function onOpen(evt) {
		var name = document.getElementById('name')
		appendMessage(name.value + "님 환영합니다");
		name.value = '';

	}
	function onMessage(evt) {
		var data = evt.data;
		appendMessage(data);
	}
	function onClose(evt) {
		var name = document.getElementById('name')
		appendMessage(name.value + "님 안녕히가세요");
	}
	function sendMessage() {
		var name = $("#name").val();
		var msg = $("#inputMessage").val();
		wsocket.send(msg);
		$("#inputMessage").val("");
	}
	function appendMessage(msg) {
		var div = document.createElement('div');

		if (msg.substring(0, 5) == "admin") {
			div.style["width"] = "auto";
			div.style["word-wrap"] = "break-word";
			div.style["display"] = "inline-block";
			div.style["background-color"] = "#fcfcfc";
			div.style["border-radius"] = "3px";
			div.style["padding"] = "3px";
			div.style["margin-left"] = "3px";
		} else {
			div.style["width"] = "auto";
			div.style["word-wrap"] = "break-word";
			div.style["float"] = "right";
			div.style["display"] = "inline-block";
			div.style["background-color"] = "#ffea00";
			div.style["padding"] = "3px";
			div.style["border-radius"] = "3px";
			div.style["margin-right"] = "3px";
		}

		div.innerHTML = msg;
		document.getElementById('messageWindow2').appendChild(div);

		document.getElementById('inputMessage').value = '';

		//clear div 추가. 줄바꿈용.      
		var clear = document.createElement('div');
		clear.style["clear"] = "both";
		document.getElementById('messageWindow2').appendChild(clear);

		//div 스크롤 아래로. 
		messageWindow.scrollTop = messageWindow.scrollHeight;
	}
</script>

