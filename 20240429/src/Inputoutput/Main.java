package Inputoutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	// 전역변수
	private static MemoList memoList = new MemoList(); // 외부 접근 불가능, main 클래스 안에서만 접근 가능
	
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * 입출력
		 * - 파일, 키보드, 모니터, 메모리 사이를 연결하는 무언가 필요하다 (스트림 Stream)
		 * 스트림
		 * - 데이터를 운반하는데 사용되는 연결 통로
		 * 
		 */

		/*
		 * 입력스트림
		 * - 불러오기
		 * 출력스트림
		 * - 저장
		 * 
		 */
		
		/*
		 * 이진파일
		 * - 동영상, 이미지, 엑셀, 기본 자료형
		 * 객체를 저장할 수 있는 형태!
		 * 
		 */
		
		/*
		 * 텍스트 파일
		 * - 오직 문자로만 저장하고 불러오기
		 * 
		 */
		

		int menu = 0;
		while (menu != 7) {

			while (true) {
				System.out.println("==============================");
				System.out.println("1.입력  2.목록보기  3.수정  4.삭제");
				System.out.println("5.파일로 저장  6.파일에서 읽기  7.종료");
				System.out.println("==============================");
				System.out.print("원하는 메뉴를 입력하고 enter키를 누르세요:");

				menu = scan.nextInt();
				
				// 정상적으로 입력했을 때는 while문 나가기
				if (menu >= 1 && menu <= 7) {
					break;
				}
				// 7초과 또는 -값이 들어오면
				System.out.println("1 ~ 7 사이의 메뉴만 입력하세요!");
			}
			switch(menu) {
			
			case 1:
				insert();
				break;
				
			case 2:
				print();
				break;
				
			case 3:
				break;	
			
			case 4:
				break;
			
			case 5:
				fileWrite();
				break;	
				
			case 6:
				fileRead();
				break;	
				
			}

		}
		// switch에서 해당되지 않으면 다시 while문으로 올라가서 menu != 7 다른지에 대한 조건에 해당되어 false가 나온다 - 반복이 멈추게 된다
		System.out.println("프로그램 종료!");

	}
	// memoList에 있는 ArrayList를 반환 받아서 데이터를 출력하는 메서드
	private static void print() {
		// ArrayList 전체 가져오기
		ArrayList<Memo> temp = memoList.getMemoList();
		
		if(temp.size() == 0) {
			System.out.println("데이터가 없습니다.");
		}else {
			for(int i = 0; i < temp.size(); i++) {
				System.out.println(temp.get(i));
			}
		}
		
	}
	
	// 키보드로 텍스트 파일 이름을 입력받아 텍스트 파일에 저장된 데이터를 ArrayList에 저장하는 메서드
	private static void fileRead() {
		Scanner scan = new Scanner(System.in);
		System.out.print("읽어올 텍스트 파일 이름: ");
		String fileName = scan.nextLine().trim();
		
		// 텍스트 파일에 저장된 데이터를 ArrayList에 저장하는 메서드를 실행한다(호출)
		memoList.readMemo(fileName);
	}
	
	// 키보드로 텍스트 파일 이름을 입력받아 ArrayList에 저장된 데이터를 텍스트 파일로 저장하는 메서드
	private static void fileWrite() {
		Scanner scan = new Scanner(System.in);
		System.out.print("저장할 텍스트 파일이름: ");
		String fileName = scan.nextLine().trim();
		
		// ArrayList에 저장된 데이터를 텍스트 파일로 저장하는 메서드
		memoList.writeMemo(fileName);
	}
	
	
	// 글을 저장하는 메서드
	// 각각 스캐너를 이용해서 입력 받고 ArrayList에 저장하는 내용을 작성하기
	private static void insert() {
		Scanner scan = new Scanner(System.in);
		System.out.println("게시글에 저장할 글 입력: ");
		System.out.print("이름: ");
		// 공백 제거 trim()
		// 중간 공백은 제거 못하고 앞과 뒤에 있는 공백만 제거
		String name = scan.nextLine().trim();
		
		System.out.print("비밀번호: ");
		String password = scan.nextLine().trim();
		
		System.out.print("메모: ");
		String memo = scan.nextLine().trim();
		
		Memo vo = new Memo(name, password, memo);
		
		// memoList 다른 클래스로 보내야한다
		memoList.addMemo(vo);
		System.out.println("저장 완료!");
	}

}
