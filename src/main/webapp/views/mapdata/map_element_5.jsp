<%--
  Created by IntelliJ IDEA.
  User: playdata
  Date: 2023-06-20
  Time: 오후 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%MapDto map5 = (MapDto) session.getAttribute("map");%>

<% int number5 = map5.getMap()[1][0]; %>
<%if ( number5 == 0){%>
<div class = clear>
  ?
</div>
<%}else if ( number5 == 1){%>
<div class = >
HERE
  <%--  미클리어--%>
</div>
<%}else if ( number5 == 2){%>
<div class = >
  clear
</div>
<%}%>