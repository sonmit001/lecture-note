<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import = "java.util.Random" %>
<html>
<head><title>break ��� ��</title></head>
<body>
<%
	Random random = new Random();
	for (int i = 1 ; i <= 20 ; i++) {
		int number = random.nextInt(10) + 1;
%>
<%= i %> ��° = <%= number %> <br>
<%
		if (number == 7) break;
	}
%>
</body>
</html>
