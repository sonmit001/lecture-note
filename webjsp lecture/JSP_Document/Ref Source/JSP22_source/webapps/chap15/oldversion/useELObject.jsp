<%@ page contentType = "text/html; charset=euc-kr" %>
<%
	request.setAttribute("name", "�ֹ���");
%>
<html>
<head><title>EL Object</title></head>
<body>

��û URI: ${pageContext.request.requestURI} <br>
request�� name �Ӽ�: ${requestScope.name} <br>
code �Ķ����: ${param.code}

</body>
</html>
