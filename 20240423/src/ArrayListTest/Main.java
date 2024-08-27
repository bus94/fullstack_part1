package ArrayListTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// 저장을 위한 컨트롤러 객체 생성
	// 지역변수로 활용해도 되지만, main에서 함수 활용을 할거면 전역변수로 해둬야 활용 용이
	public static ShoppingController sc = new ShoppingController();
	public static Scanner scan = new Scanner(System.in);
	public static String loginEmail = null;
	// 로그인 되었다는 것을 알 수 있는 전역변수를 선언하여 null값이면 로그인x, 값이 있다면 로그인o!

	/*
	 * <내생각> 위의 내용을 활용한다면 조회를 아무나 하지 못하도록 코드를 짜볼 수 있어보인다. 정보 권한자 Email을 설정 (ex.
	 * String adminEmail) adminEmail != null 이라면 관리자 로그인o → 이후 조회 누르면 조회가능하도록 설정,
	 * 아니라면 "권한이 없습니다." 출력하면 될 것으로 보인다.
	 * 
	 */

	public static void main(String[] args) {

		/*
		 * 회원의 정보를 저장하는 클래스 장바구니 기능을 추가하는 클래스
		 * 
		 */

		while (true) {
			System.out.println("===== 쌍용쇼핑몰 =====");
			System.out.println("     1. 로그인");
			System.out.println("     2. 로그아웃");
			System.out.println("     3. 회원가입");
			System.out.println("     4. 조회");
			System.out.println("     0. 종료");
			System.out.print("메뉴: ");
			int sel = scan.nextInt();
			scan.nextLine();

			if (sel == 1) {
				/*
				 * 로그인시 쇼핑 물건 구매할 수 있는 메뉴
				 * 
				 * 1. 물품 구매: 옷, 음식, 그외 준비중.. 2. 장바구니: 장바구니 안의 물건 출력, 물품 삭제, 수량 변경 0. 메뉴로 돌아가기
				 * 
				 */
				boolean checkLogin = true;
				while (checkLogin) {
					if (sc.getList().size() == 0) {
						System.out.println("회원가입이 필요합니다.");
						continue;
					}
					System.out.print("이메일: ");
					String searchEmail = scan.nextLine();
					System.out.print("비밀번호: ");
					String searchPass = scan.nextLine();
					sc.login(searchEmail, searchPass);
					checkLogin = !checkLogin;
					if (!checkLogin) {
						break;
					}
				}

			} else if (sel == 2) {
				/*
				 * 로그아웃 만약 로그인이 되어있지 않다면 "로그인을 하세요!" 출력 만약 로그인이 되어있다면 "로그아웃 되었습니다." 출력
				 * 
				 */
				if (loginEmail != null) {
					System.out.println("로그아웃 되었습니다.");
					loginEmail = null;
				} else {
					System.out.println("로그인 하세요.");
					continue;
				}

			} else if (sel == 3) {
				/*
				 * 1. 회원가입시 회원가입에 대한 내용을 입력받고 ArrayList에 저장 2. 이메일을 입력받고 이메일이 중복인지 확인하는 내용 출력 3.
				 * ArrayList 정렬(선택or버블) → 이메일을 기준으로
				 * 
				 */

				boolean check = false;
				String newEmail = "";

				while (!check) {
					System.out.print("회원가입 이메일: ");
					newEmail = scan.nextLine();

					if (sc.checkEmail(newEmail)) {
						System.out.println("이미 같은 이메일 주소가 있습니다. 이메일을 다시 입력해주세요.");
						continue;
					} else {
						check = !check;
					}
				}

				System.out.print("회원가입 비밀번호: ");
				String newPass = scan.nextLine();
				System.out.print("회원가입 이름: ");
				String newName = scan.nextLine();
				System.out.print("핸드폰 번호: ");
				String newPhone = scan.nextLine();

				sc.setAdd(newEmail, newPass, newName, newPhone);
				System.out.println("회원 가입이 정상적으로 완료되었습니다. 감사합니다!");

			} else if (sel == 4) {
				ArrayList<Member> list = sc.getList();
				for (int i = 0; i < list.size(); i++) {
					String r = list.get(i).toString(); // private 으로 ArrayList<Member> list는 접근 제어 되어있기 때문에 get()이용하는 것
					// list.get(0) → 첫 번째 객체(회원) 정보를 출력하게 된다
					System.out.println(r);
				}
				System.out.println("가입한 총 회원의 수는 " + list.size() + "명 입니다.");

			} else if (sel == 0) {
				break;

			} else {
				System.out.println("메뉴를 다시 입력해주세요.");
			}

		}

	}

}
