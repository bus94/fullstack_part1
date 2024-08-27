package GUI_OnlineBook_Main;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame9 extends JFrame{
	MyFrame9(){
		setBounds(500, 400, 900, 600);
		setLayout(new BorderLayout());
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(5, 1));
		
		JLabel j1 = new JLabel(new ImageIcon("user.png"));
		j1.setBounds(0, 0, 200, 200);
		
		JLabel j2 = new JLabel("-- 고객 정보를 입력하세요 --");
		
		
		pan.add(j1);
		pan.add(j2);
		
		add(pan);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Main {

	public static void main(String[] args) {

		new GuestWindow();
		new MyFrame9();
		
	}

}
