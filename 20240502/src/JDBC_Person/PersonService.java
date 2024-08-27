package JDBC_Person;

import java.util.Scanner;

import JDBC_Test.MemoDAO;

public class PersonService { // Menu
	private static Scanner sc = new Scanner(System.in);
	
	public static void insertStudent() {
		System.out.println("PersonService 안에 insertStudent()메서드 실행");
		System.out.println("추가할 학생의 정보를 입력하세요!");
		System.out.print("학번: ");
		int insertHakbun = sc.nextInt();
		sc.nextLine();
		System.out.print("이름: ");
		String insertName = sc.nextLine();
		System.out.print("키: ");
		int insertHeight = sc.nextInt();
		System.out.print("몸무게: ");
		int insertWeight = sc.nextInt();
		System.out.print("학년: ");
		int insertGrade = sc.nextInt();
		sc.nextLine();
		System.out.print("추가 학생의 전공 입력: ");
		String insertMajor = sc.nextLine();
		
		StudentVO svo = new StudentVO(insertHakbun, insertName, insertHeight
									, insertWeight, insertGrade, insertMajor);
		System.out.println(svo);
		if (PersonDAO.insertStudent(svo)) {
			System.out.println("학생이 성공적으로 추가되었습니다!");
		} else {
			System.out.println("학생 추가를 실패하였습니다!");
		}
	}
	
	
	
	public static void insertEmployee() {
		System.out.println("PersonService 안에 insertEmployee()메서드 실행");
		System.out.println("추가할 직원의 정보를 입력하세요!");
		System.out.print("사번: ");
		int insertEmpNo = sc.nextInt();
		sc.nextLine();
		System.out.print("이름: ");
		String insertName = sc.nextLine();
		System.out.print("나이: ");
		int insertAge = sc.nextInt();
		System.out.print("키: ");
		int insertHeight = sc.nextInt();
		System.out.print("몸무게: ");
		int insertWeight = sc.nextInt();
		System.out.print("급여: ");
		int insertSalary = sc.nextInt();
		sc.nextLine();
		System.out.print("부서: ");
		String insertDept = sc.nextLine();
		
		EmployeeVO evo = new EmployeeVO(insertEmpNo, insertName, insertAge
								, insertHeight, insertWeight, insertSalary, insertDept);
		System.out.println(evo);
		if(PersonDAO.insertEmployee(evo)) {
			System.out.println("직원이 성공적으로 추가되었습니다!");
		}else {
			System.out.println("직원 추가를 실패하였습니다!");
		}
	}

	public static void printStudent() {
		System.out.println("PersonService 안에 printStudent()메서드 실행");
		if(PersonDAO.printStudent()) {
			System.out.println(PersonDAO.countStudent + "명의 학생의 정보 조회를 완료하였습니다.");
		}else {
			System.out.println("조회할 학생의 정보가 없습니다.");
		}
	}
	
	public static void printEmployee() {
		System.out.println("PersonService 안에 printEmployee()메서드 실행");
		if(PersonDAO.printEmployee()) {
			System.out.println(PersonDAO.countEmployee + "명의 직원의 정보 조회를 완료하였습니다.");
		}else {
			System.out.println("조회할 직원의 정보가 없습니다.");
		}
	}
	

}
