<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% 
	request.setCharacterEncoding("EUC-KR");	
	%>
	<jsp:useBean id="movieBean" class="com.mission.javabeans.MovieBean" />
	<jsp:setProperty property="*" name="movieBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#rowstyle
{
	text-align: center;
	font-weight: bol;
}
</style>
</head>
<body>
	<h2>�Է� �Ϸ�� ����</h2>
	<table>
		<tr>
			<td id="rowstyle">����</td>
			<td><jsp:getProperty property="name" name="movieBean"/></td>
		</tr>
		<tr>
			<td id="rowstyle">����</td>
			<td><jsp:getProperty property="price" name="movieBean"/></td>
		</tr>
		<tr>
			<td id="rowstyle">����</td>
			<td><jsp:getProperty property="director" name="movieBean"/></td>
		</tr>
		<tr>
			<td id="rowstyle">�⿬���</td>
			<td><jsp:getProperty property="actor" name="movieBean"/></td>
		</tr>
		<tr>
			<td id="rowstyle">�ó�ý�</td>
			<td><jsp:getProperty property="synopsis" name="movieBean"/></td>
		</tr>
		<tr>
			<td id="rowstyle">�帣</td>
			<td><jsp:getProperty property="genre" name="movieBean"/></td>
		</tr>
	</table>
</body>
</html>