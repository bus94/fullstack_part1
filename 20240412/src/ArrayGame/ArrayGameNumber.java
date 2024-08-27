package ArrayGame;

import java.util.Scanner;

public class ArrayGameNumber {

	public static void main(String[] args) {

		/*
		 * # 숫자이동[1단계] 1. 숫자2는 캐릭터이다. 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로 숫자2를 입력하면, 캐릭터가 오른쪽으로
		 * 이동한다. 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다. 4. {0, 0, 2, 0, 0, 0, 0}; ==> 왼쪽 ==>
		 * {0, 2, 0, 0, 0, 0, 0};
		 * 
		 */
		Scanner sc = new Scanner(System.in);

		int[] game = { 0, 0, 2, 0, 0, 0, 0 };

		/*
		 * 게임판 출력 배열의 값 기준으로 0일 땐 빈공간, 2일 땐 주인공(옷)으로 출력
		 * 
		 * 2(주인공)가 이동할 때, 주인공의 인덱스를 기억하는 변수 필요
		 * 
		 */

		int player = 2; // 주인공의 인덱스 기억하는 변수

		while (true) {

			int i = 0;

			while (i <= 6) {
				if (game[i] == 0) {
					System.out.print("_ ");
				} else if (game[i] == 2) {
					System.out.print("옷 ");
				}
				i++;
			}
			System.out.println();
			System.out.print("1) 왼쪽  2) 오른쪽 : ");
			int move = sc.nextInt();

			if (move == 1) {
				
				if (player - 1 >= 0) {
					// 왼쪽으로 이동하는 경우 해당 인덱스의 값이 이동할 수 있도록 설정 (배열의 값 변경)
					game[player - 1] = 2;
					game[player] = 0;
					// player의 인덱스가 줄어들 수 있도록 설정 (인덱스 값 변경)
					player--;
				}

			} else if (move == 2) {
				
				if (player + 1 < game.length) {
					game[player + 1] = 2;
					game[player] = 0;
					player++;
				}
				
			}

		} // while 끝

		/*
		 * 왼쪽 끝으로 가거나 오른쪽 끝으로 가면 에러 발생 ArrayIndexOutOfBoundsException
		 * 
		 * <해결 코드 작성> 왼쪽으로 갈 수 있는 공간이 있는지 검사 후 0보다 크거나 같을 경우 이동 만약 마이너스 값이 나오면 이동 x
		 * 
		 */

	}

}
