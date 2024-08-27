package Book_Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Book_Member.UserInfo;

// 가장 첫 화면 - 고객의 정보를 입력하는 페이지
public class GuestWindow extends JFrame{
	
	public GuestWindow() {
		setTitle("고객 정보 입력");
		// 내가 원하는대로 배치를 하고 싶을 경우에는 setLayout(null);
		setLayout(null);
		// 윈도우 창
		setBounds(0, 0, 1000, 750);
		
		Font ft = new Font("함초롱돋움", Font.BOLD, 20);
		
		// Dimension 클래스 : 너비랑 높이를 자동으로 저장하는 클래스
		// Toolkit 클래스 : 정보를 가져와서 반으로 계산해서 저장하는 것
		// setLocation(x, y); // 창의 위치만 지정
		
		// 고양이 이미지
		JPanel userPanel = new JPanel();
		userPanel.setBounds(0, 100, 1000, 250);
		
		ImageIcon imageIcon = new ImageIcon("./images/user.png");
		// 그냥 아이콘 자체로 이미지를 표현할 수 없으니 라벨에다가 ImageIcon을 올려서 표현하기
		JLabel userLabel = new JLabel(imageIcon);
		userPanel.add(userLabel);
		add(userPanel);
		
		// -- 고객 정보를 입력하세요 --
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 350, 1000, 50);
		
		JLabel titleLabel = new JLabel("-- 고객 정보를 입력하세요 --");
		titleLabel.setFont(ft);
		titleLabel.setForeground(Color.blue);
		titlePanel.add(titleLabel);
		add(titlePanel);
		
		// "이름" 텍스트와 입력칸 추가하기
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 400, 1000, 50);
		
		JLabel nameLabel = new JLabel("이    름: ");
		nameLabel.setFont(ft);
		namePanel.add(nameLabel);
		
		JTextField nameField = new JTextField(10);
		nameField.setFont(ft);
		namePanel.add(nameField);
		
		add(namePanel);
		
		JPanel phonePanel = new JPanel();
		JLabel phoneLabel = new JLabel("연 락 처: ");
		phonePanel.setBounds(0, 450, 1000, 50);
		phoneLabel.setFont(ft);
		phonePanel.add(phoneLabel);
		
		JTextField phoneField = new JTextField(10);
		phoneField.setFont(ft);
		phonePanel.add(phoneField);
		
		add(phonePanel);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(0, 500, 1000, 100);
		
		JButton btn = new JButton("쇼핑하기", new ImageIcon("./images/shop.png"));
		btnPanel.add(btn);
		add(btnPanel);
		
		// 버튼을 클릭했을 때 mainMenu로 이동
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nameField.getText().isEmpty() || phoneField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btn, "고객 정보를 입력하세요", "고객 정보"
														, JOptionPane.ERROR_MESSAGE);
				}else {
					// 고객에 대한 정보를 생성
					UserInfo.init(nameField.getText(), phoneField.getText());
					
					// MainWindow 생성자를 통해 생성되기 전 현재 창을 종료한다.
					dispose();
					
					// user 객체 생성하고
					new MainWindow("온라인 서점", 0, 0, 1100, 900);
				}
			}
		});
		
		
		// 버튼에 들어가는 가게 모양 아이콘 가져오기
		setIconImage(new ImageIcon("./images/shop.png").getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}


