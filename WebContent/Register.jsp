<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Register</title>
</head>
<body>
	<div>
		<h1>Register</h1>
	</div>
	<div class="inputs">
		<p class="errors">
			<c:out value="${requestScope.registrationError }"></c:out>
		</p>

		<form method="post" action="Register.do">
			<input name="name" size=1 type="text" placeholder="First Name"><br>
			<br> <input name="surname" size=1 type="text"
				placeholder="Last Name"><br>
			<br> <input name="password" size=1 type="password"
				placeholder="Password"><br>
			<br> <input class="in-button" type="submit" value="Register">
		</form>
	</div>
</body>
</html>