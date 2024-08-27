package Naver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main1 {

	public static void main(String[] args) {
		// 입출력을 할 때 파일만 하는 것이 아니라 인터넷에 있는 기능을 가지고 와서 사용

		// API
		// - 프로그램들 끼리 서로 통신(상호작용)할 수 있도록 도와주는 매개체
		String clientId = "Vrb_8gFvQuYhvSpSlidB";
		String secret = "td9mhgcax4";
		String url = "https://openapi.naver.com/v1/search/blog?";

		String text = null;
		try {
			// 검색할 때 문자를 url에 같이 보내면 한글이 깨질 수 있다. 한글을 깨지지 않게 인코딩.
			// 데이터 통신할 때 java.net 패키지 안에 포함.
			// UTF-8 가변 길이 인코딩 방식
			// - 유니코드값에 따라서 1바이트부터 4바이트까지 사용하여 문자를 인코딩할 수 있다.

			// 알파벳 아스키코드표 안에 문자들을 1byte
			// 아스키코드표 이외의 문자는 2~4바이트 사이로 인코딩 된다.

			// 인코딩 실패를 하면 발생하는 예외가 있다.
			// RuntimeException
			// UnsupportedEncodingException
			text = URLEncoder.encode("강동원", "UTF-8");
			url += "query=" + text;
			System.out.println(url);

			// 네이버에 접속하기 위해서 설정을 해야된다.
			Map<String, String> requestHeaders = new HashMap<String, String>();

			requestHeaders.put("X-Naver-Client-Id", clientId);
			requestHeaders.put("X-Naver-Client-Secret", secret);

			String response = get(url, requestHeaders);

			System.out.println(response);

			parse(response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 가져온 데이터를 key를 이용해서 값을 꺼내서 클래스 객체에 저장하기
	private static void parse(String response) throws Exception {
		
		// 검색한 결과를 한꺼번에 저장하는 ArrayList
		ArrayList<Search> list = new ArrayList<Search>();

		// 1. 구분자 생성
		JSONParser parser = new JSONParser();

		// 2. 문자열 → JSONObject로 변경해야 key를 이용할 수 있다.
		JSONObject object = (JSONObject) parser.parse(response);
		
		// 3. key를 이용해서 여러 개의 값을 저장한 items의 값을 꺼낸다. items는 여러 개의 값을 저장하는 배열 형태로 되어있다.
		JSONArray items = (JSONArray) object.get("items");
		
		// 4.반복을 이용해서 하나의 객체를 꺼내와서 각각 key를 이용해서 꺼내서 형변환한다.
		for(Object obj : items) {
			JSONObject item = (JSONObject) obj;
			
			Search s = new Search();
			s.setTitle((String)item.get("title"));
			s.setLink((String)item.get("link"));
			s.setBloggername((String)item.get("description"));
			s.setBloggerlink((String)item.get("bloggerlink"));
			// 날짜는 바로 형변환을 할 수 없으니 밑의 코드로 작성하기 
			// (문자형태로 변환하고, 변환한 문자를 서식에 맞게 parser() 메서드 이용해서 LocalDateTime클래스의 객체를 생성한다.
//			String date = (String)item.get("postdate");
			s.setPostdate((String)item.get("postdate"));
			
			
			// 8버전까지만 사용하는 기술(현재 11버전)
			// Date d = new Date(date);
			
//			DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
//			LocalDateTime post = LocalDateTime.parse(date,DATE_FORMATTER);
			
			// Search 객체에 추가하기
//			s.setPostdate(post);
			
			// 여러 개의 검색을 리스트에 저장한다.
			list.add(s);
		}
		// 전체적으로 출력
		System.out.println(list);

	}

	private static String get(String url, Map<String, String> requestHeaders) throws Exception {
		// URL 객체 생성
		URL apiUrl = new URL(url);

		// HttpURLConnection
		// : 자바에서 http 통신을 처리하는 클래스
		// 요청을 만들고 서버로부터 응답을 받을 수 있도록 해주는 클래스
		HttpURLConnection con = (HttpURLConnection) apiUrl.openConnection();

		// URL 안의 내용 보이기
		con.setRequestMethod("GET");

		// 우리가 map으로 설정한 내용을 HttpURLConnection 클래스 한테 저장해줘야 한다.
		for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
			con.setRequestProperty(header.getKey(), header.getValue());
		}
		// 웹과 통신이 정상적으로 성공코드로 200번 혹은 201번이 응답코드로 온다. (거의 200번)
		int code = con.getResponseCode();

		System.out.println("응답코드: " + code);

		InputStream in = null;
		// 정상적으로 응답 되었다면 응답코드로 200이 온다.
		if (code == HttpURLConnection.HTTP_OK) {
			in = con.getInputStream(); // 응답 스트림
		} else {
			// 오류 발생 시
			in = con.getErrorStream();
		}

		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader line = new BufferedReader(reader); // 바이트 단위로 읽기 힘드니 한 줄씩 읽어올 수 있도록
		StringBuilder body = new StringBuilder();

		String temp;

		while ((temp = line.readLine()) != null) {
			body.append(temp); // 응답한 내용 저장
		}

		return body.toString();
	}

}
