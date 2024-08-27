package If;

import java.util.Scanner;

public class If_Ex3 {

	private static double l;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 두 수 비교하기
		System.out.print("A B : ");
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A > B) {
			System.out.println(">");
		} else if(A < B) {
			System.out.println("<");
		} else {
			System.out.println("==");
		}
		
		// 시험 성적
		System.out.print("시험 점수 : ");
		int score = sc.nextInt();
		char result = ' ';
		
		if(score >= 90) {
			result = 'A';
		} else if(score >= 80) {
			result = 'B';
		} else if(score >= 70) {
			result = 'C';
		} else if(score >= 60) {
			result = 'D';
		} else {
			result = 'F';
		}
		System.out.println(result);
		
		// 윤년
		System.out.print("연도 : ");
		int year = sc.nextInt();
		
		if(year % 4 == 0) {
			if(year % 100 != 0 || year % 400 == 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		} else {
			System.out.println(0);
		}
		// → 위의 코드를 다른 코드로 작성하는 경우
//		boolean isYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
//		System.out.println((isYear)? 1 : 0 );
		
		// BMI지수 계산
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (height * height);
		System.out.println("BMI 지수: " + bmi);
		String bmiResult = "";
		if(bmi < 18.5) {
			bmiResult = "저체중";
		} else if(bmi < 23) {
			bmiResult = "정상체중";
		} else if(bmi < 25) {
			bmiResult = "과체중";
		} else if(bmi < 30) {
			bmiResult = "비만";
		} else {
			bmiResult = "고도 비만";
		}
		System.out.println(bmiResult);
		
		// 두 개의 정수와 연산 기호 입력
		System.out.print("피연산자1 입력 : ");
		int n1 = sc.nextInt();
		System.out.print("피연산자2 입력 : ");
		int n2 = sc.nextInt();
		sc.nextLine();
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
		String oper = sc.nextLine();
		// 한 문자를 가져올 수 없기에 String을 사용
		// char를 사용하는 경우 ("작은 따옴표 써야하는 것 주의하기")
		// char oper = sc.nextLine().charAt(0);
		// → 작성한 내용의 0번째 인덱스의 문자를 사용하겠다라는 뜻
		// 이렇게 되면 == 으로 문자가 같은지 비교 가능 
		// String은 데이터 값을 비교 → equals를 사용
		double sol = 0;
		
		if(oper.equals("+")) {
			sol = (n1 + n2);
		} else if(oper.equals("-")) {
			sol = (n1 - n2);
		} else if(oper.equals("*")) {
			sol = (n1 * n2);
		} else if(oper.equals("/")) {
			sol = ((double) n1 / n2);
		} else if(oper.equals("%")) {
			sol = (n1 % n2);
		} else {
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		}
		
		System.out.println(n1 + " " + oper + " " + n2 + " = " + sol);
		// 자동정렬 : Ctrl + Shift + f
		
		// Pass, Fail
		System.out.print("중간고사 점수 : ");
		int ms = sc.nextInt();
		System.out.print("기말고사 점수 : ");
		int fs = sc.nextInt();
		System.out.print("과제 점수 : ");
		int ws = sc.nextInt();
		System.out.print("출석회수 : ");
		int ds = sc.nextInt();
		
		double m = ms*20/100;
		double f = fs*30/100;
		double w = ws*30/100;
		double d = ds;
		double s = m + f + w + d ;
		String r = "";
		
		System.out.println("=================결과=================");
		System.out.println("중간 고사 점수(20) : " + m);
		System.out.println("기말 고사 점수(30) : " + f);
		System.out.println("과제 점수           (30) : " + w);
		System.out.println("출석 점수           (20) : " + d);
		System.out.println("총점 : " + s);
		
		if(s < 70 || ds <= (20*70/100)) {
			r = "Fail [점수 미달]";
		} else {
			r = "Pass";
			}
		System.out.println(r);
		
//		// 사분면 고르기
		System.out.print("x좌표: ");
		int x = sc.nextInt();
		System.out.print("y좌표: ");
		int y = sc.nextInt();
		int Qu = 0;
		
		if(x > 0 && y > 0) {
			Qu = 1;
		} else if(x < 0 && y > 0) {
			Qu = 2;
		} else if(x < 0 && y < 0) {
			Qu = 3;
		} else if(x > 0 && y < 0) {
			Qu = 4;
		}
		System.out.println(Qu);
		
		// 알람 시계
		System.out.print("몇 시 : ");
		int H = sc.nextInt();
		System.out.print("몇 분 : ");
		int M = sc.nextInt();
		String alarm = "";
		int M1 = (M-45 >= 0)? M - 45  : M + 60 - 45;
		int H1 = (H - 1 >= 0)? H - 1 : 23;
		
		System.out.println(H1 + ":" + M1);
	}
}
