package Network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {

	public static void main(String[] args) {

		// 통신 소켓
		Socket socket = null;
		
		// 서버에서 전송되는 데이터를 읽는 Scanner
		Scanner scan = null;
		
		// 서버로 데이터를 전송하는 PrintWriter
		PrintWriter printWriter = null;
		
		try {
			// 데이터를 제공하는 서버에 접속
			System.out.println("192.168.100.40 10001포트로 접속 시도!");
			
			// 서버 IP 주소 → host, port (String host, int port)
			socket = new Socket("192.168.100.40", 10001);
			
			// 서버에서 전송되는 데이터를 수신하기 위해 수신용 객체를 생성한다.
			scan = new Scanner(socket.getInputStream()); // scan을 키보드가 아닌 소켓의 양방향 통신하는 곳을 통해 읽어들이겠다
			
			// 서버에서 전송된 데이터를 읽어서 출력한다.
			System.out.println(scan.nextLine());
			
			printWriter = new PrintWriter(socket.getOutputStream()); // 수신된 소켓의 데이터를 읽어 들이는 것
			
			// 클라이언트에서 서버로 메시지를 전송한다.
			// 반드시 문자의 끝이라는 것을 알려주기 위해 개행 문자(\n)을 붙여준다.
			printWriter.write("어련히 알아서 ~\n");
			
			// 버퍼가 가득 차지 않아도 데이터를 전송할 수 있는 메서드
			printWriter.flush(); // 원래는 버퍼가 가득 차야 데이터가 전송 됨
			
			// 클라이언트에서 전송되는 데이터를 수신하기 위해 수신용 객체를 생성한다.
			scan = new Scanner(socket.getInputStream());
			
			// 클라이언트에서 전송된 데이터를 읽어서 출력한다.
			//System.out.println(scan.nextLine());
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 예외가 발생하든 안 하든 무조건 통신한 포트
			// 스트림들은 무조건 닫는다.
			
			try {socket.close();} 
			// 예외를 무시한다.
			catch (IOException e) {}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
