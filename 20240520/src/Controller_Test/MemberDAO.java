package Controller_Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;
	private String sql;
	private MemberVO member = new MemberVO();

	// DB에 연결해서 결과값 넘겨줄 역할
	public int login(MemberVO member) {
		try {
			conn = DBUtil.getConnection();
			sql = " select hakbun , passwd from member where hakbun = ? , passwd = ? ";
			pt = conn.prepareStatement(sql);
			pt.setString(1, member.getHakbun());
			pt.setString(1, member.getPasswd());
			rs = pt.executeQuery();
			
			while(rs.next()) {
				member = new MemberVO(rs.getString("hakbun"), rs.getString("passwd"));
				return 1;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
