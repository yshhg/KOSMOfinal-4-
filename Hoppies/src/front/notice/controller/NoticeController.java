package front.notice.controller;

import java.security.Principal;

import com.sun.media.jfxmedia.logging.Logger;

import front.common.ChabunUtil;
import front.common.CommonUtils;
import front.common.FileUploadUtil;
import front.notices.vo.NoticeVO;

public class NoticeController {

	@RequestMapping(value="noticeInsert", method=RequstMethod.POST)
	public String noticeInsert(HttpServletRequest req, Principal principal, Model model) {
		Logger.info("NoticeController noticeInsert nnum >>> : " + nnum);
		
		String nnum = ChabunUtil.getNoticeChabun("N", chabunService.getNoticeChabun().getNnum);
		logger.info("NoticeController noticeInsert nnum >>> : " + nnum);
		
		FileUploadUtil fu = new FileUploadUtil( CommonUtils.NOTICE_IMG_UPLOAD_PATH
												CommonUtils.NOTICE_IMG_FILE_SIZE
												CommonUtils.NOTICE_EN_CODE);
		boolean bool = fu.imgfileUploadSize(req);
		logger.info("NoticeController noticeInsert bool >>> : " + bool);
		
		NoticeVO _nvo = null;
		_nvo = new NoticeVO();
		
		_nvo.setNnum(nnum);
		_nvo.setNsubject(fu.getParameter("nsubject"));
		_nvo.setNwriter(principal.getName());
		_nvo.setNcontents(fu.)
		
	}
}
