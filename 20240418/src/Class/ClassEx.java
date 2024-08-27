package Class;

import java.awt.Image;
import java.time.LocalDateTime;

// 클래스의 첫 글자는 대문자
class 주민등록증{
  		String 이름;
  		String 주소;
  		String 주민번호;
  		String 발급기관;
  		int 발급일자;
  		Image 사진;
}

// 클래스 만드는 곳
class Board{
	int no; // 글번호
	String title; // 제목
	String content; // 내용
	String name; // 이름
	String id; // ID
	int readCount; // 조회수
	LocalDateTime date; // 게시일
}

class pokemon{
	String name;
	Image image;
	String type;
	double height;
	double weight;
	char gender;
	String property;
}

class naver_CreateAccount{
	String id;
	String pw;
	String email;
	String name;
	int birth;
	String mobileCarrier;
	char gender;
	String nationality;
	String phoneNumber;
}
   
public class ClassEx {

	public static void main(String[] args) {
		
		/*
		 *  <클래스 사용>
		 *  새로운 변수 만들기 (메모리의 새로운 공간을 생성)
		 *  new 주민등록증(); 을 반복해서 여러 인스턴스 생성
		 *   → 메모리 공간의 주소는 16진수로 저장 (0~9, a~f 총 16개로 표현)
		 *     → 확인 방법은 System.out.println(new 주민등록증()); 해보면 뒤의 숫자(0~9)와 소문자 알파벳(a~f)이 출력됨
		 *  
		 *  클래스명 변수명 = new 클래스명(); → 클래스명은 타입명이라고 생각하기 (ex. int 변수명 = new int();)
		 *  
		 */
		
		/*
		 * 클래스 
		 * - 변수 만들면 자동으로 초기화 진행
		 * - 정수(int) → 0
		 * - 실수(double) → 0.0
		 * - 문자 ' ', 문자 여러 개(문자열) → Null
		 * - boolean → false
		 * 
		 */
		
		주민등록증 jumin1 = new 주민등록증();
		System.out.println(new 주민등록증());
		// 클래스 내 각각의 변수에 데이터 저장
		jumin1.이름 = "홍길동";
		jumin1.주민번호 = "990101-1234567";
		jumin1.발급일자 = 20240418;
		jumin1.발급기관 = "서울시청";
		jumin1.주소 = "서울시 강남구";
		
		System.out.println(jumin1.이름);
		System.out.println(jumin1.발급일자);
		
		주민등록증 jumin2 = new 주민등록증();
		
		주민등록증 jumin3 = new 주민등록증();
		
		주민등록증 jumin4 = new 주민등록증();
		
		Board board1 = new Board();
		Board board2 = new Board();
		Board board3 = new Board();
		
		pokemon pokemon1 = new pokemon();
		pokemon1.name = "꼬부기";
		
		
		
		
	}

}
