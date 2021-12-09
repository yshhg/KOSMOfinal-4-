<%@page import="front.notices.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
   
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 전체조회</title>
<style type="text/css">
	* {
		margin: 0 auto;
		/*text-align: center;*/
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

	//체크박스 체크 확인하기 
	function checkOnly(chk){
		// alert(">>> : " + chk);
		var chkObj = document.getElementsByName("nnumCheck");
		console.log("chkObj >>> : " + chkObj);
		for (var i=0; i < chkObj.length; i++){
			if (chkObj[i] != chk){
				chkObj[i].checked = false;
			}
		}
	}
	
	$(document).ready(function(){	

		// 등록하기 
		$("#I").click(function(){			
			location.href='/Hoppies/notice/notice.html';			
		});
		
		// 전체조회
		$("#SALL").click(function(){			
			var isudType = document.noticeSelectAllForm.ISUD_TYPE.value = "SALL";			
			send(isudType);		
		});
		
		// 수정하기 
		$("#U").click(function(){			

			var nCnt = chkInfo();			
			if (nCnt == 0){	
				console.log('체크박스를 체크하세요');
				alert('체크박스를 체크하세요');
			}else{					// jQuery 버전 
				var v1 = $("#ISUD_TYPE").val('U');
				alert(v1.val());
				send(v1);				
			}			
		});
		
	
		// 삭제하기 
		$("#DOK").click(function(){			
			
			var nCnt = chkInfo();
			if (nCnt == 0){	
				console.log('체크박스를 체크하세요');
				alert('체크박스를 체크하세요');
			}else{				
				// jQuery 버전 
				var v2 = $("#ISUD_TYPE").val('DOK');
				alert("공지사항을 삭제하시겠습니까? " + v2.val());
				send(v2);
			}					
		});
		
		// 체크박스 체크 카운트
		function chkInfo(){			
			var obj = document.getElementsByName("nnumCheck");
			var nCnt = 0;			
			for(var i=0; i < obj.length; i++){ 
	          	if (obj[i].checked == true){ 
	          		nCnt++;
	          	}		          			            
	        }			
			console.log(nCnt);			
			return nCnt;
		}
		
		// submit 
		function send(isudType){
			alert(isudType);
			
			$("#noticeSelectAllForm").attr({
				"action":"/Hoppies/notice?ISUD_TYPE="+isudType,
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		}
	});

</script>	
</head>
<% request.setCharacterEncoding("UTF-8");%> 
SELECT ALL
<%
	Object obj = request.getAttribute("aListAll");
	if (obj == null) return;
	
	ArrayList<NoticeVO> aList = (ArrayList<NoticeVO>)obj;
	int nCnt = aList.size();
	out.println("전체 조회 건수  " + nCnt + " 건");	
%>
<table>
<tr>
<td calspan="2">
<font size="4" color="blue">
	<img src="/Hoppies/img/img_mando/ase.gif" width="25" height="25" alter="image">
	NOTICE TEST
</font>
</td>
</tr>
</table>
<hr>
<hr>
<form name="noticeSelectAllForm" id="noticeSelectAllForm">
<table border="1">
<thead>
<tr>
	<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
	<td class="tt">순번</td>
	<td class="tt">번호</td>
	<td class="tt">글제목</td>
	<td class="tt">내용</td>
	<td class="tt">사진</td>
	<td class="tt">삭제여부</td>
	<td class="tt">등록일</td>
	<td class="tt">수정일</td>
</tr>
</thead>
<%
	for(int i=0; i<nCnt; i++){
		
		NoticeVO nvo = aList.get(i);

%>					
<tbody>
<tr>
	<td class="tt">
		<input type="checkbox" id="nnumCheck" name="nnumCheck" value=<%= nvo.getNnum() %> onclick="checkOnly(this)">
	</td>		
	<td class="tt"><%= i + 1 %></td>
	<td class="tt"><%= nvo.getNnum() %> </td>
	<td class="tt"><%= nvo.getNsubject() %> </td>
	<td class="tt"><%= nvo.getNmemo() %> </td>
	<td class="tt"><img src="/Hoppies/fileupload/notice/<%= nvo.getNphoto() %> " border="1" width="25" height="25" alt="image"></td>
	<td class="tt"><%= nvo.getDeleteyn() %> </td>		
	<td class="tt"><%= nvo.getnInsertdate() %> </td>
	<td class="tt"><%= nvo.getnUpdatedate() %> </td>		
</tr>	
<%
	}//end of if
%>						
<tr>
	<td colspan="9" align="right">
		<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">			
		<input type="button" value="등록" id="I">s
		<input type="button" value="조회" id="SALL">
		<input type="button" value="수정" id="U">
		<input type="button" value="삭제" id="DOK">									
	</td>
</tr>	
</tbody>			
</table>
</form>		
</body>
</html>

