package front.gameboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import front.common.ChabunUtil;
import front.common.CommonUtils;
import front.common.FileUploadUtil;
import front.common.service.ChabunService;
import front.gameboard.service.GameBoardService;
import front.gameboard.vo.GameBoardVO;

@Controller
@RequestMapping(value = "/front/game")
public class GameBoardController {
	Logger logger = Logger.getLogger(GameBoardController.class);
	
	private GameBoardService gameBoardService;
	private ChabunService chabunService;
	
	// 생성자 오토와이어드 2021-11-22 작성
	@Autowired(required=false)
	public GameBoardController(GameBoardService gameBoardService,
								ChabunService chabunService) {
		this.gameBoardService = gameBoardService;
		this.chabunService = chabunService;
	}
	
	// 게임 게시판 글 입력 폼 2021-11-22 작성
	@RequestMapping(value="gameBoardForm", method=RequestMethod.GET)
	public String gameboardForm() {
		return "/game/gameBoardForm";
	}
	
	// 게임 게시판 글쓰기 2021-11-22 작성
	@RequestMapping(value="gameBoardInsert", method=RequestMethod.POST)
	public String gameboardInsert(HttpServletRequest req) {
		logger.info("GameBoardController.gameboardInsert 함수 진입 >>> : ");
		
		// 채번 구하기
		String gnum = ChabunUtil.getGameBoardChabun("GB", chabunService.getGameBoardChabun().getGnum());
		logger.info("GameBoardController gameboardInsert gnum >>> : " + gnum);
		
		// 이미지 업로드
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.G_BOARD_IMG_UPLOAD_PATH
											,CommonUtils.G_BOARD_IMG_FILE_SIZE
											,CommonUtils.G_BOARD_EN_CODE);
		
		// 이미지 파일 원본 사이즈
		boolean bool = fu.imgfileUpload(req);
		logger.info("BoardController boardInsert bool >>> : " + bool);
		
		// 채번, 이미지 업로드 성공하면 VO 세팅하기
		GameBoardVO _gvo = null;
		_gvo = new GameBoardVO();
		
		_gvo.setGnum(gnum);
		_gvo.setGnickname(fu.getParameter("gnickname"));
		_gvo.setGsubject(fu.getParameter("gsubject"));
		_gvo.setGcontents(fu.getParameter("gcontents"));
		_gvo.setGdivi(fu.getParameter("gdivi"));
		_gvo.setMno(fu.getParameter("mno"));
		_gvo.setRecom(fu.getParameter("recom"));
		_gvo.setUnrecom(fu.getParameter("unrecom"));
		_gvo.setPhoto(fu.getFileName("gfile"));
		
		logger.info("GameBoardController boardInsert _gvo.getGnum() >>> : " + _gvo.getGnum());
		logger.info("GameBoardController boardInsert _gvo.getGcontents() >>> : " + _gvo.getGcontents());
		logger.info("GameBoardController boardInsert _gvo.mno() >>> : " + _gvo.getMno());
		logger.info("GameBoardController boardInsert _gvo.getGPhoto() >>> : " + _gvo.getPhoto());
		int nCnt = gameBoardService.gameboardInsert(_gvo);
		
