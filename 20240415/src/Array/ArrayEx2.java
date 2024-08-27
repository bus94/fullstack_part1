package Array;

import java.util.Scanner;

public class ArrayEx2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[3][3];

		int k = 1;
		
		// 인덱스 2개를 입력받아 값 출력
//		System.out.print("인덱스1 입력 : ");
//		int index1 = sc.nextInt();
//		
//		System.out.print("인덱스2 입력 : ");
//		int index2 = sc.nextInt();
//		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
//		System.out.println("값 출력 : " + arr[index1][index2]);
//		
//		// 값을 입력받아 인덱스 2개 출력
//		System.out.print("값 입력 : ");
//		int value = sc.nextInt();
//		
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				if(arr[i][j] == value) {
//					System.out.println("인덱스1 출력 : " + i + ", 인덱스2 출력 : " + j);
//					break;
//				} else {
//					System.out.println("찾는 값이 없습니다.");
//					continue;
//				}
//			}
//		}
		
		// 가장 큰 값의 인덱스 2개 출력
//		int max = arr[0][0];
//		int a = 0, b = 0;
//		
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				if(max < arr[i][j]) {
//					max = arr[i][j];
//					a = i;
//					b = j;
//				}
//			}
//		}
//		System.out.println(a + " " + b);
		
		// 값 2개를 입력받아 값 교체
		System.out.print("값1 입력 : ");
		int v1 = sc.nextInt();
		
		System.out.print("값2 입력 : ");
		int v2 = sc.nextInt();
		
		int i1 = 0; // 강사님은 0이 아닌 -1로 저장하고 시작함
		int j1 = 0;
		int i2 = 0;
		int j2 = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(arr[i][j] == v1) {
					i1 = i;
					j1 = j;
				}
				if(arr[i][j] == v2) {
					i2 = i;
					j2 = j;
				}
				
			}
		}
					
		int temp = arr[i1][j1];
		arr[i1][j1] = arr[i2][j2];
		arr[i2][j2] = temp;
		System.out.println(arr[i1][j1] + " " + arr[i2][j2]);
		
		
		

	}

}
