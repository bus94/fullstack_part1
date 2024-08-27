package WrapperClass;

public class Main {

	public static void main(String[] args) {
		
		// 자바의 자료형
		//  기본자료형(primitive type) / 참조자료형(reference type)
		
		// 기본 타입의 데이터를 객체로 표현해야 되는 경우가 종종 있다
		// 기본 타입을 객체로 다루기 위해서 사용하는 클래스
		// : 래퍼클래스
		// java.lang패키지에 포함되어 제공 → 따라서 별다른 패키지를 불러오지 않아도 소스 단에서 바로 사용 가능
		
		// 기본 타입을 객체로 만드는 과정을 Boxing(박싱)이라고 한다
		//  (반대 과정을 Unboxing(언박싱))
		
		// 기본 자료형 int
		int a = 5;
		
		// Integer 클래스
		Integer num1 = new Integer(a); // → 밑줄이 있는 경우는 굳이 쓸 필요가 없기 때문
		// auto boxing
		// 컴파일이 알아서 기본 자료형을 객체화 시켜준다 (ex. int → Integer)
		Integer num2 = a;
		
		// 출력 자체적으로는 차이가 없지만 기본 자료형과 클래스의 기능에서의 차이가 있다
		System.out.println(a); // a. 에 대한 기능은 없지만
		System.out.println(num2); // num2. 에 대한 기능은 여러 개가 나온다 (기본적으로 Object 클래스를 상속받고 있기 때문에)

		// 실수를 객체화
		double b = 13.12;
		Double num3 = b;
		
		Integer num4 = 10 + 20;
		System.out.println(num4);
		
		// 저장 후 추가적으로 100을 더하고 싶다면
		
		// 언박싱
		// 래퍼클래스에서 기본자료형으로 변경하여 그 값을 꺼내온다
		int n = num4.intValue(); // num4의 정수값을 가져오겠다
		n = n + 100; // 값을 더한 후
		num4 = new Integer(n); // 다시 boxing(객체화)해야한다
		// 하지만 이 boxing과 unboxing 과정이 자동으로 이루어지기 때문에 아래의 코드와 같이 진행하면 된다
		num4 += 100;
		
		Integer aa = 100;
		int aaa = 100;
		int bbb = 200;
		System.out.println(aa == aaa); // true : 결과값이 나오는 이유는 값끼리만 비교한 것이 아니라 자동으로 박싱과 언박싱 과정이 되기 때문
		System.out.println(aa == bbb); // false
		
		Integer bb = 200;
		Integer cc = 200;
		Integer dd = bb+cc;
		System.out.println(bb == cc); // false : 객체끼리 비교할 땐 주소값을 비교하기 때문에 true가 나올 수 없다
		
		System.out.println(bb.equals(cc)); // true : 객체 안에 있는 값을 비교하려면 클래스에 이미 저장되어있는 equals를 이용하면 된다
		// → 비교하는 과정은 bb.intValue() 와 cc.intValue()가 같은지에 대한 결과를 출력하는 것이다
		
		// 값이 같은지 비교할 땐 메서드를 이용한다
		// → 비교 연산자 빼고는 다른 연산은 가능
		System.out.println(bb.equals(cc)); // true
		System.out.println(bb < cc); // false
		System.out.println(bb <= cc); // true
		System.out.println(bb + cc); // 400
		
		/*
		 * 자료형 변환 메서드
		 *  객체를 포장하는 기능 외에도 래퍼클래스에서 자체적으로 지원하는 메서드
		 *  : parse()
		 *  
		 * parse()를 주로 쓰는 경우
		 * : 데이터 통신이나 DB 전송은 html로 입력받거나 문자로 들어오는데,
		 *   문자로 들어온 타입을 숫자로 바꾸거나, boolean 타입으로 바꾸거나 등등의 경우에서 쓰인다
		 * 
		 */
		
		
		// 문자 → int 타입 변경
		String str = "10"; // 이건 숫자 10이 아닌 문자 10인 것
		int i = Integer.parseInt(str); // parse()를 이용하여 문자를 숫자로 변경하는 과정
		
		// 문자 10 → double 타입으로 변경
		double d2 = Double.parseDouble(str);
		
		// 문자 → 실수 타입 변경
		String str2 = "10.5";
		// double d = (double)str2;는 에러 발생함
		double d = Double.parseDouble(str2); // 문자를 실수로 변경하는 과정
		
		
		System.out.println(i); // 10
		System.out.println(d2); // 10.0
		System.out.println(d);
		System.out.println(str + str2); // 1010.5
		System.out.println(i + d); // 20.5
		
		// 문자 → int 타입
		// int i2 = Integer.parseInt(str2);
		// System.out.println(i2); 에러 발생
		//  코드에 빨간 줄은 없지만 실행을 했을 때 에러가 발생할 수 있다
		//   그걸 처리하기 위해서 사용하는 것이 "예외처리!"
		
		// 문자 → boolean 타입 변경
		String str3 = "true";
		boolean bool = Boolean.parseBoolean(str3);
		System.out.println(bool); // true
		
		
		
		
	}

}
