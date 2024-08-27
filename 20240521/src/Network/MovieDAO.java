package Network;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// DB에 접근해서 저장하는 내용
public class MovieDAO {

	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;
	private String sql;

	public void insert(Movie movie) throws Exception {
		System.out.println("MovieDAO insert() 메서드 실행!");
		System.out.println(movie);

		conn = DBUtil.getConnection();
		String sql = "insert into Movie values(?, ?, ?, ?, ?, ?) ";

		pt = conn.prepareStatement(sql);
		pt.setString(1, movie.getRnum());
		pt.setString(2, movie.getRank());
		pt.setString(3, movie.getRankOldAndNew());
		pt.setString(4, movie.getMovieNm());
		pt.setString(5, movie.getOpenDt());
		pt.setString(6, movie.getAudiAcc());

		int result = pt.executeUpdate();
		
		pt.close();
		conn.close();
		
	}
}

// select 문 작성해보았는데 MovieService클래스의 insert() 메서드 통해 작성 중
// 필요 없는 내용!!!!
//	public void select() {
//		try {
//			conn = DBUtil.getConnection();
//			String sql = " select * from Movie ";
//			pt = conn.prepareStatement(sql);
//			rs = pt.executeQuery();
//
//			System.out.println("일별 박스오피스");
//			System.out.println("순서\t영화타입\t순위\t랭킹진입여부\t영화명\t개봉일\t누적관객수");
//			while (rs.next()) {
//				Movie movie = new Movie(rs.getString("rnum"), rs.getString("boxofficeType"), rs.getString("rank"),
//						rs.getString("rankOldAndNew"), rs.getString("movieNm"), rs.getString("openDt"),
//						rs.getString("audiAcc"));
//				System.out.println(movie.getRnum() + "\t" + movie.getBoxofficeType() + "\t" + movie.getRank() + "\t"
//						+ movie.getRankOldAndNew() + "\t" + movie.getMovieNm() + "\t" + movie.getOpenDt() + "\t"
//						+ movie.getAudiAcc());
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}