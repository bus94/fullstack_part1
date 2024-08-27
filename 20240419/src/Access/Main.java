package Access;

import AccessTest1.Info;

public class Main {

	public static void main(String[] args) {

		/*
		 * public (전체 공개)
		 * 	- 같거나 다른 폴더 모두 접근이 가능
		 * 	- 모든 폴더에서 해당 클래스에 대한 객체 생성도 가능
		 *  - 클래스 내 변수들 또는 클래스에 접근제어자를 붙일 수 있다.
		 *  - 다른 폴더에서 객체를 생성할 경우에는 폴더의 경로를 포함해야한다. (import 폴더명.클래스명;)
		 *  - 단! public class 클래스명{}
		 *    .java파일명과 클래스명이 똑같아야 된다.
		 *    그래서 하나의 자바파일에서 public class 하나 밖에 작성하지 못한다.
		 * 
		 */
		
		// AccessTest1 폴더 안의 클래스를 가지고 와서 객체(인스턴스) 생성
		Info info1 = new Info();
		info1.age = 10;
		info1.name = "이서희";
		System.out.println(info1.name + " " + info1.age);
		
	}

}
