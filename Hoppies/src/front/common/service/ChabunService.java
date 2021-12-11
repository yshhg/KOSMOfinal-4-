package front.common.service;

import front.gameboard.vo.GameBoardVO;
import front.mem.vo.MemberVO;
import front.notices.vo.NoticeVO;

public interface ChabunService {
	
	public MemberVO getMemChabun();
	public GameBoardVO getGameBoardChabun();
	public NoticeVO getNoticeChabun();
	
}
