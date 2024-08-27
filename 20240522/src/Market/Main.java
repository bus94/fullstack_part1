package Market;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Service service = new Service();

		Scanner sc = new Scanner(System.in);

		int menu = 0;

		try {

			while (true) {
				System.out.println("1) 서희의 모든 주문 목록?");
				System.out.println("2) 서희가 주문한 모든 횟수 조회?");
				System.out.println("3) 서희가 모든 주문별 결제 금액을 조회");
				System.out.println("4) 서희의 총 결제 금액을 조회");
				System.out.println("5) 상품1 돈까스의 총 판매 금액은 64,500원 조회 ");
				System.out.println("0 종료!");

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

				case 5:
					service.join5();
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
