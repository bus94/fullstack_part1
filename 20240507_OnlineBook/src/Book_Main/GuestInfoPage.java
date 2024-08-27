package Book_Main;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Book_Member.UserInfo;

// 고객 정보를 출력하는 창을 생성하는 클래스
public class GuestInfoPage extends JPanel{

	public GuestInfoPage(JPanel panel) {
		Font ft = new Font("함초롬돋움", Font.BOLD, 20);
		Font ft1 = new Font("함초롬돋움", Font.BOLD, 22);
		
		// 사용자가 직접 설정 → 기본 FlowLayout 설정값을 null값으로 초기화한 것
		setLayout(null);
		
		// 패널에 있는 x, y, width, height를 한 번에 저장하는 클래스
		// 패널이 가지고 있는 x, y, w, h를 패널에서 꺼내와서 
		// Rectangle 클래스가 자동으로 매칭해서 저장해준다.
		Rectangle rect = panel.getBounds(); 
		System.out.println(rect);
		// 위의 정보를 이용해서 윈도우 창의 크기를 수정하는 메서드를 호출해야된다.
		setPreferredSize(rect.getSize());
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 100, 1000, 50);
		namePanel.setFont(ft);
		JLabel nameLabel = new JLabel("이    름: ");
		nameLabel.setFont(ft);
		JLabel nameUser = new JLabel();
		// TextField 에서 저장한 내용을 가지고 와서 
		// nameUser.setText();
		nameUser.setFont(ft1);
		nameUser.setText(UserInfo.getmUser().getName());
		
		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(0, 150, 1000, 50);
		phonePanel.setFont(ft);
		JLabel phoneLabel = new JLabel("연 락 처: ");
		phoneLabel.setFont(ft);
		JLabel phoneUser = new JLabel();
		phoneUser.setFont(ft1);
		phoneUser.setText(UserInfo.getmUser().getPhone());
		
		// 각각의 영역에 추가
		namePanel.add(nameLabel);
		namePanel.add(nameUser);
		
		phonePanel.add(phoneLabel);
		phonePanel.add(phoneUser);
		
		// 윈도우에 추가
		add(namePanel);
		add(phonePanel);
	}
}
