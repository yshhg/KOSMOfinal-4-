package front.notices.sql;

public abstract class NoticeSqlMap {
	
public static String getMaxChabunQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  /*+ INDEX_DESC(A SYS_C0011201) */ 			\n");
		sb.append("         NVL(MAX(SUBSTR(A.NNUM, -4)), 0) + 1 MAXNUM	\n");
		sb.append(" FROM    NOTICE A 								\n");	  

		return sb.toString();
	}

	public static String getNoticeSelectAllQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 									\n");
		sb.append("      A.NNUM 			NNUM 			\n");
		sb.append("		,A.NSUBJECT  		NSUBJECT 		\n");
		sb.append("		,A.NMEMO  			NMEMO 			\n");	  
		sb.append("		,A.NPHOTO  			NPHOTO 			\n");	  
	    sb.append("		,A.DELETEYN 		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.NINSERTDATE, 'YYYY-MM-DD')  NINSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.NUPDATEDATE, 'YYYY-MM-DD')  NUPDATEDATE	\n");	    
	    sb.append("	FROM 								\n");
	    sb.append("		 NOTICE A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	ORDER BY 1 DESC						\n");

	    return sb.toString();
	}
	
	public static String getNoticeSelectQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 									\n");
		sb.append("      A.NNUM 			NNUM 			\n");
		sb.append("		,A.NSUBJECT  		NSUBJECT 		\n");
		sb.append("		,A.NMEMO  			NMEMO 			\n");	  
		sb.append("		,A.NPHOTO  			NPHOTO 			\n");	  
	    sb.append("		,A.DELETEYN 		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.NINSERTDATE, 'YYYY-MM-DD')  NINSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.NUPDATEDATE, 'YYYY-MM-DD')  NUPDATEDATE	\n");	    
	    sb.append("	FROM 								\n");
	    sb.append("		 NOTICE A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.NNUM   = ?					\n");// placeholder 1

	    return sb.toString();
	}
	public static String getNoticeInsertQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("		MVC_NOTICE 				    	\n");
		sb.append("		          (			    		\n");
		sb.append("      			 NNUM 				\n"); // COLUMN 1
		sb.append("					,NSUBJECT 			\n"); // COLUMN 2
		sb.append("					,NMEMO 				\n"); // COLUMN 3
	    sb.append("					,NPHOTO 			\n"); // COLUMN 4	    
	    sb.append("					,DELETEYN			\n"); // COLUMN 5
	    sb.append("					,NINSERTDATE			\n"); // COLUMN 6
	    sb.append("					,NUPDATEDATE			\n"); // COLUMN 7	 	  
		sb.append("			      )						\n");
		sb.append("	       VALUES   					\n");
		sb.append("	       		 (  					\n");
		sb.append("     				 ? 				\n"); // placeholder 1
		sb.append("						,? 				\n"); // placeholder 2
	    sb.append("						,?   			\n"); // placeholder 3
	    sb.append("						,?   			\n"); // placeholder 4	   
	    sb.append("						,'Y'			\n"); // placeholder 5
	    sb.append("						,SYSDATE 		\n"); // placeholder 6
	    sb.append("						,SYSDATE 		\n"); // placeholder 7	
		sb.append("	              )						\n");		
		
		return sb.toString();
	}
	
	public static String getNoticeUpdateQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   	 NOTICE 			    \n");	
		sb.append("	SET  								\n");		
		sb.append("			 NSUBJECT 		= ?			\n"); // placeholder 1	  
		sb.append("			,NMEMO   		= ?			\n"); // placeholder 2			
	    sb.append("		  	,NUPDATEDATE 	= SYSDATE	\n");
		sb.append("	WHERE  	 NNUM 			= ?			\n"); // placeholder 3	    
		sb.append("	AND    	 DELETEYN 		= 'Y'  		\n");		
					
		return sb.toString();

	}
	public static String detNoticeDeleteQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  MVC_NOTICE						\n");	
		sb.append("		   MVC_MEMBER 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   DELETEYN 	= 'N'			\n");	    	   
	    sb.append("		  ,NUPDATEDATE 	= SYSDATE		\n");
		sb.append("	WHERE  NNUM 		= ?				\n"); // placeholder 1    
		sb.append("	AND    DELETEYN 	= 'Y'  			\n");		
					
		return sb.toString();

	}	
}



