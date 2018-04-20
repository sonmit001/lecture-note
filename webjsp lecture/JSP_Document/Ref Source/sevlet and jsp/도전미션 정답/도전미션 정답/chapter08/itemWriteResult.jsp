<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String sql = "insert into item values(?,?,?)";
// �����ų �������� ? ������
Connection conn = null;
PreparedStatement pstmt = null;
String url="jdbc:oracle:thin:@localhost:1521:XE";
String uid="scott";
String pass="tiger";
%>
<%
try{//1. ����̹� �ε�
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, uid, pass); //2. ���� ��ü ���
	pstmt = conn.prepareStatement(sql); //3. statement ��ü ���
	// ? -> ���ε� ����
	request.setCharacterEncoding("EUC-KR");
	String name=request.getParameter("name");
	String price=request.getParameter("price");
	String description=request.getParameter("description");

	pstmt.setString(1, name);
	pstmt.setInt(2, Integer.parseInt(price));
	pstmt.setString(3, description);
	//4. ������ ����
	pstmt.executeUpdate();
}catch(Exception e)
{
	e.printStackTrace();
}finally{
	if(pstmt!= null)
		pstmt.close();
	if(conn!= null)
		conn.close();
}
%>
<a href=itemWrite.jsp>��� ����</a>
</body>
</html>