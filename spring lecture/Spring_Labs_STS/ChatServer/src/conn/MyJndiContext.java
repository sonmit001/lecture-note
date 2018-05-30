package conn;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import oracle.jdbc.pool.OracleDataSource;

public class MyJndiContext {
	private static OracleDataSource ds;
	static{
		try {
			//context.xml �� Context�� �о� ���� ���� ��ü�� �����Ѵ�.
			InitialContext ctx = new InitialContext();
			// Resource ��  name���� �о� ����ͼ� OracleDataSource��ü�� ��ȯ
			ds = (OracleDataSource) ctx.lookup("java:comp/env/jdbc/myora");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getDs() throws SQLException {
		return ds.getConnection();
	}
	
	
	
	
	
	

}
