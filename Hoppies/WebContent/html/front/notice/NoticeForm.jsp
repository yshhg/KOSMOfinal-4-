<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 입력 </title>
<style type="text/css">

	.div1{
		background:white ;
		border: 1px;	
		width: 450px;		
		margin: 100px auto;	
	}
		
	.align{
		text-align: center;
	}

</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(document).on("click", "#sbbtn", function(){
			console.log("sbbtn >>> : ");
			$('#NoticeForm').attr({
				'action':'NoticeInsert.s',
				'method':'POST',
				'enctype':'multipart/form-data'
			}).submit();
		})
	})
</script>
</head>
<body>
<div class="div1">
<form name="noticeWrite" id="noticeWrite">
<table border="1">
	<tr>	
		<td colspan="2" class="align">
						
			<font size="10" style="color:black;">NOTICE</font> 
				
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
			
			보내기
		</button>	
		<button type="reset">
		
			다시
		</button>
	</td>				
	</tr>
</form>
</body>
</html>