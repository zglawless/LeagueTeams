<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="rosterDetailsNavigationServlet">
<table>
<c:forEach items="${requestScope.allRosters}" var="currentroster">
<tr>
	<td><input type="radio" name="id" value="${currentroster.id}"></td>
	<td><h2>${currentroster.rosterName}</h2></td>
</tr>
	
<tr>
	<td colspan="3">Start Date: ${currentroster.startDate}</td>
</tr>

<tr>
	<td colspan="3">Team: ${currentroster.teams.teamName}</td>
</tr>
<c:forEach var="listVal" items="${currentroster.listOfPlayers}">
<tr><td></td>
<td colspan="3">
${listVal.name}, ${listVal.number}, ${listVal.startDate}
</td>
</tr>
</c:forEach>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToRoster">
<input type="submit" value="delete" name="doThisToRoster">

</form>
<a href="addPlayersForListServlet">Create a new roster</a><br />
<a href="index.html">Insert a new player</a>
</body>
</html>