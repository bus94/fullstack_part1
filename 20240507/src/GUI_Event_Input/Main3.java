package GUI_Event_Input;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MyFrame7 extends JFrame implements MouseListener, MouseWheelListener {
	// 클래스 멤버 변수로 선언 (컴포넌트)
	JPanel pan1;
	JPanel pan2;
	int size = 15;

	// 글씨 설정
	Font font = new Font("궁서체", Font.PLAIN, size);

	// 실제 글씨
	JLabel label = new JLabel("Hello");

	MyFrame7() { // 윈도우 설정
		setBounds(500, 400, 500, 500);

		// 똑같은 크기로 만들기 - gridLayout
		// 장점은 컴포넌트 크기를 자동으로 맞춰준다.
		setLayout(new GridLayout(2, 1));

		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void init() {

		// 컴포넌트
		pan1 = new JPanel();
		pan2 = new JPanel();
		
		pan2.setBackground(Color.pink);

		// 이벤트
		pan2.addMouseListener(this);

		// 마우스 휠을 이용해서 이벤트를 추가
		pan2.addMouseWheelListener(this);

		// 글씨를 pan1에 추가하기
		pan1.add(label);

		// 윈도우 추가
		add(pan1);
		add(pan2);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pan1.setBackground(Color.blue);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pan1.setBackground(Color.red);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pan1.setBackground(Color.green);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		pan1.setBackground(Color.magenta);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		pan1.setBackground(Color.yellow);
	}

	// 마우스 휠 이벤트에 대한 메서드
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// System.out.println(e.getWheelRotation());
		int wheel = e.getWheelRotation();

		if (wheel < 0) {
			// 휠을 앞으로 굴렸다!
			size--;
		} else {
			// 휠을 뒤로 굴렸다!
			size++;
		}
		font = new Font("궁서체", Font.PLAIN, size);
		
		// 변경된 폰트 설정을 라벨에 수정
		label.setFont(font);
	}
}

public class Main3 {

	public static void main(String[] args) {

		new MyFrame7();

	}

}
