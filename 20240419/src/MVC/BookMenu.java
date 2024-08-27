package MVC;

import java.util.Arrays;
import java.util.Scanner;

// View를 담당하는 클래스
public class BookMenu {
	private Scanner sc = new Scanner(System.in);

	// 프로그램의 처리를 하는 BookController 클래스 생성
	private BookController bc = new BookController(); // BookMenu에서 받은 book 객체를 BookController에서 처리할 수 있게 됨

	public void mainMenu() {
		while (true) {
			System.out.println("=====^^^^  메인 메뉴  ^^^^=====");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			int menuNum = sc.nextInt();

			if (menuNum == 1) {
				insertBook();
			} else if (menuNum == 2) {
				selectList();
			} else if (menuNum == 3) {
				searchBook();
			} else if (menuNum == 4) {
				deleteBook();
			} else if (menuNum == 5) {
				ascBook();
			} else if (menuNum == 9) {
				System.out.println("프로그램을 종료합니다.");
				return;
			} else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
		}
	}

	public void insertBook() {
		sc.nextLine();
		System.out.print("도서명 : ");
		String newName = sc.nextLine();
		System.out.print("저자명 : ");
		String newAuthor = sc.nextLine();
		System.out.print("장르(1. 인문 / 2. 과학 / 3. 외국어 / 4. 기타) : ");
		String newCategory = sc.nextLine();
		System.out.print("가격 : ");
		int newPrice = sc.nextInt();
		Book book = new Book(newName, newAuthor, newCategory, newPrice);
		boolean result = bc.insert(book);
		if (result) {
			System.out.println("정상 저장되었습니다.");
		} else {
			System.out.println("공간이 꽉 차서 저장이 되지 않았습니다.");
		}
	}

	public void selectList() {
		System.out.println("===== 도서 전체 조회 =====");
		Book[] bookList = bc.getSelectList();
		int count = bc.getCount();
		for(int i = 0; i < count; i++) {
			bookList[i].print();
		}
	}

	public void searchBook() {
		sc.nextLine();
		System.out.println("===== 도서 검색 =====");
		System.out.print("검색 키워드 : ");
		String keyword = sc.nextLine();
		bc.searchBook(keyword);
	}

	public void deleteBook() {
		sc.nextLine();
		System.out.println("===== 도서 삭제 =====");
		System.out.print("삭제할 도서명: ");
		String title = sc.nextLine();
		System.out.println("삭제할 저자명: ");
		String author = sc.nextLine();
	}

	public void ascBook() {
	}

}
