package Map_Farm;

import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	
	// 직원과 고객의 정보와 농산물에 대한 내용을 저장할 수 있는 저장소
	public static AdMinController ac = new AdMinController();
	public static CustomerController cc = new CustomerController();

	public static void main(String[] args) {

		while (true) {
			System.out.println("========== 쌍용 마트 ==========");
			System.out.println("=====***** 메인 메뉴 *****=====");
			System.out.println("1. 직원 메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료");
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				adminMenu();
				break;

			case 2:
				customerMenu();
				break;

			case 9:
				System.out.println("프로그램 종료");
				break;

			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;

			}

		}
	}

	public static void adminMenu() {
		while (true) {
			System.out.println("=====***** 직원 메뉴 *****=====");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 1:
				String[] list = {"과일", "채소", "견과"};
				
				System.out.println("1. 과일 / 2. 채소 / 3. 견과");
				System.out.print("추가할 종류 번호 : ");
				int addFNum = sc.nextInt();
				
				if(addFNum < 1 || addFNum > 3) {
					continue;
				}
				sc.nextLine();
				System.out.print("이름 : ");
				String addName = sc.nextLine();
				System.out.print("수량 : ");
				int addCount = sc.nextInt();
				
				Farm f = null;
				if(addFNum == 1) {
					f = new Fruit(list[0], addName);
				}else if(addFNum == 2) {
					f = new Vegetable(list[1], addName);
				}else if(addFNum == 3) {
					f = new Nut(list[2], addName);
				}else {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
				// adminController로 넘겨서 저장까지 하는 내용
				if(f != null) {
					// 직원들에 대한 정보를 저장하는 컨트롤러
					ac.addNewKind(f, addCount);
				}else {
					System.out.println("메뉴를 제대로 입력!");
					System.out.println("농작물 저장 안됨!");
				}
				break;

			case 2:
				
				break;

			case 3:
				
				break;

			case 4:
				
				break;

			case 9:
				
				break;

			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;

			}
		}
	}

	public static void customerMenu() {
		// 반복문 중에서 실행문을 먼저 실행하고 조건을 물어보는 반복문
		// do while문
		
		int sel;
		do {
			System.out.println("현재 쌍용마트 농산물 수량");

			System.out.println("=====***** 고객 메뉴 *****=====");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.println();
			System.out.print("메뉴 번호 선택 : ");
			sel = sc.nextInt();
			
			switch (sel) {
			case 1:
				
				break;

			case 2:
				
				break;

			case 3:
				
				break;

			case 9:
				
				break;

			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;

			}
		} while(sel != 9) ;
		
		
		
	}

}
