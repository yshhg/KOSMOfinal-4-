<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">

	.div1{
		background: lightblue;
		border: 1px solid red;	
		width: 450px;		
		margin: 100px auto;	
	}
		
	.align{
		text-align: center;
	}

</style>
<!-- 제이쿼리 CDN -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		//폼태그 데이터 JSP 보내기 
		$("#noticeBtn").click(function(){
			alert();
			console.log();
			
			var v1 = $("#ISUD_TYPE").val();
			alert("v1 >>> : " + v1);
			
			
			// attr() vs prop()
			$("#noticeWrite")
			.attr({
					"action":"/testKosmo/notice?ISUD_TYPE="+v1,
				    "method":"POST",
				    "enctype":"multipart/form-data"
			       })
			.submit();	
		});		
	});
</script>	
</head>
<body>
<div class="div1">
<form name="noticeWrite" id="noticeWrite">
<table border="1">
	<tr>	
		<td colspan="2" class="align">	
						
			<font size="4" style="color:blue;">공지 사항</font> 
			<img src="Hoppies/img/img_mando/ase.gif" width="25" height="25" alt="image">		
		</td>				
	</tr>
	<tr>
		<td class="align">글번호</td>
		<td><input type="text" name="nnum" id="nnum" size="20" readonly></td>
	</tr>
	<tr>
		<td class="align">제목</td>
		<td><input type="text" name="nsubject" id="nsubject" size="49"></td>
	</tr>		
	<tr>
		<td class="align">내용</td>
		<td>
		<textarea name="nmemo" id="nmemo" cols="51" rows="10"></textarea>
	</td>
	</tr>
	<tr>
		<td class="align">사진</td>
		<td>
		<input type="file" name="nphoto" id="nphoto">
	</td>
	</tr>	
	<tr>
		<td colspan="2" class="align">	
		<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="I">					
		<button type="button" id="noticeBtn">
			<img src="/Hoppies/img/img_mando/ase.gif" width="25" height="25" alt="image">	
			보내기
		</button>	
		<button type="reset">
			<img src="/Hoppies/img/img_mando/b-baa.gif" width="25" height="25" alt="image">	
			다시
		</button>
	</td>				
	</tr>
</table>
</form>
</div>
</body>
</html>