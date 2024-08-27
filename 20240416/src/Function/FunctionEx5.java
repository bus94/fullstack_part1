package Function;

public class FunctionEx5 {

	public static void arrIntprint(int[] list) {
		System.out.println("list 배열 출력: ");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		// 배열을 출력하는 함수
		int[] arr = {1,2,3,4,5,6,4};
		int[] arr2 = {10,20,30,54,50};
		int[] arr3 = {100,200,300,540,500};
		
		arrIntprint(arr);
		arrIntprint(arr2);
		arrIntprint(arr3);
		
		/*
		 * 매개변수(parameter)
		 * : 함수에서 다른 함수로 데이터를 이동시키는 변수
		 * (주의) 정확한 타입 !
		 * 하나의 변수에는 하나의 타입만 저장 가능
		 * 정수 배열 → 정수 배열
		 * 문자 배열 → 문자 배열
		 * 
		 */
		
		String[] nameList = {"익준", "준완", "송화"};
		listPrint(nameList);
		
		String[] idList = {"qwer", "asdf", "zxcv"};
		listPrint(idList);
		
	}
	
	public static void listPrint(String[] list) {
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}

}
