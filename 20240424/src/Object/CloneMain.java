package Object;

// 객체를 복사하기 위해서는 clone 메서드도 오버라이딩 해야되지만
// Cloneable 인터페이스를 구현 해야된다
class B implements Cloneable{ // 이 객체는 복사 할거다 라는 뜻의 인터페이스
	String str;
	
	B(String s){
		str = s;
	}
	
	// 객체를 복사하기 위해서는 clone 메서드를 오버라이딩 해야한다
	// 오버라이딩을 할 때 함수 안에 내용을 변경할 때, 단순하게 접근 제어자만 변경할 때도 있다
	// → 오버라이딩 조건에 접근 제어자는 해당되지 않는다는 것이다
	// clone 작성 후 Ctrl + Spacebar
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		// 깊은 복사
		// return new B(this.str);
		
		// 얕은 복사
		return super.clone();
	}
}

public class CloneMain {

	public static void main(String[] args) {

		// 객체를 그대로 복사하는 방법
		// Clone 메서드
		// - 객체를 깊은 복사할 때 사용하는 메서드
		// Object 클래스 clone() 메서드는 기본적으로 접근 제한자 protected
		
		// protected
		// - 부모 클래스에 대해서 public 멤버처럼 취급되는데, 외부에서는 private 멤버처럼 취급된다
		// - 같은 폴더에서는 모두 접근이 되지만 다른 폴더에서는 접근을 막는다
		
		// protected를 선언한 클래스를 상속한 자식 클래스의 멤버만 접근 가능
		
		// 참조 변수
		// - 직접적으로 데이터를 저장하는 것이 아닌 heap 영역에 주소를 저장
		
		// <객체의 복사>
		// 1. 얇은 복사
		// 	 객체의 주소만 복사!
		// 	 원본만 데이터를 수정하려해도 복사본까지 수정이 된다
		// 2. 깊은 복사
		//   새로운 공간에 객체 그대로 복사!
		//   원본 데이터를 변경해도 복사본 까지는 영향이 가지 않는다
		
		B ori = new B("Hello");
		// 기본적으로 Object 클래스로 복사되기 때문에
		// B 클래스로 다운 캐스팅 하기 위함 (B)
		// B copy = (B)ori.clone(); - 에러 발생 해결 위해 try/catch (나중에 배움)
		B copy = null;
		try { // 예외가 발생했을 때
			copy = (B)ori.clone();
		} catch (CloneNotSupportedException e) { // 이렇게 처리하겠다
			e.printStackTrace();
		}
		
		// 원본의 객체를 변경
		ori.str = "world";
		System.out.println("원본: " + ori.str);
		System.out.println(ori);
		System.out.println(ori.hashCode());
		System.out.println("사본: " + copy.str);
		System.out.println(copy);
		System.out.println(copy.hashCode());
		
		
	}

}
