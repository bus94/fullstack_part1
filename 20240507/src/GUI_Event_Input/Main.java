package GUI_Event_Input;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class MyFrame5 extends JFrame {
	public MyFrame5() {
		setBounds(0, 0, 300, 300);
		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void init() {
		JTextField jtext1 = new JTextField(10);
		JButton btn = new JButton("눌름");
		// 화면 배치
		setLayout(new FlowLayout()); // 한 줄 배치

		// 버튼을 클릭했을 때 텍스트 창에 있는 내용을 가져오기
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = jtext1.getText();
				// System.out.println(text);
				
				// JOptionPane 팝업 클래스!
				JOptionPane.showMessageDialog(null, "입력한: " + text);
			}
		}

		);

		// 추가
		add(jtext1);
		add(btn);
	}
}

public class Main {

	public static void main(String[] args) {

		new MyFrame5();

	}

}
