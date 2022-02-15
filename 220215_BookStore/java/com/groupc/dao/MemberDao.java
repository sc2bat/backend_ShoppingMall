package com.groupc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.groupc.dto.AddressVO;
import com.groupc.dto.MemberVO;
import com.groupc.util.Dbm;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MemberVO getMember(String id) {
	 MemberVO mvo = null;
		String sql = "select*from member where id=?";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				mvo = new MemberVO();
				mvo.setId( rs.getString("id") );
				mvo.setPwd(rs.getString("pwd"));
		        mvo.setName(rs.getString("name"));
		        mvo.setEmail(rs.getString("email"));
		        mvo.setZip_num(rs.getString("zip_num"));
		        mvo.setAddress(rs.getString("address"));
		        mvo.setPhone(rs.getString("phone"));
		        mvo.setUseyn(rs.getString("useyn"));
		        mvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs);
		}
		return mvo;
	}
	
	public ArrayList<AddressVO> selectAddress(String dong) {
		ArrayList<AddressVO> list = new ArrayList<AddressVO>();
		String sql = "select * from address where dong like '%'||?||'%'";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AddressVO avo = new AddressVO();
				avo.setZip_num(rs.getString("zip_num"));
				avo.setSido(rs.getString("sido"));
				avo.setGugun(rs.getString("gugun"));
				avo.setDong(rs.getString("dong"));
				avo.setZip_code(rs.getString("zip_code"));
				avo.setBunji(rs.getString("bunji"));
				list.add(avo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs);
		}
		return list;
	}


	public int insertMember(MemberVO mvo) {
		int result = 0;
		String sql = "insert into member(id, pwd, name, email, zip_num, address, phone, gender) "
				+ " values(?, ?, ?, ?, ?, ?, ?, ?)";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getEmail());
			pstmt.setString(5, mvo.getZip_num());
			pstmt.setString(6, mvo.getAddress());
			pstmt.setString(7, mvo.getPhone());
			pstmt.setString(8, mvo.getGender());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return result;
	}
	
	public void updateMember(MemberVO mvo) {
		String sql = "Update member set pwd=?, name=?, zip_num=?, address=?, "
				+ "email=?, phone=? where id = ?";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getName());
			pstmt.setString(3, mvo.getZip_num());
			pstmt.setString(4, mvo.getAddress());
			pstmt.setString(5, mvo.getEmail());
			pstmt.setString(6, mvo.getPhone());
			pstmt.setString(7, mvo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs);
		}
	}
	
	public MemberVO checkMemberId(String name, String phone, String email) {
		MemberVO mvo = null;
		String sql = "select id from member where (name=? and phone=?) or (name=? and email=?)";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setId( rs.getString("id") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			Dbm.close(con, pstmt, rs);
		}
		return mvo;
	}


	public MemberVO checkMemberPwd(String id, String phone, String email) {
		MemberVO mvo = null;
		String sql = "select pwd from member where (id=? and phone=?) or (id=? and email=?)";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, phone);
			pstmt.setString(3, id);
			pstmt.setString(4, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setPwd( rs.getString("pwd") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			Dbm.close(con, pstmt, rs);
		}
		return mvo;
	}
}
