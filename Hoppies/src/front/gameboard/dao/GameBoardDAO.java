package front.gameboard.dao;

import java.util.List;

import front.gameboard.vo.GameBoardVO;

public interface GameBoardDAO {

	public List<GameBoardVO> gameboardSelect(GameBoardVO gvo);
	public List<GameBoardVO> gameboardSelectAll(GameBoardVO gvo);
	public int gameboardInsert(GameBoardVO gvo);
	public int gameboardUpdate(GameBoardVO gvo);
	public int gameboardDelete(GameBoardVO gvo);
	
	// 로그인 체크
	public List<GameBoardVO> boardLoginCheck(GameBoardVO gvo);
	
	// 페이징
	public List<GameBoardVO> gameboardSelectPaging(GameBoardVO gvo);
	
	// 추천, 비추천
	public int boardRecom(int i);
	public int boardUnrecom(int i);
}
