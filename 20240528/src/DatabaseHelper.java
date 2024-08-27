import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/yourdatabase";
    private static final String USER = "yourusername";
    private static final String PASSWORD = "yourpassword";
    private static Connection conn; 
    private static PreparedStatement pstmt;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void updateRow(int id, String name, int age) throws SQLException {
    	conn = getConnection();
        String sql = "UPDATE your_table SET name = ?, age = ? WHERE id = ?";
        pstmt = conn.prepareStatement(sql);
        
        try{
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    public static void deleteRow(int id) throws SQLException {
        String sql = "DELETE FROM your_table WHERE id = ?";
        conn = getConnection();
        pstmt = conn.prepareStatement(sql);
        try{
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    public static void resetAutoIncrement(int nextId) throws SQLException {
        String sql = "ALTER TABLE your_table AUTO_INCREMENT = ?";
        conn = getConnection();
        pstmt = conn.prepareStatement(sql);
        try{
            conn.setAutoCommit(false); // 트랜잭션 시작
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("LOCK TABLES your_table WRITE"); // 테이블 잠금
                pstmt.setInt(1, nextId);
                pstmt.executeUpdate();
                stmt.execute("UNLOCK TABLES"); // 테이블 잠금 해제
            }
            conn.commit(); // 트랜잭션 커밋
        } catch (SQLException e) {
            conn.rollback(); // 오류 발생 시 롤백
            throw e;
        } finally {
            conn.setAutoCommit(true); // 자동 커밋 모드 복원
        }
    }
}
