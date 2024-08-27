
public class A {
	
	// static 변수는 모든 함수에서 사용 가능하기 때문에 굳이 매개변수로 작성할 필요가 없다

	// 컴파일 후 메모리 로드 시 메모리 공간에 이미 할당됨
	// static 붙은 변수나 메서드는 이미 만들어진 것이기 때문에 어떤 함수든 출력 가능
	
	// 지역변수와 static 변수는 완전히 다른 것(다른 공간에 저장)
	// static 변수는 인스턴스 객체들이 공유할 수 있다
	
	// private static int top; 으로 작성할 경우 private 적용됨
	static int top;  
	// → 생략되어있는 default 제어자 이기 때문에 같은 폴더에서는 접근 가능하고, 다른 폴더에서는 접근 불가능하다
	
	void push() {
		System.out.println("현재 top: " + A.top); 
	}
	
	void show(int top) {
		System.out.println("매개변수 top: " + top);
		A.top++;
	}
	
}
