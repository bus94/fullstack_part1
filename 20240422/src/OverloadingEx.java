
public class OverloadingEx {

	// 정수 2개
	public static void add(int n1, int n2) {
		System.out.println("정수 더한 값: " + (n1 + n2));
	}

	// 실수 2개
	public static void add(double n1, double n2) {
		System.out.println("실수 더한 값: " + (n1 + n2));
	}
	
	// 정수 + 실수
	public static void add(int n1, double n2) {
		System.out.println("정수 + 실수 더한 값: " + (n1 + n2));
	}

	public static void main(String[] args) {

		// ex. 계산기를 만들려고 한다
		// - 정수 2개 더한다, 실수 2개 더한다, 정수 + 실수 계산 등의 함수를 위의 코드처럼 일일이 작성해야한다
		
		// 오버로딩 (함수명은 같되, 매개 변수의 타입과 개수는 달라야한다 / 반환 타입은 오버로딩에 해당되지 않는다(신경x))
		// 비슷한 뜻으로는 New
		// - 새로운 함수를 계속 만들되 같은 이름의 함수를 만든다
		// - 각각의 함수의 매개 변수의 타입이 다르거나 변수의 개수도 달라야한다.
		// 자바 컴파일이 구별해서 함수를 호출한다
		// ex. println (printf는 출력할 때마다 어떤 타입을 출력할지 일일이 작성해야한다 → C언어)
		
		
		
	}

}
