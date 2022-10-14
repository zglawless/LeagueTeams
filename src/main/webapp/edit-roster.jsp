<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit an existing roster</title>
</head>
<body>
<form action="editRosterDetailsServlet" method="post">
<input type="hidden" name="id" value="${rosterToEdit.id}">
Roster Name: <input type="text" name="rosterName" value="${rosterToEdit.rosterName}"><br />

Start Date: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
<input type="text" name="day" placeholder="dd" size="4" value="${date}">
<input type="text" name="year" placeholder="yyyy" size="4" value="${year}">

Team Name: <input type="text" name="teamName" value="${rosterToEdit.teams.teamName}"><br />

Available Players:<br />

<select name="allPlayersToAdd" multiple size="6">
<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
	<option value="${currentplayer.id}">${currentplayer.name}</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Edit Roster and Add Players">
</form>
<a href="index.html">Go add new players/teams instead</a>
</body>
</html>