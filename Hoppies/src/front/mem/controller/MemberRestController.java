package front.mem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/front/mem")
public class MemberRestController {
	
	@RequestMapping(value = "MemForm")
	public String index() {
		return "front/mem/MemForm";
	}
	
	@RequestMapping(value = "login")
	public String login() {
		return "front/mem/login";
	}

}
