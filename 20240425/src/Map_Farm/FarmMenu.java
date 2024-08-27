package Map_Farm;

import java.util.Scanner;

public class FarmMenu {
	Scanner sc = new Scanner(System.in);
	FarmController fc = new FarmController();

	void mainMenu() {
		while (true) {
			System.out.println("========== 쌍용 마트 ==========");
			System.out.println("=====***** 메인 메뉴 *****=====");
			System.out.println("1. 직원 메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료");
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			int sel = sc.nextInt();

			if (sel == 1) {
				adminMenu();
			} else if (sel == 2) {
				customerMenu();
			} else if (sel == 3) {
				System.out.println("프로그램 종료.");
				return;
			} else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}

	}

	void adminMenu() {
		System.out.println("=====***** 직원 메뉴 *****=====");
		System.out.println("1. 새 농산물 추가");
		System.out.println("2. 종류 삭제");
		System.out.println("3. 수량 수정");
		System.out.println("4. 농산물 목록");
		System.out.println("9. 메인으로 돌아가기");
		System.out.println();
		System.out.print(" 메뉴 번호 입력 : ");
		int sel1 = sc.nextInt();

		if (sel1 == 1) {
			addNewKind();
		} else if (sel1 == 2) {
			removeKind();
		} else if (sel1 == 3) {
			changeAmount();
		} else if (sel1 == 4) {
			printFarm();
		} else if (sel1 == 9) {
			mainMenu();
		} else {
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
		}

	}

	void customerMenu() {
		System.out.println("현재 쌍용마트 농산물 수량");
		printFarm();
		
		System.out.println("=====***** 고객 메뉴 *****=====");
		System.out.println("1. 농산물 사기");
		System.out.println("2. 농산물 빼기");
		System.out.println("3. 구입한 농산물 보기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.println();
		System.out.print("메뉴 번호 선택 : ");
		int sel2 = sc.nextInt();
		
		if(sel2 == 1) {
			buyFarm();
		} else if (sel2 == 2) {
			removeFarm();
		} else if (sel2 == 3) {
			printBuyFarm();
		} else if (sel2 == 9) {
			mainMenu();
		} else {
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
		}
	}

	void addNewKind() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("추가할 종류 번호 : ");
		int addFNum = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 : ");
		String addName = sc.nextLine();
		System.out.print("수량 : ");
		int addCount = sc.nextInt();
		

		if (addFNum == 1) {
			Fruit f = new Fruit("과일", addName);
			// 만약 fc.addNewKind()이 return 으로 참이 나오면 추가 성공 출력
			if(fc.addNewKind(f, addCount)) {
				System.out.println("과일" + addName + " " + addCount +"개를 추가하였습니다.");
				System.out.println("새 농산물이 추가되었습니다.");
				return;
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				return;
			}
		} else if (addFNum == 2) {
			Vegetable f = new Vegetable("채소", addName);
			if(fc.addNewKind(f, addCount)) {
				System.out.println("채소" + addName + " " + addCount +"개를 추가하였습니다.");
				System.out.println("새 농산물이 추가되었습니다.");
				return;
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				return;
			}
		} else if (addFNum == 2) {
			Nut f = new Nut("견과", addName);
			if(fc.addNewKind(f, addCount)) {
				System.out.println("견과" + addName + " " + addCount +"개를 추가하였습니다.");
				System.out.println("새 농산물이 추가되었습니다.");
				return;
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				return;
			}
		} else {
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
		}
	}

	void removeKind() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("삭제할 종류 번호 : ");
		int addFNum = sc.nextInt();
		sc.nextLine();
		System.out.print("삭제할 농산물의 이름 : ");
		String addName = sc.nextLine();
		System.out.print("수량 : ");
		int addCount = sc.nextInt();
	}

	void changeAmount() {

	}

	void printFarm() {

	}

	void buyFarm() {

	}

	void removeFarm() {

	}

	void printBuyFarm() {

	}

}
