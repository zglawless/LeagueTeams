<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Player List</title>
</head>
<body>
<form method = "post" action="playerNavigationServlet">
<table>
<c:forEach items = "${requestScope.allPlayers}" var = "currentplayer">
<tr>
<td><input type = "radio" name="id" value="${currentplayer.id}"> </td>
<td>${currentplayer.name}</td>
<td>${currentplayer.number}</td>
<td>${currentplayer.startDate}</td>
</tr>
</c:forEach>
</table>
<input type ="submit" value = "edit" name="doThisToPlayer">
<input type ="submit" value = "delete" name="doThisToPlayer">
<input type ="submit" value = "add" name="doThisToPlayer">
</form>
</body>
</html>