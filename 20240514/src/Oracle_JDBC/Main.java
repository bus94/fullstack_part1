package Oracle_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {

		try {
			// 외부 클래스 파일을 읽어오기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// URL, User(id), Password(pw)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "KH";
			String password = "KH";
			
			// 실제 데이터베이스 연결하는 인터페이스 변수
			Connection conn = DriverManager.getConnection(url, user, password);
			
			if(conn != null) {
				System.out.println(conn);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
