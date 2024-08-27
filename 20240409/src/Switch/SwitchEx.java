package Switch;

public class SwitchEx {

	public static void main(String[] args) {
		
		// if문: 참, 거짓으로 실행 / switch문: 숫자, 문자로 실행 (key 값으로 value를 찾음)
		
		int key = 2;
		switch(key) {
		case 0:
			System.out.println("0이다!");
			System.out.println("0의 범위!");
			break;
		case 1:
			System.out.println("1이다!");
			System.out.println("1의 범위!");
			break;
		}
		
		// switch문에서 key값으로 사용할 수 있는 자료형: 정수, 한 문자, 문자열
		// 실수는 key값으로 사용할 수 없다
		// float 일 경우 4byte, 6자리까지 출력 / double 일 경우 8byte, 16자리까지 출력
		// ∵ 너무 길기 때문에 실수 입력 못하게 해둠
		char chKey = 'A';
		
		switch(chKey) {
		
		case 'A': case 'a':
			System.out.println("대문자 A");
			// 한 문자를 강제적으로 정수로 표현
			System.out.println((int)chKey);
			// By.아스키 코드 char(문자) 'A' = 65, 'B' = 66, '1' = 49 로 10진수로 변환 출력 (문자를 숫자 형태로)
			System.out.println('B' + '1');
			// By.아스키 코드 → 'A' + '1' = 65 + 49 = 114 → By.아스키 코드 (숫자를 문자로) ∴ r 로 출력
			System.out.println((char)('A' + '1'));
			break;
			
		}
		
		System.out.println("switch문 끝!");

		// 메뉴
		String strKey = "조회";
		
		switch(strKey) {
		
		case "입력":
			System.out.println(strKey + " 메뉴");
			break;
			
		case "수정":
			System.out.println(strKey + " 메뉴");
			break;
			
		case "조회":
			System.out.println(strKey + " 메뉴");
			break;
			
		case "삭제":
			System.out.println(strKey + " 메뉴");
			break;
			
		case "종료":
			System.out.println(strKey + " 메뉴");
			break;
			
		default:
			System.out.println("메뉴에 없는 key입니다.");	
			break;
		}
		
		int score = 95;
		
		switch(score / 10) {
		
		case 9:
			if(score % 10 >= 5) {
				
			}
			System.out.println("A");
			break;
			
		}
		
	}

}
