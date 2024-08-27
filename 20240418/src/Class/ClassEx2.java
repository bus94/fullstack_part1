package Class;

// 클래스 정의 (생성)
class Member {
	String memberId;
	String memberPwd;
	String memberName;
	int age;
	char gender;
	String phone;
	String email;
	
}

// 중복 변수들이 많아지는 현상을 해결하기 위해 하나의 틀인 클래스를 이용하는 것이다
// 클래스 - 변수들의 묶음
// ValueObject: 한 건의 데이터를 저장하는 것 (VO 클래스)
class Cookie {
	// 클래스 멤버변수(필드)
	String name;
	int level;
	int hp;
	char grade;
	String attr;
	
	// 새로운 인스턴스 생성할 때마다 클래스 멤버변수의 값들을 하나하나씩 선언해줘야하므로 그 과정을 해결하기위해서
	// 클래스 내 함수를 선언하여 그 함수를 사용한다
	// 함수 생성 과정에서 init 이라는 함수명은 위의 다섯가지 유형의 클래스 변수의 값을 저장한다는 의미로 작성하였다
	void init(String n, int l, int i, char g, String a) {
		name = n;
		level = l;
		hp = i;
		grade = g;
		attr = a;
	}
	
}// → 클래스로 묶었다 - "캡슐화" 라고 함

public class ClassEx2 {

	public static void main(String[] args) {

		Member member1 = new Member();
		System.out.println(member1);

		// 클래스 통해 인스턴스 생성
		Cookie c1 = new Cookie();
		// 해당 클래스의 함수를 통해 입력값 대입
		c1.init("와인맛 쿠키", 5, 160, 'S', "와인 던지기");
		
		Cookie c2 = new Cookie();
		c2.init("용감한 쿠키", 1, 80, 'A', "그냥 용감해");
		
		Cookie c3 = new Cookie();
		c3.init("평범한 쿠키", 1, 80, 'A', "진심 평범해");

	}

}
