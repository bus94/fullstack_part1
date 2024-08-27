package Input;

import java.util.Scanner;

public class InputTest3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력1 : ");
		int n1 = sc.nextInt();
		System.out.print("입력2 : ");
		int n2 = sc.nextInt();
		System.out.print("입력3 : ");
		int n3 = sc.nextInt();
		
		boolean result = (n1 == n2 && n2 == n3) ? true : false;
		System.out.println(result);
	}

}
