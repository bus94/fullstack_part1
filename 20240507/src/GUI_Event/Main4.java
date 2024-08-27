package GUI_Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame4 extends JFrame {
	JButton btn = new JButton("버튼을 누르세요!");

	MyFrame4() {
		setBounds(0, 0, 300, 300);

		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	void init() {

		btn.addActionListener(
				
				/*
				 * 무명 클래스 (익명 클래스) - 클래스 몸체가 정의 되었지만 클래스 이름이 없는 클래스 - 클래스를 정의 하는 동시에 객체를 생성하며,
				 * 이름이 없기 때문에 한 번만 사용할 수 있다!
				 * 
				 */
				new ActionListener() { // Anonymous Inner type

					@Override
					public void actionPerformed(ActionEvent e) {
						if (btn.getText().equals("눌렀니?")) {
							btn.setText("버튼눌렀음");
						} else {
							btn.setText("눌렀니?");
						}
					}
				}
		);

		add(btn);

	}

}

public class Main4 {

	public static void main(String[] args) {

		new MyFrame4();

	}

}

