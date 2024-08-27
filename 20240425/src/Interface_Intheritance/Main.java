package Interface_Intheritance;

class A{
	// 변수
	
	
	// 함수
	// list[0] = new int[];, if(true){}; 등의 실행문은 함수 밖에 작성하면 실행이 되지 않는다
	// 따라서 void show(){ } → 함수 중괄호 {} 안에 작성해야한다
	
}

public class Main {

	public static void main(String[] args) {
		
		// 20년 전 프린터는 흑백만 출력
		SamsungPrinter s1 = new SamsungPrinter();
		s1.printBlack("서희의 ppt 파일");
		LGPrinter l1 = new LGPrinter();
		l1.printBlack("서희의 엑셀 파일");
		
		System.out.println();
		
		/*
		 * 인터페이스 상속
		 *  클래스들끼리 상속을 통해 확장하듯
		 *  인터페이스들끼리 자체적으로 확장하고 싶다면
		 * 	extends 이용해서 상속한다
		 * 
		 * 클래스는 다중상속 x
		 * 인터페이스는 다중상속 o
		 * 
		 * 상수(필드) static 이기 때문
		 * 구현체를 따라가지 않는다
		 * → 독립적인 상수
		 * 
		 * 인터페이스에 클래스를 상속하거나 클래스에 인터페이스를 상속은 X
		 * Object 클래스가 최고 조상이 아니기 때문에
		 * 
		 */
		
		// 인터페이스 상속에 의한 다형성도 가능
		ColorPrinter[] list = {new ColorPrintSamsung(), new ColorPrintLG(), new HpPrinter()};
		
		// 어떤 타입이 와도 다 저장할 수 있는, 모든 타입을 받아주는 Object 클래스 이용해도 된다
//		for(Object temp : list) { // Object는 모든 클래스의 부모 클래스이므로 현재 업캐스팅이 된 상황(자식 → 부모)
//			temp.
//		}
		for(ColorPrinter temp : list) {
			temp.printBlack("서희 ppt");
			temp.printColor("서희 엑셀");
			if(temp instanceof ColorPrinter) { // 캐스팅이 가능한지 물어봄
				System.out.println("가능하다!");
			} else {
				System.out.println("불가능하다!");
			}	
			System.out.println();
		}
		
		
	}

}
