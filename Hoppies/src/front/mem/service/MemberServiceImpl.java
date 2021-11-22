package front.mem.service;

import java.util.List;

import front.mem.vo.MemberVO;
import front.mem.dao.MemberDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberServiceImpl implements MemberService {
	Logger logger = Logger.getLogger(MemberServiceImpl.class);

	private MemberDAO memberDAO;
	
	@Autowired(required=false)
	public MemberServiceImpl(MemberDAO memberDAO){
		this.memberDAO = memberDAO;
	}
	
	
	@Override
	public List<MemberVO> memberSelectAll(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberSelectAll() 함수 진입");
		return memberDAO.memberSelectAll(mvo);
	}

	@Override
	public List<MemberVO> memberSelect(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberSelect() 함수 진입");
		return memberDAO.memberSelect(mvo);
	}

	@Override
	public int memberInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberInsert() 함수 진입");
		return memberDAO.memberInsert(mvo);
	}

	@Override
	public int memberUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberUpdate() 함수진입");
		return memberDAO.memberUpdate(mvo);
	}

	@Override
	public int memberDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberDelete() 함수진입");
		return memberDAO.memberDelete(mvo);
	}

	@Override
	public List<MemberVO> memberIdCheck(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberServiceImpl memberIdCheck() 함수진입");
		return memberDAO.memberIdCheck(mvo);
	}
}
