package GUI_Table_Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 컨트롤러에서 입력된 데이터나 출력을 해야되는 내용들 정리하는 클래스
// DB로 전송하기 전에 조작하는 클래스
public class TableService {
	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;

	private TableDAO dao = new TableDAO();

	// 추가하는 메서드
	public int insert(Board board) {
		System.out.println("TableService 실행 insert() 메서드");

		return dao.insert(board);
	}

	// 전체 조회를 해서 테이블에 출력!
	public String[][] select() {
		
		return dao.select();
	}
	
	// 삭제하기 메서드
	// 컨트롤러에서 글의 번호를 입력받아서 서비스에게 넘겨준다.
	public int delete(int num) {
		return dao.delete(num);
	}

	// 조회 수를 증가시키는 메서드
	public int readCount(int selectRow) {
		// DB에 현재 선택한 행이 있는지 먼저 가져온다.
		Board board = dao.selectByNum(selectRow);
		if(board != null) {
			// 데이터가 있음!
			// 기존에 있는 readCount값을 먼저 꺼내와야 된다.
			board.setReadCount(board.getReadCount() + 1);
			int temp = dao.update(board);
			if(temp > 0) {
				temp = board.getReadCount();
			}
			
			return temp;
		}
		return 0;
	}

}

