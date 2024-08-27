package GUI_Event_Input;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame6 extends JFrame {
	public MyFrame6() {
		setBounds(0, 0, 300, 300);
		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void init() {
		// 키를 눌렀을 때
		// KeyListener 인터페이스를 이용하여 객체를 생성해서 이벤트를 실행 할 수 있다.

		// 윈도우 색상에 관련된 클래스
		// Color 클래스 (static 설정 이므로 객체 생성할 필요 없음)
		JPanel p = new JPanel();
		p.setBackground(Color.MAGENTA);
		
		// 문자를 저장하는 변수 선언
		StringBuilder sb = new StringBuilder();

		// 키 이벤트는 윈도우 창에 이벤트를 설정한다.
		// 그때는 앞에 아무것도 작성하지 않는다.
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// System.out.println("타이핑"); // 잘 안 쓰임
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// System.out.println("키보드 뗄 때");
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println("누를 때");
				// 특수 키들은 문자로 표현을 못한다.
				// char 아스키코드표
				// System.out.println(e.getKeyChar());
				// 입력된 키가 숫자로 온다.
				// System.out.println(e.getKeyCode());
				int getKey = e.getKeyCode();
				
				// 엔터를 눌렀을 때 현재 입력한 문자까지만 팝업에 출력!
				if(getKey == 10) {
					JOptionPane.showMessageDialog(null, sb);
					
					// 기존의 문자를 지우는 내용을 작성
					sb.setLength(0);
				} 
				// 입력된 문자를 sb에 저장한다.
				sb.append((char)getKey);
				
//				if(getKey == 32) {
//					System.out.println("스페이스바");
//				}
				
				// 입력한 키 값을 팝업창에 띄우기
				//  팝업의 text는 문자로 들어가야 된다.
				//  입력하다가 엔터가 들어오면 엔터 전까지의 문자를 문자열에 저장해서 한 번에 팝업에 띄우기
			}
		});

		add(p);

	}
}

public class Main2 {

	public static void main(String[] args) {

		new MyFrame6();

	}

}
