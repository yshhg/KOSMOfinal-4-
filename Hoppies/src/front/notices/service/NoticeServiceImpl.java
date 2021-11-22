package front.notices.service;

import java.util.ArrayList;

import a.b.c.com.notice.dao.Noticedao;
import a.b.c.com.notice.dao.NoticedaoImpl;
import a.b.c.com.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public ArrayList<NoticeVO> noticeSelectAll() {
		// TODO Auto-generated method stub
		
		
		Noticedao ndao = new NoticedaoImpl();
		return ndao.noticeSelectAll();
	}

	@Override
	public ArrayList<NoticeVO> noticeSelect(NoticeVO nvo) {
		// TODO Auto-generated method stub
			
		
		Noticedao ndao = new NoticedaoImpl();
		return ndao.noticeSelect(nvo);
	}

	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub
				
		
		Noticedao ndao = new NoticedaoImpl();
		return ndao.noticeInsert(nvo);
	}

	@Override
	public int noticeUpdate(NoticeVO nvo) {
		// TODO Auto-generated method stub
			
		
		Noticedao ndao = new NoticedaoImpl();
		return ndao.noticeUpdate(nvo);
	}

	@Override
	public int noticeDelete(NoticeVO nvo) {
		// TODO Auto-generated method stub
			
		
		Noticedao ndao = new NoticedaoImpl();
		return ndao.noticeDelete(nvo);
	}
}
