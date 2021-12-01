package front.gameboard.vo;

import org.apache.log4j.Logger;

// 2021-11-21, 장진영 수정

public class GameBoardVO {
	private static Logger logger = Logger.getLogger(GameBoardVO.class);
	
	private String gnum;
	private String gnickname;
	private String gsubject;
	private String gcontents;
	private String gdivi;
	private String mno;
	private String recom;
	private String unrecom;
	private String photo;
	private String deleteyn;
	private String insertdate;
	private String updatedate;

	// 검색 구분자 및 검색어 
	private String keyfilter;
	private String keyword;
	private String startdate;
	private String enddate;
		
	// 페이징 이동 필드
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;
	
	public GameBoardVO() {
		
	}

	public GameBoardVO(String gnum, String gnickname, String gsubject, String gcontents, String gdivi, String mno,
			String recom, String unrecom, String photo, String deleteyn, String insertdate, String updatedate,
			String keyfilter, String keyword, String startdate, String enddate, String pageSize, String groupSize,
			String curPage, String totalCount) {
		
		this.gnum = gnum;
		this.gnickname = gnickname;
		this.gsubject = gsubject;
		this.gcontents = gcontents;
		this.gdivi = gdivi;
		this.mno = mno;
		this.recom = recom;
		this.unrecom = unrecom;
		this.photo = photo;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.keyfilter = keyfilter;
		this.keyword = keyword;
		this.startdate = startdate;
		this.enddate = enddate;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}
	
	public String getGnum() {
		return gnum;
	}
	public String getGnickname() {
		return gnickname;
	}
	public String getGsubject() {
		return gsubject;
	}
	public String getGcontents() {
		return gcontents;
	}
	public String getGdivi() {
		return gdivi;
	}
	public String getMno() {
		return mno;
	}
	public String getRecom() {
		return recom;
	}
	public String getUnrecom() {
		return unrecom;
	}
	public String getPhoto() {
		return photo;
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
	public String getKeyfilter() {
		return keyfilter;
	}
	public String getKeyword() {
		return keyword;
	}
	public String getStartdate() {
		return startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public String getPageSize() {
		return pageSize;
	}
	public String getGroupSize() {
		return groupSize;
	}
	public String getCurPage() {
		return curPage;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setGnum(String gnum) {
		this.gnum = gnum;
	}
	public void setGnickname(String gnickname) {
		this.gnickname = gnickname;
	}
	public void setGsubject(String gsubject) {
		this.gsubject = gsubject;
	}
	public void setGcontents(String gcontents) {
		this.gcontents = gcontents;
	}
	public void setGdivi(String gdivi) {
		this.gdivi = gdivi;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public void setRecom(String recom) {
		this.recom = recom;
	}
	public void setUnrecom(String unrecom) {
		this.unrecom = unrecom;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public void setDeleteyn(String delyn) {
		this.deleteyn = delyn;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public void setKeyfilter(String keyfilter) {
		this.keyfilter = keyfilter;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}
	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	public static void printVO(GameBoardVO gvo) {
		logger.info("GameBoardVO 데이터 확인 시작 >>> : ");
		
		logger.info("글번호 >>> : " + gvo.getGnum());
		logger.info("닉네임 >>> : " + gvo.getGnickname());
		logger.info("글 제목 >>> : " + gvo.getGsubject());
		logger.info("글 내용 >>> : " + gvo.getGcontents());
		logger.info("글 분류 >>> : " + gvo.getGdivi());
		logger.info("회원번호 >>> : " + gvo.getMno());
		logger.info("글 추천 >>> : " + gvo.getRecom());
		logger.info("글 비추천 >>> : " + gvo.getUnrecom());
		logger.info("삭제여부 >>> : " + gvo.getDeleteyn());
		logger.info("입력일 >>> : " + gvo.getInsertdate());
		logger.info("수정일 >>> : " + gvo.getUpdatedate());
		
		logger.info("페이징 데이터 확인 >>>");
		
		logger.info("페이지 >>> : " + gvo.getPageSize());
		logger.info("그룹사이즈 >>> : " + gvo.getGroupSize());
		logger.info("현재페이지 >>> : " + gvo.getCurPage());
		logger.info("전체건수 >>> : " + gvo.getTotalCount());
		
		logger.info("조건검색 데이터 확인 >>>");
		
		logger.info("검색 필터 >>> : " + gvo.getKeyfilter());
		logger.info("검색 키워드 >>> : " + gvo.getKeyword());
		logger.info("검색 시작일 >>> : " + gvo.getStartdate());
		logger.info("검색 종료일 : " + gvo.getEnddate());
	}
}
