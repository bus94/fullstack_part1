package Interface_NoteBook;

// 노트북은 아니다! → 노트북을 상속받을 순 없다
// 인터페이스인 크롬에 대한 기능은 사용할 수 있으므로 아래와 같이 작성 가능
public class GalaxyTab implements Chrome{

	@Override
	public void browser() {
		System.out.println("갤럭시탭만의 크롬버전");
	}
	
}
