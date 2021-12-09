<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록</title>
</head>
<body>
<h3>공지사항 등록</h3>
<hr>
<%
	Object obj = request.getAttribute("nCnt");
	if (obj == null) return;
		
	int nCnt = ((Integer)obj).intValue();
	
	if (nCnt > 0){
		System.out.println("입력이 완료 되었습니다." + nCnt);
%>
		<script>
			location.href="/Hoppies/notice?ISUD_TYPE=SALL";
		</script>
<%		
	}else{
		
	}
%>
</body>
</html>