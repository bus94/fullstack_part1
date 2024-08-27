package Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;
	private Statement st;
	private String sql;

	// 1번 문제
	public void join1(Student student) throws Exception {
//		"1) 다음 중 올바른 것을 모두 고르시오. "
//		"a) 홍팍이의 프로그래밍 성적은 80점을 받아 A0(4.0)이다."
//		"b) 라이언의 프로그램밍 성적은 79점을 받아 B+(3.5)이다."
//		"c) 젤리의 대학 수학 성적은 68점을 받아 C+(2.5)이다."
//		"d) 알파고의 영작문 성적은 91점을 받아 A+(5.0)이다."
		// 입력받아 확인할 수 있도록 작성
		conn = DBUtil.getConnection();
		sql = "select s.nickname as 이름, c.title as 과목, g.exam_score as 점수, g.grade as 등급, p.point as 학점 "
				+ " from students s " + " join grades g on g.student_id = s.id "
				+ " join courses c on c.id = g.course_id " + " join grade_points p on p.grade = g.grade "
				+ " WHERE s.nickname = ? AND c.title = ? ";
		pt = conn.prepareStatement(sql);
		pt.setString(1, student.getNickname());
		pt.setString(2, student.getTitle());
		rs = pt.executeQuery();

		if (rs.next()) {
			System.out.println("============================");
			System.out.println(rs.getString("이름") + "이의 " + rs.getString("과목") + " 성적은 " + rs.getString("점수") + "점을 받아 "
					+ rs.getString("등급") + "(" + rs.getString("학점") + ")이다.");
			System.out.println("============================");
		}
	}

	// 2번 문제
	public void join2() throws Exception {
		conn = DBUtil.getConnection();
		sql = "SELECT  c.title AS 과목명, round(AVG(exam_score), 2) AS \"평균 시험점수\" " + " FROM grades g "
				+ " JOIN courses c ON c.id = g.course_id " + " GROUP BY c.title, course_id ";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		System.out.println("============================");
		System.out.println("[과목별 평균 시험점수]");
		if (rs.next()) {
			do {
				System.out.println("과목명: \"" + rs.getString("과목명") + "\", 평균 시험점수: " + rs.getString("평균 시험점수") + "점");
			} while (rs.next());
		}
		System.out.println("============================");
	}

	public void join3() throws Exception {
		conn = DBUtil.getConnection();
		sql = "SELECT s.nickname AS \"닉네임\", round(AVG(p.point), 2) AS \"평균 학점\"\r\n"
				+ "FROM students s JOIN grades g ON s.id = g.student_id JOIN grade_points p ON g.grade = p.grade "
				+ " where s.nickname in ('알파고', '라이언') " + " GROUP BY s.nickname, student_id ";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		System.out.println("============================");
		System.out.println("[학생별 평균 학점(등급점수)을 수강성적 및 해당 점수가 3.5 미만인 학생 조회]");
		if (rs.next()) {
			do {
				System.out.println("닉네임: " + rs.getString("닉네임"));
				System.out.println("평균 학점: " + rs.getString("평균 학점"));
			} while (rs.next());
		}
		System.out.println("============================");
	}

	public void join4() throws Exception {
		conn = DBUtil.getConnection();
		sql = "SELECT title AS \"강의명\", \"평균 학점\" " + 
				" FROM ( " + " SELECT c.title, ROUND(AVG(gp.point), 2) AS \"평균 학점\" FROM courses c\r\n" + 
				" JOIN grades g ON c.id = g.course_id " + 
				" JOIN grade_points gp ON g.grade = gp.grade " + 
				" GROUP BY c.title ORDER BY AVG(gp.point) DESC " + ") WHERE ROWNUM <= 3 ";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		System.out.println("============================");
		System.out.println("[모든 강의별 평균 학점(등급점수)을 구하고, 이보다 후하게 준 “꿀 강의” TOP3를 조회]");
		if (rs.next()) {
			do {
				System.out.println("강의명: " + rs.getString("강의명"));
				System.out.println("평균 학점: " + rs.getString("평균 학점"));
			} while (rs.next());
		}
		System.out.println("============================");
	}
}
