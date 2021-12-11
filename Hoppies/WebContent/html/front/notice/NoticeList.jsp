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
<th class="tt" width="60" title="삭제여부">삭제여부</th>
<th class="tt" width="30" title="등록일">등록일</th>
<th class="tt" width="40" title="수정일">수정일</th>
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
</table>
</form>
<h1 align='center'>공지 사항</h1>
<table align='center' border='1' width='80%'>
	<tr height='10' align='center' bgcolor='lightgreen'>
		<td>번호</td>
		<td>작성자</td>
		<td>제목</td>
		<td>작성일</td>
	</tr>
	<c:choose>
		<c:when test='${boardList == null}'>
			<td colspan="4">
				<p align="center">
					<b><span style='font-size=9pt;'>등록된 글이 없습니다.</span></b>
				</p>
			</td>
		</c:when>
		
		<c:when test="${boardList != null }">
			<c:forEach var="post" items="${boardList }" varStatus="postNum">
			<tr align="center">
				<td width="5%">${post.bno}</td>
				<td width="10%">${post.id }</td>
				<td align='left' width="35%">
				<span style='padding-right:30px'></span>
			<c:choose>
				<c:when test="${post.level > 1 }">
					<c:forEach begin="1" end="${post.level }">
						<span style='padding-left:20px'></span>
					</c:forEach>
					<span style='font-size:12px;'>[답변]</span>
					<a class="cls1" href='/board/post?no=${post.bno }'>${post.title }</a>
				</c:when>
				
				<c:otherwise>
					<a class='cls1' href='/board/post?no=${post.bno }'>${post.title }</a>
				</c:otherwise>
			</c:choose>
			</td>
			<td width="10%">
				<fmt:formatDate value="${post.regdate }"/>
			</td>
			</tr>
			</c:forEach>
		</c:when>
	</c:choose>
  
  <!-- 페이징 처리 부분 -->
	<td colspan="4">
	<p align="center"><b><span style='font-size=9pt;'>
	<c:if test="${page.prev }">
		<a href="/board/list?page=${page.startPage -1 }">이전 페이지</a>
	</c:if>
&nbsp;<c:forEach var="num" begin="${page.startPage }" end="${page.endPage }">
			<a href="/board/list?page=${num }">${num }</a> &nbsp;
	</c:forEach>
	<c:if test="${page.next }">
		<a href="/board/list?page=${page.endPage + 1 }">다음 페이지</a>
	</c:if>
	</span></b>
	</p>
	</td>
<!--End Paging -->
  </table>
  
<a class='cls1' href="/html/front/notice/NoticeForm.jsp"><p class='cls2'>글쓰기</a>


</body>
</html>