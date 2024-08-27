package Inheritance;

// 클래스마다 중복되는 내용이 있기에 "상속"을 이용

class 포켓몬{ // 기본 클래스 (부모 클래스)
	String name;
	int level = 1;
	String attack;
}

public class 꼬부기 extends 포켓몬{ // 자식 클래스
}

class 어니부기 extends 꼬부기{
}

class 거북왕 extends 어니부기{
}
