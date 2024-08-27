package Constructor; // 생성자 : 객체 생성 시 원하는 값으로 초기화 할 수 있다

class Cat{
	
	String name; // 이름
	String breeds; // 품종
	double weight; // 무게
	
	// 생성자 (함수랑 비슷)
	// 기본 세팅되어있는 초기값으로 결정하는 것이 아닌 개발자가 원하는 값으로 설정
	Cat(String n, String b, double w){
		name = n;
		breeds = b;
		weight = w;
	}
	
	// 생성자의 2가지 역할
	// 1) 객체 생성 : 메모리 공간 만들기
	// 2) 객체 초기화 : 객체의 변수들의 값을 저장
	
	// 동작(메서드)
	void claw() {}
	void meow() {}
	
}

class Dog{
	String name; // 이름
	String breeds; // 품종
	int age; // 나이
	
	// 생성자 생성
	Dog(String n, String b, int a){
		name = n;
		breeds = b;
		age = a;
	}
}

class Hero{
	String name;
	int hp;
	
	Hero(String n, int h){
		name = n;
		hp = h;
		System.out.println("생성완료!");
	}
	
	void print(String name, int hp) {
		System.out.println("Hero { name: " + name + ", hp: " + hp + " }");
	}
	String toStr() {
		// 실수 %.자릿수f → %.1f = 10.1f
		return String.format("Hero { name : %s, hp : %d } ", name, hp);
	}

	// 아래의 코드는 String toStr(){} 와 같음
//	@Override
//	public String toString() {
//		return "Hero { name : " + name + ", hp : " + hp + " }";
//	}

}

public class ConstructorEx1 {

	public static void main(String[] args) {

		Cat cat1 = new Cat("나비", "턱시도", 2.0);
		System.out.println(cat1.name + " " + cat1.breeds + " " + cat1.weight);
		Cat cat2 = new Cat("야옹이", "턱시도", 2.1);
		System.out.println(cat2.name + " " + cat2.breeds + " " + cat2.weight);
		
		Dog dog1 = new Dog("망고", "시츄", 5);
		System.out.println(dog1.name + " " + dog1.breeds + " " + dog1.age + "살");

		Hero hero1 = new Hero("아이언맨", 80);
		Hero hero2 = new Hero("타노스", 160);
		Hero hero3 = new Hero("토르", 150);
		Hero hero4 = new Hero("그루트", 40);
		
		// Q. 객체명.클래스함수명(); 에서 객체명은 해당 객체의 함수를 호출하는 것이고, (name, hp)안에 있는 변수들의 정보만 빼올 뿐 객체의 기준은 맨앞에 적힌 객체명이 기준이다. 
//		hero1.print(hero1.name, hero1.hp);
//		hero2.print(hero2.name, hero2.hp);
//		hero3.print(hero3.name, hero3.hp);
//		hero4.print(hero4.name, hero4.hp);
		
		System.out.println(hero1.toStr());
		System.out.println(hero2.toStr());
		System.out.println(hero3.toStr());
		System.out.println(hero4.toStr());
		
		System.out.println("===============================");
		System.out.println("객체 배열을 생성하여 출력한 Hero");
		
		Hero[] hero = new Hero[4];
		
		hero[0] = hero1;
		hero[1] = hero2;
		hero[2] = hero3;
		hero[3] = hero4;
		
		for(int i = 0; i < hero.length; i++) {
			System.out.println(hero[i].toStr());
		}
		
		
	}

}
