package Book_Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Book_Page.AdminLoginDialog;
import Book_Page.AdminPage;
import Book_Page.CartAddItemPage;

public class MainWindow extends JFrame {

	static JPanel mMenuPanel, mPagePanel;
	static Font ft = new Font("함초롬돋움", Font.BOLD, 15);

	public MainWindow(String title, int x, int y, int width, int height) {

//		setIconImage(new ImageIcon("./images/shop.png").getImage());

		initContainer(title, x, y, width, height);
		initMenu();

		setVisible(true);
		setIconImage(new ImageIcon("./images/shop.png").getImage());
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initMenu() {
		// 1. 메뉴바 생성
		JMenuBar menuBar = new JMenuBar();

		// 2. 메뉴 생성
		JMenu menu01 = new JMenu("고객");
		JMenu menu02 = new JMenu("상품");
		JMenu menu03 = new JMenu("장바구니");
		JMenu menu04 = new JMenu("주문");

		menuBar.add(menu01);
		menuBar.add(menu02);
		menuBar.add(menu03);
		menuBar.add(menu04);

		// 3. 하위 메뉴 생성 & 4. 메뉴에 추가
		// 1) 고객 메뉴
		JMenuItem item01 = new JMenuItem("고객정보");
		JMenuItem item02 = new JMenuItem("종료");
		menu01.add(item01);
		menu01.add(item02);

		// 2) 상품 메뉴
		JMenuItem item03 = new JMenuItem("상품목록보기");
		menu02.add(item03);

		// 3) 장바구니 메뉴
		JMenuItem item04 = new JMenuItem("항목 추가");
		JMenuItem item05 = new JMenuItem("항목 수량 줄이기");
		JMenuItem item06 = new JMenuItem("항목 삭제");
		JMenuItem item07 = new JMenuItem("장바구니 비우기");
		menu03.add(item04);
		menu03.add(item05);
		menu03.add(item06);
		menu03.add(item07);

		// 4) 주문 메뉴
		JMenuItem item08 = new JMenuItem("영수증 표시");
		menu04.add(item08);

		// 5. 윈도우 메뉴를 수정
		setJMenuBar(menuBar);
	}

	private void initContainer(String title, int x, int y, int width, int height) {
		setTitle(title);
		setLayout(null);
		setBounds(x, y, width, height);

		// 실질적으로 공유할 static 객체들을 생성
		mMenuPanel = new JPanel();
		mPagePanel = new JPanel();
//		mMenuPanel.setBounds(0, 20, 900, 100);
		mMenuPanel.setBounds(0, 0, 1000, 80);
		mPagePanel.setBounds(0, 100, 1000, 700);

		// menuBtn 버튼들만 만들고 이벤트 설정하는 메서드 생성하기
		menuBtn();
		add(mMenuPanel);
		add(mPagePanel);
//		ex();
	}

	private void menuBtn() {
		// 폰트는 static으로 셋팅해서 적용하기
//		JButton btn1 = new JButton("고객 정보 확인하기", new ImageIcon("./images/1.png"));
//		JButton btn2 = new JButton("장바구니 상품목록보기", new ImageIcon("./images/2.png"));
//		JButton btn3 = new JButton("장바구니 비우기", new ImageIcon("./images/3.png"));
//		JButton btn4 = new JButton("장바구니에 항목추가하기", new ImageIcon("./images/4.png"));
//		JButton btn5 = new JButton("장바구니에 항목수량 줄이기", new ImageIcon("./images/5.png"));
//		JButton btn6 = new JButton("장바구니에 항목삭제하기", new ImageIcon("./images/6.png"));
//		JButton btn7 = new JButton("주문하기", new ImageIcon("./images/7.png"));
//		JButton btn8 = new JButton("종료", new ImageIcon("./images/8.png"));
//		JButton btn9 = new JButton("관리자", new ImageIcon("./images/9.png"));

		// 메인 메뉴 1번째 줄 판넬
//		JPanel j1Pan = new JPanel();
//		JPanel j2Pan = new JPanel();

		JButton btn01 = new JButton("고객 정보 확인하기", new ImageIcon("./images/1.png"));
		btn01.setBounds(0, 0, 100, 50);
		btn01.setFont(ft);
		mMenuPanel.add(btn01);
//		j1Pan.add(btn01);
		// 익명클래스를 이용해서 (이름이 없는 클래스)
		// 딱! 한번만 실행이 가능하다. (일회용)
		btn01.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 기존에 보여주는 패널은 지운다.
				mPagePanel.removeAll();
				// 그리고 현재 버튼이 눌린 화면을 보여주기 위해서
				// 고객 정보를 출력하는 클래스를 만들어서 내용을 출력한다.
				mPagePanel.add("고객 정보 확인", new GuestInfoPage(mPagePanel));
				// 구성 요소 가로/세로 속성 변경하여 호출
				mPagePanel.revalidate();
				// 현재 재배치한 내용으로 보이기
				mPagePanel.repaint();
			}
		});
		JButton btn02 = new JButton("장바구니 상품 목록보기", new ImageIcon("./images/2.png"));
		
		btn02.setBounds(0, 0, 100, 50);
		btn02.setFont(ft);
		mMenuPanel.add(btn02);
		
		btn02.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
			
		JButton btn03 = new JButton("장바구니 비우기", new ImageIcon("./images/3.png"));
		btn03.setBounds(0, 0, 100, 50);
		btn03.setFont(ft);
		mMenuPanel.add(btn03);
		
		btn03.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton btn04 = new JButton("장바구니에 항목 추가하기", new ImageIcon("./images/4.png"));
		btn04.setBounds(0, 0, 100, 50);
		btn04.setFont(ft);
		mMenuPanel.add(btn04);
		
		btn04.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mPagePanel.removeAll();
				mPagePanel.add("장바구니에 항목 추가하기", new CartAddItemPage(mPagePanel));
				mPagePanel.revalidate();
				mPagePanel.repaint();
			}
		});
		
		JButton btn05 = new JButton("장바구니에 항목수량 줄이기", new ImageIcon("./images/5.png"));
		btn05.setBounds(0, 0, 100, 50);
		btn05.setFont(ft);
		mMenuPanel.add(btn05);
		btn05.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton btn06 = new JButton("장바구니에 항목 삭제하기", new ImageIcon("./images/6.png"));
		btn06.setBounds(0, 0, 100, 50);
		btn06.setFont(ft);
		mMenuPanel.add(btn06);
		
		btn06.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton btn07 = new JButton("주문하기", new ImageIcon("./images/7.png"));
		btn07.setBounds(0, 0, 100, 50);
		btn07.setFont(ft);
		mMenuPanel.add(btn07);
		
		btn07.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton btn08 = new JButton("종료", new ImageIcon("./images/8.png"));
		btn08.setBounds(0, 0, 100, 50);
		btn08.setFont(ft);
		mMenuPanel.add(btn08);
		
		btn08.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton btn09 = new JButton("관리자", new ImageIcon("./images/9.png"));
		btn09.setBounds(0, 0, 100, 50);
		btn09.setFont(ft);
		mMenuPanel.add(btn09);
		
		btn09.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminLoginDialog admin;
				JFrame frame = new JFrame();
				admin = new AdminLoginDialog(frame, "관리자 로그인");
				admin.setVisible(true);
				
				// 로그인이 되면 AdminPage(관리자 페이지) 보이기
				// 로그인 정보를 저장하는 변수 static 
				if(admin.isLogin) {
					mPagePanel.removeAll();
					mPagePanel.add("관리자", new AdminPage(mPagePanel));
					mPagePanel.revalidate();
					mPagePanel.repaint();
				}
			}
		});
		JButton btn10 = new JButton("1:1 대화");
		btn10.setBounds(0, 0, 100, 50);
		btn10.setFont(ft);
		mMenuPanel.add(btn10);
		
		btn08.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
