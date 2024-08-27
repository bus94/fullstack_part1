package NetworkWithTeacher;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

	private static MovieService movieService = new MovieService();
	private static UserService userService = new UserService();
	private static TicketService ticketService = new TicketService();
	private static Scanner sc = new Scanner(System.in);
	private static User loginUser = null;

	public static void main(String[] args) {

		int menu = 0;

		// 만약 데이터베이스에 정보가 있다면
		// 밑에 if문을 실행할 이유가 없다.
		// 데이터가 없다면 init()실행해야되니
		// 조건을 not 연산자를 이용해서 뒤집는다.
		try {
			if (!hasMovieData()) {

				init();
			}

			while (true) {

				mainMenu();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 데이터가 있는지 확인하는 메서드
	public static boolean hasMovieData() throws Exception {

		return movieService.hasMovieData();
	}

	public static void mainMenu() throws Exception {

		/**
		 * 1. 영화 목록 보기 2. 로그인 3. 회원가입 4. 영화 예매
		 */

		System.out.println("=== Main Menu ===");
		System.out.println("1. 영화 목록 보기");
		System.out.println("2. 로그인");
		System.out.println("3. 회원가입");
		System.out.println("4. 영화 예매");
		System.out.println("5. 구매 목록");
		System.out.println("0. 종료");
		System.out.print("메뉴를 선택하세요: ");

		int menu = sc.nextInt();
		sc.nextLine(); // 줄바꿈 문자 제거

		switch (menu) {
		case 1:

			break;
		case 2:
			login();
			break;
		case 3:
			join();
			break;
		case 4:
			reservation();
			break;
		case 5:
			buylist();
			break;
		case 0:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			break;
		}

	}

	// 예매 목록 조회
	private static void buylist() throws Exception{
		// 예매 목록을 출력할 때 티켓을 예매한 사람의 이름을 출력
		ticketService.select();
	}

	// 예매를 하는 메서드
	private static void reservation() throws Exception {
		if (loginUser != null) {
			// 영화 이름을 가지고 와서 출력
			ArrayList<Movie> movieList = movieService.select();

			// isEmpty() 안에 데이터가 있는지 확인
			// 비었다면 true, 데이터가 있다면 false
			if (movieList != null && !movieList.isEmpty()) {
				// ex) %-5s : 왼쪽부터 5칸에 문자열을 대입
				System.out.printf("%-5s     %-30s %-15s%n", "순위", "영화명", "개봉일");
				System.out.println("----------------------------------------------------------");

				for (Movie movie : movieList) {
					System.out.printf("%-5s %-30s %-15s%n", movie.getRank(), movie.getMovieNm(), movie.getOpenDt());
				}

				// 티켓 구매 시 입력할 데이터
				System.out.print("영화명: ");
				String name = sc.nextLine();

				System.out.print("시간 ex)5월 16일 오후 7시 : ");
				String time = sc.nextLine();

				System.out.print("인원 수: ");
				int count = sc.nextInt();

				sc.nextLine();
				System.out.print("좌석 입력 ex)G열 12 : ");
				String seat = sc.nextLine();

				boolean result = ticketService.insert(new Ticket(loginUser.getId(), name, time, count, seat));

				if (result) {
					System.out.println("정상적으로 예매 완료하였습니다.");
				} else {
					System.out.println("예매를 실패하였습니다.");
				}

			} else {
				System.out.println("영화 정보가 없습니다.");
			}

		} else {
			// loginUser 변수가 null 이면 로그인 안되었기 때문에 예외 메시지 띄우기
			System.out.println("로그인을 먼저 하세요.");
		}

	}

	// 로그인 하는 메서드
	private static void login() throws Exception {
		System.out.print("아이디를 입력: ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력: ");
		String password = sc.nextLine();

		User result = userService.login(id, password);

		if (result != null) {
			loginUser = result;
			System.out.println("로그인 성공");
		} else {
			System.out.println("아이디 또는 비밀번호를 확인하세요");
		}
	}

	// 회원가입 시 입력 받는 메서드
	private static void join() throws Exception {
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("아이디를 입력하세요: ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요: ");
		String password = sc.nextLine();
		System.out.print("폰번호를 입력하세요: ");
		String phoneNumber = sc.nextLine();
		System.out.print("이메일을 입력하세요: ");
		String email = sc.nextLine();
		System.out.print("생년월일을 입력하세요 (YYYY-MM-DD): ");
		String birthDate = sc.nextLine();

		User user = new User(name, id, password, phoneNumber, email, birthDate);

		boolean result = userService.join(user);

		if (result) {
			// 팝업
			System.out.println("회원가입 성공했습니다.");
		} else {
			System.out.println("회원가입 실패했습니다.");
		}

	}

	public static void init() {

		// 자바에서 네트워크 통신을 이용해서
		// 직접 읽어 드려서 데이터 분리할 것!
		// 클래스에 저장해서 DB에 저장

		try {

			// 1.url을 만들기 위한 문자열 객체가
			// 필요하다!
			StringBuilder urlBuilder = new StringBuilder(
					"http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?");

			// 2. api의 요청할 때 같이 저장하는
			// 변수의 값들을 저장 해야된다. 발급키
			// 영문자나 숫자는 상관없는데 한글 같은 경우에는
			// url에 보내면 1byte단위로 변환하기 때문에
			// 한글을 에러 발생할 수있다. utf-8
			urlBuilder.append(URLEncoder.encode("key", "UTF-8") + "=f5eef3421c602c6cb7ea224104795888");
			urlBuilder.append(
					"&" + URLEncoder.encode("targetDt", "UTF-8") + "=" + URLEncoder.encode("20240520", "UTF-8"));

			// 3. URL객체 생성
			URL url = new URL(urlBuilder.toString());

			// 4. 요청하고자 하는 URL통신하기 위한
			// Connection 객체 생성
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// 5. 통신을 위한 메서드(전송방식)
			// get url에 내가 작성한 변수값들이 모두 보인다.
			// post url만 보임
			conn.setRequestMethod("GET");

			// 6. 통신 응답 코드 확인
			System.out.println("응답 코드: " + conn.getResponseCode());

			// 7. 만약 에러코드가 발생할 경우는 꺼내오는 작업
			// 을 하면 안된다.
			BufferedReader rd;

			// 정상통신시 200이 온다!
			if (conn.getResponseCode() == 200) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			// 9. 저장된 데이터를 라인별로(한 줄씩 ) 읽어드리기
			StringBuilder sb = new StringBuilder();
			String line;

			// readLine() 메서드의 한줄씩 읽어온다.
			// 문자가 저장되는데 다음 읽을 데이터가 없으면
			// null
			while (true) {
				line = rd.readLine();

				// 만약 line이 null이면 반복멈춘다.
				if (line == null) {
					break;
				}
				// sb변수에 추가하기
				sb.append(line);
			}

			// 10. 객체 해제(닫기)
			rd.close();
			conn.disconnect();

			// 11. 전달된 데이터 확인
			System.out.println(sb.toString());

			// 12. 전달된 데이터를 이용해서 클래스에
			// 저장하는 내용을 작성하기!

			// movieservice로 넘겨서
			// insert() 메서드 안에서 데이터를
			// ArrayList타입으로 저장하고
			// movieDao로 넘겨서 데이터베이스에
			// 저장되는 것 까지!

			movieService.insert(sb.toString());
		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}

//import java.io.*;
//import java.net.*;
//import java.util.Scanner;
//
//public class Main2 {
//	private static MovieService movieService = new MovieService();
//	private static UserService userService = new UserService();
//
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		int menu = 0;
//
//		/*
//		 * DB에 영화 정보가 있으면, 만약에 DB에 영화 정보가 없으면 init() 메서드를 실행해서 DB에 먼저 저장하고 그리고
//		 * mainMenu()
//		 * 
//		 */
//
//		// 만약 DB에 정보가 있다면 밑의 if문을 실행할 필요 없다.
//		// 만약 DB에 정보가 없다면 밑의 if문을 통해 init()을 (init(): DB에 정보 추가)
//		//
//		try {
//			if (!hasMovieData()) {
//				init();
//			}
//
//			while (true) {
//				mainMenu();
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	//
//	public static boolean hasMovieData() throws Exception {
//		return movieService.hasMovieData();
//	}
//
//	public static void mainMenu() {
//		/*
//		 * 1. 영화 목록 보기 2. 로그인 3. 회원가입 4. 영화 예매
//		 */
//		Scanner sc = new Scanner(System.in);
//		int menu = 0;
//
//		while (true) {
//			System.out.println("========== < 영  화 > ==========");
//			System.out.println("1. 영화 목록 보기");
//			System.out.println("2. 로그인");
//			System.out.println("3. 회원가입");
//			System.out.println("4. 영화 예매");
//			System.out.print("메뉴 입력: ");
//			menu = sc.nextInt();
//
//			switch (menu) {
//			case 1:
//				break;
//
//			case 2:
//				System.out.println("로그인 정보를 입력하세요.");
//				System.out.print("ID: ");
//				String id = sc.nextLine();
//				System.out.print("PW: ");
//				String password = sc.nextLine();
//				userService.login(id, password);
//				break;
//
//			case 3:
//				mainSignUp();
//				break;
//
//			case 4:
//				break;
//
//			default:
//				if (menu > 4 || menu < 1) {
//					System.out.println("잘못 입력하셨습니다.\n메뉴를 다시 입력해주세요.");
//				}
//			}
//
//		}
//	}
//
//	public static void mainSignUp() {
//		Scanner sc = new Scanner(System.in);
//		UserDAO dao = new UserDAO();
//
//		System.out.println("회원가입 할 정보를 입력해주세요.");
//		System.out.print("이름: ");
//		String nameSignUp = sc.nextLine();
//		System.out.print("ID: ");
//		String idSignUp = sc.nextLine();
//		boolean result = dao.selectByUser(idSignUp);
//		if (!result) {
//			return;
//		}
//
//		System.out.print("PW: ");
//		String passwordSignUp = sc.nextLine();
//		System.out.print("전화번호: ");
//		String phoneSignUp = sc.nextLine();
//		System.out.print("이메일: ");
//		String emailSignUp = sc.nextLine();
//		System.out.print("생년월일(yymmdd): ");
//		String birthDateSignUp = sc.nextLine();
//
//		User user = new User(nameSignUp, idSignUp, passwordSignUp, phoneSignUp, emailSignUp, birthDateSignUp);
//
//		userService.signUp(user);
//
//	}
//
//	// 만약 DB에 데이터가 없다면 init() 메서드를 이용해서 영화 정보를 웹에서 가져오는 메서드
//	public static void init() {
//		// 자바에서 네트워크 통신을 이용해서 직접 읽어들여 데이터 분리하기
//		// 분리한 것을 클래스에 저장해서 DB에 저장
//
//		try {
//			// 1. url을 만들기 위한 문자열 객체가 필요하다 (?까지가 url인 것)
//			StringBuilder urlBuilder = new StringBuilder(
//					"https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?");
//
//			// 2. api의 요청할 때 같이 저장하는 변수의 값들을 저장 해야된다. 발급키
//			// - 영문자나 숫자는 상관 없는데 한글 같은 경우에는 url에 보내면 1byte 단위로 변환하기 때문에 한글은 에러를 발생할 수 있다.
//			// UTF-8 (인코딩 방식) 이용
//			// *주의 * 공백은 있으면 안 된다!!
//			urlBuilder.append(URLEncoder.encode("key", "UTF-8") + "=f5eef3421c602c6cb7ea224104795888");
//			urlBuilder.append(
//					"&" + URLEncoder.encode("targetDt", "UTF-8") + "=" + URLEncoder.encode("20240520", "UTF-8"));
//
//			// 3. URL 객체 생성 (문자열 타입만 받기 때문에 toString() 사용)
//			URL url = new URL(urlBuilder.toString());
//
//			// 4. 요청하고자 하는 URL 통신하기 위한 Connection 객체 생성
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//			// 5. 통신을 위한 메서드(전송방식)
//			// get: url에 내가 작성한 변수값들이 모두 보인다.
//			// post: url만 보인다.
//			conn.setRequestMethod("GET"); // GET 방식
//
//			// 6. 통신 응답 코드 확인
//			System.out.println("응답 코드: " + conn.getResponseCode());
//
//			// 7. 만약 에러코드가 발생할 경우 꺼내오는 작업을 하면 안된다.
//			BufferedReader rd; // 읽어오는 버퍼 선언하되 응답되면 객체 생성한다.
//
//			// 정상 통신시 200 출력
//			if (conn.getResponseCode() == 200) {
//				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			} else {
//				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//			}
//
//			// 8. 저장된 데이터를 라인 별로(한 줄씩) 읽어들이기
//			StringBuilder sb = new StringBuilder();
//			String line;
//
//			// reaLine() 메서드의 한 줄씩 읽어온다.
//			// 문자가 저장되는데 다음 읽을 데이터가 없으면 null
//			while (true) {
//				line = rd.readLine();
//
//				// 만약 line이 null이면 읽어올 것이 없다는 것
//				if (line == null) {
//					break;
//				} else {
//					// sb 변수에 추가하기
//					sb.append(line);
//				}
//			}
//
//			// 9. 객체 해제(닫기)
//			rd.close();
//			conn.disconnect();
//
//			// 10. 전달된 데이터 확인
//			System.out.println(sb.toString());
//
//			// 11. 전달된 데이터를 이용해서 클래스에 저장하는 내용을 작성하기
//			// MovieService로 넘겨서 insert() 메서드 안에서 데이터를 ArrayList타입으로 저장하고 MovieDao로 넘겨서 DB에
//			// 저장하기
//			movieService.insert(sb.toString());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
