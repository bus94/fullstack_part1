package Inheritance_Person;

public class Employee extends Person {

	private int salary;
	private String dept;

	public Employee() {
	}

	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(name, age, height, weight);
		this.salary = salary;
		this.dept = dept;
	}

	public void print() {
		System.out.println(" 이름: " + getName() + " 나이: " + getAge() + " 신장: " + getHeight() + " 몸무게: " + getWeight()
				+ " 급여: " + salary + " 부서: " + dept);
	}

	@Override
	public String toString() {
		return super.toString() + salary + " " + dept;
	}

	
}
