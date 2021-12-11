package front.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import front.notices.service.NoticeService;
import front.notices.vo.NoticeVO;
import front.common.CommonUtils;
import front.common.FileUploadUtil;



@Controller
public class NoticeController {

	Logger logger = Logger.getLogger(NoticeController.class);
	
	@Autowired(required=false)
	private NoticeService NoticeService;
	
	
	public NoticeController(NoticeService NoticeService) {
		this.NoticeService = NoticeService;
	}
	

	//  공지사항 글쓰기 폼 출력
	
	@GetMapping("noticeForm")
	public String noticeForm(NoticeVO nvo) {
		logger.info("noticeForm() CALL");
		return "notice/noticeForm";
	}



	// ==================================================================== /
	// 공지사항 글쓰기
	// ==================================================================== /
	@PostMapping("noticeInsert")
	public String noticeInsert(HttpSession hs, HttpServletRequest req) throws IOException {

		logger.info("noticeInsert() CALL");
 
		NoticeVO nvo = null; 
		nvo = new NoticeVO();

		// from noticeList() => get teacher's name
		String Nnum = (String)hs.getAttribute("userName");
		logger.info("HOME -> NOTICE LIST -> NOTICE FORM -> TEACHER NAME : " + Nnum);

		// REset from session value
		nvo.setNnum(Nnum);
		logger.info("TEACHER NAME IS : " + nvo.getNnum());
		
		// fileUploadUtil Instance
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.NOTICE_IMG_UPLOAD_PATH,
											   CommonUtils.NOTICE_IMG_FILE_SIZE,
											   CommonUtils.NOTICE_EN_CODE);
		
		boolean bool = fu.imgfileUploadSize(req);
		logger.info(bool);

		String nsubject = fu.getParameter("nsubject");
		String nmemo = fu.getParameter("nmemo");
		
		
		logger.info("NOTICE SUBJECT(TITLE) IS ---- : " + nsubject);
		logger.info("NOTICE MEMO IS ---------- :  " + nmemo);
		
		
		nvo.setNsubject(nsubject);					// 제목
		nvo.setNmemo(nmemo);				// 내용
		
		
		
		int nCnt = NoticeService.noticeInsert(nvo);
		logger.info("SUCCESS? THEN PRINT ((((1)))) : " + nCnt);
		
		if (nCnt > 0) {
		
			return "notice/noticeInsert";
		}
			

