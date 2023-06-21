<%--
  Created by IntelliJ IDEA.
  User: Playdata_
  Date: 2023-06-21
  Time: 오전 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String uri = request.getRequestURI();
%>
<html>
<head>
    <link rel="stylesheet" href="./css/char.css" />
    <link rel="stylesheet" href="./css/character.css" />
</head>
<body>
<header>
    <div class="top">
        <p class="mainfont logo">
            PLAY DATA <br />
            STORY
        </p>
        <p class="mainfont aboutus">About us</p>
        <button class="headerbutton headerbuttonfont headerbuttonlogin mainfont">캐릭터 선택</button>
        <button class="headerbutton headerbuttonfont headerbuttonsignup mainfont">나가기</button>
    </div>
</header>
</body>
</html>
