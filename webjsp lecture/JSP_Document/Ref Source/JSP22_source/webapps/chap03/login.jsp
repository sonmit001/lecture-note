<%@ page contentType="text/html; charset=euc-kr" %>
<%
	String id = request.getParameter("memberId");
	if (id.equals("madvirus")) {
		response.sendRedirect("/chap03/index.jsp");
	} else {
%>
<html>
<head><title>�α��ο� ����</title></head>
<body>
�߸��� ���̵��Դϴ�.
</body>
</html>
<%
	}
%>
