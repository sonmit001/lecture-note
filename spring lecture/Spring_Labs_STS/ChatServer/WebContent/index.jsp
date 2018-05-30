<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>index.jsp</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script>
 //push Client����
 console.log("typeof:"+typeof(EventSource));
 //push�� ���� �� �ִ� ���������� �Ǵ� (Ÿ�Կ��� -> ��ü�� Ÿ��Ȯ��)
 if(typeof(EventSource) != "undefined"){
 var eventSource = 
	 new EventSource("chatload.jsp",
			 { withCredentials: true } );
 // EventSource EventListener�� ����
 // onmessage : ������ ���� push �޼����� ���ŵǸ� �߻�(������)
 // onerror : ������ ���� push���� ������ �߻��Ǿ��� �� �߻�
 // onopen : ������ ������ �Ǿ��� �� �߻�
 eventSource.onmessage = function(event){ //�������������� ���ư��� �ִ� �ݹ��Լ�
	 //alert(event.data);
	 $("#target").html("<div style='background:orange'>"
			 +event.data+"</div>");
 };
 }else{
  $("#target").html("�ش� �������� ������ �ȵ˴ϴ�.")
 }

// Ajax�� ������� �����͸� ������ �� 
//����ڰ� �Է��� ������ ������ ����
 $(function(){
  $("form").submit(function(){
   var fdata = {
     u_id:encodeURIComponent($("#u_id").val()),
     chat:encodeURIComponent($("#chat").val())};
   $.ajax({ //ajax�� ����
    type:"POST", //����� �־���� (URL�� �Ⱥ���)
    url:"http://192.168.0.9:8090/ChatServer/chat_add.jsp",
    data:fdata
   });
   return false;//������Ŀ� �������� �ȹٲ�� false����
  });
 });
</script>
</head>
<body>
<div id="warp">
 <form method="post" action="chat_add.jsp" 
 name="cform" id="cform">
  <input type="text" id="u_id" name="u_id" 
  required="required" placeholder="�̸��̳����̵�"> 
  <input type="text" id="chat" name="chat" 
  required="required" placeholder="��ȭ����">
  <input type="submit" id="send" value="���ۼ�">
 </form>
 <div id="target"></div>
</div>
</body>
</html>





