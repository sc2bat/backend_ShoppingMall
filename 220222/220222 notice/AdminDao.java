package com.groupc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.groupc.dto.AdminVO;
import com.groupc.dto.NoticeVO;
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

	public void updateQna(QnaVO qvo) {
		String sql = "update qna set reply=?, rep='2' where qseq=?";
		con = Dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getReply() );
			pstmt.setInt(2,  qvo.getQseq() );
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace(); 
		} finally { Dbm.close(con, pstmt, rs);  
		}
		
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

	
}
