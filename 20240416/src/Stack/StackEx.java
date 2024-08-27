package Stack;

public class StackEx {

	public static void show(int[] arr, int top, int count) {

		for (int i = top; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("최종 개수: " + count);

	}

	// 데이터 추가 하는 함수
//	public static void push(int[] arr, int top, int count, int value) {
//		
//			arr[++top] = value; 
//			top++; 
//			count++;
//			
//	} 
	// 지역변수의 성격으로 인해 top이 증가하지 않고 실행만 되고 데이터가 삭제가 됨  
	// main 함수에서 왔던 top의 값이 push를 실행했을 때 결과가 top++이 되겠지만 
	// push가 실행을 마치면 변한 top의 값이 삭제되고 처음 top의 값으로 돌아오게 된다

	public static void main(String[] args) {

		/*
		 * 스택 : 쌓다, 더미 입구가 하나이기 때문에 가장 먼저 들어간 데이터가 가장 나중에 나온다 → LIFO (Last In First Out)
		 * 스택 구조는 자바가 이미 만들어둠 → 심화 컬렉션 프레임워크 Stack
		 * 
		 * 스택 구조를 사용하기 위해서는 2가지 변수가 필요
		 * 
		 * 배열로 구현을 하는 것이기에 인덱스를 이용해서 사용
		 * 
		 */

		int top = -1; // 아직 스택에 데이터가 쌓이지 않았기 때문
		int count = 0; // 스택 데이터 개수

		int[] arr = new int[5]; // 현재 각 인덱스마다의 값이 0

		// 데이터 추가
//		arr[0] = 10; // top = 0; count = 1; → 0번째(top) 인덱스에 1개(count)의 데이터가 쌓여있다
//		top = 0;
//		count++;
//
//		arr[1] = 20; // top = 1; count = 2;
//		top = 1;
//		count++;
//
//		arr[2] = 30; // top = 2; count = 3;
//		top = 2;
//		count++;
//		push(arr, top, count, 10);
//		push(arr, top, count, 20);
//		push(arr, top, count, 30);

		// 출력
//		for(int i = top; i >= 0; i--) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
//		System.out.println("최종 개수: " + count);
		show(arr, top, count);

		// 데이터 삭제
//		int del = arr[top];
//		arr[top] = 0;
//		top--;
//		count--;

		// 출력
//		for(int i = top; i >= 0; i--) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
//		System.out.println("최종 개수: " + count);
		show(arr, top, count);

	

	}

}
