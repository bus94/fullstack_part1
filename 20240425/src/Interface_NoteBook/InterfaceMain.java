package Interface_NoteBook;

//interface 인터페이스이름{
//	public static final 타입 상수이름 = 값; // public static final 생략 가능
//	public abstract 타입 메서드이름(매개변수); // public abstract 생략 가능
//	
//	
//}

interface Tv{
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	void changeVolume(int volume);
	void changeChannel(int channel);
	
	// public static final
	// public abstract
	// 위의 코드들을 생략해도 인터페이스를 만들 때 모든 멤버에 적용되기 때문에 편하게 구현할 수 있도록 생략 가능
	// 단! 컴파일 시에 자동으로 추가되어서 기능 구현이 된다
	
	// extends 와 implements 를 같이 사용할 경우
	// extends를 먼저 쓰고, 뒤에 implements를 작성 해야한다 (추상클래스명 인터페이스명 순서로)
	
	
}

public class InterfaceMain {

	public static void main(String[] args) {

	}

}
