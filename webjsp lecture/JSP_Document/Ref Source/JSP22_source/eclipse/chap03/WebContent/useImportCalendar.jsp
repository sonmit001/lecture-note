<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.util.Calendar" %>
<html>
<head><title>Calendar Ŭ���� ���</title></head>
<body>
<%
	Calendar cal = Calendar.getInstance();
%>
������ 
	<%= cal.get(Calendar.YEAR) %>�� 
	<%= cal.get(Calendar.MONTH) + 1 %>��
	<%= cal.get(Calendar.DATE) %>��
�Դϴ�.
</body>
