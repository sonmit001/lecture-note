<%@ page import="mvjsp.chap15.Thermometer"%>
<%@ page contentType="text/html; charset=euc-kr"%>
<%
	Thermometer thermometer = new Thermometer();
	request.setAttribute("t", thermometer);
%>
<html>
<head>
	<title>�µ� ��ȯ ����</title>
</head>
<body>
	${t.setCelsius('����', 27.3)}
	���� �µ�: ����	${t.getCelsius('����')}�� / ȭ�� ${t.getFahrenheit('����')}
	
	<br/>
	����: ${t.info}
</body>
</html>
