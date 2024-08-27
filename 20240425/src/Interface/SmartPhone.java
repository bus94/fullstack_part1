package Interface;

// 스마트폰도 어떤 스마트폰인지 명확한 구분이 되지 않음
// ex. 갤럭시 노트9, 아이폰 13 등

// Java는 다중 상속이 안된다 (다중상속을 하게 된다면 각자 다른 클래스에서의 같은 이름의 메서드나 생성자 등 겹치는 문제가 발생)
// → 그래서 인터페이스 필요

public abstract class SmartPhone extends Phone {

	String maker; // 제조사
	
	public SmartPhone() {
		
	}

	// 정보 출력 메서드
	// 갤럭시나 아이폰 등 기종에 맞게 정보를 출력하는 "공통" 메서드
	abstract void printInformation(); // 추상 메서드

}
