<%@page import="front.notices.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
 
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>공지사항 조건조회</title>
<style type="text/css">
	* {
		margin: 0 auto;
		/*text-align: center;*/
	}
	
	div {
		margin: 50px 0px 0px 100px;
	}			

	td, th {
		 padding: 5px;
	}
	
	.tt {
		text-align: center;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	function noticeUpdate(actionUpdate){
		console.log("noticeUpdate 진입 >>> : " + actionUpdate);
				
		if ('U' == actionUpdate){
			var v1 = "UOK";		
			document.noticeUpdateForm.action="/testKosmo/notice?ISUD_TYPE="+v1;			
		}
		
		if ('D' == actionUpdate){
			var v2 = "DOK";
			document.noticeUpdateForm.action="/testKosmo/notice?ISUD_TYPE="+v2;
		}
		
		document.noticeUpdateForm.method="POST";
		document.noticeUpdateForm.enctype="application/x-www-form-urlencoded";
		document.noticeUpdateForm.submit();		
	}
	
	function checkAction(actionName){
		console.log("진입 " + actionName);
		
		if ('I' == actionName){	
			location.href="/Hoppies/notice/notice.html";
		}
		if ('SALL' == actionName){			
			location.href="/testKosmo/notice?ISUD_TYPE=SALL";
		}
	}	
</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT 

<%
	Object obj = request.getAttribute("aListS");
	if (obj == null) return;
	
	ArrayList<NoticeVO> aList = (ArrayList<NoticeVO>)obj;
	int nCnt = aList.size();
	out.println("조건 조회 " + nCnt + " 건");
	
	String nnum = "";
	String nsubject = "";		
	String nmemo = "";
	String nphoto = "";
	String deleteyn = "";
	String insertdate = "";
	String updatedate = "";	
	
	if (nCnt == 1){
		NoticeVO nvo = aList.get(0);
		
		nnum = nvo.getNnum();
		nsubject = nvo.getNsubject();
		nmemo = nvo.getNmemo();
		nphoto = nvo.getNphoto();
		deleteyn = nvo.getDeleteyn();
		insertdate = nvo.getnInsertdate();
		updatedate = nvo.getnUpdatedate();		
	}
%>
<hr>
<div>
<form name="noticeUpdateForm" id="noticeUpdateForm">
<table border="1">
<tr>	
	<td colspan="2" align="center">	
					
		<font size="4" style="color:blue;">공지사항 수정</font> 
		<img src="/Hoppies/img/img_mando/ase.gif" width="25" height="25" alt="image">		
	</td>				
</tr>
<tr>
	<td class="tt">글번호</td>
	<td><input type="text" name="nnum" id="nnum" size="20"  value="<%= nnum %>" readonly></td>
</tr>
<tr>
	<td class="tt">제목</td>
	<td><input type="text" name="nsubject" id="nsubject" value="<%= nsubject %>" size="55"></td>
</tr>
<tr>
	<td  class="tt">내용</td>
	<td>
	<textarea name="nmemo" id="nmemo" cols="50" rows="10"><%= nmemo %></textarea>
</td>
</tr>
<tr>
	<td  class="tt">사진</td>
	<td>
	<img src="/Hoppies/fileupload/notice/<%= nphoto %>" border="1" width="40" height="50" alt="image">		
</td>
</tr>
<tr>
	<td colspan="2" align="center">	
	<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" >
	<input type="button" value="수정" onclick="noticeUpdate('U')"/>
    <input type="reset" value="취소" />
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="입력" onclick="checkAction('I')"/>
	<input type="button" value="목록" onclick="checkAction('SALL');">
</td>	
<tr>			
</table>
</form>
</div>
</body>
</html>