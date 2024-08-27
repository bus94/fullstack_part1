package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Book_Item.Book;
import Book_Main.DBUtil;

// DB 가기 전에 데이터를 가공하는 역할
// Service 클래스는 DB에 접속 정보를 생성하는 역할이다.
public class BookService {
	Connection co = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public boolean select(Book book) {
		boolean res = false;
		try {
			co = DBUtil.getMysqlConn();
			String sql = "select * from bookmarket where (";
			ps = co.prepareStatement(sql);
//			ps.setString(parameterIndex, x);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return res;
	}
}
