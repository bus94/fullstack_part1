package JDBC_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getMysqlCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/memoList?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			con = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버를 읽어 올 수 없습니다.");
		}catch(SQLException e) {
			System.out.println("데이터베이스 접속 정보 에러!");
			System.out.println("혹은 문법 에러!");
		}
		return con;
	}
	
	public static void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
