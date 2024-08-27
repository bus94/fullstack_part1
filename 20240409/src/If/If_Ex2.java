package If;

import java.util.Scanner;

public class If_Ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// next() : 한 단어 입력 (공백 허용x)
		// nextLine() : 한 줄 입력 (공백 허용o)
		// 키보드로 입력하는 데이터를 입력 받는 경우 바로 변수에 저장되지 않는다.
		// "버퍼"라는 임시 기억장소에 저장된 후 읽어 들이는 메소드(ex. nextInt, nextDouble)가 실행될 때 변수에 저장된다.
		// nextLine() 메소드 : 키보드 버퍼 비어있다면 입력 기다리며 대기 / 비어있지 않다면 버퍼의 내용을 끝까지 읽어들인다. 
		// → ex. 다른 메소드 이용 시 enter에 대한 데이터를 버퍼에 저장되어있어 비어있지 않다고 인식 - enter는 공백으로 보임
		// 위의 정수, 실수 입력 받고 nextLine() 나오면 입력을 받을 수 있도록 버퍼를 비워야 한다.
		// 버퍼 비우는 방법: sc.nextLine();
		
		System.out.print("나이: ");
		int age = sc.nextInt();
		
		sc.nextLine();
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		System.out.println(age + " " + name);
		
		// 아이디, 비밀번호
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		String dbId = "myId";
		String dbPw = "myPassword12";

		// 주의 사항: 문자를 비교할 때는 == 연산자 불가 / 입력한 문자열의 데이터를 비교하기 위한 equals()를 이용해야한다. 
		// → ∵ 저장 공간이 달라서 안의 데이터끼리 비교하기 위함
		if(id.equals(dbId)) {
			if(pw.equals(dbPw)) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} else {
			System.out.println("아이디가 틀렸습니다.");
		}
	}

}
