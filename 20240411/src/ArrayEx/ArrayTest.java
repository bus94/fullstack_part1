package ArrayEx;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
//		// 문제 1번
//		int[] arr = {87, 11, 92, 14, 47};
//		for(int num : arr) {
//			System.out.print(num + " ");
//		}System.out.println();
//		
//		// 문제 2번
//		int total = 0;
//		
//		for(int tot : arr) {
//			total += tot;
//		} 
//		System.out.println("총점 : " + total + "점");
//		System.out.println("평균 : " + (double) total / arr.length + "점");
//		
//		// 문제 3번
//		int count = 0;
//		
//		for(int pass : arr) {
//			if(pass >= 60) {
//				count++;
//			}
//		}System.out.println("합격생 수 : " + count + "명");
//		
//		// 위의 for문을 while문으로
//		int s = 0;
//		
//		while(s <= 4) {
//			if(arr[s] >= 60) {
//				count++;
//			}
//			s++;
//		} System.out.println("합격생 수 : " + count + "명");
//		
//		
//		// 문제 4번
//		System.out.print("인덱스 입력(0~4) : ");
//		int index = sc.nextInt();
//		
//		System.out.println("성적 : " + arr[index] + "점");
//		
//		// 문제 5번
//		System.out.print("87, 11, 45, 98, 23 중 하나의 성적 입력 : ");
//		int score = sc.nextInt();
//		
//		for(int i = 0; i < arr.length; i++) {
//			if(score == arr[i]) { // → 순차탐색 : 순서대로 탐색하는 방법 / 배열의 길이가 길면 처리 속도가 느려짐
//				System.out.println("인덱스 : " + i);
//			}
//		}
//		// 위의 for문을 while문으로
//		int i = 0;
//		
//		while(i < 5) {
//			if(score == arr[i]) {
//				System.out.println("인덱스 : " + i);
//				break;
//			}
//			i++;
//		}
//		
//		
//		// 문제 6번
//		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
//		int[] scores = {87, 11, 45, 98, 23};
//		
//		System.out.print("학번 입력 : ");
//		int h = sc.nextInt();
//		
//		for(int i = 0; i < hakbuns.length; i++) {
//				if(h == hakbuns[i]) {
//					System.out.println("성적 : " + scores[i] + "점");
//				}
//		}
		
		// 문제 7번
//		int[] array = new int[10];
//		for(int i = 0; i < array.length; i++) {
//			array[i] = i + 1;
//			System.out.print(array[i] + " ");
//		} 
//		// while문으로
//		int i = 0;
//		while(i < 10) {
//			array[i] = i + 1;
//			System.out.print(array[i] + " ");
//			i++;
//		}
//		
//		// 문제 8번
//		int[] array = new int[10];
//		for(int i = 0; i < array.length; i++) {
//			array[i] = array.length - i;
//			System.out.print(array[i] + " ");
//		} 
//		
//		// 문제 9번
//		System.out.println("양의 정수 : ");
//		int i = sc.nextInt();
//		
//		int[] array = new int[i];
//		
//		for(int j = 0; j < array.length; j++) {
//			array[j] = j + 1;
//			System.out.println(array[j] + " ");
//		}
//		// 강사님 풀이 (while 문을 이용)
//	    System.out.print("배열 개수: ");
//		int num = sc.nextInt();
//		
//		int[] arr = new int[num];
//		
//		int start = 1;
//		int i = 0;
//		
//		while(i < num) {
//		    arr[i] = start;
//		    System.out.println(arr[i]);
//		    
//		    start++;
//		    i++;
//		}
		
		// 문제 10번
//		String[] fruit = {"사과", "귤", "포도", "복숭아", "참외"};
//		System.out.println(fruit[1]);
		
		// 숫자이동[1단계]
		int[] game = {0, 0, 2, 0, 0, 0, 0};
		
		int player = -1;
		for(int i = 0; i < 7; i ++) {
			if(game[i] == 2) {
				player = i;
			}
		}
		
		System.out.println("1. 왼쪽    2. 오른쪽");
		
	}
}