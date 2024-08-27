package StringToken;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

//		// StringTokenizer
//		// split()
//
//		// 공통점: 문자열 구분하는데 사용
//		String str = "010-1234-5678";
//		// split() 메서드는 인수로 지정된 구분자로 문자열을 분리해서 배열로 리턴
//		String[] phone = str.split("-");
//		System.out.println(Arrays.toString(phone));
//
//		// split() 메서드는 구분자를 2개 이상 지정할 수 없다.
//		// 공백가 탭이 섞여있는 데이터에 구분자를 공백만 지정하면 탭으로 구분된 데이터는 분리할 수가 없다.
//
//		str = "사과 배 복숭아	밤 대추";
//		String[] data = str.split(" ");
//		System.out.println(Arrays.toString(data));
//
//		// 밑에 있는 클래스를 사용하기 위해서는 java.util 포함해야한다
//		// 입출력할 때 한 줄씩 입력을 읽어 드리면 라인 단위로 읽어 들일 수 밖에 없다.
//		// 사용자가 지정하는 구분자를 경계로 문자열을 분리한다.
//		// 구분자를 생략하면 공백과 탭을 기본 구분자로 사용하며 구분자로 분리된 데이터를 "토큰"이라 한다.
//		StringTokenizer st = null;
//
//		// 문자열이 공백이나 탭으로 구분된 경우
//		// 띄어쓰기 기준으로 문자열을 분리
//		st = new StringTokenizer(str); // 반환하면 배열이 아닌 문자열로 반환됨
//
//		// hasMoreTokens()
//		// : 클래스 객체에 다음에 읽은 token이 있으면 true, 없으면 false를 리턴
//		// (쉽게 말해 다음 데이터가 있다면 true, 없으면 false)
//		while (st.hasMoreTokens()) {
//			// 다음 데이터가 있다면 반복
//			System.out.println(st.nextToken());
//		}
//		System.out.println("=========================");
//
//		// 문자열이 ","로 구분된 경우
//		String str2 = "사과,배,복숭아,밤,대추";
//		StringTokenizer st2 = new StringTokenizer(str2, ",");
//
//		while (st2.hasMoreTokens()) {
//			System.out.println(st2.nextToken());
//		}
//		System.out.println("=========================");
//
//		// 두 개 이상의 문자로 구분이 가능하다
//		// 클래스 생성시 구분자를 2번째 인수로 지정을 하고 구분자를 여러 개 지정할 수 있다
//		String str3 = "사과,배,복숭아.밤,대추";
//		StringTokenizer st3 = new StringTokenizer(str3, ",.");
//
//		while (st3.hasMoreTokens()) {
//			System.out.println(st3.nextToken());
//		}
//		System.out.println("=========================");

		// StringTokenizer 클래스 생성자의 3번째 인수로 구분자를 토큰에 포함시키는 여부를 지정할 수 있다
		// 3번째 인수는 생략 시 false가 된다 → 토큰에 포함되지 않는다는 것!
		// 만약 true를 쓰면 구분자를 토큰에 포함시킨다
		String str4 = "사과=1000,배=2000,복숭아=3000,밤=4000,대추=5000";
		StringTokenizer st4 = new StringTokenizer(str4, "=", true); // 구분자 포함 여부

//		while (st4.hasMoreTokens()) {
//			System.out.println(st4.nextToken());
//		}
//		System.out.println("=========================");

		// 사과(1,000원)

		DecimalFormat df2 = new DecimalFormat("#,##0원");

		while (st4.hasMoreTokens()) {
			// 다음 데이터 가져옴
			String s = st4.nextToken();

			if (s.equals("=")) {
				System.out.print("(");
			} else if (s.equals(",")) {
				System.out.print(")");
			} else {
				try {
					// ","와 "=" 출력할 때 괄호로 변경하였고,
					// 사과, 배 등 단어와 숫자에 대한 변경을 해야하는데 반복하다가 단어가 오면 예외가 발생할 수 있다
					// ex. "사과"는 숫자가 아니므로 변경 필요x
					System.out.print(df2.format(Integer.parseInt(s))); // 숫자를 문자로 저장하기 때문에 숫자를 정수형태로 바꾸어서 저장
				} catch (Exception e) {
					System.out.print(s); // 단어는 숫자로 변경할 필요없으니 그대로 문자로 저장
				}
			}
		}
		System.out.println(")");

//		위의 코드를 switch문으로 바꿔보기 (미완성)
//		while (st4.hasMoreTokens()) {
//			String s = st4.nextToken();
//			String m = "";
//			boolean check = s.equals(m);
//			
//			switch (m) {
//			
//			case "=":
//				if(check) {
//					System.out.print("(");
//				} else 
//					continue;
//				
//			case ",":
//				if(check) {
//				System.out.print(")");
//				} else
//					continue;
//
//			default:
//				try {
//					System.out.print(df2.format(Integer.parseInt(s))); 
//				} catch (Exception e) {
//					System.out.print(s);
//				}
//				break;
//				
//			}
//		}
//		System.out.println(")");

		// 숫자 형식 지정을 위한 DecimalFormat 객체 생성
		// # : 숫자가 없으면 표시하지 않음을 의미
		// 0 : 숫자가 없으면 0으로 표시
		double number = 1234567.89;
		DecimalFormat df = new DecimalFormat("#,##0.00"); // # : 숫자가 없으면 표시하지 않는다는 의미

		String formatted = df.format(number);
		System.out.println(formatted);

//		구분자     split은 정규 표현식으로 구분하고 
//	      	   StringTokenizer는 문자로 받는다.
//	      
//		split의 결과 : 문자열 배열 
//		StringTokenizer의 결과 : 객체
//
//		split : 빈문자열을 토큰으로 인식
//		StringTokenizersms : 빈 문자열을 토큰으로 인식하지 않음
//
//		split은 데이터를 토큰으로 잘라낸 결과를 배열에 담아 반환하지만
//			StringTokenizer 보다 성능이 떨어진다.
//		그러나 데이터의 양이 많은 경우가 아니라면 별 문제가 되지 않는다.

	}

}
