package front.baseCode.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import front.baseCode.vo.BaseCodeVO;

@Repository
public class BaseCodeDAOImpl implements BaseCodeDAO{
	
	Logger logger = Logger.getLogger(BaseCodeDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BaseCodeVO> selectAreaAll(BaseCodeVO mvo) {
		logger.info("memberDAOImpl memberSelectAll() 함수진입");
		
		return sqlSession.selectList("selectAreaAll", mvo);
	}

	@Override
	public List<BaseCodeVO> selectHobyyAll(BaseCodeVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberDAOImpl selectHobyyAll() 함수진입");
		return sqlSession.selectList("selectHobyyAll", mvo);
	}

}
