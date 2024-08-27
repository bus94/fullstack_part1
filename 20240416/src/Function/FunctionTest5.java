package Function;

import java.util.Scanner;

// 엘레베이터
public class FunctionTest5 {

	public static void goDownfloor(int n, int t) {

		for (int i = 0; i < n - t + 1; i++) {
			System.out.println("현재 층은 " + (n-i) + " 입니다.");
		}
		System.out.println(t + " 층에 도착하였습니다. 안녕히 가세요.");
	}

	public static void goUpfloor(int n, int t) {

		for (int i = 0; i < t - n + 1; i++) {
			System.out.println("현재 층은 " + (n+i) + " 입니다.");
		}
		System.out.println(t + " 층에 도착하였습니다. 안녕히 가세요.");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("가고자 하는 층 입력: ");
			int i = sc.nextInt();
			System.out.print("현재 위치 입력: ");
			int n = sc.nextInt();
			if (i == n || i > 6 || i < 1) {
				System.out.println("다른 층(1~6)을 눌러주세요.");
			} else {
				if (n > i) {
					goDownfloor(n, i);
					return;
				} else if (n < i) {
					goUpfloor(n, i);
					return;
				}
			}
		}

	}

}
