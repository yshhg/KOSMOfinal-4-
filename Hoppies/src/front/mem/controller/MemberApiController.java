package front.mem.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/front/api")
public class MemberApiController {
	Logger logger = Logger.getLogger(MemberApiController.class);
	
	//회원가입
	@RequestMapping(value = "regist")
	public String regist() {
		
		logger.info("MemberApiController >>>>>>>>>>>>> regist() 함수진입");
		
		return "login/login";
	}
	 

}
