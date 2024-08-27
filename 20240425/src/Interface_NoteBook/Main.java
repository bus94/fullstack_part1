package Interface_NoteBook;

public class Main {

	public static void main(String[] args) {

		AppleNoteBook a1 = new AppleNoteBook();
		GalaxyNoteBook g1 = new GalaxyNoteBook();
		LgNoetBook l1 = new LgNoetBook();
		GalaxyTab g2 = new GalaxyTab();
		
		// 인터페이스 사용할 때의 장점을 활용
		// - 크롬을 다운 받은 모든 기계들을 관리
		//   - 부모 클래스가 다른 클래스여도 인터페이스 통해 여러 클래스를 관리할 수 있다
		// 아래 코드로 예시를 보면
		//   NoteBook 클래스 상속 받은 클래스들인 a1, g1, l1과 상속 받지 않은 클래스인 g2를 한 번에 출력 가능
		Chrome[] list = {a1, g1, l1, g2};
		
		for(int i = 0; i < 4; i++) {
			list[i].browser();
		}
		
		/*
		 * 인터페이스
		 *  - 서로 다른 두 개의 시스템 장치 사이에서 정보나 신호를 주고 받는 경우
		 *    사용자가 기기를 쉽게 동작시키는데 도움을 주는 상호작용
		 * 
		 * 인터페이스는 다중 상속이 가능
		 * 다중 상속할 때는 ,를 사용해서 추가하면 된다
		 * 키워드 implements 인터페이스명, 인터페이스명, ...
		 * 
		 * 인터페이스를 구현하는 멤버
		 * 	추상메서드
		 * 	고정된 상수만 (final) 만 저장 가능
		 * 	public abstract 생략 가능
		 * 
		 */
		
		
	}

}
