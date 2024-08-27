package NetworkWithTeacher;

/*
 * Ticket을 조회할 때 사용하는 전처리 클래스
 * 티켓 취소, 티켓 추가, 구매내역을 조회할 때 사용
 */
public class TicketService {
	
	private TicketDAO dao = new TicketDAO();

	// 티켓 추가하는 메서드 (예매)
	public boolean insert(Ticket ticket) throws Exception{
		return dao.insert(ticket);
	}

	public void select() throws Exception{
		dao.select();
	}

	
	
	
}
