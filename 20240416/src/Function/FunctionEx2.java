package Function;

import java.util.Scanner;

public class FunctionEx2 {

	public static void korScore() {
		Scanner sc = new Scanner(System.in);

		System.out.print("국어 점수를 입력하세요: ");
		int koreanScore = sc.nextInt();
	}
	
	public static void engScore() {
		Scanner sc = new Scanner(System.in);

		System.out.print("영어 점수를 입력하세요: ");
		int englishScore = sc.nextInt();
	}
	
	public static void matScore() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수학 점수를 입력하세요: ");
		int mathScore = sc.nextInt();
	}

	public static void input() {

		korScore();
		engScore();
		matScore();

	}

	public static void main(String[] args) {

		// 국어, 영어, 수학 점수 입력.
		// 국어 등급 B 입니다.
		// 영어 등급 A 입니다.
		// 수학 등급 C 입니다.

	}

}
