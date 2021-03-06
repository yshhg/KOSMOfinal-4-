package front.mem.vo;

import org.apache.log4j.Logger;

import front.mem.controller.MemberController;

public class MemberVO {
	private static Logger logger = Logger.getLogger(MemberVO.class);
			
	private String mnum;
	private String mname;
	private String mid;
	private String mpw;
	private String madmin;
	private String mhobby_1;
	private String mhobby_2;
	private String mhobby_3;
	private String marea;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	private String tempauthmemail;
	private String tempauthnum;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String mnum, String mid, String mpw,String mname,
						  String madmin, String mhobby_1, String mhobby_2,
						  String mhobby_3, String marea, String deleteyn,
						  String insertdate, String updatedate, String tempauthmemail,
						  String tempauthnum
						  ) {
		this.mnum = mnum;
		this.mname = mname;
		this.mid = mid;
		this.mpw = mpw;
		this.madmin = madmin;
		this.mhobby_1 = mhobby_1;
		this.mhobby_2 = mhobby_2;
		this.mhobby_3 = mhobby_3;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}

	
	public String getMnum() {
		return mnum;
	}
	
	public String getMname() {
		return mname;
	}

	public String getMid() {
		return mid;
	}

	public String getMpw() {
		return mpw;
	}

	public String getMadmin() {
		return madmin;
	}

	public String getMhobby_1() {
		return mhobby_1;
	}

	public String getMhobby_2() {
		return mhobby_2;
	}

	public String getMhobby_3() {
		return mhobby_3;
	}

	public String getMarea() {
		return marea;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public String getTempauthmemail() {
		return tempauthmemail;
	}

	public String getTempauthnum() {
		return tempauthnum;
	}
	
	//setter
	

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}
	
	public void setMname(String mname) {
		this.mnum = mname;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public void setMadmin(String madmin) {
		this.madmin = madmin;
	}

	public void setMhobby_1(String mhobby_1) {
		this.mhobby_1 = mhobby_1;
	}

	public void setMhobby_2(String mhobby_2) {
		this.mhobby_2 = mhobby_2;
	}

	public void setMhobby_3(String mhobby_3) {
		this.mhobby_3 = mhobby_3;
	}

	public void setMarea(String marea) {
		this.marea = marea;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public void setTempauthmemail(String tempauthmemail) {
		this.tempauthmemail = tempauthmemail;
	}

	public void setTempauthnum(String tempauthnum) {
		this.tempauthnum = tempauthnum;
	}
	
	// ???????????? ??????
	public static void printVO(MemberVO mvo) {
		logger.info("memberVO ????????? ?????? : >>>");
		
		logger.info("???????????? >>> : " + mvo.getMnum());
		logger.info("???????????? >>> : " + mvo.getMname());
		logger.info("??????????????? >>> : " + mvo.getMid());
		logger.info("?????????????????? >>> : " + mvo.getMpw());
		logger.info("????????? ?????? >>> : " + mvo.getMadmin());
		logger.info("?????? ??????_1 >>> : " + mvo.getMhobby_1());
		logger.info("?????? ??????_2 >>> : " + mvo.getMhobby_2());
		logger.info("?????? ??????_3 >>> : " + mvo.getMhobby_3());
		logger.info("?????? ?????? >>> : " + mvo.getMarea());
		logger.info("???????????? : " + mvo.getDeleteyn());
		logger.info("????????? >>> : " + mvo.getInsertdate());
		logger.info("????????? >>> : " + mvo.getUpdatedate());
		
		logger.info("???????????????  ????????? >>> : " + mvo.getTempauthmemail());
		logger.info("???????????????  ???????????? >>> : " + mvo.getTempauthnum());
		
		logger.info("SpringMemberVO ????????? ?????? ???  >>> : ");	
		
	}
	
	
	
	

}
