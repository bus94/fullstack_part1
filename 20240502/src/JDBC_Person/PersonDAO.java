package JDBC_Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonDAO {
	public static int countStudent = 0;
	public static int countEmployee = 0;

	public static boolean insertStudent(StudentVO svo) {
		System.out.println("PersonDAO 안에 insertStudent() 메서드 실행");
		boolean result = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBUtil.getMysqlCon();
			String sql = "INSERT INTO Student VALUES (?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, svo.getHakbun());
			ps.setString(2, svo.getName());
			ps.setInt(3, svo.getHeight());
			ps.setInt(4, svo.getWeight());
			ps.setInt(5, svo.getGrade());
			ps.setString(6, svo.getMajor());
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				result = true;
			} else {
				result = false;
			}
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean insertEmployee(EmployeeVO evo) {
		System.out.println("PersonDAO 안에 insertEmployee() 메서드 실행");
		boolean check = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBUtil.getMysqlCon();
			String sql = "INSERT INTO Employee VALUES (?, ?, ?, ?, ?, ?, ?) ";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, evo.getEmpNo());
			ps.setString(2, evo.getName());
			ps.setInt(3, evo.getAge());
			ps.setInt(4, evo.getHeight());
			ps.setInt(5, evo.getWeight());
			ps.setInt(6, evo.getSalary());
			ps.setString(7, evo.getDept());
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				check = true;
			}else {
				check = false;
			}
			ps.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public static boolean printStudent() {
		System.out.println("PersonDAO 안에 printStudent() 메서드 실행");
		Connection con = null;
		PreparedStatement ps = null;
		boolean check = false;
		
		try {
			con = DBUtil.getMysqlCon();
			String sql = " select * from Student";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("학번: " + rs.getInt("hakbun"));
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("키   : " + rs.getInt("height"));
				System.out.println("몸무게: " + rs.getInt("weight"));
				System.out.println("학년: " + rs.getInt("grade"));
				System.out.println("전공: " + rs.getString("major"));
				System.out.println();
				countStudent++;
			}
			check = true;
			rs.close();
			ps.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public static boolean printEmployee() {
		System.out.println("PersonDAO 안에 printEmployee() 메서드 실행");
		Connection con = null;
		PreparedStatement ps = null;
		boolean check = false;
		
		try {
			con = DBUtil.getMysqlCon();
			String sql = " select * from Employee";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("사번: " + rs.getInt("empNo"));
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("나이: " + rs.getInt("age"));
				System.out.println("키   : " + rs.getInt("height"));
				System.out.println("몸무게: " + rs.getInt("weight"));
				System.out.println("월급: " + rs.getInt("salary"));
				System.out.println("부서: " + rs.getString("dept"));
				System.out.println();
				countEmployee++;
			}
			check = true;
			rs.close();
			ps.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}

}
