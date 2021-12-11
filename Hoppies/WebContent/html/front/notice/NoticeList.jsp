<%@page import="java.util.List"%>
<%@page import="front.notices.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 전체 리스트</title>
<style>
.cls1 {
	text-decoration:none;
}

.cls2 {
	text-align:center;
	font-size:30px;
}
</style>

</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<%
//페이지 세팅
int pageSize = 0;
int groupSize = 0;
int curPage = 0;
int totalCount = 0;

Object objPaging = request.getAttribute("pagingNvo");
NoticeVO pagingNvo = (NoticeVO)objPaging;

Object objList = request.getAttribute("listAll");
if(objList == null)
	return;
List<NoticeVO> list = (List<NoticeVO>)objList;
System.out.println("noticeList.jsp >>> : " + list.size());

if(list.size() > 0){
	
}

%>

<form method="POST" id="noticeList">
<!--  전체묶음-->
<div style="width:1200px; margin:0 auto;">
<h2>공지사항</h2>
<% String Nnum = (String)session.getAttribute("Nnum"); %>
<hr>
	<%=Nnum %> 관리자 로그인 중입니다.
	<!-- 상단 레이아웃 -->
	<div>
	<!-- 왼쪽 게시물 개수 -->
	<div style="float:left; width:50%">전체 <span><%=list.size() %></span>건</div>
	
	<!-- 오른쪽 게시물 개수  -->
	<div style="float:right; width:50% text-align:right; margin-bottom:10px;">
	<select name="searchType" Nnum="searchTyple">
	<option value="Nsubject" selected>제목</option>
	<option value="Nmemo">내용</option>
	</select>
	<!-- 검색값을 받음 -->
	<input type="text" Nsubject="keyword" placeholder="검색어 입력"/>
	<!-- 검색 버튼 -->
	<input type="button" id=searchBtn" value="조회"/>
	</div>
</div>

<!-- 공지사항 목록 -->
<table id="NoticeList" style="margin:0 auto; width:1200px;" summary='공지사항 첫 화면: 공지사항 목록'>
<thead>
<tr>
<th class="tt" width="40" title="공지글번호">공지글번호</th>
<th class="tt" width="450" title="공지글제목">공지글제목</th>
<th class="tt" width="80" title="공지글본문">공지글본문</th>

</tr>
</thead>

<%
for(int i=0; i < list.size(); i++){
	NoticeVO nvo = list.get(i);
	System.out.println("loop(ing..)index : " + (i+1));
	System.out.println("nvo.getNnum() >>> : " + nvo.getNnum());
	
	//페이징
	pageSize = Integer.parseInt(pagingNvo.getPageSize());
	groupSize = Integer.parseInt(pagingNvo.getGroupSize());
	curPage = Integer.parseInt(pagingNvo.getCurPage());
	totalCount = Integer.parseInt(nvo.getTotalCount());
}
%>


<tfoot>
						<tr>
							<td colspan="10">
								<jsp:include page="NoticePaging.jsp" flush="true">
									<jsp:param value="noticeList.k" name="url"/>
									<jsp:param value="" name="str"/>
									<jsp:param value="<%=pageSize %>" name="pageSize"/>
									<jsp:param value="<%=groupSize %>" name="groupSize"/>
									<jsp:param value="<%=curPage %>" name="curPage"/>
									<jsp:param value="<%=totalCount %>" name="totalCount"/>
								</jsp:include>
							</td>
						</tr>
					</tfoot>
</table>
</form>

 
  
<a class='cls1' href="/html/front/notice/NoticeForm.jsp"><p class='cls2'>글쓰기</a>


</body>
</html>