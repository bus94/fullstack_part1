package Interface_NoteBook;

public class LgNoetBook extends NoteBook implements Chrome{
	
	@Override
	void 워드작성() {
		System.out.println("LG만의 워드를 작성");
	}

	@Override
	void 인터넷() {
		System.out.println("LG만의 인터넷");
	}

	void LG만의기능() {
		System.out.println("LG만의 기능제공");
	}

	@Override
	public void browser() {
		System.out.println("LG만의 크롬버전");
	}
	
}
