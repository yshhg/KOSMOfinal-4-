<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!Doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회원가입</title>
<link rel="stylesheet" href="../../../css/front/mem/member.css">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<section class="member-form">
		<h1>HoPPies.</h1>
		<h2>- Create account -</h2>
		<form action="">
			<div class="member-area">
				<input type="text" name="name" id="name" autocomplete="off" required>
				<label for="name">이름</label>
			</div>
			<div class="member-area">
				<input type="text" name="id" id="id" autocomplete="off" required>
				<label for="id">아이디</label>
			</div>
			<div class="member-area">
				<input type="password" name="pw" id="pw" autocomplete="off" required>
				<label for="pw">비밀번호</label>
			</div>
			<div class="member-area">
				<input type="password" name="pw2" id="pw2" autocomplete="off"
					required> <label for="pw2">비밀번호 확인</label>
			</div>

			<!-- 팝업 버튼-->
			<div class="wrap">
				<li><button class="popup_button left">취미</button></li>
				<li><button class="popup_button right">지역</button></li>
			</div>
			<!-- 팝업 버튼  -->

			<div class="btn-area">
				<button id="btn" type="submit">회원가입</button>
			</div>
		</form>
		<div class="caption">
			<a href="/Hoppies/html/front/login/login.html">이미 회원 이십니까?</a>
		</div>
	</section>

	<script>
        let name = $('#name');
        let name2 = $('#name2');
        let id = $('#id');
        let pw = $('#pw');
        let pw2 =$('#pw2');

        $(btn).on('click', function() {
           if($(name).val() == "") {
               $(name).next('label').addClass('warning');
               setTimeout(function() {
                   $('label').removeClass('warning');
               },1500);
           }
            else if($(name2).val() == "") {
                $(name2).next('label').addClass('warning');
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

        });


    </script>

</body>
</html>
