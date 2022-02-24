package com.groupc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.groupc.dto.AdminVO;
import com.groupc.dto.MemberVO;
import com.groupc.dto.NoticeVO;
import com.groupc.dto.ProductVO;
import com.groupc.dto.QnaVO;
import com.groupc.util.Dbm;
import com.groupc.util.Paging;

public class AdminDao {
	private AdminDao() {}
	private static AdminDao itc = new AdminDao();
	public static AdminDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AdminVO getWorker(String adminId) {
		AdminVO avo = null;
		String sql = "SELECT * FROM worker WHERE id=?";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				avo = new AdminVO();
				avo.setId( rs.getString("id") );
				avo.setPwd(rs.getString("pwd"));
				avo.setName(rs.getString("name"));
				avo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs);
		}
		return avo;
	}

	public ArrayList<Integer> getCnt() {
		ArrayList<Integer> cnt = new ArrayList<Integer>();
		String sql = "";
		con = Dbm.getConnection();
		try {
			// membercnt
			sql = "SELECT COUNT(*) AS membercnt FROM member WHERE useyn='y'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int i = rs.getInt("membercnt");
				cnt.add(0, i);
			}
			pstmt.close();
			
			// bookcnt
			sql = "SELECT COUNT(*) AS bookcnt FROM bookproduct WHERE useyn='y'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int i = rs.getInt("bookcnt");
				cnt.add(1, i);
			}
			pstmt.close();
			
			// ordercnt
			sql = "SELECT COUNT(*) AS ordercnt FROM orders";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int i = rs.getInt("ordercnt");
				cnt.add(2, i);
			}
			pstmt.close();

			// qnacnt
			sql = "SELECT COUNT(*) AS qnacnt FROM qna";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int i = rs.getInt("qnacnt");
				cnt.add(3, i);
			}
			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs);
		}
		
		return cnt;
	}

	public int getAdminCount(String tablename, String fieldname, String key) {
		int count = 0;
		String sql = "SELECT COUNT(*) AS count FROM " + tablename + " WHERE " + 
		fieldname + " LIKE '%'||?||'%' ";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return count;
	}

	public ArrayList<ProductVO> getProductList(Paging paging, String key) {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		
		String sql = "SELECT * FROM (" + " SELECT * FROM ( "
						+ " SELECT rownum AS rn, b.* FROM ("
						+ " (SELECT * FROM bookproduct WHERE bname LIKE '%'||?||'%' ORDER BY bseq DESC) b) "
						+ " ) WHERE rn >= ? " + " ) WHERE rn <= ? ";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setBseq(rs.getInt("bseq"));
				pvo.setBname(rs.getString("bname"));
				pvo.setWriter(rs.getString("writer"));
				pvo.setByear(rs.getString("byear"));
				pvo.setKind(rs.getString("kind"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setPublisher(rs.getString("publisher"));
				pvo.setGenre(rs.getString("genre"));
				pvo.setContent(rs.getString("content"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
				productList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		
		
		return productList;
	}

	public void updateProduct(ProductVO pvo) {
		String sql = "UPDATE bookproduct SET bname=?, writer=?, byear=?, kind=?, "
				+ "price=?, publisher=?, genre=?, content=?, useyn=?, bestyn=?, image=? "
				+ "WHERE bseq=?";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getBname());
			pstmt.setString(2, pvo.getWriter());
			pstmt.setString(3, pvo.getByear());
			pstmt.setString(4, pvo.getKind());
			pstmt.setInt(5, pvo.getPrice());
			pstmt.setString(6, pvo.getPublisher());
			pstmt.setString(7, pvo.getGenre());
			pstmt.setString(8, pvo.getContent());
			pstmt.setString(9, pvo.getUseyn());
			pstmt.setString(10, pvo.getBestyn());
			pstmt.setString(11, pvo.getImage());
			pstmt.setInt(12, pvo.getBseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
	}

	public void insertProduct(ProductVO pvo) {
		String sql = "INSERT INTO bookproduct(bseq, bname, writer, publisher, byear, price, content, kind, genre, image, bestyn, useyn) "
				+ " VALUES(bookproduct_seq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getBname());
			pstmt.setString(2, pvo.getWriter());
			pstmt.setString(3, pvo.getPublisher());
			pstmt.setString(4, pvo.getByear());
			pstmt.setInt(5, pvo.getPrice());
			pstmt.setString(6, pvo.getContent());
			pstmt.setString(7, pvo.getKind());
			pstmt.setString(8, pvo.getGenre());
			pstmt.setString(9, pvo.getImage());
			pstmt.setString(10, pvo.getBestyn());
			pstmt.setString(11, pvo.getUseyn());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
	}

	public void deleteProduct(int bseq) {
		String sql = "DELETE FROM bookproduct WHERE bseq =?";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		
	}
	// 220222
	public ArrayList<ProductVO> getBestProductList(Paging paging) {
		ArrayList<ProductVO> bestproductList = new ArrayList<ProductVO>();
		
		String sql = "SELECT * FROM (" + " SELECT * FROM ( "
						+ " SELECT rownum AS rn, b.* FROM ("
						+ " (SELECT * FROM bookproduct WHERE bestyn='y' ORDER BY bseq DESC) b) "
						+ " ) WHERE rn >= ? " + " ) WHERE rn <= ? ";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setBseq(rs.getInt("bseq"));
				pvo.setBname(rs.getString("bname"));
				pvo.setWriter(rs.getString("writer"));
				pvo.setByear(rs.getString("byear"));
				pvo.setKind(rs.getString("kind"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setPublisher(rs.getString("publisher"));
				pvo.setGenre(rs.getString("genre"));
				pvo.setContent(rs.getString("content"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
				bestproductList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		
		return bestproductList;
	}
	
	public void updateProductBestyn(int bseq, String bestyn) {
		String sql = "";
		
		con = Dbm.getConnection();
		try {
			if(bestyn.equals("y")) {
				sql = "UPDATE bookproduct SET bestyn='n' WHERE bseq=?";
			}else {
				sql = "UPDATE bookproduct SET bestyn='y' WHERE bseq=?";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		
	}
	
	
	public int getAllCountForQna(String key) {
		int count=0;
		String sql = "select count(*) as cnt from qna where subject like '%'||?||'%' or content like '%'||?||'%' ";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, key);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt("cnt");
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs);
		}
		return count;
	}

	public ArrayList<QnaVO> listQna(Paging paging, String key) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = " select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, q.* from "
				+ " ((select * from qna where subject like '%'||?||'%' or content like '%'||?||'%' order by qseq desc) q) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  key);
			pstmt.setString(2,  key);
			pstmt.setInt(3,  paging.getStartNum()) ;
			pstmt.setInt(4,  paging.getEndNum() );
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				list.add(qvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {  Dbm.close(con, pstmt, rs);   }
		return list;
	}
	
	public ArrayList<NoticeVO> listNotice(Paging paging, String key) {
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		String sql = " select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, n.* from "
				+ " ((select * from notice where subject like '%'||?||'%' or content like '%'||?||'%' order by nseq desc) n) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  key);
			pstmt.setString(2,  key);
			pstmt.setInt(3,  paging.getStartNum()) ;
			pstmt.setInt(4,  paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO nvo = new NoticeVO();
				nvo.setNseq(rs.getInt("nseq"));
				nvo.setSubject(rs.getString("subject"));
				nvo.setContent(rs.getString("content"));
				nvo.setIndate(rs.getTimestamp("indate"));
				nvo.setUseyn(rs.getString("useyn"));
				list.add(nvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs);  
		}
		return list;
	}
	
	public void insertNotice(NoticeVO nvo) {
		String sql = "insert into notice( nseq, subject, content) values(notice_seq.nextVal, ? , ?)";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nvo.getSubject());
			pstmt.setString(2, nvo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs);  
		}
		
	}

	public ArrayList<MemberVO> getMemberList(Paging paging, String key) {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		
		String sql = "SELECT * FROM (" + "SELECT * FROM ("
				+ " SELECT rownum AS rn, m.* FROM( "
				+ " (SELECT * FROM member WHERE id LIKE '%'||?||'%')m) "
				+ " ) WHERE rn >= ?" + " ) WHERE rn <= ?";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setZip_num(rs.getString("zip_num"));
				mvo.setAddress(rs.getString("address"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setUseyn(rs.getString("useyn"));
				mvo.setIndate(rs.getTimestamp("indate"));
				mvo.setGender(rs.getString("gender"));
				mvo.setPoint(rs.getInt("point"));
				memberList.add(mvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		
		return memberList;
	}

	public ArrayList<MemberVO> getMemberUseNList(Paging paging, String key) {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		
		String sql = "SELECT * FROM (" + "SELECT * FROM ("
				+ " SELECT rownum AS rn, m.* FROM( "
				+ " (SELECT * FROM member WHERE useyn='n' AND id LIKE '%'||?||'%')m) "
				+ " ) WHERE rn >= ?" + " ) WHERE rn <= ?";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setZip_num(rs.getString("zip_num"));
				mvo.setAddress(rs.getString("address"));
				mvo.setUseyn(rs.getString("useyn"));
				mvo.setIndate(rs.getTimestamp("indate"));
				mvo.setGender(rs.getString("gender"));
				mvo.setPoint(rs.getInt("point"));
				memberList.add(mvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		
		return memberList;
	}

	public void updateMemberUseyn(String id, String useyn) {
		String sql = "";
		
		con = Dbm.getConnection();
		try {
			if(useyn.equals("y")) {
				sql = "UPDATE member SET useyn='n' WHERE id=?";
			}else {
				sql = "UPDATE member SET useyn='y' WHERE id=?";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		
	}

	public void updateMember(MemberVO mvo) {
		String sql = "UPDATE member SET name=?, pwd=?, email=?, phone=?,"
				+ " zip_num=?, address=?, useyn=?, gender=?, point=? WHERE id=?";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getName());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getEmail());
			pstmt.setString(4, mvo.getPhone());
			pstmt.setString(5, mvo.getZip_num());
			pstmt.setString(6, mvo.getAddress());
			pstmt.setString(7, mvo.getUseyn());
			pstmt.setString(8, mvo.getGender());
			pstmt.setInt(9, mvo.getPoint());
			pstmt.setString(10, mvo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
	}

	
}
