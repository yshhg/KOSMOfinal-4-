<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="front.gameboard.vo.GameBoardVO" %> 
<%@ page import="java.util.List" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 게시판</title>
<style type="text/css">
	.tt{
		text-align: center;
		font-weight: bold;
	}
</style> 
<link rel="stylesheet" href="../../../common/datepiker/jquery-ui-1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="../../../common/datepiker/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){			
		/*
			CSS 선택자 우선순위 점수
			직접기입  : styl='' : 1000 점 
			id : #sbnum : 100점
			class : .sbnum : 10점
			속성 : [name="sbnum"] : 10점
		*/
		// sbnum
		$(document).on("click", "#gnum", function(){
			//alert("chkInSbnum >>> : ");		
			if($(this).prop('checked')){			 
				//$('input[type="checkbox"][name="sbnum"]').prop('checked',false);
				$('.gnum').prop('checked',false);
				$(this).prop('checked',true);
			}
		});
			
		// 검색버튼
		//  U
		$(document).on("click", "#searchBtn", function(){
			alert("searchBtn >>> : ");			
			$("#gameboardList").attr({ "method":"GET"
				                  ,"action":"/front/game/gameboardSelectAll.s"}).submit();
		});
		// datepicker : from ~ to 기간조회
		$("#startdate").datepicker({		
			showOn: "button",    // 달력을 표시할 타이밍 (both: focus or button)
			buttonImage: "/img/cal_0.gif", 
			buttonImageOnly : true,            
			buttonText: "날짜선택",             
			dateFormat: "yy-mm-dd",             
			changeMonth: true,                  			
			onClose: function(selectedDate) {    
				$("#enddate").datepicker("option", "minDate", selectedDate);
			}                
		});		
		$("#enddate").datepicker({
			showOn: "button", 
			buttonImage: "/img/cal_0.gif", 
			buttonImageOnly : true,
			buttonText: "날짜선택",
			dateFormat: "yy-mm-dd",
			changeMonth: true,			
			onClose: function(selectedDate) {	
				$("#startdate").datepicker("option", "maxDate", selectedDate);
			}               
		});			
		
		//  I
		$(document).on("click", "#I", function(){
			//alert("I >>> : ");
			location.href="/front/game/gameBoardForm.s";
		});
		//  U
		$(document).on("click", "#U", function(){
			// alert("U >>> : ");	
			if ($('.gnum:checked').length == 0){
				alert("수정할 글 번호 하나를 선택해주세요");
				return;
			}
			 $("#gameboardList").attr({ "method":"POST"
				                   ,"action":"/front/game/gameBoardSelect.s"}).submit();
		});
		//  D
		$(document).on("click", "#D", function(){
			//alert("D >>> : ");	
			if ($('.gnum:checked').length == 0){
				alert("삭제할 글 번호 하나를 선택해주세요");
				return;
			}
			$("#gameboardList").attr({ "method":"POST"
				                  ,"action":"/front/game/gameBoardDelete.s"}).submit();
		});
		
		$(document).on("click", "#R", function(){
			if ($('.gnum:checked').length == 0){
				alert("추천할 글 번호 하나를 선택해주세요")
				return;
			}
			$("#gameboardList").attr({ "method":"GET"
									,"action":"BoardRecom"}).submit();	
		})
	});

</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
<%

	Object obj = request.getAttribute("listAll");
	List<GameBoardVO> list = (List)obj;
	
	int nCnt = list.size();
	System.out.println("nCnt >>> : " + nCnt);	
%>
<form name="gameboardList" id="gameboardList">
<table border="1" align="center">
<thead>
<tr>
	<td colspan="10" align="center">
		<h2>게시판</h2>
	</td>
</tr>
<tr>
<td  colspan="10" align="left">
<select id="keyfilter" name="keyfilter">
	<option value="key1">제목</option>
	<option value="key2">내용</option>
	<option value="key3">제목+내용</option>
	<option value="key4">닉네임</option>
	<option value="key5">유저번호</option>
</select>
<input type="text" id="keyword" name="keyword" placeholder="검색어 입력"><br>
<input type="text" id="startdate" name="startdate" size="12" placeholder="시작일 ">
~ <input type="text" id="enddate" name="enddate" size="12" placeholder="종료일">
<button type="button" id="searchBtn">검색</button>
</td>
</tr>
<tr>
	<td class="tt">체크</td>
	<td class="tt">글번호</td>
	<td class="tt">닉네임</td>
	<td class="tt">제목</td>		
	<td class="tt">내용</td>
	<td class="tt">분류</td>
	<td class="tt">유저번호</td>
	<td class="tt">최종작성일</td>
</tr>
</thead>
<%
for(int i=0; i<nCnt; i++){		
	GameBoardVO gvo = list.get(i);	
	
%>					
<tbody>
<tr>
	<td align="center">
		<input type="checkbox" name="gnum" id="gnum" class="gnum" value=<%= gvo.getGnum() %> >
	</td>		
	<td class="tt"><%= gvo.getGnum() %> </td>
	<td class="tt"><%= gvo.getGnickname() %> </td>
	<td class="tt"><a href="<%= gvo.getGnum() %>"><%= gvo.getGsubject() %></a></td>
	<td class="tt"><%= gvo.getGcontents() %> </td>
	<td class="tt"><%= gvo.getGdivi() %> </td>
	<td class="tt"><%= gvo.getMno() %> </td>
	<td class="tt"><%= gvo.getUpdatedate() %> </td>
</tr>	
<%
}//end of for
%>						
<tr>
	<td colspan="7" align="right">		
		<input type="button" value="글쓰기" id='I'>	
		<input type="button" value="글수정" id='U'>
		<input type="button" value="글삭제" id='D'>		
		<input type="button" value="추천" id='R'>					
	</td>
</tr>	

</tbody>			
</table>
</form>	
</body>
</html>