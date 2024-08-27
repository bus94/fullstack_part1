package Object;

import java.util.Objects;

class A{
	int num;
	int num2;

	// toString()을 하게 되면 Override가 자동으로 작성되는 것은
	// Object 클래스가 가지고 있는 toString을 상속 받았기 때문에
	// 새로운 함수를 만든 것이 아닌 상속받은 내용을 재정의(오버라이딩) 한 것이기 때문이다
	@Override
	public String toString() {
		return "num: " + num;
	}
	// (toString으로 반환값을 정하지 않으면 주소값이 출력됨)

	@Override
	public boolean equals(Object obj) {
		
		// obj는 A 타입의 객체가 업 캐스팅 되어있는 상태
		// 따라서 Object 타입의 obj를 A 타입으로 자식 클래스로 가야하는 다운 캐스팅 필요
		A temp = (A) obj; 
		
		if(this.num == temp.num || this.num2 == temp.num2) {
			System.out.println("같다!");
			return true;
		}else {
			System.out.println("다르다!");
			return false;
		}
		
	}
	
}

public class Main {

	public static void main(String[] args) {

//		// Object 클래스
//		// - 모든 자바는 무조건 Object 클래스로부터 시작
//		// - 클래스 생성 시 자동으로 Object 클래스를 상속 받는다 (extends 기입 하지 않아도 컴파일러가 알아서 상속 시켜주고 컴파일 해줌)
//		// - 필드(변수) 없고 메서드(함수) 구성 되어있다
//		
//		// Object 클래스 메서드 종류
//		// - 역할 : 운영체제와 자바 가상 머신의 사이를 관리
//		
//		// toString()
//		// - 객체 자신의 정보를 문자열로 반환
//		// - 객체의 고유한 정보를 출력하고 싶을 때
//		// - 기본적으로 객체를 출력(println)
//		//  변수.toString() 하지 않아도 자동으로 붙여 호출
//		// - 기본 정보를 원하지 않고 작성자가 원하는 대로 클래스 변수 내용을 보고 싶다면 재정의(오버라이딩)
//		
//		A a1 = new A();
//		System.out.println(a1); // System.out.println(a1.toString()); toString()이 자동으로 호출된 것
//		
//		// Arrays.toString(배열);
//		// 배열 자체를 String 문자화 이미 재정의 해놓은 것!
//		
//		// Objects 클래스
//		// 객체 비교, 해시코드 생성, null 여부, 객체 문자열 리턴 등등
//		// 수행하는 메서드들로 구성 (개발자가 가져다쓰기 편하게 구현 가능)
//		// 객체를 생성하지 않고도 사용할 수 있는 static 영역에 저장되어있다
//		boolean result = Objects.equals("이서희", "이서희");
//		System.out.println(result);
		
		A a1 = new A();
		a1.num = 10;
		A a2 = new A();
		a2.num = 20;
		
		// 객체 끼리 비교
		// equals(,);
		// 객체의 주소값만 확인
		boolean res = a1.equals(a2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(res);
		
		// String 클래스는 이미 문자를 비교하는 equals() 메서드를 만들어두었다
		String str1 = "ad";
		String str2 = "ad";
		if(str1.equals(str2)) {
			System.out.println("문자열이 같다.");
		} else {
			System.out.println("문자열이 다르다.");
		}
		
	}

}
