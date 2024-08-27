package ArrayEx;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores = {87, 11, 45, 98, 23};
		
		/*
		 * <순서도>
		 * 1. 학번 입력
		 * 2. 학번 배열에서 검색 // 내 풀이: 1,2번 바꿔서 작성
		 * 
		 * 
		 */
		
//		System.out.print("학번 입력 : ");
//		int h = sc.nextInt();
//		
//		for(int i = 0; i < hakbuns.length; i++) { 
//				if(h == hakbuns[i]) {
//					System.out.println("성적 : " + scores[i] + "점");
//				}
//		
//		}
		
		// 강사님 풀이
//		System.out.print("학번 입력: ");
//		int find = sc.nextInt();
//		int size = hakbuns.length;
//		int i = 0;
		
		// 데이터 있는지 확인
//		boolean check = false;
//		
//		while(i < size) {
//			if(hakbuns[i] == find) {
//				System.out.println("성적: " + scores[i] + "점");
//				check = true;
//				break;
//			}
//			i++;
//		} 
		/*
		 *  while문 이후 반복문에서 학번을 찾으면 check = true;
		 *  못찾으면 check = false; 로 끝날 것 !
		 *   
		 */
//		if(!check) {
//			System.out.println("해당학번은 존재하지 않습니다.");
//		}
		

//		System.out.print("학번 입력 : ");
//		int h = sc.nextInt();
//		
//		boolean c = false;
//		for(int i = 0; i < hakbuns.length; i++) {
//				if(hakbuns[i] == h) {
//					System.out.println("성적 : " + scores[i] + "점");
//			        c = true;
//			        break;
//				} 
//		}
//		if(!c){
//		    System.out.println("해당학번은 존재하지 않습니다.");
//		}
//		for문으로 활용
		
		/*
		 * Arrays클래스 : 배열들을 다루기 위한 기능(메소드) 포함
		 * binarySearch(배열명, 찾는 값)
		 * 데이터가 있으면 공간번호(인덱스), 없으면 음수로 반환
		 * 이진탐색 기법은 무조건 정렬 되어 있어야한다
		 * → 문자 검색할 땐 대,소문자까지 비교하기 때문
		 * Arrays.sort()
		 * → sort 오름차순 정렬
		 * 
		 */
		
//		int index = Arrays.binarySearch(hakbuns, find);
//		System.out.println("결과 : " + index);
//		
//		if(index >= 0) {
//			System.out.println(scores[index]);
//		}else {
//			System.out.println("해당학번은 존재하지 않습니다.");
//		}
		
		/*
		 *  학번 배열은 정렬되어 있으므로 binarySearch가 가능하고
		 *  그에 대한 값은 인덱스 값으로 나오게 됨
		 *  → 따라서 int 변수로 선언
		 *  
		 */
		
		/*
		 * 암묵적으로 index 반환 시 -1은 인덱스번호를 찾지 못했다란 뜻
		 * 배열의 인덱스 번호는 마이너스가 나올 수 없다(파이썬은 가능)
		 *  
		 */
		
		// 인덱스 번호를 이용해서 가장 큰 값 구하기
		
		//System.out.println("1등 학생의 학번, 성적: " + hakbuns[m] + ", " + max + "점");
//		int m = 0;
//		int max = 0;
//		int index = 0;
//		
//		while(m < size - 1) {
//			if(scores[m] > max) {
//				max = scores[m];
//				index = m;
//			}
//			m++;
//		} System.out.println("1등 학생의 학번(성적): " + hakbuns[index] + "번(" + max + ")점");
		
		// 강사님 풀이
		
		/*
		 * max = 0; 이 되면 가장 큰 값은 구하기 쉽지만 가장 작은 값을 구할 땐 문제가 생길 수 있다
		 * max나 min의 값은 배열의 0번째 값으로 기준잡는게 더 효율적이다
		 * 
		 */
		
		int maxScore = scores[0];
		int maxIndex = 0;
		
		int i = 1;
		
		while(i < scores.length) {
			if(scores[i] > maxScore) {
				maxScore = scores[i];
				maxIndex = i;
			}
			i++;
		} System.out.println("1등 학생의 학번(성적): " + hakbuns[maxIndex] + "번(" + maxScore + ")점");
		
		
		
	}

}
