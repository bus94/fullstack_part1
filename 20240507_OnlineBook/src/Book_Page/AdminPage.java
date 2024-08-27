package Book_Page;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.*;

// GUI 컴포넌트(요소)
// 일반 객체를 컴포넌트로 같이 사용하기 위해선 상속을 이용해서 
// JPanel에 대한 내용을 포함해야한다.
public class AdminPage extends JPanel{
	// 생성자는 기본적으로 public 설정해둬야 다른 곳에서 사용 가능
//	LocalDateTime localTime;
	
	public AdminPage(JPanel panel) {
		Font ft = new Font("함초롬돋움", Font.BOLD, 20);
		
		setLayout(null);
		
		Rectangle rect = panel.getBounds();
		setPreferredSize(rect.getSize());
		
		// 1. 현재 시간을 기준으로 해서 도서ID 저장
		// 2. 가져온 날짜의 포맷형식을 지정한다.
		//    yyMMddhhmmss
		// 3. ISBN 문자열 뒤에 날짜를 연결한다.
		// 4. Label에 저장 후 윈도우에 추가하기
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddhhmmss");
		String strDate = formatter.format(date);
		JPanel idPanel = new JPanel();
		idPanel.setBounds(10, 100, 700, 50);
		JLabel idLabel = new JLabel("도서ID: " + "ISBN" + strDate);
		idLabel.setFont(ft);
		idPanel.add(idLabel);
		add(idPanel);
//		// 현재 시간을 기준으로 도서아이디 저장
//        LocalDateTime currentTime = LocalDateTime.now();
//        String bookId = currentTime.format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
//
//        // 현재 날짜의 포맷 형식을 지정한다.
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String isbnWithDate = "ISBN" + currentTime.format(formatter);

		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(100, 150, 700, 50);
		JLabel nameLabel = new JLabel("도서명 : ");
		nameLabel.setFont(ft);
		
		JTextField nameTextField = new JTextField(20);
		nameTextField.setFont(ft);
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		add(namePanel);

		JPanel pricePanel = new JPanel();
		pricePanel.setBounds(100, 200, 700, 50);
		JLabel priceLabel = new JLabel("가   격 : ");
		priceLabel.setFont(ft);
		JTextField priceTextField = new JTextField(20);
		priceTextField.setFont(ft);
		pricePanel.add(priceLabel);
		pricePanel.add(priceTextField);
		add(pricePanel);

		JPanel authorPanel = new JPanel();
		authorPanel.setBounds(100, 250, 700, 50);
		JLabel authorLabel = new JLabel("저   자 : ");
		authorLabel.setFont(ft);
		JTextField authorTextField = new JTextField(20);
		authorTextField.setFont(ft);
		authorPanel.add(authorLabel);
		authorPanel.add(authorTextField);
		add(authorPanel);

		JPanel descPanel = new JPanel();
		descPanel.setBounds(100, 300, 700, 50);
		JLabel descLabel = new JLabel("설   명 : ");
		descLabel.setFont(ft);
		JTextField descTextField = new JTextField(20);
		descTextField.setFont(ft);
		descPanel.add(descLabel);
		descPanel.add(descTextField);
		add(descPanel);

		JPanel categoryPanel = new JPanel();
		categoryPanel.setBounds(100, 350, 700, 50);
		JLabel categoryLabel = new JLabel("분   야 : ");
		categoryLabel.setFont(ft);
		JTextField categoryTextField = new JTextField(20);
		categoryTextField.setFont(ft);
		categoryPanel.add(categoryLabel);
		categoryPanel.add(categoryTextField);
		add(categoryPanel);

		JPanel datePanel = new JPanel();
		datePanel.setBounds(100, 400, 700, 50);
		JLabel dateLabel = new JLabel("출판일 : ");
		dateLabel.setFont(ft);
		JTextField dateTextField = new JTextField(20);
		dateTextField.setFont(ft);
		datePanel.add(dateLabel);
		datePanel.add(dateTextField);
		add(datePanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(100, 450, 700, 50);
		add(buttonPanel);
		JLabel okLabel = new JLabel("추가");
		okLabel.setFont(ft);
		JButton okButton = new JButton();
		okButton.add(okLabel);
		buttonPanel.add(okButton);
		JLabel cancelLabel = new JLabel("취소");
		cancelLabel.setFont(ft);
		JButton cancelButton = new JButton();
		cancelButton.add(cancelLabel);
		buttonPanel.add(cancelButton);
		
	}
}
