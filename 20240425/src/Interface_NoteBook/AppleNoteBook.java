package Interface_NoteBook;

public class AppleNoteBook extends NoteBook implements Chrome{
	
	@Override
	void 워드작성() {
		System.out.println("애플만의 워드를 작성");
	}

	@Override
	void 인터넷() {
		System.out.println("애플만의 인터넷");
	}

	void 애플만의기능() {
		System.out.println("애플만의 기능제공");
	}

	@Override
	public void browser() {
		System.out.println("애플만의 크롬버전");
	}
	
}
