package front.mem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import front.common.service.ChabunService;
import front.mem.service.MemberService;
import front.mem.vo.MemberVO;

@Controller
@RequestMapping(value = "/front/mem")
public class MemberRestController {
	Logger logger = Logger.getLogger(MemberRestController.class);

	@Autowired(required = false)
	MemberService memberService;

	// 회원가입화면으로 이동
	@RequestMapping(value = "/MemForm")
	public String index() {
		return "mem/MemForm";
	}

	@RequestMapping(value = "/confirmId", method = RequestMethod.POST)
	@ResponseBody
	public Object confirmId(MemberVO mvo) {

		// String id = req.getParameter("id");
		logger.info("url => confirmId");

		List<MemberVO> list = memberService.memberIdCheck(mvo);

		String msg = "";
		if (list.size() == 0) {
			msg = "ID_YES";
		} else {
			msg = "ID_NO";
		}

		return msg;
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login/login";
	}

	@RequestMapping(value = "/memInsert", method = RequestMethod.POST)
	public String memInsert(HttpServletRequest req, Model model) {

		logger.info("url => memInsert");

		MemberVO vo = new MemberVO();
		logger.info("url => memInsert>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + req.getParameter("mname"));
		vo.setMname(req.getParameter("mname"));
		vo.setMid(req.getParameter("mid"));
		vo.setMpw(req.getParameter("mpw"));
		vo.setMhobby_1(req.getParameter("mhobby_1"));
		vo.setMhobby_2(req.getParameter("mhobby_2"));
		vo.setMhobby_3(req.getParameter("mhobby_3"));
		vo.setMarea(req.getParameter("marea"));

		memberService.memInsert(vo);

		return "redirect:/front/mem/main.s";
	}

	@RequestMapping(value = "/main")
	public String main() {
		return "main/main";
	}

}
