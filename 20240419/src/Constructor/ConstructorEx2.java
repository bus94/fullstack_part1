package Constructor;

import java.util.Arrays;
import java.util.Scanner;

class A{
	
	// 생성자의 특징
	// 1) 반환 타입 없다 2) 반드시 클래스 이름하고 같아야 한다
	// 기본 생성자 생성 가능 (아래와 같이)
	A(){}
}

class Song{
	String name;
	String singer;
	
	// 생성자를 만들어 놓으면 기본 생성자가 생기지 않기 때문에 기본 생성자를 만들기 위해선(메모리만 생성하려면) 기본 생성자를 따로 저장한다
	Song(){}
	Song(String n, String s){
		name = n;
		singer = s;
	}
}

public class ConstructorEx2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 아래의 코드는 기본 생성자가 아닌 변수가 저장된 생성자로 저장하는 경우이다
		// 입력한 값을 바로 저장하려면 기본 생성자로는 저장할 수가 없기 때문에 클래스 내에 변수를 가진 생성자를 만들어야 한다
		Song s1 = new Song("별헤는 밤", "유재하");
		System.out.println(s1.name);
		
		// 기본 생성자로 생성한 객체
		Song s2 = new Song();
		
		
		System.out.print("노래제목: ");
		s2.name = sc.nextLine();
		System.out.print("가수이름: ");
		s2.singer = sc.nextLine();
		
		Song[] list = new Song[5];
		list[0] = s1;
		list[1] = s2;
		
		System.out.println(Arrays.toString(list));
		
		
	}

}
