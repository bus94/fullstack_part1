package Function;

import java.util.Scanner;

// 요금
public class FunctionTest6 {
	
	public static double periodDiscount(int contractPrice, int period) {
		
		if(period > 12) {
			return contractPrice * 20 / 100;
		} else if(period > 6) {
			return contractPrice * 10 / 100;
		} else {
			return contractPrice * 0 / 100;
		}
		
	}
	
	public static double creditCardDiscount(int contractPrice, int cardCode) {
		
		switch (cardCode) {
		case 13:
			return contractPrice * 12 / 100;
		case 12:
			return contractPrice * 8 / 100;
		case 11:
			return contractPrice * 5 / 100;
		default :
			return 0;
		}
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("계약 금액 입력: ");
		int contractPrice = sc.nextInt();
		System.out.print("사용 개월 수 입력: ");
		int period = sc.nextInt();
		System.out.print("카드 코드 입력: ");
		int cardCode = sc.nextInt();
		
		double finalPrice = contractPrice - periodDiscount(contractPrice, period) - creditCardDiscount(contractPrice, cardCode);
		System.out.println("최종 요금은 " + finalPrice + " 원 입니다.");
	}

}
