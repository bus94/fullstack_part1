package Function;

public class FunctionEx3 {

	/*
	 * 함수명은 중복 불가
	 * 
	 */
	
	//printFor1,2,3 → printFor 함수로 통일
	public static void printFor(int 시작, int 끝) {
		for(int start = 시작; start <= 끝; start++) {
			System.out.println(start);
		}
		System.out.println();
	}
	
	public static void add(int a, int b) {
		int result = a + b;
		System.out.println(result);
	}
	
	public static void printFor1() {
		for(int start = 1; start <= 5; start++) {
			System.out.println(start);
		}
	}
	
	public static void printFor2() {
		for(int start = 1; start <= 50; start++) {
			System.out.println(start);
		}
	}
	
	public static void printFor3() {
		for(int start = 1; start <= 100; start++) {
			System.out.println(start);
		}
	}
	
	public static void main(String[] args) {

		/*
		 * 함수의 장점: 재사용성↑, 중복코드 제거
		 * 코드 추가하거나 삭제하거나 변경 할 때
		 * 코드마다 직접 변경하는 것이 아니라 하나의 함수 안에서 변경 가능
		 * 유지 보수 효율↑
		 * 
		 */
		
		
		printFor1();
		printFor2();
		printFor3();
		
		printFor(1,5); // printFor1();
		printFor(1,50); // printFor2();
		
		add(1,1);
		add(2,2);
		add(10,10);
		add(100,200);
		
		
	}

}
