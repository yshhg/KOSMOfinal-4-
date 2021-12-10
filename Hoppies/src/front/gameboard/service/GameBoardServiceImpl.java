package front.gameboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import front.gameboard.dao.GameBoardDAO;
import front.gameboard.vo.GameBoardVO;

@Service
@Transactional
public class GameBoardServiceImpl implements GameBoardService {
	Logger logger = Logger.getLogger(GameBoardServiceImpl.class);
	
	private GameBoardDAO gameBoardDAO;
	
	@Autowired(required=false)
	public GameBoardServiceImpl(GameBoardDAO gameBoardDAO) {
		this.gameBoardDAO = gameBoardDAO;
	}
	
	@Override
	public List<GameBoardVO> gameboardSelect(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return gameBoardDAO.gameboardSelect(gvo);
	}

	@Override
	public List<GameBoardVO> gameboardSelectAll(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return gameBoardDAO.gameboardSelectAll(gvo);
	}

	@Override
	public int gameboardInsert(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return gameBoardDAO.gameboardInsert(gvo);
	}

	@Override
	public int gameboardUpdate(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return gameBoardDAO.gameboardUpdate(gvo);
	}

	@Override
	public int gameboardDelete(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return gameBoardDAO.gameboardDelete(gvo);
	}

	@Override
	public List<GameBoardVO> boardLoginCheck(GameBoardVO gvo){
		// TODO Auto-generated method stub
		return gameBoardDAO.boardLoginCheck(gvo);
	}
	
	@Override
	public List<GameBoardVO> gameboardSelectPaging(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return gameBoardDAO.gameboardSelectPaging(gvo);
	}
	
	@Override
	public int boardRecom(int i, boolean b) {
	
		// true=추천, false=비추천
		if(b) {
			gameBoardDAO.boardRecom(i);
		}else {
			gameBoardDAO.boardUnrecom(i);
		}
		
		return 0;
	}

}
