package front.notices.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import front.notices.dao.Noticedao;
import front.notices.vo.NoticeVO;


@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

	
	Logger logger = Logger.getLogger(NoticeServiceImpl.class);
	
	
	@Autowired(required=false)
	private Noticedao NoticeDAO;
	
	public NoticeServiceImpl(Noticedao NoticeDAO) {
		this.Noticedao = NoticeDAO;
	}

	// 게시글 작성
	@Override
	public int noticeInsert(NoticeVO nvo) {
		logger.info("noticeInsert(nvo) transaction");
		return Noticedao.noticeInsert(nvo);
	}
	
	// 목록 조회
	@Override
	public List<NoticeVO> noticeList(NoticeVO nvo) {
		logger.info("noticeList(nvo) transaction");
		return Noticedao.noticeList(nvo);
	}
	
	// 게시글 상세 조회
	@Override
	public NoticeVO noticeSelect(NoticeVO nvo) {
		logger.info("noticeSelect(nvo) transaction");
		return Noticedao.noticeSelect(nvo);
	}
	

	
	// 게시글 수정
	@Override
	public int noticeUpdate(NoticeVO nvo) {
		logger.info("noticeUpdate(nvo) transaction");
		return Noticedao.noticeUpdate(nvo);
	}

	// 게시글 삭제
	@Override
	public int noticeDelete(NoticeVO nvo) {
		logger.info("noticeDelete(nvo) transaction");
		return Noticedao.noticeDelete(nvo);
	}
}