package front.notices.dao;

import java.util.List;

import front.notices.vo.NoticeVO;



public interface NoticeDAO {

	// 게시글 작성
	public int noticeInsert(NoticeVO nvo);
	// 목록 조회
	public List<NoticeVO> noticeList(NoticeVO nvo);
	

	// 게시글 상세 조회
	public NoticeVO noticeSelect(NoticeVO nvo);
	// 조회수 증가
	public void updateCntHit(String no_num);


	// 게시글 수정
	public int noticeUpdate(NoticeVO nvo);
	// 게시글 삭제
	public int noticeDelete(NoticeVO nvo);
}
	