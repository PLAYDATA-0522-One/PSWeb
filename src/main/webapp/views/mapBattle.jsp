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

<%--  <% int a = (int) (Math.random()*3); %>--%>

<%--  <% if(a == 0){%>--%>
<%--  <img  class = map_spot src="img/battle2.jpg" alt="battle">--%>
<%--  <%}else if(a == 1){%>--%>
<%--  <img  class = map_spot src="img/battle.jpg" alt="battle">--%>
<%--  <%}else if(a == 2){%>--%>
  <img  class = map_spot src="img/battle3.jpg" alt="battle">
<%--  <%}%>--%>

  <div class = monster>
  <%if(request.getAttribute("monster")!=null){%>
  <% Monster monster = (Monster) request.getAttribute("monster");%>
   <div class="monster_info">
    <h2>체력 <%= monster.getNow_hp()%> / <%=monster.getHp()%> </h2>
    <h2>공격력 <%=monster.getAttackpoint()%> </h2>
  </div>
  <%if (monster.getName().equals("빨강달팽이")){%>
  <img  style="width: 400px" src="img/redsnail.png" alt="redsnail">
  <%} else if (monster.getName().equals("파란달팽이")){%>
  <img style="width: 400px" src="img/bluesnail.png" alt="bluesnail">
  <%} else if (monster.getName().equals("리본돼지")){%>
  <img style="width: 400px" src="img/pig.png" alt="pig">
  <%} else if (monster.getName().equals("스텀프")){%>
  <img style="width: 400px" src="img/stump.png" alt="stump">
  <%} else if (monster.getName().equals("옥토퍼스")){%>
  <img style="width: 400px" src="img/octopus.png" alt="octopus">
  <%} else if (monster.getName().equals("주황버섯")){%>
  <img style="width: 400px" src="img/orangemushroom.png" alt="orangemushroom">
  <%} else if (monster.getName().equals("슬라임")){%>
  <img style="width: 400px" src="img/redsnail.jpg" alt="redsnail">
  <%} else if (monster.getName().equals("와일드보어")){%>
  <img style="width: 400px" src="img/redsnail.jpg" alt="redsnail">
  <%} else if (monster.getName().equals("아이언호그")){%>
  <img style="width: 400px" src="img/redsnail.jpg" alt="redsnail">
  <%} else if (monster.getName().equals("스톰골렘")){%>
  <img style="width: 400px" src="img/stonegolem.png" alt="stonegolem">
  <%} else if (monster.getName().equals("주니어발록")){%>
  <img style="width: 400px" src="img/juniorbalok.png" alt="juniorbalok">
  <%} %>
<%--  이제 복사 붙여넣기만 하면 됨.--%>
  <%}%>
  </div>

<%--<%if(request.getAttribute("user") !=null){&ndash;%&gt;--%>
<%--   UserNow user = (UserNow) request.getAttribute("user");--%>
<%--   if(user.isChar_dead())%> &lt;%&ndash;  유저나우든 유저든 직업이 있어야함.&ndash;%&gt;--%>
<%--<%}%>--%>


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
    <form class="battle_frame_btn_1" action="/battle" method="post">
      <input type="hidden" name = 'action' value="1">
    <input type ='submit' value="공격하기" class = battle_frame_btn_1>
    </form>
    <form class="battle_frame_btn_2" action="/battle" method="post">
      <input type="hidden" name = 'action' value="2">
      <input type ='submit' value="방어하기" class = battle_frame_btn_1>
    </form>
    <form class="battle_frame_btn_3" action="/battle" method="post">
      <input type="hidden" name = 'action' value="3">
      <input type ='submit' value="회복하기" class = battle_frame_btn_1>
    </form>
  </div>
</div>

</body>
</html>
