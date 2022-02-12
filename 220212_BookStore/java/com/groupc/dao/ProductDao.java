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
				pvo.setByear(rs.getInt("byear"));
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
				pvo.setByear(rs.getInt("byear"));
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
				pvo.setByear(rs.getInt("byear"));
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
				pvo.setByear(rs.getInt("byear"));
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
	
	
	public ArrayList<ProductVO> getLocalList() {
		ArrayList<ProductVO> localviewList = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM localviewList";
		// paging
		// String sql = "SELECT * FROM localviewList";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setBseq(rs.getInt("bseq"));
				pvo.setBname(rs.getString("bname"));
				pvo.setWriter(rs.getString("writer"));
				pvo.setByear(rs.getInt("byear"));
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

	public ArrayList<ProductVO> getGlobalList() {
		ArrayList<ProductVO> globalviewList = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM globalviewList";
		// paging
		// String sql = "SELECT * FROM globalviewList";
		
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setBseq(rs.getInt("bseq"));
				pvo.setBname(rs.getString("bname"));
				pvo.setWriter(rs.getString("writer"));
				pvo.setByear(rs.getInt("byear"));
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


	public ArrayList<ProductVO> getViewList(String genre) {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql = "";
		// paging
		con = Dbm.getConnection();
		try {
			if(genre.equals("all")) {
				sql = "SELECT * FROM bookproduct ORDER BY bseq DESC";
				pstmt = con.prepareStatement(sql);
			}else {
				sql = "SELECT * FROM bookproduct WHERE genre = ? ORDER BY bseq DESC";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, genre);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setBseq(rs.getInt("bseq"));
				pvo.setBname(rs.getString("bname"));
				pvo.setWriter(rs.getString("writer"));
				pvo.setByear(rs.getInt("byear"));
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


	

	

	

}
