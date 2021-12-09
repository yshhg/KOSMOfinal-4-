package front.common.dao;

import front.computer.vo.ComputerBoardVO;
import front.gameboard.vo.GameBoardVO;
import front.mem.vo.MemberVO;

public interface ChabunDAO {
	
	public MemberVO getMemChabun();
	public GameBoardVO getGameBoardChabun();
	public ComputerBoardVO getComputerBoardChabun();//21-12-09 컴퓨터 채번 추가
}
