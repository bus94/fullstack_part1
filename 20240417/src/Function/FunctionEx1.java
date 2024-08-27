package Function;

import java.util.Random;

public class FunctionEx1 {
	
	public static int hello() {
		int n1 = 10;
		int n2 = 20;
		
		return n1;
		// return n1,n2; 불가
	}
	
	public static int[] loop(int[] arr) {
		
		Random	ran = new Random();
		
		for(int i = 0; i < 100; i++) {
			int rand = ran.nextInt(6);
			arr[rand]++;
		}		
		return arr;
	}
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");			
		}
	}

	public static void main(String[] args) {

		System.out.println(hello());
		
		/*
		 * 함수의 return 값은 1개만 가능
		 * 2개의 값 넘기는 해결법
		 *  클래스로 만들어서(묶어서) 넘기기
		 *  변수를 이용해서 배열의 공간과 갯수를 사용하는 방법
		 * 
		 * 함수의 2가지 종류
		 * 	1) 내장 함수: 자바에서 미리 만들어둔 함수
		 * 		ex) println(), nextInt() ... 
		 * 	2) 사용자 정의 함수: 개발자가 만든 함수
		 * 		→ 자바 컴파일은 모르기에 main 함수 밖에 작성해서 정의
		 *  
		 */
		
		int[] arr = new int[6];
		// 주사위 100 번 던졌을 때
		// {1 나온 갯수, 2 나온 갯수, 3 나온 갯수, 4 나온 갯수, 5 나온 갯수, 6 나온 갯수} 카운트
		print(loop(arr));
	}

}
