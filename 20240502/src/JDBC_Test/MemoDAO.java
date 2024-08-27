package JDBC_Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

// MemoService 클래스에서 전처리 작업이 완료되어서 넘어온 데이터로 sql 명령을 실행하는 클래스
public class MemoDAO { // (DAO: Database Access Object)
	// MemoVO 객체를 넘겨받아 테이블에 데이터를 저장하는 메서드
	public static boolean insert(MemoVO vo) {
		System.out.println("MemoDAO 안에 insert() 메서드 실행");
		// 데이터가 저장 잘 되었는지 확인하는 변수
		boolean result = false;
		Connection con = null;
		PreparedStatement ps = null;
//		Statement st = null;
		
		try {
//			// 1. Mysql 연결하기
			con = DBUtil.getMysqlCon();
//			st = con.createStatement();
//			
//			// 2. sql 생성하기
//			String sql = "insert into memo values( ";
//			sql += vo.getMemNo() + " , '";
//			sql += vo.getMemTitle() + "', '";
//			sql += vo.getMemContent() + "', '";
//			sql += vo.getMemDate() + "' ) ";
//			
//			// 3. sql 전송하기
//			int rows = st.executeUpdate(sql);
//			
//			// 4. 만약 실행이 정상적으로 되었다면 true, 안 되었다면 false
//			if(rows > 0) {
//				result = true;
//			} else {
//				result = false;
//			}
//			
//			// 자원 닫기
//			st.close();
//			con.close();
			
			// 2. sql 명령문
			String sql = "insert into memo values(?,?,?,?)";
			
			// 3. sql 명령을 임시로 실행한다.
			ps = con.prepareStatement(sql);
			
			// 4. "?"에 데이터를 넣어준다.
			//   sql로 날짜를 전송할 때 문자 타입으로 보내주면 자동으로 날짜 형식으로 들어간다.
			ps.setInt(1, vo.getMemNo());
			ps.setString(2, vo.getMemTitle());
			ps.setString(3, vo.getMemContent());
			ps.setString(4, vo.getMemDate().toString());
			System.out.println(sql);
			
			// 5. 최종 실행 sql 전송
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				result = true;
			} else {
				result = false;
			}
			ps.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		// 실행 결과를 MemoService에게 보낸다.
		return result;
	}
	
	public static void print() {
		System.out.println("MemoDAO 안에 print() 메서드 실행");
		Connection con = null;
		
		try {
			con = DBUtil.getMysqlCon();
			String sql = "select * from memo ";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("글 번호: " + rs.getInt("memoNo"));
				System.out.println("글 제목: " + rs.getString("memoTitle"));
				System.out.println("글 내용: " + rs.getString("memoContent"));
				System.out.println("작성일 : " + rs.getString("memoDate").toString());
				System.out.println();
			}
			System.out.println("전체 출력 완료!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// 테이블에서 글 1건을 얻어오는 메서드
	public static MemoVO selectById(int idx) {
		System.out.println("MemoDAO 안에 selectById() 메서드 실행");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 메모가 있으면 메모의 객체 1건을 리턴시킬 객체가 필요하다.
		MemoVO vo = null;
		
		try {
			con = DBUtil.getMysqlCon();
			String sql = "select * from memo ";
			// 조건
			sql += " where memoNo = ?";
			
			ps = con.prepareStatement(sql); // 실행하겠다!
			ps.setInt(1, idx);
			
			// 조회니까 sql 실행 명령메서드() 작성
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new MemoVO(rs.getInt("memoNo"), rs.getString("memoTitle")
						, rs.getString("memoContent"), rs.getTimestamp("memoDate").toLocalDateTime());
			}
			System.out.println("결과: " + vo);
			
			rs.close();
			ps.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		// 위의 실행한 내용을 MemoService에게 전달한다.
		// 만약 없으면 null, 있으면 memo 객체!
		return vo;
	}

	// 수정할 메서드!
	public static void update(int idx, String title, String content) {
		System.out.println("MemoDAO 안에 update() 메서드 실행");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBUtil.getMysqlCon();
			String sql = "update memo " + 
					"   set " + 
					"	memoContent = ?, " + 
					"	memoTitle = ? " + 
					"   where " + 
					"	memoNo = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setString(2, title);
			ps.setInt(3, idx);

			ps.executeUpdate();
			
			ps.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(int idx) {
		System.out.println("MemoDAO 안에 delete() 메서드 실행");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBUtil.getMysqlCon();
			String sql = "delete FROM memo where memoNo = ?";
;
			ps = con.prepareStatement(sql);
			ps.setInt(1, idx);

			ps.executeUpdate();
			
			ps.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
