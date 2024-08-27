package While;

import java.util.Scanner;

public class WhileEx4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 구구단
		System.out.print("단 수: ");
		int dan = sc.nextInt();
		
		while (dan <= 9) {
			int start = 1; 
			/*
			 *  int start = 1; 을 while 반복문 밖에 작성해두면 
			 *  반복문 안에서 지역변수 개념으로 사라지게 되어 
			 *  반복문 밖에 있는 int start = 1; 로 선언되어 실행됨 (start는 반복문 영향을 받지 않게 됨)
			 */
			
			while (start <= 9) {
				if (dan > 9) {
					System.out.println("9이하의 숫자만 입력하세요.");
					continue;
				}
				System.out.printf("%d * %d = %d\n", dan, start, (dan * start));
				// System.out.println(dan + " * " + start + " = " + (dan * start));
				start++;
			}
			dan++;
		}
		
		
		
	}

}
