package Crawling;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingMain3 {

	public static void main(String[] args) {
		// 영화 url을 저장하는 타입으로 ArrayList
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		
		try {
			// 1. url
			String url = "https://www.cgv.co.kr/";
			
			// 2. 연결
			Document doc = Jsoup.connect(url).get();
			
			// 3. 출력 (확인용)
//			System.out.println(doc);
			
			// 이미지를 둘러싸고 있는 테두리인 img_wrap 그룹으로 찾는다.
			Elements images = doc.getElementsByClass("img_wrap");
//			System.out.println(images);
			// 각 img_wrap 내의 이미지 링크를 가져오기
			for(Element temp : images) {
				// selectFirst() : 선택한 요소 중에서 첫 번째 요소를 선택하는 메서드
				Element img = temp.selectFirst("img"); // 첫 번째 요소 중에 img 요소를 가져와라 → img 태그만(태그 속 전체 내용) 출력된다.
//				System.out.println(img);
				if(img != null) {
					// 이미지 태그 안의 경로(속성: 하나의 데이터 값) 
					// attr() 메서드 이용
					String imgUrl = img.attr("src");
//					System.out.println(imgUrl); // img 태그 안의 url만 출력된다.
				}
			}
			
			// 영화 정보에 대한 내용을 크롤링
//			Elements info = doc.getElementsByClass("movie_info_wrap");
//			Elements info = doc.getElementsByClass("movieName");
//			System.out.println(info);
			
			// images, infos의 내용을 ArrayList에 Movie객체를 생성해서 추가하기
			Elements infos = doc.getElementsByClass("movieName");
			
			// Elements 클래스에서 size() 
//			System.out.println(images.size());
//			System.out.println(infos.size());
			
			for(int i = 0; i < images.size() && i < infos.size(); i++) {
				Element img = images.get(i).selectFirst("img");
				Element name = infos.get(i);
				if(img != null && name != null) {
					String imageURL = img.attr("src");
					String title = name.text();
					Movie movie = new Movie(title, imageURL);
					movieList.add(movie);
				}
			}
			for(Movie temp : movieList) {
				System.out.println(temp);
			}
			
			// 정보 단락에서 데이터 뽑기
			Elements movieEle = doc.getElementsByClass("movie_info_wrap");
			
			// 각 영화 정보 꺼내기
			for(Element temp : movieEle) {
				// 영화제목
				String title = temp.selectFirst("strong.movieName").text();
				
				// 예매율
				String res = temp.select("span").last().text();
				
				System.out.println("영화이름: " + title);
				System.out.println(res);
				System.out.println();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

// 이미지랑 영화 제목을 한꺼번에 저장하는 클래스
class Movie{
	private String title;
	private String imageURL;
	
	public Movie(String title, String imageURL) {
		this.title = title;
		this.imageURL = imageURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "[title=" + title + ", imageURL=" + imageURL + "]";
	}
	
	
}
