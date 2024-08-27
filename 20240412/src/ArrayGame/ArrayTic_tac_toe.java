package ArrayGame;

import java.util.Scanner;

public class ArrayTic_tac_toe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * # 틱택토 === 틱택토 === [X][X][O] [ ][O][ ] [ ][ ][ ] [p1] 인덱스 입력 : 6 === 틱택토 ===
		 * [X][X][O] [ ][O][ ] [O][ ][ ] [p1] 승리
		 * 
		 */

		/*
		 * 게임을 위한 배열 생성 배열 공간 생성 → 0으로 자동 저장 만약 0이면 빈 공간 [ ] (플레이어1,2) p1 : 1 → O / p2 :
		 * 2 → X 로 표현
		 * 
		 */

		int[] game = new int[9]; // 9칸만 생성

		// p1과 p2의 변수 체크값은 반복문 안에 작성x
		boolean check = true;
		
		/*
		 *  결과를 저장하는 변수
		 *  
		 *  
		 */
		int win = 0;

		while (true) {
			int i = 0;

			/*
			 * 3칸 씩 출력하기 위해 나눗셈 이용해서 공통된 값 찾기 %3 이용
			 */

			while (i < game.length) {

				/*
				 * 입력한 인덱스 값을 이용해서 배열의 실제값을 변경(기본 설정값: 0)해서 출력하기
				 * 
				 */

				if (game[i] == 0) {
					System.out.print("[ ]");
				} else if (game[i] == 1) {
					System.out.print("[O]");
				} else if (game[i] == 2) {
					System.out.print("[X]");
				}

				/*
				 * 나머지가 2가 되었을 때 줄바꿈
				 */

				if (i % 3 == 2) {
					System.out.println();
				}

				i++;

			}

//			if (check) {
//
//				System.out.print("[p1] 인덱스: ");
//				int p1 = sc.nextInt();
//				game[p1] = 1;
//				check = false;
//
//			} else {
//
//				System.out.print("[p2] 인덱스: ");
//				int p2 = sc.nextInt();
//				game[p2] = 2;
//				check = true;
//
//			}

			int curPlayer = check ? 1 : 2;

			System.out.print("[" + (check ? "p1" : "p2") + "] 인덱스 : ");
			int index = sc.nextInt();

			// index 변수 이용하여 game 배열 공간에 값을 가지고 와서 빈 공간인지 확인
			if (game[index] == 0) {
				game[index] = curPlayer;
			} else {
				System.out.println("이미 선택된 위치 입니다.");
				System.out.println("다시 입력하세요!");
				continue;
			}
			check = !check;
			
			
			// 승리 조건
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
		System.out.println((win == 1 ? "p1" : "p2") + " 승리!");
	}
	/*
	 * for문 for(int i = 0; i < 9; i++) {
	 * 
	 * if(game[i] == 0) { System.out.print("[ ]"); }
	 * 
	 * }
	 */

}
