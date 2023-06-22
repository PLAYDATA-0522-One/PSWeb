<%--
  Created by IntelliJ IDEA.
  User: playdata
  Date: 2023-06-20
  Time: 오전 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <link rel ="stylesheet" href="/css/public.css">
  <link rel="stylesheet"  href="/css/map.css">
  <title>Map</title>
</head>
<body class = bodycolor_formap>

<header>
  <img class="joystick" src="img/joy_stick1.png" alt="joy_stick">
  <div class="top">
    <p class="mainfont logo">PLAY DATA <br> STORY</p>
    <a href="/main"><button class="headerbutton headerbuttonfont headerbuttonsignup mainfont">LOGOUT</button></a>
  </div>
</header>

<div class= mapdata>

  <c:if test="${sessionScope.get('직업') == '전사'}">
    <img  src="img/warrior.png" alt="warrior">
  </c:if>
  <img  class = map_spot src="img/temple.png" alt="shop">

  <%if (session.getAttribute("usermessage")!=null) {%>
  <div>
    <img class="talk" src = "img/talk.png" alt = "talk" >
    <h1 class="talk_word"><%=(String) session.getAttribute("usermessage")%> </h1>
  </div>
  <%}%>

  <img  class = character_frame src="img/warrior.png" alt="warrior">
  <div class = battle_frame>
    <img class = battle_frame_in src="img/battle_frame.png" alt="battle_frame">
    <h2 class = condition>골드 <%=request.getAttribute("gold")%></h2>
    <h2 class = condition_1>HP</h2>
    <h1 class = condition_2> <%=request.getAttribute("nowHealth")%>/ <%=request.getAttribute("Health")%></h1>
    <form class="battle_frame_btn_1" action="/temple" method="post">
      <input type="hidden" name = 'action' value="1">
      <input type ='submit' value="치료(50G)" class = battle_frame_btn_1>
    </form>
    <form class="battle_frame_btn_2" action="/temple" method="post">
      <input type="hidden" name = 'action' value="2">
      <input type ='submit' value="나가기" class = battle_frame_btn_1>
    </form>
<%--    <form class="battle_frame_btn_3" action="/battle" method="post">--%>
<%--      <input type="hidden" name = 'action' value="3">--%>
<%--      <input type ='submit' value="나가기" class = battle_frame_btn_1>--%>
<%--    </form>--%>
  </div>
</div>

</body>
</html>
