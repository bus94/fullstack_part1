package Serialize;

import java.io.Serializable;

// 직렬화를 하기 위해서는 인터페이스를 구현해야된다.
// 마커인터페이스 (단순히 표시하는 인터페이스)
// Serializable
public class Signton implements Serializable {
	private Signton() {
	}

	// 내부 클래스에서 private, static 사용할 수 있다.
	private static class Settings {
		// final 키워드를 사용할 때는 변수명이 모두 대문자
		private static final Signton INSTANCE = new Signton();
	}
	
	public static Signton getInstance() {
		return Settings.INSTANCE;
	}

}
