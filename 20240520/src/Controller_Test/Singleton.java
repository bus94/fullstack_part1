package Controller_Test;

// 싱글톤 객체 사용 예시
public class Singleton {
	private Singleton ton = new Singleton();
	private static Singleton sql;
	
	private Singleton() {
		
	}

	public Singleton getTon() {
		return ton;
	}

}
