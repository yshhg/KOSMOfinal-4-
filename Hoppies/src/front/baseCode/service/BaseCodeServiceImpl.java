package front.baseCode.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import front.baseCode.dao.BaseCodeDAO;
import front.baseCode.vo.BaseCodeVO;

@Service
public class BaseCodeServiceImpl implements BaseCodeService{
	Logger logger = Logger.getLogger(BaseCodeServiceImpl.class);

	@Autowired(required=false)		//@Inject
	BaseCodeDAO baseCodeDAO;
	
	@Override
	public List<BaseCodeVO> selectAreaAll(BaseCodeVO mvo) {
		logger.info("BaseCodeServiceImpl >>>>>>>>>>>>>> selectAreaAll() 함수진입");
		
		return baseCodeDAO.selectAreaAll(mvo);
	}

	@Override
	public List<BaseCodeVO> selectHobyyAll(BaseCodeVO mvo) {
		// TODO Auto-generated method stub
		logger.info("BaseCodeServiceImpl >>>>>>>>>>>>>> selectHobyyAll() 함수진입");
		return baseCodeDAO.selectHobyyAll(mvo);
	}

}
