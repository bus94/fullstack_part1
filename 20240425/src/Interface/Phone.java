package Interface;

// 핸드폰의 기능
//  - 스마트폰 / 2G폰 모두 전화에 대한 공통 기능 탑재

// 추상 클래스 (전화 걸고, 받는 공통 기능 가진 클래스)
public abstract class Phone {

	abstract String makeCall();
	abstract String takeCall();

}
