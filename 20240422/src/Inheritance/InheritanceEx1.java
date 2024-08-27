package Inheritance;

class A{
	private int num;
	int num2;
	
	// 매개 변수를 가진 생성자
	public A(int num, int num2) {
		this.num = num;
		this.num2 = num2;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	
}
class B extends A{
	// 상속 하게 되면 부모가 매개 변수 가진 생성자를 만들면 부모가 객체를 먼저 생성하고 "매개 변수 데이터" 저장해서 자식한테 보내줘야 한다.
	// → 물건 받으면 물건이 눈 앞에 있어야 하는 것처럼
	
	int num3;
	
	// 부모 클래스의 생성자를 호출하는 키워드
	public B(int num, int num2, int num3) {
		super(num, num2); // super는 상속받는 클래스의 변수 데이터(즉 A의 데이터)
		this.num3 = num3;
	}
	
}

public class InheritanceEx1 {

	public static void main(String[] args) {

		// 상속 : 클래스들 안에 중복 변수나 메서드를 하나의 클래스로 만든다.
		// 		   기본적인 클래스를 만들어서 새로운 클래스를 만들 때 기본 클래스를 적용해서 추가적인 내용을 가진 클래스로 만든다.
		// extends 기본 클래스명{}
		// 상속은 하나의 클래스만 가능 하고,	
		// 여러 개의 클래스(다중 상속)를 상속 할 수 없다.
		// → 인터페이스 개념이 나오게 된다.
		
		// 상속 중 접근 제어자 private
		// 자식 클래스에서 부모 클래스의 private 변수나 메서드에 접근 불가능
		B b1 = new B(10, 20, 30);
		System.out.println(b1.getNum());
		System.out.println(b1.num2);
		System.out.println(b1.num3);
	}

}
