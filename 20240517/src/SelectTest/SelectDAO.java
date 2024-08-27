package SelectTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SelectDAO {

	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;
	private String sql;
	private ArrayList<Employee> listE = new ArrayList<Employee>();
	private ArrayList<Job> listJ = new ArrayList<Job>();
	private ArrayList<Department> listD = new ArrayList<Department>();
	
	public void select17() throws Exception{
		
	}
	
	public void select8() throws Exception{
		System.out.println("EMPLOYEE 테이블에서 실수령액(6번 참고)이 5천만원 이상인 사원의 이름, 월급, 실수령액, 고용일 조회");
		conn = DBUtil.getConnection();
		sql = " select emp_Name as 이름, salary as 월급, " + 
			  " to_char(nvl(salary *(12 + bonus) -(salary * 12 * 0.03), salary * 12 * 0.97), 'L99,999,999') as 실수령액 " + 
			  " hire_Date as 고용일 " +
			  " FROM EMPLOYEE WHERE ( nvl(salary * (12 + bonus) - (salary * 12 * 0.03), salary * 12 * 0.97) salary * (12 + bonus) ) >= 50000000 ";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		System.out.println("------------------------------------------------------");
		System.out.println("이름\t|월급\t\t|실수령액\t\t|고용일");
		System.out.println("------------------------------------------------------");
		while (rs.next()) {
			String name = rs.getString("이름");
			String salary = rs.getString("월급");
			String actualSalary = rs.getString("실수령액");
			LocalDateTime hire_Date = rs.getTimestamp("고용일").toLocalDateTime();
			System.out.println(name + "\t|" + salary + "\t|" + actualSalary + "\t|" + hire_Date);
		}
	}
	
	public void select7() throws Exception{
		System.out.println("EMPLOYEE 테이블에서 SAL_LEVEL이 S1인 사원의 이름, 월급, 고용일, 연락처 조회");
		conn = DBUtil.getConnection();
		sql = " SELECT emp_Name as 이름, salary as 월급, hire_Date as 고용일, phone as 연락처 FROM EMPLOYEE WHERE sal_Level = 'S1' ";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		System.out.println("-------------------------------------------------------------");
		System.out.println("이름\t|월급\t\t|고용일\t\t\t|연락처");
		System.out.println("-------------------------------------------------------------");
		while (rs.next()) {
			String name = rs.getString("이름");
			String salary = rs.getString("월급");
			LocalDateTime hire_Date = rs.getTimestamp("고용일").toLocalDateTime();
			String phone = rs.getString("연락처");
			System.out.println(name + "\t|" + salary + "\t|" + hire_Date + "\t|" + phone);
		}
	}
	
	public void select6() throws Exception{
		System.out.println("EMPLOYEE 테이블에서 이름, 연봉, 총수령액(보너스포함), 실수령액(총수령액 - (연봉*세금 3%)) 조회");
		conn = DBUtil.getConnection();
		sql = " select emp_Name as \"이름\" , to_char(salary * 12, 'L99,999,999') as \"연봉\", "
				+ " TO_CHAR(nvl(salary * (12 + bonus), salary * 12), 'L99,999,999') as \"총수령액\", "
				+ " TO_CHAR(nvl(salary * (12 + bonus) -(salary * 12 * 0.03), salary * 12 * 0.97), 'L999,999,999,999') as \"실수령액\" from EMPLOYEE ";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		System.out.println("------------------------------------------------------");
		System.out.println("이름\t|연봉\t\t|총수령액\t\t|실수령액");
		System.out.println("------------------------------------------------------");
		while (rs.next()) {
			String name = rs.getString("이름");
			String salary = rs.getString("연봉");
			String total = rs.getString("총수령액");
			String actualSalary = rs.getString("실수령액");
			System.out.println(name + "\t|" + salary + "\t|" + total + "\t|" + actualSalary);
			
//			System.out.printf("%10d %10s %10s %10s", name, salary, total, actualSalary);
		}
	}
	
	public void select5() throws Exception{
		System.out.println("EMPLOYEE테이블의 고용일, 사원 이름, 월급 조회");
		conn = DBUtil.getConnection();
		sql = "select hire_date, emp_Name, salary from EMPLOYEE";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		System.out.println("------------------------------------------------------");
		System.out.println("고용일\t|이름\t\t|월급");
		System.out.println("------------------------------------------------------");
		while (rs.next()) {
			LocalDateTime hire_Date = rs.getTimestamp("고용일").toLocalDateTime();
			String name = rs.getString("이름");
			String salary = rs.getString("월급");
			System.out.println(hire_Date + "\t|" + name + "\t|" + salary);
		}
	}
	
	public void select4() throws Exception{
		System.out.println("EMPLOYEE 테이블의 직원명, 이메일, 전화번호, 고용일 조회");
		conn = DBUtil.getConnection();
		sql = "select emp_Name, email, nvl(phone, 'no phone') phone , hire_date from EMPLOYEE";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		System.out.println("----------------------------------");
		System.out.println("직원명\t|이메일\t\t|전화번호\t\t|입사일");
		System.out.println("----------------------------------");
		while (rs.next()) {
			String emp_Name = rs.getString("emp_Name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String hire_date = rs.getString("hire_date");
			System.out.println(emp_Name + "\t|" + email + "\t|" + phone + "\t|" + hire_date);
		}
	}
	
	public void select3() throws Exception{
		System.out.println("DEPARTMENT 테이블의 모든 정보 조회");
		conn = DBUtil.getConnection();
		sql = "select * from DEPARTMENT";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		System.out.println("----------------------------------");
		System.out.println("부서이름\t|부서명\t\t|지역코드");
		System.out.println("----------------------------------");
		while (rs.next()) {
			String deptID = rs.getString("dept_ID");
			String deptTitle = rs.getString("dept_Title");
			String LocationID = rs.getString("Location_ID");
			System.out.println(deptID + "\t|" + deptTitle + "\t|" + LocationID);
		}
	}

	public void select2() throws Exception{
		System.out.println("JOB 테이블의 직급 이름 조회");
		conn = DBUtil.getConnection();
		sql = "select JOB_NAME from JOB";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		System.out.println("------------");
		System.out.println("직급이름");
		System.out.println("------------");
		while (rs.next()) {
			String jobName = rs.getString("job_Name");
			System.out.println(jobName);
		}
	}
	
	public void select1() throws Exception{
		System.out.println("JOB 테이블의 모든 정보 조회");
		conn = DBUtil.getConnection();
		sql = "select * from JOB";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		System.out.println("---------------------");
		System.out.println("직급코드\t|직급이름");
		System.out.println("---------------------");
		while (rs.next()) {
			String jobCode = rs.getString("job_Code");
			String jobName = rs.getString("job_Name");
			System.out.println(jobCode + "\t|" + jobName);
		}
	}
	
}

//conn = DBUtil.getConnection();
//sql = "select * from Employee";
//pt = conn.prepareStatement(sql);
//rs = pt.executeQuery();
//while(rs.next()) {
//	Employee temp = new Employee();
//	temp.setEmp_ID(rs.getString("emp_Id"));
//	temp.setEmp_Name(rs.getString("emp_Name"));
//	temp.setEmp_No(rs.getString("emp_No"));
//	temp.setEmail(rs.getString("email"));
//	temp.setPhone(rs.getString("phone"));
//	temp.setDept_Code(rs.getString("dept_Code"));
//	temp.setJob_Code(rs.getString("job_Code"));
//	temp.setSal_Level(rs.getString("sal_Level"));
//	temp.setSalary(rs.getInt("salary"));
//	temp.setBonus(rs.getInt("bonus"));
//	temp.setManager_Id(rs.getString("manager_Id"));
//	temp.setHire_Date(rs.getTimestamp("hire_Date").toLocalDateTime());
////	temp.setEnt_Date(rs.getTimestamp("ent_Date").toLocalDateTime());
//	temp.setEnt_Yn(rs.getString("ent_Yn").charAt(0));
//	list.add(temp);
//}
//for(Employee temp : list) {
//	System.out.println("ID: " + temp.getEmp_ID());
//	System.out.println("name: " + temp.getEmp_Name());
//	System.out.println("No: " + temp.getEmp_No());
//	System.out.println("Email: " + temp.getEmail());
//	System.out.println("Phone: " + temp.getPhone());
//	System.out.println("Dept_Code: " + temp.getDept_Code());
//	System.out.println("Job_Code: " + temp.getJob_Code());
//	System.out.println("Sal_Level: " + temp.getSal_Level());
//	System.out.println("salary: " + temp.getSalary());
//	System.out.println("Bonus: " + temp.getBonus());
//	System.out.println("Manager_Id: " + temp.getManager_Id());
//	System.out.println("Hire_Date: " + temp.getHire_Date());
//	System.out.println("Ent_Date: " + temp.getEnt_Date());
//	System.out.println("Ent_Yn: " + temp.getEnt_Yn());
//	System.out.println();
//}
