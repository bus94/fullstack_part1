package BookDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
	public static ArrayList<Book> bookList = new ArrayList<Book>();

	public static void main(String[] args) {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/db1_book_store?serverTimezone=UTC";
			con = DriverManager.getConnection(url, "root", "1234");
			String sql = "SELECT * FROM book";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				bookList.add(new Book(rs.getInt("book_no"), rs.getInt("book_kind")
						, rs.getString("book_title"), rs.getInt("book_price")
						, rs.getInt("book_count"), rs.getString("book_author")
						, rs.getString("book_publishing_com"), rs.getString("book_image")
						, rs.getString("book_content"), rs.getString("book_discount_rate")));
			}
			System.out.println(bookList);
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버를 찾지 못했다!");
		} catch(SQLException e) {
			System.out.println("정보가 잘못 되었다!");
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		
	}

}
