package Controller_Test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Controller1 extends JFrame implements ActionListener{
	
	private JTextField hakField;
	private JPasswordField passField;
	private JButton btn;
	
	/* Controller는 경로를 관리하는 클래스
	 * - 화면과 데이터를 처리하는 DB랑 연결해주는 클래스다
	 */
	
	/* 싱글톤 객체
	 * - 단 하나의 유일한 객체
	 * - 메모리 절약을 위해 인스턴스가 필요할 때는 새로 만들지 말고 기존의 인스턴스를 가지고 와서 사용한다.
	 */ 
	private MemberService mService = new MemberService();
	
	public MemberService getmService() {
		return mService;
	}

	public Controller1() {
		// 윈도우 창 생성
		setTitle("수강신청");
		setSize(500, 500);
		getContentPane().setBackground(Color.WHITE);
		
		// 화면 중간에 윈도우 창 배치하는 메서드
		// setLocationRelativeTo(null);
		// : 컴포넌트들을 상대적 위치에 배치하는데 사용이 된다.
		// - null을 넣으면 윈도우창을 가운데 배치할 수 있도록 설정이 되어있다.
		setLocationRelativeTo(null);
		
		// 배치관리자를 내가 직접 설정
		setLayout(null);
		
		// 패널생성
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(50, 50, 400, 300);
		mainPanel.setBorder(new LineBorder(Color.BLACK));
		add(mainPanel);
		
		// 수강신청 라벨 추가 (글씨 크기 40)
		JLabel titleLabel = new JLabel("수강신청");
		titleLabel.setFont(new Font("굴림체", Font.BOLD, 40));
		titleLabel.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		titleLabel.setBounds(0, 10, 400, 50);
		titleLabel.setBorder(new LineBorder(Color.BLACK));
		mainPanel.add(titleLabel);
		
//		TitledBorder title = new TitledBorder("new Border");
//		mainPanel.add(getLabel("this is a title", title));
		
		hakField = new JTextField("학번", 20);
		hakField.setBounds(100, 100, 200, 30);
		mainPanel.add(hakField);
		
		// 비밀번호 입력받는 JPasswordField
		passField = new JPasswordField(20);
		passField.setBounds(100, 150, 200, 30);
		mainPanel.add(passField);
		
		btn = new JButton("로그인");
		btn.setBounds(200, 200, 100, 30);
		mainPanel.add(btn);
		
		btn.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// 버튼이 눌렸을 때 실행하는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		// 텍스트 필드의 모든 내용을 가지고 온다.
		String hakbun = hakField.getText();
		// getPassword() 가져오지만 char[] 배열로 가져오기 때문에 문자열로 변경해야된다.
		String pass = new String(passField.getPassword());
		
		// 서비스로 넘기기 VO 한 건의 데이터를 저장하기 위해서 
		int result = mService.login(new MemberVO(hakbun, pass));
		
		// 팝업 
		// - 성공했다는 팝업 띄우고, 메인 페이지로 이동
		// - 실패했다면 다시 입력받을 수 있도록 초기화
		
		
	}
}