		if (nCnt > 0) {return "game/gameBoardInsert";}		
		return "game/gameBoardForm";
	}
	
	// 글 목록 페이징 조회
	@RequestMapping(value="gameboardSelectPaging", method=RequestMethod.GET)
	public String gameboardSelectPaging(GameBoardVO gvo, Model model) {
		logger.info("GameBoardController gameboardSelectPaging 함수 진입 >>> : ");
		
		logger.info("페이징 관련 로그 ======================================");
		
		// 페이징 변수 세팅
		int pageSize = CommonUtils.G_BOARD_PAGE_SIZE;
		int groupSize = CommonUtils.G_BOARD_GROUP_SIZE;
		int curPage = CommonUtils.G_BOARD_CUR_PAGE;
		int totalCount = CommonUtils.G_BOARD_TOTAL_COUNT;
		
		if(gvo.getCurPage() != null) {
			curPage = Integer.parseInt(gvo.getCurPage());
		}
		
		gvo.setPageSize(String.valueOf(pageSize));
		gvo.setGroupSize(String.valueOf(groupSize));
		gvo.setCurPage(String.valueOf(curPage));
		gvo.setTotalCount(String.valueOf(totalCount));
		
		logger.info("GameBoardController gameboardSelectPaging gvo.getPageSize() >>> : " + gvo.getPageSize());
		logger.info("GameBoardController gameboardSelectPaging gvo.getGroupSize() >>> : " + gvo.getGroupSize());
		logger.info("GameBoardController gameboardSelectPaging gvo.getCurPage() >>> : " + gvo.getCurPage());
		logger.info("GameBoardController gameboardSelectPaging gvo.getTotalCount() >>> : " + gvo.getTotalCount());
		
		GameBoardVO.printVO(gvo);
		
		List<GameBoardVO> listAll = gameBoardService.gameboardSelectPaging(gvo);
		logger.info("GameBoardController gameboardSelectPaging listAll.size() >>> : " + listAll.size());
		
		if (listAll.size() > 0) {
			for (int i=0; i < listAll.size(); i++ ) {
				GameBoardVO gbvo = (GameBoardVO)listAll.get(i);
				logger.info("listAll ::: gbvo.getPageSize() >>> : " + gbvo.getPageSize());
				logger.info("listAll ::: gbvo.getGroupSize() >>> : " + gbvo.getGroupSize());
				logger.info("listAll ::: gbvo.getCurPage() >>> : " + gbvo.getCurPage());
				logger.info("listAll ::: gbvo.getTotalCount() >>> : " + gbvo.getTotalCount());
			}
			
			model.addAttribute("pagingGVO", gvo);
			model.addAttribute("listAll", listAll);
			return "game/gameBoardSelectPaging";
		}
		
		return "game/gameBoardForm";
	}
	
	// 글 목록 조회
	@RequestMapping(value="gameboardSelectAll", method=RequestMethod.GET)
	public String gameboardSelectAll(GameBoardVO gvo, Model model) {
		logger.info("GameBoardController gameboardSelectAll 함수 진입 >>> : ");
		
		logger.info("검색 관련 로그 >>> : ======================================= ");
		logger.info("GameBoardController gameboardSelectAll gvo.getKeyfilter()" + gvo.getKeyfilter());
		logger.info("GameBoardController gameboardSelectAll gvo.getKeyword()" + gvo.getKeyword());
		logger.info("GameBoardController gameboardSelectAll gvo.getStartdate()" + gvo.getStartdate());
		logger.info("GameBoardController gameboardSelectAll gvo.getEnddate()" + gvo.getEnddate());
		
		List<GameBoardVO> listAll = gameBoardService.gameboardSelectAll(gvo);
		logger.info("GameBoardController gameboardSelectAll listAll.size() >>> : " + listAll.size());
		
		if(listAll.size() > 0) {
			model.addAttribute("listAll", listAll);
			return "game/gameBoardSelectAll";
		}
		
		return "game/gameBoardForm";
	}
	
	// 게시글 수정/삭제 글 조회
	@RequestMapping(value="gameboardSelect", method=RequestMethod.POST)
	public String gameboardSelect(GameBoardVO gvo, Model model) {
		logger.info("GameBoardController gameboardSelect 함수 진입 >>> : ");
		logger.info("GameBoardController gameboardSelect gvo.getGnum() >>> " + gvo.getGnum());
		
		List<GameBoardVO> listG = gameBoardService.gameboardSelect(gvo);
		logger.info("GameBoardController gameboardSelect listG.size() >>> ; " + listG.size());
		
		if (listG.size() == 1) {
			model.addAttribute("listG", listG);
			return "game/gameBoardSelect";
		}
		
		return "game/gameBoardForm";
	}
	
	// 게시글 수정하기
	@RequestMapping(value="gameboardUpdate", method=RequestMethod.POST)
	public String gameboardUpdate(GameBoardVO gvo, Model model) {
		logger.info("GameBoardController gameboardUpdate 함수 진입 >>> : ");
		
		logger.info("GameBoardController gameboardUpdate gvo.getGnum() >>> : " + gvo.getGnum());
		logger.info("GameBoardController gameboardUpdate gvo.getGcontents() >>> : " + gvo.getGcontents());
		int nCnt = gameBoardService.gameboardUpdate(gvo);
		logger.info("GameBoardController gameboardUpdate nCnt >>> : " + nCnt);
		
		if (nCnt > 0) {return "game/gameBoardUpdate";}
		return "game/gameBoardForm";
	}

	// 게시글 삭제하기
	@RequestMapping(value="gameboardDelete", method=RequestMethod.POST)
	public String gameboardDelete(GameBoardVO gvo, Model model) {
		logger.info("GameBoardController gameboardDelete 함수 진입 >>> : ");
		
		logger.info("GameBoardController gameboardDelete gvo.getGnum() >>> : " + gvo.getGnum());
		int nCnt = gameBoardService.gameboardDelete(gvo);
		logger.info("GameBoardController gameboardDelete nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "game/gameBoardDelete";}
		return "game/gameBoardForm";
	}
	
	/*
	
	// 로그인 체크하기 2021-12-03
	@RequestMapping(value="boardLoginCheck", method=RequestMethod.POST)
	@ResponseBody
	public Object boardLoginCheck(GameBoardVO gvo) {
		logger.info("GameBoardController boardLoginCheck 함수 진입 >>> : ");
		
		logger.info("GameBoardController boardLoginCheck gvo.getGnickname() >>> : " + gvo.getGnickname());
		logger.info("GameBoardController boardLoginCheck gvo.getMno() >>> " + gvo.getMno());
		
		List<GameBoardVO> list = gameBoardService.boardLoginCheck(gvo);
		logger.info("GameBoardController boardLoginCheck list.size() >>> " + list.size());
		
		String msg = "";
		if (list.size() == 1) {msg = "LOGIN_OK";}
		else {msg = "NO_LOGIN";}
		
		return msg;
	}
	*/
}
