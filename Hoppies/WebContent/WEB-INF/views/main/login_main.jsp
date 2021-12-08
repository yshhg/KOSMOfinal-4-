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

<body onload="startTime()">
<section class="main-form">
<div class="mainb">
<a href="/Hoppies/index.jsp" style="cursor:pointer"><strong>Hoppies</strong></a>
</div>
<div class="mainb2">Person People</div>
<div id ="wrap">
        <header>
        
            <ul class = "gnb">
                <li><a href="/front/mem/logoutPro.s"><strong>로그아웃</strong></a></li>
                <li><a href="/front/mem/logoutPro.s"><strong>마이페이지</strong></a></li>
            </ul>
        </header>
    </div>
    
    <div id="mySidenav" class="sidenav">
	  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	  <a href="#">Book</a>
	  <a href="#">Computer</a>
	  <a href="/front/game/gameBoardSelectAll.s">Game</a>
	  <a href="#">Contact</a>
	</div>
<span style="font-size:90px;cursor:pointer" onclick="openNav()">&#8250;</span>




<!-- <div class = "mainb3">Seoul<br>Current Weather</div>-->
<div class = "mainb3">서울</div>
<div class="seicon", style = "text-align:center"></div>
<div class="setemp"> 현재 온도 : </div>

<div class = "mainb3">경기</div>
<div class="gyicon", style = "text-align:center"></div>
<div class="gytemp"> 현재 온도 : </div>

<div class = "mainb3">부산</div>
<div class="buicon", style = "text-align:center"></div>
<div class="butemp"> 현재 온도 : </div>


<!--  <div class="lowtemp">최저 온도 : </div>-->
<!--  <div class="hightemp">최고 온도 : </div>-->

<div id ="clock" class="clockcss"></div>
<div class = "mlmod">
<button type="button"style="color: #black; background:#fff; font-size:15px; font-family: 'Noto Sans KR', sans-serif; border-radius:25px; padding:10px 30px; cursor: pointer;" onclick="homzzang()"><strong>모드 전환<strong></strong></button>
</div>
<div id="theme"></div>

<!-- <img src="http://openweathermap.org/img/wn/10d@2x.png" alt="">
 	  아이콘 출력 : http://openweathermap.org/img/wn/10d@2x.png  끝에 @2x는 모바일용에만 적용한다. (2배키우라는 뜻)
 -->



<script>
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('clock').innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i}; // 숫자가 10보다 작을 경우 앞에 0을 붙여줌
    return i;
}

</script>

<script>
// On page load set the theme.
(function() {
  let onpageLoad = localStorage.getItem("theme") || "";
  let element = document.body;
  element.classList.add(onpageLoad);
  document.getElementById("theme").textContent =
    localStorage.getItem("theme") || "light";
})();

function homzzang() {
  let element = document.body;
  element.classList.toggle("dark-mode");

  let theme = localStorage.getItem("theme");
  if (theme && theme === "Dark-mode") {
    localStorage.setItem("theme", "");
  } else {
    localStorage.setItem("theme", "");
  }

  document.getElementById("theme").textContent = localStorage.getItem("theme");
}
</script>




<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	<script>
		var Seourl = 'http://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=93bf46cb6d5b998d5ecdd3f8bf6000da&units=metric';
		var Gyourl = 'https://api.openweathermap.org/data/2.5/weather?q=Gyeonggi-do&appid=93bf46cb6d5b998d5ecdd3f8bf6000da&units=metric';
		var Busurl = 'api.openweathermap.org/data/2.5/weather?q=Busan&appid=93bf46cb6d5b998d5ecdd3f8bf6000da&units=metric';
		
		$.getJSON(Seourl,function(result){		
					// result 변수는 getJSON 안에서 선언되었기때문에 안에서 사용되어야 한다.
					$('.setemp').append(result.main.temp + ' º');
					//$('.lowtemp').append(result.main.temp_min);
					//$('.hightemp').append(result.main.temp_max);

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
					$('.seicon').html(wiconUrl);
		});
		
		$.getJSON(Gyourl,function(result){		
				// result 변수는 getJSON 안에서 선언되었기때문에 안에서 사용되어야 한다.
				$('.gytemp').append(result.main.temp + ' º');
				
				var wiconUrl = '<img src="http://openweathermap.org/img/wn/'+result.weather[0].icon +'.png" alt="'+ result.weather[0].description +'">'
				$('.gyicon').html(wiconUrl);
		});
		
		$.getJSON(Gyourl,function(result){		
			// result 변수는 getJSON 안에서 선언되었기때문에 안에서 사용되어야 한다.
			$('.butemp').append(result.main.temp + ' º');
			
			var wiconUrl = '<img src="http://openweathermap.org/img/wn/'+result.weather[0].icon +'.png" alt="'+ result.weather[0].description +'">'
			$('.buicon').html(wiconUrl);
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