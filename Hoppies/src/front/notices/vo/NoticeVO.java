package front.notices.vo;

public class NoticeVO {
	
	private String nnum;
	private String nsubject;
	private String nmemo;
	private String nphoto;
	private String deleteyn;
	private String ninsertdate;
	private String nupdatedate;
	
	public NoticeVO() {
		
	}
	
	public NoticeVO(String nnum, String nsubject, String nmemo,
			String nphoto, String deleteyn, String insertdate,
			String updatedate) {
		
	}
	
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

	public String getPageSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGroupSize() {
		// TODO Auto-generated method stub
		return null;
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
	}