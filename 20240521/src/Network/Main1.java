package Network;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main1 {

	public static void main(String[] args) throws Exception {

		// 분리를 해야되는 문자열을 저장
		String movie = "{\"boxOfficeResult\":{\"boxofficeType\":\"일별 박스오피스\",\"showRange\":\"20240520~20240520\",\"dailyBoxOfficeList\":[{\"rnum\":\"1\",\"rank\":\"1\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20228797\",\"movieNm\":\"범죄도시4\",\"openDt\":\"2024-04-24\",\"salesAmt\":\"489183104\",\"salesShare\":\"37.6\",\"salesInten\":\"-964796017\",\"salesChange\":\"-66.4\",\"salesAcc\":\"102406220729\",\"audiCnt\":\"51464\",\"audiInten\":\"-95674\",\"audiChange\":\"-65\",\"audiAcc\":\"10711197\",\"scrnCnt\":\"1207\",\"showCnt\":\"5057\"},{\"rnum\":\"2\",\"rank\":\"2\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20203557\",\"movieNm\":\"그녀가 죽었다\",\"openDt\":\"2024-05-15\",\"salesAmt\":\"317031096\",\"salesShare\":\"24.4\",\"salesInten\":\"-592328871\",\"salesChange\":\"-65.1\",\"salesAcc\":\"4053289679\",\"audiCnt\":\"33577\",\"audiInten\":\"-59962\",\"audiChange\":\"-64.1\",\"audiAcc\":\"424151\",\"scrnCnt\":\"900\",\"showCnt\":\"3332\"},{\"rnum\":\"3\",\"rank\":\"3\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20247783\",\"movieNm\":\"혹성탈출: 새로운 시대\",\"openDt\":\"2024-05-08\",\"salesAmt\":\"153090215\",\"salesShare\":\"11.8\",\"salesInten\":\"-450943776\",\"salesChange\":\"-74.7\",\"salesAcc\":\"7964805906\",\"audiCnt\":\"15399\",\"audiInten\":\"-43622\",\"audiChange\":\"-73.9\",\"audiAcc\":\"782471\",\"scrnCnt\":\"884\",\"showCnt\":\"2048\"},{\"rnum\":\"4\",\"rank\":\"4\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20249507\",\"movieNm\":\"극장판 하이큐!! 쓰레기장의 결전\",\"openDt\":\"2024-05-15\",\"salesAmt\":\"156673072\",\"salesShare\":\"12.0\",\"salesInten\":\"-380359468\",\"salesChange\":\"-70.8\",\"salesAcc\":\"3793533791\",\"audiCnt\":\"15023\",\"audiInten\":\"-36608\",\"audiChange\":\"-70.9\",\"audiAcc\":\"363309\",\"scrnCnt\":\"810\",\"showCnt\":\"2532\"},{\"rnum\":\"5\",\"rank\":\"5\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20249305\",\"movieNm\":\"가필드 더 무비\",\"openDt\":\"2024-05-15\",\"salesAmt\":\"34891095\",\"salesShare\":\"2.7\",\"salesInten\":\"-316898257\",\"salesChange\":\"-90.1\",\"salesAcc\":\"1782974801\",\"audiCnt\":\"4080\",\"audiInten\":\"-33797\",\"audiChange\":\"-89.2\",\"audiAcc\":\"195577\",\"scrnCnt\":\"474\",\"showCnt\":\"818\"},{\"rnum\":\"6\",\"rank\":\"6\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20236674\",\"movieNm\":\"이프: 상상의 친구\",\"openDt\":\"2024-05-15\",\"salesAmt\":\"23081095\",\"salesShare\":\"1.8\",\"salesInten\":\"-111528663\",\"salesChange\":\"-82.9\",\"salesAcc\":\"691988455\",\"audiCnt\":\"2671\",\"audiInten\":\"-11957\",\"audiChange\":\"-81.7\",\"audiAcc\":\"76416\",\"scrnCnt\":\"373\",\"showCnt\":\"501\"},{\"rnum\":\"7\",\"rank\":\"7\",\"rankInten\":\"1\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20249317\",\"movieNm\":\"악마와의 토크쇼\",\"openDt\":\"2024-05-08\",\"salesAmt\":\"20266800\",\"salesShare\":\"1.6\",\"salesInten\":\"-18105200\",\"salesChange\":\"-47.2\",\"salesAcc\":\"759965500\",\"audiCnt\":\"2436\",\"audiInten\":\"-1334\",\"audiChange\":\"-35.4\",\"audiAcc\":\"78355\",\"scrnCnt\":\"171\",\"showCnt\":\"249\"},{\"rnum\":\"8\",\"rank\":\"8\",\"rankInten\":\"0\",\"rankOldAndNew\":\"NEW\",\"movieCd\":\"20236653\",\"movieNm\":\"퓨리오사: 매드맥스 사가\",\"openDt\":\"2024-05-22\",\"salesAmt\":\"20394000\",\"salesShare\":\"1.6\",\"salesInten\":\"20394000\",\"salesChange\":\"100\",\"salesAcc\":\"31002000\",\"audiCnt\":\"2266\",\"audiInten\":\"2266\",\"audiChange\":\"100\",\"audiAcc\":\"2890\",\"scrnCnt\":\"8\",\"showCnt\":\"8\"},{\"rnum\":\"9\",\"rank\":\"9\",\"rankInten\":\"-2\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20231677\",\"movieNm\":\"남은 인생 10년\",\"openDt\":\"2023-05-24\",\"salesAmt\":\"16642051\",\"salesShare\":\"1.3\",\"salesInten\":\"-48228878\",\"salesChange\":\"-74.3\",\"salesAcc\":\"5574372732\",\"audiCnt\":\"1653\",\"audiInten\":\"-4653\",\"audiChange\":\"-73.8\",\"audiAcc\":\"548223\",\"scrnCnt\":\"162\",\"showCnt\":\"238\"},{\"rnum\":\"10\",\"rank\":\"10\",\"rankInten\":\"1\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"19950084\",\"movieNm\":\"쇼생크 탈출\",\"openDt\":\"1995-02-04\",\"salesAmt\":\"6443016\",\"salesShare\":\"0.5\",\"salesInten\":\"-7362129\",\"salesChange\":\"-53.3\",\"salesAcc\":\"421390083\",\"audiCnt\":\"726\",\"audiInten\":\"-757\",\"audiChange\":\"-51\",\"audiAcc\":\"48150\",\"scrnCnt\":\"91\",\"showCnt\":\"133\"}]}}";

		// 1. jsonparser 객체를 먼저 생성 (org.json.simple.parser로 선택)
		JSONParser parser = new JSONParser();
		
		// 2. 문자열 → JSONObject 객체로 변경
		JSONObject object1 = (JSONObject)parser.parse(movie);
		
//		System.out.println(object1);
		// 3. Object1 객체에서 key를 이용해서 안에 있는 value의 타입이 JSONObject
		//    - 다시 한 번 저장
		JSONObject object2  = (JSONObject)object1.get("boxOfficeResult");
		
//		System.out.println("\n" + object2);
		
		// 4. key를 이용해서 value을 가져왔고, 그 객체의 타입이 여러 개를 저장하는 배열 [] 형태
		JSONArray array = (JSONArray)object2.get("dailyBoxOfficeList");
		
//		System.out.println("\n" + array);
//		System.out.println();
		
		// 5. 반복문을 이용해서 데이터를 꺼내기
		for(Object temp : array) {
			JSONObject objTemp = (JSONObject)temp;
			System.out.println(objTemp.get("rank") + "위 " + objTemp.get("movieNm"));
		}
		
	}

}
