<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page errorPage="errorView.jsp" %>
<%@ page import="mvjsp.chap13.service.DeleteMessageService" %>
<%@ page import="mvjsp.chap13.service.InvalidMessagePassowrdException" %>
<%
	int messageId = Integer.parseInt(request.getParameter("messageId"));
	String password = request.getParameter("password");
	boolean invalidPassowrd = false;
	try {
		DeleteMessageService deleteService = DeleteMessageService.getInstance();
		deleteService.deleteMessage(messageId, password);
	} catch(InvalidMessagePassowrdException ex) {
		invalidPassowrd = true;
	}
%>
<html>
<head>
	<title>���� �޽��� ������</title>
</head>
<body>
<%  if (!invalidPassowrd) { %>
�޽����� �����Ͽ����ϴ�.
<%  } else { %>
�Է��� ��ȣ�� �ùٸ��� �ʽ��ϴ�. ��ȣ�� Ȯ�����ּ���.
<%  }%>
<br/>
<a href="list.jsp">[��� ����]</a>
</body>
</html>