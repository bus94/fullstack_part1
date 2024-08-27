package Interface_Marker;

public class Unit {
	
	private int hp; 
	private final int maxHp; 

	Unit(int maxHp) {
		this.maxHp = maxHp;
		this.hp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

}

class Tank extends Unit {
	Tank() {
		super(1000); 
		System.out.println("탱크 생성!");
	}
}

class Soldier extends Unit implements A{
	Soldier() {
		super(100); 
		System.out.println("군인 생성!");
	}
}

class Doctor extends Unit implements A{
	Doctor() {
		super(80); 
		System.out.println("의사 생성!");
	}

	void operate(A unit) {
		// 인터페이스 타입으로 다형성에 의해 업캐스팅이 된 것
		// 다형성에 의해 타입을 구별함
		// 마커 인터페이스로 업캐스팅을 하게 되면 내가 원하는 변수에 접근이 불가능하다 (오버라이딩을 할 메서드가 없어 그것도 해결x)
		// 마커 인터페이스를 사용할 경우 잠시 Unit 타입으로 다운캐스팅을 해서 변수에 접근한다
		// Soldier 같은 경우 Unit클래스를 상속받고, A인터페이스도 구현하고 있기 때문에 해당 타입들을 모두 가지고 있어
		// 인터페이스의 타입 접근을 부모 클래스의 타입으로 잠시 변경하여 변수에 접근한다
		Unit u = (Unit) unit;
		u.setHp(u.getMaxHp());
		
		// 인터페이스 상속을 계속 하다보면 기하급수적으로 늘어날  수 있어 default 제어자로 해결하는 것
		// default void 함수명() {}; 처럼 이미 완성된 함수가 존재하기 때문에 이 함수는 오버라이딩 대상에서 제외가 된다
		// → 원래는 인터페이스 안에서 선언해둔 추상메서드는 다른 클래스에서 구현하게 되면 오버라이딩해서 작성해야만 한다
	}

}
