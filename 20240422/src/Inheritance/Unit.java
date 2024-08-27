package Inheritance;

public class Unit {
	// 어떤 캐릭터든 목숨과 마력
	private int hp;
	
	public Unit(int hp) {
		this.hp = hp;
	}
	
	void attack() {
		System.out.println("공격!");
	}
}

class Terran extends Unit{
	public Terran(int hp){
		super(hp);
	}
}

// 마린이라는 군인은 테란의 캐릭터 → Unit, Terran 다중 상속이 안되므로 Terran으로 상속받으면 된다
class Marine extends Terran{
	public Marine(int hp){
		super(hp); // Marine이 받은 hp를 → Terran hp에게, 그 hp를 → Unit hp에게 전달하여 객체 생성
	}
	@Override
	void attack() {
		System.out.println("총 싸움!");
	}
}

class Zerg extends Unit{
	public Zerg(int hp){
		super(hp);
	}
}

class Protoss extends Unit{
	public Protoss(int hp){
		super(hp);
	}
}



