<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.playdata.game.dao.CharacterUtil" %>
<%@ page import="com.playdata.game.dao.CharacterDao" %>
<%@ page import="com.playdata.game.dto.Character" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="/css/char.css" />
  <link rel="stylesheet" href="/css/select.css" />
  <title>PLAYDATA STORY</title>
</head>
<body class="bodycolor">
<header>
  <div class="top">
    <p class="mainfont logo">
      PLAY DATA <br />
      STORY
    </p>
    <p class="mainfont aboutus">About us</p>

    <button
            class="headerbutton headerbuttonfont headerbuttonlogin mainfont"
    >
      캐릭터 생성
    </button>
    <button
            class="headerbutton headerbuttonfont headerbuttonsignup mainfont"
    >
      나가기
    </button>
  </div>
</header>
<div class="container">
  <%-- Display characters dynamically --%>
  <%
    List<Character> characters = (List<Character>) session.getAttribute("characters");
    if (characters != null && !characters.isEmpty()) {
      for (Character character : characters) {
  %>
  <div class="item">
<%--    <h1><%=character.getJob()%></h1>--%>
    <img src="<%= CharacterUtil.getImageUrl(character.getJob()) %>" alt="Character" />
    <div class="job-name">Level: <%= character.getLevel() %><br />
      Nickname: <%= character.getUname() %></div>
  <%-- Closing tag for item --%>
  <% } %>
    <%
      }
    %>
  <%-- Closing tag for container --%>
</div>
</body>
</html>