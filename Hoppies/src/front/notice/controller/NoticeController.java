package front.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import front.common.CommonUtils;
import front.common.FileUploadUtil;
import front.notice.service.NoticeService;
import front.notice.service.NoticeServiceImpl;
import front.notice.vo.NoticeVO;



@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=\"UTF-8");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("ISUD_TYPE");	
		
		if (isudType !=null && isudType.length() > 0){
			isudType = isudType.toUpperCase();
			
		
			if ("I".equals(isudType)){
				
				
                boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");				
				if (bool){
					
					
					String filePaths = CommonUtils.NOTICE_IMG_UPLOAD_PATH;
	                int size_limit = CommonUtils.NOTICE_IMG_FILE_SIZE;
	                String  encode_type = CommonUtils.NOTICE_IMG_ENCODE;
					
					FileUploadUtil fu = new FileUploadUtil();					
					boolean bFile = fu.fileUpldad3(request, filePaths, size_limit, encode_type);
					
					if (bFile){
						
						
						NoticeService ns = new NoticeServiceImpl();
						NoticeVO nvo = null;
						nvo = new NoticeVO();
						
						String nnum = GetChabun.getNoticeChabun("d");
						
						
						
						nvo.setNnum(nnum);
					
						nvo.setNsubject(fu.getParameter("nsubject"));
						
						nvo.setNmemo(fu.getParameter("nmemo"));						
					
						ArrayList<String> aFileName = fu.getFileNames();
						String nphoto = aFileName.get(0);				
						nvo.setNphoto(nphoto);
						
					
						
						NoticeVO.printlnNoticeVO(nvo);
					
						int nCnt = ns.noticeInsert(nvo);
						if (nCnt > 0){						
							request.setAttribute("nCnt", new Integer(nCnt));				
							RequestDispatcher rd = request.getRequestDispatcher("/front/notice/noticeInsert.jsp");
							rd.forward(request, response);						
						}else{
							out.println("<script>");				
							out.println("location.href='/front/notice/notice.html'");
							out.println("</script>");
						}
					
					}else{
						
					}	
				}				
			} 
			
			
			if ("SALL".equals(isudType)){
				
				
				
				NoticeService ns = new NoticeServiceImpl();
				ArrayList<NoticeVO> aListAll = ns.noticeSelectAll();
				
				if (aListAll !=null && aListAll.size() > 0) {
					
					request.setAttribute("aListAll", aListAll);					
					RequestDispatcher rd= request.getRequestDispatcher("/front/notice/noticeSelectAll.jsp");
					rd.forward(request, response);
					
				}else {
					out.println("<script>");					
					out.println("location.href='/front/notice?ISUD_TYPE=SALL'");
					out.println("</script>");
				}		
			} 
			
		
			if ("S".equals(isudType) || "U".equals(isudType)){
				

				String nnum = request.getParameter("nnumCheck");				
				if (nnum !=null && nnum.length() > 0){
					
					
				
					NoticeService ns = new NoticeServiceImpl();
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					
					nvo.setNnum(nnum);					
					ArrayList<NoticeVO> aListS = ns.noticeSelect(nvo);
					
					if (aListS !=null && aListS.size() > 0) {
						System.out.println("aListS.size() >>> : " + aListS.size());						
						request.setAttribute("aListS", aListS);					
						RequestDispatcher rd= request.getRequestDispatcher("/front/notice/noticeSelect.jsp");
						rd.forward(request, response);
						
					}else {
						out.println("<script>");
						
						out.println("location.href='/front/notice?ISUD_TYPE=SALL'");
						out.println("</script>");
					}									
				}else{
					
				}		
			}
			
			
			if ("UOK".equals(isudType)){
			
				
				String nnum = request.getParameter("nnum");
				String nsubject = request.getParameter("nsubject");
				String nmemo = request.getParameter("nmemo");				
				
				
				
				NoticeService ns = new NoticeServiceImpl();
				NoticeVO nvo = null;
				nvo = new NoticeVO();
				
				nvo.setNnum(nnum);
				nvo.setNsubject(nsubject);
				nvo.setNmemo(nmemo);
				
				int nCnt = ns.noticeUpdate(nvo);
				
				if (nCnt > 0) {
									
					request.setAttribute("nCnt", new Integer(nCnt));										
					RequestDispatcher rd= request.getRequestDispatcher("/front/notice/noticeUpdate.jsp");
					rd.forward(request, response);
					
				}else {
					
					out.println("<script>");	
					
					out.println("location.href='/front/notice?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}			
			
			
			if ("DOK".equals(isudType)){
				
				
			
				String nnum = request.getParameter("nnumCheck");				
				if (nnum !=null && nnum.length() > 0){
					
					
				
					NoticeService ns = new NoticeServiceImpl();
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					
					nvo.setNnum(nnum);
					int nCnt = ns.noticeDelete(nvo);
					
					if (nCnt > 0) {
									
						request.setAttribute("nCnt", new Integer(nCnt));										
						RequestDispatcher rd= request.getRequestDispatcher("/Hoppies/notice/noticeDelete.jsp");
						rd.forward(request, response);
						
					}else {
						
						
					}
				}else{
					
				}	
			}	
			
		
			if ("NOTICE".equals(isudType)){
				

				String nnum = "NB202109240005";				
				if (nnum !=null && nnum.length() > 0){
					
					
					
					NoticeService ns = new NoticeServiceImpl();
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					
					nvo.setNnum(nnum);					
					ArrayList<NoticeVO> aListS = ns.noticeSelect(nvo);
					
					if (aListS !=null && aListS.size() > 0) {
											
						request.setAttribute("aListS", aListS);					
						RequestDispatcher rd= request.getRequestDispatcher("/front/notice/noticePopup.jsp");
						rd.forward(request, response);
						
					}else {
						
					}									
				}else{
					
				}		
			}
		}else{
			
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
