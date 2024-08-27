package Abstract_Car;

public class Hyundai extends Car{

	@Override
	void 전진한다() {
		System.out.println("Hyundai 전진 기능");
	}
	
	@Override
	void 브레이크() {
		System.out.println("Hyundai 브레이크 기능");
	}
	
	@Override
	void 주차한다() {
		System.out.println("Hyundai 주차 기능");
	}
	
	@Override
	void 후진한다() {
		System.out.println("Hyundai 후진 기능");
	}
	
	void 현대만의_기능() {
		System.out.println("Hyundai만의 기능");
	}
	
}
