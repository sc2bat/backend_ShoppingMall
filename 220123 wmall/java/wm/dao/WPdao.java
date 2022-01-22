package wm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wm.dto.WPVO;
import wm.util.Db;

public class WPdao {
	private WPdao(){}
	private static WPdao itc = new WPdao();
	public static WPdao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public ArrayList<WPVO> getBestList() {
		ArrayList<WPVO> list = new ArrayList<WPVO>();
		String sql = "SELECT * FROM wbest_view";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				WPVO wpvo = new WPVO();
				wpvo.setPseq(rs.getInt("pseq"));
				wpvo.setName(rs.getString("name"));
				wpvo.setPrice_s(rs.getInt("price_s"));
				wpvo.setImage(rs.getString("image"));
				list.add(wpvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt, rs);
		}
		return list;
	}


	public ArrayList<WPVO> getNewList() {
		ArrayList<WPVO> list = new ArrayList<WPVO>();
		String sql = "SELECT * FROM wnew_view";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				WPVO wpvo = new WPVO();
				wpvo.setPseq(rs.getInt("pseq"));
				wpvo.setName(rs.getString("name"));
				wpvo.setPrice_s(rs.getInt("price_s"));
				wpvo.setImage(rs.getString("image"));
				list.add(wpvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt, rs);
		}
		return list;
	}
	
}
