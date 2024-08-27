import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// Member DB에 접근 할 수 있는 클래스
public class MemberDAO {
	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;
	private String sql;
	private Member member = new Member();

	public MemberDAO() {
	}

	public void select(String hakbun) {

	}

	public Member login(String hakbun, String passwd) {
		String hakbunSel = "";
		String passwdSel = "";

		try {
			conn = DBUtil.getConnection();
			sql = " select * from member where hakbun = ? ";
			pt = conn.prepareStatement(sql);
			pt.setString(1, "hakbun");
			rs = pt.executeQuery();

			hakbunSel = rs.getString("hakbun");
			passwdSel = rs.getString("passwd");
			member = new Member(hakbunSel, passwdSel);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

}
