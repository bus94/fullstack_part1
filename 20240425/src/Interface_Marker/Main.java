package Interface_Marker;

public class Main {

	public static void main(String[] args) {

		/*
		 * 마커인터페이스
		 *  빈 인터페이스
		 * 	단순하게 클래스들끼리 연결하기 위해 만들어놓은 인터페이스
		 */
		
		Tank t1 = new Tank();
		Soldier s1 = new Soldier();
		Doctor d1 = new Doctor();
		
		// 1. 마커 인터페이스로 사람으로 묶을 수 있었고
		// 2. 부모 클래스 타입으로 잠시 변환하여 해당 변수에 접근할 수 있도록 하였다
		d1.operate(s1);
		d1.operate(d1);
		// 탱크는 마커 인터페이스를 구현하지 않았기 때문에 에러 발생
		// d1.operate(t1); 
		
	}

}

interface A{
	
}