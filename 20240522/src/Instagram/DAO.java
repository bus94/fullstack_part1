package Instagram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;
	private String sql;

	public void join1() throws Exception {
		conn = DBUtil.getConnection();
		sql = "SELECT COUNT(distinct user_id) AS user_count FROM photo";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		if (rs.next()) {
			System.out.println("사진 게시 유저 수: " + rs.getInt(1));
		}

	}

	public void join2() throws Exception {
		conn = DBUtil.getConnection();
		sql = "select p.fileName from comments c join " + " photo p on (c.photo_id = p.id) " + " where c.id = 3";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		if (rs.next()) {
			System.out.println("3번 댓글이 달린 사진: " + rs.getString("fileName"));
		}

	}

	public void join3() throws Exception {
		conn = DBUtil.getConnection();
		sql = "select c.body, u.nickname " + " from photo p " + " join comments c on(c.photo_id = p.id) "
				+ "join user1 u on (u.id = p.user_id) " + "where p.id = 1";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		System.out.println("사진1에 달린\n댓글 내용\t\t|닉네임");
		System.out.println("------------------------------------");
		if (rs.next()) {
			do {
				System.out.println(rs.getString("body") + "\t\t|" + rs.getString("nickname"));
			} while (rs.next());
		}
	}

	public void join4() throws Exception {
		conn = DBUtil.getConnection();
		sql = "select p.filename, u.nickname " + "from photo p " + "join user1 u on (u.id = p.user_id) "
				+ "where p.id = 5";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		if (rs.next()) {
			System.out.println("사진5의\n파일명\t\t\t\t사진 게시자 닉네임");
			System.out.println("--------------------------------------------");
			System.out.println(rs.getString("filename") + "\t\t" + rs.getString("nickname"));
		}
	}
	
	void join5() throws Exception{
		conn = DBUtil.getConnection();
		sql = "SELECT u.nickname, p.filename " + 
				" FROM like3 l " + 
				" JOIN user1 u ON u.id = l.user_id " + 
				" JOIN photo p ON p.id = l.photo_id " + 
				" WHERE p.id = 2";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		
		System.out.println("닉네임\t\t\t|파일명");
		System.out.println("------------------------------------");
		if (rs.next()) {
			do {
				System.out.println(rs.getString("nickname") + "\t\t\t|" + rs.getString("filename"));
			} while (rs.next());
		}
	}

}
