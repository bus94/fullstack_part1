package While;

import java.util.Scanner;

public class WhileEx2 {

	public static void main(String[] args) {
		// Ctrl + D : 한 줄 지우기
		
		Scanner sc = new Scanner(System.in);
		
		// 대입 연산자
		// ex. a = a + b;
		// → a += b;
//		int a = 10;
//		int b = 1;
//		
//		a = a + b; // 11
//		System.out.println(a += b); // 12 
//		System.out.println(a -= b); // 11
//		System.out.println(a *= b); // 11
//		System.out.println(a /= b); // 11
//		System.out.println(a %= b); // 0
//		
//		// int c = 1, d, e; → 이러면 d, e가 할당되지 않아서 출력 안됨
//		int c = 1, d = 0, e = 0;
//		
//		System.out.println("c : " + c); // 1
//		System.out.println("d : " + d); // 0
//		System.out.println("e : " + e); // 0
		
		/*
		 *  <증감 연산자> : 1만 증가 또는 감소
		 *  ex. ++ , --
		 *  
		 *  변수++ : 사용 후 증가 (사용: 출력 또는 연산)
		 *	→ ;(마침표) 을 만나서 문장이 종료 될 때 1 증가
		 *
		 *	++변수 : 증가 후 사용
		 *	→ 변수에 저장된 값을 1 증가하고 사용
		 *
		 */
		
//		d = c++;
//		System.out.println("c++ : " + d); // 1
//		System.out.println("++d : " + (++d)); // 2
//		System.out.println("d++ : " + (d++)); // 2
//		System.out.println("d : " + d); // 3
		
//		System.out.print("정수를 하나 입력하세요 : ");
//		int input = sc.nextInt();
//		int z = 1;
//		int total = 0;
//		
//		while(z <= input) {
//			total = total + z;
//			z++;
//		}
//		
//		System.out.println("누적된 합 : " + total);
		
		// 1~50까지 홀수의 합
//		int m = 1;
//		int end = 50;
//		int sum = 0;
//		
//		while(m <= end) {
//			sum = sum + m;
//			m += 2;
//		}
//		
//		System.out.println("1부터 " + end + "까지의 홀수의 합 : " + sum);
		
		
		
	}

}
