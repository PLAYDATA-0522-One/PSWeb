<%@ page import="com.playdata.game.dao.MonsterDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<%
    int n;
    n = new MonsterDao().randomMonster();

    if(0<=n && n<3)
    {

    } else if (3<=n && n<6)
    {

    }
    else if (6<=n && n<9)
    {

    }
    else if (9<=n && n<=12)
    {

    }
%>
<head>
  <title>battle</title>
  <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/fight.css">
</head>
<body>
<header>
    <%--    <img class="joystick" src="img/joy_stick1.png" alt="joy_stick">--%>
    <div class="top">
        <a href="/main"><p class="mainfont logo">PLAY DATA <br> STORY</p></a>
        <a href="/fight"><button class="start_button">모험시작</button></a>
        <a href="/main"><button class="start_button">뒤로돌아가기</button></a>
    </div>
</header>
</body>
</html>
