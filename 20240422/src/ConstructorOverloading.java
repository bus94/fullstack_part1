
class Naver{
	private String email;
	private String passwd;
	private String id;
	
	// 함수에서 중요한 부분
	// 접근제어자 반환타입 함수명(매개변수 타입)
	// → 매개변수명은 상관 없다
	// ex. public String fuction(int count)
	
	public Naver() {}
	
	// <생성자 오버로딩> : 오버로딩을 이용하여 생성자 생성
	// 타입이 다른 같은 명의 생성자를 여러 개 생성
	// 매개 변수의 타입이나 개수가 다르다
	public Naver(String email, String passwd, String id) {
		this.email = email;
		this.passwd = passwd;
		this.id = id;
	}

	public Naver(String passwd, String id) {
		this.passwd = passwd;
		this.id = id;
	}
	
}

class Animal{
	String name;
	String breeds; 
	int age;
	
	public Animal() {}
	public Animal(String name) {
		this.name = name;
	}
	public Animal(String name, String breeds) {
		this.name = name;
		this.breeds = breeds;
	}
	public Animal(String name, String breeds, int age) {
		this.name = name;
		this.breeds = breeds;
		this.age = age;
	}
	
	void makeSound() {
	}
}

class Cat extends Animal{
	
	// 부모 클래스에서 상속받은 함수로 다시 재정의 하겠다
	// Overriding (오버라이딩: 덮어쓰기) 
	// 비슷한 뜻으로 Change
	// : 부모가 물려준 함수의 내용을 재정의하는 것
	// - 함수를 새로 만드는 것이 아니다
	// - 함수명, 매개변수 개수 및 타입이 똑같아야 한다
	//   반환타입까지 부모가 만든 함수랑 똑같아야 한다
	@Override
	void makeSound() {
		System.out.println("야옹");
	}
	
	public Cat() {}
	public Cat(String name, String breeds, int age) {
		super(name, breeds, age);
	}
}

class Dog extends Animal{
	
	
	@Override
	void makeSound() {
		System.out.println("멍멍");
	}
	
	public Dog() {}
	public Dog(String name, String breeds, int age) {
		super(name, breeds, age);
	}
}

public class ConstructorOverloading {

	public static void main(String[] args) {
		Naver n1 = new Naver();
		Naver n2 = new Naver("qqqq", "qqqq");
		Naver n3 = new Naver("email", "passwd", "id");
	}
	
	Animal a1 = new Animal();
	
}
