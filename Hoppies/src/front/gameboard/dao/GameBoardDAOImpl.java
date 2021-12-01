package front.gameboard.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import front.gameboard.vo.GameBoardVO;

@Repository
public class GameBoardDAOImpl implements GameBoardDAO {
	Logger logger = Logger.getLogger(GameBoardDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<GameBoardVO> gameboardSelect(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gameboardSelect", gvo);
	}

	@Override
	public List<GameBoardVO> gameboardSelectAll(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gameboardSelectAll", gvo);
	}

	@Override
	public int gameboardInsert(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("gameboardInsert", gvo);
	}

	@Override
	public int gameboardUpdate(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("gameboardUpdate", gvo);
	}

	@Override
	public int gameboardDelete(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("gameboardDelete", gvo);
	}

	@Override
	public List<GameBoardVO> gameboardSelectPaging(GameBoardVO gvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gameboardSelectPaging", gvo);
	}

}
