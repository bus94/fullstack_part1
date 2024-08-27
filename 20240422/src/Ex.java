
public class Ex {

	public static void main(String[] args) {

		// 클래스를 이용해서 실제 객체인 인스턴스를 만드는 곳은 main
		
		// main 함수 안에서의 a1은 지역 변수인 것
		A a1 = new A();
		a1.push();
		a1.show(10);
		a1.push();
		a1.show(11);
		a1.push();
		
		System.out.println(A.top);
	}

}
