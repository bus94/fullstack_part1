package PolymorphismTest;

import java.util.ArrayList; // ArrayList 사용하기 위함
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 여러 권의 책을 한꺼번에 저장 관리
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		//추가
		bookList.add(new CookBook("백종원의집밥", "백종원", "tvN", true));
		bookList.add(new AniBook("한번더해요", "미티", "원모어", 19));
		bookList.add(new AniBook("루피의원피스", "루피", "japan", 12));
		bookList.add(new CookBook("이혜정의얼마나맛있게요", "이혜정", "문학", false));
		bookList.add(new CookBook("최현석날따라해봐", "최현석", "소금책", true));
		bookList.add(new ItBook("채쌤의 자바 프로그래밍 핵심", "채규태", "쌤즈", true, true));
		
		ArrayList<Book> bookList1 = new ArrayList<Book>();

		
		// toString() 메서드
		// : 인스턴스(객체)에 대한 정보를 문자열로 반환
		// 기본적으로 Object 클래스 toString()
		// 클래스 이름 @메모리의 주소(16진수 해시코드)
		// - 내가 만든 클래스에서 오버라이딩
		//    내 클래스 멤버에 맞게 재정의(변경)한 것이다
		//    메모리의 주소 → 반환할 문자열로 재정의 한 것이고, 그에 따른 return값으로 문자열로 반환 받아 자동 호출 할 수 있는 것이다
		System.out.println(bookList);
		
		// 검색
		// index 반환하여 확인하는 방법: indexOf()
		// 그냥 검색하게 되면 ArrayList 배열의 인덱스 기준으로 찾게 된다(각 클래스의 객체들의 값들에 대한 index가 아니라)
		// 	System.out.println(bookList.indexOf("이혜정")); → 출력값: -1
		// 	 ∵ ArrayList 배열의 0~5까지의 인덱스에는 "이혜정"이 없기 때문에 -1로 출력되는 것 (찾지 못했다는 뜻)
		// 해결방법: 하나씩 꺼내와서 비교해야한다
		//  → get() 사용 : bookList.get()
		//     ∵ ArrayList 배열의 정보는 private으로 접근제어 되어있기 때문에 get()을 이용하는 것!
		//  → ArrayList 배열은 length가 아닌 size로 한다
		for(int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
			if(bookList.get(i).getAuthor().equals("이혜정")) {
				System.out.println("찾음");
				System.out.println("인덱스: " + i);
			}
		}
		
	}

//  아래 코드 내용은 다형성을 이용하여 부모 클래스와 자식 클래스들 간의 객체 생성한 후 배열로 정리한 것이다
	// 	Main 내용으로 Main 안에 주석처리해서 정리해두었다
	//	아래 코드 중 ArrayList<>는 스스로 정리해본 코드이기 때문에 위의 내용에서 강사님과 같이 정리하였으니 비교해보면 된다
//	public static void print(Book[] bookList) {
//		for (int i = 0; i < bookList.length; i++) {
//			bookList[i].show();
//			System.out.println();
//		}
//	}
//
//	public static boolean search(Book[] bookList) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("검색할 책 저자 입력: ");
//		String findAuthor = sc.nextLine();
//
//		for (int i = 0; i < bookList.length; i++) {
//			if (findAuthor.equals(bookList[i].getAuthor())) {
//				bookList[i].show();
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public static void main(String[] args) {
//
//		// 다형성 : 하나의 타입으로 여러 상속 관계의 타입들로 저장할 수 있다
//		// - 유지보수가 용이하다 (유지보수: 여러 개의 객체를 하나의 타입으로 관리)
//		// - 재사용성이 높다 (재사용성: 객체를 재사용)
//		// - 상속관계여야 한다
//		// - 다형성이 보장되기 위해 오버라이딩(재정의)이 반드시 필요하다
//		// - 자식 클래스의 객체가 부모 클래스의 타입으로 형변환(업캐스팅) 해야한다
////		Book b1 = new Book("채쌤 자바", "채규태", "쌤즈");
////		Book b2 = new AniBook("원피스", "미상", "미상", 0);
////		Book b3 = new CookBook("이혜정선생님 집밥", "이혜정", "요리출판사", true);
////		
////		// 다형성을 확인하는 연산자
////		// 비교할변수명 instanceof 클래스타입
////		if(b3 instanceof Book) {
////			System.out.println("상속 관계다!");
////		}else {
////			System.out.println("상속 관계 아니다!");
////		}
////		
////		if(b1 instanceof Book) {
////			System.out.println("상속 관계다!");
////		}else {
////			System.out.println("상속 관계 아니다!");
////		}
////		
////		if(b2 instanceof CookBook) {
////			System.out.println("상속 관계다!");
////		}else {
////			System.out.println("상속 관계 아니다!");
////		}
//
//		// AniBook a1 = new Book(); → 에러 발생 (이유: 자식 클래스의 객체는 부모 클래스 타입에 전부 없기에 타입을 받아들이지
//		// 못함)
//
//		// 다형성을 이용해서 상속관계를 가지는 Book
//		// 부모 타입으로 자식 클래스를 저장하면 부모가 물려준 타입만 저장 가능
//		Book[] bookList = new Book[6];
//
//		bookList[0] = new CookBook("백종원의집밥", "백종원", "tvN", true);
//		bookList[1] = new AniBook("한번더해요", "미티", "원모어", 19);
//		bookList[2] = new AniBook("루피의원피스", "루피", "japan", 12);
//		bookList[3] = new CookBook("이혜정의얼마나맛있게요", "이혜정", "문학", false);
//		bookList[4] = new CookBook("최현석날따라해봐", "최현석", "소금책", true);
//		bookList[5] = new ItBook("채쌤의 자바 프로그래밍 핵심", "채규태", "쌤즈", true, true);
//		
//		ArrayList<Book> listBook = new ArrayList<Book>();
//		listBook.add(new CookBook("백종원의집밥", "백종원", "tvN", true));
//		listBook.add(new AniBook("한번더해요", "미티", "원모어", 19));
//		listBook.add(new AniBook("루피의원피스", "루피", "japan", 12));
//		listBook.add(new CookBook("이혜정의얼마나맛있게요", "이혜정", "문학", false));
//		listBook.add(new CookBook("최현석날따라해봐", "최현석", "소금책", true));
//		listBook.add(new ItBook("채쌤의 자바 프로그래밍 핵심", "채규태", "쌤즈", true, true));
//		
//		
//		// 출력하기 위해 부모 클래스에서 show를 정의하였고, 자식 클래스에서 오버라이딩을 통해 show를 재정의하여 각각 다른 타입으로 결과를
//		// 출력할 수 있다
////		bookList[0].show();
////		bookList[1].show();
////		bookList[2].show();
////		bookList[3].show();
////		bookList[4].show();
//		// 위의 코드를 반복문으로
////		for (int i = 0; i < bookList.length; i++) {
////			bookList[i].show();
////			System.out.println();
////		}
//		print(bookList);
//
//		// 검색할 땐 타입이 다르면 각각의 타입에 맞게 저장해서 검색해야했다
//		// 부모클래스의 타입으로 자식 클래스에 객체를 저장하면 통합검색이 가능해진다
//		// ex. 책 저자가 "이혜정"인 객체를 검색해서 show() 함수 호출해보기
//		boolean result = search(bookList);
//		if(result == false) {
//			System.out.println("찾는 저자가 없습니다!");
//		}
//	}

}
