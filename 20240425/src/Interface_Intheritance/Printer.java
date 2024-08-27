package Interface_Intheritance;

public interface Printer {
	
	void printBlack(String fileName);
	
}

// 인터페이스끼리도 상속이 가능!
interface ColorPrinter extends Printer{ 
	// 상속 받은 인터페이스의 기능이 생략되어있는 것
	// void printBlack(String fileName);
	
	// 추가될 기능만 작성하면 된다
	void printColor(String fileName);
	
}
