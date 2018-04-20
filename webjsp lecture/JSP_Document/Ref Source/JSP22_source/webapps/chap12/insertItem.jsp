<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.SQLException" %>
<%
	String idValue = request.getParameter("id");
	
	Connection conn = null;
	PreparedStatement pstmtItem = null;
	PreparedStatement pstmtDetail = null;

	String jdbcDriver = "jdbc:mysql://localhost:3306/chap12?" +
						"useUnicode=true&characterEncoding=euckr";
	String dbUser = "jspexam";
	String dbPass = "jspex";
	
	Throwable occuredException = null;
	
	try {
		int id = Integer.parseInt(idValue);
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		conn.setAutoCommit(false);
		
		pstmtItem = conn.prepareStatement("insert into ITEM values (?, ?)");
		pstmtItem.setInt(1, id);
		pstmtItem.setString(2, "��ǰ �̸� " + id);
		pstmtItem.executeUpdate();
		
		if (request.getParameter("error") != null) {
			throw new Exception("�ǵ��� �ͼ��� �߻�");
		}
		
		pstmtDetail = conn.prepareStatement(
			"insert into ITEM_DETAIL values (?, ?)");
		pstmtDetail.setInt(1, id);
		pstmtDetail.setString(2, "�� ���� " + id);
		pstmtDetail.executeUpdate();
		
		conn.commit();
	} catch(Throwable e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch(SQLException ex) {}
		}
		occuredException = e;
	} finally {
		if (pstmtItem != null)
			try { pstmtItem.close(); } catch(SQLException ex) {}
		if (pstmtDetail != null)
			try { pstmtDetail.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
%>
<html>
<head><title>ITEM �� �Է�</title></head>
<body>

<%  if (occuredException != null) { %>
������ �߻��Ͽ���: <%= occuredException.getMessage() %>
<%  } else { %>
�����Ͱ� ���������� ��
<%  } %>
</body>
</html>
