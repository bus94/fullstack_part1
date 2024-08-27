package GUI_Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame3 extends JFrame implements ActionListener{
	JButton btn = new JButton("버튼을 누르세요!");
	
	MyFrame3(){
		setBounds(0, 0, 300, 300);
		
		init();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	void init() {
		
		btn.addActionListener(this);
		
		add(btn);
		
	}
	
	// MyFrame3 멤버로 메서드를 구현할 수 있다.
	// 이벤트가 발생했을 때 이벤트 객체를 만들어야 되는데 나 자신 안에 메서드를 구현했다.
	@Override
	public void actionPerformed(ActionEvent e) {
		if(btn.getText().equals("눌렀니?")){
			btn.setText("버튼눌렀음");
		} else {
			btn.setText("눌렀니?");
		}
	}
	
}

public class Main3 {

	public static void main(String[] args) {
		new MyFrame3();
	}

}
