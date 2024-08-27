package Function;

import java.util.Scanner;

public class RecursionFunction2 {
	// 전역변수를 활용하는 경우 main의 반복문이 있을 때 입력한 값마다 초기화를 해야하기 때문에 int로 설정만 해두고 
	// main에서 초기값을 설정해둔다
	static int count0;
	static int count1;

	// 0번째 인덱스: 0의 카운팅
	// 1번째 인덱스: 1의 카운팅
	public static int fibonacci(int num) {
		if (num == 0) {
			count0++;
			return 0;
		} else if (num == 1) {
			count1++;
			return 1;
		} else {
			return fibonacci(num - 1) + fibonacci(num - 2);
		}
	}

	
	public static void main(String[] args) {

		// 피보나치 수열
		// 0이 출력되는 횟수와 1이 출력되는 횟수 출력하기
		Scanner sc = new Scanner(System.in);

		System.out.print("테스트 횟수: ");
		int t = sc.nextInt();

		int i = 0;
		int[] arr = new int[2];
		while (i < t) {
			count0 = 0;
			count1 = 0;
			System.out.print("피보나치 수열: ");
			int n = sc.nextInt();

			fibonacci(n);
			i++;
			System.out.println(count0 + " " + count1);
		}
		System.out.println(count0);
		System.out.println(count1);

//		System.out.print("두 개의 자연수: ");
//		int n1 = sc.nextInt();
//		int n2 = sc.nextInt();
//
//		so(n1);
//		so(n2);
	}

//	// 소수 구하기
//	public static void so(int n) {
//		int i;
//		for (i = 2; i <= n; i++) {
//			if (n % i == 0) {
//				break;
//			}
//		}
//		if (n == i) {
//			System.out.println(n + "은 소수입니다.");
//		} else {
//			System.out.println(n + "은 소수가 아닙니다.");
//		}
//	}

}
