package JDBC;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// JDBC
		// - 자바 언어로 다양한 종류의 관계형 데이터베이스에
		// 접속하고 SQL 문을 수행하여 처리하는 표준 SQL 인터페이스
		// API

		// - java.sql 패키지 안에 있는 내용들
		// 메서드 몸체를 구현한 클래스 파일들이 필요하다.

		// JDBC 드라이버 로딩
		// - 압축 푼 JDBC 드라이버 파일을 사용할 수 있도록 메모리에 로딩해야됨

		// Class.forName(드라이버명)
		// Mysql : com.mysql.cj.jdbc.Driver
		// Oracle : oracle.jdbc.driver.OracleDriver

		// DB와 연결을 해야한다.
		// java.sql.DriverManager 클래스의 getConnection() 메서드 이용해서
		// 실제 자바 프로그램과 DB를 네트워크 상에서 연결
		// - 연결 성공하면 Connection 객체로 표현하여 반환한다.

		// getConnection((1), (2), (3));
		// (1) URL : 접속할 서버의 URL, 프로토콜(네트워크 송신을 위한 규칙), 서버주소
		// , DB 이름으로 구성된다.
		// jdbc : [DBMS]
		// mysql jdbc : mysql://서버주소/DB명
		// oracle jdbc : oracle:thin@서버주소,서비스번호
		// (2) user : DB서버에 로그인할 계정
		// mysql : root 최고 관리자
		// oracle : system 또는 sys
		// (3) password : DB서버에 로그인할 비밀번호

//		select();
//		System.out.println();
//		selectNameNo();
//		System.out.println();
//		selectPrice();
//		System.out.println();
//		selectPrice2();
//		System.out.println();
//		selectDate();
//		selectMember();
//		checkId();
//		findBookTitle(); // 미완성
	}

	// 회원가입 시 아이디가 중복인지 확인하는 메서드
	public static void checkId() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("회원가입할 아이디: ");
			String checkid = sc.nextLine();

			Connection con = DBUtil.getMysqlCon();

			String sql = "select count(*) from member ";
			sql += " where member_id = '" + checkid + "' ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				// mysql은 1번부터 인덱스(번호)가 시작된다.
				// oralce은 0번부터 인덱스(번호)가 시작된다.
				int count = rs.getInt(1); // 따라서 컬럼인덱스를 1로 한 것!
				if (count > 0) {
					System.out.println("중복된 아이디입니다.");
				} else {
					System.out.println("사용 가능한 아이디입니다.");
				}
			}
			
			DBUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 책을 검색할 때 책의 제목에 키보드로 입력한 단어가 포함된 책의 정보를 모두 출력하는 메서드
