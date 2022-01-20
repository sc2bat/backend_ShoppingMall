package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenac.dto.CartVO;
import com.ezenac.dto.OrderVO;
import com.ezenac.util.Dbman;

public class OrderDao {
	private OrderDao() {}
	private static OrderDao itc = new OrderDao();
	public static OrderDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public int insertOrder(ArrayList<CartVO> list, String id) {
		int oseq = 0;
		con = Dbman.getConnection();
		// 1. 주문번호(시퀀스 자동입력)와 구매자 아이디로 orders 테이블에 레코드 추가
		String sql = "INSERT INTO orders(oseq, id) VALUES(orders_seq.nextVal, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		// 2. Orders 테이블에 시퀀스로 입력된 가장 마지막(방금추가한) 주문 번호 조회
			pstmt.close();
			sql = "SELECT MAX(oseq) AS max_oseq FROM orders";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				oseq = rs.getInt("max_oseq");
			}
		// 3. list 의 카트목록들을 Orders 에서 얻은 max_oseq 와 함께 order_detail 에 추가
			pstmt.close();
			for(CartVO cvo : list) {
				// 카트 목록을 하나씩 꺼내서 order_detail 테이블에 추가하고 
				sql = "INSERT INTO order_detail(odseq, oseq, pseq, quantity) "
						+ " VALUES(order_detail_seq.nextVal, ?, ? ,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, oseq);
				pstmt.setInt(2, cvo.getPseq());
				pstmt.setInt(3, cvo.getQuantity());
				pstmt.executeUpdate();
				
			// 4. order_detail 에 추가된 카트 내용은 cart 테이블에서 처리되었으므로 삭제 또는 result 를 2로 변경 또는 삭제
				pstmt.close();
				// sql = "DELETE FROM cart WHERE cseq=?";
				sql = "UPDATE cart SET result='2' WHERE cseq=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cvo.getCseq());
				pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
		
		// 5. 주문번호 oseq 를 return
		return oseq;
	}
	
	
	
}
