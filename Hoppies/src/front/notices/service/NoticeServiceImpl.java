package front.notices.service;

import java.util.ArrayList;

import front.notices.dao.Noticedao;
import front.notices.dao.NoticedaoImpl;
import front.notices.vo.NoticeVO;

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
