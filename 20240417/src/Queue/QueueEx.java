package Queue;

import java.util.Scanner;

public class QueueEx {
	
	
	public static void main(String[] args) {

		/*
		 * Queue(큐): (사전적) 무엇을 기다리는 사람 먼저 대기한 사람이 먼저 일을 해결하고 나간다 FIFO(First In First
		 * Out) ex.배열(LinkedList)
		 * 
		 * Enqueue: 큐의 맨 뒤에 데이터 추가 Dequeue: 큐의 맨 앞에 데이터 삭제
		 * 
		 * 큐는 앞과 뒤를 구별해야함 Front(삭제) / Rear(추가) 컴퓨터 버퍼(scanner)에서 주로 사용
		 * 
		 */
		int[] arr = { 1, 2, 3, 4, 5 };
		int front = 0; // 맨 앞 데이터의 index
		int rear = 4; // 맨 뒤 데이터의 index

		System.out.println(front);
		System.out.println(rear);

		int count = arr.length; // 배열 arr의 길이 : 5
		arr = push(arr, count); // 데이터 추가로 push 함수에 의해 길이 : 6
		rear = arr.length - 1; // 그 때의 맨 뒤 데이터의 index : 6 - 1 = 5
		count = arr.length;
		System.out.println("현재 rear: " + rear);
		System.out.println("현재 count: " + count);
		print(arr);
		delete(arr, count);
		print(arr);
	}

	// Queue에 추가하는 함수
	public static int[] push(int[] arr, int count) {
		// 배열을 넘겨 받은 후 기존 배열을 temp에 복사하고
		// 기존 배열의 길이에서 추가한 새로운 배열을 생성
		// 값 추가하고 main함수의 rear에 적용

		// 만약 데이터가 없다면 기본 데이터를 복사하는 문장 쓸 필요 없다
		if (count == 0) {
			arr = new int[1];
		} else {
			int[] temp = arr; // temp는 지역변수로 else의 {} 안에서만 이루어짐
			arr = new int[count + 1]; // 길이가 1 증가한 새로운 arr 배열 생성
			
			for (int i = 0; i < temp.length; i++) {
				arr[i] = temp[i];
			}
		}
		Scanner sc = new Scanner(System.in);
		// 새로운 데이터 추가 (데이터가 1개 추가 되었으므로 count++)
		System.out.print("추가 할 정수: ");
		arr[count++] = sc.nextInt();
		
		return arr; // arr의 길이가 늘어난 arr로 return이 되므로 count까지 늘어난 상태로 같이 main으로 넘어감 
					// push 함수를 실행한 main 함수에서는 배열이 늘어난 arr이 적용되므로 count가 count++로 적용됨
	}

	// Queue에 삭제하는 함수
	public static int[] delete(int[] arr, int count) {
		if (count == 0) {
			arr = new int[1];
		} else {
			int[] temp = arr;
			arr = new int[count]; 
			
			for (int i = 0; i < temp.length; i++) {
				arr[i] = temp[i+1];
			}
		}
		return arr;

	}

	// 조회 → 순서대로 출력
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
