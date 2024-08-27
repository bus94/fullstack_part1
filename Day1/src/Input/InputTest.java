package Input;

import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int n2 = sc.nextInt();
		
		String result1 = (n2 % 2 == 0) ? "짝수다" : "홀수다";
		System.out.println(result1);
		
		System.out.print("나이 : ");
		int n3 = sc.nextInt();
		
		String result3 = (n3 < 20) ? "청소년" : "성인";
		System.out.println(result3);
		
	}

}
