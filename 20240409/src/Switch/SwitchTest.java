package Switch;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		// 비밀번호
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("비밀번호 입력(1000~9999) : ");
//		int pw = sc.nextInt();
//		
//		int pw1 = pw / 1000;
//		int pw2 = (pw % 1000) / 100;
//		int pw3 = (pw % 100) / 10;
//		int pw4 = (pw % 10);
//
//		if(pw > 9999 || pw < 1000) {
//			System.out.println("자리수 안맞음");
//		} else if(pw1 == pw2) {
//			System.out.println("실패");
//		} else if (pw2 == pw3) {
//			System.out.println("실패");
//		} else if (pw3 == pw4) {
//			System.out.println("실패");
//		} else if (pw4 == pw1) {
//			System.out.println("실패");
//		} else if (pw2 == pw4) {
//			System.out.println("실패");
//		} else if (pw1 == pw3) {
//			System.out.println("실패");
//		} else {
//			System.out.println("성공");
//		}

		// 학생수준평가 합격여부
//		System.out.print("영어 점수 입력 : ");
//		int eng = sc.nextInt();
//		System.out.print("수학 점수 입력 : ");
//		int mat = sc.nextInt();
//		
//		if(eng + mat <110) {
//			System.out.println("불합격 : 총합 점수가 부족합니다.");
//		} else if(eng < 40) {
//			System.out.println("불합격 : 영어 점수가 부족합니다.");
//		} else if(mat < 40) {
//			System.out.println("불합격 : 수학 점수가 부족합니다.");
//		} else {
//			System.out.println("합격");
//		}
		
		// 연습3
//		System.out.print("손가락 둘레 : ");
//		int size = sc.nextInt();
//		
//		if(size < 51 || size > 55) {
//			System.out.println("반지 제작 불가");
//		} else if(size > 51 && size <= 52) {
//			System.out.println("9호 추천");
//		} else if(size > 52 && size <= 53) {
//			System.out.println("10호 추천");
//		} else if(size > 53 && size <= 54) {
//			System.out.println("11호 추천");
//		} else if(size > 54 && size <= 55) {
//			System.out.println("12호 추천");
//		}
		
		// 연습4
//		System.out.println("1. +" + "\n" +
//							"2. -" + "\n" +
//							"3. *" + "\n" +
//							"4. /" + "\n");
//		System.out.print("원하는 연산 번호 입력: ");
//		int cal = sc.nextInt();
//		System.out.print("첫번째 수 : ");
//		int a = sc.nextInt();
//		System.out.print("두번째 수 : ");
//		int b = sc.nextInt();
//		int cal1 = 0;
//		
//		if(cal == 1) {
//			cal1 = a + b;
//		} else if(cal == 2) {
//			cal1 = a - b;
//		} else if(cal == 3) {
//			cal1 = a * b;
//		} else if(cal == 4) {
//			cal1 = a / b;
//		} else {
//			System.out.println("연산 번호 재입력");
//			return;
//		}
//		
//		System.out.println(cal1);
		
//		// 5번
//		System.out.print("해당 연도 : ");
//		int year = sc.nextInt();
//		
//		if(year % 400 == 0) {
//			System.out.println("윤년");
//		} else if(year % 4 == 0 && year % 100 != 0) {
//			System.out.println("윤년");
//		} else {
//			System.out.println("윤년이 아니다");
//		}
		
		// 6번 (p23)
		
		
		
	} 
} 

// year % 4 == 0 && year % 100 != 0 || year % 400 == 0
// F && T || T => 4로 나누어 떨어지지 않고 10으로 나누어짐 F || T
// 400으로 나누어 떨어져도 윤년
