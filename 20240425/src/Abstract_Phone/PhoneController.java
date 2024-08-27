package Abstract_Phone;


public class PhoneController {
	
//	// 1) 부모 클래스인 Phone에 대한 객체 배열을 생성하고
//	// 2) 각 인덱스별 자식 클래스들에 대한 객체를 하나씩 생성
//	// 3) 그것을 반복문으로 printInformation 메서드를 이용하여 출력하기
//	
//	// Q. 1에서 왜 세미콜론이 자꾸 에러 발생이 되는가?
//	// Q. 2에서 왜 반복문 작성할 때 phoneList에 대한 길이를 가져올 수 없는걸까?
//	Phone[] phoneList = {new GalaxyNote9(), new V40()};
//	// Q. 기본 생성자를 만들 때에도 자식 클래스의 메서드 중 부모 클래스가 가지고 있지 않는 메서드가 있기 때문에 생성이 안되는 것인지?
//	// Q. 그렇다면 다운 캐스팅을 하면서 객체 배열을 생성하려면 어떻게 해야하는지?
//	
//	for(int i = 0; i < phoneList.length; i++) {
//		((GalaxyNote9) phoneList[i]).printInformation();
//	}
	
	Phone[] phoneList = {new GalaxyNote9(), new V40()};
	
	void show() {
		for(int i = 0; i < phoneList.length; i++) {
			phoneList[i].printInformation();
			System.out.println();
		}
	}
	
}
