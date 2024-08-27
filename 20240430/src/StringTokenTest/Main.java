package StringTokenTest;

/*
 * String을 불변으로 설정한 이유
 * 1. 힙영역의 메모리공간을 절약하기 위해서 한 번 저장된 문자를 기억(캐싱)
 * 2. 보안
 * 		데이터베이스의 사용자 이름, 정보 , 암호를
 * 		연결하기 위해서 수신할 때 문자열로 전달되는데
 * 		그 사이 번지수의 문자열 값이 변경될 수 있다.
 * 		변경이 되면 해커가 참조 값을 변경해서 
 * 		보안적 문제를 유발할 수 있다
 * 
 */

public class Main {

	public static void main(String[] args) {
		
		new TokenMenu().mainMenu();
		
	}

}
