package For;

import java.util.Random;
import java.util.Scanner;

public class ForEx {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		/*
		 * while문 → 반복 위해 초기값을 설정하고 증감식까지 작성 필요 for문 → 가독성을 높이기 위함 동작의 순서는 while문과 같지만
		 * 코드 작성법이 조금 다르다 while문 : 위에서부터 순서대로 작성 for문 : 초기식; 비교식; 증감식 순서로 작성
		 * 
		 */

//		// 1 ~ 100
//		for(int i = 0; i < 100; i++) {
//			System.out.print((i+1) + " ");
//		}
//		
//		System.out.println();
//		
//		// 1 ~ 100 까지 합
//		int sum = 0;
//		for(int i = 1; i <= 100; i++) {
//			sum += i;
//		} System.out.println(sum);
//		
//		// 1 ~ 100 홀수
//		for(int i = 0; i < 100; i++) {
//			System.out.print(++i + " ");
//		}
//		
//		System.out.println();
//		
//		for(int i = 0; i < 100; i++) {
//			if(i % 2 != 0) {
//			System.out.print(i + " ");
//			}
//		}
//		
//		System.out.println();
//		
//		// 1 ~ 100 홀수의 합
//		int sum1 = 0;
//		for(int i = 0; i < 100; i++) {
//			++i;
//			sum1 += i;
//		} System.out.println(sum1);
//		
//		int sum2 = 0;
//		for(int i = 0; i < 100; i++) {
//			if(i % 2 != 0) {
//				sum2 += i;
//			}
//		}System.out.println(sum2);
//		
//		// 랜덤학생
//		int[] arr = new int[10];
//		int sum = 0;
//		int count = 0;
//		int max = arr[0];
//		int index = 0;
//		
//		System.out.println("학생 10명의 성적: ");
//		for(int i = 0; i < 10; i++) {
//			arr[i] = rd.nextInt(100) + 1;
//			sum += arr[i];
//			if(arr[i] >= 60) {
//				count++;
//			}
//			System.out.print(arr[i] + "점 ");
//			if(max < arr[i]) {
//				max = arr[i];
//				index = i;
//			}
//		}
//		System.out.println();
//		System.out.println("전교생의 총점, 평균: " + sum + "점, " + sum/10 + "점");
//		System.out.println("합격자 수: " + count + "명");
//		System.out.println("1등 학생의 번호, 성적: " + (index + 1) + "번, " + max + "점");

//		// 단체 유니폼
//
//		int people = 0;
//		while (true) {
//			System.out.print("사람들의 수: ");
//			people = sc.nextInt();
//			if (people < 1 || people > 100) {
//				System.out.println("사람들의 수를 다시 입력하세요.");
//				continue;
//			}
//			break;
//		}
//		
//		int[] arr = new int[people];
//
//		int countS = 0, countM = 0, countL = 0, countXL = 0;
//
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print("덩치: ");
//			int n = sc.nextInt();
//			arr[i] = n;
//			if (n < 95) {
//				countS++;
//			} else if (n < 100) {
//				countM++;
//			} else if (n < 105) {
//				countL++;
//			} else if (n >= 105) {
//				countXL++;
//			}
//			System.out.println();
//		}
//		System.out.println("주문해야하는 S, M, L, XL의 수: " + countS + ", " + countM + ", " + countL + ", " + countXL);

		// 카카오택시
		
		// 목적지(destination)
		int desX = 0;
		desX = rd.nextInt(20) - 10;
		int desY = 0;
		desY = rd.nextInt(20) - 10;

		// 현재 위치
		int x = 0;
		int y = 0;

		// 방향(direction)
		int dir = 0;

		// 속도
		int speed = 0;

		// 요금
		int fee = 0;
		
		// 이동거리
		int move = 0;

		boolean run = true;
		while (run) {

			System.out.println("= 카카오 택시 =");
			System.out.println("목적지 : " + desX + "," + desY);
			System.out.println("현위치 : " + x + "," + y);
			System.out.println("방   향 : " + dir);
			System.out.println("속   도 : " + speed);
			System.out.println("============");

			System.out.println("1.방향설정");
			System.out.println("2.속도설정");
			System.out.println("3.이동하기");

			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();

			if (sel == 1) {
				System.out.print("방향설정 동(1)서(2)남(3)북(4): ");
				dir = sc.nextInt();
			} else if (sel == 2) {
				System.out.print("속도설정 1 ~ 3: ");
				speed = sc.nextInt();
			} else if (sel == 3) {
				System.out.print("이동하기: ");
				move = sc.nextInt();
				fee += (move * speed * 50);
				if(dir == 1) {
					x += move * speed;
				}else if(dir == 2) {
					x -= move * speed;
				}else if(dir == 3) {
					y -= move * speed;
				}else if(dir == 4) {
					y += move * speed;
				}
			}
			if(x == desX && y == desY) {
				run = false;
			}
		}System.out.println("요금은 " + fee + "원 입니다.");

	}

}
