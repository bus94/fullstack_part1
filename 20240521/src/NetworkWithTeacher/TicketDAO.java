package NetworkWithTeacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TicketDAO {
	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;

	public boolean insert(Ticket ticket) throws Exception {
		boolean result = false;
		conn = DBUtil.getConnection();
		String sql = "insert into Ticket values(seq_ticket.nextval, ?, ?, ?, ?, ?)";

		pt = conn.prepareStatement(sql);
		pt.setString(1, ticket.getUserId());
		pt.setString(2, ticket.getMovieTitle());
		pt.setString(3, ticket.getMovieDate());
		pt.setInt(4, ticket.getCount());
		pt.setString(5, ticket.getSeat());

		result = pt.executeUpdate() > 0 ? true : false;

		return result;
	}

	// 구매 목록 확인하는 메서드
	public void select() throws Exception {
		conn = DBUtil.getConnection();
		String sql = "select * from ticket t join userlist u on t.user_id = u.id ";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		if (rs.next()) {
			// 반복내용 작성해서 출력하기
			System.out.println("[" + rs.getString("name") + "님의 예매 목록]" + "\n" + "ticket_id" +
								". 영화제목: " + rs.getString("movie_title") + ", 개봉일: " + rs.getString("movie_date"));
			System.out.println();
		}

		rs.close();
		pt.close();
		conn.close();

	}

}
