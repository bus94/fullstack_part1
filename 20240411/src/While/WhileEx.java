package While;

import java.util.Scanner;

public class WhileEx {

	public static void main(String[] args) {
		/* 반복문
		 * 
		 * 횟수 
		 * 	for
		 * 조건 
		 * 	while(비교) {
		 * 		참이면 반복;
		 * 	}
		 * 
		 * <반복문 3요소>
		 * 1) 시작하는 값(초기식) 
		 * 2) 비교하는 문장 필요(조건식) 
		 * 3) 증거하거나 감소(증감식) - 무한루프에 빠지지 않도록 하기 위함
		 * 
		 */
		
//		int start = 1;
//		while(start <= 5) {
//
//			System.out.println(start);
//			
//			start = start + 1;
//			
//		}
//		
//		//중간 공백 생성하기 (출력시 한 줄 공백 생김)
//		System.out.println();
//		
////		// duplicate 중복 : 이미 선언되어있는 변수는 다시 선언할 필요 없이 값만 할당하기
////		int start = 1;
//		
//	
//		start = 1;
//		
//		while(start <= 100) { 
//		// while(start < 101)
//		// while(start != 101)
//			
//			System.out.println(start);
//			start = start + 1;
//		}
//		
//		System.out.println();
//		
//		// Alt + Shift + R : 해당 이름 전부 바꾸기
//		// Ctrl + Alt + Up/Down : 위로 복사/아래로 복사
//		int start2 = 5;
//		while(start2 > 0) {
//			System.out.println(start2);
//			start2 -= 1;
//		}
//		
//		System.out.println();
//		
//		int start3 = 1;
//		while(start3 < 101) {
//			System.out.println(start3);
//			start3 += 2;
//		}
		
		Scanner sc = new Scanner(System.in);
		
		// 예제
//		System.out.print("1이상의 숫자를 입력하세요 : ");
//		int i = sc.nextInt();
//		
//		if(i >= 1){
//			while(i >= 1) {
//			System.out.println(i);
//			i--;
//			}
//		} else {
//			System.out.println("1이상의 숫자를 입력해주세요.");
//		}
		
		// 백준 예제
//		System.out.println("테스트 횟수 입력 : ");
//		int n = sc.nextInt();
//		int q = 0;
//		
//		while(q < n) {
//			System.out.print("A B : ");
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			int c = a + b;
//			System.out.println(a + b);
//			q++;
//		}
	
	}

}
