package Sort;

import java.util.Scanner;

public class SelectionSortTest2 {
	
	public static double cal_productPrice(int totalPrice) {
		
		double productPrice = (double) totalPrice * 10 / 11;
		return productPrice;
		
	}
	
	public static double cal_tax(int totalPrice) {
		
		double tax = (double) totalPrice / 11;
		return tax;
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("소비자가 입력(원): ");
		int totalPrice = sc.nextInt();
		
		System.out.println("제품 가격은 " + cal_productPrice(totalPrice) + "원, 부가가치세는 " + cal_tax(totalPrice) + "원입니다.");
		
		
	}

}
