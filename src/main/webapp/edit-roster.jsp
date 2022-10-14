<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
* {
	box-sizing: border-box;
}

.row {
	display: flex;
}

.column {
	flex: 50%;
	padding: 10px;
	height: 300px;
	margin: 10px;
}

body {
	background-color: lightblue;
}

a {
	color: black;
	font-family: Arial, Helvetica, sans-serif;
}

input {
	margin-bottom: 10px;
}


</style>
<title>Edit an Existing Roster</title>
</head>
<body>
<h1 style="text-align: center;">Edit an Existing Roster</h1>

<div class="row">
	<div class="column" style="background-color: white;">
		<form action="editRosterDetailsServlet" method="post">
			<input type="hidden" name="id" value="${rosterToEdit.id}">
			Roster Name: <input type="text" name="rosterName" value="${rosterToEdit.rosterName}"><br />

			Start Date: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
			<input type="text" name="day" placeholder="dd" size="4" value="${date}">
			<input type="text" name="year" placeholder="yyyy" size="4" value="${year}">

			Team Name: <input type="text" name="teamName" value="${rosterToEdit.teams.teamName}"><br />

			Available Players:<br />

			<select style="width: 100px;" name="allPlayersToAdd" multiple size="6">
			<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
				<option value="${currentplayer.id}">${currentplayer.name}</option>
			</c:forEach>
			</select>
			<br />
			<input type="submit" value="Edit Roster and Add Players">
		</form>
	</div>
</div>
<a href="index.html">Go add new players/teams instead</a>
</body>
</html>