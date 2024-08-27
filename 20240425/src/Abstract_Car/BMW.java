package Abstract_Car;

// BMW 자동차
public class BMW extends Car{
	
	// 자동차로써의 기본적인 기능
	@Override
	void 전진한다() {
		System.out.println("BMW 전진 기능");
	}
	
	@Override
	void 브레이크() {
		System.out.println("BMW 브레이크 기능");
	}
	
	@Override
	void 주차한다() {
		System.out.println("BMW 주차 기능");
	}
	
	@Override
	void 후진한다() {
		System.out.println("BMW 후진 기능");
	}
	
	// BMW만의 기능
	void seriesM() {
		System.out.println("BMW 고성능 기능!");
	}
	
}
