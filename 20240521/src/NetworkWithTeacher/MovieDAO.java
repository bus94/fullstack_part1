package NetworkWithTeacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// DB에 접근해서 저장하는 내용
public class MovieDAO {

	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;
	private String sql;
	
	public boolean hasMovieData() throws Exception{
		// 1. 결과를 저장할 변수 생성
		boolean result = false;
		
		// 2. DB 접속
		conn = DBUtil.getConnection();
		
		// 3. 명령문 작성
		sql = "select count(*) from Movie ";
		
		// 4. 명령문 실행
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		
		// 5. 결과 반환
		if(rs.next()) {
			// 조회한 결과를 가져온다. 그때 컬럼이 하나 반환된다. 그 안의 값을 꺼낼 때 정수값으로 반환해서 0과 비교한다.
			if(rs.getInt(1) > 0) {
				result = true;
			}
		}
		
		// 6. 자원 해제
		rs.close();
		pt.close();
		conn.close();
		
		return result;
	}

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

	// 영화 전체 조회를 해서 DB에서 가져온다.
	public ArrayList<Movie> select() throws Exception{
		ArrayList<Movie> list = null;
		
		conn = DBUtil.getConnection();
		sql = "select * from Movie ";
		
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();
		
		if(rs.next()) {
			list = new ArrayList<Movie>();
			
			do {
				list.add(new Movie(
						rs.getString("rnum"),
						rs.getString("rank"),
						rs.getString("rankOldAndNew"),
						rs.getString("movieNm"),
						rs.getString("openDt"),
						rs.getString("audiAcc")
						));
			}while(rs.next());
		}
		
		rs.close();
		pt.close();
		conn.close();
		
		return list;
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