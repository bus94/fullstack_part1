package Memo;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
	// 저장된 글 전체를 얻어오는 메서드
	public static void select() {
		// 얻어온 글을 출력하는 메서드
		System.out.println("Service클래스의 select() 실행!");
		ArrayList<MemoVO> list = DAO.select();
		
		for(MemoVO memo : list) {
			System.out.println(memo);
		}
	}
	public static void insert() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Service클래스의 insert() 실행!");
		
		System.out.println("추가할 게시글의 정보를 입력해주세요.");
		System.out.print("글  제목: ");
		String name = sc.nextLine();
		
		System.out.print("내    용: ");
		String memo = sc.nextLine();
		
		System.out.print("비밀번호: ");
		String password = sc.nextLine();
		
		MemoVO temp = new MemoVO(name, memo, password);
		
		DAO.insert(temp);
	}
	
	// 아이디 혹은 idx 번호로 수정해야되는 data가 있는지 먼저 확인하고 수정하는 DAO.update() 메서드를 실행해야한다.
	public static void update() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Service의 update() 실행!");
		MemoVO vo = search();
		if(vo != null) {
			System.out.print("수정할 게시글의 비밀번호: ");
			String pass = sc.nextLine();
			
			if(vo.getPassword().equals(pass)) {
				System.out.println("수정할 데이터를 입력하세요.");
				System.out.print("수정할 글 제목: ");
				String name = sc.nextLine();
				System.out.print("수정할 글 내용: ");
				String memo = sc.nextLine();
				System.out.print("수정할 글 비밀번호: ");
				String password = sc.nextLine();
				
				// 기존의 데이터를 가지고 있는 vo변수 안에 수정 후 넘겨주기
				vo.setName(name);
				vo.setMemo(memo);
				vo.setPassword(password);
				
				// DB에서 실행해서 성공한 행의 개수가 넘어오기 때문에 꼭 1이 아닐 수도 있다. → 0보다 큰 값인지, 작은 값인지로 확인하기
				if(DAO.update(vo) > 0) {
					System.out.println("정상적으로 수정되었습니다.");
				} else {
					System.out.println("수정에 실패하였습니다. 내용을 확인해주세요.");
				}
				
			}
			else {
				System.out.println("비밀번호가 다릅니다. 다시 메뉴로 돌아갑니다.");
				return; // 함수 종료!
			}
			
		} else {
			// 찾는 아이디가 없으면 함수 종료!
			System.out.println("찾는 아이디가 없습니다. 다시 메뉴로 돌아갑니다.");
		}
		
	}
	
	public static void delete() {
		MemoVO vo = search();
		if(vo != null) {
			
			DAO.delete(vo);
			System.out.println("삭제를 완료하였습니다.");
		}else {
			System.out.println("찾는 아이디가 없습니다!");
		}
		
	}
	
	public static MemoVO search() {
		Scanner sc = new Scanner(System.in);
//		System.out.println("수정할 게시글의 번호를 입력하세요.");
//		System.out.print("게시글 번호: ");
//		int num = sc.nextInt();
		
		System.out.println("수정할 게시글의 아이디를 입력하세요.");
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		// 실제 데이터베이스에서 검색하기
		MemoVO vo = DAO.search(name);
		System.out.println("확인: " + vo);
		return vo;
	}
}
