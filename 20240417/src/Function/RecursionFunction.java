package Function;

public class RecursionFunction {

	public static void hello() {
		System.out.println("hello");
		hello();
	}

	// 재귀함수가 스택오버플로우에러가 발생하지 않도록 하는 경우
	public static void helloSolution(int end) {
		if (end == 0) {
			return;
		}
		System.out.println("hello");
		helloSolution(end - 1);
	}

	public static void a() {
		b();
		System.out.println("a");
	}

	public static void b() {
		c();
		System.out.println("b");
	}

	public static void c() {
		System.out.println("c");
	}

	public static int sum(int n) {
		if (n == 1) {
			return 1;
		}
		return n + sum(n - 1);
	}

	public static int pow(int n) {
		if (n == 1) {
			return 2;
		}
		return 2 * pow(n - 1);
	}

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static int fibonacci(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 0) {
			return 0;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static void main(String[] args) {

		/*
		 * 재귀함수: 함수 안에서 자기 자신을 호출 자신을 반복적으로 호출하면서 원하는 결과 갖는다 재귀함수를 이용해서 데이터를 저장하는 방식으로는
		 * 트리 구조, 이분 탐색
		 * 
		 */

		/*
		 * 호출 스택(call stack): 프로그램에서 함수나 메서드를 호출할 때 해당 함수나 메서드의 실행이 끝날 때까지 실행되는 다른 함수나
		 * 메서드의 호출 정보를 저장하는 자료구조
		 * 
		 * StackOverflowError 호출 스택이 가득 찼을 때 생기는 에러 → 함수를 멈출 수 있는 조건 필요
		 * 
		 */

		// hello(); → 무한 반복이 있어짐 (hello 안의 hello 안의 hello 안의.. 함수 실행)

		// 1부터 10까지 합을 구하는 재귀함수

		a(); // 실행순서 c → b → a
		helloSolution(5);

		// 재귀함수를 이용하여 1~10까지의 총 합 구하기
		int result = sum(10);
		System.out.println("총 합: " + result);

		// 재귀함수를 이용하여 10의 팩토리얼
		// 거듭 제곱(pow) : 하나의 숫자를 다른 숫자(지수)만큼 곱하는 것
		result = pow(5);
		System.out.println("2의 거듭제곱: " + result);
		result = factorial(5);
		System.out.println("팩토리얼: " + result);
		// 피보나치 수열
		result = fibonacci(10);
		System.out.println("10번째 피보나치 수열: " + result);

	}

}
