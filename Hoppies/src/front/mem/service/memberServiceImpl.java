package front.mem.service;

import java.util.List;

import front.mem.vo.memberVO;
import front.mem.dao.memberDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class memberServiceImpl implements memberService {
	Logger logger = Logger.getLogger(memberServiceImpl.class);

	private memberDAO memberDAO;
	
	@Autowired(required=false)
	public memberServiceImpl(memberDAO memberDAO){
		this.memberDAO = memberDAO;
	}
	
	
	@Override
	public List<memberVO> memberSelectAll(memberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberSelectAll() 함수 진입");
		return memberDAO.memberSelectAll(mvo);
	}

	@Override
	public List<memberVO> memberSelect(memberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberSelect() 함수 진입");
		return memberDAO.memberSelect(mvo);
	}

	@Override
	public int memberInsert(memberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberInsert() 함수 진입");
		return memberDAO.memberInsert(mvo);
	}

	@Override
	public int memberUpdate(memberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberUpdate() 함수진입");
		return memberDAO.memberUpdate(mvo);
	}

	@Override
	public int memberDelete(memberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberDelete() 함수진입");
		return memberDAO.memberDelete(mvo);
	}

	@Override
	public List<memberVO> memberIdCheck(memberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberIdCheck() 함수진입");
		return memberDAO.memberIdCheck(mvo);
	}
}
