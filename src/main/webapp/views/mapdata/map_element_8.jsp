<%--
  Created by IntelliJ IDEA.
  User: playdata
  Date: 2023-06-20
  Time: 오후 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%MapDto map8 = (MapDto) session.getAttribute("map");%>

<% int number8 = map8.getMap()[1][3]; %>
<%if ( number8 == 0){%>
<div class = clear>

  ?
</div>
<%}else if ( number8 == 1){%>
<div class = >
HERE
  <%--  미클리어--%>
</div>
<%}else if ( number8 == 2){%>
<div class = >
  clear
</div>
<%}%>