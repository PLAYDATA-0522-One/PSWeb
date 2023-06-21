<%@ page import="com.playdata.game.dto.MapDto" %><%--
  Created by IntelliJ IDEA.
  User: playdata
  Date: 2023-06-20
  Time: 오후 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<%MapDto map = (MapDto) session.getAttribute("map");%>
<% int number = map.getMap()[0][0]; %>
<%if ( number == 0){%>
<div class = box>
?
</div>
<%}else if ( number == 1){%>
<span class = box>
HERE
<%--  미클리어--%>
</span>
<%}else if ( number == 2){%>
<div class = box>
clear
</div>
<%}%>

