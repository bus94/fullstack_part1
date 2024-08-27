package GUI_Button;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame6 extends JFrame{
	MyFrame6(){
		setSize(500, 500);
		
		// 화면배치
		setLayout(new FlowLayout());
		
		// 검색창이나 입력창을 만들때 사용하는 한 줄 텍스트 입력
		
		// 기본 생성 할 경우 칸이 존재하지 않아 입력할 수 없게 된다.
		// JTextField input1 = new JTextField();
		
//		// 입력창의 칸을 설정할 수 있다.
//		// 괄호 안에 숫자를 넣으면 숫자 만큼 공간이 생긴다.
//		JTextField input1 = new JTextField(10);
		JTextField input1 = new JTextField("고양이", 10);
		
		// 체크 박스
		//  기본 생성을 하면 체크박스만 생성된다
		JCheckBox ch1 = new JCheckBox();
		//  생성 시 문자를 넣으면 체크박스 옆에 문자가 생긴다.
		JCheckBox ch2 = new JCheckBox("고양이");
		// 	문자열을 입력하고 두 번째 인자로 true가 들어오면 체크박스가 선택된 표시로 바뀐다.
		JCheckBox ch3 = new JCheckBox("강아지", true);
		
		// "체크 박스"는 여러 개를 선택해서 결과를 생성할 수 있다.
		// "라디오 버튼"은 여러 가지 옵션 중에서 하나만 선택할 수 있다.
		
		// 각각의 라디오 버튼이 생성되기 때문에 체크박스와 다름없이 모두 선택이 가능한 현상이 생긴다.
		// 여러 개의 라디오 박스를 하나의 그룹으로 묶어줘야한다.
		JRadioButton jr1 = new JRadioButton();
		JRadioButton jr2 = new JRadioButton("고양이");
		JRadioButton jr3 = new JRadioButton("강아지", true);
		
		// 콤보 박스
		JComboBox obj1 = new JComboBox();
		
		String[] name = {"고양이", "강아지", "돼지"};
		JComboBox obj2 = new JComboBox(name);
		
		// 여러 줄을 작성하는 텍스트 표시(메모장과 같은 기능)
		JTextArea jt1 = new JTextArea();
		// 행(줄), 열(칸)
		JTextArea jt2 = new JTextArea(5, 30); 
		
		// JLabel
		//  텍스트를 배치하기 위한 구성 요소
		//  읽기 전용 텍스트의 한 줄을 표시하는데 사용함
		JLabel j1 = new JLabel("고양이");
		JLabel j2 = new JLabel(new ImageIcon("cat.png"));
		
		// JPasswordField
		// 	클래스를 이용해서 비밀번호 입력에 특화된 텍스트 구성 요소
		//  암호 기능을 처리하고 한 줄 텍스트를 편집할 수 있다.
		JPasswordField pass1 = new JPasswordField(10);
		
		// 기본적으로 .으로 지정되어있고, 원하는 문자로 넣을 경우 변경하면 된다.
		pass1.setEchoChar('*');
		
		// 윈도우에 추가
		add(input1);
		add(ch1); add(ch2); add(ch3);
		add(jr1); add(jr2); add(jr3);
		add(obj1); add(obj2);
		add(jt1); add(jt2);
		add(j1); add(j2);
		add(pass1);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class JTextFieldMain {

	public static void main(String[] args) {
		
		new MyFrame6();
		
	}

}
