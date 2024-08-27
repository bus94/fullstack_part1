package Function;

import java.util.Scanner;

public class FunctionTest2 {
	
	public static void se(String ide) {
		if(ide.charAt(6) == '1' || ide.charAt(6) == '3') {
			System.out.println("남");
		}else if(ide.charAt(6) == '2' || ide.charAt(6) == '4'){
			System.out.println("여");
		}
	}
	
	// 주민번호의 7번째 자리를 나눗셈과 나머지를 이용할 수도 있다
	// jumin/1000000%10 → (결과로 나온) 7번째 수로 남,여 구분할 수 있다
	
	public static void si(String idi) {
		if(idi.charAt(7) == '1' || idi.charAt(7) == '3') {
			System.out.println("남");
		}else if(idi.charAt(7) == '2' || idi.charAt(6) == '4'){
			System.out.println("여");
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호 13자리를 '-' 없이 입력: ");
		String ide = sc.nextLine();
		// long 타입으로 작성하는 경우
		// System.out.print("주민등록번호 13자리를 '-' 없이 입력: ");
		// long jumin = sc.nextLong();
		
		se(ide);
		
		System.out.print("주민등록번호 13자리를 '-' 포함해서 입력: ");
		String idi = sc.nextLine();
		
		si(idi);
	}

}
