package ClassArray;

import java.util.Scanner;

/*	과정명
 * Java Application 개발을 위한 프로그래밍 기초
 * (오후) 자료구조 및 알고리즘
 * 
 */

class Employee {
	int empNo;
	String empName;
	String dept;
	String job;
	int age;
	char gender;
	int salary;
	double bonusPoint;
	String phone;
	String address;

	// 메서드 : 클래스 안에 있는 함수
	// 특별한 메서드 : 클래스 멤버들을 하나의 문자열로 만드는 경우 (@Override로 입력하기)
	void information(int e, String emp, char g, String p) {
		empNo = e;
		empName = emp;
		gender = g;
		phone = p;

	}

	@Override
	public String toString() {
		return "Employee empNo=" + empNo + ", empName=" + empName + ", dept=" + dept + ", job=" + job + ", age=" + age
				+ ", gender=" + gender + ", salary=" + salary + ", bonusPoint=" + bonusPoint + ", phone=" + phone
				+ ", address=" + address + "";
	}

}

public class ClassArrayEx3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Employee emp1 = new Employee();
		emp1.information(100, "홍길동", '남', "010-1234-5678");
		System.out.println(emp1.toString());

		Employee emp2 = new Employee();
		emp2.information(101, "김길순", '여', "010-7894-1234");
		System.out.println(emp2.toString());

		Employee[] list = new Employee[5];
		list[0] = emp1;
		list[1] = emp2;

		// count를 2가지로 활용할 것!
		// 1) 직원 수
		// 2) 배열의 공간의 번호로 사용
		int count = 2;

		while (true) {
			System.out.println("1. 사원추가      ");
			System.out.println("2. 사원수정      ");
			System.out.println("3. 사원삭제      ");
			System.out.println("4. 사원출력      ");
			System.out.println("9. 프로그램종료 ");
			System.out.println("현재 직원수:" + count + "명");
			System.out.print("메뉴번호를 누르세요: ");
			int sel = sc.nextInt();

			switch (sel) {
			case 1:
				if (count < 5) {
					Employee e = new Employee();

					System.out.print("사원 번호: ");
					e.empNo = sc.nextInt();

					sc.nextLine();
					System.out.print("사원 이름: ");
					e.empName = sc.nextLine();

					System.out.print("사원 성별: ");
					e.gender = sc.nextLine().charAt(0);

					System.out.print("전화 번호: ");
					e.phone = sc.nextLine();

					list[count] = e;
					count++;
				} else {
					System.out.println("배열의 공간이 가득 찼다!");
				}
				break;

			case 2:
				boolean che = false;
				while (!che) {
					System.out.println("가장 최신의 사원 정보를 수정하게 됩니다.\n사원의 어떤 정보를 수정하시겠습니까?");
					Employee update = list[count - 1];
					System.out.println("1. 전화번호");
					System.out.println("2. 사원연봉");
					System.out.println("3. 보너스율");
					System.out.println("9. 돌아가기");
					System.out.print("메뉴번호를 누르세요 : ");
					int cho = sc.nextInt();

					switch (cho) {
					case 1:
						sc.nextLine();
						System.out.print("수정할 전화번호 : ");
						update.phone = sc.nextLine();
						break;

					case 2:
						System.out.print("사원 연봉 : ");
						update.salary = sc.nextInt();
						break;

					case 3:
						System.out.print("보너스율 : ");
						update.bonusPoint = sc.nextDouble();
						break;

					case 9:
						System.out.println("메인 메뉴로 돌아갑니다.");
						che = !che;
					}
				} 
				break;

			case 3:
				sc.nextLine();
				boolean check = false;
				while (!check) {
					System.out.print("정말 삭제하시겠습니까? (y/n) : ");
					String answer = sc.nextLine();

					switch (answer) {
					case "y":
					case "Y":
						Employee delete = list[count - 1];
//						count--; // 고정된 배열에서 count를 줄이면서 [인덱스 = count-1]인 데이터를 숨길 수 있다.
//						         // → 데이터가 삭제되는 건 아님
						list[count - 1] = null;
						count--;
						check = !check;
						System.out.println("데이터 삭제에 성공하셨습니다.");
						break;

					case "n":
					case "N":
						check = !check;
						break;

					default:
						System.out.println("잘못 입력하셨습니다.\n다시 입력해주세요.");
					}
				}
				break;

			case 4:
				for (int i = 0; i < count; i++) {
					System.out.println("1) 사원 번호: " + list[i].empNo);
					System.out.println("2) 이      름: " + list[i].empName);
					System.out.println("3) 성      별: " + list[i].gender);
					System.out.println("4) 전화 번호: " + list[i].phone);
				}
				break;

			case 9:
				System.out.println("종료!");
				return;

			}
		}

	}

}
