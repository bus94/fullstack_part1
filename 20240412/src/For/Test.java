package For;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//		System.out.print("규정 속도 : ");
//		int speed = sc.nextInt();
//
//		System.out.print("도로를 달리는 차의 수 : ");
//		int countCar = sc.nextInt();
//
//		int[] cars = new int[countCar];
//		int count = 0;
//		int a = 0, b = 0, c = 0;
//
//		System.out.print("달리는 차의 속도 : ");
//		for (int i = 0; i < countCar; i++) {
//			int carS = sc.nextInt();
//
//			if (carS >= (int) (speed * 1.1) && carS < (int) (speed * 1.2)) {
//				count += 3;
//				a++;
//			} else if (carS >= (int) (speed * 1.2) && carS < (int) (speed * 1.3)) {
//				count += 5;
//				b++;
//			} else if (carS >= (int) (speed * 1.3)) {
//				count += 7;
//				c++;
//			}
//		}
//		System.out.println("10% 이상 20% 미만 위반 : " + a + "대 " + 3*a + "만원");
//		System.out.println("20% 이상 30% 미만 위반 : " + b + "대 " + 5*b + "만원");
//		System.out.println("30% 이상              위반 : " + c + "대 " + 7*c + "만원");
//		System.out.println("모든 차의 벌금 : " + "총 " + (a+b+c) + "대 " + (3*a + 5*b + 7*c) + "만원 입니다.");
		
		
		// 태권도, 500m 달리기, 사격 경기
		
//		#문제4
//		종목은 태권도, 500m 달리기, 사격 경기를 하려 합니다. 종목별 점수 산출 방식은 다음과 같습니다.
//
//		| 종목        | 점수 산출 방식                                                                      |
//		|-------------|----------------------------------------------------------------------------------------|
//		| 태권도   | 25경기 이상 승리하면 250점. 그 외에는 승리당 8점               |
//		| 500m 달리기 | 60초에 완주 시 250점. 그보다 빠르면 1초당 +5점 느리면 1초당 -5점                        |
//		| 사격        | 10번 사격해 과녁에 적힌 숫자의 합만큼 점수 획득. 7번 이상 10점에 맞추면 추가 점수 100점  |
//
//		태권도에서 승리한 횟수 taekwondo, 달리기 기록 running, 사격 기록이 담긴 배열 shooting이 매개변수로 주어질 때, 이 선수가 획득한 총점수를 return 하도록 solution 메소드를 작성하려 합니다. 빈칸을 채워 전체 코드를 완성해주세요.
//
//		---
//		#####매개변수 설명
//		태권도에서 승리한 횟수 taekwondo, 달리기 기록 running, 사격 기록이 담긴 배열 shooting이 solution 메소드의 매개변수로 주어집니다.
//		* 태권도에서는 0회 이상 35회 이하 승리할 수 있습니다.
//		* 달리기 기록은 초 단위이며 40 이상 120 이하인 정수입니다.
//		* 사격은 총 10번 하며, 과녁에는 0부터 10까지의 숫자가 적혀있습니다.
//
//		---
//		#####return 값 설명
//		이 선수가 획득한 총점수를 return 해주세요.
//
//		---
//		#####예시
//
//		| taekwondo | running | shooting                            | return |
//		|-----------|---------|---------------------------------------|--------|
//		| 27        | 63    | [9, 10, 8, 10, 10, 10, 7, 10, 10, 10] | 679   |
//
//		#####예시 설명
//		태권도에서 25회 이상 승리했기 때문에 250점을 획득했습니다.
//		달리기에서 60초보다 3초 느렸기 때문에 250점에서 15점을 뺀 235점을 획득했습니다.
//		사격에서 과녁을 맞혀 94점을 받았고, 10점을 7번 맞췄기 때문에 추가 점수 100점을 받아 총 194점을 획득했습니다.
//		따라서 이 선수가 받은 총점수는 679점입니다.
		
		System.out.print("태권도 승리한 횟수: ");
		int taekwondo = sc.nextInt();
		
		System.out.print("달리기 기록: ");
		int running = sc.nextInt();
		
		System.out.print("사격 기록: ");
		int shooting = sc.nextInt();
		
		int ts = 0;
		int rs = 0;
		int ss = 0;
		
		int[] shootingRecord = new int[10];
		
		if(taekwondo >= 25) {
			ts = 250;
		} else {
			ts = taekwondo * 8;
		}
		
		if(running <= 60) {
			
		}
		
	}
}
