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


	public WPVO getProduct(int pseq) {
		WPVO wpvo = null;
		String sql = "SELECT * FROM wproduct WHERE pseq=?";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				wpvo = new WPVO();
				wpvo.setPseq(pseq);
				wpvo.setName(rs.getString("name"));
				wpvo.setKind(rs.getString("kind"));
				wpvo.setPrice_b(rs.getInt("price_b"));
				wpvo.setPrice_s(rs.getInt("price_s"));
				wpvo.setPrice_dc(rs.getInt("price_dc"));
				wpvo.setContent(rs.getString("content"));
				wpvo.setImage(rs.getString("image"));
				wpvo.setUseyn(rs.getString("useyn"));
				wpvo.setBestyn(rs.getString("bestyn"));
				wpvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt, rs);
		}
		
		return wpvo;
	}


	public ArrayList<WPVO> selectPK(String kind) {
		ArrayList<WPVO> list = new ArrayList<WPVO>();
//		String sql = "SELECT * FROM wproduct WHERE kind=1";
		String sql = "SELECT * FROM wproduct WHERE kind=?";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, kind);
			pstmt.setInt(1, Integer.parseInt(kind));
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
