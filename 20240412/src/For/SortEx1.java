package For;

public class SortEx1 {

	public static void main(String[] args) {
		/*
		 * <버블 정렬> : 인접한 값(앞,뒤 라고 생각) 비교하여 서로 위치 교환 : 오름차순으로 정렬 : 비교하는 횟수 감소 (이미 맨 뒤로
		 * 이동했기 때문) : PASS1 → 가장 큰 값이 맨 뒤로 이동
		 * 
		 */

		int[] numList = { 6, 7, 5, 2, 1, 4, 3 };

		int size = numList.length;

		for (int i = 0; i < size; i++) {

			System.out.print(numList[i] + " ");

		}
		System.out.println();

		System.out.println("현재 배열 사이즈: " + size);

		for (int i = 0; i < size - 1; i++) {
			// 현재 인덱스와 다음 인덱스 비교하여 큰 값을 다음 인덱스로 교체
			// 인덱스 값끼리 비교하는 반복 횟수를 j로 설정
			for (int j = 0; j < size - i - 1; j++) {
				if (numList[j] > numList[j + 1]) {
					int temp = numList[j];
					numList[j] = numList[j + 1];
					numList[j + 1] = temp;
				}
			}

		}
		System.out.println("버블정렬 후");
		for (int i = 0; i < size; i++) {
			System.out.print(numList[i] + " ");
		}
		
		// 백준
		// 알고리즘 수업 - 버블정렬1
		

	}

}
