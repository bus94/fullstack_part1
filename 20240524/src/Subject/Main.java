package Subject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Service service = new Service();

		Scanner sc = new Scanner(System.in);

		int menu = 0;

		try {

			while (true) {
				System.out.println("1) 다음 중 올바른 것을 모두 고르시오. " + 
									"\na) 홍팍이의 프로그래밍 성적은 80점을 받아 A0(4.0)이다." + 
									"\nb) 라이언의 프로그램밍 성적은 79점을 받아 B+(3.5)이다." + 
									"\nc) 젤리의 대학 수학 성적은 68점을 받아 C+(2.5)이다." + 
									"\nd) 알파고의 영작문 성적은 91점을 받아 A+(5.0)이다.");

				System.out
						.println("2) 과목별 평균 시험점수를 다음과 같이 조회하시오.");

				System.out.println("3) 학생별 평균 학점(등급점수)을 수강성적으로부터 구하고, 해당 점수가 3.5 미만인 학생을 다음과 같이 조회하시오.");

				System.out.println("4) 모든 강의별 평균 학점(등급점수)을 구하고, 이보다 후하게 준 “꿀 강의” TOP3를 조회하시오.");

				System.out.println("0) 종료!");

				menu = sc.nextInt();

				switch (menu) {
				case 1:
					sc.nextLine();
					System.out.print("과목: ");
					String title = sc.nextLine();
					System.out.print("이름: ");
					String nickname = sc.nextLine();
					
					service.join1(new Student(title, nickname));
					break;
				case 2:
					service.join2();

					break;
				case 3:
					service.join3();
					break;
				case 4:
					service.join4();
					break;

				case 0:
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
