package Select;

import java.time.LocalDateTime;

public class Employee {
	private String emp_ID;
	private String emp_Name;
	private String emp_No;
	private String email;
	private String phone;
	private String dept_Code;
	private String job_Code;
	private String sal_Level;
	private int salary;
	private double bonus;
	private String manager_Id;
	private LocalDateTime hire_Date;
	private LocalDateTime ent_Date;
	private char ent_Yn;
	
	public Employee() {
	}

	public Employee(String emp_ID, String emp_Name, String emp_No, String email, String phone, String dept_Code,
			String job_Code, String sal_Level, int salary, double bonus, String manager_Id, LocalDateTime hire_Date,
			LocalDateTime ent_Date, char ent_Yn) {
		this.emp_ID = emp_ID;
		this.emp_Name = emp_Name;
		this.emp_No = emp_No;
		this.email = email;
		this.phone = phone;
		this.dept_Code = dept_Code;
		this.job_Code = job_Code;
		this.sal_Level = sal_Level;
		this.salary = salary;
		this.bonus = bonus;
		this.manager_Id = manager_Id;
		this.hire_Date = hire_Date;
		this.ent_Date = ent_Date;
		this.ent_Yn = ent_Yn;
	}

	public String getEmp_ID() {
		return emp_ID;
	}

	public void setEmp_ID(String emp_ID) {
		this.emp_ID = emp_ID;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public String getEmp_No() {
		return emp_No;
	}

	public void setEmp_No(String emp_No) {
		this.emp_No = emp_No;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDept_Code() {
		return dept_Code;
	}

	public void setDept_Code(String dept_Code) {
		this.dept_Code = dept_Code;
	}

	public String getJob_Code() {
		return job_Code;
	}

	public void setJob_Code(String job_Code) {
		this.job_Code = job_Code;
	}

	public String getSal_Level() {
		return sal_Level;
	}

	public void setSal_Level(String sal_Level) {
		this.sal_Level = sal_Level;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public String getManager_Id() {
		return manager_Id;
	}

	public void setManager_Id(String manager_Id) {
		this.manager_Id = manager_Id;
	}

	public LocalDateTime getHire_Date() {
		return hire_Date;
	}

	public void setHire_Date(LocalDateTime hire_Date) {
		this.hire_Date = hire_Date;
	}

	public LocalDateTime getEnt_Date() {
		return ent_Date;
	}

	public void setEnt_Date(LocalDateTime ent_Date) {
		this.ent_Date = ent_Date;
	}

	public char getEnt_Yn() {
		return ent_Yn;
	}

	public void setEnt_Yn(char ent_Yn) {
		this.ent_Yn = ent_Yn;
	}

	@Override
	public String toString() {
		return "[emp_ID=" + emp_ID + ", emp_Name=" + emp_Name + ", emp_No=" + emp_No + ", email=" + email
				+ ", phone=" + phone + ", dept_Code=" + dept_Code + ", job_Code=" + job_Code + ", sal_Level="
				+ sal_Level + ", salary=" + salary + ", bonus=" + bonus + ", manager_Id=" + manager_Id + ", hire_Date="
				+ hire_Date + ", ent_Date=" + ent_Date + ", ent_Yn=" + ent_Yn + "]";
	}
	
}
