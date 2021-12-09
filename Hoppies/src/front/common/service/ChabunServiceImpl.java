package front.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import front.common.dao.ChabunDAO;
import front.computer.vo.ComputerBoardVO;
import front.gameboard.vo.GameBoardVO;
import front.mem.vo.MemberVO;


@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	private Logger logger = Logger.getLogger(ChabunServiceImpl.class);
	
	private ChabunDAO chabunDAO;
	
	@Autowired(required=false)
	public ChabunServiceImpl (ChabunDAO chabunDAO) {
		this.chabunDAO = chabunDAO;
	}
	
	@Override
	public GameBoardVO getGameBoardChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunServiceImpl.getGameBoardChabun >>> : ");
		return chabunDAO.getGameBoardChabun();
	}
	
	@Override
	public ComputerBoardVO getComputerBoardChabun(){//21-12-09 컴퓨터 채번 추가
		logger.info("ChabunServiceImpl.getComputerBoardChabun >>> : ");
		return chabunDAO.getComputerBoardChabun();
	}
	
	@Override
	public MemberVO getMemChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunServiceImpl getMemChabun >>> : ");
		return chabunDAO.getMemChabun();
	}

}
