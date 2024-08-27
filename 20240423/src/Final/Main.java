package Final;

public class Main {

	public static void main(String[] args) {

		// 변수
		// - 기본적으로 변수들은 데이터를 저장하고 변경할 수 있다 (가변적)
		// But. 변수에 처음 저장된 값을 변경하지 못하게 하는 키워드
		// → final
		// - 변수를 선언할 때 그에 대한 값도 같이 저장해줘야한다
		final String hello = "Hello";
		System.out.println(hello);

		// hello = "HELLO"; → 에러 발생: final로 변수를 저장했기 때문에 변경이 불가

		Tank t1 = new Tank();
		Soldier s1 = new Soldier();
		Doctor d1 = new Doctor();

		System.out.println(t1.getHp() + "/" + t1.getMaxHp());
		System.out.println(s1.getHp() + "/" + s1.getMaxHp());
		System.out.println(d1.getHp() + "/" + d1.getMaxHp());
                                 
		s1.setHp(10);              
		System.out.println(t1.getHp() + "/" + t1.getMaxHp());
		System.out.println(s1.getHp() + "/" + s1.getMaxHp());
		System.out.println(d1.getHp() + "/" + d1.getMaxHp());
		d1.operate(s1);          
		d1.operate(d1);                          
		d1.operate(t1);                         
		System.out.println(t1.getHp() + "/" + t1.getMaxHp());
		System.out.println(s1.getHp() + "/" + s1.getMaxHp());
		System.out.println(d1.getHp() + "/" + d1.getMaxHp());
	}

}

// 클래스 멤버변수로 final 고정값을 사용할 때는 각각의 클래스마다 다른 값을 사용하려면 생성자를 이용한다
class Unit {
	private int hp; // 유동적인 목숨
	private final int maxHp; // 고정된 목숨

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
		super(1000); // Tank 클래스의 maxHp 변수의 값은 1000으로 고정된 것
		System.out.println("탱크 생성!");
	}
}

class Soldier extends Unit {
	Soldier() {
		super(100); // Soldier 클래스의 maxHp 변수의 값은 100으로 고정된 것
		System.out.println("군인 생성!");
	}
}

class Doctor extends Unit {
	Doctor() {
		super(80); // Doctor 클래스의 maxHp 변수의 값은 80으로 고정된 것
		System.out.println("의사 생성!");
	}

	// 사람만 치료 가능
//	// 군인을 치료한다고 했을 때 군인 타입의 매개변수
//	//  → 군인들만 들어올 수 있는 타입으로 매개변수 설정된 것
//	void operate(Soldier unit) {
//		unit.hp = maxHp;
//		System.out.println("회복되었다!");
//	}
//	
//	//  → 의사들만 들어올 수 있는 타입으로 매개변수 설정된 것
//	void operate(Doctor unit) {
//		unit.hp = maxHp;
//		System.out.println("회복되었다!");
//	}
	// Unit의 타입을 비교 (사람만 구별)
	// 참조변수 instanceof 클래스명
	//  - 만약 클래스명과 관련이 있다면 상속관계이거나 자기 자신의 타입이거나 해서
	//     맞다면 true, 아니면 false
	void operate(Unit unit) {
		if (unit instanceof Soldier || unit instanceof Doctor) {
			unit.setHp(unit.getMaxHp());
			System.out.println("회복되었다!");
		}else {
			System.out.println("기계는 고칠 수 없다!");
		}
	}

}
