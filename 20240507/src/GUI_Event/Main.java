package GUI_Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 독립된 클래스
// 단점: JFrame에 있는 클래스 멤버의 변수에 접근을 할 수 없다.

// 버튼을 클릭했을 때 실행하는 클래스
// ActionListener 버튼을 클릭했을 때 기능!
class MyListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		// 버튼을 클릭했을 때 실행할 문장;
//		System.out.println("버튼이 눌렸습니다!");
		
		// 버튼 글씨를 변경
		// 1. 먼저 버튼의 객체를 가져오기
		// 	현재 발생한 이벤트의 정보 (컴포넌트)
		JButton btn = (JButton) e.getSource();
		// 2. 변경
		// System.out.println(btn.getText());
		if(btn.getText().equals("눌렀니?")){
			btn.setText("버튼눌렀음");
		} else {
			btn.setText("눌렀니?");
		}
	
		// btn.setText("눌렀니?"); // 실행된 버튼을 클릭하면 해당 문장으로 변경됨
		
	}
	
}

class MyFrame extends JFrame{
	JButton btn = new JButton("버튼을 누르세요!");
	
	MyFrame(){
		setBounds(0, 0, 300, 300);
		
		init(); // 컴포넌트 (버튼, 체크박스)
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	void init() {
		
		// GUI는 순서에 민감하기 때문에 컴포넌트들을 생성하고 윈도우 창에 추가하기 전에 모든 설정을 하는 것이 좋다!
		
		// 버튼에 이벤트가 발생하면 실행하는 메서드
		btn.addActionListener(new MyListener());
		
		// 객체 생성 후 무조건 윈도우 창에 추가하기
		add(btn);
	
		
	}
	
}

public class Main {

	public static void main(String[] args) {

		/*
		 * 이벤트(event)
		 * - 사용자가 윈도우에서 버튼 클릭이나 스크롤 등 어떤 특별한 행동을 했을 때 실행되는 것!
		 * - 사용자 입력에 의해서 실행되는 부분
		 * 
		 * 이벤트 처리 순서
		 * - 이벤트 발생
		 * - 이벤트 객체 생성
		 * - 이벤트 리스너 탐색
		 * - 이벤트 리스너 호출
		 * - 이벤트 리스너 실행
		 * 
		 * 이벤트 소스 : 이벤트를 발생한 component
		 * 이벤트 객체 : 발생한 이벤트에 대한 정보
		 * 이벤트 리스너 : 이벤트를 처리하는 코드, 컴포넌트에 이동해서 작동
		 * 
		 */
		
		new MyFrame();
		
		
		
		
		
	}

}
