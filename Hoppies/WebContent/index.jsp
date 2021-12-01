<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hoppies</title>
 <link rel="stylesheet" href="../../../css/front/main/main.css">
 <script type = "text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

 
</head>
<body>
<section class="main-form">
<h1><a href="/Hoppies/index.jsp" style="cursor:pointer">Hoppies</a></h1>
<h4>Person People</h4>
<div id ="wrap">
        <header>
        
            <ul class = "gnb">
                <li><a href="/front/mem/MemForm.s">가입하기</a></li>
                <li><a href="#">로그인</a></li>
            </ul>
        </header>
    </div>
    
    <div id="mySidenav" class="sidenav">
	  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	  <a href="#">Book</a>
	  <a href="#">Computer</a>
	  <a href="/front/game/gameBoardForm.s">Game</a>
	  <a href="#">Contact</a>
	</div>
<span style="font-size:90px;cursor:pointer" onclick="openNav()">&#8250;</span>




<h6>Seoul<br>Current Weather</h6>
<div class="icon", style = "text-align:center">


</div>
<div class="clockcss"></div>
<div class="ctemp">현재 온도 : </div>
<!--  <div class="lowtemp">최저 온도 : </div>-->
<!--  <div class="hightemp">최고 온도 : </div>-->
</div>
<h5 class="time"></h5>


<!-- <img src="http://openweathermap.org/img/wn/10d@2x.png" alt="">
 	  아이콘 출력 : http://openweathermap.org/img/wn/10d@2x.png  끝에 @2x는 모바일용에만 적용한다. (2배키우라는 뜻)
 -->
</h3>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	<script>
		$.getJSON('http://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=93bf46cb6d5b998d5ecdd3f8bf6000da&units=metric',
				function(result){
			
					/*시간 출력*/								
					var ct = result.dt;
					
					function convertTime(t){
						var ot = new Date(t*1000);
						//Sun Nov 28 2021 18:27:44 GMT+0900 (한국 표준시) 이렇게 출력된다.	
						var hr = ot.getHours();
						var m  = ot.getMinutes();
											
						return hr + ':' + m
									
					}
					
					var currentTime = convertTime(ct)
					$('.time').append(currentTime);
					
					// result 변수는 getJSON 안에서 선언되었기때문에 안에서 사용되어야 한다.
					$('.ctemp').append(result.main.temp + 'º');
					$('.lowtemp').append(result.main.temp_min);
					$('.hightemp').append(result.main.temp_max);

					
					/*아이콘
					
					$('.icon').append(result.weather[0].icon);
					
					->
					
					var wiconUrl = '<img src="http://openweathermap.org/img/wn/10d@2x.png" alt="">'// 이렇게하면 고정적인 img 가 나오기때문에 
					
					->
					'<img src="http://openweathermap.org/img/wn/'+result.weather[0].icon +'.png" alt="'+ result.weather[0].description +'">'
					로 수정
					

				    -
				    
					*/
					//(result.weather[0].icon
					var wiconUrl = '<img src="http://openweathermap.org/img/wn/'+result.weather[0].icon +'.png" alt="'+ result.weather[0].description +'">'
					$('.icon').html(wiconUrl);

		});
		

	</script>

	<script>
		function openNav() {
		  document.getElementById("mySidenav").style.width = "250px";
		}
		
		function closeNav() {
		  document.getElementById("mySidenav").style.width = "0";
		}
	</script>

   </section>
</body>
</html>