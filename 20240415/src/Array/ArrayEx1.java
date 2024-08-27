package Array;

import java.util.Random;

public class ArrayEx1 {

	public static void main(String[] args) {
		/*
		 * 2차원 배열
		 * 
		 */
		
		int[][] arr = new int[3][3];
		
		/* 
		 * 행 i, 열 j 로 생각하고 i로 외부, j로 내부 기준으로 코딩
		 * 
		 */
		
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;
		
		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		
		arr[2][0] = 70;
		arr[2][1] = 80;
		arr[2][2] = 90;
		
		for(int i = 0; i <= 2; i++) {
			
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
			
		}
		
		Random random = new Random();
		
		int rand = random.nextInt(6) + 1;
		
		int[] result = new int[100];
		int dice = 0;
		int[] diceCount = new int[6];
		
//		for(int i = 0; i < result.length; i++) {
//			
//			dice = rand;
//			result[i] = dice;
//			
//			switch(dice) {
//			case 1:
//				diceCount[0]++;
//				break;
//				
//			case 2:
//				diceCount[1]++;
//				break;
//				
//			case 3:
//				diceCount[2]++;
//				break;
//				
//			case 4:
//				diceCount[3]++;
//				break;
//				
//			case 5:
//				diceCount[4]++;
//				break;
//				
//			case 6:
//				diceCount[5]++;
//				break;
//			}
//			
//			System.out.println((i+1) + " : " + diceCount[i] + "번");
//		}
		
		// 강사님 풀이
		
		int[] nums = new int[6];
		
		for(int i = 1; i <= 100; i++) {
			nums[random.nextInt(6)]++;
		}
		
		for(int i = 1; i < 101; i++) {
			switch(random.nextInt(6)) {
			case 1:
				nums[0]++;
				break;
			case 2:
				nums[1]++;
				break;
			case 3:
				nums[2]++;
				break;
			case 4:
				nums[3]++;
				break;
			case 5:
				nums[4]++;
				break;
			case 6:
				nums[5]++;
				break;
			}
		}
		
	}

}
