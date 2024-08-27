package Function;

import java.util.Scanner;

public class FunctionTest2 {
	
	public static void checkPW(String password) {
		
		int pwlength = password.length();
		
		if(pwlength >= 9) {
			System.out.println("Good");
		}else if(pwlength < 9) {
			if(pwlength >= 5) {
				System.out.println("Normal");
			}else {
				System.out.println("Bad");
			}
		}
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("password 입력: ");
		String password = sc.nextLine();
		
		System.out.print("Your Password: ");
		checkPW(password);
	}

}
