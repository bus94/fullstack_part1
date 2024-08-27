package Class;

import java.util.Arrays;
import java.util.Random;

// do while문
// do에서 무조건 1번 실행한 후 while에서 조건 참/거짓에 따라 반복문 실행/중지
class Lotto {
	int[] lotto;
	int size;

	void random(int size) {
		lotto = new int[size];
		
		Random ran = new Random();

		for (int i = 0; i < 6; i++) {
			int num;
			boolean isDu;

			do {
				num = ran.nextInt(45) + 1;
				isDu = false;
				for (int j = 0; j < i; j++) {
					if (lotto[j] == num) {
						isDu = true;
						break;
					}
				}
			} while (isDu);

			lotto[i] = num;
		}
		System.out.println("정렬 전: ");
		System.out.println(Arrays.toString(lotto));
		Arrays.sort(lotto);
		System.out.println("정렬 후: ");
		System.out.println(Arrays.toString(lotto));
	}
}

public class ClassTest2 {

	public static void main(String[] args) {
		// 클래스 멤버 변수로 배열을 저장할 수
		// 있다.

		// 1. 랜덤클래스를 이용해서 숫자
		// 	1~45 사이의 중복해도 됨!
		// 2. 중복제거하기
		// 3. 함수로 변경
		
		Lotto lo = new Lotto();
		lo.random(6);

//		Random ran = new Random();
//		
//		// 배열의 시작번호는 0번 이기 때문에 0부터 시작한다.
//		for (int i = 0; i < 6; i++) {
//			int num;
//			boolean isDu;
//			
//			do { // 1~45 숫자 하나뽑는다. 
//				num = ran.nextInt(45) +1;
//				isDu = false;
//				
//				//중복확인 
//				for(int j = 0; j < i; j++) {
//					if(lo.lotto[j] == num) {
//						isDu = true;
//						break;
//					}
//				}
//				
//			// 참일 경우에는 중복이기 때문에 실행하는
//		    // do로 올라가서 다시 랜덤값을 뽑는다.
//			// 거짓일 경우에는 중복되지 않았다는 것!
//			// 반복문을 빠져나온다.
//			}while(isDu);
//			
//			//저장
//			lo.lotto[i] = num;
//		}
//		System.out.println(Arrays.toString(lo.lotto));
		// do~while문
		// 실행 -> 반복(조건)
		// 무조건 1번은 먼저 실행을 하고
		// 반족조건을 물어본다.
		
		// 정렬(버블정렬, 선택정렬)
		
		int[] arr = {135, 124, 543, 453, 623, 234, 875, 602};
		System.out.println("정렬 전의 배열 arr");
		System.out.println(Arrays.toString(arr));
		
		// 버블정렬
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			
		}
		System.out.println("버블정렬 후");
		System.out.println(Arrays.toString(arr));

		
		// 선택정렬
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("선택정렬 후");
		System.out.println(Arrays.toString(arr));
		

	}
}