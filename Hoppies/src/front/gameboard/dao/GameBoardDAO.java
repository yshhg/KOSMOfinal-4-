package front.gameboard.dao;

import java.util.List;

import front.gameboard.vo.GameBoardVO;

public interface GameBoardDAO {

	public List<GameBoardVO> gameboardSelect(GameBoardVO gvo);
	public List<GameBoardVO> gameboardSelectAll(GameBoardVO gvo);
	public int gameboardInsert(GameBoardVO gvo);
	public int gameboardUpdate(GameBoardVO gvo);
	public int gameboardDelete(GameBoardVO gvo);
	
	// 페이징
	public List<GameBoardVO> gameboardSelectPaging(GameBoardVO gvo);
}