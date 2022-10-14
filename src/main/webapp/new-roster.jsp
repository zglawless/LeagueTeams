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
}

input {
	margin-bottom: 10px;
}

</style>
<title>Create a new list</title>
</head>
<body>
<h1 style="text-align: center;">Create a new list</h1>

<div class="row">
	<div class="column" style="background-color: white;">
		<form action="createNewRosterServlet" method="post">
			Roster Name: <input type="text" name="rosterName"><br />
			Start Date: <input type="text" name="month" placeholder="mm" size="4">
			<input type="text" name="day" placeholder="dd" size="4">
			<input type="text" name="year" placeholder="yyyy" size="4">
			Team Name: <input type="text" name="teamName"><br />

			Available Players:<br />
			<select style="width: 100px;" name="allPlayersToAdd" multiple size="6">
				<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
					<option style="color: black" value="${currentplayer.id}">${currentPlayer.name}</option>
				</c:forEach>
			</select>
			<br />
			<input type="submit" value="Create Roster and Add Players">
		</form>
	</div>
</div>
<a href="index.html">Go add new players/teams instead</a>
</body>
</html>