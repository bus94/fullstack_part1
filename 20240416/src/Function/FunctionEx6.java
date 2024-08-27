package Function;

public class FunctionEx6 {
	
	public static String name() {
		return "이서희";
	}
	
	public static int add(int num) {
		return num + 10;
	}

	public static void main(String[] args) {

		/*
		 * 함수 실행하고 남겨놓을 값이 있으면 return;
		 * return의 기능 2가지
		 * 1) 함수종료
		 * 2) 함수가 종료되기 전에 함수를 실행한 함수에게 데이터 값을 돌려준다
		 * 
		 */
		
		System.out.println(name());
		System.out.println(add(20));
		
		int sum = add(20);
		System.out.println(sum);
		
		/*
		 * 변수: 메모리에 생존하는 시간
		 * 전역변수: 
		 * 
		 * 지역변수: 중괄호 닫히는 사이에 만들어진 변수
		 * int num = 10; (main 함수의 지역변수)
		 * 지역변수끼리는 중복 x
		 * { → 변수 만들어지고, } → 변수 삭제 가 된다
		 * 
		 */
		
		print();		
	}
	
	public static void print() {
		/*
		 * print 함수가 시작될 땐 main 함수의 num 과는 메모리 공간과 생존 시간이 다르기 때문에 num 중복선언이 가능
		 * 
		 */
		
		int num = 100;
		System.out.println("print() num: " + num);
		
		int total = add(10,20);
		System.out.println("main 함수: " + total);
	}
	
	public static int add(int n1, int n2) {
		/*
		 * { → 변수 만들어지고, } → 변수 삭제 가 된다
		 * 따라서 다른 함수에서 출력할 때 결과값이 삭제 되니
		 * 출력하기 위해 return; 작성 필요 (내보내기)
		 * 
		 */
		int total = n1 + n2;
		return total;
	}

}
