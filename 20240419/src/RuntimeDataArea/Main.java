package RuntimeDataArea;

/*
 * <Java 메모리 영역>
 * - Stack 영역
 * 		메서드가 실행 될 때 지역변수, 매개변수, 객체의 주소값을 저장하는 참조변수
 * 		함수가 실행하고 끝나면 사라지는 공간
 * 
 * - Heap 영역
 * 		클래스를 이용해서 만드는 공간(객체)
 * 		new 키워드를 이용해서 메모리 할당
 * 		프로그램이 실행 중일 때(Runtime) 생성되는 객체들을 인스턴스(Instance)라고 한다.
 * 		프로그램이 시작하면 데이터나 변수들이 생성되는데, 프로그램이 끝날 때까지 데이터를 유지할 수 있다.
 * 		Java의 GarbageCollector 역할로 인해 생성된 메모리 공간(주소)에 변수가 없다면 그 공간을 회수한다. 
 * 		그 공간을 활용, 참조하게 되어 Heap을 참조영역이라고도 한다.
 * 
 * - Static 영역 (정적영역, method영역)
 * 		Java 프로그램이 실행하기 전, static 변수나 메서드를 첫 단계에 메모리에 올려 프로그램을 실행
 * 		실행 1순위 → static
 * 		자바 가상 머신(JVM)에서 객체를 생성하지 않아도 메모리에 호출시켜 할당이 가능하다.
 * 		main 함수도 실행되기 위해서는 메모리에 올라가야 한다. 
 * 			∴ public static main(){} → main함수에 static이 붙게 되는 것!!
 * <Java 변수의 종류>
 * 	클래스 변수 : static / 객체끼리 공유하는 변수로 여러 개의 객체 공통적으로 사용하는 값
 * 	인스턴스 변수 : 개별적인 저장공간으로 객체, 인스턴스마다 다른 값을 저장할 수 있다
 * 	지역 변수 : 함수 내에 사용할 수 있는 값
 * 	매개 변수 : 전달되는 값 
 * 
 * 	→ 생성되는 시간에 따라 구별
 * 		1) static
 * 		2) non_static
 * 
 */

class B{
	int hakbun;
	static int count = 1;
	
	B(int hakbun){
		this.hakbun = hakbun;
		System.out.println("학번: " + hakbun);
		System.out.println("B객체 생성: count: " + count++);
	}
}

class D{
	int data;
	
	void show() {
		System.out.println("non-static");
	}
	
	static void show2() {
		// System.out.println(data); → 에러 발생. static이기 때문에 1순위로 실행됨 → 따라서 D클래스 안에 있는 data 변수는 출력에 포함 되지 않은 것
		System.out.println("static O");
	}
}

public class Main {

	public static void main(String[] args) {

		// b1, b2, b3 : 인스턴스 변수
		B b1 = new B(1001); // Heap 영역에 b1, b2, b3가 인스턴스 변수로서 저장되어 있고, static method 영역에 count가 저장되어 있다
		B b2 = new B(1001);
		B b3 = new B(1002);
		
		b1.count = 1000; // 
		b1.hakbun = 1005;
		
		// count의 변화는 모두에게 영향을 주었지만, hakbun의 변화는 서로에게 영향을 주지 않았다
		// 	→	count(클래스 변수로써)는 static 영역이라는 공유하는 영역에서 수정된 것이고 (클래스 변수 : 객체끼리 공유하는 변수),
		// 		hakbun은 Heap 영역에서 수정된 것이기에 각각의 다른 인스턴스 변수는 수정되지 않은 것이다
		System.out.println(b1.count);
		System.out.println(b1.hakbun);
		
		System.out.println(b2.count);
		System.out.println(b2.hakbun);
		
		System.out.println(b3.count);
		System.out.println(b3.hakbun);
		
		// 클래스D 안에 있는 static show2()를 생성
		// show2(); 만 작성하면 x, 따라서 어디 클래스의 show2인지 작성 필요
		D.show2();
		
		
		
	}

}
