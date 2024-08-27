package Abstract_Car;

// 추상 메서드를 하나라도 가지고 있으면 절대로 완벽한 설계도를 만들 수 없다 (틀을 만들어 놓은 것일 뿐)
// 공통적인 내용(기능)을 강제적으로 규칙을 정하는 추상 메서드
// 추상 메서드를 가지고 있으면 추상 클래스

// 추상 클래스는 추상 메서드만 저장할 수 있는 것이 아니라 일반 메서드도 구현이 가능

public abstract class Car {
	
	abstract void 전진한다();
	abstract void 브레이크();
	abstract void 주차한다();
	abstract void 후진한다();

	// 추상 클래스지만 일반 메서드도 구현
	// 이 기능을 상속받는 클래스에서 받을 수도, 안 받을 수도 있는 것
	void bluetooth() {
		System.out.println("");
	}
	
}
