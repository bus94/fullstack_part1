package NetworkChat;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiChatServer {

	public static void main(String[] args) {

		// 실질적으로 서버 소켓만 생성
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(10002);
			System.out.println("서버가 시작 되었습니다.");
			
			// 서버가 실행 중인 상태에서 서버에 접속하는 모든 클라이언트들의 접속을 받아야 하므로 무한 반복을 돌린다.
			while(true) {
				// 클라이언트가 접속 될 때 마다 독립된 통신 소켓을 생성
				// accept() - 접속을 기다리는 역할 뿐만 아니라 클라이언트가 접속하면 새로운 소켓 객체를 생성해서 반환한다.
				Socket socket = serverSocket.accept();
				
				// 서버에는 클라이언트 접속만 받아주고 실제 특정 클라이언트에게 전송받은 메시지를 
				// 모든 클라이언트에게 전송하는 작업은 스레드에서 처리한다.
				
				// 클라이언트가 서버에 접속 될 때 마다 스레드가 1개씩 생성된다.
				// 스레드가 실행할 때마다 클라이언트 소켓 객체를 넘겨준다.
//				Thread th = (MultiChatThread) new MultiChatThread(socket);
				Thread th = new MultiChatThread(socket);
				th.start();
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
