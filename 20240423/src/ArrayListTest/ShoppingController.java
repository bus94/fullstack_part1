package ArrayListTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

// 멤버들을 관리하는 저장하는 객체를 생성
// 물건을 추가, 삭제, 변경하거나 멤버들의 정보를 추가, 삭제하는 실제 저장소!
public class ShoppingController {

	private ArrayList<Member> list = new ArrayList<Member>();
	public static Scanner scan = new Scanner(System.in);
	public static Main m = new Main();

	public static void menu() {
		while (true) {
			System.out.println("== **님 로그인 중.. ==");
			System.out.println("1. 물품 구매");
			System.out.println("2. 장바구니");
			System.out.println("0. 메뉴로 돌아가기");
			System.out.print("메뉴: ");
			int menu = scan.nextInt();

			if (menu == 1) {
				while (true) {
					System.out.println("=== 옷 상품 ===");
					System.out.println("1. 옷");
					System.out.println("2. 음식");
					System.out.println("0. 이전 메뉴로 돌아가기");
					System.out.print("메뉴: ");
					int choose = scan.nextInt();
					scan.nextLine();

					if (choose == 1) {
						ArrayList<Product> ClothesProductList = new ArrayList<Product>();

						System.out.print("상품명: ");
						String ClothesProduct = scan.nextLine();
						System.out.print("상품가격: ");
						int ClothesPrice = scan.nextInt();
						scan.nextLine();
						System.out.print("사이즈(S/M/L): ");
						String ClothesSize = scan.nextLine();
						System.out.print("색상(White/Black/Red/Blue): ");
						String ClothesColor = scan.nextLine();

						// LocalDateTime.now() : 현재 날짜를 알려준다
						ClothesProductList.add(new Clothes(ClothesProduct, ClothesPrice, LocalDateTime.now(), 0,
								ClothesSize, ClothesColor));
						System.out.println(ClothesProduct + " 상품(옷) 주문이 완료되었습니다.");
						System.out.println("=== 추가 주문 ===");

					} else if (choose == 2) {
						ArrayList<Product> FoodProductList = new ArrayList<Product>();

						System.out.println("상품명: ");
						String FoodProduct = scan.nextLine();
						System.out.println("상품가격: ");
						int FoodPrice = scan.nextInt();

						FoodProductList.add(new Food(FoodProduct, FoodPrice, LocalDateTime.now(), 0,
								LocalDateTime.now()));
						System.out.println(FoodProduct + " 상품(푸드) 주문이 완료되었습니다.");
						System.out.println("=== 추가 주문 ===");
					} else if (choose == 0) {
						break;
					}
				}
			} else if(menu == 2) { // 장바구니
				
			} else if(menu == 0) {
				break;
			}
		}
	}
	
	// 장바구니 확인하기 위한 메서드
//	public ArrayList<Member> getProductList() {
//	} 

	// 추가할 list에는 private으로 접근제어 되어있기 때문에 set로 작성
	public void setAdd(String newEmail, String newPass, String newName, String newPhone) {
		list.add(new Member(newEmail, newPass, newName, newPhone));
	}

	// 중복 확인 하는 메서드
	public boolean checkEmail(String newEmail) {

		// 중복 체크 하기 위해 호출
		// size() : 회원을 저장한 list 배열의 데이터의 개수 반환 (가입한 회원 수)
		int size = list.size();

		// ArrayList 비어있으면 확인할 필요가 없으므로
		if (size == 0) {
			return false;
		} else {
			// 가입한 회원이 1명 이상 있다면
			for (int i = 0; i < size; i++) {
				// 중복된 경우
				if (list.get(i).getEmail().equals(newEmail)) {
					return true;
				}
			}
		}
		// 중복이 없다는 것을 확인하였으니
		return false;
	}

	// 조회하는 메서드
	public ArrayList<Member> getList() {
		return list;
	}

	// 로그인 메서드
	public void login(String searchEmail, String searchPass) {
		boolean check = false;
		while (!check) {

			for (int i = 0; i < list.size(); i++) {
				String dbEmail = list.get(i).getEmail();
				String dbPass = list.get(i).getPass();
				if (dbEmail.equals(searchEmail) && dbPass.equals(searchPass)) {
					check = !check;
					m.loginEmail = searchEmail; // 로그인 유무를 알 수 있도록 변수 활용
					menu();
				} else {
					System.out.println("이메일 또는 비밀번호가 틀렸습니다. 다시 입력해주세요.");
					break;
				}
			}
			break;
		}
	}
}
