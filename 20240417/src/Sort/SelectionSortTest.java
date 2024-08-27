package Sort;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortTest {

	// 키보드로 5개의 이름을 입력받아 이름 정렬

	public static String scanner() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name = sc.nextLine();
		return name;
	}

	public static void print(String[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static String[] selectSort(String[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].charAt(0) > arr[j].charAt(0)) {
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;

	}

	public static void main(String[] args) {

		String[] nameList = new String[5];

		for (int i = 0; i < nameList.length; i++) {
			nameList[i] = scanner();
		}

		print(nameList);
		print(selectSort(nameList));
		for (int i = 0; i < nameList.length; i++) {
			System.out.println(selectSort(nameList)[i].charAt(0) + " ");
		}
	}

}
