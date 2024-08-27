package Panel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//사각형 정보를 저장하는 클래스 
class Rect {
	
	
	int x;		
	int y;
	int w;
	int h;
	
	// 색상 
	Color color = null;
	
	// 이동 여부 저장 
	boolean is_move = false;

	public Rect() {
	}

	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		//기본 검정색으로 설정함
		color = Color.black;
		
	}
	// 각각의 사각형들은  클릭 되었는지 확인
	// 메서드 
	//  사각형 안에서 클릭이 됬는지 밖에서 클릭됬는지
	//  확인 
	boolean getClicked(int rx,int ry) {
		
		if(rx > x && rx < x +w && 
		   ry > y && ry < y + h) {
			return true;
		}
		return false;		
	}
	
	// 사각형들이 위에 메서드에서 클릭이 되었다면
	// 움직인다. 움직이는 모습을 업데이트 !
	void update() {
		
		if(is_move) {
			
			y += 1; // 이동 중이면 y값을 증가해서
					// 아래로 이동시킨다. 
		}
		// 한없이 증가를 하면 한없이 아래로 내려가서 
		// 윈도우창 밖으로 나간다. 
		
		if( y > 300) {
			y = 50; //위에서 50만큼 떨어진 위치로 이동
			is_move = false;
		}		
	}	
}

// 실제 사각형을 객체를 생성하고 움직이는 클래스
class GameBoard{
	//사각형을 저장하는 배열 
	Rect[] rc = new Rect[5];
	
	int x = 0, y = 0;
	
	// 사각형 배치하는 생성자 
	public GameBoard() {
	
	
	}	
}

class MyPanel extends JPanel
			  implements MouseListener,
			           MouseMotionListener{
	
	// 패널을 초기화 
	public MyPanel() {
	
		setLayout(null); 
		addMouseListener(this);
		addMouseMotionListener(this);	
	}		

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

public class AnimationMain1 {

	public static void main(String[] args) {
		
		// 프레임 생성 
		JFrame frame = new JFrame();
		frame.setTitle("Test1");
		frame.setDefaultCloseOperation
				(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(600, 400);
		frame.setLocation(100,0);
		// 우리가 만든 패널을 추가하기 
		frame.setContentPane(new MyPanel());
		frame.setVisible(true);
		
		
		
	}
}