//		JButton btn02 = new JButton("장바구니 상품목록보기", new ImageIcon("./images/2.png"));
//		j1Pan.add(btn02);
//		JButton btn03 = new JButton("장바구니 비우기", new ImageIcon("./images/3.png"));
//		j1Pan.add(btn03);
//		JButton btn04 = new JButton("장바구니에 항목추가하기", new ImageIcon("./images/4.png"));
//		j1Pan.add(btn04);
//		
//		// 메인 메뉴 2번째 줄
//		JButton btn05 = new JButton("장바구니에 항목수량 줄이기", new ImageIcon("./images/5.png"));
//		j2Pan.add(btn05);
//		JButton btn06 = new JButton("장바구니에 항목삭제하기", new ImageIcon("./images/6.png"));
//		j2Pan.add(btn06);
//		JButton btn07 = new JButton("주문하기", new ImageIcon("./images/7.png"));
//		j2Pan.add(btn07);
//		JButton btn08 = new JButton("종료", new ImageIcon("./images/8.png"));
//		j2Pan.add(btn08);
//		JButton btn09 = new JButton("관리자", new ImageIcon("./images/9.png"));
//		j2Pan.add(btn09);
//		
//		mMenuPanel.add(j1Pan);
//		mMenuPanel.add(j2Pan);
//		
		
	}

	// 배열 이용한 참고용 (관건: 배열을 만든 후 각각의 객체들의 이벤트 발생 시 적용하는 것을 고민해야함!!)
	private void ex() {
		mMenuPanel = new JPanel();
		mMenuPanel.setBounds(100, 0, 800, 80);

		// 버튼에 사용될 아이콘들의 경로
		String[] iconPaths = { "./images/1.png", "./images/2.png", "./images/3.png", "./images/4.png", "./images/5.png",
				"./images/6.png", "./images/7.png", "./images/8.png", "./images/9.png" };

		// 버튼에 사용될 텍스트들
		String[] buttonTexts = { "고객 정보 확인하기", "장바구니 상품 목록보기", "장바구니 비우기", "장바구니에 항목 추가하기", "장바구니에 항목수량 줄이기",
				"장바구니에 항목 삭제하기", "주문하기", "종료", "관리자" };

		JButton[] btnList = new JButton[9];
		for (int i = 0; i < btnList.length; i++) {
			btnList[i] = new JButton(buttonTexts[i], new ImageIcon(iconPaths[i]));
//			btnList[i].setBounds(10 + i * 110, 10, 100, 50);
			mMenuPanel.add(btnList[i]);

			// 각각의 버튼을 클릭했을 때 이벤트까지 추가해야한다.
			btnList[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 각 버튼에 대한 동작을 여기에 구현
					String buttonText = ((JButton) e.getSource()).getText();
					switch (buttonText) {
					case "고객 정보 확인하기":
						// 고객 정보 확인하기 버튼 동작 구현
						break;
					case "장바구니 상품 목록보기":
						// 장바구니 상품 목록보기 버튼 동작 구현
						break;
					case "장바구니 비우기":
						// 장바구니 비우기 버튼 동작 구현
						break;
					// 나머지 버튼에 대한 동작 구현
					}
				}

			});
			add(mMenuPanel);
		}
	}
}
