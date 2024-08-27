package StringTokenTest;

import java.util.StringTokenizer;

public class TokenController {
	
	TokenController(){
	}
	
	public String afterToken(String str) {
		StringTokenizer s = new StringTokenizer(str); // 구분자를 작성하지 않으면 콤마 및 공백으로 자동 구분자 적용
		
		// StringBuilder
		// 가변적으로 메모리 공간을 늘렸다 줄였다 할 수 있다.
		StringBuilder sb = new StringBuilder();
		while(s.hasMoreTokens()) {
			sb.append(s.nextToken());
		}
		// 가변적인 문자열을 저장하는 객체에서 불변 문자열로 변경되어 넘어간다.
		return sb.toString();
		
//		String resultStr = "";
//		while(s.hasMoreTokens()) {
//			resultStr += s.nextToken(); 
//		}
//		// 문자 변수 선언 후 토큰 단위의 문자를 연결하여 하나의 문자열을 생성 후 반환
//		return resultStr;
	}
	
	public String firstCap(String input) {
		// 실제 함수를 실행할 때 데이터가 없는 경우가 발생할 수 있으므로 예외적인 처리를 해주는 것이 좋다.
		if(input.isEmpty()) { // 문자변수명.isEmpty() : 데이터가 없다면(비어있다면) true 
			return input;
		}
		input = input.substring(0, 1).toUpperCase() + input.substring(1);
		return input; // return 값이므로 해당 함수에서 input을 데이터를 변경해도 함수가 return하면 input은 다시 초기값으로 설정됨
	}
	
	public int findChar(String input, char one) {
		int count = 0;
//		for(int i = 0; i < input.length(); i++) {
//			if(input.charAt(i) == one) {
//				count++;
//			}
//		}
		// 문자끼리 비교할 때 한 문자씩 비교하는 거라면 == 으로 비교 가능하다.
		for(char c : input.toCharArray()) { // 문자변수명.toCharArray() 문자열을 한 문자 배열로 나타냄
			if(c == one) {
				count++;
			}
		}
		return count;
	}
	
	
}
