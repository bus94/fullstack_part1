package NetworkChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatClient extends JFrame implements ActionListener, Runnable {

//	JPanel panel;
//	JTextArea textArea;
//	JTextField textField;
//	JButton btn;
//
//	Socket socket;
//	PrintWriter printWriter;
//	Scanner scanner;
//	String message = "";

//	MultiChatThread mt = new MultiChatThread();
//
//	public MultiChatClient() {
//		setTitle("멀티 채팅방 - 클라이언트");
//		setBounds(840, 20, 500, 700);
//
//		init();
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
//	}
//
//	private void init() {
//		textArea = new JTextArea();
//		textArea.setOpaque(true);
//		textArea.setBackground(new Color(162, 245, 230));
//		// 채팅글이 아래에서부터 올라 올 수 있도록 설정하는 메서드
//		textArea.setVerticalAlignment(JLabel.BOTTOM);
//		textArea.setEditable(false);
//		add(textArea);
//
//		panel = new JPanel();
//		panel.setLayout(new BorderLayout());
//		textField = new JTextField();
//		btn = new JButton("전송");
//		panel.add(textField);
//		panel.add(btn, BorderLayout.EAST);
//		add(panel, BorderLayout.SOUTH);
//
//		textField.addActionListener(this);
//		btn.addActionListener(this);
//
//	}
//
//	public static void main(String[] args) {
//		MultiChatClient client = new MultiChatClient();
//
//		try {
//			client.socket = new Socket("192.168.100.53", 10002);
//			client.message = "192.168.100.40 서버의 10011번 포트로 접속 시도\n";
//			client.message += client.socket + " 접속 성공!\n";
//			client.textField.requestFocus();
//
//			Thread thread = new Thread(client);
//			thread.start();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String msg = textField.getText().trim();
//
//		if (msg.length() > 0) {
//			message = mt.getName() + ": " + msg + "\n" + message;
//			textArea.setText(message);
//
//			if (printWriter != null) {
//				printWriter.write(msg + "\n");
//				printWriter.flush();
//			}
//
//			if (msg.toUpperCase().equals("BYE")) {
//				textField.setEnabled(false);
//				btn.setEnabled(false);
//			}
//		}
//		textField.setText("");
//		textField.requestFocus();
//	}
//
//	@Override
//	public void run() {
//		
//	}

	JLabel textArea;
	JPanel panel;
	JTextField textField;
	JButton button;

	Socket socket;
	PrintWriter printWriter;
	Scanner scanner;
	String message = "";

	public MultiChatClient() {
		setTitle("멀티 채팅 프로그램 - 클라이언트");
		setBounds(1000, 50, 500, 700);

		textArea = new JLabel();
		textArea.setOpaque(true);
		textArea.setBackground(new Color(162, 245, 230));

		// 채팅글이 아래에서 부터 올라 올 수 있도록 
		// 설정하는 메서드 
		textArea.setVerticalAlignment(JLabel.BOTTOM);

		add(textArea);

		panel = new JPanel(new BorderLayout());

		panel.setPreferredSize(new Dimension(500, 40));

		textField = new JTextField();
		panel.add(textField);

		button = new JButton("전송");
		panel.add(button, BorderLayout.EAST);
		add(panel, BorderLayout.SOUTH);

		//이벤트 설정 
		textField.addActionListener(this);
		button.addActionListener(this);

		// 보이기!
		setVisible(true);
	}

	public static void main(String[] args) {

		MultiChatClient client = new MultiChatClient();

		try {
			client.socket = new Socket("192.168.100.53", 10002);
			client.message = "192.168.100.53 서버의 10002번 포트로 접속 시도<br>";
			client.message += client.socket + " 접속 성공";
			client.textArea.setText("<html>" + client.message + "</html>");

			client.textField.requestFocus();

			// 송수신 객체 생성 

			client.printWriter = new PrintWriter(client.socket.getOutputStream());
			client.scanner = new Scanner(client.socket.getInputStream());

			Thread thread = new Thread(client);
			thread.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		while (socket != null) {
			String msg = "";
			try {
				msg = scanner.nextLine().trim();
			} catch (Exception e) {
				break;
			}
			if (msg.length() > 0) {
				//message += "<br>server >> " + msg;
				message += "<br>" + msg;
				textArea.setText("<html>" + message + "</html>");
				if (msg.toLowerCase().equals("bye")) {
					break;
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		textField.setEnabled(false);
		button.setEnabled(false);
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String msg = textField.getText().trim();

		if (msg.toLowerCase().equals("bye")) {
			printWriter.write("저 나가요~~~~~ 바이바이~~~~~\n");
			printWriter.write("bye\n");
			printWriter.flush();

			if (socket != null) {
				try {
					socket.close();
				} catch (IOException err) {
					err.printStackTrace();
				}
			}
			System.exit(0);

		} else if (msg.length() > 0) {
			if (printWriter != null) {
				printWriter.write(msg + "\n");
				printWriter.flush();
			}
		}
		textField.setText("");
		textField.requestFocus();

	}

}
