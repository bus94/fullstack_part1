package Polymorphism;

import Inheritance_Person.Employee;
import Inheritance_Person.Person;
import Inheritance_Person.Student;

public class PolymorphismEx {

	public static void main(String[] args) {

		// 다형성(Polymorphism)
		// - 같은 자료형에 여러 가지 타입의 데이터를 대입하여 다양한 결과를 얻어낼 수 있다
		// - 하나의 타입으로 여러 개의 다른 타입을 저장할 수 있다
		// - "상속"은 반드시 있어야 한다! (상속 관계가 있어야 한다)
		
		Person p1 = new Person();
		Person p2 = new Student();
		System.out.println(p2.getName());
		
		Person p3 = new Employee();
		System.out.println(p3.getName());
		
		Student s1 = new Student();
		
	}

}
