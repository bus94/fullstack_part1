package Book_Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getMysqlConn() {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tableMemo?serverTimezone=UTC";
			String user = "root";
			String password = "1234";

			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수없습니다.");
		} catch (SQLException e) {
			System.out.println("sql에러입니다.");
		}

		return conn;

	}
	
	public static void close(Connection conn, PreparedStatement pt) {
		if (conn != null) {
			try {
				pt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
