package Sort;

import java.util.Arrays;

public class SelectionSort {

	// 선택정렬 오름차순 (Ascending)
	public static int[] selectAsc(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	// 선택정렬 내림차순 (Descending)
	public static int[] selectDesc(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {

		/*
		 * 선택 정렬 : 한 번의 배열 탐색에서 가장 작은 값 찾아서 위치를 찾고 그 위치의 값과 교체 : 오름 차순으로 주로 정렬
		 * 
		 */

		int[] arr = { 8, 3, 4, 9, 1 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		print(selectAsc(arr));
		print(selectDesc(arr));
	}

}
