<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-9">
				<h1>채팅방</h1>
			</div>

		</div>
		<div class="row">
			<div class="col-xs-9">
				<div>
					<h3>채팅</h3>
				</div>
				<div class="contentDiv" id="chatBox">
					<!--           <div><span class="username">hsilomedus : </span><span>whass uuup?</span></div> -->
				</div>
			</div>
			<div class="col-xs-3">
				<div>
					<h3>접속자</h3>
				</div>
				<div class="contentDiv" id="nicknamesBox">
					<!--           <div class="username">hsilomedus</div> -->
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 10px;">
			<div class="col-xs-7">
				<input type="text" id="txtMessage" class="form-control"
					placeholder="메세지를 입력해주세요." />
			</div>
			<div class="col-xs-2">
				<button id="btnSend" class="btn btn-primary" style="width: 100%;">Send</button>
			</div>
		</div>
	</div>
	
	<sec:authentication property="name" var="loginUser" />
	<input type="hidden" id="nickname" value="${loginUser}">
	<script>
		var socket;
		var registered = false;

		$(document).ready(function startClient() {
			console.log("opening socket");
			//on http server use document.domain instead od "localhost"
			//Start the websocket client
			socket = new SockJS("http://" +document.domain + ":8090/kosta/chat");

			//When the connection is opened, login.
			socket.onopen = function() {
				console.log("Opened socket.");
				//register the user
				var nickname = $("#nickname").val();
				socket.send(nickname);
			};

			//When received a message, parse it and either add/remove user or post message.
			socket.onmessage = function(a) {
				//process the message here
				console.log("received message: " + a.data);
				var message = JSON.parse(a.data);
				if (message.addUser) {
					var d = document.createElement('div');
					$(d).addClass("username user").text(message.addUser).attr(
							"data-user", message.addUser).appendTo(
							"#nicknamesBox");
				} else if (message.removeUser) {
					$(".user[data-user=" + message.removeUser + "]").remove();
				} else if (message.message) {
					var d = document.createElement('div');
					var suser = document.createElement('span');
					var smessage = document.createElement('span');

					$(suser).addClass("username")
							.text(message.nickname + " : ").appendTo($(d));
					$(smessage).text(message.message).appendTo($(d));
					$(d).appendTo("#chatBox");
					$("#chatBox").scrollTop($("#chatBox")[0].scrollHeight);
				}

			}
			socket.onclose = function() {
				document.write("Closed socket.");
			};
			socket.onerror = function() {
				document.write("Error during transfer.");
			};

			$('#txtMessage').keyup(function(e) {
				if (e.keyCode == 13) {
					sendMessage();
				}
			});
			$("#btnSend").click(function() {
				sendMessage();
			});

		});

		
		
		
		function sendMessage() {
			if ($("#txtMessage").val()) {
				socket.send($("#txtMessage").val());
				$("#txtMessage").val("");
			}
		}

		
		
		
		
/* 		$(document).ready(function() {
			$('#login_modal').modal({
				keyboard : false,
				backdrop : 'static'
			});

			$('#btnLogin').click(function() {
				if ($("#nickname").val()) {
					//init everything

					$('#login_modal').modal('hide');
					startClient();
				}
			});

		}); */
	</script>

</body>