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
		
	}


	@Override
	public void run() {
		// 서버가 동작해야되는 일을 작성
		try {
			serverSocket = new ServerSocket(10010);
			System.out.println("클라이언트의 접속을 기다리는 중입니다.");
			socket = serverSocket.accept();
			printWriter = new PrintWriter(socket.getOutputStream());
			input = new Scanner(socket.getInputStream());
			output = new Scanner(System.in);
			
//			System.out.println("클라이언트가 접속하였습니다.");
			printWriter.write("소통합시다!\n");
			printWriter.flush();
			
			do {
				message = input.nextLine();
				System.out.println("클라이언트: " + message);
				
				if(message.toUpperCase().equals("BYE")) {
					break;
				}
				
				System.out.print("서버: ");
				message = output.nextLine().trim();
				
				printWriter.write(message + "\n");
				printWriter.flush();
				
			}while(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
//		finally {
//			try {socket.close(); serverSocket.close();} 
//			catch (IOException e) {}
//		}
		
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		
		try {
			
			// 클라이언트에서 전송되는 메시지를 받는 스레드
			Thread th = new Thread(server);
			th.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
