package Array;

import java.util.Scanner;

public class ArrayEx3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] apt = { { 101, 102, 103 }, { 201, 202, 203 }, { 301, 302, 303 } };

		int[][] pay = { { 1000, 2100, 1300 }, { 4100, 2000, 1000 }, { 3000, 1600, 800 } };

		// 문제 1번
//		int sum1 = 0;
//		int sum2 = 0;
//		int sum3 = 0;
//		
//		for(int i = 0; i < apt.length; i++) {
//			for(int j = 0; j < apt.length; j++) {
//				if(i == 0) {
//					sum1 += pay[i][j];
//				}
//				if(i == 1) {
//					sum2 += pay[i][j];
//				}
//				if(i == 2) {
//					sum3 += pay[i][j];
//				}
//			}
//		}
//		System.out.println(sum1 + " " + sum2 + " " + sum3);

		// 문제 2번
//		System.out.print("호수 입력 : ");
//		int num = sc.nextInt();
//		
//		for(int i = 0; i < apt.length; i++) {
//			for(int j = 0; j < apt.length; j++) {
//				if(num == apt[i][j]) {
//					System.out.println("관리비 출력 : " + pay[i][j]);
//				}
//			}
//		}

		// 문제 3번
//		int maxPay = pay[0][0];
//		int minPay = pay[0][0];
//		int a = 0, b = 0, c = 0, d = 0;
//		
//		for(int i = 0; i < pay.length; i++) {
//			for(int j = 0; j < pay.length; j++) {
//				if(maxPay < pay[i][j]) {
//					a = i;
//					b = j;
//					maxPay = pay[a][b];
//				}
//				if(minPay > pay[i][j]) {
//					c = i;
//					d = j;
//					minPay = pay[c][d];
//				}
//			}
//		}
//		System.out.println("가장 많이 나온 집(" + apt[a][b] + "), " + "가장 적게 나온 집(" + apt[c][d] + ")" );

		// 문제 4번
//		System.out.print("호수 1 입력 : ");
//		int apt1 = sc.nextInt();
//		System.out.print("호수 2 입력 : ");
//		int apt2 = sc.nextInt();
//		
//		int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
//		
//		int tempPay = pay[i1][j1];
//		int tempApt = apt[i1][j1];
//		
//		for(int i = 0; i < pay.length; i++) {
//			for(int j = 0; j < pay.length; j++) {
//				if(apt1 == apt[i][j]) {
//					i1 = i;
//					j1 = j;
//				}
//				if(apt2 == apt[i][j]) {
//					i2 = i;
//					j2 = j;
//				}
//			}
//		}
//		tempPay = pay[i1][j1];
//		pay[i1][j1] = pay[i2][j2];
//		pay[i2][j2] = tempPay;
//		tempApt = apt[i1][j1];
//		apt[i1][j1] = apt[i2][j2];
//		apt[i2][j2] = tempApt;
//		
//		System.out.println("교체 후의 호수 1 관리비 : " + pay[i1][j1] + "\n" + "교체 후의 호수 2 관리비 : " + pay[i2][j2]);

		/*
		 * 단축키 Alt + Shift + a : 전체 편집
		 */
		// 최댓값
		int[][] arr = { { 3, 23, 85, 34, 17, 74, 25, 52, 65 }, 
				{ 10, 7, 39, 42, 88, 52, 14, 72, 63 },
				{ 87, 42, 18, 78, 53, 45, 18, 84, 53 }, 
				{ 34, 28, 64, 85, 12, 16, 75, 36, 55 },
				{ 21, 77, 45, 35, 28, 75, 90, 76, 1 }, 
				{ 25, 87, 65, 15, 28, 11, 37, 28, 74 },
				{ 65, 27, 75, 41, 7, 89, 78, 64, 39 }, 
				{ 47, 47, 70, 45, 23, 65, 3, 41, 44 },
				{ 87, 13, 82, 38, 31, 12, 29, 29, 80 } };

		System.out.print("입력하는 수 : ");
		int num = sc.nextInt();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(num == arr[i][j]) {
					System.out.println((i+1) + " "+ (j+1));
				}
			}
		}
	}
}
