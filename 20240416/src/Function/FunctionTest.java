package Function;

import java.util.Scanner;

// 기차 요금
public class FunctionTest {

	public static void print(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print("Hello java! ");
		}
	}
	
	public static void sum(int num) {
		int sum = 0;
		int i = 0;
		
		while(i <= num) {
			sum += i;
			i++;
		}
		System.out.println("총합: " + sum);
		
	}
	
	public static void reservation() {
		Scanner sc = new Scanner(System.in);
		System.out.print("춘천, 부산, 대구, 수원 중 한 곳을 입력하세요: ");
		String place = sc.nextLine();
		
		int ch = 5000, bo = 30000, da = 20000, so = 10000;
		
		if(place.equals("춘천")) {
			System.out.println(place + " 까지의 금액은 " + ch + "원 입니다.");
		}else if (place.equals("부산")) {
			System.out.println(place + " 까지의 금액은 " + bo + "원 입니다.");
		}else if (place.equals("대구")) {
			System.out.println(place + " 까지의 금액은 " + da + "원 입니다.");
		}else if (place.equals("수원")) {
			System.out.println(place + " 까지의 금액은 " + so + "원 입니다.");
		}
	}
	
	public static void sub_number(int number1, int number2) {
		int sub = number1 - number2; 
		if(sub >= 0) {
			System.out.println(sub);
		} else {
			System.out.println(sub * (-1));
		}
	}
	
		
	public static void main(String[] args) {
		
		print(5);
		System.out.println();
		sum(5);
		reservation();
		sub_number(5,10);
		
	}

}
