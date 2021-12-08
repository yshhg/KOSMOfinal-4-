package front.mem.dao;

import java.util.List;

import front.mem.vo.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> memberSelectAll(MemberVO mvo);
	public List<MemberVO> memberSelect(MemberVO mvo);
	public int memberInsert(MemberVO mvo);
	public int memberUpdate(MemberVO mvo);
	public int memberDelete(MemberVO mvo);
	
	// 아이디 중복 체크
	public List<MemberVO> memberIdCheck(MemberVO mvo);
	
	public int insertMember(MemberVO vo);
	public MemberVO loginPro(MemberVO mvo);

}
