package Function;

import java.util.Scanner;

public class FunctionEx7 {
	
	public static String checkPW(String id) {
		
		int size = id.length();
		
		String result = "";
		if(size >= 9) {
			result = "Good";
		} else if (size >= 5) {
			result = "Normal";
		} else {
			result = "Bad";
		}
		return result;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("password 입력: ");
		String password = sc.nextLine();
		
		System.out.println("Your Password: " + checkPW(password));
		
	}

}
