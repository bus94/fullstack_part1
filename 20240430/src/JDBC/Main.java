package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		// 데이터베이스란?
		// : 데이터의 저장소
		// - 여러 사람들이 공유하고 사용할 목적으로 통합 관리되는 데이터들의 모임
		
		// DBMS (DataBase Management System)
		// - 데이터를 관리하기 위해서 사용하는 형태
		
		// SQL
		// - 데이터베이스에 추가, 조회, 삭제하는 명령어
		// ex) 오라클, Mysql
		
		// 데이터베이스랑 자바는 호환이 안된다.
		// → 호환할 수 있도록 연결하는 기술
		//   : JDBC(Java Database Connection)
		// mysql 서버(데이터를 제공하는 컴퓨터)
		
		// 외부에서 추가된 JDBC안에 연결을 하려면
		// Driver.class파일을 Main.java파일에 추가해야된다.
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 연결하는 클래스를 읽어왔다. 그 안에서 데이터베이스랑 Mysql을 연결하는 getConnection() 메서드
			
			// url에 사용할 mysql이 설치된 경로와 데이터베이스 이름을 적는다.
			
			// localhost는 접속할 mysql이 설치된 컴퓨터가 현재 사용중인 컴퓨터 임을 의미하여
			// localhost대신 127.0.0.1을 사용해도 된다.
			
			// 3306 : Mysql이 컴퓨터와 통신할 때 사용하는 포트번호
			// 오라클 번호 1521 기본 포트번호
			String url = "jdbc:mysql://localhost:3306/java?serverTimezone=UTC";
			
			// 위의 정보를 저장 했으면 실제 데이터베이스로 연결하는 getConnection() 메서드를 이용
			// getConnection(url, id, password)
			// → 연결된 객체를 반환한다. Connection 객체
			conn = DriverManager.getConnection(url, "root", "1234");
			
			System.out.println(conn);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없다!");
		} catch(SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다!"); 
			// 에러 발생 시 url 등의 코드 중 오타일 확률이 가장 높다
			// 또는 경로가 잘못된 경우가 많다
		} finally {
			// 데이터베이스 작업이 완료되면 사용한 모든 객체를 닫는다.
			if(conn != null) {
				try {conn.close();} 
				catch (SQLException e) {}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
