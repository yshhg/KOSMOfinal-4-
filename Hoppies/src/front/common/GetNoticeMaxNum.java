package front.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import front.notice.common.ConnProperty;
import front.notice.sql.NoticeSqlMap;



public abstract class GetNoticeMaxNum {

	
	public static String getMaxNum(){
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getMaxChabunQuery());
			NoticeSqlMap.getMaxChabunQuery();
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				while (rsRs.next()) {
					maxNum = rsRs.getString("MAXNUM");									
				}
			}else {
				
			}
			
		
					
 			
			ConnProperty.conClose(conn, pstmt, rsRs);			
		}catch(Exception e) {
			
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return maxNum;
	}

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
