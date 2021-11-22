package front.mem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/mem")
public class MemberApiController {
	
	@RequestMapping(value = "/")
	public String index() {
		return "/mem/MemForm";
	}

}
