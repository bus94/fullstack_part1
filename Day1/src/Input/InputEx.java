package Input;

import java.util.Scanner; // 필요한 기능만 사용시 import // 키보드로 입력 받기 위해선  Scanner

public class InputEx {

	public static void main(String[] args) {
		
//		// 코드 이동 Alt + 방향키
//		System.out.println("시작하는 함수");
//		
//		// 입력창, 검색창 매번 다른 값을 키보드로 입력 하는 것
//		// Scanner -> Ctrl + SpaceBar -> java.util 폴더 -> Scanner sc = new Scanner(System.in); 작성
		Scanner sc = new Scanner(System.in);
		
		// 키보드로 입력 받은 하나의 정수가 양수이면 "양수다"
		// 양수가 아니면 "양수가 아니다"를 출력하시오
		System.out.print("정수: ");
		int n1 = sc.nextInt();
		
		String result = (n1 > 0) ? "양수다" : "양수가 아니다";
		System.out.println(result);
		
	
//		// 키보드로 정수를 입력하시오
//		System.out.println("정수 한 개: ");
//		int num = sc.nextInt();
//		
//		System.out.println(num);
//		
//		// 키보드로 실수를 입력하시오
//		System.out.println("실수 한 개: ");
//		double num2 = sc.nextDouble();
//		
//		System.out.println(num2);
		
		
	}

}
