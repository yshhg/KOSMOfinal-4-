<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 게시판 - 글쓰기 </title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(document).on("click", "#sbbtn", function(){
			console.log("sbbtn >>> : ");
			$('#boardForm').attr({
				'action':'gameboardInsert.s',
				'method':'POST',
				'enctype':'multipart/form-data'
			}).submit();
		})
	})
</script>
</head>
<body>
<form name="gameboardForm" id="gameboardForm">
<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">게임 게시판 글쓰기</td>
	</tr>
	<tr>
		<td align="center">글번호</td>
		<!-- readonly을 사용해서 sbnum를 사용할 수 없게 만든다.-->
		<td><input type="text" name="gnum" id="gnum" size="20" readonly></td>
	</tr>
	<tr>
		<td  align="center">닉네임</td>
		<td><input type="text" name="gnickname" id="gnickname" size="53"></td>
	</tr>
	<tr>
		<td align="center">제목</td>
		<td><input type="text" name="gsubject" id="gsubject" size="53"></td>
	</tr>
	<tr>
		<td  align="center">내용</td>
		<td>
		<textarea name="gcontents" id="gcontents" cols="50" rows="10"></textarea>
	</td>
	</tr>
	<tr>
		<td align="center">분류</td>
		<td>
			<input type="checkbox" name="gdivi" value="01" />일반
			<input type="checkbox" name="gdivi" value="02" />공략
			<input type="checkbox" name="gdivi" value="03" />후기
			<input type="checkbox" name="gdivi" value="04" />구인
			<input type="checkbox" name="gdivi" value="05" />정보
	</tr>
	<tr>
		<td  align="center">사진</td>
		<td>
		<input type="file" name="photo" id="photo">
	</td>
	</tr>
	<tr>
		<td colspan="2" align="right">				
		<input type="button" value="글쓰기" id="gbtn">		
	</td>				
	</tr>
</table>
</form>
</body>
</html>