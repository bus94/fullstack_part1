import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// 로그인(멤버)을 하면 로그인을 해결하는 Controller
// 수강신청을 하면 수강신청 Controller

public class Controller extends JFrame{
	
	// 로그인 창 보이기
	// - 로그인해서 팝업창 띄우기 (실패)
	// - 로그인이 되면 메인페이지 보이기
	
	public Controller() {
		MemberDAO memDAO = new MemberDAO();
		MemberService memService = new MemberService();
		Member member = new Member();
		
		setTitle("로그인");
		setBounds(50, 50, 400, 500);
		setLayout(null);
		
		Font ft = new Font("함초롱돋움", Font.BOLD, 50);
		
		JPanel mainPanel = new JPanel();
		JLabel titleLabel = new JLabel("수강신청");
		titleLabel.setFont(ft);
		mainPanel.setBounds(0, 50, 400, 150);
		mainPanel.add(titleLabel);
		
		JPanel hakPanel = new JPanel();
		JTextField hakTextField = new JTextField("학번", 30);
		hakPanel.setBounds(0, 200, 400, 100);
		hakPanel.add(hakTextField);
		
		JPanel pwPanel = new JPanel();
		JTextField pwTextField = new JTextField("****", 30);
		pwPanel.setBounds(0, 300, 400, 100);
		pwPanel.add(pwTextField);
		
		JPanel btnPanel = new JPanel();
		JButton btn = new JButton("로그인");
		btnPanel.setBounds(0, 400, 400, 100);
		btnPanel.add(btn);
		
//		btn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(hakTextField.getText().isEmpty() || pwTextField.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(btn, "로그인 정보를 입력하세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
//				} else if() {
//					dispose();
//					mainController(hakTextField.getText());
//				} else {
//					JOptionPane.showMessageDialog(btn, "로그인 정보가 일치하지 않습니다.\n다시 로그인해주세요.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//
//		});
		
		add(mainPanel);
		add(hakPanel);
		add(pwPanel);
		add(btnPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	protected void mainController(String hakbun) {
		setTitle("수강신청");
		setBounds(100, 100, 1200, 800);
		setLayout(null);
		
		JPanel mainPanelw = new JPanel(new BorderLayout());
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BorderLayout(8, 2));
		JLabel nameInfo = new JLabel("2020년 2학기 수강신청");
		JLabel name = new JLabel();
		JLabel hakInfo = new JLabel("이름");
		JLabel majorInfo = new JLabel("학번");
		JLabel infoLabel4 = new JLabel("학부(과)");
		JLabel infoLabel5 = new JLabel("학년");
		JLabel infoLabel6 = new JLabel("최소신청학점");
		JLabel infoLabel7 = new JLabel("최대신청학점");
		
		infoPanel.add(nameInfo);
		infoPanel.add(hakInfo);
		infoPanel.add(majorInfo);
		infoPanel.add(infoLabel4);
		infoPanel.add(infoLabel5);
		infoPanel.add(infoLabel6);
		infoPanel.add(infoLabel7);
		
		mainPanelw.setBounds(0, 0, 250, 800);
		mainPanelw.add(infoPanel, BorderLayout.CENTER);
		
		add(mainPanelw);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
}
