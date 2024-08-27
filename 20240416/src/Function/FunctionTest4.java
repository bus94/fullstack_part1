package Function;

import java.util.Scanner;

// 기차표 예매
public class FunctionTest4 {

	public static int objection(String o) {

		int a = 0;
		switch (o) {
		case "춘천":
			a = 5000;
			break;

		case "부산":
			a = 30000;
			break;

		case "대구":
			a = 20000;
			break;

		case "수원":
			a = 10000;
			break;

		}
		return a;
	}

	public static int train(String t) {
		int b = 0;
		switch (t) {
		case "KTX":
			b = 10000;
			break;

		case "새마을호":
			b = 5000;
			break;

		case "무궁화호":
			b = 3000;
			break;
	
		}
		return b;
	}

	public static int ud(String s) {
		int c = 0;
		switch (s) {
		case "좌석":
			c = 0;
			break;

		case "입석":
			c = -2000;
			break;

		}
		return c;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("춘천(운임:5000원) 부산(운임:30000원) 대구(운임:20000원) 수원(운임:10000원) 중 목적지를 한 곳 입력하세요: ");
		String o = sc.nextLine();
		System.out.print("KTX(10000원 추가)/새마을호(5000원 추가)/무궁화호(3000원 추가) 중 하나를 입력하세요: ");
		String t = sc.nextLine();
		System.out.print("좌석/입석(2000원 할인)중 하나를 입력하세요: ");
		String s = sc.nextLine();
		
		int cal_payment = objection(o)+train(t)+ud(s);
		
		System.out.println(cal_payment + " 원");
	}

}
