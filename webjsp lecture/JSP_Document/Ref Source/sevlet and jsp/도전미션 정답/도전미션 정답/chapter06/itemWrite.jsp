<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% 
	request.setCharacterEncoding("EUC-KR");	
	%>
	<jsp:useBean id="itemBean" class="com.mission.javabeans.ItemBean" />
	<jsp:setProperty property="*" name="itemBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�Է� �Ϸ�� ����</h2>
	<table>
		<tr>
			<td>��ǰ��</td>
			<td><jsp:getProperty property="name" name="itemBean"/></td>
		</tr>
		<tr>
			<td>����</td>
			<td><jsp:getProperty property="price" name="itemBean"/></td>
		</tr>
		<tr>
			<td>����</td>
			<td><jsp:getProperty property="description" name="itemBean"/></td>
		</tr>
	</table>
</body>
</html>