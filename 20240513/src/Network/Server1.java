package Network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

	public static void main(String[] args) {

		/*
		 * Socket 클래스
		 * 
		 * TCP 통신 : 연결 기반 프로토콜 (전화)
		 * 
		 * 데이터를 보내는 쪽(보통 클라이언트)에서 객체를 생성하여 데이터를 받는 쪽(서버)에서 클라이언트 요청을 받으면 요청에 대한 Socket
		 * 객체를 생성하여 데이터를 처리한다.
		 * 
		 */

		// 서버 소켓 (연결만 받는다)
		// 소켓 (데이터를 주고 받는 역할)

		// 서버 소켓 생성
		ServerSocket server = null;

		// 통신 소켓 생성
		Socket socket = null; // 택배 박스와 같은 의미

		// 클라이언트가 전송한 소켓의 데이터를 읽는 스캐너 생성
		Scanner scan = null;

		// 클라이언트에게 데이터를 전송하는 객체
		PrintWriter printWriter = null; // 문자에 대한 데이터 관련된 객체

		try {
			// 서버 만들기
			// 192.168.100.40의 IP 주소를 가지는 10001번 포트를 열어 서버 소켓을 생성한다.
			server = new ServerSocket(10001);
			System.out.println("서버시작: " + server); // server 출력: ServerSocket[addr=0.0.0.0/0.0.0.0,localport=10001]
			
			// 클라이언트가 접속하기를 무한정 기다린다.
			// accept() 메소드는 지정한 포트로 클라이언트가 접속하기를 무한 대기한다.
			socket = server.accept(); // 클라이언트가 접속하면 실행 // accept: 받아들이다
			System.out.println("클라이언트 접속 확인");
			
			// 서버에서 클라이언트에게 데이터를 전송용 객체를 만든다.
			printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("어서와~\n");
			printWriter.flush();
			
			scan = new Scanner(socket.getInputStream());
			System.out.println(scan.nextLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 클라이언트와 통신이 종료되면 통신에 사용된 서버 소켓과 소켓을 닫는다.
			try {
				socket.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
/*
 * 0.0.0.0 : 모든 IP의 접속을 다 받는다는 의미
 * 
 * 
 * 포트 사용 중인지 확인하고 싶은 경우
 * 명령프롬프트 → netstat
 * 
 * java.net.BindException
 * - 포트 번호를 누군가 사용하고 있는 것! 중복되는 포트 번호 에러
 * → 에러 해결 방법: 포트 번호를 변경
 *
 */


