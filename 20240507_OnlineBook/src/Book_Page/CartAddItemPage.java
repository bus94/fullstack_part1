package Book_Page;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Book_Item.Book;
import Book_Item.BookInfo;

public class CartAddItemPage extends JPanel implements ListSelectionListener {
	ImageIcon imageBook;
	int mSelectRow = 0;
	JTable bookTable;

	public CartAddItemPage() {
	}

	public CartAddItemPage(JPanel panel) {
		Font ft = new Font("함초롬돋움", Font.BOLD, 20);
		setLayout(null);

		Rectangle rect = panel.getBounds();
		setPreferredSize(rect.getSize());

		// 이미지 가져오기
		// 상대경로(현재 프로젝트명을 기준으로 경로 설정)
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(20, 0, 370, 400);

//		// 실제 이미지 가져오기
//		// ImageIcon("경로설정.확장자")
//		imageBook = new ImageIcon("./images/ISBN1234.jpg");
//		// 이미지 아이콘 클래스로 이미지 가져오고,
//		// 띄울 때는 JLabel or JButton을 이용해서 표현하기
		JLabel label = new JLabel(imageBook);
		imagePanel.add(label);
		add(imagePanel);

		// 테이블 생성
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(390, 0, 610, 400);
		add(tablePanel);

		// 열 이름
		Object[] tableHeader = { "도서ID", "도서명", "가격", "저자", "설명", "분야", "출판일" };
		// ArrayList에 데이터 채우기 위해서 init 메서드를 먼저 호출하고 그 다음에 리턴 받으면 하나의 데이터를 저장한 리스트를 받는다.
		BookInfo.init();
		ArrayList<Book> bookList = BookInfo.getmBookList();

		// 하나의 데이터를 가지고 와서 String[]로 변경해서 저장
//		Book temp = bookList.get(0);

		// Object[ArrayList.size()][열 이름의 개수]
		// ArrayList.size() → bookList.size()
		Object[][] content = new Object[3][tableHeader.length];

//		content[0][0] = temp.getBookId();
//		content[0][1] = temp.getBookName();
//		content[0][2] = temp.getBookPrice();
//		content[0][3] = temp.getBookAuthor();
//		content[0][4] = temp.getBookDescription();
//		content[0][5] = temp.getBookCategory();
//		content[0][6] = temp.getBookDate();

		for (int i = 0; i < bookList.size(); i++) {

//			int a = (i + 4);
			Book temp = bookList.get(i);
//			imageBook = new ImageIcon("./images/ISBN123" + a + ".jpg");
//			JLabel label = new JLabel(imageBook);
//			imagePanel.add(label);
//			add(imagePanel);

			content[i][0] = temp.getBookId();
			content[i][1] = temp.getBookName();
			content[i][2] = temp.getBookPrice();
			content[i][3] = temp.getBookAuthor();
			content[i][4] = temp.getBookDescription();
			content[i][5] = temp.getBookCategory();
			content[i][6] = temp.getBookDate();
		}

		bookTable = new JTable(content, tableHeader);

		// 첫 번째 행 선택
		bookTable.setRowSelectionInterval(0, 0);
		// 선택된 열의 인덱스를 반환
		bookTable.getSelectedColumn();

		// 스크롤 추가
		JScrollPane js = new JScrollPane();
		// 스크롤 크기 설정
		js.setPreferredSize(new Dimension(600, 350));
		// 테이블과 스크롤을 연결해서 뷰(화면)에 보이기
		js.setViewportView(bookTable);
		// 테이블 영역에 추가하기
		tablePanel.add(js);

		bookTable.getSelectionModel().addListSelectionListener(this);

		// 버튼 만들기
		JPanel btnPanel = new JPanel();
//		btnPanel.setLayout(new BorderLayout());
		btnPanel.setBounds(0, 400, 1000, 100);

		JButton btn = new JButton("장바구니 담기");
		btn.setFont(ft);
//		btnPanel.add(btn, BorderLayout.EAST);
		btnPanel.add(btn);

		// 테이블을 마우스로 클릭했을 때
		// 인터페이스는 구현하면 무조건 몇 개든 오버라이딩 메서드를 사용해야한다.
		// 인터페이스 구현 시 필요한 메서드만 오버라이딩 할 수 있는 클래스 Adapter의 역할!
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스를 클릭했을 때 이벤트 처리를 하면 된다.
				
				// 행과 열을 각각 선택해서 사용할 수 있도록 변수 선언
				int row = bookTable.getSelectedRow();
				int col = bookTable.getSelectedColumn();
				System.out.println("선택 행: " + row);
				System.out.println("선택 열: " + col);
				
				mSelectRow = row;
				// 테이블 안에 담긴 내용이 어떤 객체(타입인지) 모르기 때문에 모든 객체를 담을 수 있는 Object 타입 사용
				Object value = bookTable.getValueAt(row, 0);
				// 위에서 파일명을 가지고 왔다.
				// Object 타입이라 확장자를 붙여서 문자로 파일명을 만든다.
				String str = value + ".jqp";
				
				// 만든 파일명을 이용해서 경로를 설정한다.
				imageBook = new ImageIcon("./images/" + str);
				
				JLabel label = new JLabel(imageBook);
				
				// 기존에 보이던 이미지는 지운다.
				imagePanel.removeAll();
				imagePanel.add(label);
				imagePanel.revalidate();
				imagePanel.repaint();
			}
		});

		add(btnPanel);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

//		if (!e.getValueIsAdjusting()) {
//			int selectRow = bookTable.getSelectedRow() + 1;
//			
//			if (selectRow != -1) {
//				int readCount1 = bookTable.readCount(selectRow);
//
//				String bookId = bookTable.getValueAt(selectRow, 0).toString();
//				String bookName = bookTable.getValueAt(selectRow, 1).toString();
//				int bookPrice = bookTable.getValueAt(selectRow, 2).toString();
//				String bookAuthor = bookTable.getValueAt(selectRow, 3).toString();
//				String bookDescription = bookTable.getValueAt(selectRow, 4).toString();
//				String bookCategory = bookTable.getValueAt(selectRow, 5).toString();
//				LocalDateTime bookDate = bookTable.getValueAt(selectRow, 6).toString();
//
////				JOptionPane.showMessageDialog(TableController.this, message.toString());
//				// 추가
//				CartItemListPage.add(book);
//			}
//		}
	}

}
