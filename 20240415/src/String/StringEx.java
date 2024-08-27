package String;

public class StringEx {

	public static void main(String[] args) {

		/*
		 *  문자열 비교
		 *	equals() 비교하는 문자가 같으면 true, 다르면 false
		 *  → 대소문자 구별함
		 *	구별 안하려면 equalsIgnoreCase()
		 *  
		 */
		String str = "AbcdeF";
		System.out.println(str.equalsIgnoreCase("aBCDeF"));
		
		/*
		 *  문자열 길이 확인
		 *	length()
		 *  
		 *	
		 *  
		 */
		System.out.println("길이: " + str.length());
		
		// 문자열 저장하는 경우
		// 1byte당 하나씩 저장하게 된다 (배열처럼 공간에 문자 하나씩 저장하게 된다)
		// ex) j, a, v, a, …
		// 문자는 한 번 저장하면 변경이 "불가"
		String str2 = "java spring html jsp";
		
		// 1) substring(index값)
		// 문자열 중에서 특정 부분을 뽑아낼 경우 사용
		// 입력한 인덱스부터 출력
		// 2) substring(a, b)
		// a부터 b전까지 출력
		// 시작 포함o, 끝 포함x
		System.out.println(str2.substring(5)); 
		System.out.println(str2.substring(5, 16)); // index15가 l이기에 l까지 출력하려면 index16으로 끝번호 정해야함
		// But!
		// substring은 문자형에서만 사용 가능하고, 정수형에서는 사용 불가
		String str3 = "202404151237";
		System.out.println(str3.substring(0, 4) + "년 " + str3.substring(4, 6) + "월 " +
							str3.substring(6, 8) + "일 " + str3.substring(8, 10) + "시 " +
							str3.substring(10) + "분 입니다.");
		
		
	}

}
