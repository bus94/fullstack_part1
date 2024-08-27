package Book_Page;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Book_Item.Book;

/*
 * 장바구니 클래스를 만든다.
 * 클래스 멤버들을 선언하여 어딘가 저장하기
 * Book, BookInfo 참고!
 * 
 */
public class CartItemListPage{
	private static ArrayList<Book> cartList = new ArrayList<Book>();

	public static void add(Book book) {
		cartList.add(book);
	}
	
	public static ArrayList<Book> getmBookList() {
		return cartList;
	}

}
