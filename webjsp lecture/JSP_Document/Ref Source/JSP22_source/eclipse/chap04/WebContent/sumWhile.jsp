<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<head><title>while ���� ��� ��</title></head>
<body>
<%
	int sum = 0;
	int i = 1;
	while( i <= 100 ) {
		sum += i;
		i++;
	}
%>
1���� 100������ �� = <%= sum %> <br>
</body>
</html>
