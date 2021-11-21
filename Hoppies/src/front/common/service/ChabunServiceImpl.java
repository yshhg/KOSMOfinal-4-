package front.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import front.common.DAO.ChabunDAO;
import front.mem.vo.memberVO;


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
	public memberVO getMemChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunServiceImpl getMemChabun >>> : ");
		return chabunDAO.getMemChabun();
	}

}
