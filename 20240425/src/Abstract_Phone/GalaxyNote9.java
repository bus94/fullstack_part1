package Abstract_Phone;

// 갤럭시노트9는 스마트폰이면서 폰
public class GalaxyNote9 extends SmartPhone {

	String maker = "삼성";
	
	public GalaxyNote9() {
	}

	// 상속받는 클래스가 추상 클래스이므로 부모 클래스격들의 추상 메서드는 모두 오버라이딩 대상이 된다
	@Override
	void printInformation() {
		System.out.println("갤럭시 노트9은 " + maker + "에서 만들어졌고 제원은 다음과 같다.");
		System.out.println(makeCall());
		System.out.println(takeCall());
		System.out.println(picture());
		System.out.println(charge());
		System.out.println(touch());
	}

	@Override
	String makeCall() {
		return "번호를 누르고 통화버튼을 누름";
	}

	@Override
	String takeCall() {
		return "수신 버튼을 누름";
	}
	
	// 갤럭시노트만의 기능으로 오버라이딩 대상이 아니다
	String picture() {
		return "1200만 듀얼 카메라";
	}
	
	String charge() {
		return "고속 충전, 고속 무선 충전";
	}
	
	String touch() {
		return "정전식, 와콤펜 지원";
	}

	
	
}
