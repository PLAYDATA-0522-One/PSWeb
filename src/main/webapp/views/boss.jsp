<%@ page import="com.playdata.game.dto.Monster" %>
<%@ page import="com.playdata.game.dto.User" %>
<%@ page import="com.playdata.game.dto.UserNow" %><%--
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
  <%--  <%if(request.getAttribute("monster")!=null){%>--%>
  <%--  <% Monster monster = (Monster) request.getAttribute("monster");%>--%>
  <%--  <%if (monster.getName().equals("빨간달팽이")){%>--%>
  <%--  <img  src="img/redsnail.jpg" alt="redsnail">--%>
  <%--  <%} else if (monster.getName().equals("파랑달팽이")){%>--%>
  <%--  <img  src="img/redsnail.jpg" alt="redsnail">--%>
  <%--  <%}%>--%>
  <%--&lt;%&ndash;  이제 복사 붙여넣기만 하면 됨.&ndash;%&gt;--%>
  <%--  <%}%>--%>
  <%--// 이제 여기에 사진 넣고,--%>
  <%--// 이런식으로 사진 추가하기--%>

  <%--  <%}%>--%>
  <%--  ${monster.~~} ==빨간돼지--%>

  <%--<%if(request.getAttribute("user") !=null){&ndash;%&gt;--%>
  <%--   UserNow user = (UserNow) request.getAttribute("user");--%>
  <%--   if(user.isChar_dead())%> &lt;%&ndash;  유저나우든 유저든 직업이 있어야함.&ndash;%&gt;--%>
  <%--<%}%>--%>




  <img  class = map_spot src="img/battleboss.jpg" alt="battle">
    <div class = monster_boss>
      <%if(request.getAttribute("monster")!=null){%>
      <% Monster monster = (Monster) request.getAttribute("monster");%>
      <%if (monster.getName().equals("크림슨발록")){ %>
      <img style="width: 900px" src="img/crimebal.png" alt="crimebal">
      <%}%>
      <%--  이제 복사 붙여넣기만 하면 됨.--%>
      <div class="monster_bossinfo">
      <h2>체력<%= monster.getNow_hp()%> / <%=monster.getHp()%> </h2>
      <h2>공격력<%=monster.getAttackpoint()%> </h2>
      </div>
  <%}%>

    </div>

  <%if (session.getAttribute("usermessage")!=null) {%>
  <div>
    <img class="talk" src = "img/talk.png" alt = "talk" >
    <h1 class="talk_word"><%=(String) session.getAttribute("usermessage")%> </h1>
  </div>
  <%}%>
  <%UserNow user = (UserNow) session.getAttribute("userNow");%>

  <img  class = character_frame src="img/warrior.png" alt="warrior">
  <div class = battle_frame>
    <img class = battle_frame_in src="img/battle_frame.png" alt="battle_frame">
    <h3 class = condition>공격력 <%=user.getAttackpoint()%></h3>
    <h3 class = condition_1>HP <%=user.getNow_hp()%>/ <%=user.getHp()%></h3>
    <h3 class = condition_2>포션 개수 <%=user.getPortion()%></h3>
    <h3 class = condition_3>경험치 <%=user.getExp()%>/100</h3>
    <form class="battle_frame_btn_1" action="/boss" method="post">
      <input type="hidden" name = 'action' value="1">
      <input type ='submit' value="공격하기" class = battle_frame_btn_1>
    </form>
    <form class="battle_frame_btn_2" action="/boss" method="post">
      <input type="hidden" name = 'action' value="2">
      <input type ='submit' value="방어하기" class = battle_frame_btn_1>
    </form>
    <form class="battle_frame_btn_3" action="/boss" method="post">
      <input type="hidden" name = 'action' value="3">
      <input type ='submit' value="도구사용" class = battle_frame_btn_1>
    </form>
  </div>
</div>

</body>
</html>
