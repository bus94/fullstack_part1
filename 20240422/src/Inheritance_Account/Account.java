package Inheritance_Account;

import java.util.Scanner;

// 고객의 정보를 저장하는 클래스
public class Account {
	// Scanner 전역변수로 활용해야 함수 실행할 때마다 써야하는 번거로움 사라짐
	Scanner sc = new Scanner(System.in);
	
	// 상태(데이터)
	String accNumber; // 계좌번호
	int accPw; // 비밀번호
	String accName; // 계좌명
	int money; // 잔액
	
	// <동작(함수) ex. 출금, 입금, 조회 등>
	// 입금
	void deposit(int money) {
		this.money += money;
	}
	
	// 출금
	void withdraw() {
		if(money <= 0) {
			System.out.println("잔액이 부족하여 출금을 할 수 없습니다.");
			return; // 잔액 부족으로 출금 못하면 과정 끝내기
		} 
		// 출금할 금액 입력하기
		System.out.print("출금액: ");
		int temp = sc.nextInt();
		
		if(temp > money) {
			System.out.println("잔액이 부족합니다(출금 불가).");
		}else {
			this.money -= temp;
			System.out.println("출금 완료!");
			System.out.println("현재 잔액: " + money);
		}
		
	}
	
}
