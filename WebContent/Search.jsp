<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta charset="ISO-8859-1">
<title>Search for contacts</title>
</head>
<body>
		<div>
			<h1>Search for contacts </h1>
		</div>
		
		<form method="post" action="Search.do">
		<input type="text" name="name" placeholder="Name">
		<input type="text" name="surname" placeholder="Surname">
		<input type="text" name="phonenumber" placeholder="PhoneNumber">
		<input type="submit" value="Search">
		</form>
		
			<table>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Phone number</th>
		</tr>
		<c:forEach items="${searchContactsList}" var="list">
			<tr>
				<td>${list.name}</td>
				<td>${list.surname}</td>
				<td>${list.phoneNumber}</td>
			</tr>
		</c:forEach>
	</table>
		
</body>
</html>