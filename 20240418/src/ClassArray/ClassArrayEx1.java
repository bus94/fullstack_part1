package ClassArray;

class Join{
	String id;
	String pw;
}

public class ClassArrayEx1 {

	public static void main(String[] args) {

		/*
		 * Join 클래스 1000개의 인스턴스 생성
		 * 클래스를 통해 각각의 다른 타입의 변수를 여러 개로 묶어서 하나의 단어로 표현
		 * 
		 * 그렇다면 같은 타입으로 여러 개의 변수를 한번에 생성하는 기법은?
		 * → "배열"
		 * 클래스라는 타입의 변수로 배열에 넣는다면 되지 않을까?
		 * 
		 */
		
		Join join1 = new Join();
		
		// Join 타입의 변수를 저장하기 위한 공간만 저장
		// → Join 클래스 안에 있는 각각의 변수들의 데이터값이 생성된 것이 아니다 (인스턴스 생성필요)
		Join[] joinList = new Join[5];
		
		// 객체 배열 → 실제 각 타입의 주소값을 저장하는 것 (각각의 변수값을 설정해줘야한다)
		// 실제 데이터를 저장하기 위해서는 new 타입명(); 으로 각각의 공간을 저장할 수 있도록 설정됨
		joinList[0] = new Join();
		joinList[0].id = "qwer";
		joinList[0].pw = "qwer1";
		
		// 배열을 사용할 때 공간에 각각 저장될 수 이도록 새로운 변수 new 생성해야한다.
		joinList[1] = new Join();
		joinList[1].id = "asdf";
		joinList[1].pw = "asdf2";
		
			
		System.out.println(joinList[0].id);
		System.out.println(joinList[0].pw);
		
	}

}
