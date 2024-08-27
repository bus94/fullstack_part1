package MVC;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== Welcome Library =====");
		System.out.println();
		
		BookMenu menu = new BookMenu();
		menu.mainMenu();
		
	}

}

/*
 * <MVC>
 * 각 개발 영역에 맞게 MVC로 구분하여
 * 각 역할에 맞게 코드를 작성할 수있는 
 * 개발 방식!
 * 
 *
 * 클라이언트
 *  - 데이터를 요청하는 컴퓨터(또는 사람 등)
 * 
 * 서버
 *  - 데이터를 보내주는 컴퓨터
 * 
 * Model
 *  - 클라이언트의 요청을 전달 받아 요청사항을 처리하는 작업
 *  - DB로 들어가서 로그인 확인
 *  - 중복 확인, 비밀번호 찾기 등의 회원가입
 * 
 * View
 *  - 웹 브라우저(화면)
 *  - Java ex) 키보드로 입력하는 것, 결과를 출력하는 println()
 * 
 * Controller
 *  - Model과 View를 연결
 *  - 요청이 들어오면 어떤 처리를 해야하는지, 어떤 Model로 보내야하는지, Model에서 결과를 받으면 어떤 View에서 출력할지 결정
 * 
 * Java에서는 컨트롤러가 Model을 포함
 * 
 */

/*
 * main 함수에서는 View 페이지로 이동할 수 있도록만 이용하고 나머지는 클래스로 작성
 * 
 */
