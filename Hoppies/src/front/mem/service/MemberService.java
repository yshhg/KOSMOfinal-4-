package front.mem.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import front.mem.vo.MemberVO;

public interface MemberService {
	
	public List<MemberVO> memberSelectAll(MemberVO mvo);
	public List<MemberVO> memberSelect(MemberVO mvo);
	public int memberInsert(MemberVO mvo);
	public int memberUpdate(MemberVO mvo);
	public int memberDelete(MemberVO mvo);
	
	// 아이디 중복 체크
	public List<MemberVO> memberIdCheck(MemberVO mvo);
	
	public void memInsert(MemberVO mvo);

}
