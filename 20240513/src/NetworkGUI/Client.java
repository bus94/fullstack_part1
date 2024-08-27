package NetworkGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener, Runnable { // ActionListener : 버튼 클릭 했을 때 이벤트 발생에 대한 인터페이스
																			// 설정
	// 전체 대화를 출력하는 영역
	JTextArea textArea;
	// 대화 내용을 입력하는 텍스트 필드와 전송 버튼을 올릴 패널
	JPanel panel;
	// 대화 내용을 입력하는 텍스트 필드와 전송하는 버튼
	JTextField textField;
	JButton btn;

	// 데이터를 주고 받을 수 있는 소켓 통신을 사용
	Socket socket;
	PrintWriter printWriter;
	Scanner input;
	Scanner output;
	String message = ""; // 보낼 메세지

	public Client() {
		setTitle("1:1 채팅 프로그램 - 클라이언트");
		setBounds(840, 20, 500, 700);

		init(); // 실제 채팅방을 구성하는 컴포넌트

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void init() {

		textArea = new JTextArea();
		textArea.setBackground(new Color(162, 245, 230));

		// 텍스트 영역을 편집 불가능
		textArea.setEditable(false);
		add(textArea);

		// 영역을 나누는 패널은 기본 배치가 FlowLayout()인 한 줄로 보여준다.
		panel = new JPanel();
		// BorderLayout
		// - 5개의 영역(동,서,남,북,가운데)에 한 영역 당 하나의 컴포넌트만 지정할 수 있다.
		// - 하나의 컴포넌트 공간을 여러 개로 쪼개서 사용하려고 패널을 생성
		panel.setLayout(new BorderLayout());

		// 패널의 영역을 조절(사이즈)
		textField = new JTextField();
		btn = new JButton("전송");
		panel.add(textField); // 그냥 설정하면 가운데로 배치됨
		panel.add(btn, BorderLayout.EAST);

		add(panel, BorderLayout.SOUTH);

		// 텍스트 필드와 전송 버튼을 눌렀을 때 이벤트 실행
		textField.addActionListener(this);
		btn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		while (true) {
			String msg = "";
			System.out.print("클라이언트: ");
			message = input.nextLine().trim();
			printWriter.write(message + "\n");
			printWriter.flush();
			msg = "클라이언트: " + message;
			textArea.setText(msg);

			// 서버에서 BYE라는 문자가 오면
			// 반복문 종료하고 채팅창을 종료시킨다.
			if (message.toUpperCase().equals("BYE")) {
				break;
			}
			message = output.nextLine();
			System.out.println("서버: " + message);
			msg = "서버: " + message;
			textArea.setText(msg);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void run() {
		// 클라이언트가 실행해야될 문장
		// - 서버와 통신 유지한다는 내용
		// - 서버에서 언제 메시지를 보내 올지 모르기 때문에 통신이 종료될 때까지 반복하며 서버에서 전송되는 메시지를 스레드로 받는다.

		// 서버와 통신 유지되고 있는 동안 반복한다.
		// 서버에서 전송되는 메시지를 받는다.
		// 서버가 보낸 메시지 - 스캐너를 이용해서 메시지를 읽는다.
		// InputStream() 동작!

		// 서버에서 전송된 메시지를 클라이언트 채팅창에 표시한다.
		try {
			socket = new Socket("192.168.100.40", 10010);
			System.out.println(socket + "에 접속였습니다.");
			

			printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("접속하였습니다.\n");
			printWriter.flush();
			// 클라이언트 입장에선 입력해서 보내야할 내용이면서
			// 서버 입장에선 받아서 확인해야할 내용 - 서버 기준으로 input 변수 선언함(헷갈리지 않도록)
			input = new Scanner(System.in);
			output = new Scanner(socket.getInputStream());
			System.out.println(output.nextLine());

//			while (socket != null) {
//				textArea.setText(message);
//
//				System.out.print("클라이언트: ");
//				message = input.nextLine().trim();
//				printWriter.write(message + "\n");
//				printWriter.flush();
//				
//				// 서버에서 BYE라는 문자가 오면
//				// 반복문 종료하고 채팅창을 종료시킨다.
//				if (message.toUpperCase().equals("BYE")) {
//					break;
//				}
//				message = output.nextLine();
//				System.out.println("서버: " + message);
//				
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 서버와 통신이 종료되면 메시지를 입력할 수 없도록 텍스트 필드와 전송 버튼을 비활성화시킨다.
		textField.setEnabled(false);
		btn.setEnabled(false);

		// 통신에 사용한 모든 객체를 맏는다.
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Client client = new Client();

		try {

			Thread th = new Thread(client);
			th.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
