package Exception_Test;

import java.util.Scanner;

// 
class AccountException extends Exception {
	public AccountException(String msg) {
		super(msg);
	}
}

class Account {
	String accountNo; // 계좌 번호
	String ownerName; // 사용자 이름
	int balance; // 잔액

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	void deposit(int amount) { // 입금
		balance += amount;
		System.out.println(amount + "원 입금되었습니다. \n현재 잔액은 " + balance + "원 입니다.");
	}

	// 내가 만든 예외 처리(AccountException)를 메소드 안에서 해결
	void withdraw(int amount) throws AccountException { // 인출
		// 현재 잔액이 10만원일 때 출금액이 20만원이면 불가능 → 예외 처리
		if (amount > balance) {
			throw new AccountException("잔액이 " + (amount - balance) + "원이 부족합니다.");
		}
		// 잔액이 있다면 출금액 만큼 빼기
		balance -= amount;
		System.out.println(amount + "원이 출금되었습니다. \n현재 잔액은 " + balance + "원이 있습니다.");
	}
}

class CheckingAccount extends Account {
	String cardNo; // 카드 번호

	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}

	void pay(String cardNo, int amount) throws AccountException {
		if (!this.cardNo.equals(cardNo)) {
			throw new AccountException("카드 번호가 일치하지 않습니다.");
		}
		withdraw(amount);
//		if(amount > balance) {
//			throw new AccountException("잔액을 확인하세요.");
//		}
//		balance -= amount;
//		System.out.println(amount + "원이 결제되었습니다. \n현재 잔액은 " + balance + "원이 있습니다.");
	}
}

public class Main {

	public static void main(String[] args) throws AccountException {
		// 계좌 생성
		Account account1 = new Account("111-222-333", "홍길동", 100000);
		Account account2 = new Account("444-555-666", "김철수", 50000);
		Account account3 = new Account("777-888-999", "이영희", 200000);
		Account account4 = new Account("123-456-789", "박영수", 150000);
		Account account5 = new Account("987-654-321", "최민식", 300000);
		
		CheckingAccount checkAcc1 = 
				new CheckingAccount("999-88-777",
								  "홍길동", 100000
								  ,"5555-5555-4444");
		
		try {
			// 출금 테스트
			//account1.withdraw(1000000);
			//account2.withdraw(40000);
			
			// 결제 테스트
			checkAcc1.pay("5555-5555-4444", 2000000);

		} catch (AccountException e) {
			System.out.println("예외: " + e.getMessage());
		}
		System.out.println("정상 실행!");

//		Account a = new Account(190000);
//		CheckingAccount ca = new CheckingAccount();
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("인출할 금액: ");
//		int wd = sc.nextInt();
//		
//		try {
//			if((a.balance - wd) < 0) {
//				throw new MyException("");
//			}
//			System.out.println(wd + "원이 인출되었습니다.");
//			System.out.println("잔액 " + a.withdraw(wd) + "원이 있습니다.");
//		}catch(MyException e) {
//			System.out.println((wd - a.balance) + "원의 금액이 부족합니다.");
//		}

	}

}

//class MyException extends Exception{
//	
//	public MyException(String msg) {
//		super(msg); 
//	}
//	
//}