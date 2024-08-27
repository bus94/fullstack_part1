package Inheritance_Shape;

public class Main {

	public static void main(String[] args) {

		// 도형에 대해 저장하는 클래스들
		
		// 사각형 인스턴스를 생성 (새로운 변수)
		Rect rect1 = new Rect();
		rect1.x = 100;
		rect1.y = 100;
		rect1.w = 100;
		rect1.h = 100;
		rect1.draw();
		
		// 원 인스턴스 (새로운 변수)
		Circle c1 = new Circle(10, 10, 10);
//		c1.x = 10;
//		c1.y = 10;
//		c1.r = 10; // → private int r; 이기에 에러 발생
		c1.draw();
		
	}

}
