package Exception;

class A{
//	void z() {
//		try {
//		System.out.println(10 / 0);
//		}catch(Exception e) {
//			// 예외가 발생하면 어디서 어떤 함수에서 생겼는지 그 함수와 관련된 모든 내용들을 스택 구조(쌓기 구조)로 보여준다
//			e.printStackTrace();
//		}
//	}
	
	// 예외가 발생하면 한 군데에서 처리하기
	// 메서드를 실행할 때 모든 예외에 대해 z()를 호출한다 (z라는 메서드를 실행)
	// 예외를 던진다 
	void z() throws Exception{
		System.out.println(10 / 0);
	}
	
	void z1() throws IndexOutOfBoundsException, ArithmeticException{
		System.out.println(10 / 0);
	}
}

public class Main2 {

	public static void z() throws Exception{
		System.out.println(10 / 0);
	}
	
	public static void y() throws Exception{
		z();
	}
	
	public static void x() throws Exception{
		y();
	}
	
	public static void main(String[] args) {

		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		A a4 = new A();
		A a5 = new A();
		
		try {
			a1.z();
			a2.z1();
			x(); // main이 부른 함수 x(); 이므로 main에서 x();를 예외처리하는 것
		}catch(Exception e) {
			// 예외의 부모클래스로 업캐스팅해서 예외에 관한 모든 자식들을 처리한다
			e.printStackTrace();
		}
		
	}

}

