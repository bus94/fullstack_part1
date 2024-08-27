package ArrayList;

class Parent{
	String name;
	int age;
	
	void show() {
		System.out.println("Parent의 메서드 실행!");
	}
}

class Child extends Parent{
	/* 
	 * 부모 클래스의 변수는 아래와 같이 상속받아 저장되어있음
	 * 
	 * String name;
	 * int age;
	 * 
	 */
	int number;
	
	void show() {
		System.out.println("Child의 메서드 실행!");
	}
}

public class ParentMain {

	public static void main(String[] args) {
		// 업 캐스팅 (자식 → 부모 타입으로 변경)
		// - (Parent) 형변환 연산기호를 생략할 수 있다
		// 자식 클래스가 부모 클래스로 업캐스팅 된다는 것은 멤버 개수가 감소하는 것을 의미
		//  그러다보니 자식 클래스에만 있는 속성(변수)과 메서드는 실행을 못한다
		//   실행하고 싶다면 자식 클래스에서 부모가 물려준 메서드를 오버라이딩한다
		//   부모 클래스의 메서드가 동작하는 것이 아니라 자식 클래스의 메서드가 우선적으로 실행된다
//		Q. 그렇다면 자식 클래스의 메서드를 사용하고 싶다면 무조건 부모 클래스에 해당 메서드를 작성하고 오버라이딩 작업 후 써야하는건지?
//		A.  
		// 업캐스팅을 하는 이유: 공통적으로 할 수 있는 부분을 만들어서 간단하게 다루기 위해서
		Parent p2 = (Parent) new Child();
		p2.show(); // 오버라이딩해서 사용 가능 → Child의 show() 메서드 실행
// 		Q. 오버라이딩을 하지 않았는데 출력해보면 왜 Child의 show() 메서드가 실행되는 것인가?
//		A. 
		
		// 다운 캐스팅 (부모 → 자식 타입으로 변경)
		// 업캐스팅해서 공통부분을 다루었다면 자식들만의 메서드나 변수를 사용하기 위해 업캐스팅한 객체를 다시 자식 클래스 타입으로 되돌리는 것
		// 주의! 형변환 기호를 생략 할 수 없다 
		// (Child) 변수명
		Child c2 = (Child) p2;
		
		c2.show(); // p2의 show() 사용
		
		// 참조변수의 형변환은 사용할 수 있는 멤버의 개수를 조절하는 것
		
		// 같은 부모를 상속 받은 형제 클래스끼리는 서로 캐스팅이 불가능
	}

}
