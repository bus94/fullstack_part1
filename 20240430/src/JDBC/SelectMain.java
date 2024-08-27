package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectMain {

	public static void main(String[] args) {

		/*
		 * DAO(Database Access Object) : DB에 접속하여 실제 데이터를 추가하거나 결과를 조회해서 전달받는 클래스
		 * 
		 * DTO(Data Transfer Object) : DB의 각 컬럼(열)에 저장하는 클래스로 사용된다.
		 * 
		 */

		// Select를 하기 위해서 또 mysql을 연결해야된다.
		Connection con = null;
		try {
			// 1. 드라이버 포함하기
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. url, id, password
			String url = "jdbc:mysql://localhost:3306/java?serverTimezone=UTC";

			// 3. 실제 접속하기 위해 메서드 호출
			con = DriverManager.getConnection(url, "root", "1234");
			
			// 4. 조회한 내용을 가져오기
			String sql = "select * from memberlist"; // 공백은 구분만 해주면 되고, 입력할 때 ""안에 ;은 넣으면 안된다.
			
			// 5. sql 명령문을 데이터베이스 전송하려면 전송 기능을 가지고 있는 객체들이 있다.
			Statement stmt = con.createStatement();
			
			// 6. executeQuery(sql명령문);
			// 	  : 데이터를 조회할 때 사용하는 메서드
			// ResultSet DB에서 테이블의 행과 열의 집합으로 이루어진 결과를 반환한다. (한 행씩 접근)
			ResultSet rs = stmt.executeQuery(sql);

			// 7. 위의 결과가 있는지 없는지 확인
			//   next() 메서드 : 다음 행으로 이동한다. 데이터가 있으면 true, 없으면 false
			while(rs.next()) {
				System.out.println("id: " + rs.getString("id")); // rs.getString("컬럼명");
				System.out.println("pw: " + rs.getString("pw"));
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			// mysql의 드라이버 정보를 못 가져올 수 있다.
			// 경로가 잘못되거나 오타로 인해서 예외가 발생할 수 있다.
			System.out.println("드라이버를 찾지 못했다!");
		} catch (SQLException e) {
			System.out.println("정보가 잘못 되었다!");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}

	}

}
