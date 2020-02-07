<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Log in</title>
</head>
<body>
	<div>
		<h1>Log in</h1>
	</div>
	<div class="inputs">
	<p class="errors"><c:out value="${requestScope.loginError }"></c:out></p>
		<form method="POST" action="Login.do">
			<input type="text" placeholder="First Name" name="name"><br>
			<br> <input type="text" placeholder="Last Name" name="surname"><br>
			<br> <input type="password" placeholder="Password" name="password"><br> <br>
			<input class="in-button" type="submit" value="Log in">
		</form>
		<p>New here?</p>
		<a href="Register.jsp">
			<button>Register Now!</button>
		</a>
	</div>
</body>
</html>