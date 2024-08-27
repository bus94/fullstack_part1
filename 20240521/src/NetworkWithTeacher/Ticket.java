package NetworkWithTeacher;

/*
 * Ticket 클래스는 한 건의 티켓 구매 정보를 저장하는 클래스
 * 구매하는 아이디
 * 영화제목
 * 영화날짜
 * 상영관
 * 좌석
 */
public class Ticket {
	
	private String userId;
    private String movieTitle;
    private String movieDate;
    private int count;
    private String seat;
    
	public Ticket() {
	}

	public Ticket(String userId, String movieTitle, String movieDate, int count, String seat) {
		this.userId = userId;
		this.movieTitle = movieTitle;
		this.movieDate = movieDate;
		this.count = count;
		this.seat = seat;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Ticket [userId=" + userId + ", movieTitle=" + movieTitle + ", movieDate=" + movieDate + ", count="
				+ count + ", seat=" + seat + "]";
	}
    
}
