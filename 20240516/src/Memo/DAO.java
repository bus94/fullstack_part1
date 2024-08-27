package Memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {
	static Connection conn;
	static PreparedStatement pt;
	static ResultSet rs;

	public static ArrayList<MemoVO> select() {
		ArrayList<MemoVO> list = new ArrayList<MemoVO>();

		try {
			conn = DBUtil.getConnection();
			String sql = "select * from board ";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();

			while (rs.next()) {
				MemoVO temp = new MemoVO();
				temp.setIdx(rs.getInt("idx"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setMemo(rs.getString("memo"));
				// Timestamp 클래스를 이용하고, 해당 클래스는 java.sql에 포함되어있다.
				Timestamp date = rs.getTimestamp("writeDate");
				temp.setWriteDate(date.toLocalDateTime());

//				// DAO에서 저장할 때 오늘 날짜와 비교하여 저장
//				LocalDateTime today = LocalDateTime.now();
//				LocalDateTime memoDate = date.toLocalDateTime();
//				
//				if(memoDate.equals(today)) {
//					// 오늘 날짜인 경우 시간만 출력
//					temp.setWriteDate(memoDate.toLocalTime());
//				} else {
//					temp.setWriteDate(memoDate);
//				}

				list.add(temp);
			}
			rs.close();
			pt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 데이터 추가하는 메서드
	// 게시글을 하나 추가하는 메서드로 만들기
	public static void insert(MemoVO temp) {
		System.out.println("Dao 클래스 insert()");
		int result = 0;
		try {
			// 1. DB 연결
			conn = DBUtil.getConnection();

			// 2. sql 명령문
			String sql = "insert into board(idx, name, password, memo, writeDate) ";
			sql += " values(board_idx1.nextval, ?, ?, ?, SYSDATE) ";

			// 3. 임시 전송
			pt = conn.prepareStatement(sql);
			pt.setString(1, temp.getName());
			pt.setString(2, temp.getPassword());
			pt.setString(3, temp.getMemo());

			result = pt.executeUpdate();
			System.out.println("전송: " + result);
			System.out.println("게시글이 성공적으로 추가되었습니다!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pt != null)
					pt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Service에서 넘어온 수정된 vo객체를 이용해서 기존 데이터에 있는 내용을 update하기
	public static int update(MemoVO vo) {
		conn = DBUtil.getConnection();
		int result = 0;
		try {
			String sql = "update board ";
			sql += " set name = ?, memo = ?, password = ? ";
			sql += " where idx = ? ";
			
			pt = conn.prepareStatement(sql);
			pt.setString(1, vo.getName());
			pt.setString(2, vo.getMemo());
			pt.setString(3, vo.getPassword());
			pt.setInt(4, vo.getIdx());
			
			result = pt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// DAO 클래스 안의 search() 실행해서 아이디를 입력 받아 검색해서 반환하는 메서드
	public static MemoVO search(String name) {
		MemoVO vo = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "select * from board ";
			sql += " where name = ? ";

			pt = conn.prepareStatement(sql);
			pt.setString(1, name);

			rs = pt.executeQuery();

			if (rs.next()) {
				vo = new MemoVO(rs.getInt("idx"), rs.getString("name"), rs.getString("password"),
						  rs.getString("memo"), rs.getTimestamp("writeDate").toLocalDateTime());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}

	public static int delete(MemoVO vo) {
		conn = DBUtil.getConnection();
		int result = 0;
		try {
			String sql = "delete from board ";
			sql += " where name = ? ";
			
			pt = conn.prepareStatement(sql);
			pt.setString(1, vo.getName());
			
			result = pt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
	}

}
