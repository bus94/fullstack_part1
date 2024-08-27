package String;

import java.util.Arrays;

public class StringEx2 {

	public static void main(String[] args) {

		String str = "java spring html jsp";
		
		System.out.println(str.toUpperCase()); // 대문자
		System.out.println(str.toLowerCase()); // 소문자
		
		// 문자열 검색
		// indexOf() : 문자열에서 특정문자가 시작되는 인덱스로 반환
		// → 해당 문자의 인덱스 찾기
		// index 0번 부터 찾고, 처음 나오는 값의 인덱스로 반환
		System.out.println(str.indexOf('p'));
		// indexOf(문자 or 문자열, index);
		// 해당하는 인덱스부터 검색
		// 중복되는 경우 사용
		System.out.println(str.indexOf('p',7)); // 7번 인덱스부터 검색
		
		// contains()
		// 문자열에 조회할 문자가 포함되어있는지에 대해
		// 조회했을 때의 결과값 true, false
		System.out.println(str.contains("jsp"));
		System.out.println(str.contains("boot"));
		
		// split()
		// 특정 문자를 이용하여 문자열을 구별한 후 "배열"로 반환
		System.out.println(str);
		String[] result = str.split(" ");
		System.out.println(result);
		
		// Arrays.toString(생성한 배열);
		// 배열의 값을 문자 형태로 반환 (for문 이용해서 써서 출력해도 됨)
		System.out.println(Arrays.toString(result));
		
		str = "java!spring/html!jsp";
		result = str.split("!");
		System.out.println(Arrays.toString(result));
		
		// replace(기존 문자or문자열, 변경할 문자or문자열)
		// 특정 문자 → 원하는 문자로 변경할 때
		// '!' → ' ' 로 변경
		// 변경한 내용은 영구 저장이 아님
		// 그렇기 때문에 변경 내용은 저장해둬야한다
		System.out.println(str.replace('!', ' '));
		System.out.println(str);
		// 변경 내용을 저장할  땐
		str = str.replace('!', ' ');
		System.out.println(str);
		str = str.replace("spring", "boot");
		System.out.println(str);
		
		// 문자열을 비교할 때 사전식 배열하는 경우
		// 첫 번째 문자열이 두 번째 문자열보다 
		// 앞에 위치하는 경우 : 음수
		// 같은 경우 : 0
		// 뒤에 위치하는 경우 : 양수
		str = "abc";
		int res = str.compareTo("c"); // by.아스키코드표 a = 97, c = 99 → c 기준으로 a는 c 앞으로 2 → ∴ -2 출력
		int res1 = str.compareTo("abc");
		int res2 = str.compareTo("b");
		System.out.println(res);
		System.out.println(res1);
		System.out.println(res2);
		// 아스키코드에서 대소문자는 구분
		str = "Abc";
		int res3 = str.compareTo("c");
		System.out.println(res3); // A = 65 (65 - 99 = -34) ∴ -34 출력
		
		if(str.compareTo("Abc") == 0) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
	}

}
