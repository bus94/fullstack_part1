package Exception;

// 사용자 정의 예외 클래스
class MyException extends Exception{
	
	public MyException(String msg) {
		super(msg); // 부모 클래스에게 예외처리를 넘겨라
	}
	
}

public class Main3 {

	public static void main(String[] args) {

		// 내가 클래스를 이용해서 개발을 하면 내가 개발한 클래스의 예외처리할 수 있는 객체를 생성하는 틀을 만들어야 된다
		// 내가 만든 예외처리 클래스를 직접 객체 생성 해야된다
		
		try { // 예외 발생 문장들;
			// 직접 예외를 발생 시킬 수 있다
			// throw 키워드
			throw new MyException("내가 만든 예외!");
		} catch (MyException e) {
			System.out.println("예외: " + e.getMessage());
		}
		System.out.println("프로그램 정상 작동");
		
		
	}

}
