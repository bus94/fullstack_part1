package Object;

public class ClassMain {

	public static void main(String[] args) {

		// Object
		//  getClass()
		//  어떤 클래스 파일의 클래스 정보를 갖고 있는 Class 클래스 객체
		
		// Class 클래스 - 클래스 이름이 Class인 것
		// - 클래스의 모든 정보(변수, 메서드, 타입)를 가지고 있고 접근 가능하게 해준다
		
		String str = "Class 클래스 테스트";
		
		// String 객체로부터 클래스의 정보 얻어오기
		System.out.println(str.getClass()); // java.lang.String
		
		Class cls = str.getClass();
		
		// 클래스의 이름만 호출한다
		System.out.println("1. " + cls.getSimpleName()); // 1. String
		
		// 패키지의 이름을 호출한다 => 폴더명
		System.out.println("2. " + cls.getPackageName()); // 2. java.lang
		
		// 클래스의 이름 전부를 호출한다 (풀네임)
		System.out.println("3. " + cls.getName()); // 3. java.lang.String
		
		// 제어자 정보를 호출한다
		System.out.println("4. " + cls.toGenericString()); // 4. public final class java.lang.String
		
		
		
		
	}

}
