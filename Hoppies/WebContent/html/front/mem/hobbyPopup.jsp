<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="../../css/front/mem/popup.css">
<title>취미 선택</title>
<html>

<script type="text/javascript">
	
$(document).ready(function(){
	
	//회원가입화면에서 hobby1,2,3 값 가져와서 넣어 줌.
	document.getElementById("mhobby_1").value = opener.document.getElementById("mhobby_1").value;
	document.getElementById("mhobby_2").value = opener.document.getElementById("mhobby_2").value;
	document.getElementById("mhobby_3").value = opener.document.getElementById("mhobby_3").value;
	
	 $('input:checkbox[name="checkbox"]').each(function() {

	     if(this.value == $('[id="mhobby_1"]').val() || this.value == $('[id="mhobby_2"]').val() || this.value == $('[id="mhobby_3"]').val()){ //값 비교해서 회원가입폼에서 가져온 데이터와 일치하면
	            this.checked = true; //checked 처리
	      } 

	 });

});
        function getParentText(){
        	if($('input:checkbox[name="checkbox"]:checked').length > 3){
        		alert("취미는 3개까지 선택가능합니다.");
        		return false;
        	}
            
    		var arr = [];
    		$('input[name="checkbox"]:checked').each(function(){
    			var chk = $(this).val();
    			arr.push(chk);
    		})
    		console.log(arr);
    		
    		for(var i = 0; i < arr.length ; i++){
    			arr[i];
    			console.log(arr[i]);
    		}

    		$('input[id=mhobby_1]').attr('value',arr[0]);
    		$('input[id=mhobby_2]').attr('value',arr[1]);
    		$('input[id=mhobby_3]').attr('value',arr[2]);
    		
    		console.log("test>>>>>",$('[id="mhobby_1"]').val());
    		console.log("test>>>>>",$('[id="mhobby_2"]').val());
    		console.log("test>>>>>",$('[id="mhobby_3"]').val());
    		//팝업창 hobby1,2,3 값 회원가입 폼에 세팅.
    		opener.document.getElementById("mhobby_1").value = document.getElementById("mhobby_1").value;
    		opener.document.getElementById("mhobby_2").value = document.getElementById("mhobby_2").value;
    		opener.document.getElementById("mhobby_3").value = document.getElementById("mhobby_3").value;
            
            window.close();
        }
        
</script>



<body>
	<h2>취미 선택 - 3개까지 선택 가능합니다.</h2>

	<input type="hidden" name="hobby" id="mhobby_1" value="" />
	<input type="hidden" name="hobby" id="mhobby_2" value="" />
	<input type="hidden" name="hobby" id="mhobby_3" value="" />

	<c:forEach items="${hobbyList}" var="res">
		<label><input type="checkbox" class="checkbox" name="checkbox"
			data-name="${res.code_nm}" value="${res.code}" /></label>
	</c:forEach>
	<div class="btn-area">
		<button id="btn" onclick="getParentText();">확인</button>
	</div>
</body>
</html>