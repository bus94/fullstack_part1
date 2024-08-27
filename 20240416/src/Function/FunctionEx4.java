package Function;

import java.util.Scanner;

public class FunctionEx4 {
	
	public static void binarySearch() {
		
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		
		Scanner sc = new Scanner(System.in);
		System.out.println("찾는 값 입력: ");
		int find = sc.nextInt();
		
		// 기준 인덱스 찾기
		int left = 0;
		int right = arr.length - 1;
		
		// 기준 값과 찾는 값을 비교하여 기준 값 재설정하고 찾을 때까지 반복
		while (true) {
			int mid = (left + right) / 2;
			System.out.println("왼쪽: " + left);
			System.out.println("오른쪽: " + right);
			System.out.println("기준점: " + mid);
			
			if (arr[mid] == find) {
				System.out.println("찾았다!");
				System.out.println(mid + "번 째 인덱스");
				break;
			} else if (arr[mid] > find) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
	}

	public static void main(String[] args) {

		/*
		 * <순차 탐색> : 순서대로 배열의 0번부터 순서대로 각 방에 접근해서 비교 단점: 데이터가 많을 수록 비효율적 (처리할게 많아져 많은 시간
		 * 소요)
		 * 
		 * <이진 탐색 (Binary Search)> 조건: 배열이 정렬되어있어야 한다 방법 (1) 양 끝 값을 더한 후 중간값으로 기준을 잡는다
		 * (2) 찾는 값과 중간값을 비교한다 (3) if 찾는 값 < 기준값 → 기준값보다 작은 범위의 값들을 다시 검색 if 찾는 값 > 기준값
		 * → 기준값보다 큰 범위의 값들을 다시 검색 (4) 위의 과정을 반복하여 값을 찾는다
		 * 
		 * 위의 과정 다시 정리해보면 1. 기준 인덱스(공간번호) 찾는다 2. 정렬이 되어있어야 한다 (기본적으로 오름차순 ASC) 3. 기준 값과
		 * 비교해서 기준 값보다 작으면 왼쪽, 크면 오른쪽 장점: 순차 탐색보다는 데이터 검색이 더 빠르다 단점: 정렬이 안되어 있으면 이분탐색을 할
		 * 수 없다
		 * 
		 */

		binarySearch();
		
	}

}
