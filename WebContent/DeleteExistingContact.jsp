<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="styles.css">
		<title>Delete contact</title>
	</head>
	<body>
	<c:if test="${empty currentUser}">
		<c:redirect url="/index.jsp" />
	</c:if>
	
		<div>
			<h1>Delete contact</h1>
		</div>
		<div class="inputs">
			<form method="POST" action="Delete.do">
				<p class="delete-warning">Are you sure u want to delete this contact. <br>
					This action cannot be undone</p>
				<input name="phoneNumber" type="text" placeholder="Phone number"><br><br>
				<input class="delete-button" type="submit" value="Delete">
			</form>
		</div>
		</body>
</html>