package GUI_Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class MyFrame8 extends JFrame {
	JFrame frame = new JFrame();

	MyFrame8() {
		setBounds(0, 0, 300, 300);
		
		// 1. 메뉴바 생성
		JMenuBar menuBar = new JMenuBar();

		// 2. 메뉴를 생성
		JMenu menu01 = new JMenu("File");
		JMenu menu02 = new JMenu("Edit");
		JMenu menu03 = new JMenu("Source");

		// 3. 메뉴바에 추가
		menuBar.add(menu01);
		menuBar.add(menu02);
		menuBar.add(menu03);

		// 4. 메뉴 항목 만들기
		JMenuItem item01 = new JMenuItem("New");
		JMenuItem item02 = new JMenuItem("Open");

		/* New 새로운 창이 뜰 수 있도록 ! 이벤트 */
		item01.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 새로운 창을 생성하고 보이도록 함
				JFrame newFrame = new JFrame("New Window");
				newFrame.setBounds(500, 500, 200, 200);
				newFrame.setVisible(true);
				
			}
		});

		/* Open을 클릭하면 파일을 가져올 수 있는 창 ! 이벤트 */
		item02.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일 다이얼로그 (파일 선택 대화상자) 생성
				JFileChooser fc = new JFileChooser();
				
				// 파일 선택 시 대화상자 열기
				int value = fc.showOpenDialog(null);
				
				System.out.println(value);
				// 창 open이 정상적으로 실행되었다면 0을 반환, 중간에 취소시 1을 반환한다.
				if(value == JFileChooser.APPROVE_OPTION) {
					
					// 선택한 파일 가져오기
					// getSelectedFile() 메서드를 이용해서 파일의 객체를 생성한다.
					
					File selectFile = fc.getSelectedFile();
					System.out.println(selectFile.getAbsolutePath() + " " + selectFile.getName());
				}
				
				// 사용자가 파일을 선택하고 open 버튼을 클릭한 경우
				// 선택한 파일을 가져올 수 있도록 file 객체를 생성해서 저장한다.
			}
		});

		// 5. 파일이라는 메뉴에 항목을 추가하기
		menu01.add(item01);
		menu01.add(item02);

		// 6. 프레임에 메뉴 설정하기
		setJMenuBar(menuBar);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}

public class Main {

	public static void main(String[] args) {

		/*
		 * 모든 최상위 창에는 관련 메뉴의 모음이 있다. 사용자가 이용할 수 있는 다양한 선택 항목으로 구성되며, 각 선택 항목에는 드롭다운 메뉴
		 * 옵션 포함하고 있다.
		 * 
		 * JMenuBar - 창이나 프레임에 메뉴 표시줄을 표시한다. - 여러 개의 메뉴가 있을 수 있다.
		 * 
		 * JMenu 메뉴바에 나타나는 폴다운 메뉴 컴포넌트를 표시한다.
		 * 
		 * JMenuItem - 간단한 메뉴 항목을 추가한다. - 메뉴에 사용된 항목은 JMenuItem로 만들 수 있다.
		 * 
		 */

//		JFrame frame = new JFrame();
//		// 1. JMenuBar를 생성한다.
//		frame.setBounds(0, 0, 300, 300);
//		JMenuBar menuBar = new JMenuBar();
//		
//		// 2. 메뉴를 생성
//		JMenu menu01 = new JMenu("File");
//		JMenu menu02 = new JMenu("Edit");
//		JMenu menu03 = new JMenu("Source");
//		
//		// 3. 메뉴바에 추가
//		menuBar.add(menu01);
//		menuBar.add(menu02);
//		menuBar.add(menu03);
//		
//		// 4. 메뉴 항목 만들기
//		JMenuItem item01 = new JMenuItem("New");
//		JMenuItem item02 = new JMenuItem("Open");
//		JMenuItem item03 = new JMenuItem("Close");
//		
//		// 5. 파일이라는 메뉴에 항목을 추가하기
//		menu01.add(item01);
//		menu01.add(item02);
//		menu01.add(item03);
//		
//		// 6. 프레임에 메뉴 설정하기 (메뉴를 추가할 땐 setJMenuBar();)
//		frame.setJMenuBar(menuBar);
//		
//		// 7. 윈도우 창에 보이기
//		frame.setVisible(true);

		new MyFrame8();

	}

}
