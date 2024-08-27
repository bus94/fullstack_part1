package Panel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

// 1) 틀, 2) 패널 ==> 그래픽 

class MyPanel2 extends JPanel
			   implements MouseListener,
			   		MouseMotionListener{

	
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}
	
}



public class AnimationMain2 {

	public static void main(String[] args) {

		// 프레임 생성
		JFrame frame = new JFrame();
		frame.setTitle("Test2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(1000, 800);
		frame.setLocation(100, 0);
		// 우리가 만든 패널을 추가하기
		frame.setContentPane(new MyPanel2());
		frame.setVisible(true);

	}
}
