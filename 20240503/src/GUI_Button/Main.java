package GUI_Button;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame5 extends JFrame{
	MyFrame5(){
		setSize(400, 400);
		
//		JButton[] btList = new JButton[3];
//		
//		for(int i = 0; i < btList.length; i++) {
//			btList[i] = new JButton("버튼" + (i+1));
//			add(btList[i]);
//		}
		
		// 버튼의 글씨를 없애고 아이콘으로
		// ImageIcon클래스 이용해서 객체를 생성한다.
		JButton btn1 = new JButton("고양이", new ImageIcon("cat.png"));
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		
		setLayout(new FlowLayout());
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Main {

	public static void main(String[] args) {
		
		// 윈도우 창은 400, 400으로 설정
		// 버튼은 3개를 생성
		// 화면의 배치는 한 줄로 배치하는 윈도우 창 띄우기
		new MyFrame5();
	}

}
