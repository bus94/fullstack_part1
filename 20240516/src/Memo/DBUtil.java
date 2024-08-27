package Memo;

import java.sql.Connection;
import java.sql.DriverManager;

// Oracle 연결하는 클래스
public class DBUtil {
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "1234";
			
			conn = DriverManager.getConnection(url, user, password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return conn;
	}
	
	
	
	
	
}
