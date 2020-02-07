<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="styles.css">
		<title>Delete current user</title>
	</head>
	<body>
	<c:if test="${empty currentUser}">
		<c:redirect url="/index.jsp" />
	</c:if>
	
		<div>
			<h1>Delete current user</h1>
		</div>
		<div class="inputs">
			<form method="POST" action="DeleteUser.do">
				<p class="delete-warning">Are you sure u want to delete your user account. <br>
					This action cannot be undone</p>
				<input class="delete-button" type="submit" value="Delete">
			</form>
		</div>
		</body>
</html>