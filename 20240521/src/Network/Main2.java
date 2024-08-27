package Network;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main2 {
	private static MovieService movieService = new MovieService();
	private static UserService userService = new UserService();
	private static User loginUser = null;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int menu = 0;

		/*
		 * DB에 영화 정보가 있으면, 만약에 DB에 영화 정보가 없으면 init() 메서드를 실행해서 DB에 먼저 저장하고 그리고
		 * mainMenu()
		 * 
		 */

		while (true) {
			mainMenu();
			return;
		}

	}

	public static void mainMenu() {
		/*
		 * 1. 영화 목록 보기 2. 로그인 3. 회원가입 4. 영화 예매
		 */
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		
		while (true) {
			System.out.println("========== < 영  화 > ==========");
			System.out.println("1. 영화 목록 보기");
			System.out.println("2. 로그인");
			System.out.println("3. 회원가입");
			System.out.println("4. 영화 예매");
			System.out.println("0. 종료");
			System.out.print("메뉴 입력: ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				break;

			case 2:
				sc.nextLine();
				System.out.println("로그인 정보를 입력하세요.");
				System.out.print("ID: ");
				String id = sc.nextLine();
				System.out.print("PW: ");
				String password = sc.nextLine();
				loginUser = userService.login(id, password);
				break;

			case 3:
				mainSignUp();
				break;

			case 4:
				if(loginUser != null) {
					reservation();
				} else {
					System.out.println("로그인을 해주세요.");
				}
				break;

			default :
				if (menu > 4 || menu < 0) {
					System.out.println("잘못 입력하셨습니다.\n메뉴를 다시 입력해주세요.");
				} else {
					System.out.println("시스템이 종료됩니다.");
					return;
				}
			}

		}
	}
	
	private static void reservation() {
		System.out.println("========== < 티  켓 > ==========");
		
	}

	public static void mainSignUp() {
		Scanner sc = new Scanner(System.in);
		UserDAO dao = new UserDAO();
		
		System.out.println("회원가입 할 정보를 입력해주세요.");
		System.out.print("이름: ");
		String nameSignUp = sc.nextLine();
		System.out.print("ID: ");
		String idSignUp = sc.nextLine();
		boolean result = dao.selectByUser(idSignUp);
		if(!result) {
			return;
		}
		
		System.out.print("PW: ");
		String passwordSignUp = sc.nextLine();
		System.out.print("전화번호: ");
		String phoneSignUp = sc.nextLine();
		System.out.print("이메일: ");
		String emailSignUp = sc.nextLine();
		System.out.print("생년월일(yymmdd): ");
		String birthDateSignUp = sc.nextLine();
		
		User user = new User(nameSignUp, idSignUp,
				passwordSignUp, phoneSignUp,
				emailSignUp, birthDateSignUp);
				
		userService.signUp(user);
		
	}

	// 만약 DB에 데이터가 없다면 init() 메서드를 이용해서 영화 정보를 웹에서 가져오는 메서드
	public static void init() {
		// 자바에서 네트워크 통신을 이용해서 직접 읽어들여 데이터 분리하기
		// 분리한 것을 클래스에 저장해서 DB에 저장

		try {
			// 1. url을 만들기 위한 문자열 객체가 필요하다 (?까지가 url인 것)
			StringBuilder urlBuilder = new StringBuilder(
					"https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?");

			// 2. api의 요청할 때 같이 저장하는 변수의 값들을 저장 해야된다. 발급키
			// - 영문자나 숫자는 상관 없는데 한글 같은 경우에는 url에 보내면 1byte 단위로 변환하기 때문에 한글은 에러를 발생할 수 있다.
			// UTF-8 (인코딩 방식) 이용
			// *주의 * 공백은 있으면 안 된다!!
			urlBuilder.append(URLEncoder.encode("key", "UTF-8") + "=f5eef3421c602c6cb7ea224104795888");
			urlBuilder.append(
					"&" + URLEncoder.encode("targetDt", "UTF-8") + "=" + URLEncoder.encode("20240520", "UTF-8"));

			// 3. URL 객체 생성 (문자열 타입만 받기 때문에 toString() 사용)
			URL url = new URL(urlBuilder.toString());

			// 4. 요청하고자 하는 URL 통신하기 위한 Connection 객체 생성
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// 5. 통신을 위한 메서드(전송방식)
			// get: url에 내가 작성한 변수값들이 모두 보인다.
			// post: url만 보인다.
			conn.setRequestMethod("GET"); // GET 방식

			// 6. 통신 응답 코드 확인
			System.out.println("응답 코드: " + conn.getResponseCode());

			// 7. 만약 에러코드가 발생할 경우 꺼내오는 작업을 하면 안된다.
			BufferedReader rd; // 읽어오는 버퍼 선언하되 응답되면 객체 생성한다.

			// 정상 통신시 200 출력
			if (conn.getResponseCode() == 200) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			// 8. 저장된 데이터를 라인 별로(한 줄씩) 읽어들이기
			StringBuilder sb = new StringBuilder();
			String line;

			// reaLine() 메서드의 한 줄씩 읽어온다.
			// 문자가 저장되는데 다음 읽을 데이터가 없으면 null
			while (true) {
				line = rd.readLine();

				// 만약 line이 null이면 읽어올 것이 없다는 것
				if (line == null) {
					break;
				} else {
					// sb 변수에 추가하기
					sb.append(line);
				}
			}

			// 9. 객체 해제(닫기)
			rd.close();
			conn.disconnect();

			// 10. 전달된 데이터 확인
			System.out.println(sb.toString());

			// 11. 전달된 데이터를 이용해서 클래스에 저장하는 내용을 작성하기
			// MovieService로 넘겨서 insert() 메서드 안에서 데이터를 ArrayList타입으로 저장하고 MovieDao로 넘겨서 DB에
			// 저장하기
			movieService.insert(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
