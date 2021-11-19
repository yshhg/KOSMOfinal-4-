package front.mem.service;

import java.util.List;

import front.mem.vo.memberVO;

public interface memberService {
	
	public List<memberVO> memberSelectAll(memberVO mvo);
	public List<memberVO> memberSelect(memberVO mvo);
	public int memberInsert(memberVO mvo);
	public int memberUpdate(memberVO mvo);
	public int memberDelete(memberVO mvo);
	
	// 아이디 중복 체크
	public List<memberVO> memberIdCheck(memberVO mvo);

}
