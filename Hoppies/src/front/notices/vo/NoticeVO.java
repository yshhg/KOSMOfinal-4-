package front.notices.vo;

public class NoticeVO {
	//테이블
	private String nnum;
	private String nsubject;
	private String nmemo;
	private String nphoto;
	private String deleteyn;
	private String ninsertdate;
	private String nupdatedate;
	
	// 검색
	private String searchType;	// 말머리
	private String keyword;		// 검색어
	
	//페이징
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;		// 전체 게시글 개수
	
	
	
	// 기본 생성자
	public NoticeVO() {
		
	}
	
	public NoticeVO(String nnum, String nsubject, String nmemo,
			String nphoto, String deleteyn, String insertdate,
			String updatedate,String searchType, String keyword,
			String pageSize, String groupSize, String curPage, String totalCount // 페이징
			
			) {
		this.nnum = nnum;
		
		this.nsubject = nsubject;
		this.nmemo = nmemo;
		
		
		this.ninsertdate = insertdate;
		
		this.nupdatedate = updatedate;
		
		this.nupdatedate = updatedate;	
		//검색
		this.searchType = searchType;
		this.keyword = keyword;
		
		// 페이징
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}
	
	
	// 게터
	public String getNnum() {
		return nnum;
	}
	public String getNsubject() {
		return nsubject;
	}
	public String getNmemo() {
		return nmemo;
	}
	public String getNphoto() {
		return nphoto;
	}
	public String getDeleteyn() {
		return deleteyn;
	}
	public String getnInsertdate() {
		return ninsertdate;
	}
	public String getnUpdatedate() {
		return nupdatedate;
	}
	public String getSearchType() {
		return searchType;
	}

	public String getKeyword() {
		return keyword;
	}
	public String getPageSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGroupSize() {
		// TODO Auto-generated method stub
		return null;
	}

		
	
	
	
	// 세터
	public void setNnum(String nnum) {
		this.nnum = nnum;
	}
	public void setNsubject(String nsubject) {
		this.nsubject = nsubject;
	}
	public void setNmemo(String nmemo) {
		this.nmemo = nmemo;
	}
	public void setNphoto(String nphoto) {
		this.nphoto = nphoto;
	}
	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}
	public void setnInsertdate(String insertdate) {
		this.ninsertdate = insertdate;
	}
	public void setnUpdatedate(String updatedate) {
		this.nupdatedate = updatedate;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCurPage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTotalCount() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPageSize(String valueOf) {
		// TODO Auto-generated method stub
		
	}

	public void setGroupSize(String valueOf) {
		// TODO Auto-generated method stub
		
	}

	public void setCurPage(String valueOf) {
		// TODO Auto-generated method stub
		
	}

	public void setTotalCount(String valueOf) {
		// TODO Auto-generated method stub
		
	}	
	
	
	
	public static void printNoticeVO(NoticeVO nvo) {
		System.out.print(nvo.getNnum() 			+ ", ");
		System.out.print(nvo.getNsubject() 		+ ", ");
		System.out.print(nvo.getNmemo()			+ ", ");
		System.out.print(nvo.getNphoto() 		+ ", ");					
		System.out.print(nvo.getDeleteyn() 		+ ", ");
		System.out.print(nvo.getnInsertdate() 	+ ", ");
		System.out.println(nvo.getnUpdatedate());
		}
	public static void printlnNoticeVO(NoticeVO nvo) {
		
		System.out.println(nvo.getNnum());
		System.out.println( nvo.getNsubject());
		System.out.println( nvo.getNmemo());		
		System.out.println( nvo.getNphoto());					
		System.out.println( nvo.getDeleteyn());
		System.out.println(nvo.getnInsertdate());
		System.out.println(nvo.getnUpdatedate());
	}

	
	// vo 출력
		public static void printVO(NoticeVO nvo) {
			
			// 로그인시 바인딩된 데이터 출력  
			System.out.println("\n===========NoticeVO 변수 바인딩 현황=============\n");
			System.out.println("입력된 제목 >>> : " + nvo.getNsubject());
			System.out.println("입력된 내용 >>> : " + nvo.getNmemo());
			System.out.println("\n");
			System.out.println("\n============================================\n");

		}
	}