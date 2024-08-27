package GUI_Total;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ColorChart extends JFrame implements MouseWheelListener{

	// totalPan
	JPanel totalPan = new JPanel();

	// colorPan r,g,b 저장
	JPanel colorPan = new JPanel();

	// totalPan과 colorPan으로 2개의 영역으로 나누었으니 colorPan을 3개의 영역으로 다시 나눈다.

	JPanel redPan = new JPanel();
	JPanel bluePan = new JPanel();
	JPanel greenPan = new JPanel();
	
	// 색상을 저장하는 변수
	// 0 ~ 255 사이의 색상 표현의 범위
	int red = 128;
	int blue = 128;
	int green = 128;

	ColorChart() {
		setBounds(100, 50, 600, 800);

		// 윈도우 배치를 똑같은 크기로 설정
		setLayout(new GridLayout(2, 1));

		// 실제 각각의 판에 배경색 저장
		redPan.setBackground(Color.red);
		bluePan.setBackground(Color.blue);
		greenPan.setBackground(Color.green);

		// colorPan판에 추가를 해야된다.
		// 기본 배치가 한 줄에 배치하는 FlowLayout으로 되어있기 때문에
		// 똑같은 크기로 3개를 배치시키기 위해선 GridLayout으로 변경해야한다.
		colorPan.setLayout(new GridLayout(1, 3));

		// colorPan에 추가
		colorPan.add(redPan);
		colorPan.add(bluePan);
		colorPan.add(greenPan);

//		// 이벤트 추가
//		redPan.addMouseWheelListener(new MouseWheelListener() {
//			@Override
//			public void mouseWheelMoved(MouseWheelEvent e) {
//				if (e.getWheelRotation() < 0) {
//					red = --red < 0? 0 : red;
//				} else {
//					red = ++red > 255 ? 255 : red;
//				}
//				
//				// 색상이 변경 되었기 때문에 다시 컬러를 생성해서 totalPan에 추가하면 된다.
//				totalPan.setBackground(new Color(red, blue, green));
//			}
//		});
//		bluePan.addMouseWheelListener(new MouseWheelListener() {
//			@Override
//			public void mouseWheelMoved(MouseWheelEvent e) {
//				if (e.getWheelRotation() < 0) {
//					blue = --blue < 0? 0 : blue;
//				} else {
//					blue = ++blue > 255 ? 255 : blue;
//				}
//				totalPan.setBackground(new Color(red, blue, green));
//			}
//		});
//		greenPan.addMouseWheelListener(new MouseWheelListener() {
//			@Override
//			public void mouseWheelMoved(MouseWheelEvent e) {
//				if (e.getWheelRotation() < 0) {
//					green = --green < 0? 0 : green;
//				} else {
//					green = ++green > 255 ? 255 : green;
//				}
//				totalPan.setBackground(new Color(red, blue, green));
//			}
//		});
		
		// 이벤트 추가 코드 간단한 코드로 변경
		// 클래스한테 구현
		redPan.addMouseWheelListener(this);
		bluePan.addMouseWheelListener(this);
		greenPan.addMouseWheelListener(this);

		// 윈도우 추가
		add(totalPan);
		add(colorPan);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// 어떤 패널에서 휠을 굴렸는지 판단한다.
		// getSource() : 이벤트가 발생된 객체의 컴포넌트 정보를 얻어온다.
		// 어떤 컴포넌트가 올 지 모른다. (버튼, 휠, 키, 스크롤, 체크박스, 라디오버튼 등등)
		//  - 가장 최상위 부모 클래스인 Object 타입으로 받게 된다.
		// 발생한 패널의 객체를 가지고 있다. → 발생한 패널의 주소값을 temp가 저장하고 있다.
		Object obj = e.getSource();
		JPanel temp = (JPanel) obj;
		
		// 주소값을 이용하여 해당하는 객체의 변수를 수정, 적용할 수 있다.
		if(temp == redPan) {
			if (e.getWheelRotation() < 0) {
				red = --red < 0? 0 : red;
			} else {
				red = ++red > 255 ? 255 : red;
			}
			System.out.println("red: " + red);
		}else if(temp == bluePan) {
			if (e.getWheelRotation() < 0) {
				blue = --blue < 0? 0 : blue;
			} else {
				blue = ++blue > 255 ? 255 : blue;
			}
			System.out.println("blue: " + blue);
		}else if(temp == greenPan) {
			if (e.getWheelRotation() < 0) {
				green = --green < 0? 0 : green;
			} else {
				green = ++green > 255 ? 255 : green;
			}
			System.out.println("green: " + green);
		}
		// 셋 중 하나의 패널(영역)이 선택 되었다면 색상을 다시 설정하기
		totalPan.setBackground(new Color(red, blue, green));
	}

}

public class Main {

	public static void main(String[] args) {
		new ColorChart();
	}

}
