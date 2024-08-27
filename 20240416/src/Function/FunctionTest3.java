package Function;

import java.util.Scanner;

// 커피 요금
public class FunctionTest3 {
	
	public static int coffee(String c) {
		
		int a = 0;
		if(c.equals("Americano")) {
			a = 3900;
		}else if(c.equals("Cafe mocha")) {
			a = 4500;
		}else if(c.equals("Cafe Latte")) {
			a = 5000;
		}else if(c.equals("Green Tea Latte")) {
			a = 5500;
		}
		return a;
		
	}
	
	public static int size(String s) {
		
		int b = 0;
		if(s.equals("G")) {
			b = 1000;
		}else if(s.equals("R")) {
			b = 500;
		}else if(s.equals("S")) {
			b = 0;
		}
		
		return b;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Harry Cafe");
		System.out.print("Choose 1 : Americano/Cafe mocha/Cafe Latte/Green Tea Latte: ");
		String c = sc.nextLine();
		
		System.out.print("Choose size: G(grande)/R(regular)/S(short): ");
		String s = sc.nextLine();
		
		System.out.println("총 금액은 " + (coffee(c)+size(s)) + " 원 입니다.");
		
	}

}
