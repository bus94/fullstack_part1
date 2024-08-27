package Abstract;

public class Dog extends Animal{
	
	@Override
	void 운다() {
		System.out.println("멍멍!");
	}

	@Override
	void play() {
		System.out.println("강아지 놀다");
	}

	@Override
	void 먹는다() {
		System.out.println("강아지 먹다");
	}

	void 강아지만의_기능() {
		System.out.println("강아지만의 기능");
	}
	
}
