<%--
  Created by IntelliJ IDEA.
  User: playdata
  Date: 2023-06-20
  Time: 오전 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div class = "mapdata">
<table class = "fielddata">
<tr>
    <td>
        <%@include file="mapdata/map_element.jsp"%>
    </td>

    <td>
        <%@include file="mapdata/map_element_2.jsp"%>
    </td>
    <td>
        <%@include file="mapdata/map_element_3.jsp"%>
    </td>
    <td>
        <%@include file="mapdata/map_element_4.jsp"%>
    </td>
</tr>

<tr>
    <td>
        <%@include file="mapdata/map_element_5.jsp"%>
    </td>
    <td>
        <%@include file="mapdata/map_element_6.jsp"%>
    </td>
    <td>
        <%@include file="mapdata/map_element_7.jsp"%>
    </td>
    <td>
        <%@include file="mapdata/map_element_8.jsp"%>
    </td>
</tr>
    <tr>
        <td>
            <%@include file="mapdata/map_element_9.jsp"%>
        </td>
        <td>
            <%@include file="mapdata/map_element_10.jsp"%>
        </td>
        <td>
            <%@include file="mapdata/map_element_11.jsp"%>
        </td>
        <td>
            <%@include file="mapdata/map_element_12.jsp"%>
        </td>
    </tr>

</table>
</div>
<div class = move_frame>
    <form class="move_frame_btn_1" action="/map" method="post">
        <input type="hidden" name = 'action' value="1">
        <input type ='submit' value="↑" class = "move_frame_btn_1">
    </form>
    <form class="move_frame_btn_2" action="/map" method="post">
        <input type="hidden" name = 'action' value="2">
        <input type ='submit' value="←" class = "move_frame_btn_2" >
    </form>
    <form class="move_frame_btn_3" action="/map" method="post">
        <input type="hidden" name = 'action' value="3">
        <input type ='submit' value="↓" class = "move_frame_btn_3" >
    </form>
    <form class="move_frame_btn_4" action="/map" method="post">
        <input type="hidden" name = 'action' value="4">
        <input type ='submit' value="→" class = "move_frame_btn_4" >
    </form>

<div>

</div>

</body>
</html>
