package If_Game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class UpAndDown {

	public static void main(String[] args) {
		/* # Up & Down 게임[1단계]
		 * 1. com은 8이다.
		 * 2. me는 숫자를 하나입력받는다.
		 * 3. com 과 me 를 비교해서 다음과 같은 메세지를 출력한다.
		 * 1) me < com	: Up!
		 * 2) me == com : Bingo!
		 * 3) me > com  : Down!
		 */
		
		// 문제점: 1) com값이 정해져 있기에 난수로 설정 필요 2) 10회 실행하려면 10회를 Run 해야하는 불편(if만 사용한 경우)
		
		// 키보드 생성
		Scanner sc = new Scanner(System.in);
		// 랜덤클래스
		Random r = new Random();
		
//		// com 값을 난수로 설정 /* 랜덤클래스 변수명.nextInt(개수) + 시작수; */
//		int com = r.nextInt(10) + 1;
//		
//		System.out.print("숫자 입력 : ");
//		int me = sc.nextInt();
//		
//		if(me < com) {
//			System.out.println("Up!");
//		} else if(me == com) {
//			System.out.println("Bingo!");
//		} else if(me > com) {
//			System.out.println("Down!");
//		} 
//		
//		// 동전 1: 앞면, 0: 뒷면 / 랜덤값 2개
//		int coin = r.nextInt(2);
//		if(coin  == 1) {
//			System.out.println("앞면");
//		} else {
//			System.out.println("뒷면");
//		}
//		
//		// 로또 번호 6개 출력 / 1 ~ 45
//		// 중복 제거하는 방법 배우기! (아래의 코드는 중복 제거 못함)
		
		int[] array = new int[6];
		
		for(int i = 0; i < array.length;i++) {
			array[i] = r.nextInt(45) + 1; 
			for(int j = 0;j < i;j++) {
				if(array[j] == array[i]) {
					i--;
					break;
				}
			}
			
		}
		for(int i : array) {
			System.out.print(i + " ");
		}
//		System.out.println(Arrays.toString(array));
		
	}

}
