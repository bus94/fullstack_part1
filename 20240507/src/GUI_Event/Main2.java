package GUI_Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 내부 클래스로 이벤트 처리하기
// 	클래스 안에 클래스를 집어 넣는 것!
// 	(외부 클래스는 private을 선언 할 수 없지만 내부 클래스는 선언 가능)
// MyFrame2 클래스 안에 멤버로 속해 있기 때문에 전역변수로 선언된 btn 컴포넌트를 형변환 필요 없이 사용 가능하다.
class MyFrame2 extends JFrame {
	JButton btn = new JButton("버튼을 누르세요!");

	private class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// JButton btn = (JButton) e.getSource();
			if (btn.getText().equals("눌렀니?")) {
				btn.setText("버튼눌렀음");
			} else {
				btn.setText("눌렀니?");
			}

			// btn.setText("눌렀니?");

		}

	}

	MyFrame2() {
		setBounds(0, 0, 300, 300);

		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	void init() {

		btn.addActionListener(new MyListener());

		add(btn);

	}

}

public class Main2 {

	public static void main(String[] args) {
		new MyFrame2();
	}

}
