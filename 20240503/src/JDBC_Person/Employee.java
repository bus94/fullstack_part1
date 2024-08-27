package JDBC_Person;

public class Employee extends Person{

	private int salary;
	private String dept;
	
	public Employee() {
	}

	public Employee(String name, int age, int height, int weight, int salary, String dept) {
		super(name, age, height, weight);
		this.salary = salary;
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "salary=" + salary + ", dept=" + dept + ", toString()=" + super.toString();
	}
	
}
