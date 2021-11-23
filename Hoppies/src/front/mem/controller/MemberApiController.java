package front.mem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MemberApiController {
	
	@RequestMapping(value = "MemForm")
	public String index() {
		return "mem/MemForm";
	}

}
