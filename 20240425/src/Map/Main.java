package Map;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//		// Map 인터페이스
//		// - 키와 값으로 데이터를 저장
//		// - 연락처, 사전, 카카오톡 프로필명
//		// - 배열이나 list계열은 숫자로 방 번호가 자동으로 부여
//		// - 공간의 이름을 마음대로 문자로 사용하고 싶을 때 Map 사용
//		// - 배열의 공간의 번호 = Map의 key
//		//   배열의 값 = value
//		// - 순서가 없다는 것은 인덱스가 없다는 것
//		//   순서대로 데이터에 접근을 할 수 없다 (순서가 유지되지 않는다)
//		
//		// Map 2가지 종류
//		// 1. HashMap (정렬X)
//		// 2. TreeMap (정렬O)
//		
//		// key는 중복되면 안된다
//		// value는 중복으로 저장 할 수 있다
//		// key를 중복적으로 작성할 수 있는데, Map에 key가 존재한다면 기존 데이터를 수정하게 된다
//		
//		// Map의 공간을 먼저 생성 (ArrayList처럼)
//		// <타입> 기본 자료형으로 타입명을 사용해선 안된다
//		// 기본 자료형을 객체화 시켜주는 래퍼 클래스
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		
//		// HashMap - 순서가 없다
//		map.put("Java", 100);
//		map.put("Python", 100);
//		map.put("Spring", 95);
//		map.put("Java", 80); // key가 중복되면 기존 데이터를 가장 최근 데이터로 수정한다
//		// But. 기존 key가 없다면 put을 이용해서 새로운 데이터가 추가된다
//		
//		// 출력
//		System.out.println(map);
//		
//		// 조회 (데이터 가져오기)
//		// get(key) : value (key의 값)
//		// 데이터 있으면 value, 없으면 null로 반환
//		System.out.println(map.get("Java"));
//		System.out.println(map.get("python")); 
//		// key는 대,소문자를 구분한다
//		
//		// 삭제
//		map.remove("Python");
//		System.out.println(map);
//		
//		// 전체 조회 (검색)
//		// for문을 사용할 때 여러 개를 저장하는 타입을 적어준다
//		// 그 타입의 key를 기준으로 하나씩 꺼내오는 개념으로 코드 작성해준다
//		// map.keySet() : key만 뽑아갈 수 있다
//		for(String key : map.keySet()) {
//			System.out.println("key: " + key);
//			System.out.println("value: " + map.get(key));
//			System.out.println();
//		}
//		
//		System.out.println("map size: " + map.size());
//		
//		// key값이 존재하는지 여부
//		// containsKey()
//		// key값이 있으면  true, 없으면 false
//		String searchKey = "Java";
//		if(map.containsKey(searchKey)) {
//			System.out.println("존재함");
//		}else {
//			System.out.println("존재안함");
//		}
//		
//		// 값이 (value) 객체가 있는지 확인
//		Integer searchValue = 80; // 객체 타입으로 해야한다
//		if(map.containsValue(searchValue)) {
//			System.out.println("값이 존재함");
//		}else {
//			System.out.println("값이 존재안함");
//		}

		// map으로 Member들을 저장
		// key id값을 이용해서 저장
		// value  Member 객체 저장
		HashMap<String, Member> map = new HashMap<String, Member>();

		// 저장
		map.put("qwer", new Member("qwer", "qwer")); // 1234
		map.put("asdf", new Member("asdf", "asdf"));
		map.put("poiu", new Member("poiu", "poiu"));
		map.put("zxcv", new Member("zxcv", "zxcv"));

//		System.out.println(map);
//		
//		// 객체 자체를 삭제하는 것이 아니라 map의 공간을 삭제하는 것!
//		map.remove("poiu");
//		System.out.println(map);
//		
//		// 전체 지우기
//		map.clear();
//		System.out.println(map);

		Scanner sc = new Scanner(System.in);
		String loginCheck = null;

		while (true) {
			System.out.println("1. 로그인");
			System.out.println("2. 로그아웃");
			System.out.println("3. 종료");
			System.out.print("메뉴 : ");
			int sel = sc.nextInt();
			sc.nextLine();

			if (sel == 1) {
				boolean check = false;
				while (!check) {
					System.out.print("id: ");
					String id = sc.nextLine();
					System.out.print("pw: ");
					String pw = sc.nextLine();

					// 1. key containskey
					// 2. id 기준으로 true 나오면 map에서 get key - 객체에서의 getid getpw 
					if(map.containsKey(id)) {
						if(map.get(id).getId().equals(id) && map.get(pw).getPw().equals(pw)) {
							System.out.println("로그인이 확인되었습니다!");
							loginCheck = "a";
							check = true;
							continue;
						}
					}else {
						System.out.println("입력하신 id 또는 pw가 틀렸습니다. 다시 로그인해주세요.");
						System.out.println("1. 이전 메뉴로 돌아가기");
						System.out.println("2. 로그인 계속하기");
						System.out.print("메뉴: ");
						int sel1 = sc.nextInt();
						if(sel1 == 1) {
							break;
						}else if(sel == 2) {
							continue;
						}
						sc.nextLine();
					}
					
					// 처음 작성했던 코드 (위의 코드가 강사님 설명해주시고 힌트 주신 뒤 작성한 코드)
//					Member login = new Member(id, pw);
//					if (map.containsValue(login)) {
//						loginCheck = "a";
//						check = true;
//						continue;
//					} else {
//						System.out.println("입력하신 id 또는 pw가 틀렸습니다. 다시 로그인해주세요.");
//						System.out.println("1. 이전 메뉴로 돌아가기");
//						System.out.println("2. 로그인 계속하기");
//						System.out.print("메뉴: ");
//						int sel1 = sc.nextInt();
//						if(sel1 == 1) {
//							break;
//						}else if(sel == 2) {
//							continue;
//						}
//						sc.nextLine();
//					}
				}

			}else if(sel == 2) {
				if(loginCheck == null) {
					System.out.println("로그인을 해주세요.");
					continue;
				}else {
					System.out.println("로그아웃 되었습니다!");
					loginCheck = null;
					continue;
				}
			}else if(sel == 3) {
				System.out.println("프로그램을 종료!");
				return;
			}

		}

	}

}
