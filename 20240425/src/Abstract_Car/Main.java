package Abstract_Car;

public class Main {

	public static void main(String[] args) {

		// 추상 클래스는 객체(인스턴스)를 생성할 수 없다
		// Car car1 = new Car();
		
		// 하지만 추상 클래스를 상속받는 클래스에 대한 객체는 생성할 수 있다
		BMW c1 = new BMW();
		Benz c2 = new Benz();
		Hyundai c3 = new Hyundai();
		
		// 추상 클래스
		// - 객체는 생성할 수 없지만 다형성을 이용할 수는 있다
		// 여러 개의 객체를 관리할 수 있다
		Car[] list = {c1, c2, c3};
		
		for(int i = 0; i < 3; i++) {
			list[i].전진한다();
		}
		
		// 추상 클래스에 새로운 내용이 추가되거나 삭제되거나 그러면 추상클래스를 상속해 간 자식 클래스들은
		// 꼭 오버라이딩을 하거나 메서드를 삭제해줘야 한다
		
	}

}
