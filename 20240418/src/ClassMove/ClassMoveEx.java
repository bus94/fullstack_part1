package ClassMove;

class Student{ // Menu의 입장
	/*
	 * 학번, 수강과목
	 * 
	 * 클래스 안에 클래스 만들기
	 * Subject 수강과목에 대한 정보를 저장하는 클래스
	 * 
	 */
	
	int hakbun;
	Subject sub1 = new Subject();
	
}

class Subject{ // Controller의 입장
	// 과목에 대한 정보 저장하는 클래스 멤버 생성
	String subName;
	int score;
	
}

public class ClassMoveEx {

	public static void main(String[] args) {

		// 위의 있는 학생 객체를 먼저 만들어야 한다.
		Student temp = new Student();
		
		// 수강 과목의 이름 저장
		temp.sub1.subName = "Java";
		temp.sub1.score = 100;
		
		System.out.println("과목: " + temp.sub1.subName);
		System.out.println("과목 점수: " + temp.sub1.score);
		
	}

}
