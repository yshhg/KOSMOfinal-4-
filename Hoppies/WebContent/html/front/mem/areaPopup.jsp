<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="../../css/front/mem/popup.css">
<title>지역 선택</title>
<html>

<script type="text/javascript">
	
$(document).ready(function(){
	
	//회원가입화면에서 hobby1,2,3 값 가져와서 넣어 줌.
	document.getElementById("marea").value = opener.document.getElementById("marea").value;
	
	 $('input:radio[name="rdo"]').each(function() {

	     if(this.value == $('[id="marea"]').val()){ //값 비교해서 회원가입폼에서 가져온 데이터와 일치하면
	            this.checked = true; //checked 처리
	      } 

	 });

});
        function getParentText(){
            
    		var chk;
    		$('input[name="rdo"]:checked').each(function(){
    			chk = $(this).val();
    		})
    		console.log(chk);
    		
    		$('input[id=marea]').attr('value',chk);
    		
    		console.log("test>>>>>",$('[id="marea"]').val());
    		//팝업창 hobby1,2,3 값 회원가입 폼에 세팅.
    		opener.document.getElementById("marea").value = document.getElementById("marea").value;
            
            window.close();
        }
        
</script>



<body>
	<h2>취미 선택</h2>

	<input type="hidden" name="marea" id="marea" value="" />

	<c:forEach items="${areaList}" var="res">
		<label><input type="radio" class="rdo" name="rdo" value="${res.code}" >${res.code_nm}</label>
	</c:forEach>
	<div class="btn-area">
		<button id="btn" onclick="getParentText();">확인</button>
	</div>
</body>
</html>