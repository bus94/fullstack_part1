package Inheritance_Person;

public class Student extends Person{
	
	private int grade;
	private String major;
	
	// 부모 클래스에서 기본 생성자를 만들었다면 자식 클래스에서도 기본 생성자를 만들어야 한다
	public Student() {}
	
	public Student(String name, int age, double height, double weight, int grade, String major) {
		super(name, age, height, weight);
		this.grade = grade;
		this.major = major;
	}

	// toString을 이용했는데 출력이 안됨
	// 안되는 이유(혼자 생각해봤을때): getName은 리턴값을 말하는데 그 리턴값들이 여러 개가 있어 최종 리턴값의 영향을 주지 못하는 것이 아닐까?
	// → 이게 아니라 getName이 부모클래스에 있기 때문에 리턴 할 수 없는 것!!
//	@Override
//	public String toString() {
//		return " 이름: " + getName() + " 나이: " + getAge() + " 신장: " + getHeight() + " 몸무게: " + getWeight() + " 학년: " + grade + " 전공: " + major;
//	}
	
	
	public void print() {
	System.out.println(" 이름: " + getName() + " 나이: " + getAge() + " 신장: " + getHeight() + " 몸무게: " + getWeight() + " 학년: " + grade + " 전공: " + major);
	// System.out.println(" 이름: " + super.getName() + " 나이: " + super.getAge() + " 신장: " + super.getHeight() + " 몸무게: " + super.getWeight() + " 학년: " + grade + " 전공: " + major);
	// 원래는 super.를 붙여 부모 클래스의 getName이라는 것을 구분해줘야하지만 안붙여도 출력은 가능
	}

	@Override
	public String toString() {
		return super.toString() + grade + " " + major; // 부모 클래스의 toString을 통해 호출
	}
}
