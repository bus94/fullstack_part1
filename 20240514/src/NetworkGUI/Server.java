package NetworkGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 다중 상속 불가능! (run() 메서드 사용을 위해 Thread도 상속 하고 싶지만 불가)
// run() 메서드 하나만 구현한 인터페이스: Runnable
public class Server extends JFrame implements ActionListener, Runnable {

	JTextArea textArea;
	JPanel panel;
	JTextField textField;
	JButton btn;

	ServerSocket serverSocket;
	Socket socket;
	PrintWriter printWriter;
	Scanner input;
	Scanner output;
	Scanner scanner;
	String message = ""; // 보낼 메세지

	public Server() {
		setTitle("1:1 채팅 프로그램 - 서버");
		setBounds(100, 20, 500, 700);

		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void init() {

		textArea = new JTextArea();
		textArea.setBackground(new Color(162, 245, 230));

		textArea.setEditable(false);
		add(textArea);

		panel = new JPanel();
		panel.setLayout(new BorderLayout());

		textField = new JTextField();
		btn = new JButton("전송");
		panel.add(textField);
		panel.add(btn, BorderLayout.EAST);

		add(panel, BorderLayout.SOUTH);

		textField.addActionListener(this);
		btn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = textField.getText().trim();
		if(msg.length() > 0) {
			message =  "서버: " + msg + "\n" + message;
			textArea.setText(message);
			
			if(printWriter != null) {
				printWriter.write(msg + "\n");
				printWriter.flush();
			}
			
			if(msg.toUpperCase().equals("BYE")) {
				textField.setEnabled(false);
				btn.setEnabled(false);
			}
		}
		textField.setText("");
		textField.requestFocus();
	}


	@Override
	public void run() {
		// 서버가 동작해야되는 일을 작성
		// 클라이언트가 통신을 유지하고 있는 동안 반복
		while(socket != null) {
			// 클라이언트가 메시지를 보낸 걸 읽기
			String msg = "";
			msg = scanner.nextLine().trim();
			
			// 서버 창에 표시한다.
			if(msg.length() > 0) {
				message = "클라이언트: " + msg + "\n" + message;
				textArea.setText(message);
				
				if(msg.toUpperCase().equals("BYE")) {
					break; // 통신 종료
				}
			}
			// 위에 있는 내용을 확인하기 위해서 프로그램을 약간 지연시킨다.
			try {Thread.sleep(100);} 
			catch (InterruptedException e) {e.printStackTrace();}
		}
		// 클라이언트와 통신이 종료되면 메시지를 입력할 수 없도록 비활성화 시킨다.
		textField.setEnabled(false);
		btn.setEnabled(false);
		
		// socket 닫기
		try {socket.close();} 
		catch (IOException e) {e.printStackTrace();}
		
		
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		
		try {
			// 어떤 클라이언트든 접속을 허용한다. 그리고 접속 포트를 생성한다.
			server.serverSocket = new ServerSocket(10011);
			server.message = "어떤 클라이언트가 들어올까? 10011번 포트로 서버 시작\n";
			server.textArea.setText(server.message);

			// 클라이언트가 접속하기 전에는 텍스트 필드와 전송 버튼을 비활성화 시킨다.
			server.textField.setEnabled(false);
			server.btn.setEnabled(false);
			
			// 클라이언트의 접속을 기다린다.
			server.socket = server.serverSocket.accept();
			server.message += server.serverSocket + " 접속 성공!\n";
			server.textArea.setText(server.message);
			
			// 클라이언트가 접속했으므로 텍스트 필드와 전송 버튼을 활성화(true) 변경
			// 메시지를 입력 할 수 있도록 텍스트 필드로 포커스를 옮겨준다.
			server.textField.setEnabled(true);
			server.btn.setEnabled(true);
			server.textField.requestFocus();
			
			// 클라이언트와 메시지를 주고 받기 위해서 송수신 객체 생성
			server.printWriter = new PrintWriter(server.socket.getOutputStream());
			server.scanner = new Scanner(server.socket.getInputStream());
			
			// 클라이언트에서 전송되는 메시지를 받는 스레드
			Thread th = new Thread(server);
			th.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
