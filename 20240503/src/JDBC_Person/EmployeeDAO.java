package JDBC_Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {
	
	private Connection co = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public boolean insert(Employee em) {
		
		boolean res = false;
		
		try {
			co = DBUtil.getMysqlCon();
			String sql = "insert into Employee(name, age, height, weight, salary, dept) "
					+ " values(?, ?, ?, ?, ?, ?) ";
			ps = co.prepareStatement(sql);
			
			ps.setString(1, em.getName());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
