package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenac.dto.AdminVO;
import com.ezenac.dto.MemberVO;
import com.ezenac.dto.OrderVO;
import com.ezenac.dto.ProductVO;
import com.ezenac.util.Dbman;
import com.ezenac.util.Paging;

public class AdminDao {
	private AdminDao() {	}
	private static AdminDao itc = new AdminDao();
	public static AdminDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public AdminVO workerCheck(String workId) {
		AdminVO avo = null;
		String sql = "SELECT * FROM worker WHERE id=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, workId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				avo = new AdminVO();
				avo.setId(rs.getString("id"));
				avo.setPwd(rs.getString("pwd"));
				avo.setName(rs.getString("name"));
				avo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
		return avo;
	}

/*
	public ArrayList<ProductVO> listProduct(Paging paging) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
//		String sql = "SELECT * FROM shopproduct ORDER BY pseq DESC";
		String sql = "SELECT * FROM ("
				+ "SELECT * FROM ("
				+ "SELECT rownum AS rn, p.* FROM ((SELECT * FROM shopproduct ORDER BY pseq DESC) p)"
				+ ") WHERE rn>=?"
				+ ") WHERE rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}*/
	public ArrayList<ProductVO> listProduct(Paging paging, String key) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
//		String sql = "SELECT * FROM shopproduct ORDER BY pseq DESC";
		String sql = "SELECT * FROM ("
				+ "SELECT * FROM ("
				+ "SELECT rownum AS rn, p.* FROM ((SELECT * FROM shopproduct "
				+ " WHERE name LIKE '%'||?||'%' "
				+ " ORDER BY pseq DESC) p)"
				+ ") WHERE rn>=?"
				+ ") WHERE rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}


//	public int getAllCount() {
//		int count = 0;
//		String sql = "SELECT COUNT(*) AS cnt FROM shopproduct";
//		con = Dbman.getConnection();
//		try {
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				count = rs.getInt("cnt");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			Dbman.close(con, pstmt, rs);
//		}
//		return count;
//	}
	public int getAllCount(String tablename, String fieldname, String key) {
		int count = 0;
		String sql = "SELECT COUNT(*) AS cnt FROM " + tablename + " WHERE " + fieldname + " LIKE '%'||?||'%'";
//		String sql = "SELECT COUNT(*) AS cnt FROM shopproduct WHERE name LIKE '%'||?||'%'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
		return count;
	}

	public void insertProduct(ProductVO pvo) {
		String sql = "INSERT INTO shopproduct(pseq, kind, name, price1, price2, price3, content, image)"
				+ " VALUES(product_seq.nextVal, ?, ?, ?, ?, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind());
			pstmt.setString(2, pvo.getName());
			pstmt.setInt(3, pvo.getPrice1());
			pstmt.setInt(4, pvo.getPrice2());
			pstmt.setInt(5, pvo.getPrice3());
			pstmt.setString(6, pvo.getContent());
			pstmt.setString(7, pvo.getImage());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
	}

	public void updateProduct(ProductVO pvo) {
		String sql = "UPDATE shopproduct SET kind=?, name=?, price1=?, price2=?, price3=?, "
				+ "content=?, bestyn=?, useyn=?, image=? WHERE pseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind());
			pstmt.setString(2, pvo.getName());
			pstmt.setInt(3, pvo.getPrice1());
			pstmt.setInt(4, pvo.getPrice2());
			pstmt.setInt(5, pvo.getPrice3());
			pstmt.setString(6, pvo.getContent());
			pstmt.setString(7, pvo.getBestyn());
			pstmt.setString(8, pvo.getUseyn());
			pstmt.setString(9, pvo.getImage());
			pstmt.setInt(10, pvo.getPseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
	}

	public ArrayList<OrderVO> listOrder(Paging paging, String key) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
//		String sql = "SELECT * FROM order_view ORDER BY result, odseq DESC";
		/*
		String sql = "SELECT * FROM ("
				+ "SELECT * FROM ("
				+ "SELECT rownum AS rn, m.* FROM ("
				+ "(SELECT * FROM order_view ORDER BY result, odseq DESC) m)"
				+ " ) WHERE rn>=?"
				+ " ) WHERE rn<=?";
		*/
		/* 속도가 느림
		 * String sql ="SELECT * FROM ("
				+ "SELECT rownum AS rn, m.* FROM ("
				+ "(SELECT * FROM order_view ORDER BY result, odseq DESC) m)"
				+ " ) WHERE rn>=? AND WHERE rn<=?";
		*/
		
		String sql = "SELECT * FROM ("
				+ "SELECT * FROM ("
				+ "SELECT rownum AS rn, m.* FROM ("
				+ "(SELECT * FROM order_view WHERE mname LIKE '%'||?||'%' ORDER BY result, odseq DESC) m)"
				+ " ) WHERE rn>=?"
				+ " ) WHERE rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, paging.getStartNum());
//			pstmt.setInt(2, paging.getEndNum());
			
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVO ovo = new OrderVO();
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setOseq(rs.getInt("oseq"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setId(rs.getString("id"));
				ovo.setMname(rs.getString("mname"));
				ovo.setZip_num(rs.getString("zip_num"));
				ovo.setAddress(rs.getString("address"));
				ovo.setPhone(rs.getString("phone"));
				ovo.setPseq(rs.getInt("pseq"));
				ovo.setPname(rs.getString("pname"));
				ovo.setPrice2(rs.getInt("price2"));
				ovo.setQuantity(rs.getInt("quantity"));
				ovo.setResult(rs.getString("result"));
				list.add(ovo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public void updateOrderResult(int odseq) {
		String sql = "UPDATE order_detail SET result='2' WHERE odseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, odseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
	}

	public ArrayList<MemberVO> listMember() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "SELECT * FROM shopmem";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}
	
}
