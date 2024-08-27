package ArrayGame;

import java.util.Scanner;

public class ArrayTic_tac_toe_practice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] game = new int[9]; 

		boolean check = true;
		
		int win = 0;
		
		while (true) {
			int i = 0;
		
			while (i < game.length) {
				
				if (game[i] == 0) {
					System.out.print("[ ]");
				} else if (game[i] == 1) {
					System.out.print("[O]");
				} else if (game[i] == 2) {
					System.out.print("[X]");
				}

				if (i % 3 == 2) {
					System.out.println();
				}

				i++;

			}
			
//			if (check) {
//				System.out.print("[p1] 인덱스 : ");
//				int p1 = sc.nextInt();
//				if(game[p1] != 0) {
//					System.out.println("다시 입력해주세요.");
//					continue;
//				}else
//				game[p1] = 1;
//				check = false;
//			} else {
//				System.out.print("[p2] 인덱스 : ");
//				int p2 = sc.nextInt();
//				if(game[p2] != 0) {
//					System.out.println("다시 입력해주세요.");
//					continue;
//				} else
//				game[p2] = 2;
//				check = true;
//			}
			
			/*
			 *  현재 플레이어가 p1인 경우 true
			 *			   p2인 경우 false
			 *
			 */
			int curPlayer = check? 1 : 2;
			
			System.out.print("[" + (check? "p1" : "p2") + "] 인덱스 : ");
			int index = sc.nextInt();
			
			// index 변수 이용하여 game 배열 공간에 값을 가지고 와서 빈 공간인지 확인
			if(game[index] == 0) {
				game[index] = curPlayer;
				check = !check;
			} else {
				System.out.println("이미 선택된 위치 입니다.");
				System.out.println("다시 입력하세요!");
				continue;
			}
			
			if (i % 3 == 0) {
				
				if (game[0] == 1) {
					System.out.println("p1 승리!");
					break;
				} else if (game[0] == 2) {
					System.out.println("p2 승리!");
					break;
				}
			}
			
			if((game[0] == curPlayer && game[4] == curPlayer && game[8] == curPlayer) || 
					(game[2] == curPlayer && game[4] == curPlayer && game[6] == curPlayer)) {
				win = curPlayer;
				break;
			}
			
			if((game[0] == curPlayer && game[1] == curPlayer && game[2] == curPlayer) ||
					(game[3] == curPlayer && game[4] == curPlayer && game[5] == curPlayer) ||
					(game[6] == curPlayer && game[7] == curPlayer && game[8] == curPlayer)) {
				win = curPlayer;
				break;
			}
			
			if((game[0] == curPlayer && game[3] == curPlayer && game[6] == curPlayer) ||
					(game[1] == curPlayer && game[4] == curPlayer && game[7] == curPlayer) ||
					(game[2] == curPlayer && game[5] == curPlayer && game[8] == curPlayer)) {
				win = curPlayer;
				break;
			}
			
		}
		
	}
	

}