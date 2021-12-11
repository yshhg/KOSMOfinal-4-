<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ page import="front.gameboard.vo.GameBoardVO" %> 
<%@ page import="java.util.List" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드 선택</title>
<style type="text/css">
	div {
			margin: 50px 0px 0px 100px;
		}
	.mem{ text-align: center;}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		// 로그인 확인
		$(document).on("click", "#lgbtn", function(){
			alert("lgbtn >>> : ");

			let lgcheckURL = "boardLoginCheck.s";
			let reqType = "POST";
			let dataParam = {
				sbnum: $("#mno").val(),
				sbpw: $("#gnickname").val(),
			};
			//dataParam = $("#boardUpdateForm").serialize();
			//alert("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: lgcheckURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess,
				error: whenError
			});
			
			function whenSuccess(resData){	
				alert("resData >>> : " + resData);
				if ("LOGIN_OK" == resData){
					alert("로그인 확인.");
					$("#mno").attr("readonly", true);	
					$("#U").css('background-color','yellow');
					$("#D").css('color','red');
				}else if ("NO_LOGIN" == resData){
					alert("로그인 되지 않음.");
					$("#mno").val('');
					$("#mno").focus();
				};				
			}
			function whenError(e){
				alert("e >>> : " + e.responseText);
			}
		});
	
		//  U
		$(document).on("click", "#U", function(){
			//alert("U >>> : ");		
			$("#gameboardUpdateForm").attr({ "method":"POST"
				                        ,"action":"gameboardUpdate.s"}).submit();
		});
		//  D
		$(document).on("click", "#D", function(){
			//alert("D >>> : ");
			$("#gameboardUpdateForm").attr({ "method":"POST"
				                        ,"action":"gameboardDelete.s"}).submit();
		});
	});
</script>	
</head>
<body>
글 수정하기
<hr>
<% request.setCharacterEncoding("UTF-8");%> 
<%
	Object obj = request.getAttribute("listG");
	List<GameBoardVO> list = (List)obj;
	GameBoardVO gvo = null;
	if (list.size() == 1) {
		gvo = list.get(0);
	};
%>
<div>
<form name="gameboardUpdateForm" id="gameboardUpdateForm">
<table border=1>
<tr>
<td colspan="2" align="center">게시판 글수정하기</td>
</tr>
<tr>
<td class="mem">글번호</td>
<td><input type="text" name="gnum" id="gnum" value="<%= gvo.getGnum() %>" readonly/></td>
</tr>

<tr>
<td class="mem">제목</td>
<td>
<input type="text" name="gsubject" id="gsubject" value="<%= gvo.getGsubject() %>" style="width:100px"  readonly/>
</td>
</tr>
<tr>
<td class="mem">닉네임</td>
<td><input type="text" name="gnickname" id="gnickname" value="<%=  gvo.getGnickname() %>" readonly/></td>
</tr> 
<tr>
<td class="mem">글내용</td>
<td>
<textarea name="gcontents" id="gcontents" rows="5" cols="50"><%= gvo.getGcontents() %>					
</textarea>
</td>
</tr>
<tr>
<td class="mem">회원번호</td>
<td>
<input type="text" name="mno" id="mno" value="<%= gvo.getMno() %>" readonly/></td>
<td class="mem">등록일</td>
<td> 
<input type="text" name="insertdate" id="insertdate" value="<%= gvo.getInsertdate() %>" readonly />		      
</td>	 
<td class="mem">수정일</td>
<td> 
<input type="text" name="updatedate" id="updatedate" value="<%= gvo.getUpdatedate() %>" readonly />		      
</td>
</tr>
<tr> 	 
<tr>
<td colspan="2" align="right"> 		
<button type="button" id="U">수정</button>
<button type="button" id="D">삭제</button>
</td>				
</tr>
</table>
</form>
</div>
</body>
</html>