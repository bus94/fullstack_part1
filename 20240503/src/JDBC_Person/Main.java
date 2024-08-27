package JDBC_Person;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// main에서 학생의 입력과 출력을 하는 전처리 객체 주소를 저장해서 연결한다.
		StudentService stuService = new StudentService();
		EmployeeService empService = new EmployeeService();
		int menu = 0;
		int stuCount = 0;
		int empCount = 0;
		
		while (menu != 3) {
			while (true) {
				stuCount = stuService.count();
				System.out.println("현재 저장된 학생은 " + stuCount + "명 입니다.");
				System.out.println("현재 저장된 직원은 " + empCount + "명 입니다.");
				
				System.out.println("============================================");
				System.out.println(" 1.학생    2.직원    3.종료 ");
				System.out.println("============================================");
				System.out.print("원하는 메뉴를 입력하고 Enter키를 누르세요: ");
				menu = sc.nextInt();
				if (menu >= 1 && menu <= 3) {
					break;
				}
				System.out.println("메뉴는 1 ~ 3 사이의 정수로 입력해야 합니다.");
			}

			switch (menu) {
			
			case 1:
				stuService.mainMenu();
				break;
				
			case 2:
				empService.mainMenu();
				break;
				
			case 3:
				break;
				
			}
		}
		System.out.println("프로그램을 종료합니다. 바이바이~~~~~");
		
	}

}
