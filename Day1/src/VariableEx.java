
public class VariableEx {

	public static void main(String[] args) {
		// 변수 Variable : 값을 저장하는 공간
		
		int num;
		num = 10;
		System.out.println(num);
		
		// 4byte 공간에 정수 하나 저장
		int number;
		number = 100;
		System.out.println(number);
		
		// 8byte 실수 저장
		double hei = 12.34;
		System.out.println(hei);
		
		// 국어10, 수학95, 영어87
		int kor = 18, mat = 95, eng = 87;
	
		// 총점 평균
		int total = kor + mat + eng;
		double avg = (double)total / 3; // 계산 할 때만 형태 변환 후 실행
		// 왼쪽 타입 기준으로 자동으로 변경 : Casting 형변환 (자료형이 큰 자료형에 들어갈 수 있도록)
		// 자동으로 형변환(묵시적 형변환)
		// 강제로 형변환(명시적 형변환)
		
		// 실수 자릿수를 원하는 대로 출력 printf("%f",변수명);
		// printf() 는 줄바꿈이 포함되어있지 않다
		
		System.out.println("총점: " + total);
		System.out.println("평균: " + avg);
		System.out.printf("%f\n",avg);
		System.out.printf("%.5f\n",avg);
		System.out.printf("%.4f\n",avg);
		System.out.printf("%.3f\n",avg);
		System.out.printf("%.2f\n",avg);
		System.out.printf("%.1f\n",avg);

	}

}
