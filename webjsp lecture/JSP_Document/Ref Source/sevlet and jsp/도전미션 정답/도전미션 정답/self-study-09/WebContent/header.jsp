<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
 td{
 	border: 1px solid black;
 	width: 200px;
 	text-align: center;
 }
 table.mainmenu td.login:HOVER{
    background-color: pink;
 }
 
</style>
</head>
<body>
	<table class="mainmenu" align="center">
	<c:if test="${empty emp}">	
		<tr>
			<td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					
			<td class="login"> <a name="login" href="login.do" style="text-decoration: none;">�α���</a></td>
			<td style="width:250px">����ڵ��<br>
			 <span style="color:red">(�����ڷ� �α��� �� ��� ����)</span></td>
			<td>����������<br>
			 <span style="color:red">(�α��� �� ��� ����)</span></td>
		</tr>	
	</c:if>
	<c:if test="${!empty emp }">
		<tr>
			<td> <label name="home">${emp.name}�� �ݰ����ϴ�.</label></td>
			<td> <label name="home">���� : ${emp.lev}</label></td>
			 <td class="login"> <a href="logout.do" style="text-decoration: none;">�α׾ƿ�</a></td>
			<c:choose>
			<c:when test="${result==2}">
			 <td class="login"> <a href="custom.do" style="text-decoration: none;">����ڵ��</a></td>
			</c:when>
			<c:when test="${result==3}">
			 <td style="width:300px">����ڵ��
			 <span style="color:red">(�����ڷ� �α��� �� ��� ����)</span></td>
			</c:when>
			</c:choose>
			<td class="login">
			  <a href="mypage.do" style="text-decoration: none;">����������</a></td>
		</tr>		
	</c:if>
	</table>
</body>
</html>