package JDBC_Person;

public class Student extends Person{
	
	// 인스턴스 변수
	private int hakbun;
	private int grade;
	private String major;
	
	public Student() {
	}
	
	public Student(String name, int age, int height, int weight, int grade, String major) {
		super(name, age, height, weight);
		this.grade = grade;
		this.major = major;
	}

	public int getHakbun() {
		return hakbun;
	}

	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
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
		return super.toString()+ ", grade=" + grade + ", major=" + major;
	}
	
}
