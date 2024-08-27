package Input;

import java.util.Scanner;

public class InputTest1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
				
		// 1번
		System.out.print("실수 : ");
		double f1 = sc.nextDouble();
		
		System.out.println(f1 + "의 정수 부분은 " + (int)f1 + "입니다.");
		
		// 2번
		System.out.print("number : ");
		int number = sc.nextInt();
		System.out.print("n : ");
		int n = sc.nextInt();
		System.out.print("m : ");
		int m = sc.nextInt();
	
//		if(number % n == 0) {
//			if(number % m == 0) {
//				System.out.println("1");
//			}else {
//				System.out.println("0");
//			}
//		}else {
//			System.out.println("0");
//		}
		System.out.println((number % n == 0 && number % m == 0)? 1 : 0);
	
		// 값의 교체
		int a = 10;
		int b = 20;
		
		int i = a;
		a = b; // int a = b; 로 하면 안되는 것은 int a 를 이미 선언하였는데, 다시 선언하다보니 오류가 생김
		b = i;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		
	}

}
