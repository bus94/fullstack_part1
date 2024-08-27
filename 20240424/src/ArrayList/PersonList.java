package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

class Person{
	private String name;
	private int age;
	
	
	// 매개변수를 받아서 한꺼번에 초기화
	// 매개변수: 전달되는 값
	public Person(){
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	// 클래스 멤버를 출력하는 함수
	// 인스턴스 : 변수마다 각각 생성되는 변수 또는 메서드
	// ↓ 인스턴스 메서드
	public void info() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
	
}

public class PersonList {

	public static void main(String[] args) {

		System.out.println(new Person()); // 메모리 공간의 주소값이 나오게 됨
		Person p1 = new Person();
		Person p2 = new Person("홍길동", 25);
		Person p3 = new Person("이익준", 30);
		
		
		p1.setName("이서희");
		p1.setAge(20);
		System.out.println(p1.getName() + " " + p1.getAge());
		System.out.println(p2.getName() + " " + p2.getAge());
		
		// 가변적인 Person 타입을 저장하는 배열
		// 동적 할당
		ArrayList<Person> list = new ArrayList<Person>();
		
		list.add(p1);
		list.add(p2);
		list.add(new Person("양석형",20));
		list.add(new Person("채송화",20));
		list.add(new Person("김준완",20));
		list.add(new Person("안정원",20));
		
		System.out.println(list); // 주소값 출력됨
		System.out.println("길이: " + list.size());
		
		// Person 타입 삭제
		// 검색 후 삭제
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 이름: ");
		String delName = sc.nextLine();
		
		// ArrayList에서 반복하며 찾기
		for(int i = 0; i < list.size(); i++) {
			// 만약 list.get(i)로만 작성하면 주소값으로만 검색하게 됨
			if(list.get(i).getName().equals(delName)) {
				list.remove(i);
				System.out.println("삭제가 완료되었습니다.");
			}
		}
		for(int i = 0; i < list.size(); i++) {
			list.get(i).info();
			System.out.println();
		}
	}
	
	

}
