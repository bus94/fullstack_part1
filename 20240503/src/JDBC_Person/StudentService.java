package JDBC_Person;

import java.util.ArrayList;
import java.util.Scanner;

// 학생의 데이터베이스를 들어가기 전에 처리해야되는 클래스 (입,출력)

// jsp에서 service는 오로지 데이터베이스로 가기 위한 전처리만 하는 기능이다
public class StudentService {
	private Scanner sc = new Scanner(System.in);
	
	// (원래는 Service에 만드는 것이 아니다. → DAO)
	private ArrayList<Student> stuList = new ArrayList<Student>();
	
	// 학생의 데이터베이스에 접근하는 DAO의 객체를 가지고 있어야 된다.
	private StudentDAO dao = new StudentDAO();
	
	// 학생 메인 메뉴
	public void mainMenu() {
		int menu = 0;
		
		while (menu != 6) {
			while (true) {
				System.out.println("============================================");
				System.out.println(" 1.학생 추가 2.학생 조회 3.학생 수정 4.학생 삭제 5.학생 6.메인으로");
				System.out.println("============================================");
				System.out.print("원하는 메뉴를 입력하고 Enter키를 누르세요: ");
				menu = sc.nextInt();
				if (menu >= 1 && menu <= 6) {
					break;
				}
				System.out.println("메뉴는 1 ~ 3 사이의 정수로 입력해야 합니다.");
			}

			switch (menu) {
			
			case 1:
				insert();
				break;
				
				
			case 2:
				System.out.println("1. 전체 조회   2. 한 건 조회");
				System.out.print("원하는 메뉴를 입력하고 Enter키를 누르세요: ");
				int sel = sc.nextInt();
				
				if(sel == 1) {
					select();
				} else if(sel == 2) {
					selectByStudent();
				} else {
					System.out.println("1 ~ 2 사이의 정수로 입력하세요.");
				}
				
				break;
				
			case 3:
				// 학번으로 검색해서 학번이 있으면
				// 키와 몸무게 수정 메서드 DAO에서 작성
				update();
				break;
				
			case 4:
				delete();
				break;
				
			case 5:
				break;
				
			}
		}
		System.out.println("메인 메뉴로 돌아갑니다.");
	}
	
	private void delete() {
		System.out.print("삭제할 학번 입력: ");
		int hakbun = sc.nextInt();
		boolean s = dao.delete(hakbun);;
		if(s) {
			System.out.println("정상적으로 삭제!");
		}else {
			System.out.println("삭제 안됨!");
		}
	}

	private void update() {
		System.out.print("수정할 학생의 학번 입력: ");
		int hakbun = sc.nextInt();
		Student s = dao.selectByHakbun(hakbun);
		if(s != null) {
			System.out.print("수정할 키 입력: ");
			int updateH = sc.nextInt();
			System.out.print("수정할 몸무게 입력: ");
			int updateW = sc.nextInt();
			
			dao.updateByHakbun(hakbun, updateH, updateW);
			System.out.println("학생의 정보를 성공적으로 수정하였습니다.");
		} else {
			System.out.println("학생의 정보 수정을 실패하였습니다.");
		}
		
	}

	// 한 건 조회할 때 외부에서 사용할 메서드가 아니라면 private으로 숨겨도 된다.
	private void selectByStudent() {
		// 1. 어떤 학번을 조회할 것인지
		System.out.print("조회할 학생의 학번 입력: ");
		int hakbun = sc.nextInt();
		
		// 2. 먼저 학번이 있는지 검색하는 메서드
		// DAO에 학번을 검색할 수 있는 selectByHakbun(학번) 메서드 생성하기
		// 만약 학번이 있다면 학번의 정보를 출력
		// 한 행을 객체로 반환 받고 만약 없으면 찾는 학번은 없습니다! 출력
		// 출력은 무조건 서비스에서 하기
		
		// 내가 작성한 코드 (객체로 리턴값 받아서 출력)
		Student s = dao.selectByHakbun(hakbun);
		if(s != null) {
			System.out.println(hakbun + "번의 학생 정보입니다.");
			System.out.println("조회 결과: " + s);
		} else {
			System.out.println("찾는 학번의 학생이 없습니다.");
		}
	}

	// 전체 조회하기
	private void select() {
		stuList = dao.select();
		
		for(Student temp : stuList) {
			System.out.println(temp);
		}
				
	}

	// 추가하기
	public void insert() {
		sc.nextLine();
		System.out.print("학생 이름: ");
	    String name = sc.nextLine();
	    
	    System.out.print("학생 나이: ");
	    int age = sc.nextInt();
	    
	    System.out.print("학생 키: ");
	    int height = sc.nextInt();
	    
	    System.out.print("학생 몸무게: ");
	    int weight = sc.nextInt();
	    
	    System.out.print("학생 학년: ");
	    int grade = sc.nextInt();
	    sc.nextLine(); 
	    
	    System.out.print("학생 전공: ");
	    String major = sc.nextLine();
	    
	    // 7개의 변수를 하나로 묶어서 DAO한테 전송
	    Student stu1 = new Student(name, age, height, weight, grade, major);
	    
	    // DAO로 stu1을 넘긴다.
	    boolean res = dao.insert(stu1);
	    if(res) {
	    	System.out.println("정상적으로 추가되었습니다!");
	    }else {
	    	System.out.println("추가하지 못했습니다. 에러를 확인해주세요.");
	    }
	    
	}

	// 학생의 현재 수를 카운트 하는 메서드
	public int count() {
		return dao.count();
	}
}
