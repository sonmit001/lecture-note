<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
<%
try{
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String uid="scott";
	String pass="tiger";
	String sql = "SELECT * FROM item";
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("����̹� �ε� ����");
	conn = DriverManager.getConnection(url, uid, pass);
	System.out.println("���� ����");
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	
	out.println("<table border=1>");
	while(rs.next())
	{
		out.println("<tr>");
		out.println("<td>"+rs.getString("ITEMNAME")+"</td>");
		out.println("<td>"+rs.getString("PRICE")+"</td>");
		out.println("<td>"+rs.getString("DESCRIPTION")+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
}catch(Exception e){
	e.printStackTrace();
}
%>
</body>
</html>