package JDBC_Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

// 데이터베이스에 접근하는 클래스
// sql에서 전송하면 자바로 변경하고 자바에서 sql로 전송하면 결과를 보낸다
public class StudentDAO {
	private Scanner sc = new Scanner(System.in);
	private Connection co = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 실제 데이터베이스에 정보를 추가하는 메서드
	public boolean insert(Student s) {
		boolean res = false;

		try {
			// 1. DB 연결
			co = DBUtil.getMysqlCon();

			// 2. sql 명령문 작성 - 임시 실행
			String sql = "INSERT INTO Student(name, age, height, weight, grade, major) VALUES (?, ?, ?, ?, ?, ?) ";

			// 3. ?에 데이터 채우기
			ps = co.prepareStatement(sql);

			// 4. sql로 데이터 전송
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setInt(3, s.getHeight());
			ps.setInt(4, s.getWeight());
			ps.setInt(5, s.getGrade());
			ps.setString(6, s.getMajor());

			// 5. 결과를 가지고 Service로 보내기
			int rows = ps.executeUpdate();

			if (rows > 0) {
				res = true;
			} else {
				res = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				co.close();
			} catch (Exception e) {
			}
		}
		return res;
	}

	public int count() {
		int res = 0;
		try {
			co = DBUtil.getMysqlCon();
			String sql = "select count(*) from Student";
			ps = co.prepareStatement(sql);

			rs = ps.executeQuery();
			if (rs.next()) {
				res = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				co.close();
			} catch (Exception e) {
			}
		} 
		return res;
	}

	public ArrayList<Student> select() {
		ArrayList<Student> res = null;

		try {
			co = DBUtil.getMysqlCon();
			String sql = "select * from Student";
			ps = co.prepareStatement(sql);

			rs = ps.executeQuery();

			if (rs.next()) {
				res = new ArrayList<Student>();

				do {
					Student t = new Student();
					t.setName(rs.getString("name"));
					t.setAge(rs.getInt("age"));
					t.setHeight(rs.getInt("height"));
					t.setWeight(rs.getInt("weight"));
					t.setHakbun(rs.getInt("hakbun"));
					t.setGrade(rs.getInt("grade"));
					t.setMajor(rs.getString("major"));

					// 리스트에 추가
					res.add(t);
				} while (rs.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				co.close();
			} catch (Exception e) {
			}
		}

		return res;
	}

	public Student selectByHakbun(int hakbun) {
		// 학생이 있으면 학생의 객체 1건을 리턴시킬 객체가 필요하다.
		Student stu = null;
		try {
			co = DBUtil.getMysqlCon();
			String sql = "select * from Student where hakbun = ?";
			ps = co.prepareStatement(sql);
			ps.setInt(1, hakbun);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				stu = new Student(rs.getString("name"), rs.getInt("age")
						, rs.getInt("height"), rs.getInt("weight")
						, rs.getInt("grade"), rs.getString("major"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				co.close();
			} catch (Exception e) {
			}
		} 
		
		return stu;
	}

	public Student updateByHakbun(int hakbun, int updateH, int updateW) {
		Student upStu = null;
		
		try {
			co = DBUtil.getMysqlCon();
			String sql = "update Student set height = ?, weight = ? where hakbun = ?";
			ps = co.prepareStatement(sql);
			ps.setInt(1, updateH);
			ps.setInt(2, updateW);
			ps.setInt(3, hakbun);
			
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				co.close();
			} catch (Exception e) {
			}
		} 
		return upStu;
	}

	public boolean delete(int hakbun) {
		boolean res = false;
		
		try {
			co = DBUtil.getMysqlCon();
			String sql = "delete from Student where hakbun = ?";
			ps = co.prepareStatement(sql);
			ps.setInt(1, hakbun);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				res = true;
			}			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				co.close();
			} catch (Exception e) {
			}
		} 
		// 삭제 안되면 예외가 발생하거나 false를 넘겨서 결과를 출력
		return res;
	}

}
