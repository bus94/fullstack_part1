package Interface_NoteBook;

public class GalaxyNoteBook extends NoteBook implements Chrome{

	@Override
	void 워드작성() {
		System.out.println("갤럭시만의 워드를 작성");
	}

	@Override
	void 인터넷() {
		System.out.println("갤럭시만의 인터넷");
	}

	void 갤럭시만의기능() {
		System.out.println("갤럭시만의 기능제공");
	}

	@Override
	public void browser() {
		System.out.println("갤럭시만의 크롬버전");
	}
	
}
