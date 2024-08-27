package ClassArray;

class Student {
	String name;
	String subject;
	int score;
}

public class ClassArrayEx2 {

	public static void main(String[] args) {

		Student stu1 = new Student();
        stu1.name = "김길동";
        stu1.subject = "자바";
        stu1.score = 100;

        Student stu2 = new Student();
        stu2.name = "박길동";
        stu2.subject = "디비";
        stu2.score = 50;

        Student stu3 = new Student();
        stu3.name = "이길동";
        stu3.subject = "화면";
        stu3.score = 85;

        Student stu4 = new Student();
        stu4.name = "정길동";
        stu4.subject = "서버";
        stu4.score = 60;

        Student stu5 = new Student();
        stu5.name = "홍길동";
        stu5.subject = "자바";
        stu5.score = 20;
        
        // 위 학생들 중 이길동 있다면 이길동의 정보 출력해라!
        // 각각의 정보들로 일일이 확인해야됨
        // → if(stu1.equals("이길동")){
        // System.out.println(stu1.name);
        // } else {
        // System.out.println("아니다");
        // } 라는 식으로 확인
        // 위의 내용대로 확인하게 되면 가독성과 유지보수(변경, 추가, 삭제) ↓
        
        // 한 곳에 모아두기 위한 공간을 배열로 사용
        Student[] stuList = new Student[5];
        stuList[0] = stu1;
        stuList[1] = stu2;
        stuList[2] = stu3;
        stuList[3] = stu4;
        stuList[4] = stu5;
        
        for(int i = 0; i < stuList.length; i++) {
        	if(stuList[i].name.equals("이길동")) {
        		System.out.println("찾았다! " + (i+1) + "번째 학생");
        	}else {
        		System.out.println("아니다");
        	}
        }
        
        Student[] 강의장2 = new Student[20];
		
        for(int i = 0; i < stuList.length; i++) {
        	if(stuList[i].score >= 60) {
        	System.out.println("통과");
        }else {
        	System.out.println("재시험");
        }
	}
	}

}
