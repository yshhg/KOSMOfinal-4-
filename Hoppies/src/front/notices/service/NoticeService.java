package front.notices.service;

import java.util.ArrayList;

import front.notices.vo.NoticeVO;

public interface NoticeService {
	
	public ArrayList<NoticeVO> noticeSelectAll();
	public ArrayList<NoticeVO> noticeSelect(NoticeVO nvo);
	public int noticeInsert(NoticeVO nvo);
	public int noticeUpdate(NoticeVO nvo);
	public int noticeDelete(NoticeVO nvo);	

}
