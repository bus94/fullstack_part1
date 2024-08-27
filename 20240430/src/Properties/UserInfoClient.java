package Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserInfoClient {

	public static void main(String[] args) {

		// db.properties 파일을 읽어오는 FileInputStream
		String dbType = "";
		// 바이트 단위로 읽어온다.
		FileInputStream fis = null;
		
		try {
			// . → 현재 프로젝트 ("20240430" 프로젝트)
			// 상대경로 : 현재 프로젝트를 기준으로 경로를 가져온다.
			String filepath = "./src/Properties/db.properties";
			fis = new FileInputStream(filepath);
			
			// read() 메서드
			// : FileInputStream클래스 객체에서 1바이트의 데이터를 읽어온다.
			// - 코드값으로 읽어오기 때문에 문자로 출력하려면 형변환(casting)을 해야된다.
			
//			System.out.println(fis.read()); 
//			System.out.println((char)fis.read()); 
			
			// read() 메서드 - 읽어들일 데이터가 없으면 -1, 있으면 데이터의 코드값(숫자)으로 리턴
			// 끝까지 다 읽으면 역시 -1로 리턴된다.
//			int ch;
//			String prop = "";
//			
////			while(true) {
////				ch = fis.read();
////				if(ch == -1) {
////					// 읽을 데이터가 없으면(-1로 반환) 반복문 멈춤
////					break;
////				}
////				prop += (char)ch;
////			}
//			// 위의 코드를 간단하게 표현
//			while((ch = fis.read()) != -1) {
//				prop += (char)ch;
//			}
//			System.out.println(prop);
//			
//			// 구분자를 이용하여 원하는 값만 가져오려면
//			String[] dbProp = prop.split("=");
//			System.out.println(dbProp[1]);
			
			Properties properties = new Properties();
			properties.load(fis);
			
			// getProperty() KEY 가 있으면 VALUE 가져옴, 없으면 NULL
			// getProperty(KEY, 기본값) 으로 기본값을 설정하면 만약 KEY가 없으면 기본값이 출력!
			System.out.println(properties.getProperty("DBTYPE", "잘못된 KEY")); // 출력: MARIADB
			System.out.println(properties.getProperty("DBTYP", "잘못된 KEY")); // 출력: 잘못된 KEY
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {fis.close();} 
				// {} 중괄호를 비우면 예외를 무시
				catch (IOException e) {}
			}
		}
		
		
		
		
		
		
		
		
		
	}

}
