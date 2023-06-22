<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <link rel ="stylesheet" href="/css/public.css">
  <link rel="stylesheet"  href="/css/map.css">
  <title>gameover</title>
</head>

<body class = bodycolor_formap>

<header>
  <div class="top">
    <p class="mainfont logo">PLAY DATA <br> STORY</p>
    <a href="/main"><button class="headerbutton headerbuttonfont headerbuttonsignup mainfont">LOGOUT</button></a>
  </div>
</header>

<img class = gameset src="img/gameover.png" alt="gameover">

<form class="gameset_1" action="/gameover" method="post">
  <input type="hidden" name = 'action' value="1">
  <input type ='submit' value="종료하기" class = battle_frame_btn_1>
</form>

</body>

</html>
