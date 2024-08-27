package Memo;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// System.in - 자동으로 키보드와 자바 사이에 버퍼(임시저장공간)가 생성 및 스트림(연결)
		Scanner sc = new Scanner(System.in);

		int menu = 0;

		while (menu != 5) {
			while (true) {
				System.out.println("============================================");
				System.out.println(" 1.입력  2.목록보기  3.수정  4.삭제  5.종료 ");
				System.out.println("============================================");
				System.out.print("원하는 메뉴를 입력하고 enter키를 누르세요: ");
				menu = sc.nextInt();
				if (menu >= 1 && menu <= 5) {
					break;
				}
				System.out.println("메뉴는 1 ~ 5 사이의 정수로 입력해야 합니다.");
			}
			switch (menu) {
			case 1:
				Service.insert();
				break;
				
			case 2:
				Service.select();
				break;
				
			case 3:
				Service.update();
				break;
				
			case 4:
				Service.delete();
				break;
			}
		}

		System.out.println("프로그램 종료!");
	}

}
