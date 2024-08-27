package JDBC_Test;

import java.util.Scanner;

// 데이터를 테이블에 저장, 수정, 삭제 및 조회 작업을 
//  실행하기 전 필요한 전처리 작업을 실행하는 클래스

public class MemoService {
	// 데이터를 입력받아서 전송만 담당하는 DAO 클래스로 넘겨준다. : 로그 찍기
	private static Scanner sc = new Scanner(System.in);

	public static void insert() {
		// 실행한 메서드를 확인하는 것!
		System.out.println("MemoService 안에 insert()메서드 실행");
		sc.nextLine();
		// 전처리
		// 키보드로 memo에 대한 데이터 입력받기
		System.out.println("메모를 입력하세요!");
		System.out.print("글 제목: ");
		String title = sc.nextLine();
		System.out.print("글 내용: ");
		String content = sc.nextLine();

		// 입력받은 데이터를 객체화 시켜서
		MemoVO vo = new MemoVO(title, content);
		System.out.println(vo);
		// DAO 클래스로 넘겨준다.
		if (MemoDAO.insert(vo)) {
			System.out.println("메모가 성공적으로 추가되었습니다!");
		} else {
			System.out.println("메모 추가를 실패하였습니다!");
		}

		// 저장이 잘 되면 그 결과를 반환받아서 출력
		// 성공 시 땡땡님의 글이 저장완료 되었습니다.
		// 실패 시 글이 제대로 저장되지 않았습니다.

	}

	// 수정할 글 번호를 입력 받아 DAO로 넘겨주어 글을 수정하는 메서드
	public static void update() {
		System.out.println("MemoService 안에 update()메서드 실행");
		
		// 수정할 글의 번호를 입력 받는다.
		System.out.print("수정할 글의 번호: ");
		int idx = sc.nextInt();
		
		// update, delete를 할 땐 꼭! 검색을 먼저 하고,
		// 검색한 내용이 있을 때 수정, 삭제를 해야된다.
		MemoVO vo = MemoDAO.selectById(idx);
		if(vo != null) { // 수정할 메모가 존재하니?
			System.out.println("수정할 메모가 있다.");
			sc.nextLine();
			// 수정할 내용을 입력 받기
			// 제목, 내용 두 개만 받기
			System.out.print("수정할 제목: ");
			String title = sc.nextLine();
			
			System.out.print("수정할 내용: ");
			String content = sc.nextLine();
			
			// 진짜 수정하는 update 메서드 만들기
			MemoDAO.update(idx, title, content);
			System.out.println("수정 완료하였습니다!");
			
		}
	}	
	
	// 삭제하기
	// 글 번호로 삭제하는 메서드 만들기
	public static void delete() {
		// 키보드로 삭제할 글 번호 입력하고 DAO로 전달해서 DAO에서 삭제하고
		// 삭제가 되었다면 "정상적으로 삭제 됨"
		//      되지않았다면 "정상적으로 삭제 되지 않음" 출력
		System.out.println("MemoService 안에 delete()메서드 실행");
		
		System.out.print("삭제할 글의 번호: ");
		int idx = sc.nextInt();
		
		// 먼저 글의 번호가 있는 지 확인
		MemoVO vo = MemoDAO.selectById(idx);
		if(vo != null) { 
			MemoDAO.delete(idx);
			System.out.println(idx + "번 째 글을 정상적으로 삭제 완료하였습니다!");
		} else {
			System.out.println(idx + "번 째 글이 없어 삭제할 수 없습니다!");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
