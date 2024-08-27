package Network;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// User정보를 DB에 접근해서 저장(create), 조회(read), 수정(update), 삭제(delete) → CRUD (생성, 읽기, 갱신, 삭제)
public class UserDAO {
	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;
	private User user = null;

	// 로그인
	public User login(String id, String password) {
		System.out.println("UserDAO login() 메서드 실행!");

		try {
			conn = DBUtil.getConnection();
			String sql = "select id, password from Users where id = ? and password = ? ";
			pt = conn.prepareStatement(sql);
			pt.setString(1, id);
			pt.setString(2, password);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				user = new User(rs.getString("id"), rs.getString("password"));
			}
			
			if (user.getId() != null) {
				System.out.println("로그인에 성공하였습니다.");
			} else {
				System.out.println("로그인에 실패하였습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	// 회원 추가
	public void insert(User user) {
		System.out.println("UserDAO insert() 메서드 실행!");

		try {
			conn = DBUtil.getConnection();
			String sql = "insert into Users values(?, ?, ?, ?, ?, ?)";

			pt = conn.prepareStatement(sql);
			pt.setString(1, user.getName());
			pt.setString(2, user.getId());
			pt.setString(3, user.getPassword());
			pt.setString(4, user.getPhone());
			pt.setString(5, user.getEmail());
			pt.setString(6, user.getBirthDate());

			int result = pt.executeUpdate();

			if (result == 1) {
				System.out.println("회원가입이 정상적으로 완료되었습니다.");
			} else {
				System.out.println("회원가입에 실패하였습니다.");
			}

			pt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 회원 검색 (아이디 중복 확인)
	public boolean selectByUser(String id) {
		boolean check = false;
		System.out.println("UserDAO selectByUser() 메서드 실행!");

		try {
			conn = DBUtil.getConnection();
			String sql = "select id from Users where id = ? ";
			pt = conn.prepareStatement(sql);
			pt.setString(1, id);
			rs = pt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("id"));
				user = new User(rs.getString("id"));
			}

			if (user.getId() == null) {
				System.out.println("새로 생성이 가능한 아이디입니다.");
				check = true;
				System.out.println(check);
			} else {
				System.out.println(check);
				System.out.println("중복된 아이디입니다.");
			}

			rs.close();
			pt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}
}
