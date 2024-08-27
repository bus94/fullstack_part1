package Market;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Instagram.DBUtil;

public class DAO {
	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;
	private Statement st;
	private String sql;

	// 1번 문제
	public void join1() throws Exception {
		conn = DBUtil.getConnection();
		sql = "SELECT u.nickname AS 주문자, " + " o.id AS 주문번호, " + " o.status AS 주문상태, " + " o.created_at AS 주문일자 "
				+ " FROM orders o " + " JOIN users u ON ( u.id = o.user_id ) " + " WHERE u.nickname = '서희' ";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		if (rs.next()) {
			do {
				System.out.println("============================");
				System.out.println("[서희의 모든 주문 목록]");
				System.out.println("주문자: " + rs.getString("주문자"));
				System.out.println("주문번호: " + rs.getString("주문번호"));
				System.out.println("주문상태: " + rs.getString("주문상태"));
				System.out.println("주문일자: " + rs.getString("주문일자"));
				System.out.println("============================");
			} while (rs.next());
		}
	}

	// 2번 문제
	public void join2() throws Exception {
		conn = DBUtil.getConnection();
		sql = "SELECT COUNT(*) AS 주문횟수  FROM orders o " + " JOIN users u ON ( u.id = o.user_id ) "
				+ " WHERE u.nickname = '서희'";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		if (rs.next()) {
			do {
				System.out.println("============================");
				System.out.println("[서희가 주문한 모든 횟수 조회]");
				System.out.println("주문횟수: " + rs.getString("주문횟수"));
				System.out.println("============================");
			} while (rs.next());
		}
	}

	public void join3() throws Exception {
		conn = DBUtil.getConnection();
		sql = "SELECT u.nickname AS 주문자명, o.id AS 주문번호, p.amount AS 결제금액 " + " FROM orders o "
				+ " JOIN users u ON ( o.user_id = u.id ) JOIN payments p ON ( o.id = p.order_id ) "
				+ " WHERE u.nickname = '서희'";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		if (rs.next()) {
			do {
				System.out.println("============================");
				System.out.println("[서희가 모든 주문별 결제 금액을 조회]");
				System.out.println("주문자명: " + rs.getString("주문자명"));
				System.out.println("주문번호: " + rs.getString("주문번호"));
				System.out.println("결제금액: " + rs.getString("결제금액"));
				System.out.println("============================");
			} while (rs.next());
		}
	}

	public void join4() throws Exception {
		conn = DBUtil.getConnection();
		sql = "SELECT SUM(p.amount) AS 결제금액 " + " FROM orders o " + " JOIN users u ON ( o.user_id = u.id ) "
				+ " JOIN payments p ON ( o.id = p.order_id ) " + " WHERE u.nickname = '서희'";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		if (rs.next()) {
			do {
				System.out.println("============================");
				System.out.println("[서희의 총 결제 금액을 조회]");
				System.out.println("결제금액: " + rs.getString("결제금액"));
				System.out.println("============================");
			} while (rs.next());
		}
	}

	public void join5() throws Exception {
		conn = DBUtil.getConnection();
		sql = "SELECT SUM(p.price) as 총판매금액 " + " FROM order_details d "
				+ " JOIN products p ON ( d.product_id = p.id ) " + " WHERE p.id = 1";
		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		if (rs.next()) {
			do {
				System.out.println("============================");
				System.out.println("[상품1 돈까스의 총 판매 금액은 64,500원 조회]");
				System.out.println("총판매금액: " + rs.getString("총판매금액"));
				System.out.println("============================");
			} while (rs.next());
		}
	}
}
