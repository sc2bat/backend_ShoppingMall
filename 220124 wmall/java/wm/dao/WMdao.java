package wm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wm.dto.WAVO;
import wm.dto.WMVO;
import wm.util.Db;

public class WMdao {
	private WMdao() {}
	private static WMdao itc = new WMdao();
	public static WMdao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public WMVO getMember(String id) {
		WMVO wmvo = null;
		String sql = "SELECT * FROM wmem WHERE id=?";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				wmvo = new WMVO();
				wmvo.setId(rs.getString("id"));
				wmvo.setPwd(rs.getString("pwd"));
				wmvo.setName(rs.getString("name"));
				wmvo.setEmail(rs.getString("email"));
				wmvo.setZip_num(rs.getString("zip_num"));
				wmvo.setAddress(rs.getString("address"));
				wmvo.setPhone(rs.getString("phone"));
				wmvo.setUseyn(rs.getString("useyn"));
				wmvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt, rs);
		}
		return wmvo;
	}

	public int insertWM(WMVO wmvo) {
		// id pwd name email zip_num address phone
		int result = 0;
		String sql = "INSERT INTO wmem(id, pwd, name, email, zip_num, address, phone)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wmvo.getId());
			pstmt.setString(2, wmvo.getPwd());
			pstmt.setString(3, wmvo.getName());
			pstmt.setString(4, wmvo.getEmail());
			pstmt.setString(5, wmvo.getZip_num());
			pstmt.setString(6, wmvo.getAddress());
			pstmt.setString(7, wmvo.getPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt, rs);
		}
		
		return result;
	}

	// zip_num sido gugun dong zip_code bunji
	public ArrayList<WAVO> selectA(String dong) {
		ArrayList<WAVO> alist = new ArrayList<WAVO>();
		String sql = "SELECT * FROM address WHERE dong LIKE '%'||?||'%'";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				WAVO wavo = new WAVO();
				wavo.setZip_num(rs.getString("zip_num"));
				wavo.setSido(rs.getString("sido"));
				wavo.setGugun(rs.getString("gugun"));
				wavo.setDong(rs.getString("dong"));
				wavo.setZip_code(rs.getString("zip_code"));
				wavo.setBunji(rs.getString("bunji"));
				alist.add(wavo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt, rs);
		}
		
		return alist;
	}

	public void updateWM(WMVO wmvo) {
		String sql = "UPDATE wmem SET pwd=?, name=?, email=?, zip_num=?, address=?, phone=? WHERE id=?";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wmvo.getPwd());
			pstmt.setString(2, wmvo.getName());
			pstmt.setString(3, wmvo.getEmail());
			pstmt.setString(4, wmvo.getZip_num());
			pstmt.setString(5, wmvo.getAddress());
			pstmt.setString(6, wmvo.getPhone());
			pstmt.setString(7, wmvo.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt, rs);
		}
		
	}
	
	
}
