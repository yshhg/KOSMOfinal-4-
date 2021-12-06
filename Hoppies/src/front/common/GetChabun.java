package front.common;

public abstract class GetChabun {
	
	
	public static final String BIZ_GUBUN_N 	= "NB"; // 공지사항 : NOTICE BOARD
	

	public static String numPad(String t, String c){
	
		for (int i=c.length(); i < 4; i++) {
			c = "0" + c;
		}				
		return DateFormatUtil.ymdFormats(t).concat(c);
	}
	// 공지사항  번호  
	public static String getNoticeChabun(String type) {
		
		return BIZ_GUBUN_M.concat(numPad(type, ""));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}