		return "notice/noticeForm"; // ?
	}
	
	
	// 공지사항 목록 조회 (LANDING: SELECT ALL)
	
	@GetMapping("noticeList")
	public String noticeList(HttpSession hs, Model model, NoticeVO nvo) {
		logger.info("noticeList() CALL");
		
		// 페이지 필드 셋팅
		int pageSize = CommonUtils.NOTICE_PAGE_SIZE;
		int groupSize = CommonUtils.NOTICE_GROUP_SIZE;
		
		
		if(nvo.getCurPage() != null) {
			curPage = Integer.parseInt(nvo.getCurPage());
			logger.info("curPage >>> : " + curPage);
		}
		
		nvo.setPageSize(String.valueOf(pageSize));
		nvo.setGroupSize(String.valueOf(groupSize));
		
		
				
				
				// PAGIN SETTING
				nvo.setPageSize(String.valueOf(pageSize));
				nvo.setGroupSize(String.valueOf(groupSize));
				
				
				List<NoticeVO> listAll = NoticeService.NoticeList(nvo);
				
				if(listAll.size() > 0) {
					logger.info("Controller.listAll.size(): " + listAll.size());
					
					model.addAttribute("pagingNvo", nvo);
					model.addAttribute("listAll", listAll);
				}		
				return "notice/noticeList";
				
								
	
				List<NoticeVO> listStu = NoticeService.checkStudent(lvo);
				//  go to nvo
				nvo = listStu.get(0);
				String ms_name = nvo.getNnum();
				
				
				
				
				
				
				// 페이징 셋팅
				nvo.setPageSize(String.valueOf(pageSize));
				nvo.setGroupSize(String.valueOf(groupSize));
				nvo.setCurPage(String.valueOf(curPage));
				nvo.setTotalCount(String.valueOf(totalCount));
				
				
				List<NoticeVO> listAll = NoticeService.NoticeList(nvo);
				
				if(listAll.size() > 0) {
					logger.info("Controller.listAll.size(): " + listAll.size());
					
					model.addAttribute("pagingNvo", nvo);
					model.addAttribute("listAll", listAll);
				}
				
				return "notice/noticeList";
			}
		
											
			
				if(mt_id != null) {						
				
			
				// PAGIN SETTING
				nvo.setPageSize(String.valueOf(pageSize));
				nvo.setGroupSize(String.valueOf(groupSize));
				nvo.setCurPage(String.valueOf(curPage));
				nvo.setTotalCount(String.valueOf(totalCount));
				
				List<NoticeVO> listAll = NoticeService.noticeList(nvo);
				
				if(listAll.size() > 0) {
					logger.info("Controller.listAll.size(): " + listAll.size());
					
					model.addAttribute("pagingNvo", nvo);
					model.addAttribute("listAll", listAll);
				}		
				return "notice/noticeList";
				
			} else {								// STUDENT LOGIN ========================= //
	
				
				
				
				// PAGING SETTING
				nvo.setPageSize(String.valueOf(pageSize));
				nvo.setGroupSize(String.valueOf(groupSize));
				nvo.setCurPage(String.valueOf(curPage));
				nvo.setTotalCount(String.valueOf(totalCount));
				
				List<NoticeVO> listAll = NoticeService.noticeList(nvo);
				
				if(listAll.size() > 0) {
					logger.info("Controller.listAll.size(): " + listAll.size());
					
					model.addAttribute("pagingNvo", nvo);
					model.addAttribute("listAll", listAll);
				}
				
				return "notice/noticeList";
			}
		}
	}

	

	// ==================================================================== /
	// 게시글 상세 조회
	// ==================================================================== /
	@GetMapping("noticeDetail")
	public String noticeSelect(NoticeVO nvo, HttpServletRequest req, Model model, HttpSession hs) {
		logger.info("noticeSelect() CALL");
		
		// FROM noticeList()
		String myName = (String)hs.getAttribute("userName");
		logger.info("HOME(SCHOOL) -> NOTICE -> NOTICELIST -> SELECT, MY NAME? : " + myName);
		
	}

	
	// 게시글 수정 
	
	@PostMapping("noticeUpdateForm")
	public String noticeUpdateForm(NoticeVO nvo, HttpServletRequest req, Model model) {
		logger.info("noticeUpdateForm() ȣ��");
		String no_num = req.getParameter("no_num");
		nvo.setNnum(no_num);
		NoticeVO listS = NoticeService.noticeSelect(nvo);
		model.addAttribute("listS", listS);
		return "notice/noticeUpdateForm";
	}
	
	
	// ==================================================================== /
	// 게시글 수정
	// ==================================================================== /
	@PostMapping("noticeUpdate")
	public String noticeUpdate(NoticeVO nvo, HttpSession hs, HttpServletRequest req) {
		logger.info("noticeUpdate() ȣ��");
		
		// from noticeList()
		String myName = (String)hs.getAttribute("userName");
		logger.info(" 홈-> 공지사항 목록 -> 조회 -> 수정 -> 내 이름 :  : " + myName);
		String mt_id = (String) hs.getAttribute("teacherId");
		logger.info("TEACHER'S ID : " + mt_id);
		
		// FILEUPLOADUTIL INSTANCE
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.NOTICE_IMG_UPLOAD_PATH,
											   CommonUtils.NOTICE_IMG_FILE_SIZE,
											   CommonUtils.NOTICE_EN_CODE);
		
		boolean bool = fu.imgfileUploadSize(req);
		logger.info(bool);

		String nnum = fu.getParameter("Nnum");
		String nsubject = fu.getParameter("Nsubject");
		String nmemo = fu.getParameter("Nmemo");
		

		logger.info("NO_NUM ------------------ :" + nnum);
		logger.info("NO_SUBJECT -------------- : " + nsubject);
		logger.info("NMEMO ------------- : " + nmemo);
		
		
		nvo.setNnum(nnum);
		nvo.setNsubject(nsubject);					// 제목
		nvo.setNmemo(nmemo);				// 내용
								// 파일
		
		
			
			
			
			
			logger.info("선택한 공지사항 글 번호: " + nnum);
			
			// 공지 갱신()
			int nCnt = NoticeService.noticeUpdate(nvo);

			if(nCnt == 1) {
				return "notice/noticeUpdate";
			} else {
				return "notice/noticeUpdateForm";
			}
			
		
		
			
		}
	


	// 게시글 삭제
	
	@PostMapping("noticeDelete")
	public String noticeDelete(NoticeVO nvo, HttpServletRequest req) {
		logger.info("noticeDelete()");
		
		String no_num = req.getParameter("no_num");
		
		logger.info("no_num --------------------------------------- : " + no_num);
		nvo.setNnum(no_num);
		logger.info("recheck! no_num ------------------------------ : " + no_num);
		
		// 공지삭제
		int nCnt = NoticeService.noticeDelete(nvo);
		
		if(nCnt == 1) {
			return "notice/noticeDelete";
		}
		return "notice/noticeList";
	}
	
}
