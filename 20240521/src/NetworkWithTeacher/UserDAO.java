package NetworkWithTeacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// User정보를 DB에 접근해서 저장(create), 조회(read), 수정(update), 삭제(delete) → CRUD (생성, 읽기, 갱신, 삭제)
public class UserDAO {
	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;

	public boolean join(User user) throws Exception {
		System.out.println("UserDAO join() 메서드 실행!");
		System.out.println(user);
		conn = DBUtil.getConnection();
		String sql = "insert into UserList values(?, ?, ?, ?, ?, ?)";

		pt = conn.prepareStatement(sql);
		pt.setString(1, user.getName());
		pt.setString(2, user.getId());
		pt.setString(3, user.getPassword());
		pt.setString(4, user.getPhoneNumber());
		pt.setString(5, user.getEmail());
		pt.setString(6, user.getBirthDate());

		int result = pt.executeUpdate();

		pt.close();
		conn.close();

		return result > 0 ? true : false;
	}

	public User login(String id, String password) throws Exception{
		User user = null;
		
		System.out.println("UserDAO login() 메서드 실행!");
		
		// DB 연결
		conn = DBUtil.getConnection();
		String sql = "select * from UserList where id = ? and password = ? ";

		// sql 실행
		pt = conn.prepareStatement(sql);
		pt.setString(1, id);
		pt.setString(2, password);

		rs = pt.executeQuery();
		if(rs.next()) {
			user = new User(
					rs.getString("name"),
					rs.getString("id"),
					rs.getString("password"),
					rs.getString("phone_number"),
					rs.getString("email"),
					rs.getString("birth_date")
					);
		}
		
		rs.close();
		pt.close();
		conn.close();
		
		return user;
	}
}
