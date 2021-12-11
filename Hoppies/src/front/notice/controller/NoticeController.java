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
	
	
	public NoticeController(NoticeService kosmosNoticeService) {
		this.NoticeService = NoticeService;
	}
	
	//  공지사항 글쓰기 폼 출력
	@GetMapping("noticeForm")
	public String noticeForm(KosmosNoticeVO nvo) {
		logger.info("noticeForm() CALL");
		return "notice/noticeForm";
	}



	
	// 공지사항 글쓰기
	@PostMapping("noticeInsert")
	public String noticeInsert(HttpSession hs, HttpServletRequest req) throws IOException {

		logger.info("noticeInsert() CALL");
 
		NoticeVO nvo = null; 
		nvo = new NoticeVO();

		// 공지사항 리스트
		String mt_num = (String)hs.getAttribute("userName");
		logger.info("LOGIN -> HOME -> NOTICE LIST -> NOTICE FORM -> TEACHER NAME : " + mt_num);

		
		nvo.setnnum(mt_num);
		logger.info("TEACHER NAME IS : " + nvo.getnnum());
		
		// fileUploadUtil Instance
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.NOTICE_IMG_UPLOAD_PATH,
											   CommonUtils.NOTICE_IMG_FILE_SIZE,
											   CommonUtils.NOTICE_EN_CODE);
		
		boolean bool = fu.imgfileUploadSize(req);
		logger.info(bool);

		String no_subject = fu.getParameter("no_subject");
		String no_contents = fu.getParameter("no_contents");
		String no_file = fu.getFileName("no_file");
		String mt_id = fu.getParameter("mt_id");
		
		logger.info("NOTICE SUBJECT(TITLE) IS ---- : " + no_subject);
		logger.info("NOTICE CONTENTS IS ---------- :  " + no_contents);
		
		nvo.setMt_num(mt_num);							// 작성자
		nvo.setNo_subject(no_subject);					// 제목
	
		
		
		
		// noticeInsert()
		int nCnt = NoticeService.noticeInsert(nvo);
		logger.info("SUCCESS? THEN PRINT ((((1)))) : " + nCnt);
		
		if (nCnt > 0) {
		
			return "notice/noticeInsert";
		}
			

		return "notice/noticeForm"; // ?
	}
	
	
	
	// 공지사항 목록 조회 
	
	@GetMapping("noticeList")
	public String noticeList(HttpSession hs, Model model, KosmosNoticeVO nvo) {
		logger.info("noticeList() CALL");
		
		// 세션에 "result"
		LoginVO lvo = (LoginVO) hs.getAttribute("result");
		
		// student login check
		String ms_id = lvo.getMs_id();
		String ms_pw = lvo.getMs_pw();
		logger.info("STUDENT ID ----- : " + ms_id);
		logger.info("STUDENT PW ----- : " + ms_pw);
		
		// teacher login check
		String mt_id = lvo.getMt_id();
		String mt_pw = lvo.getMt_pw();
		logger.info("TEAHCER ID ----- : " + mt_id);
		logger.info("TEAHCER PW ----- : " + mt_pw);

		String searchType = nvo.getSearchType();
		String keyword = nvo.getKeyword();
		logger.info("searchType ------ : " + searchType);
		logger.info("keyword --------- : " + keyword);
		nvo.setSearchType(searchType);
		nvo.setKeyword(keyword);

		// paging field setting (rehandling vo DATATYPE)
		int pageSize = CommonUtils.NOTICE_PAGE_SIZE;
		int groupSize = CommonUtils.NOTICE_GROUP_SIZE;
		int curPage = CommonUtils.BOARD_CUR_PAGE;
		int totalCount = CommonUtils.BOARD_TOTAL_COUNT;
		
		if(nvo.getCurPage() != null) {
			curPage = Integer.parseInt(nvo.getCurPage());
			logger.info("curPage >>> : " + curPage);
		}
		
		nvo.setPageSize(String.valueOf(pageSize));
		nvo.setGroupSize(String.valueOf(groupSize));
		nvo.setCurPage(String.valueOf(curPage));
		nvo.setTotalCount(String.valueOf(totalCount));
		
		logger.info("KosmosBoardController boardSelectAll bvo.getPageSize() >>> : " 
					+ nvo.getPageSize());
		logger.info("KosmosBoardController boardSelectAll bvo.getGroupSize() >>> : " 
					+ nvo.getGroupSize());
		logger.info("KosmosBoardController boardSelectAll bvo.getCurPage() >>> : " 
					+ nvo.getCurPage());
		logger.info("KosmosBoardController boardSelectAll bvo.getTotalCount() >>> : " 
					+ nvo.getTotalCount());

		
		if(keyword != null) {						// ======= 검색어가 입력된 경우 ======= //
			if(mt_id != null) {						// TEACHER LOGIN ==================== //
				
				logger.info("nvo.getSearchType() : " + nvo.getSearchType());
				logger.info("keyword ");
				// 회원 이름 끄내기
				List<NoticeVO> listTea = NoticeService.checkTeacher(lvo);
				nvo = listTea.get(0);
				String teacherName = nvo.getMt_name();
				String teacherId = nvo.getMt_id();
				logger.info("show me what ur name is : " + teacherName);
				logger.info("what's ur id : " + teacherId);
				
				// 공지사항 테이블 작성자(mt_num)에다 교사 테이블의 교사 이름 세팅!
				nvo.setMt_num(teacherName);
				nvo.setMt_id(teacherId);
				
				// keyword & searchType set in nvo
				nvo.setSearchType(searchType);
				nvo.setKeyword(keyword);
				
				// MT_NAME ---> "writer"
				hs.setAttribute("writer", teacherName);
				// MT_NAME ---> "userName"
				hs.setAttribute("userName", teacherName);
				
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
				
			} else {								// STUDENT LOGIN ==================== //
	
				List<NoticeVO> listStu = NoticeService.checkStudent(lvo);
				// nvo
				nvo = listStu.get(0);
				String ms_name = nvo.getMs_name();
				
				nvo.setMs_name(ms_name);
				logger.info("show me what ur name is : " + ms_name);
				
				// RESET keyword & searchType in nvo
				nvo.setSearchType(searchType);
				nvo.setKeyword(keyword);
				// MS_NAME ---> userName
//				hs.setAttribute("userName", ms_name);
				logger.info("DO U GET searchType ??? : " + nvo.getSearchType());
				logger.info("DO U GET keyword ??? : " + nvo.getKeyword());
				
				// PAGING SETTING
				nvo.setPageSize(String.valueOf(pageSize));
				nvo.setGroupSize(String.valueOf(groupSize));
				nvo.setCurPage(String.valueOf(curPage));
				nvo.setTotalCount(String.valueOf(totalCount));
				
				// noticeList() gogo
				List<KosmosNoticeVO> listAll = kosmosNoticeService.noticeList(nvo);
				
				if(listAll.size() > 0) {
					logger.info("Controller.listAll.size(): " + listAll.size());
					
					model.addAttribute("pagingNvo", nvo);
					model.addAttribute("listAll", listAll);
				}
				
				return "notice/noticeList";
			}
		
		} else {										// ======= JUST SELECT NOTICE LIST ======= //
			
				if(mt_id != null) {						// TEACHER LOGIN ========================= //
				
				// lvo(회원 아이디와 회원 비밀번호로)로 회원 이름 끄내기
				List<KosmosNoticeVO> listTea =  kosmosNoticeService.checkTeacher(lvo);
				nvo = listTea.get(0);
				String teacherName = nvo.getMt_name();
				String teacherId = nvo.getMt_id();
				logger.info("show me what ur name is : " + teacherName);
				logger.info("what's ur id : " + teacherId);
				
				// 공지사항 테이블 작성자(mt_num)에다 교사 테이블의 교사 이름 세팅!
				nvo.setMt_num(teacherName);
				nvo.setMt_id(teacherId);
				
				// MT_NAME ---> "writer"
				hs.setAttribute("writer", teacherName);
				// MT_NAME ---> "userName"
				hs.setAttribute("userName", teacherName);
				
				// PAGIN SETTING
				nvo.setPageSize(String.valueOf(pageSize));
				nvo.setGroupSize(String.valueOf(groupSize));
				nvo.setCurPage(String.valueOf(curPage));
				nvo.setTotalCount(String.valueOf(totalCount));
				
				List<KosmosNoticeVO> listAll = kosmosNoticeService.noticeList(nvo);
				
				if(listAll.size() > 0) {
					logger.info("Controller.listAll.size(): " + listAll.size());
					
					model.addAttribute("pagingNvo", nvo);
					model.addAttribute("listAll", listAll);
				}		
				return "notice/noticeList";
				
			} else {								// STUDENT LOGIN ========================= //
	
				List<KosmosNoticeVO> listStu = kosmosNoticeService.checkStudent(lvo);
				
				nvo = listStu.get(0);
				String ms_name = nvo.getMs_name();
				logger.info("show me what ur name is : " + ms_name);
				
				// MS_NAME ---> "userName"
				hs.setAttribute("userName", ms_name);
	
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

	

	
	// 게시글 상세 조회
	
	@GetMapping("noticeDetail")
	public String noticeSelect(NoticeVO nvo, HttpServletRequest req, Model model, HttpSession hs) {
		logger.info("noticeSelect() CALL");
		
		// FROM noticeList()
		String myName = (String)hs.getAttribute("userName");
		logger.info("HOME(SCHOOL) -> NOTICE -> NOTICELIST -> SELECT, MY NAME? : " + myName);
		String mt_id = (String) hs.getAttribute("teacherId");
		logger.info("TEAHCER'S ID : " + mt_id);
		
		if(nvo.getMs_name() != null) {		// STUDENT LOGIN ============== //
			
			nvo.setMs_name(myName);
			logger.info("IMMA STUDENT, AND MY NAME IS : " + nvo.getMs_name());
			
			String no_num = req.getParameter("no_num");
			logger.info("선택한 공지사항 글 번호 : " + no_num);
			
			NoticeVO listS = NoticeService.noticeSelect(nvo);

			// 조회수 증가 함수도 함께 실행
			kosmosNoticeService.updateCntHit(no_num);

			model.addAttribute("listS", listS);
			
			return "notice/noticeDetail";
		
		
		} else {							// TEACHER LOGIN ============== //
			
			nvo.setMt_name(myName);
			logger.info("IMMA TEACHER, AND MY NAME IS : " + nvo.getMt_name());

			String no_num = req.getParameter("no_num");
			logger.info("선택한 공지사항 글 번호: " + no_num);

			nvo.setMt_id(mt_id);
			logger.info("TEACHER'S ID : " + nvo.getMt_id());
			
			KosmosNoticeVO listS = kosmosNoticeService.noticeSelect(nvo);

			// 조회수 증가 함수도 함께 실행
			kosmosNoticeService.updateCntHit(no_num);

			model.addAttribute("listS", listS);
			
			return "notice/noticeDetail";
		}

	}


	// 게시글 수정 화면 출력
	
	@PostMapping("noticeUpdateForm")
	public String noticeUpdateForm(NoticeVO nvo, HttpServletRequest req, Model model) {
		logger.info("noticeUpdateForm() ȣ��");
		String no_num = req.getParameter("no_num");
		nvo.nnum(no_num);
		NoticeVO listS = NoticeService.noticeSelect(nvo);
		model.addAttribute("listS", listS);
		return "notice/noticeUpdateForm";
	}
	
	
	
	// 게시글 수정
	
	@PostMapping("noticeUpdate")
	public String noticeUpdate(NoticeVO nvo, HttpSession hs, HttpServletRequest req) {
		logger.info("noticeUpdate() ȣ��");
		
		// from noticeList()
		String myName = (String)hs.getAttribute("userName");
		logger.info("로그인-> 홈-> 공지사항 목록 -> 조회 -> 수정 -> 내 이름 :  : " + myName);
		String mt_id = (String) hs.getAttribute("teacherId");
		logger.info("TEACHER'S ID : " + mt_id);
		
		// FILEUPLOADUTIL INSTANCE
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.NOTICE_IMG_UPLOAD_PATH,
											   CommonUtils.NOTICE_IMG_FILE_SIZE,
											   CommonUtils.NOTICE_EN_CODE);
		
		boolean bool = fu.imgfileUploadSize(req);
		logger.info(bool);

		String no_num = fu.getParameter("no_num");
		String no_subject = fu.getParameter("no_subject");
		String no_contents = fu.getParameter("no_contents");
		String no_file = fu.getFileName("no_file");

		logger.info("NO_NUM ------------------ :" + no_num);
		logger.info("NO_SUBJECT -------------- : " + no_subject);
		logger.info("NO_CONTENTS ------------- : " + no_contents);
		logger.info("NO_FILE ----------------- :" + no_file);
		
		nvo.setnnum(nnum);
		nvo.setNo_subject(subject);					// 제목
		
		
		if(nvo.getMs_name() != null) {		// STUDENT LOGIN =============== //
			
			nvo.setMs_name(myName);
			logger.info("IMMA STUDENT, MY NAME IS : " + nvo.getMs_name());
			
			logger.info("선택한 공지사항 글 번호: " + no_num);
			
			
			int nCnt = kosmosNoticeService.noticeUpdate(nvo);

			if(nCnt == 1) {
				return "notice/noticeUpdate";
			} else {
				return "notice/noticeUpdateForm";
			}
			
		} else {							
			nvo.setMt_name(myName);
			logger.info("교사 로그인 : 내 이름은  : " + nvo.getMt_name());


			logger.info("선택한 공지사항 글 번호: " + no_num);

			
			
			
			int nCnt = NoticeService.noticeUpdate(nvo);

			if(nCnt == 1) {
				return "notice/noticeUpdate";
			} else {
				return "notice/noticeUpdateForm";
			}
			
		}
	}


	// 게시글 삭제
	
	@PostMapping("noticeDelete")
	public String noticeDelete(NoticeVO nvo, HttpServletRequest req) {
		logger.info("noticeDelete() ȣ��");
		
		String no_num = req.getParameter("no_num");
		
		logger.info("no_num --------------------------------------- : " + no_num);
		nvo.setnnum(no_num);
		logger.info("recheck! no_num ------------------------------ : " + no_num);
		
		// noticeDelete() gogo
		int nCnt = NoticeService.noticeDelete(nvo);
		
		if(nCnt == 1) {
			return "notice/noticeDelete";
		}
		return "notice/noticeList";
	}
	
}
