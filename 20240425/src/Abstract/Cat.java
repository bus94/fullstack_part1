package Abstract;

public class Cat extends Animal{
	
	// 동작
	// 상속받으면 고양이의 내용으로 변경
	
	@Override
	void 운다() {
		System.out.println("야옹!");
	}

	@Override
	void play() {
		System.out.println("고양이 놀다");
	}

	@Override
	void 먹는다() {
		System.out.println("고양이 먹다");
	}

	void 고양이만의_기능() {
		System.out.println("고양이만의 기능");
	}
	
}
