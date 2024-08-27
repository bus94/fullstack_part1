package GUI_Layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame2 extends JFrame{
	MyFrame2(){
		setSize(500, 500);
		
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		JButton btn4 = new JButton("버튼4");
		JButton btn5 = new JButton("버튼5");
		
		// 화면 배치 설정
		// 왼쪽에서 오른쪽으로 "한 줄"에 차례대로 화면에 배치한다.
		setLayout(new FlowLayout());
		
		// 버튼 추가
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class FlowLayoutMain {

	public static void main(String[] args) {
		
		// 화면의 배치를 이용한 클래스
		new MyFrame2();
	}

}
