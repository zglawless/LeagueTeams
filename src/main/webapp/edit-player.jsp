<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit a player</title>
</head>
<body>
<form action = "editPlayerServlet" method="post">
Name: <input type = "text" name = "name" value = "${playerToEdit.name}">
Number: <input type = "text" name = "number" value = "${playerToEdit.number}">
Start Date: <input type = "text" name = "startdate" value = "${playerToEdit.startDate}">
 <input type = "hidden" name = "id" value = "${playerToEdit.id}">
<input type="submit" value = "Save Edited Item">
</form>

</body>
</html>