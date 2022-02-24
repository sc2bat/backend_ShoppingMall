package com.groupc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.groupc.dto.ProductVO;
import com.groupc.util.Dbm;
import com.groupc.util.Paging;

public class ProductDao {
	

	private ProductDao() {}
	private static ProductDao itc = new ProductDao();
	public static ProductDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// index.jsp 
	public ArrayList<ProductVO> getBestList() {
		ArrayList<ProductVO> bestList = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM best_pro_view";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setBseq(rs.getInt("bseq"));
				pvo.setBname(rs.getString("bname"));
				pvo.setImage(rs.getString("image"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setWriter(rs.getString("writer"));
				bestList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return bestList;
	}
	

	public ArrayList<ProductVO> getNewList() {
		ArrayList<ProductVO> newList = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM new_pro_view";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setBseq(rs.getInt("bseq"));
				pvo.setBname(rs.getString("bname"));
				pvo.setImage(rs.getString("image"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setWriter(rs.getString("writer"));
				newList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return newList;
	}
	
	// 추천도서 0214
	public ArrayList<ProductVO> getRecommandList() {
		ArrayList<ProductVO> recommandList = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM recommand_pro_view";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setBseq(rs.getInt("bseq"));
				pvo.setBname(rs.getString("bname"));
				pvo.setImage(rs.getString("image"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setWriter(rs.getString("writer"));
				recommandList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return recommandList;
	}

	// \product\bestProduct.jsp
	public ArrayList<ProductVO> getBestViewList() {
		ArrayList<ProductVO> bestviewList = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM bestviewList WHERE rn > 1";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
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
				bestviewList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return bestviewList;
	}
	
	public ArrayList<ProductVO> getBestViewOneList() {
		ArrayList<ProductVO> bestviewoneList = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM bestviewList WHERE rn = 1";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
				bestviewoneList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return bestviewoneList;
	}
	
	// \product\newProduct.jsp
	public ArrayList<ProductVO> getNewViewList() {
		ArrayList<ProductVO> newviewList = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM newviewList WHERE rn > 1";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
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
				newviewList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return newviewList;
	}
	
	
	public ArrayList<ProductVO> getNewViewOneList() {
		ArrayList<ProductVO> newviewoneList = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM newviewList WHERE rn = 1";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
				newviewoneList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return newviewoneList;
	}
	
	
	public ArrayList<ProductVO> getLocalList(Paging paging, String kind) {
		ArrayList<ProductVO> localviewList = new ArrayList<ProductVO>();
//		String sql = "SELECT * FROM localviewList";
		// paging
		String sql = "SELECT * FROM ("
				+ " SELECT * FROM ("
				+ " SELECT rownum AS rn, b.* FROM "
				+ " ((SELECT * FROM localviewList WHERE kind LIKE '%'||?||'%' ORDER BY bseq DESC) b)"
				+ " ) WHERE rn >= ? "
				+ " ) WHERE rn <= ? ";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, kind);
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
				localviewList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return localviewList;
	}

	public ArrayList<ProductVO> getGlobalList(Paging paging, String kind) {
		ArrayList<ProductVO> globalviewList = new ArrayList<ProductVO>();
//		String sql = "SELECT * FROM globalviewList";
		// paging
		String sql = "SELECT * FROM ("
				+ " SELECT * FROM ("
				+ " SELECT rownum AS rn, b.* FROM "
				+ " ((SELECT * FROM globalviewList WHERE kind LIKE '%'||?||'%' ORDER BY bseq DESC) b)"
				+ " ) WHERE rn >= ? "
				+ " ) WHERE rn <= ? ";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, kind);
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
				globalviewList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return globalviewList;
	}


	public ArrayList<ProductVO> getViewList(Paging paging, String genre) {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql = "";
		// paging 220218
		con = Dbm.getConnection();
		try {
			sql = "SELECT * FROM ("
					+ " SELECT * FROM ("
					+ " SELECT rownum AS rn, b.* FROM "
					+ " ((SELECT * FROM bookproduct WHERE genre LIKE '%'||?||'%' ORDER BY bseq DESC) b)"
					+ " ) WHERE rn >= ? "
					+ " ) WHERE rn <= ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, genre);
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


	public ProductVO getProduct(int bseq) {
		ProductVO pvo = new ProductVO();
		String sql = "select * from bookproduct where bseq=?";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pvo.setBseq(bseq);
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
				pvo.setBestyn(rs.getString("Bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
		return pvo;
	}
	

	public ArrayList<ProductVO> getSearchViewList(String option, String str, Paging paging) {
		ArrayList<ProductVO> searchViewList = new ArrayList<ProductVO>();
		String sql = "";
		con = Dbm.getConnection();
		try {
			if(option.equals("통합검색")) {
				sql = "SELECT * FROM ("
						+ " SELECT * FROM ("
						+ " SELECT rownum AS rn, b.* FROM "
						+ " ((SELECT * FROM bookproduct WHERE bname LIKE '%'||?||'%' ORDER BY bseq DESC) b)"
						+ " ) WHERE rn >= ? "
						+ " ) WHERE rn <= ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, str);
				pstmt.setInt(2, paging.getStartNum());
				pstmt.setInt(3, paging.getEndNum());
			}else {
				sql = "SELECT * FROM ("
						+ " SELECT * FROM ("
						+ " SELECT rownum AS rn, b.* FROM "
						+ " ((SELECT * FROM bookproduct WHERE bname LIKE '%'||?||'%' AND kind=? ORDER BY bseq DESC) b)"
						+ " ) WHERE rn >= ? "
						+ " ) WHERE rn <= ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, str);
				if(option.equals("국내도서")) {
					pstmt.setString(2, "l");
				}else {
					pstmt.setString(2, "g");
				}
				pstmt.setInt(3, paging.getStartNum());
				pstmt.setInt(4, paging.getEndNum());
			}
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
				searchViewList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return searchViewList;
	}
	
	public int getProductCount(String kind, String genre) {
		int count = 0;
		String sql = "SELECT COUNT(*) AS cnt FROM bookproduct WHERE "
				+ "kind LIKE '%'||?||'%' AND genre LIKE '%'||?||'%'";
			
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, kind);
			pstmt.setString(2, genre);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return count;
	}
	
	public int getSearchingCount(String str, String option) {
		int count = 0;
		String sql = "SELECT COUNT(*) AS cnt FROM bookproduct WHERE "
				+ "bname LIKE '%'||?||'%' AND kind LIKE '%'||?||'%'";
			
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, str);
			if(option.equals("통합검색")) {option = "";
			}else if(option.equals("국내도서")) {option = "l";
			}else if(option.equals("외국도서")) {option = "g";
			}else {option = "";}
			pstmt.setString(2, option);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		return count;
	}

	

}
