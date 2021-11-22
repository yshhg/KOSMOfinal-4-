package front.notices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.notice.sql.NoticeSqlMap;
import a.b.c.com.notice.vo.NoticeVO;

public class NoticedaoImpl implements Noticedao {

	@Override
	public ArrayList<NoticeVO> noticeSelectAll() {
		// TODO Auto-generated method stub
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<NoticeVO> aList = null;
		
		try {
			
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeSelectAllQuery());
			
						
			
			rsRs = pstmt.executeQuery();			
			
			if (rsRs !=null) {
				
				aList = new ArrayList<NoticeVO>();
				
				while (rsRs.next()) {
					
					NoticeVO _nvo = new NoticeVO();
					
					_nvo.setNnum(rsRs.getString(1)); 
					_nvo.setNsubject(rsRs.getString(2)); 
					_nvo.setNmemo(rsRs.getString(3));				
					_nvo.setNphoto(rsRs.getString(4));									
					_nvo.setDeleteyn(rsRs.getString(5));
					_nvo.setnInsertdate(rsRs.getString(6));
					_nvo.setnUpdatedate(rsRs.getString(7));
					
					aList.add(_nvo);
					NoticeVO.printNoticeVO(_nvo);
				}				
			}
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;	
	}

	@Override
	public ArrayList<NoticeVO> noticeSelect(NoticeVO nvo) {
		// TODO Auto-generated method stub
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<NoticeVO> aList = null;
		
		try {
			
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeSelectQuery());			
						
			
			pstmt.clearParameters();
			
			pstmt.setString(1, nvo.getNnum());
			rsRs = pstmt.executeQuery();			
			
			if (rsRs !=null) {
				
				aList = new ArrayList<NoticeVO>();
				
				while (rsRs.next()) {
					
					NoticeVO _nvo = new NoticeVO();
					
					_nvo.setNnum(rsRs.getString(1)); 
					_nvo.setNsubject(rsRs.getString(2)); 
					_nvo.setNmemo(rsRs.getString(3));				
					_nvo.setNphoto(rsRs.getString(4));									
					_nvo.setDeleteyn(rsRs.getString(5));
					_nvo.setnInsertdate(rsRs.getString(6));
					_nvo.setnUpdatedate(rsRs.getString(7));
					
					aList.add(_nvo);
					NoticeVO.printNoticeVO(_nvo);
				}				
			}
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;	

	}

	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub

		NoticeVO.printlnNoticeVO(nvo);
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = ConnProperty.getConnection();
			
			
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeInsertQuery());
			
  			
			// 파라미터 클리어 꼭 하기 
			pstmt.clearParameters();			
			pstmt.setString(1, nvo.getNnum()); 
			pstmt.setString(2, nvo.getNsubject()); 
			pstmt.setString(3, nvo.getNmemo());   
			pstmt.setString(4, nvo.getNphoto());

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();					
		
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return nCnt;
	}

	@Override
	public int noticeUpdate(NoticeVO nvo) {
		// TODO Auto-generated method stub
		
		NoticeVO.printlnNoticeVO(nvo);
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = ConnProperty.getConnection();
			
			
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeUpdateQuery());
			
  			
			// 파라미터 클리어 꼭 하기 
			pstmt.clearParameters();						
			pstmt.setString(1, nvo.getNsubject()); 
			pstmt.setString(2, nvo.getNmemo());   		
			pstmt.setString(3, nvo.getNnum()); 

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();					
			
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return nCnt;
	}

	@Override
	public int noticeDelete(NoticeVO nvo) {
		// TODO Auto-generated method stub
		
		NoticeVO.printlnNoticeVO(nvo);
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			
			conn = ConnProperty.getConnection();
			
			
			pstmt = conn.prepareStatement(NoticeSqlMap.detNoticeDeleteQuery());
			
  			
			// 파라미터 클리어 꼭 하기 
			pstmt.clearParameters();									
			pstmt.setString(1, nvo.getNnum()); 

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();					
			
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return nCnt;
	}

}
