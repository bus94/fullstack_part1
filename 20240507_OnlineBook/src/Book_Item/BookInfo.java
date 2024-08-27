package Book_Item;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookInfo {
	// 책을 저장하는 공간
	private static ArrayList<Book> mBookList = new ArrayList<Book>();

	public static ArrayList<Book> getmBookList() {
		return mBookList;
	}
	
	public static void init() {
		mBookList.add(new Book("ISBN1234", "쉽게 배우는 JSP 웹프로그래밍", 27000, "송미영", "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍", "IT전문서", LocalDateTime.now()));
		mBookList.add(new Book("ISBN1235", "안드로이드 프로그래밍", 33000, "우재남", "실습 단계별 명쾌한 멘토링!", "IT전문서", LocalDateTime.now()));
		mBookList.add(new Book("ISBN1236", "스크래치", 22000, "고광일", "컴퓨팅 사고력을 키우는 블록 코딩", "컴퓨터입문", LocalDateTime.now()));
	}

	public static void setmBookList(ArrayList<Book> mBookList) {
		BookInfo.mBookList = mBookList;
	}
	
}
