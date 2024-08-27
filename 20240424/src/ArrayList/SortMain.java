package ArrayList;

import java.util.ArrayList;

public class SortMain {
	// 오름차순 정렬
	public static void bubbleSortAsc(ArrayList<String> names) {
		// 몇 번 반복을 할 지 결정
		int n = names.size();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (names.get(j).compareTo(names.get(j + 1)) > 0) {
					String temp = names.get(j);
					names.set(j, names.get(j + 1));
					names.set(j + 1, temp);
				}
			}
		}
	}

	// 내림차순 정렬

	public static void main(String[] args) {


		String str1 = "가나다";
		String str2 = "나다라";

		// 비교했을 때 str1, str2의 차 만큼 숫자로 돌려준다.
		int result = str1.compareTo(str2);
		System.out.println("결과값: " + result);

		if (result < 0) {
			System.out.println("str1이 str2보다 사전순으로 앞에 있다.");
		} else if (result > 0) {
			System.out.println("str1이 str2보다 사전순으로 뒤에 있다.");
		} else {
			if (result < 0) {
				System.out.println("str1과 str2가 사전순으로 같다.");
			}
		}
		
		System.out.println();
		
		ArrayList<String> names = new ArrayList<>();
		names.add("이익준");
		names.add("김준완");
		names.add("채송화");
		names.add("양석형");
		names.add("안정원");
		
		System.out.println("정렬 전: ");
		System.out.println(names);
		
		bubbleSortAsc(names);
		System.out.println("버블정렬로 오름차순 정렬 후: ");
		System.out.println(names);
		
	}

}
