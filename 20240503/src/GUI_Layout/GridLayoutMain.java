package GUI_Layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame4 extends JFrame {
	MyFrame4() {
		setSize(500, 500);

		// 16개의 각각의 변수를 만들어도 상관없지만 중복이 되고, 
		// 빈 공간을 찾을 때마다 각각의 변수에 접근하는 불편이 있음
		JButton[] btnList = new JButton[16];
		
		// 화면 배치 설정
		// 	격자 모양의 배치를 한다. 바둑판!
		// 	행과 열로 화면이 구성된다.
		// 	똑같은 크기로 자동으로 칸에 데이터가 들어간다.
		// 	무조건 행을 기준으로 설정한다.
		// 	GridLayout(rows, cols)
		setLayout(new GridLayout(4, 4));
		
		for(int i = 0; i < btnList.length; i++) {
			btnList[i] = new JButton("버튼" + (i+1));
			add(btnList[i]);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class GridLayoutMain {

	public static void main(String[] args) {

		new MyFrame4();

	}

}
