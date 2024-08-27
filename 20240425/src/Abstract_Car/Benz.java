package Abstract_Car;

public class Benz extends Car{
	
	@Override
	void 전진한다() {
		System.out.println("Benz 전진 기능");
	}
	
	@Override
	void 브레이크() {
		System.out.println("Benz 브레이크 기능");
	}
	
	@Override
	void 주차한다() {
		System.out.println("Benz 주차 기능");
	}
	
	@Override
	void 후진한다() {
		System.out.println("Benz 후진 기능");
	}
	
	void amg() {
		System.out.println("Benz 고성능 기능!");
	}
	
}
