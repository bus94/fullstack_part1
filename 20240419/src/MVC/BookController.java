package MVC;

import java.util.ArrayList;
import java.util.Arrays;

// 데이터 저장, 찾기, 수정, 삭제, 조회
// 	처리를 하는 클래스
public class BookController {
	private Book[] bookList = new Book[20];
	// 책 권수를 저장하는 count 변수 필요
	// count로 배열의 인덱스로도 사용
	private int count = 0;

	// 저장하고 count++만 적용되는 함수이기 때문에 boolean 타입으로 리턴값 정하고 확인만 하기
	boolean insert(Book book) {
		boolean result = false;
		if (count < bookList.length) {
			bookList[count++] = book; // 비어있는 인덱스에 책 1권 저장
			// 책이 1권 늘기 때문에 count++
			System.out.println("책이 총 " + count + "권 저장되어있습니다.");
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	public int getCount() {
		return count;
	}
	
	public Book[] getSelectList() {
		return bookList;
	}
	
	public void searchBook(String keyword) {
		Book[] searchList = new Book[getCount()];
		
		for(int i = 0; i < getCount(); i++) {
			if(bookList[i].getTitle().contains(keyword)) {
				int j = 0;
				searchList[j] = bookList[i];
				searchList[j++].print();
			}else {
				System.out.println("검색 결과가 없습니다.");
				return;
			}
		}
		
	}
	
//	public Book deleteBook(String title, String author) {
//		Book[] removeBook = new Book[getCount()];
//	}
//	
//	public int ascBook() {
//		
//	}
}
