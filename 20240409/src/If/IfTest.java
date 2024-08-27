package If;

import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		// 두 수 비교하기
//		System.out.print("A B : ");
//		int A = sc.nextInt();
//		int B = sc.nextInt();
//		
//		if(A > B) {
//			System.out.println(">");
//		} else if(A < B) {
//			System.out.println("<");
//		} else {
//			System.out.println("==");
//		}
		
//		// 시험 성적
//		System.out.print("시험 점수 : ");
//		int score = sc.nextInt();
//		char result = ' ';
//		
//		if(score >= 90) {
//			result = 'A';
//		} else if(score >= 80) {
//			result = 'B';
//		} else if(score >= 70) {
//			result = 'C';
//		} else if(score >= 60) {
//			result = 'D';
//		} else {
//			result = 'F';
//		}
//		System.out.println(result);
		
//		// 윤년
//		System.out.print("연도 : ");
//		int year = sc.nextInt();
//		
//		if(year % 4 == 0) {
//			if(year % 100 != 0 || year % 400 == 0) {
//				System.out.println(1);
//			} else {
//				System.out.println(0);
//			}
//		} else {
//			System.out.println(0);
//		}
		
//		// BMI지수 계산
//		System.out.print("키(m)를 입력해 주세요 : ");
//		double height = sc.nextDouble();
//		System.out.print("몸무게(kg)를 입력해 주세요 : ");
//		double weight = sc.nextDouble();
//		
//		double bmi = weight / (height * height);
//		System.out.println("BMI 지수: " + bmi);
//		String bmiResult = "";
//		if(bmi < 18.5) {
//			bmiResult = "저체중";
//		} else if(bmi < 23) {
//			bmiResult = "정상체중";
//		} else if(bmi < 25) {
//			bmiResult = "과체중";
//		} else if(bmi < 30) {
//			bmiResult = "비만";
//		} else {
//			bmiResult = "고도 비만";
//		}
//		System.out.println(bmiResult);
		
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
	}

}
