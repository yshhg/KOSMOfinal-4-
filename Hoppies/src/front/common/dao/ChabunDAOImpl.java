package front.common.dao;


import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import front.computer.vo.ComputerBoardVO;
import front.gameboard.vo.GameBoardVO;
import front.mem.vo.MemberVO;


@Repository
public class ChabunDAOImpl implements ChabunDAO {
	private Logger logger = Logger.getLogger(ChabunDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public GameBoardVO getGameBoardChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunDAOImpl.getGameBoardChabun >>> : ");
		return sqlSession.selectOne("getGameBoardChabun");
	}
	
	@Override
	public ComputerBoardVO getComputerBoardChabun(){//21-12-09 컴퓨터 채번 추가
		// TODO Auto-generated method stub
		logger.info("ChabunDAOImpl.getComputerBoardChabun >>> : ");
		return sqlSession.selectOne("getComputerBoardChabun");
	}

	@Override
	public MemberVO getMemChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunDAOImpl getMemChabun >>> : ");
		return sqlSession.selectOne("getMemChabun");
	}	
}
