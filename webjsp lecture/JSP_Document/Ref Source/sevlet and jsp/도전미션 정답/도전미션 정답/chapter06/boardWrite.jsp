<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% 
	request.setCharacterEncoding("EUC-KR");	
	%>
	<jsp:useBean id="boardBean" class="com.mission.javabeans.BoardBean" />
	<jsp:setProperty property="*" name="boardBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<style type="text/css">
#rowstyle
{
	text-align: center;
}
</style>
<body>
	<h2>�Է� �Ϸ�� ����</h2>
	<table>
		<tr>
			<td>�ۼ���</td>
			<td><jsp:getProperty property="name" name="boardBean"/></td>
		</tr>
		<tr>
			<td>��й�ȣ</td>
			<td><jsp:getProperty property="pass" name="boardBean"/></td>
		</tr>
		<tr>
			<td>�̸���</td>
			<td><jsp:getProperty property="email" name="boardBean"/></td>
		</tr>
		<tr>
			<td>������</td>
			<td><jsp:getProperty property="title" name="boardBean"/></td>
		</tr>
		<tr>
			<td>�۳���</td>
			<td><jsp:getProperty property="content" name="boardBean"/></td>
		</tr>
	</table>
</body>
</html>