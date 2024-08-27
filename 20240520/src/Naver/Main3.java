package Naver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main3 {

	public static void main(String[] args) {
		String jsonString = "{" + "	\"dog\" : [" + "	{\"name\" : \"댕댕이\", \"age\"  : 1, \"weight\" : 2.14},"
				+ "	{\"name\" : \"식빵이\", \"age\"  : 2, \"weight\" : 2.14},"
				+ "	{\"name\" : \"뽀삐\", \"age\"  : 3, \"weight\" : 2.14}" + "	]" + "}";
		// 문자를 구별할 수 있는 JSONParser 생성
		JSONParser parser = new JSONParser();

		// 문자 → 객체로 변경
		try {
			JSONObject obj = (JSONObject) parser.parse(jsonString);

			// 기본적으로 dog라는 key를 이용해서 꺼내면 배열 형태로 여러 개가 저장되어있다.
			// key를 이용하면 배열형태로 저장해서 배열을 이용해서 key를 꺼내서 value 가져오기 때문에 JSONArray 형태로 저장한다.
			JSONArray dogArray = (JSONArray) obj.get("dog");
			
			// 배열 내의 각 객체를 반복하면서 출력
			for(Object temp : dogArray) {
				JSONObject t = (JSONObject) temp;
				System.out.println("이름: " + t.get("name"));
				System.out.println("나이: " + t.get("age"));
				System.out.println("몸무게: " + t.get("weight"));
				System.out.println();
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
