package JDBC_Person;

import java.util.Scanner;

import JDBC_Test.MemoDAO;
import JDBC_Test.MemoService;

public class Main {

	public static void main(String[] args) {

		/*
		 * 학생과 직원을 선택해서 추가하는 프로그램을 만드시오
		 * 데이터베이스에 저장하기
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		int menu1 = 0;
		int menu2 = 0;
		
		while (menu != 3) {
			while (true) {
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
				// 학생 추가
				System.out.println("============================================");
				System.out.println(" 1.추가   2.보기   3.메인으로");
				System.out.println("============================================");
				System.out.print("원하는 메뉴를 입력하고 Enter키를 누르세요: ");
				menu1 = sc.nextInt();
				
				if(menu1 == 1) {
					PersonService.insertStudent();
					break;
				} else if(menu1 == 2) {
					PersonService.printStudent();
					break;
				} else {
					System.out.println("메뉴는 1 ~ 3 사이의 정수로 입력해야 합니다. 메뉴로 돌아갑니다.");
					break;
				}
				
			case 2:
				// 직원 추가
				System.out.println("============================================");
				System.out.println(" 1.추가   2.보기   3.메인으로");
				System.out.println("============================================");
				System.out.print("원하는 메뉴를 입력하고 Enter키를 누르세요: ");
				menu2 = sc.nextInt();
				
				if(menu2 == 1) {
					PersonService.insertEmployee();

					break;
				} else if(menu2 == 2) {
					PersonService.printEmployee();
					break;
				} else {
					System.out.println("메뉴는 1 ~ 3 사이의 정수로 입력해야 합니다. 메뉴로 돌아갑니다.");
					break;
				}
				
			case 3:
				break;
				
			}
		}
		System.out.println("프로그램을 종료합니다. 바이바이~~~~~");
		
		
		
		
		
	}

}
