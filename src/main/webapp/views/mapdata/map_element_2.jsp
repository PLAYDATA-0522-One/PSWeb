<%--
  Created by IntelliJ IDEA.
  User: playdata
  Date: 2023-06-20
  Time: 오후 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<head>
  <link rel="stylesheet"  href="/css/map.css">
</head>

<%MapDto map2 = (MapDto) session.getAttribute("map");%>
<% int number2 = map2.getMap()[0][1]; %>
<%if ( number2 == 0){%>
<div class = clear>

  ?
</div>
<%}else if ( number2 == 1){%>
<div class = >
HERE
  <%--  미클리어--%>
</div>
<%}else if ( number2 == 2){%>
<div class = >
  clear
</div>
<%}%>