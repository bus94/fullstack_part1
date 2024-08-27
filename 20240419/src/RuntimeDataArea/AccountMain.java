package RuntimeDataArea;
/*
 * 계좌 등록시 계좌 번호는 은행에서 순서대로 발급 (중복 방지 위함)
 * int accNumber 계좌 번호 발급 static
 * 
 */

class Account{
	static int number = 1000;
	
	private int accNumber;
	private String accName;
	private int money;
	private int password;
	
	Account(String accName, int money, int password){
		accNumber = number++;
		this.accName = accName;
		this.money = money;
		this.password = password;
		
		info();
	}
	
	void info() {
		System.out.println("No." + number);
		System.out.println("계좌명: " + accName);
		System.out.println("계좌번호: " + accNumber);
		System.out.println("계좌 비밀번호: " + password);
		System.out.println("잔액: " + money);
		System.out.println();
	}

	public static int getNumber() {
		return number;
	}

	public static void setNumber(int number) {
		Account.number = number;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
}

public class AccountMain {

	public static void main(String[] args) {

		Account[] list = {
				new Account("댕댕이", 0, 1234),
				new Account("이쌤", 100, 4567),
				new Account("채쌤", 10000, 8912)
		};
		
//		for(int i = 0; i < list.length; i++) {
//			list[i].info();
//		}
		
	}

}
