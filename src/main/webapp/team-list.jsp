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
<title>Team List</title>
</head>
<body>
<h1 style="text-align: center;">Team List</h1>

<div class="row">
	<div class="column" style="background-color: white;">
		<form method = "post" action="teamNavigationServlet">
			<table>
				<c:forEach items = "${requestScope.allTeams}" var = "currentteam">
					<tr>
						<td><input type = "radio" name="id" value="${currentteam.id}"> </td>
						<td>${currentteam.teamName}</td>
					</tr>
				</c:forEach>
			</table>
			<input type ="submit" value = "edit" name="doThisToTeam">
			<input type ="submit" value = "delete" name="doThisToTeam">
			<input type ="submit" value = "add" name="doThisToTeam">
		</form>
	</div>
</div>

</body>
</html>