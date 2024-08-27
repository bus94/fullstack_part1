package Coffee;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Service service = new Service();

		Scanner sc = new Scanner(System.in);

		int menu = 0;

		try {

			while (true) {
				System.out.println("1) 음료(beverages)의 이름 및 가격과 함께,"
								+ " 가장 비싼 음료와의 가격 차이를 조사하려 한다. "
								+ "주어진 두 쿼리를 조합하여 이를 구하시오. ");
				
				System.out.println("2)주문내역(order_details)로부터 주문 별 음료 개수의"
								+ " 평균을 조회하려 한다."
								+ " 주어진 쿼리를 조합하여 이를 구하시오. ");
				
				System.out.println("3) 주문내역(order_details)로부터 음료 별 주문"
								+ " 개수를 조회하려 한다. 주어진 두 쿼리를 조합하여 이를 구하시오.");
				
				System.out.println("4) 평균 가격보다 비싼 음료(beverages)를 다음과 "
								 + "같이 조회하려 한다. 주어진 두 쿼리를 조합하여 "
								 + "이를 구하시오.");
				
				System.out.println("0) 종료!");

				menu = sc.nextInt();

				switch (menu) {
				case 1:
					service.join1();
					break;
				case 2:
					service.join2();

					break;
				case 3:
					service.join3();
					break;
				case 4:
					service.join4();
					break;

				case 0:
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
