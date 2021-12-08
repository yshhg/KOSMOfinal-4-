<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!Doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회원가입</title>
<link rel="stylesheet" href="../../css/front/mem/member.css">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script type="text/javascript" src="https://unpkg.com/vue@2.5.16/dist/vue.js"></script>
</head>
</head>

<script type="text/javascript" charset="utf-8">
	$(document).ready(function(){
		// 아이디 중복체크 Ajax 동기 방식
		$(document).on("click", "#midbtn", function(){
			syncIdCheckData();
		});			
		
		async function syncIdCheckData(){			
			
			let idCheckData = '';
			var vv = $("#mid").val();
			if (vv == '') {
				 $($('#mid')).next('label').addClass('warning');
	                setTimeout(function() {
	                   $('label').removeClass('warning');
	               },1500);
				return false;
			}

			
			idCheckData = await ajaxIdCheckData(vv);						
			
			if ("ID_YES" == idCheckData){
				alert("사용가능한 아이디 입니다.");																		
				$("#mpw").focus();	
				$("#confirm").val('1');	
			}else if ("ID_NO" == idCheckData){
				alert("이미 아이디 사용중인 아이디입니다.");
				$("#mid").val('');
				$("#mid").focus();
			};				
		}
		
		function ajaxIdCheckData(myval){
			
			let idCheckURL = "confirmId.s";
			let reqType = "POST";
			let dataParam = { mid: myval, };
			
			return $.ajax({							
			    url: idCheckURL
			   ,type: reqType
			   ,data: dataParam			   
			});
		}
		
		// 폼태그 데이터 JSP 보내기 
		$("#btn").click(function(){
			
	        let name = $('#mname');
	        let id = $('#mid');
	        let pw = $('#mpw');
	        let pw2 =$('#mpw2');
			
			if($(name).val() == "") {
	               $(name).next('label').addClass('warning');
	               setTimeout(function() {
	                   $('label').removeClass('warning');
	               },1500);
	           }
	              else if($(id).val() == "") {
	                $(id).next('label').addClass('warning');
	                setTimeout(function() {
	                   $('label').removeClass('warning');
	               },1500);
	            }
	             else if($(pw).val() == "") {
	                $(pw).next('label').addClass('warning');
	                setTimeout(function() {
	                   $('label').removeClass('warning');
	               },1500);
	            }
	              else if($(pw2).val() == "") {
	                $(pw2).next('label').addClass('warning');
	                setTimeout(function() {
	                   $('label').removeClass('warning');
	               },1500);
	            }
			//비밀번호 
			if($("#mpw").val() != $("#mpw2").val()){ //pwd value와 repwd의 value가 같지않으면
					alert("비밀번호가 일치하지 않습니다."); //alert
					$("#mpw2").val(''); //repwd의 값을 없애고
					$("#mpw2").focus(); //포커스 줌
					return false;
			}
			
			if($("#confirm").val() != 1){
				alert("아이디 중복확인이 필요합니다."); //alert
				return false;
			}
			
			if($("#area").val() == ''){
				alert("지역을 골라주세요."); //alert
				return false;
			}
			
			if($("#hobby1").val() == '' && $("#hobby2").val() == '' && $("#hobby3").val() == ''){
				alert("취미를 골라주세요."); //alert
				return false;
			}
			
			//alert("btn click() 함수 진입 >>> : ");
			console.log("btn click() 함수 진입 >>> : ");

			$("#memForm").attr({
					"action":"/front/mem/memInsert.s",
				    "method":"POST"
			       }).submit();	
		});
	});

	function areaPopup(){
		//popup창으로 데이터 전달
		//openWin.document.getElementById("cInput").value = document.getElementById("pInput").value;
		var url = "/front/base/areaAll.s";
		window.open(url, "confirm", "menubar=no, width=700, height=500");		
	}
	
	function hobbyPopup(){
		//popup창으로 데이터 전달
		var url = "/front/base/hobbyAll.s";
		window.open(url, "confirm", "menubar=no, width=700, height=500");	
	}	

</script>

<body >
	<div id="container">
	
	<section class="member-form">
		<h1>HoPPies.</h1>
		<h2>- Create account -</h2>
		<form id="memForm" name="memForm" class="memForm">
			<!-- hiddenId : 중복확인 버튼클릭 여부 체크 (0:클릭안함 1:클릭함) -->
			<input type="hidden" name="mhobby_1" id="mhobby_1" value=""/>
			<input type="hidden" name="mhobby_2" id="mhobby_2" value=""/>		
			<input type="hidden" name="mhobby_3" id="mhobby_3" value=""/>	
			<input type="hidden" name="marea" id="marea" value=""/>	
			<input type="hidden" name="confirm" id="confirm" value=""/>	
			
			<div class="member-area">
				<input type="text" name="mname" id="mname" autocomplete="off" required>
				<label for="mname">이름</label>
			</div>
			<div class="member-area">
				<input type="text" name="mid" id="mid" autocomplete="off" required style="width: 240px;">
				<label for="mid">아이디</label><input style="width: 150px; margin-left: 5px; font-size: 20px;" class="inputButton" type="button" name="dupChk" value="중복확인" id="midbtn">
			</div>
			<div class="member-area">
				<input type="password" name="mpw" id="mpw" autocomplete="off" required>
				<label for="mpw">비밀번호</label>
			</div>
			<div class="member-area">
				<input type="password" name="mpw2" id="mpw2" autocomplete="off"
					required> <label for="mpw2">비밀번호 확인</label>
			</div>

			<!-- 팝업 버튼-->
			<div class="wrap">
				<button type="button" class="popup_button left" onclick="hobbyPopup();">취미</button>
				<button type="button" class="popup_button right" onclick="areaPopup();">지역</button>
			</div>

			<div class="btn-area">
				<button id="btn" type="submit">회원가입</button>
			</div>
		</form>
		<div class="caption">
			<a href="/front/mem/login.s">이미 회원 이십니까?</a>
		</div>
	</section>
</div>

</body>
</html>
