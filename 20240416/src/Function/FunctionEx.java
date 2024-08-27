package Function;

import java.util.Scanner;

public class FunctionEx {

	public static void info() {

		String str = "이서희";
		int age = 20;

		System.out.println("이름: " + str);
		System.out.println("나이: " + age);

	}

	public static void hello() {

		System.out.println("Hello world!");
		
	}

	public static void main(String[] args) {

		/*
		 * 함수
		 * : 긴 코드를 짧게 변경 
		 * : main 함수 밖에서 코드 작성
		 * : 누구나 접근해서 만든다
		 * → 코드와 비슷한 이름으로 함수명 지정 
		 * 
		 * 접근 제한자 반환타입 함수명() {
		 * 		실행할 문장들; (주로 중복되는 문장들)
		 * }
		 * 
		 */

		// 생성한 함수 이용
		info();
		hello();
		hello();
		
		input();
		input();
		
	}
	
	public static void input() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수: ");
		int num = sc.nextInt();
		
		System.out.println("내가 입력한: " + num);
		
	}

}
