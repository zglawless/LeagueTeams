<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "editTeamServlet" method="post">
Name: <input type = "text" name = "name" value = "${teamToEdit.teamName}">
<input type = "hidden" name = "id" value = "${teamToEdit.id}">
<input type="submit" value = "Save Edited Item">
</form>
</body>
</html>