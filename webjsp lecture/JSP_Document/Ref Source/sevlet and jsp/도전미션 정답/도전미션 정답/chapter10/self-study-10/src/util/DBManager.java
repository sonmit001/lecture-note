package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext
					.lookup("java:/comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// ��� ���� �ڿ� �ݾ� ��� �Ѵ�. �ٵ� ������ �ϸ� �������ϱ�
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		// ��� �Ȱ͸� ����.
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DML(insert, update, delete)���� ����ϰ� ���� ����
	public static void close(Statement stmt, Connection conn) {
		// ��� �Ȱ͸� ����.
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
