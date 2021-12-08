<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LOGIN</title>
    <link rel="stylesheet" href="../../css/front/login/login.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<script type="text/javascript" charset="utf-8">
	$(document).ready(function(){
		$("#btn").click(function(){
			console.log("btn >>> : ");
			
	        let id = $('#mid');
	        let pw = $('#mpw');
	        let btn = $('#btn');
			
			if($(id).val() == "") {
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
			
			$('#loginForm').attr({
				'action':"/front/mem/loginPro.s",
				'method':'POST',
				'enctype':'application/x-www-form-urlencoded'
			}).submit();
		});
		
	})

</script>

<body>
    <section class="login-form">
        <div class="h-font">
        <h1>HoPPies.</h1>
        </div>
        
        <form action="" name="loginForm" id="loginForm">
            <div class="int-area">
                <input type ="text" name="mid" id="mid" autocomplete="off" required>
                <label for="id">아이디</label>
            </div>
             <div class="int-area">
                 <input type ="password" name="mpw" id="mpw" autocomplete="off" required>
                <label for="pw">비밀번호</label>
            </div>
            <div class="btn-area">
                <button id="btn"
                type="submit">로그인</button>
            </div>
        </form>
        <div class="caption">
            <a href="">비밀번호를 잊으셨나요?</a>
        </div>
    </section>
    
</body>
</html>