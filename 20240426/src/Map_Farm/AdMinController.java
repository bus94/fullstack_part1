package Map_Farm;

import java.util.HashMap;

// 직원들에 대한 정보를 저장하는 클래스
public class AdMinController {
	private HashMap<Farm, Integer> hMap = new HashMap<>(); // 우변의 제네릭의 타입들은 좌변의 제네릭의 타입을 참고하기 때문에 생략 가능

	// 농작물을 추가할 때 함수
	// 다형성을 이용해서 어떤 객체가 와도 농작물과 관련된 데이터를 저장

	// 실제 new를 이용해서 객체를 생성하면 new를 쓸 때마다 새로운 메모리의 주소가 생성된다
	// 자신의 주소값이 들어오면 저장 안함

	// 실질적으로 주소값이 가리키는 객체 안에 인스턴스 변수의 값이 중복될 수 있다
	boolean addNewKind(Farm f, int amount) { // 추가하는 객체가 과일, 채소, 견과인지 모르기 때문에 Farm 객체로 먼저 받기
		// 사과 10
		// 사과 20
		// 사과 10 + 20 = 30

		// Farm 이라는 주소값 있는지 확인
		// f 객체는 새로 만들어서 넘어온 객체
		// prev 변수는 기존에 hMap 저장되었던 객체
		boolean check = false;
		Farm prev = null;
		for (Farm temp : hMap.keySet()) {
			if (f == temp) {
				prev = temp;
			}
		}

		/* hMap에서 가져온 객체도 타입을 확인하고, 그 안에 있는 이름을 비교해서 사용한다 */
		// Farm 클래스 안에 equals() 메서드를 오버라이딩해서 객체끼리 비교할 수 있도록 재정의 해야된다
		if (f instanceof Fruit) {
			Fruit temp = (Fruit) f;
		} else if (f instanceof Vegetable) {
			Vegetable temp = (Vegetable) f;
		} else if (f instanceof Nut) {
			Nut temp = (Nut) f;
		}
		if (!hMap.containsKey(f)) {
			hMap.put(f, amount);
			return true;
		}
		return false;
	}

}
