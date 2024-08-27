package While;

import java.util.Scanner;

public class WhileEx3 {

	public static void main(String[] args) {

		/*
		 * break; : 반복문 자체를 중단해서 종료 continue; : 반복문 자체를 중단하지 않고 밑에 있는 문장을 실행 안함 반복문의
		 * 조건식으로 이동 (굳이 else를 이용하지 않게 됨)
		 * 
		 */

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. 조회");
			System.out.println("2. 추가");
			System.out.println("3. 삭제");
			System.out.println("0. 종료");
			System.out.print("> ");
			int sel = sc.nextInt();

			if (sel > 3 || sel < 0) {
				System.out.println("메뉴를 다시 입력하세요.\n");
				continue; // 밑에 있는 실행문을 무시하고 while문으로 다시 가서 조건문 확인
			}

			switch (sel) {
			case 1:
				System.out.println("조회\n");
				break;
			case 2:
				System.out.println("추가\n");
				break;
			case 3:
				System.out.println("삭제\n");
				break;
			case 0:
				System.out.println("종료\n");
				return; // 함수 종료!
			}

//			int i  = 1;
//			while(i <= 5) {
//				if(i == 3) {
//					i++;
//					continue;
//				}
//				System.out.println(i);
//				i++;
//			}

		}
	}
}
