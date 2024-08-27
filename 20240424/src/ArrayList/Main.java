package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

//		/*
//		 * ArrayList 특징
//		 * : 연속적인 데이터의 리스트 (연속적으로 데이터를 저장하기 때문에 빈 공간이 없음)
//		 * 
//		 * Object 클래스 배열
//		 * - 배열을 이용하기 때문에 인덱스(공간번호)를 이용해 요소에 빠르게 접근 할 수 있다.
//		 * 
//		 * - 기본 배열은 크기가 고정되어있는데 ArrayList는 가변적으로 공간을 늘리거나 줄인다.
//		 * - 기본 배열은 공간이 꽉 찰 때마다 배열을 복사하는 방식으로 늘리는 과정이 필요 (약간의 지연시간이 발생)
//		 * 
//		 * 기본 배열 [] 
// 		 *  - 정적 할당
//		 * ArrayList <> 
//		 *  - 동적 할당
//		 * 
//		 */
//		
//		// 기본 배열에서는 ex. 10개의 인덱스 중 4번 인덱스에 null값을 넣으면 빈 공간이 생기는 것! 그래서 연속적인 리스트를 할 수가 없다
//		// <> : 제네릭
//		// 기본 자료형에서는 제네릭 타입으로 사용하지 않는다. 기본 자료형: int, float, double, char, boolean
//		// 무조건 Class 객체들만 사용 가능하다
//		
//		Number[] r = new Number[5];
//		
//		r[0] = 10;
//		r[1] = 20;
//		r[2] = 30;
//		r[3] = 40;
//		r[4] = 50;
//		
//		r[3] = null;
//		
//		System.out.println(Arrays.toString(r));
//		
//		// 기본 자료형 → 객체화 시키는 클래스 
//		// : 래퍼 클래스 (Wrapper class)
//		// ex. int → Integer
//		
//		ArrayList<Integer> list = new ArrayList<Integer>(); // 초기 공간을 미생성
//		
//		list.add(10);
//		list.add(20);
//		list.add(30);
//		list.add(40);
//		list.add(50);
//		
//		System.out.println(list);
//		
//		list.remove(3);
//		System.out.println(list);
//		
//		// 초기 공간을 생성
//		ArrayList<Integer> numlist1 = new ArrayList<Integer>(10); 
//		
//		// 기존에 만들었던 리스트를 복사하는 개념
//		ArrayList<Integer> numlist2 = new ArrayList<Integer>(numlist1); 
//
//		ArrayList<String> strlist1 = new ArrayList<String>(10);
//		
//		strlist1.add("a");
//		strlist1.add("b");
//		strlist1.add("c");
//		strlist1.add("d");
//		strlist1.add("e");
//		strlist1.add("f");
//		
//		// 리스트 사이즈 size()
//		System.out.println(strlist1.size());
		
		// 리스트 자체 저장
		ArrayList<String> list1 = new ArrayList<String>();
		
		list1.add("1");
		list1.add("2");
		list1.add("5");
		list1.add("6");
		list1.add("7");
		list1.add("8");
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("3");
		list2.add("4");
		
		System.out.println(list1);
		System.out.println(list2);
		
		// 전체 리스트를 어떤 리스트 변수에 추가
		// list1 변수에 list2 내용을 추가
		// add() 맨 뒤에 "데이터를" 추가
		// addAll() 맨 뒤에 "리스트를" 추가
		list1.addAll(list2);
		
		System.out.println(list1);
		
		// 
		list1.add(4, "100");
		// list1.add(100, "100"); → 에러 발생 : 연속적인 자료 구조이기에 빈 공간을 허용하지 않고 다음 인덱스에 값을 저장할 수 있도록 해야한다
		
		// IndexOutOfBoundsException
		// 1. 리스트의 선언된 공간과 내가 호출한 인덱스 공간이 넘어갔기 때문에 (범위 초과)
		
		System.out.println(list1);
		
		// 리스트 전체 데이터값 지우기
		// list1.clear();
		
		// 검색
		// contains(값);
		// 포함 되어있으면 true, 포함 되어있지않으면 false
		
		System.out.println(list1.contains("1")); // True
		System.out.println(list1.contains(1)); // False
		
		// 데이터 얻기
		// get(인덱스);
		System.out.println(list1.get(0));
		
		// 범위를 지정해서 가져오기
		// 배열명.subList(시작인덱스, 끝인덱스);
		// 시작 번호 데이터는 포함, 끝나는 번호는 데이터를 포함 하지 않는다
		System.out.println(list1.subList(0, 5)); // 인덱스 기준 0~4까지의 데이터값
		System.out.println(list1.subList(2, 6)); // 인덱스 기준 2~5까지의 데이터값
		
		// 수정
		// set(intdex, element);
		list1.set(0, "one");
		System.out.println(list1);
		
		// ArrayList → 기본 배열 
		// 가변적인 배열을 고정된 배열로 변경하는 방법 (캐스팅)
		// 바꾸고자 하는 배열 타입  배열명 = (변경 배열) Array배열명.toArray();
		//  - 굳이 바꿀 일은 없음
		Object[] arr1 = list1.toArray();
		System.out.println(arr1);
		
	}

}
