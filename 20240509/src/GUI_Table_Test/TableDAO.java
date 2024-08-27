package GUI_Table_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// 테이블에서 일어나는 DB 접근 클래스!
// 추가, 삭제 하는 내용
public class TableDAO {
	// 전역변수이기 때문에 여러 메서드에서 사용 가능하다.
	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;

	public int insert(Board board) {
		int result = 0;

		try {
//			// 1. mysql과 자바를 연결하는 드라이버 가져온다.
//			// forName() 에는 확장자를 붙일 필요가 없다.
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			// 2. 실제 연결을 하기 위해서
//			String url = "jdbc:mysql://localhost:3306/tableMemo?serverTimezone=UTC";
//			String user = "root";
//			String password = "1234";

			// 3. 연결
			conn = DBUtil.getMysqlConn();

//			System.out.println("연결 성공!");

			// 4. sql
			String sql = "insert into memo ";
			sql += "(title, writer, content, readCount) ";
			sql += " values(?, ?, ?, ?) ";

			PreparedStatement pt = conn.prepareStatement(sql);

			// 5. ? → 채우기
			pt.setString(1, board.getTitle());
			pt.setString(2, board.getWriter());
			pt.setString(3, board.getContent());
			pt.setInt(4, board.getReadCount());

			// 6. DB로 전송
			result = pt.executeUpdate();

			// 7. mysql에 있는 데이터를 모두 조회해서 테이블에 추가하기
			// select(conn, pt);

			DBUtil.close(conn, pt);

		} catch (Exception es) {
			es.printStackTrace();
		}

		return result;
	}

	public String[][] select() {
		// select를 insert와 묶지 말고, 독립적으로 실행될 수 있도록 메서드를 작성한다.
		String[][] result = null;

		try {
			conn = DBUtil.getMysqlConn();
			String countSql = "select count(*) from memo";

			pt = conn.prepareStatement(countSql);
			rs = pt.executeQuery();

			int row = 0;
			if (rs.next()) {
				row = rs.getInt(1);
				System.out.println(row);
			} else {
				return result;
			}

			// 조회하는 sql문 작성
			String sql = "select * from memo";

			rs = pt.executeQuery(sql);

			// 2차원 배열을 선언
			result = new String[row][3];

			// 2차원 배열의 index를 저장하는 변수(공간의 번호 저장)
			int index = 0;

//			// 결과 개수를 파악하기 위해서 count()하기 불편하다.
//			// why? sql구문도 실행하기 때문
//			// ResultSet의 커서를 가장 마지막 행으로 이동시키는 메서드
//			rs.last();
//			System.out.println(rs.getRow());
//			int rowCount = rs.getRow();
//			rs.beforeFirst();

			while (rs.next()) {
				// 결과를 받아와서 테이블에 추가하는 명령문
				result[index][0] = rs.getString("title");
				result[index][1] = rs.getString("writer");
				result[index][2] = rs.getString("content");
				index++;
			}
			// 닫기
			rs.close();
			DBUtil.close(conn, pt);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delete(int num) {

		int result = 0;
		/*
		 * sql 실행문 작성하고 DB 전송하고 결과 반환
		 * 
		 */

		return result;
	}

	// 현재 클릭된 한 행의 번호를 가지고 와서 먼저 탐색하는 sql
	public Board selectByNum(int selectRow) {
		Board board = null;
		try {
			// 1. 먼저 mysql 접속
			conn = DBUtil.getMysqlConn();

			// 2. sql 명령문
			String sql = "select * from memo ";
			sql += " where num = ? ";
			pt = conn.prepareStatement(sql);

			// 3. ? 값 채우기
			pt.setInt(1, selectRow);

			// 4. 전송하기
			rs = pt.executeQuery();
			if(rs.next()) {
				board = new Board(rs.getInt("num"), rs.getString("title"), rs.getString("writer")
						, rs.getString("content"), rs.getInt("readCount"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 5. 결과 리턴!
		return board;
	}

	// 조회 수를 업데이트 하는 메서드
	public int update(Board board) {
		int result = 0;
		try {
			conn = DBUtil.getMysqlConn();

			String sql = "update memo ";
			sql += " set readCount = ? ";
			sql += " where num = ? ";
			pt = conn.prepareStatement(sql);
			pt.setInt(1, board.getReadCount());
			pt.setInt(2, board.getNum());
			
			result = pt.executeUpdate();
			
			if(result > 0) {
				result = 1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 조회 수를 업데이트 하는 메서드

//	public String[] select(Connection conn, PreparedStatement pt) throws Exception {
//		String[] result = null;
//		// 조회하는 sql문 작성
//		String sql = "select * from memo";
//		rs = pt.executeQuery();
//
//		while (rs.next()) {
//			// 결과를 받아와서 테이블에 추가하는 명령문
//			String[] rowData = { rs.getString("title"), rs.getString("writer"), rs.getString("content") };
//			
//		}
//		return result;
//	}
}
