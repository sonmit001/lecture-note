<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<head><title>for ���� ��� ��</title></head>
<body>
<%
	int sum = 0;
	for (int i = 1 ; i <= 100 ; i++) {
		sum += i;
	}
%>
1���� 100������ �� = <%= sum %> <br>
<%
	sum = 0;
	for (int i = 1 ; i <= 100 ; i += 2) {
		sum += i;
	}
%>
1���� 100������ Ȧ���� �� = <%= sum %> <br>
<%
	sum = 0;
	for (int i = 2 ; i <= 100 ; i += 2) {
		sum += i;
	}
%>
1���� 100������ ¦���� �� = <%= sum %> <br>
</body>
</html>
