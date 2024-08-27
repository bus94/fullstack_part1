package While;

import java.util.Random;
import java.util.Scanner;

public class UpAndDown {

	public static void main(String[] args) {

		// 1. 라이브러리
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		// 2. 랜덤값 설정
		int com = rd.nextInt(100) + 1;
		
		// 3. 반복문 실행할지 결정
//		boolean run = true;
//		
//		while(run) {
//			System.out.print("숫자를 입력(1~100) : ");
//			int number = sc.nextInt();
//			
//			if (number < com) {
//				System.out.println("Up!");
//			} else if (number > com) {
//				System.out.println("Down!");
//			} else {
//				System.out.println("Bingo!");
//				run = false;
//			}
//		}
		
		/* 정해진 횟수 없이 무한 반복 하는 경우 정답 맞출 시 
		*  break; 로 반복문 멈춤
		*/ 
		
		while(true) {
			System.out.print("숫자를 입력(1~100) : ");
			int number = sc.nextInt();
			
			if (number < com) {
				System.out.println("Up!");
			} else if (number > com) {
				System.out.println("Down!");
			} else {
				System.out.println("Bingo!");
				break;
			}
		}

	}

}