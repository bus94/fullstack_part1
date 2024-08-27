package Map;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {

		HashMap<String, Member> list = new HashMap<String, Member>();

		// 임의의 멤버 5명 추가
		list.put("홍길동", new Member("홍길동", "1234"));
		list.put("이순신", new Member("이순신", "abcd"));
		list.put("김철수", new Vip());
		list.get("김철수").name = "김철수";
		list.get("김철수").password = "qwer";

		list.put("박영희", new Member("박영희", "abcd1234"));
		list.put("정대만", new Vip());
		list.get("정대만").name = "정대만";
		list.get("정대만").password = "1234qewr";

		Scanner sc = new Scanner(System.in);

		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.print("선택 > ");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
		case 1:
			System.out.print("이름: ");
			String name = sc.nextLine();
			System.out.print("새 비밀번호: ");
			String password = sc.nextLine();
			
			if(list.containsKey(name)) {
				list.get(name).password = password;
				System.out.println("비밀번호가 변경되었습니다.");
			} else {
				System.out.println("해당 이름의 멤버가 존재하지 않습니다.");
			}
			break;
			
		case 2:
			System.out.print("현재 이름: ");
			String current = sc.nextLine();
			System.out.print("새 이름: ");
			String newName = sc.nextLine();
			
			if(list.containsKey(current)) {
				// 기존 이름의 멤버
				// remove(key) 삭제한 멤버의 객체를 반환
				Member member = list.remove(current); // 삭제할 멤버를 member에 반환
				// 삭제한 current 키 값을 가진 객체가 member가 그 값을 가지고 있고, 그값에 대한 이름을 수정한다
				// 수정한 member를 다시 새 멤버로 추가한다
				
				// 반환된 객체의 이름을 수정한다
				member.name = newName;
				
				// 새 멤버로 추가한다
				list.put(newName, member);
				
				System.out.println(current + "의 이름이 " + newName + " 으로 변경되었습니다.");
			} else {
				System.out.println("해당 이름의 멤버가 존재하지 않습니다.");
			}
			break;

		default:
			System.out.println("제대로 입력하세요.");
			break;
		}

	}

}
