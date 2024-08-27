package ArrayEx;

import java.util.Scanner;

public class ArrayEx1 {

	public static void main(String[] args) {

		/* 변수 : 하나의 값만 저장
		 * 
		 * Array 배열 : 여러 개의 값 저장 (단, 같은 종류(자료형)의 데이터)
		 * <배열문 표현>
		 * → 자료형[] 배열명 = new 자료형[길이]
		 * ≫ 자료형[] 배열명 에서 []로 배열이라는 것을 나타낼 수 있기에 기입하기
		 * 
		 */ 
		
//		int[] arr = new int[3];
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		
//		double[] arr2 = new double[3];
//		arr2[0] = 1.1;
//		arr2[1] = 2.2;
//		arr2[2] = 3.3;
//		
//		String[] arr3 = new String[3];
//		arr3[0] = "이익준";
//		arr3[1] = "양석형";
//		arr3[2] = "김준완";
//		
//		int[] arr4 = {1, 2, 3, 4, 5};
//		String[] arr5 = {"익준", "준완"};
//		
//		System.out.println(arr4[0]);
//		System.out.println(arr4[1]);
//		System.out.println(arr4[2]);
//		System.out.println(arr4[3]);
//		System.out.println(arr4[4]);
//		
//		System.out.println(arr5[0]);
//		System.out.println(arr5[1]);
//		
//		int[] scores = {87, 11, 30, 20, 59};
//		int total = scores[0] + scores[1] + scores[2] + scores[3] + scores[4];
//		
//		System.out.println("총점 : " + total);
//		System.out.println("배열의 길이: " + scores.length);
//		System.out.println("평균: " + total / scores.length);
//		
//		// 예제
//		int[] arr1 = {10, 20, 30, 40, 50};
//		// 문제 1
//		int i = 0;
//		
//		while(i < arr1.length) {
//			boolean result = arr1[i] % 4 == 0;
//			if(result) {
//				System.out.print(arr1[i] + " ");
//			}
//			i++;
//		} 
//		
//		System.out.println();
//		
//		// 문제 2
//		/*
//		 * for문은 조건이 필요 없다.
//		 * 배열 이름 쓰면 배열 개수만큼 자동으로 반복 실행
//		 */
//		int total2 = 0;
//		
//		for(int num : arr1) {
//				if(num % 4 == 0) {
//				total2 = total2 + num;
//			}
//		} System.out.println(total2);
//		
//		// 문제 3
//		int count = 0;
//		int number = 0;
//		
//		int start = 0;
//		while(start < 5) {
//			if(arr1[start] % 4 == 0) {
//				count++;
//			}
//			start++;
//		} System.out.println("4의 배수: " + count);
		
		// 실습 문제 15
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 : ");
		int n = sc.nextInt();
		
		int i = 1;
		
		while(i < n) {
			if(n < 2) {
				System.out.println("잘못 입력하셨습니다.");
			}
			boolean result = n % i == 0;
			if(result) {
				System.out.println("소수가 아닙니다.");
			} else {
				System.out.println("소수입니다.");
			}
			i++;
		}
		
	}

}
