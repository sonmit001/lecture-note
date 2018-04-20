<%@ page contentType = "text/html; charset=euc-kr" %>

<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>
<%@ page import = "java.io.Reader" %>
<%@ page import = "java.io.IOException" %>

<%
	String memberID = request.getParameter("memberID");
%>
<html>
<head><title>ȸ�� ����</title></head>
<body>

<%
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		String jdbcDriver = "jdbc:mysql://localhost:3306/chap12?" +
							"useUnicode=true&characterEncoding=euckr";
		String dbUser = "jspexam";
		String dbPass = "jspex";
		String query =  "select * from MEMBER_HISTORY "+
						"where MEMBERID = '"+memberID+"'";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(query);
		if(rs.next()) {
%>
<table border="1">
<tr>
	<td>���̵�</td><td><%= memberID %></td>
</tr>
<tr>
	<td>�����丮</td>
	<td>
<%
			String history = null;
			Reader reader = null;
			try {
				reader = rs.getCharacterStream("HISTORY");
				
				if (reader != null) {
					StringBuffer buff = new StringBuffer();
					char[] ch = new char[512];
					int len = -1;
					
					while( (len = reader.read(ch)) != -1) {
						buff.append(ch, 0, len);
					}
					
					history = buff.toString();
				}
			} catch(IOException ex) {
				out.println("�ͼ��� �߻�:"+ex.getMessage());
			} finally {
				if (reader != null) try { reader.close(); } catch(IOException ex) {}
			}
%>
	<%= history %>
	</td>
</tr>
</table>
<%
		} else {
%>
<%= memberID %> ȸ���� �����丮�� �����ϴ�.
<%
		}
	} catch(SQLException ex) {
%>
���� �߻�: <%= ex.getMessage() %>
<%
	} finally {
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (stmt != null) try { stmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
%>

</body>
</html>
