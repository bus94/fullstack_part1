package Crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CrawlingMain {

	public static void main(String[] args) {
		// 웹 크롤링(Web Crawling)
		// - 웹 상에서 원하는 데이터를 추출한다. (가져오기)
		// - 필요한 데이터를 가져온다.
		
		// jsoup 외부 라이브러리가 있다.
		// 다운로드 받고 압축 풀지 말고 복사해서 자바 이클립스 패키지 안에 복사, 붙여넣기 하면 된다.
		// 우클릭 통해 build path → add to build path
		
		// html
		// - 웹 페이지를 만들고 디자인 하고 싶을 때 사용하는 언어
		// - 모든 웹 페이지는 html 언어로 작성되어있다.
		
		// HTML (Hypertext Markup Language)
		// - 마크업 언어 "자료의 구조를 표현하기 위한 언어"
		
		// - 태크 <>
		// - <열린태그>내용</닫는태그>
		//   요소(element) : <열린태그>내용</닫는태그> 한 줄
		
		// html은 보이는 부분과 안 보이는 부분으로 나눈다.
		// 보이는 부분 <body> ~ </body> (화면 구성)
		// 안 보이는 부분 <head> ~ </head> 
		// 설정하는 부분은 대부분 헤더에 들어간다.
		
		// Document 클래스
		// - html 문서를 저장한다.
		// - .html
		
		// Element 클래스
		// - 요소들이 모인 자료형
		
		// 1. 크롤링 하기 위해서는 url 저장
		String url = "https://www.naver.com/";
		
		// 외부에 있는 데이터와 통신을 하려면 에러가 발생할 수 있다.(예외가 발생)
		try{
			// 2. 연결
			// Document   html 문서 생성 시 저장하는 클래스 타입
			// connect(url) : 페이지 주소의 문자열 가져온다.
			// get() 이용해서 html문서를 가져온다.
			Document doc = Jsoup.connect(url).get();
			
			// 3. 위에서 연결됨을 확인하는 출력
			// System.out.println(doc);
			
			// 4. 타이틀 꺼내기
			String title = doc.title(); // 문서가 가지고 있는 title을 문자열 타입의 title에 저장
			System.out.println(title);
			
			// 웹 문서를 확인하기 위해선 인터넷 개발자 도구(F12)
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
