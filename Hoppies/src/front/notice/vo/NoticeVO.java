package front.notice.vo;

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
		}
	public static void printlnNoticeVO(NoticeVO nvo) {
		
		}
	}
	
	