package Test;

import java.util.Random;

public class Test {

	public static String[] cardD(String[] number, String[] symbol) {

		int length = symbol.length * number.length;
		int a = 0;
		String[] arr = new String[length];
		for (int i = 0; i < symbol.length; i++) {
			for (int j = 0; j < number.length; j++) {
				arr[a++] = symbol[i] + number[j];
			}
		}
		return arr;

	}

	public static void print(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if ((i + 1) % 13 == 0) {
				System.out.println();
			}
		}
	}

	public static String[] shuffle(String[] arr) {
		Random random = new Random();

		String[] temp = arr;
		arr = new String[temp.length];
		for (int i = 0; i < arr.length; i++) {
			int j = random.nextInt(arr.length - 1);
			arr[i] = temp[j];
			// 중복 제거를 못함
			// 아래줄 부터 코딩 수정 필요!!
			for (int k = 0; k < i; k++) {
				if (arr[k].equals(arr[k + 1])) {
					i--;
				} else {
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {

		String[] number = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String[] symbol = { "♠", "◇", "♥", "♧" };

		print(cardD(number, symbol));
		System.out.println();
		print(shuffle(cardD(number, symbol)));
	}

}
