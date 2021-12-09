<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>공지사항 수정</title>
</head>
<body>
<h3>공지사항 수정</h3>
<hr>
<%
	Object obj = request.getAttribute("nCnt");
	if (obj == null) return;
		
	int nCnt = ((Integer)obj).intValue();
	
	if (nCnt > 0){
		System.out.println("수정 성공  nCnt >>> : " + nCnt);
%>
		<script>
			location.href="/testKosmo/notice?ISUD_TYPE=SALL";
		</script>
<%		
	}else{
		
	}
%>
</body>
</html>