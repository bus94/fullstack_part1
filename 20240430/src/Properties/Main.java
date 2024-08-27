package Properties;

import java.util.Enumeration;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {

		/*
		 * Properties
		 * 	key - value 저장이 된다.
		 * 	new Properties(String, String)
		 * 	
		 * 	주로 애플리케이션의 환경 설정, 관련 속성을 저장하는데 사용되며
		 *  데이터를 파일로부터 읽고 쓰기 편리한 기능을 제공한다.
		 * 
		 * 	java.util 폴더를 꼭 포함해야된다.
		 * 
		 */
		
		Properties prop = new Properties();
		
		/* prop 저장할 때는 key - value */
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10"); // capacity : 용량, 생산능력
		
		// 설정된 속성 출력
		prop.list(System.out); // 모니터로 출력 (콘솔창)
		
		/*
		 * Enum 열거타입
		 *  : 멤버라 불리는 값의 집합을 이루는 자료형
		 *    (상수 데이터들의 집합)
		 * 
		 */
		Enumeration en = prop.propertyNames();
		
		// Enumeration 데이터가 남아있는 동안 반복한다.
		// 다음 요소(데이터)가 있으면 true, 없으면 false
		while(en.hasMoreElements()) {
			// 다음 요소 가져오기
			String element = (String)en.nextElement(); // 기본적으로 Object로 업캐스팅 되어있기 때문에 String으로 저장하기 위해선 다운캐스팅 필요
			
			// 데이터의 key를 이용해서 value를 출력
			// getProperty(element)
			// 설정 파일에서 값을 꺼내올 때는 element변수에 key를 넣어서 찾는다.
			System.out.println("key: " + element);
			System.out.println("value: " + prop.getProperty(element));
		}
		
		
		
		
		
		
	}

}
