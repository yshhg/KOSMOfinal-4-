<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="front.notices.vo.NoticeVO" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 > 상세보기</title>
		
		<style>
			th, td {
				width: 700px;
				border: 1px solid black;
				text-align:left;
				line-height:1.5;
			}
			table {
				width:600px;
			}
			.all{
				width:1200px;
				margin : 50px 250px 50px 250px;
				
			}
			.wrap {
				width : 630px;
				align : center;
				border : 5px;
				margin : 10px auto;
			}
			.listBtn {
				width: 
				align: center;
			}
			.forWriter{
				margin: 10px auto;
			}
		
		</style>
	
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function(){
				
				// 목록 버튼 클릭
				$("#listBtn").on("click", function(){
					$("#noticeDetail").attr({
						"action":"noticeList.k",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					});
					
					$("#noticeDetail").submit();
				});
				
				// 수정 버튼 클릭
				$(document).on("click", "#updateBtn", function(){
					
					var v1 = $("#no_num").val();
					
					$("#noticeDetail").attr({
						"action":"noticeUpdateForm.k?no_num="+v1,
						"method":"POST",
						"enctype":"multipart/form-data"
					}).submit();
				});
				
				// 삭제 버튼 클릭
				$(document).on("click", "#deleteBtn", function(){
					var v1 = $("#no_num").val();
					$("#noticeDetail").attr({
						"action":"noticeDelete.k?no_num="+v1,
						"method":"POST",
						"enctype":"multipart/form-data"
					}).submit();
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
		
		<form id="noticeDetail" method="POST">
			<div class="all">
				<table>
					<input type="hidden" id="Nnum" name="Nnum" value="<%=nvo.getNnum() %>" />
					<input type="hidden" name="Nnum" value="<%=nvo.getNnum() %>" />
					
					<tr>
						<td colspan="1">제목</td>
						<td colspan="3">
							<input name="Nsubject" value="<%= nvo.getNsubject() %>" size="50" readonly />
						</td>
					</tr>
					<tr>
						
						<td>등록일</td>
						<td>
							<input name="Ninsertdate" value="<%= nvo.getnInsertdate() %>" readonly />
						</td>
					</tr>
					<tr>
						<td colspan="5">
							<textarea name="Nmemo" id="Nmemo" rows="10" cols="88" readonly>
								<%= nvo.getNmemo() %>
							</textarea>
						</td>
					</tr>
					
				</table>

				<div class="wrap">
					<div class="listBtn">
						<button type="button" id="listBtn">목록</button>
					</div>
				
					<div class="forWirter">
						<button type="button"id="updateBtn">수정</button>
						<button type="button"id="deleteBtn">삭제</button>
					</div>
				
				</div>
			</div>
		</form>
	</body>
</html>