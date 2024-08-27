package MusicTest;

import java.util.ArrayList;
import java.util.Scanner;

public class MusicView {

	Scanner sc = new Scanner(System.in);
	MusicController mc = new MusicController();
	public int count = 0;

	public void mainMenu() {
		while (true) {
			System.out.println("=====***** 메인 메뉴 *****=====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 곡 명 오름차순 정렬");
			System.out.println("8. 가수 명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.println();
			System.out.print("메뉴 번호 입력: ");
			int menu = sc.nextInt();

			sc.nextLine(); // 버퍼
			if (menu == 1) {
				addList();
			} else if (menu == 2) {
				addAtZero();
			} else if (menu == 3) {
				printAll();
			} else if (menu == 4) {

			} else if (menu == 5) {

			} else if (menu == 6) {

			} else if (menu == 7) {
				
			} else if (menu == 8) {

			} else if (menu == 9) {
				System.out.println("프로그램 종료");
				return;
			} else {
				System.out.println("메뉴 번호를 다시 입력해주세요.");
			}
		}
	}

	public void addList() {
		// 곡 명과 가수 명 입력 받기
		// mc에 addList() 입력한 정보 넘기고
		// 추가 성공 시 추가 성공 등의 출력
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명: ");
		String addTitle = sc.nextLine();
		System.out.print("가수 명: ");
		String addSinger = sc.nextLine();

		Music addMusic = new Music(addTitle, addSinger);

		boolean check = false;
		for (int i = 0; i < count; i++) {
			if (addMusic.equals(mc.getList().get(i))) {
				System.out.println("! 추가 실패 !");
				check = true;
				break;
			}
		}
		if(!check) {
			mc.addList(new Music(addTitle, addSinger));
			System.out.println("! 추가 성공 !");
		}
		count++;
		System.out.println("총 " + count + "곡 저장되어있습니다.");
	}

	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명: ");
		String addTitle = sc.nextLine();
		System.out.print("가수 명: ");
		String addSinger = sc.nextLine();

		Music addMusic = new Music(addTitle, addSinger);
		mc.getList().add(0, addMusic);
		count++;
		System.out.println("총 " + count + "곡 저장되어있습니다.");
	}

	public void printAll() {
		for(Music temp : mc.getList()) {
			System.out.println(temp);
		}
		System.out.println("총 " + count + "곡 저장되어있습니다.");
	}

	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ******");
		System.out.print("수정할 곡명: ");
		String find = sc.nextLine();

		for (int i = 0; i < mc.getList().size(); i++) {
			if (mc.getList().get(i).getTitle().equals(find)) {
				System.out.println("새로 수정할 곡명, 가수명: ");
				String title = sc.nextLine();
				String singer = sc.nextLine();

				// 기존 객체 남기고, 그 안의 내용만 변경!
//				mc.getList().get(i).setTitle(title);
//				mc.getList().get(i).setSinger(singer);

				// 기존 객체를 남길 필요없으니, 새로운 객체 만들어서 수정
				mc.getList().set(i, new Music(title, singer));
			} else {
				System.out.println("검색한 곡이 없습니다.");
			}
		}
	}

	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명: ");
		String find = sc.nextLine();

		boolean check = false;

		for (int i = 0; i < count; i++) {
			if (mc.getList().get(i).getTitle().equals(find)) {
				System.out.println("찾았다!");
				System.out.println(mc.getList().get(i).getSinger() + " " + mc.getList().get(i).getTitle());
				check = true;
				break;
			}
		}
		if (check == false) {
			System.out.println("검색한 곡이 없습니다.");
		}

	}
	
	// 곡 명 오름차순 정렬
	public void descTitle() {
		
	}
	
	// 가수명 내림차순 정렬
	public void ascSinger() {
		
	}
	
}
