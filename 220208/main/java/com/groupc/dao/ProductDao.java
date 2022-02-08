package com.groupc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.groupc.dto.ProductVO;
import com.groupc.util.Dbm;

public class ProductDao {
	private ProductDao() {}
	private static ProductDao itc = new ProductDao();
	public static ProductDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
//	best 상품
	public ArrayList<ProductVO> getBestList() {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM best_view";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				// 필요한 정보 
				pvo.setBseq(rs.getInt("bseq"));
				pvo.setBname(rs.getString("bname"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setImage(rs.getString("image"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return list;
	}

	// 신상품
	public ArrayList<ProductVO> getNewList() {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM new_view";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				// 필요한 정보 
				pvo.setBseq(rs.getInt("bseq"));
				pvo.setBname(rs.getString("bname"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setImage(rs.getString("image"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return list;
	}
	
}
