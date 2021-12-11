<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="front.notices.vo.NoticeVO" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 > 수정</title>
	
	<style>
		table, th, td {
				border:1px solid black;
				text-align:left;
				line-height:1.5;
				margin:auto;
		}
	</style>
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
			
		$(document).ready(function(){
			
			// 수정 버튼 클릭.
			$(document).on("click", "#updBtn", function(){
				
				var no_num = $("#no_num").val();
				console.log("updBtn");
				// notice(element)의 속성값을 가져오거나 추가 
				$('#noticeUpdateForm').attr({
					'action':'noticeUpdate.k?no_num='+no_num,
					'method':'POST',
					// 파일 넘길 때 필요
					'enctype':'multipart/form-data'
				}).submit();
			});
			
			// 목록 버튼 클릭.
			$("#listBtn").on("click", function(){
				$("#noticeUpdateForm").attr({
					'action':'noticeList.k',
					'method':'POST',
					'enctype':'multipart/form-data'
				});
				
				$("#noticeUpdateForm").submit();
			});
			
		});
			
	</script>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<%
		NoticeVO nvo = null;
		Object obj = request.getAttribute("listS");
		nvo = (NoticeVO)obj;
		System.out.println("뷰에서 선택한 글 번호 : " + nvo.getNnum());
	%>
	<div>
		<form name="noticeUpdateForm" id="noticeUpdateForm" method="POST">
				<input type="hidden" id="no_num" name="no_num" value="<%=nvo.getNnum() %>">
				<table>
					<tr>
						<td>제목</td>
						<td>
							<input type="text" name="nsubject" size="12" value="<%= nvo.getNsubject() %>" />
						</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>
							<input type="text" name="Nnum" id="Nnum" size="53" value="<%= nvo.getNnum() %>" readonly />
						</td>
					</tr>
					
					<!-- 내용 -->
					<tr>
						<td colspan="2">
							<textarea name="nmemo" id="nmemo" cols="50" rows="10"><%= nvo.getNmemo() %></textarea>
						</td>
					</tr>
				</table>
				<div style="text-align:center; margin-top: 10px;">
					<input type="button" id="updBtn" value="수정" />
					<input type="button" id="listBtn" value="목록" />
				</div>
		</form>
	</div>
</body>
</html>