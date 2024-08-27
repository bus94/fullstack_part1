package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {

		// 예외 처리
		// - 비정상적으로 프로그램이 멈추는 걸 막기 위해서 사용하는 기법

		// 프로그램이 정상적으로 작동해야하는데 10/0 같이 계산이 되지않는 등의 프로그램이 비정상적으로 멈추게 됨
		// (런타임 에러)
		System.out.println("연산");
		try {
			System.out.println(10 / 0);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없다");
//			System.out.println(e.getMessage()); 
//			// 	/by zero
//			//	java.lang.ArithmeticException: / by zero
//			//			at Exception.Main1.main(Main1.java:14)
//			e.printStackTrace();
		}
		System.out.println("정상적으로 끝!");

		// <프로그래밍에서 오류가 발생하는 시점 3가지>
		// 1. 컴파일 에러(compile-time error)
		// : 컴파일 시 에러 발생 ! (이진수로 변환하는 과정에서 에러가 발생할 수 있다)
		// ex) 문법 구문 오류(syntax error)
		// - 세미콜론(;)이 없거나 선언되지 않는 변수를 사용하거나 초기화 되지 않는 변수를 연산하거나 등등
		// 빨간색으로 표시된다
		// 2. 런타임 에러(runtime error)
		// : 프로그램 실행 시 발생하는 에러 !
		// = 실행 오류
		// 3. 논리적 에러(logical error)
		// : 실행은 되지만 의도와 다르게 동작하는 것 !
		// = 버그

		// 자바에서 에러 / 예외
		// 런타임 (실행) 시 발생할 수 있다
		// 에러(error) : 프로그램 코드에서 수습될 수 없는 심각한 오류
		// - 메모리부족, 스택오버플로우, JVM(자바가상머신) 문제 등
		// 예외(exception) : 프로그램 코드에 의해서 수습될 수 있는 아주 미약한 오류
		// - 프로그램을 사용하는 사용자 기반으로 생길 수 있는 예외들을 대응할 수 있게 코드를 작성해야한다

		// Object 클래스 > Throwable 클래스 > Exception / Error

		/*
		 * try ~ catch 문법 (if else 문과 비슷)
		 * 
		 * try{ 예외가 발생할 수 있는 문장들; } catch() { 처리하는 문장들; }
		 * 
		 * JVM이 예외 또는 에러 발생 시 예외처리 클래스
		 * 
		 */

		/*
		 * 키보드로 정수 2개를 입력 그 수를 더하는 프로그램
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[3];
		System.out.print("두 정수를 입력: ");

		// 정수가 아닌 다른 것을 입력했을 때 (문자, 소수, 기호 등)
		try {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(" 두 수의 합: " + (a + b));
			arr[3] = a + b;
		} catch (InputMismatchException e) {
			System.out.println("입력하신 내용은 정수가 아닙니다.");
			System.out.println("정수를 다시 입력해주세요.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("저장할 수 있는 공간이 없습니다.");
		} catch(NullPointerException e) {
			// 객체가 없는 상태에서 객체를 사용하려고 접근할 때 나타남
			// 자바에서 가장 빈번하게 발생하는 예외 중 하나이다
			System.out.println("객체가 없다");
		}
		System.out.println("정상 종료!");

	}

}
