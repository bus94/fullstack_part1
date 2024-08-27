package ArrayGame;

public class ArrayEx3 {

	public static void main(String[] args) {

		int[] number = {1, 2, 3, 4, 5, 6, 7 ,8 ,9 ,10, 11, 12, 13, 14, 15, 16};
		
//		int k = 0;
//		
//		while(k < 16) {
//			
//			if(number[k] == k + 1) {
//				System.out.print(number[k] + " ");
//			}
//			if(k % 4 == 3) {
//				System.out.println();
//			}
//			
//			k++;
//		}
//		
//		System.out.println();
		
		/*
		 * 배열의 요소를 행렬 형태로 출력
		 * 
		 */
		
		// 강사님 풀이
		// 행(column) 기준 잡고 출력하기
		int col = 4;
		int i = 0;
		int size = number.length;
			
		while(i < size) {
			int j = 0;
			
			while(j < col && i < size) {
				System.out.print(number[i]);
				j++;
				i++;
			}
			System.out.println();
		}
		
	}

}