//	public static void findBookTitle() {
//		Scanner sc = new Scanner(System.in);
//
//		try {
//			System.out.print("검색할 제목: ");
//			String selTitle = sc.nextLine();
//
//			Connection con = DBUtil.getMysqlCon();
//
//			String sql = "select * from book ";
//			sql += " where book_title = '" + selTitle + "' ";
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			
//			ArrayList<Book> listBook = new ArrayList<Book>();
//			Book b = null;
//			while (rs.next()) {
//				b = new Book(rs.getInt("book_no") + rs.getInt("book_kind") 
//				+ rs.getString("book_title") + rs.getInt("book_price") 
//				+ rs.getInt("book_count") + rs.getString("book_author") 
//				+ rs.getString("book_publishing_com") + rs.getString("book_image") 
//				+ rs.getString("book_content") + rs.getString("book_discount_rate"));
//				listBook.add(b);
//			}
//			System.out.println(listBook);
//			DBUtil.close(con);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// 멤버 id를 입력하면 값이 있으면 멤버의 id와 이름만 출력하고, 없으면 "찾을 수 없습니다!" 출력
	public static void selectMember() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("아이디 입력: ");
			String id = sc.nextLine();

			Connection con = DBUtil.getMysqlCon();

			String sql = "select member_id, member_name from member ";
			sql += " where member_id = '" + id + "' ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			// 한 건에 대한 데이터가 오면 if문으로 설정
			// 모르겠으면 반복문 사용해야한다. ex) 책 가격이 15000원 이상의 책 정보 가져오기
			if (rs.next()) {
				System.out.println("아이디: " + rs.getString("member_id"));
				System.out.println("이름 : " + rs.getString("member_name"));
			} else {
				System.out.println("찾을 수 없습니다!");
			}
			DBUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// book 테이블에서 입력받은 year 이전에 등록된 책 정보 가져오기
	public static void selectDate() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("조회 할 날짜: ");
			String date = sc.nextLine();

			Connection con = DBUtil.getMysqlCon();

			String sql = "select * from book ";
			// 자바에서는 문자열로 입력받았고 그에 따라 sql에게 알려줘야한다.
			// → 문자 형태로 날짜를 비교한다고 sql에 알려줘야하기 때문에 작은 따옴표를 기입해야한다.
			// 작은 따옴표를 안 쓰면 객체는 생성되지만 조회할 데이터가 없다고 나온다.
			sql += " where book_reg_date < '" + date + "' ";
			System.out.println("실행할 쿼리: " + sql);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println("책 제목: " + rs.getString("book_title"));
				System.out.println("등록일 : " + rs.getString("book_reg_date"));
				System.out.println();
			}
			DBUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 책의 가격을 입력 받아서 입력받은 결과만 조회
	public static void selectPrice2() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("가격: ");
			int price = sc.nextInt();

			// DB에서 입력한 가격 이상인 책의 결과
			Connection con = DBUtil.getMysqlCon();

			// sql 문장
			String sql = "select * from book "; // *주의* 공백 반드시 기입하기
			sql += " where book_price >= " + price;
			System.out.println(sql);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println("책 제목: " + rs.getString("book_title"));
				System.out.println();
			}
			DBUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 책의 제목, 책의 원가, 원가의 10% 인상한 결과 출력 메서드
	public static void selectPrice() {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/db1_book_store?serverTimezone=UTC";
//			String user = "root";
//			String password = "1234";
//			Connection con = DriverManager.getConnection(url, user, password);
			Connection con = DBUtil.getMysqlCon();
			Statement st = con.createStatement();
			// sql 문장
			// 문자열로 여러 줄로 보낼 경우 공백을 앞뒤로 한 칸씩 줘서 보내야 하나의 문자로 연결되었을 때
			// 에러없이 사용 가능하다.
			String sql = "SELECT " + "	book_title, " + "   book_price, "
					+ "	book_price + book_price * 0.1 as 'price' " + "FROM book";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String title = rs.getString("book_title");
				int price = rs.getInt("book_price");
				int priceA = rs.getInt("price");
				System.out.println("책의 제목: " + title);
				System.out.println("책의 원가: " + price);
				System.out.println("원가의 10% 인상된 가격: " + priceA);
				System.out.println();
			}
			DBUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 부분 조회를 하는 메서드
	public static void selectNameNo() {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/db1_book_store?serverTimezone=UTC";
//			String user = "root";
//			String password = "1234";
//			Connection con = DriverManager.getConnection(url, user, password);
			Connection con = DBUtil.getMysqlCon();
			Statement st = con.createStatement();
			String sql = "select member_no, member_name from member";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int no = rs.getInt("member_no");
				String name = rs.getString("member_name");
				System.out.println("no: " + no);
				System.out.println("name: " + name);
			}
			DBUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 전체 조회를 하는 메서드
	public static void select() {
		try { // 드라이버를 가지고 오다가 예외가 발생할 수 있기에 try-catch 문 필요
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/db1_book_store?serverTimezone=UTC";
//			String user = "root";
//			String password = "1234";
//
//			Connection con = DriverManager.getConnection(url, user, password);
			Connection con = DBUtil.getMysqlCon();
			// System.out.println(con); - 연결확인
			// - 출력 : com.mysql.cj.jdbc.ConnectionImpl@6253c26

			// 조회를 하기 위해서 자바 프로그램에서 DB쪽으로 SQL문을 전송하고
			// DB는 처리된 결과를 다시 자바 프로그램으로 전달해야된다.
			// 이 역할을 하는 것이 Statement

			// Connection 객체가 제공하는 createStatement()
			Statement st = con.createStatement();

			// 실제 전송을 위한 sql문을 문자열로 작성하면 된다.
			String sql = "select * from member";

			// 전송을 할 때 sql문에 따라서 메서드가 제공된다.
			// 1. select로 조회만 할 것이다!
			// → executeQuery(sql)
			// - 조회의 결과가 ResultSet 객체로 한꺼번에 반환 된다.
			// 내부적으로 커서가 동작한다.
			// next() 이용해서 데이터가 있는지 없는지 파악한다.
			ResultSet rs = st.executeQuery(sql);

			ArrayList<Member> list = new ArrayList<Member>();
			Member m = null;
			while (rs.next()) {
				m = new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_pw"),
						rs.getString("member_name"), rs.getString("member_gender"), rs.getInt("member_point"),
						// 실제 시간을 꺼내오는 메서드를 사용해서 자바가 가지고 있는 LocalDateTime으로 변경할 수 있다.
						// 문자열로 변경하고 싶을 땐 toString()
						rs.getTimestamp("member_reg_date").toLocalDateTime());
				list.add(m);
			}
			System.out.println(list);

			// 2. 추가, 수정, 삭제 등 sql을 변경
			// → executeUpdate(sql)
			// - 실행된 행의 개수를 반환된다. → 반환 타입이 int

			// 작업을 끝냈으면 DB와 관련 처리 작업을 하는 객체들은 모두 메모리에서 해제시켜야 된다.(닫아야한다.)
			// 메모리 해제 시에는 최근 사용했던 객체부터(거꾸로 올라가면서) 해제한다.
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
