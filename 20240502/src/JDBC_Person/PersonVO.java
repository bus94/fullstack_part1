package JDBC_Person;

//public class PersonVO {
//	private String name;
//	private int height;
//	private int weight;
//	
//	public PersonVO() {
//	}
//
//	public PersonVO(String name, int height, int weight) {
//		super();
//		this.name = name;
//		this.height = height;
//		this.weight = weight;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getHeight() {
//		return height;
//	}
//
//	public void setHeight(int height) {
//		this.height = height;
//	}
//
//	public int getWeight() {
//		return weight;
//	}
//
//	public void setWeight(int weight) {
//		this.weight = weight;
//	}
//
//	@Override
//	public String toString() {
//		return "PersonVO [name=" + name + ", height=" + height + ", weight=" + weight + "]";
//	}
//	
//}

class StudentVO{
	private int hakbun;
	private String name;
	private int height;
	private int weight;
	private int grade;
	private String major;
	
	public StudentVO() {
	}

	public StudentVO(int hakbun, String name, int height, int weight, int grade, String major) {
		super();
		this.hakbun = hakbun;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.grade = grade;
		this.major = major;
	}

	public int getHakbun() {
		return hakbun;
	}

	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "StudentVO [hakbun=" + hakbun + ", name=" + name + ", height=" + height + ", weight=" + weight
				+ ", grade=" + grade + ", major=" + major + "]";
	}
	
}

class EmployeeVO{
	private int empNo;
	private String name;
	private int age;
	private int height;
	private int weight;
	private int salary;
	private String dept;
	
	public EmployeeVO() {
	}

	public EmployeeVO(int empNo, String name, int age, int height, int weight, int salary, String dept) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.salary = salary;
		this.dept = dept;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
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
		return "EmployeeVO [empNo=" + empNo + ", name=" + name + ", age=" + age + ", height=" + height + ", weight="
				+ weight + ", salary=" + salary + ", dept=" + dept + "]";
	}
	
}