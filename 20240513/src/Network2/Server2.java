package Network2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {

	public static void main(String[] args) {

		// 1. 1:1 혹은 양방향 통신을 하기 위해서 서버(데이터를 제공하는 컴퓨터)를 내 컴퓨터에 생성
		ServerSocket server = null;
		Socket socket = null;
		Scanner input = null;
		Scanner output = null;
		PrintWriter printWriter = null;
		
		try {
			server = new ServerSocket(10006);
			System.out.println("클라이언트 기다리는 중...");
			
			socket = server.accept();
			
			// 데이터를 송수신에 사용할 객체를 생성
			printWriter = new PrintWriter(socket.getOutputStream());
			
			// 데이터 읽기
			input = new Scanner(socket.getInputStream());
			
			// 데이터 보내기
			output = new Scanner(System.in);
			
			// 클라이언트가 서버에 접속했을 때 환영인사 메시지
			System.out.println("클라이언트 접속 확인!");
			printWriter.write("어서와~\n");
			
			// 메시지 전송
			printWriter.flush();
			
			// 키보드로 입력한 메시지 또는 클라이언트가 보내온 메시지 중에서 BYE면 통신 끝낸다.
			String msg = "";
			
			do {
				// 클라이언트에서 전송된 메시지를 출력한다.
				msg = input.nextLine();
				System.out.println("client >> " + msg);
				
				// → BYE면 반복문을 탈출하고, 아니면 반복문 실행
				if(msg.toUpperCase().equals("BYE")) {
					break;
				}
				
				// 만약 BYE가 아니면 클라이언트한테 보내는 메시지 입력하기
				System.out.print("server >> ");
				msg = output.nextLine().trim();
				
				// 입력받은 메세지를 클라이언트에게 전송
				printWriter.write(msg + "\n");
				printWriter.flush();
				
			}while(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		finally {
//			try {socket.close(); server.close();} 
//			catch (IOException e) {}
//		}
		
	}

}

/*
 * TCP - ex) 카톡 메세지
 * - 연결 기반 연결 후 통신(전화기) 1:1 통신 방식
 * - 데이터의 경계 구분 안함
 * - 신뢰성 있는 데이터 전송 가능
 * 
 * UDP - ex) 다운로드
 * - 비연결 기반 통신, 연결 없이 통신(택배)
 *
 * Port
 * - IP로 컴퓨터를 찾아가서 어떤 프로그램을 실행시킬지 선택하는 역할
 * 
 * 
 */
