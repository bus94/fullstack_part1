package Network;

public class Movie {
	private String rnum;			// 순서
	private String rank;			// 순위
	private String rankOldAndNew;	// 랭킹 신규진입여부
	private String movieNm;			// 영화명
	private String openDt;			// 개봉일
	private String audiAcc;			// 누적 관객수
	
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getRankOldAndNew() {
		return rankOldAndNew;
	}
	public void setRankOldAndNew(String rankOldAndNew) {
		this.rankOldAndNew = rankOldAndNew;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public String getOpenDt() {
		return openDt;
	}
	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}
	public String getAudiAcc() {
		return audiAcc;
	}
	public void setAudiAcc(String audiAcc) {
		this.audiAcc = audiAcc;
	}
	
	public Movie() {
	}
	
	public Movie(String rnum, String rank, String boxofficeType, String rankOldAndNew, String movieNm, String openDt,
			String audiAcc) {
		this.rnum = rnum;
		this.rank = rank;
		this.rankOldAndNew = rankOldAndNew;
		this.movieNm = movieNm;
		this.openDt = openDt;
		this.audiAcc = audiAcc;
	}
	@Override
	public String toString() {
		return "[rnum=" + rnum + ", rank=" + rank + ", rankOldAndNew="
				+ rankOldAndNew + ", movieNm=" + movieNm + ", openDt=" + openDt + ", audiAcc=" + audiAcc + "]";
	}
	
	
	
}
