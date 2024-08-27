package Book_Page;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Book_Member.Admin;

/*
 * JDialog 클래스
 * - 대화 상자 형태 (팝업창을 생성하는데 사용하는 클래스)
 * - 사용자 입력 요청: 사용자로부터 정보 입력받아서 로그인 창이나 프로필 편집 창 등을 표시
 * - 여러 가지 컴포넌트들을 추가해서 대화상자를 만들고 이벤트 처리, Layout 까지 가능하다.
 * - JFrame 과 비슷하다.
 * 
 */

public class AdminLoginDialog extends JDialog {
	JTextField pwField, idField;

	// 로그인 판단
	// 다른 폴더에서 로그인 정보를 가져가서 사용할 수 있도록 public
	public boolean isLogin = false;

	public AdminLoginDialog(JFrame frame, String str) {
		// (생성자, 제목, 모달여부(주위 창 조작 여부));
		super(frame, "관리자 로그인", true);

		Font ft = new Font("함초롱돋움", Font.BOLD, 20);

		// 다이얼로그의 위치 값을 얻어오기
		// Dimension: 화면 크기를 나타내는 클래스
		// Toolkit : 시스템 도구 상자를 나타내는 클래스(시스템 정보를 가지고 있는 클래스)
		// getDefaultToolkit() : 실제 시스템의 정보를 반환하는 메서드
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();

		// 팝업창을 중앙에 배치하고 싶은 경우에는 전체 너비와 높이에서 반으로 나누면 된다.
		// 팝업 위치 설정
		setLocation(scrSize.width / 2, scrSize.height / 2);
		// 팝업 사이즈 설정
		setSize(400, 300);

		// 기존 Layout 영향을 받지 않고, 마음대로 설정하기 위해 null값으로 초기화
		setLayout(null);

		// 제목 패널을 생성하고 위치를 지정한다.
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 20, 400, 50);

		// 대화 상자에 추가
		add(titlePanel);

		// 컴포넌트들을 추가한다
		JLabel titleLabel = new JLabel("관리자 로그인");
		titleLabel.setFont(ft);

		// 타이틀 패널에 추가
		titlePanel.add(titleLabel);

		// 이름 패널 추가하고 위치 설정
		JPanel idPanel = new JPanel();
		idPanel.setBounds(0, 70, 400, 30);
		add(idPanel);

		JLabel idLabel = new JLabel("이    름: ");
		idLabel.setFont(ft);
		JTextField idField = new JTextField(10);
		idPanel.add(idLabel);
		idPanel.add(idField);

		// 패스워드 패널 추가하고 위치 설정
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(0, 100, 400, 30);
		add(pwPanel);

		JLabel pwLabel = new JLabel("패스워드: ");
		pwLabel.setFont(ft);
		JTextField pwField = new JTextField(10);
		pwPanel.add(pwLabel);
		pwPanel.add(pwField);
		
		// 확인, 취소 버튼 패널 추가하고 위치 설정
		JPanel btnPanel = new JPanel(new GridLayout(1, 2, 10, 0));
		btnPanel.setBounds(100, 130, 200, 30);
		JButton okButton = new JButton("확인");
		JButton cancelButton = new JButton("취소");
		btnPanel.add(okButton);
		btnPanel.add(cancelButton);
		add(btnPanel);
		
		// 확인 버튼을 눌렀을 때 로그인 실행
		// 1. Admin 객체 생성
		// 2. 입력한 필드에서 각각 아이디, 패스워드 가져오기
		// 3. 비교 맞으면 관리자 페이지를 보여주기
		//    틀리면 관리자 정보가 일치하지 않습니다.
		//    JOptionPane 클래스로 팝업창 이용!
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Admin admin = new Admin();
				String inputId = idField.getText();
				String inputPw = pwField.getText();
				System.out.println("id: " + inputId);
				System.out.println("pw: " + inputPw);
				
				if(admin.getId().equals(inputId) && admin.getPw().equals(inputPw)) {
					isLogin = true;
					dispose();
				}else {
					JOptionPane.showMessageDialog(okButton, "관리자 정보가 일치하지 않습니다."
							, "관리자 로그인 실패!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
		
	}

}
