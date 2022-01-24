package wm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wm.dto.WCVO;
import wm.util.Db;

public class WCdao {
	private WCdao() {}
	private static WCdao itc = new WCdao();
	public static WCdao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public ArrayList<WCVO> selectC(String id) {
		ArrayList<WCVO> clist = new ArrayList<WCVO>();
		String sql = "SELECT * FROM wc_view WHERE id=?";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				WCVO wcvo = new WCVO();
				wcvo.setCseq(rs.getInt("cseq"));
				wcvo.setId(rs.getString("id"));
				wcvo.setMname(rs.getString("mname"));
				wcvo.setPseq(rs.getInt("pseq"));
				wcvo.setPname(rs.getString("pname"));
				wcvo.setQuantity(rs.getInt("quantity"));
				wcvo.setPrice_s(rs.getInt("price_s"));
				wcvo.setResult(rs.getString("result"));
				wcvo.setIndate(rs.getTimestamp("indate"));
				clist.add(wcvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt, rs);
		}
		return clist;
	}


	public void insertC(WCVO wcvo) {
		String sql = "INSERT INTO wcart(cseq, id, pseq, quantity)"
				+ " VALUES(wc_seq.nextVal, ?, ?, ?)";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wcvo.getId());
			pstmt.setInt(2, wcvo.getPseq());
			pstmt.setInt(3, wcvo.getQuantity());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt, rs);
		}
	}
}
