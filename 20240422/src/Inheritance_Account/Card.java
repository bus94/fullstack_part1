package Inheritance_Account;

// 은행에서 발급하는 체크카드는 계좌와 연결
// 계좌의 정보를 가져온다
public class Card extends Account{

	// 카드만의 정보
	String cardNumber;
	int cardPw;
	int cvc;
	
	public Card() {}
	
	// 자식클래스에서 생성자를 만들면 부모클래스의 생성자 내용(매개변수)을 직접 입력해야한다
	// 아래 같은 경우 매개변수가진 생성자 만들면 cardNumber, cardPw, cvc에 대한 생성자만 만들어짐
	// 부모클래스의 매개변수 생성자에 대한 내용인 accNumber, accPw, accName, money는 직접 입력함
	public Card(String cardNumber, int cardPw, int cvc, String accNumber, int accPw, String accName, int money) {
		this.accNumber = accNumber;
		this.accPw = accPw;
		this.accName = accName;
		this.money = money;
		this.cardNumber = cardNumber;
		this.cardPw = cardPw;
		this.cvc = cvc;
	}

	// account 가지고 있는 메서드 사용
	void pay(int money) {
		// 계좌에서 출금
		withdraw();
	}
	
	
}
