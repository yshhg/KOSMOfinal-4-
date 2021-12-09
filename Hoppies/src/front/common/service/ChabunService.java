package front.common.service;

import front.computer.vo.ComputerBoardVO;
import front.gameboard.vo.GameBoardVO;
import front.mem.vo.MemberVO;

public interface ChabunService {
	
	public MemberVO getMemChabun();
	public GameBoardVO getGameBoardChabun();
	public ComputerBoardVO getComputerBoardChabun();//21-12-09 컴퓨터 채번 추가
	
}
