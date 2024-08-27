package Select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class SelectMain1 {

	public static void main(String[] args) {
		/*
		 * select - ResultSet: 데이터를 조회한 결과 - select 구문에 의해 반환된 행들의 집합 - ResultSet은 0개
		 * 이상의 행이 포함될 수 있고 특정한 기준에 의해서 정렬 가능
		 * 
		 * select 컬럼명[ , 컬럼명] * (한 행 전부) from 테이블명 where 조건식;
		 * 
		 */

		try {
			Connection conn;
			PreparedStatement pt;
			ResultSet rs;

//			System.out.println("* select1 *");

			ArrayList<Employee> list = new ArrayList<Employee>();

			conn = DBUtil.getConnection();
//			String sql = " select EMP_ID, EMP_NAME, SALARY from employee ";
//			pt = conn.prepareStatement(sql);
//			rs = pt.executeQuery();
//			
//			while(rs.next()) {
//				Employee temp = new Employee();
//				
//				temp.setEmp_ID(rs.getString("emp_ID"));
//				temp.setEmp_Name(rs.getString("emp_Name"));
//				temp.setSalary(rs.getInt("salary"));
//				
//				list.add(temp);
//			}
//			select1(list);
//			// 직원 전부의 연봉을 출력하시오.
//			// 직원의 이름, 월급, 연봉
//			System.out.println("\n직원들의 연봉 출력을 출력합니다. (이름, 월급, 연봉)");
//			String sql = " select EMP_NAME as 이름, SALARY \"월급(원)\", SALARY * 12 as \"연봉(원)\" from employee ";
//			
//			pt = conn.prepareStatement(sql);
//			rs = pt.executeQuery();
//			
//			while (rs.next()) { // 별칭을 썼다면 별칭으로 rs에서 불러와야한다. ex) 월급을 salary로 쓰면 에러 발생
//				System.out.println("연봉(원): " + rs.getInt("연봉(원)"));
//			}

			// AND OR - sql 코드를 자바에서 전송해서 결과 출력
//			select2(conn);
//			System.out.println();
//			select3(conn);
//			select4(conn);
			select5(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 사번, 이름, 월급을 조회(출력)하는 메서드
	public static void select1(ArrayList<Employee> list) {
		// list에서 하나씩 Employee 타입으로 꺼내서 temp에 저장하고 출력
		for (Employee temp : list) {
			System.out.println("ID: " + temp.getEmp_ID());
			System.out.println("name: " + temp.getEmp_Name());
			System.out.println("salary: " + temp.getSalary());
		}
	}

	public static void select2(Connection conn) throws Exception {
		PreparedStatement pt;
		ResultSet rs;
		System.out.println("WHERE AND");

		String sql = " SELECT " + "    emp_name, " + "    dept_code, " + "    salary " + " FROM " + "    employee "
				+ " WHERE " + "        dept_code = 'D6' " + "    AND salary >= 2000000 ";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		System.out.println("이름\t|부서코드\t|월급");
		System.out.println("------------------------");

		while (rs.next()) {
//			System.out.println("이름: " + rs.getString("emp_Name"));
//			System.out.println("부서코드: " + rs.getString("dept_Code"));
//			System.out.println("급여: " + rs.getInt("salary"));
//			System.out.println();
			String name = rs.getString("emp_Name");
			String dept = rs.getString("dept_Code");
			int salary = rs.getInt("salary");
			System.out.println(name + "\t|" + dept + "\t|" + salary);
		}

	}

	public static void select3(Connection conn) throws Exception {
		PreparedStatement pt;
		ResultSet rs;
		System.out.println("WHERE OR");

		String sql = " SELECT " + "    emp_name, " + "    dept_code, " + "    salary " + " FROM " + "    employee "
				+ " WHERE " + "        dept_code = 'D6' " + "    OR salary >= 2000000 ";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
//		while (rs.next()) {
//			System.out.println("이름: " + rs.getString("emp_Name"));
//			System.out.println("부서코드: " + rs.getString("dept_Code"));
//			System.out.println("급여: " + rs.getInt("salary"));
//			System.out.println();
//		}
		System.out.println("이름\t|부서코드\t|월급");
		System.out.println("------------------------");

		while (rs.next()) {
//			System.out.println("이름: " + rs.getString("emp_Name"));
//			System.out.println("부서코드: " + rs.getString("dept_Code"));
//			System.out.println("급여: " + rs.getInt("salary"));
//			System.out.println();
			String name = rs.getString("emp_Name");
			String dept = rs.getString("dept_Code");
			int salary = rs.getInt("salary");
			System.out.println(name + "\t|" + dept + "\t|" + salary);
		}

	}

	// LIKE 전씨 직원의 이름과 급여를 조회하는 메서드
	// 키보드를 이용해서 성씨를 입력 받는다.
	public static void select4(Connection conn) throws Exception {
		PreparedStatement pt;
		ResultSet rs;
		System.out.println("LIKE를 이용한 조회 메서드");

		String sql = "SELECT " + "    emp_name, " + "    salary " + " FROM " + "    employee "
				+ " WHERE " + "    emp_name LIKE ? "; // LIKE ?% 로 하게 되면 ?와 % 연결이 되지 않게 된다.(에러)
		pt = conn.prepareStatement(sql);
		System.out.print("조회할 이름의 성씨: ");
		Scanner scan = new Scanner(System.in);
		String selName = scan.nextLine();
		pt.setString(1, selName + "%"); // 따라서 입력문자 + "%" 로 ?에 넣어줘야 해당 값으로 받아 제대로 조회가 된다.
		// 방법 1
//		selName += "%"; // 이렇게 작성해도 될 것으로 보인다.
//		pt.setString(1, selName);
		// 방법 2
//		String sql = "SELECT " + "    emp_name, " + "    salary " + " FROM " + "    employee "
//				+ " WHERE " + "    emp_name LIKE '" + selName + "%' ";
		rs = pt.executeQuery();
		
		System.out.println("-----------------");
		System.out.println("이름\t|월급");
		System.out.println("-----------------");
		while(rs.next()) {
			String name = rs.getString("emp_Name");
			int salary = rs.getInt("salary");
			System.out.println(name + "\t|" + salary);
		}
		System.out.println("-----------------");
	}
	
	public static void select5(Connection conn) throws Exception{
		PreparedStatement pt;
		ResultSet rs;
		System.out.println("WHERE AND, OR");
		
		String sql = "SELECT EMP_NAME, SALARY, JOB_CODE " + 
				" FROM EMPLOYEE " + 
				" WHERE (JOB_CODE = 'J7' " + 
				" OR JOB_CODE = 'J2') " + 
				" AND SALARY > 2000000 ";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		
		System.out.println("--------------------------------");
		System.out.println("이름\t|월급\t\t|직급코드");
		System.out.println("--------------------------------");
		
		while(rs.next()) {
			String name = rs.getString("emp_Name");
			int salary = rs.getInt("salary");
			String jcode = rs.getString("job_Code");
			System.out.println(name + "\t|" + salary + "\t|" + jcode);
		}
		System.out.println("--------------------------------");
	}

}
