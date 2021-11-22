package front.mem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import front.common.ChabunUtil;
import front.common.CommonUtils;
import front.common.FileUploadUtil;
import front.common.service.ChabunService;
import front.mem.service.MemberService;
import front.mem.vo.MemberVO;

public class MemberController {
	Logger logger = Logger.getLogger(MemberController.class);
	
	private MemberService MemberService;
	private ChabunService chabunService;
	
	// 생성자 오토와이어드
	@Autowired(required=false)
	public MemberController(MemberService MemberService,
							ChabunService chabunService) {
		
		this.MemberService = MemberService;
		this.chabunService = chabunService;
	}
	
	// 회원가입 입력 폼
	// RequestMapping(value = "memForm", method=RequestMethod.GET)
	@GetMapping("memForm")
	public String memberForm() {
		logger.info("memberController memberForm() 함수 진입");
		return "mem/MemForm";
	}
	
	// 회원가입
	// @RequestMapping(value="memInsert", method=RequestMethod.POST)
	@PostMapping("memInsert")
	public String memInsert(HttpServletRequest req) {
		logger.info("memberController memInsert() 함수 진입");
		
		// 채번 구하기
		String mnum = ChabunUtil.getMemChabun("D", chabunService.getMemChabun().getMnum());
		logger.info("memberController memInsert mnum >> : " + mnum);
		
		// 이미지 업로드 
				FileUploadUtil fu = new FileUploadUtil(	 CommonUtils.MEMBER_IMG_UPLOAD_PATH
											           	,CommonUtils.MEMBER_IMG_FILE_SIZE
											           	,CommonUtils.MEMBER_EN_CODE);
				
		// 이미지 파일 원본 사이즈 
		// boolean bool = fu.imgfileUpload(req);
		// 이미지 파일 원본 사이즈 크기 조절 하기 
		boolean bool = fu.imgfileUploadSize(req);
		logger.info("SpringMemberController memInsert bool >>> : " + bool);

		// 채번, 이미지 업로드 성공하면 VO 세팅하기 
		MemberVO mvo = null;
		mvo = new MemberVO();
		
		// 회원번호
		mvo.setMnum(mnum);
		// 회원이름
		mvo.setMname(fu.getParameter("mname"));
		// 아이디
		mvo.setMid(fu.getParameter("mid"));
		// 패스워드
		mvo.setMpw(fu.getParameter("mpw"));
		
		//##################################################################
		// 회원취미1
		mvo.setMhobby_1(fu.getParameter("mhobby_1"));
		// 회원취미2		
		mvo.setMhobby_2(fu.getParameter("mhobby_2"));
		// 회원취미3
		mvo.setMhobby_3(fu.getParameter("mhobby_3"));
		// 지역
		mvo.setMarea(fu.getParameter("Marea"));
		
		return "mem/memForm";
	}
	
	// 회원 목록 조회
			@RequestMapping(value="memSelectAll", method = RequestMethod.GET)
			public String memSelectAll(MemberVO mvo, Model model) {
				logger.info("memberController memSelectAll 함수 진입 >>> :");	
				
				List<MemberVO> listAll = MemberService.memberSelectAll(mvo);
				logger.info("SpringMemberController memSelectAll listAll.size() >>> : " + listAll.size());
				
				if (listAll.size() > 0) { 
					
					model.addAttribute("listAll", listAll);
					return "mem/memSelectAll";
				}
				
				return "mem/memForm";
			
			}
	
	

}
