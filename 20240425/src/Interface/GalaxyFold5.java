package Interface;

import Interface_NoteBook.Chrome;

//갤럭시 폴드는 스마트폰이면서 폰이다!
//노트펜 기능을 구현
public class GalaxyFold5 extends SmartPhone implements NotePen, Chrome{

	@Override
	void printInformation() {
	}

	@Override
	String makeCall() {
		return null;
	}

	@Override
	String takeCall() {
		return null;
	}

	@Override
	public void button() {
		System.out.println("폴드만의 버튼");
	}

	@Override
	public void connect() {
		System.out.println("폴드만의 연결 방식");
	}

	@Override
	public void browser() {
		System.out.println("폴드만의 크롬버전");		
	}

}
