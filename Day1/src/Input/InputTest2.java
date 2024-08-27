package Input;

import java.util.Scanner;

public class InputTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("변수1 : ");
		int num1 = sc.nextInt();
		System.out.println("변수2 : ");
		int num2 = sc.nextInt();
		
		System.out.println("변수3 : ");
		int num3 = sc.nextInt();
		
		boolean isResult = (num3 <= num1 || num3 > num2)? true : false;
		System.out.println(isResult);
	}

}
