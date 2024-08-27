package JDBC_Test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		

		Scanner sc = new Scanner(System.in);
		int menu = 0;
		
		while (menu != 5) {
			while (true) {
				System.out.println("============================================");
				System.out.println(" 1.입력  2.목록보기  3.수정  4.삭제  5.종료 ");
				System.out.println("============================================");
				System.out.print("원하는 메뉴를 입력하고 Enter키를 누르세요: ");
				menu = sc.nextInt();
				if (menu >= 1 && menu <= 5) {
					break;
				}
				System.out.println("메뉴는 1 ~ 5 사이의 정수로 입력해야 합니다.");
			}

			switch (menu) {
			
			case 1:
				MemoService.insert();
				break;
				
			case 2:
				MemoDAO.print();
				break;
				
			case 3:
				MemoService.update();
				break;
				
			case 4:
				MemoService.delete();
				break;
				
			}
		}
		System.out.println("프로그램을 종료합니다. 바이바이~~~~~");
		
		
		
		
		
	}

}
