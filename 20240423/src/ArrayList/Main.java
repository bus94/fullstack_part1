package ArrayList;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// 자료 구조
		// - 데이터를 추가, 삭제, 수정, 조회할 때
		//   효율적으로 할 수 있도록 미리 만들어놓은 구조
		
		// 컬렉션 프레임 워크
		// - 자료 구조를 이ㅛㅇㅇ해서 자바가 미리 만들어 놓은 구조
		
		// list
		// - 순서가 있는 자료형
		// 	  인덱스(공간번호)를 이용해서 접근
		
		// set
		// - 순서가 없는 자료형
		//   중복 제거
		
		// ArrayList
		// 유동적인 배열을 만드는 것이 미리 만들어져있었다
		// 사용 방법: ArrayList<저장할 타입> 변수명
		ArrayList<String> list = new ArrayList<String>();
		
		// 추가 list.add();
		list.add("이서희");
		list.add("이익준");
		list.add("김준완");
		list.add("양석형");
		
		// 출력
		System.out.println(list);
		
		// "이서희"와 "이익준" 사이에 "채송화"를 저장
		// 중간 끼워넣기
		list.add(1, "채송화");
		System.out.println(list);
		
		// 삭제 list.remove();
		list.remove("김준완");
		System.out.println(list);
		
		// 검색 
		// - list.contains(찾는 문자열); : list 안에 해당 "문자열"이 포함 되어있니?
		System.out.println(list.contains("양석형"));
		// - list.indexOf(찾는 문자열); : list 안에 해당 "문자열"의 인덱스가 무엇이니?
		System.out.println(list.indexOf("양석형"));
	}

}
