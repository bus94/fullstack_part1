package Inheritance_Shape;

public class Circle extends Shape {
	// 상속을 이용해서 좌표 변수 받음

	// 원을 그리기 위한 좌표
	private int r; // 반지름
	
	// 컴파일 할 때 기본 생성자를 작성한다
	public Circle() {}
	
	// 인스턴스 변수(클래스 멤버 변수) 이름이 같을 때 구별을 위한 this 붙이기
	public Circle(int r, int x, int y) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	// 출력
	public void info() {
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("반지름: " + r);
	}
	
	// 오버라이딩
	@Override
	void draw() {
		System.out.println("원 그리기");
	}
	
}
