package Inheritance_Shape;

public class Rect extends Shape {
	// 상속을 이용해서 좌표 변수 받음
	
	// 사각형을 그리기 위한 좌표
	int w; // 너비
	int h; // 높이
	
	// 기본 생성자
	public Rect() {
		System.out.println("기본 생성자");
	}
	// 기본 생성자가 없으면 main 함수에서 new Rect 변수 생성 시 에러 발생
	
	// 원하는 값으로 인스턴스 생성과 동시에 초기화
	// 매개 변수가 있는 생성자
	public Rect(int x, int y, int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	@Override
	void draw() {
		System.out.println("사각형 그리기");
	}
	
}
