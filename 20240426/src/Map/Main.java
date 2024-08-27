package Map;

// HashMap 클래스 기능 포함
// Main 내용을 컴파일 하면 서 HashMap 클래스의 기능을 메모리에 로드시켜서 사용할 수 있도록 객체를 생성
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * key와 value를 이용하는 HashMap
		 * 
		 */

		// 1. 공간 생성
		HashMap<String, Member> list = new HashMap<String, Member>();

		Scanner sc = new Scanner(System.in);

		// 2. 회원가입
//		System.out.print("이름, 비밀번호: ");
//		String name = sc.nextLine();
//		String password = sc.nextLine();
//		// 위의 추가적인 방법 (name과 password를 문자열 배열에 저장하고, split으로 구분해서 작성하여 저장할 수 있도록 코드 작성)
//		// String[] info = sc.nextLine().split(",");
//		// 출력할 땐:
//		// System.out.println(info[0]);
//		// System.out.println(info[1]);
//
//		// 3. Map 저장 Value로 저장하기
//		Member mem = new Member(name, password);
//
//		// 4. key를 이용해서 추가
//		list.put(name, mem);
//
//		// 5. Vip 클래스 통해 변수 만들어서 HashMap에 저장
//		// v1 주소를 저장하는 참조변수는 자기 자신 타입만 저장 가능하다
//		Vip v1 = new Vip();
//		System.out.print("vip 이름, 비밀번호: ");
//		String[] info = sc.nextLine().split(",");
//
//		v1.password = info[1];
//
//		// 6. 저장
//		list.put(name, v1);
//
//		// 7. 출력
//		System.out.println("map 사이즈: " + list.size());
//
//		// 업그레이드 된 for문을 이용하여 먼저 key 값들만 뽑아서 반복
//		for (String key : list.keySet()) {
//			System.out.println(key);
//			System.out.println(list.get(key));
//		}
//
//		System.out.println();

		// put으로 임의의 멤버 5명 추가
		// qwer 멤버를 검색해서 비밀번호 변경 또는 이름 변경 중 하나 선택
		// 데이터 수정하는 코드 작성해보기

		
		// 수정 필요함 (강사님 풀이 Main2 참고하기)
		HashMap<String, Member> hList = new HashMap<String, Member>();
		Member m1 = new Member("qwer", "qwer");
		Member m2 = new Member("asdf", "asdf");
		Member m3 = new Member("zxcv", "zcxv");
		Member m4 = new Member("wert", "wert");
		Member m5 = new Member("sdfg", "sdfg");
		hList.put(m1.name, m1);
		hList.put(m2.name, m2);
		hList.put(m3.name, m3);
		hList.put(m4.name, m4);
		hList.put(m5.name, m5);

		while (true) {
			System.out.print("찾는 멤버 이름 검색: ");
			String findName = sc.nextLine();
			
				if (!hList.containsKey(findName)) {
					System.out.println(hList.keySet());
					System.out.println(findName);
					System.out.println("찾는 이름이 없습니다. 다시 입력해주세요.");
					break;
				}else {
					
				}
			
			if (findName.equals(hList.keySet()))
				while (true) {
					System.out.println("1. 비밀번호 변경");
					System.out.println("2. 이름 변경");
					System.out.println("3. 종료");
					int sel = sc.nextInt();

					if (sel == 1) {

					} else if (sel == 2) {

					} else if (sel == 3) {
						return;
					}

				}
		}
	}

}

// 참조변수
// Object는 모든 클래스의 최고 조상
// 업캐스팅이 되면 단점: Object 클래스가 가지고 있는 메서드만 사용한다
//  - 오버라이딩 통해 자식 클래스에서 필요한 메서드를 추가로 사용할 수 있다
//Object obj = new Vip();
//Object obj2 = new Member();
//Object obj3 = sc;
//Object obj4 = list;