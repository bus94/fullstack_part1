package Inheritance;

public class 마법사 {
	String id;
	int hp;
	int mp;
	String attack;
}

class 바드 extends 마법사{
	// 마법사 중 힐러 캐릭터
}
class 서머나 extends 마법사{
	// 마법사 중 정령으로 싸우는 캐릭터
}
class 아르카나 extends 마법사{
	// 마법사 중 카드로 싸우는 캐릭터
}
