package Constructor;

/*
 * 패키지
 * → 디렉토리 구조
 * → 폴더를 여러 개 나눠서 관리
 * → 클래스들의 중복을 제거
 * 
 * 접근 제어자
 * → 사용자가 굳이 알 필요없는 정보는 사용자로부터 숨겨야 한다 (ex. 패스워드 등)
 * → ex. private, public, default, protected
 * 
 * private (비공개)
 * → 같은 클래스(선언한 클래스)에서만 사용 가능
 * → 외부 클래스 사용 불가
 * 
 *  #같은 폴더에서 같은 클래스명이 존재할 수 없다
 */

/* 
 * <자동 생성 방법>
 * 생성자 : Source - Generate Constructor using Fields
 * getter와 setter : Source - Generate Getters and Setters
 *    단, 이미 작성되어있는 getter와 setter가 있으면 해당 변수에 대한 건 체크할 필요가 없도록 되어있다
 */ 
class Member{
	private String id;
	private String name;
	private String password;
	private String email;
	private char gender;
	private int age;
	
	Member(String n, String i) {
		name = n;
		id = i;
	}
	public Member(String id, String name, String password, String email, char gender, int age) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	// setter
	// getter
	// this : 클래스 멤버를 구별하기 위해 사용하고, 자기 자신의 객체를 가리키는 것
	// → ∵ 메서드에서 매개변수 이름이 클래스 멤버 변수명과 같다면 어떤 변수가 클래스 멤버 변수인지 모르기 때문에
	// ex) this.password = password; → 객체의 password = 매개변수의 password; 
	void setName(String updateName) {
		name = updateName;
	}

	String getName(){
		return name;
	}
	String getId() {
		return id;
	}

	void show() {
		System.out.println(name);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password; // 객체의 password = 매개변수의 password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}

public class ConstructorEx4 {

	public static void main(String[] args) {

		Member mem1 = new Member("개똥이", "qewr");
		// mem1.name = "개똥이"; 에러 → private으로 변수를 설정했기에 main에서 Member 클래스의 name에 접근할 수가 없다

		// 확인 방법
		// 1. 생성자 이용
		// 변수를 만들 때 안에 있는 private 멤버들을 초기화 한다
		
		// 2. setter 와 getter (수정하는 함수 / 꺼내오는 함수)
		// 비공개 되어있는 멤버들을 외부로 가져올 때 외부에서 값을 수정할 수 있도록 하는 역할의 함수
		System.out.println(mem1.getName());
		System.out.println(mem1.getId());
		
		mem1.setName("이똥개");
		System.out.println(mem1.getName());
	}

}
