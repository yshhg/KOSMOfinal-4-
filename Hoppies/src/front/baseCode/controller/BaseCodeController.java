package front.baseCode.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import front.baseCode.service.BaseCodeService;
import front.baseCode.vo.BaseCodeVO;
import front.mem.vo.MemberVO;

@Controller
@RequestMapping(value = "/front/base")
public class BaseCodeController {
	Logger logger = Logger.getLogger(BaseCodeController.class);
	
	@Autowired(required=false)
	BaseCodeService ser;
	
	@RequestMapping(value = "areaAll")
	public String areaAll(BaseCodeVO mvo, Model model) {
		logger.info("BaseCodeController >>>>>>>>>>>>>> areaAll() 함수진입");
		
		List<BaseCodeVO> areaList = ser.selectAreaAll(mvo);			
		 model.addAttribute("areaList", areaList);
		 
		return "mem/areaPopup";
	}
	
	@RequestMapping(value = "hobbyAll")
	public String hobbyAll(BaseCodeVO mvo, Model model) {
		logger.info("BaseCodeController >>>>>>>>>>>>>> hobbyAll() 함수진입");
		
		List<BaseCodeVO> hobbyList = ser.selectHobyyAll(mvo);		
		model.addAttribute("hobbyList", hobbyList);
		 
		return "mem/hobbyPopup";
	}

}
