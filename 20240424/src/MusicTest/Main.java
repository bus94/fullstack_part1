package MusicTest;

import java.util.Arrays;

public class Main {
	
//	// 가변인수
//	// 함수를 실행했을 때 매개변수로 들어오는 값의 개수와 상관없이 동적으로 인수를 받아서 처리할 수 있도록 만들어 놓은 기법
//	public static void print(String...str) {
//		// 배열로 처리가 된다
//		// 0~n개까지 넣을 수 있다
//		// 컴파일을 할 때 배열로 처리
//		// 배열 자료형은 매개변수 타입으로 명시한다
//		// 매개변수가 몇 개 넘어오는지 모를 경우
//		for(String s : str) { // str이라는 배열의 길이를 모르는 변수들을 문자 배열로 만들어 반복문 작성
//			System.out.print(s + " ");
//		}
//		System.out.println();
//	}
//	
//	// 가변 인자는 무조건 메서드의 파라미터 가장 마지막에 작성
//	public static void printInfo(int num, boolean str, String...strings) {
//		System.out.println("num: " + num);
//		System.out.println("boolean: " + str);
//		System.out.println("String: " + Arrays.toString(strings));
//	}
	
	public static void main(String[] args) {
//		print("홍길동");
//		print("홍길동", "이순신");
//		print("홍길동", "이순신", "이도");
//		print("홍길동", "이순신", "이도", "강감찬");
		
		MusicView mv = new MusicView();
		
		mv.mainMenu();
		
		
		
	}

}
