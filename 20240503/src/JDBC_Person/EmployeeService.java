package JDBC_Person;

import java.util.Scanner;

// 직원들의 정보를 입력하고 출력하는 클래스
// 전처리 (DB 가기 전)
public class EmployeeService {
	private Scanner sc = new Scanner(System.in);
	private EmployeeDAO dao = new EmployeeDAO();

	public void mainMenu() {
		int menu = 0;

		while (menu != 3) {
			while (true) {
				System.out.println("============================================");
				System.out.println(" 1.직원 추가    2.직원 조회    3.메인으로 돌아가기 ");
				System.out.println("============================================");
				System.out.print("원하는 메뉴를 입력하고 Enter키를 누르세요: ");
				menu = sc.nextInt();
				if (menu >= 1 && menu <= 3) {
					break;
				}
				System.out.println("메뉴는 1 ~ 3 사이의 정수로 입력해야 합니다.");
			}

			switch (menu) {

			case 1:
				insert();
				break;

			case 2:
				break;

			case 3:
				break;

			}
		}
		System.out.println("메인 메뉴로 돌아갑니다.");
	}

	private void insert() {
		sc.nextLine();
		System.out.print("직원 이름: ");
	    String name = sc.nextLine();
	    
	    System.out.print("직원 나이: ");
	    int age = sc.nextInt();
	    
	    System.out.print("직원 키: ");
	    int height = sc.nextInt();
	    
	    System.out.print("직원 몸무게: ");
	    int weight = sc.nextInt();
	    
	    System.out.print("직원 월급: ");
	    int salary = sc.nextInt();
	    sc.nextLine(); 
	    
	    System.out.print("직원 부서: ");
	    String dept = sc.nextLine();
	    
	    Employee emp1 = new Employee(name, age, height, weight, salary, dept);
	    
	    boolean res = dao.insert(emp1);
	    if(res) {
	    	System.out.println("정상적으로 추가되었습니다!");
	    }else {
	    	System.out.println("추가하지 못했습니다. 에러를 확인해주세요.");
	    }
	}

}
