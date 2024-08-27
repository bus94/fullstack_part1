package Inheritance_Person;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Student s1 = new Student("강건강", 20, 178.2, 70, 1, "정보시스템공학과");
		Student s2 = new Student("남나눔", 21, 187.3, 80, 2, "경영학과");
		Student s3 = new Student("류라라", 23, 167, 45, 4, "정보통신공학과");
		Employee e1 = new Employee("박보배", 26, 180.3, 72, 100000000, "영업부");
		Employee e2 = new Employee("송성실", 38, 182, 76, 200000000, "기획부");
//		Student[] stuList = new Student[3];
//		Employee[] empList = new Employee[10];
//		
//		// toSpring은 주소값을 return 값으로 반환하는 것이기 때문에 해당 객체명만 작성해서 출력하면 return 값이 출력이 되는 것
//		// → toSpring으로 return 값 설정해두고 그것을 println으로 출력하면 된다
//		System.out.println(s1); 
//		System.out.println(s2); 
//		System.out.println(s3); 
//
//		System.out.println();
//		
//		s1.print();
//		s2.print();
//		s3.print();
//		
//		System.out.println();
//		
//		e1.print();
//		e2.print();
		
		// <StudenNode 연결리스트>
		
		// StudentNode 를 하나 생성 (data, next를 가지고 있는 공간 객체 생성)
		StudentNode headStudent = null;
		
		StudentNode nodeS1 = new StudentNode();
		nodeS1.data = s1;
		nodeS1.next = null;
		headStudent = nodeS1;
		
		StudentNode nodeS2 = new StudentNode();
		nodeS2.data = s2;
		nodeS2.next = null;
		nodeS1.next = nodeS2;
		
		StudentNode nodeS3 = new StudentNode();
		nodeS3.data = s3;
		nodeS3.next = null;
		nodeS2.next = nodeS3;
		
		// StudentNode 연결리스트 출력
		StudentNode currentS = headStudent;
		while(currentS != null) {
			System.out.println(currentS.data);
			currentS = currentS.next;
		}
		
		System.out.println();
		
		// <EmployeeNode 연결리스트>
		EmployeeNode headEmployee = null;
		
		EmployeeNode nodeE1 = new EmployeeNode();
		nodeE1.data = e1;
		nodeE1.next = null;
		headEmployee = nodeE1;
		
		EmployeeNode nodeE2 = new EmployeeNode();
		nodeE2.data = e2;
		nodeE2.next = null;
		nodeE1.next = nodeE2;
		
		// Employee 연결리스트 출력
		EmployeeNode currentE = headEmployee;
		while(currentE != null) {
			System.out.println(currentE.data);
			currentE = currentE.next;
		}
		
		// StudentNode 검색
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색할 이름: ");
		String findNameS = sc.nextLine();
		
		currentS = headStudent;
		while(currentS != null) {
			if(currentS.data.getName().equals(findNameS)) {
				System.out.println(currentS.data);
				break;
			}
			currentS = currentS.next;
		}
		if(currentS == null) {
			System.out.println("검색한 이름은 없습니다.");
		}
		
		// EmployeeNode 검색
		System.out.print("검색할 이름: ");
		String findNameE = sc.nextLine();
		
		currentE = headEmployee;
		while(currentE != null) {
			if(currentE.data.getName().equals(findNameE)) {
				System.out.println(currentE.data);
				break;
			}
			currentE = currentE.next;
		}
		if(currentE == null) {
			System.out.println("검색한 이름은 없습니다.");
		}
		
		
	}

}
