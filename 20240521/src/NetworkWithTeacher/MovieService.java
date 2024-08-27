package NetworkWithTeacher;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// data를 받았을 때 가공이 안되어있는 경우 가공 작업을 해주는 Service 역할
public class MovieService{
	// Movie DB에 접근할 수 있는 객체를 생성한다.
	private MovieDAO dao = new MovieDAO();
	
	// MovieDAO를 호출하는 메서드
	public boolean hasMovieData() throws Exception{
		return dao.hasMovieData();
	}

	// 추가할 때 네트워크 통신으로 가지고 온 문자를 매개변수로 받아서 자바 객체로 역직렬화 하겠다.
	// JSON타입으로 사용하기
	public void insert(String sb) throws Exception{
		// 메서드가 실행 중인지를 알려주는 로그
		System.out.println("MovieService insert() 메서드 실행!");

		// 1. jsonparser 객체를 먼저 생성 (org.json.simple.parser로 선택)
		JSONParser parser = new JSONParser();

		// 2. 문자열 → JSONObject 객체로 변경
		JSONObject object1 = (JSONObject) parser.parse(sb); // 객체화 시킨 후

		// 3. Object1 객체에서 key를 이용해서 안에 있는 value의 타입이 JSONObject
		JSONObject object2 = (JSONObject) object1.get("boxOfficeResult");

		// 4. key를 이용해서 value을 가져왔고, 그 객체의 타입이 여러 개를 저장하는 배열 [] 형태
		JSONArray array = (JSONArray) object2.get("dailyBoxOfficeList");
		
		// 5. 반복문을 이용해서 데이터를 꺼내기
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		for (Object temp : array) {
			JSONObject t = (JSONObject)temp;
			
			Movie movie = new Movie();
			movie.setRnum((String)t.get("rnum"));
			movie.setRank((String)t.get("rank"));
			movie.setRankOldAndNew((String)t.get("rankOldAndNew"));
			movie.setMovieNm((String)t.get("movieNm"));
			movie.setOpenDt((String)t.get("openDt"));
			movie.setAudiAcc((String)t.get("audiAcc"));
			
			// DAO 안에 있는 insert() 불러오기
			dao.insert(movie);
		}
	}

	// 영화 목록을 조회하는 메서드 (전체 영화)
	public ArrayList<Movie> select() throws Exception{
		
		return dao.select();
	}

}
