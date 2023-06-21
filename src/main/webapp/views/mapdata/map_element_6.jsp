<%--
  Created by IntelliJ IDEA.
  User: playdata
  Date: 2023-06-20
  Time: 오후 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%MapDto map6 = (MapDto) session.getAttribute("map");%>

<% int number6 = map6.getMap()[1][1]; %>
<%if ( number6 == 0){%>
<div class = clear>
  ?
</div>
<%}else if ( number6 == 1){%>
<div class = >
HERE
  <%--  미클리어--%>
</div>
<%}else if ( number6 == 2){%>
<div class = >
  clear
</div>
<%}%>