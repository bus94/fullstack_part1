package Abstract_Phone;

public class V40 extends SmartPhone{
	
	String maker = "LG";
	
	public V40() {
	}
	
	@Override
	void printInformation() {
		System.out.println("V40은 " + maker + "에서 만들어졌고 제원은 다음과 같다.");
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

	// V40의 기능
	String picture() {
		return "1200, 1600만 트리플 카메라";
	}
	
	String charge() {
		return "고속 충전, 고속 무선 충전";
	}
	
	String touch() {
		return "정전식";
	}
	
}
