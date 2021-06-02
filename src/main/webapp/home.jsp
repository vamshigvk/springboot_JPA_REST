<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hi Aliens</title>
</head>
<body>
	
	Add alien details:
	<form action="addAlien">
		<input type="text" name="aid" value="1"><br>
		<input type="text" name="aname" value="sravs"><br>
		<input type="text" name="tech" value="java"><br>
		<input type="submit"><br>
	</form>
	
	Get alien details:
	<form action="getAlien">
		<input type="text" name="aid" value="1"><br>
		<input type="submit"><br>
	</form>
	
	Get alien details by Tech:
	<form action="getAlienByTech">
		<input type="text" name="tech" value="java"><br>
		<input type="submit"><br>
	</form>
	
</body>
</html>