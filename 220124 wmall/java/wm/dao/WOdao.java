package wm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wm.dto.WPVO;
import wm.util.Db;

public class WOdao {
	private WOdao() {}
	private static WOdao itc = new WOdao();
	public static WOdao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int insertBNow(WPVO wpvo, String id, int quantity) {
		int oseq = 0;
		
		con = Db.getConnection();
		String sql = "";
		try {
			sql = "INSERT INTO worders(oseq, id) VALUES(wo_seq.nextVal, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			sql = "SELECT MAX(oseq) AS max_oseq FROM worders";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				oseq = rs.getInt("max_oseq");
			}
			pstmt.close();
			
			sql = "INSERT INTO wo_detail(odseq, oseq, pseq, quantity)"
					+ " VALUES(wo_d_seq.nextVal, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			pstmt.setInt(2, wpvo.getPseq());
			pstmt.setInt(3, quantity);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
		}finally {
			Db.close(con, pstmt, rs);
		}
		return oseq;
	}
	
	
}
