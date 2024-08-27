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
	Scanner scanner;
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
		// 전송 버튼을 눌렀을 때 텍스트 필드에 입력된 메시지를 받는다.
		String msg = textField.getText().trim();
		
		// 텍스트 필드에 미시지가 입력된 상태일 경우 메시지를 클라이언트 채팅창에 표시하고 서버로 전송한다.
		// 문자가 있으면 보내고, 없으면 안 보낸다.
		if(msg.length() > 0) {
			// 텍스트 필드에 입력한 메시지를 클라이언트 채팅창에 표시한다.
			message = "클라이언트: " + msg + "\n" + message;
			textArea.setText(message);
			
			// 서버로 전송
			if(printWriter != null) {
				printWriter.write(msg + "\n");
				printWriter.flush();
			}
			
			if(msg.toUpperCase().equals("BYE")) {
				textField.setEnabled(false);
				btn.setEnabled(false);
			}
		}
		
		// 다음 메시지를 입력 받기 위해서 텍스트 필드에 입력된 메시지를 지우고 다시 입력할 수 있도록 포커스를 텍스트 필드로 이동한다.
		textField.setText("");
		textField.requestFocus();
		
//		while (socket != null) {
//			String msg = "";
//			System.out.print("클라이언트: ");
//			message = input.nextLine().trim();
//			printWriter.write(message + "\n");
//			printWriter.flush();
//			msg = "클라이언트: " + message;
//			textArea.setText(msg);
//
//			// 서버에서 BYE라는 문자가 오면
//			// 반복문 종료하고 채팅창을 종료시킨다.
//			if (message.toUpperCase().equals("BYE")) {
//				break;
//			}
//			message = output.nextLine();
//			System.out.println("서버: " + message);
//			msg = "서버: " + message;
//			textArea.setText(msg);
//
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
//		}

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
					
//			printWriter = new PrintWriter(socket.getOutputStream());
//			printWriter.write("접속하였습니다.\n");
//			printWriter.flush();
//			// 클라이언트 입장에선 입력해서 보내야할 내용이면서
//			// 서버 입장에선 받아서 확인해야할 내용 - 서버 기준으로 input 변수 선언함(헷갈리지 않도록)
//			input = new Scanner(System.in);
//			output = new Scanner(socket.getInputStream());
//			System.out.println(output.nextLine());
			
			while(socket != null) {
				String msg = scanner.nextLine().trim();
				
				if(msg.length() > 0) {
					message = "서버: " + msg + "\n" + message;
					textArea.setText(message); // 메시지로 textArea에 넣어줘야 한다.
					
					if(msg.toUpperCase().equals("BYE")) {
						break;
					}
				}
				
				try {Thread.sleep(100);}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

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
			// 서버에 접속한다.
			client.socket = new Socket("192.168.100.40", 10011);
			client.message = "192.168.100.40 서버의 10011번 포트로 접속 시도\n";
			client.message += client.socket + " 접속 성공!\n";
			
			// text Area에 수정하기
			client.textArea.setText(client.message);
			
			// 서버에 접속했으므로 메시지를 입력할 수 있도록 텍스트 필드로 포커스(커서)를 이동한다.
			client.textField.requestFocus();
			
			// 서버와 메시지를 주고 받을 송수신 객체를 생성한다.
			client.printWriter = new PrintWriter(client.socket.getOutputStream());
			
			// 서버가 보내온 메시지를 클라이언트가 읽는다.
			client.scanner = new Scanner(client.socket.getInputStream());
			
			// 서버에서 전송되는 메시지를 받는 스레드를 실행한다.
			// 이미 클라이언트가 JFrame 클래스를 상속받아서 Thread 클래스 객체를 상속할 수 없어서 인터페이스를 구현했고,
			// start 메서드가 없기에 Thread 객체를 따로 생성해서 인터페이스가 가지고 있는 run() 메서드를 넘겨준다.
			Thread th = new Thread(client);
			th.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

// *보낼 때의 메시지가 BYE라면 Client에서도 버튼 비활성화 시킬 수 있도록 작성하기*
// *85번째 줄을 수정하면 아래로 글을 써내려 갈 수 있지 않을까?
