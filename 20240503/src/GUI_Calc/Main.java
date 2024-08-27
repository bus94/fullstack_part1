package GUI_Calc;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrameCalc extends JFrame {

	// 강사님 풀이
	public MyFrameCalc() {
		
		setTitle("계산기 화면");
		setSize(300, 250);
		// 기본적으로 BorderLayout을 실행하고 있어서 무조건 가운데 정렬을 하는 것이다.
		// 따라서 기본적인 Layout을 없애고 사용자가 원하는 x, y를 저장 할 수 있다.
		setLayout(null);

		// 타이틀 작성하는 영역 나눈다.
		JPanel titlePan = new JPanel();

		// 영역의 크기를 설정하는 것
		// setBounds(x(좌), y(상), 너비, 높이)
		// x: 왼쪽으로부터 떨어진 거리 / y: 윗쪽으로부터 떨어진 거리
		// 한 번에 여러 개를 설정할 수 있다.
		titlePan.setBounds(0, 0, 300, 40);
		JLabel title = new JLabel("계산기");

		// 글씨체랑 글씨 크기를 조절하는 Font 클래스
		// Font(글씨체, 스타일, 사이즈)
		Font font = new Font("함초롱돋움", Font.BOLD, 30);
		
		title.setFont(font);
		
		// 타이틀 영역에 라벨을 추가하기
		titlePan.add(title);
		
		// input창 두 개를 한 줄에 표현
		// JPanel 클래스는 기본적으로 배치가 FlowLayout 되어있다. → 한 줄에 여러 개를 표현한다.
		JPanel numPanel = new JPanel();
		
		numPanel.setBounds(0, 50, 300, 40);
		
		JTextField num1 = new JTextField(5);
		JTextField num2 = new JTextField(5);
		
		numPanel.add(num1);
		numPanel.add(num2);
		
		// 숫자 버튼들을 설정
		JPanel btnPan = new JPanel();
		btnPan.setBounds(100, 90, 100, 70);
		// GridLayout(행, 열, 좌우여백, 상하여백)
		btnPan.setLayout(new GridLayout(2, 2, 5, 10)); 
		// 5, 10 은 여백의 의미 (수평, 수직)
		
		JButton btn1 = new JButton("+");
		JButton btn2 = new JButton("-");
		JButton btn3 = new JButton("*");
		JButton btn4 = new JButton("/");
		
		btnPan.add(btn1); btnPan.add(btn2);
		btnPan.add(btn3); btnPan.add(btn4);
		
		// 마지막 라벨 추가하기
		JPanel resultPan = new JPanel();
		resultPan.setBounds(0, 170, 300, 40);
		
		JLabel result = new JLabel("계산결과: ");
		resultPan.add(result);
		
		// 윈도우에 추가
		add(titlePan);
		add(numPanel);
		add(btnPan);
		add(resultPan);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// 스스로 (미완성)
//		JFrame frame = new JFrame("계산기 화면");
//		frame.setSize(500, 500);
//		
//		frame.setLayout(new BorderLayout());
//		
//		JLabel j1 = new JLabel("계산기");
//		JLabel j2 = new JLabel("계산결과: ");
//		frame.add(j1, BorderLayout.NORTH);
//		frame.add(j2, BorderLayout.SOUTH);
//		
//		JPanel pan = new JPanel();
//		pan.setLayout(new GridLayout(3, 2));
//		JTextField input1 = new JTextField(10);
//		JTextField input2 = new JTextField(10);
//		JButton btn1 = new JButton("+");
//		JButton btn2 = new JButton("-");
//		JButton btn3 = new JButton("*");
//		JButton btn4 = new JButton("/");
//		
//		pan.add(input2);
//		pan.add(btn1);
//		pan.add(btn2);
//		pan.add(btn3);
//		pan.add(btn4);
//		
//		frame.add(j1, BorderLayout.CENTER);
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
}

public class Main {

	public static void main(String[] args) {
		new MyFrameCalc();
	}

}
