<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Contact Manager</title>
</head>
<body>
	<c:if test="${not empty currentUser}">
		<c:redirect url="/MainMenuUI.jsp" />
	</c:if>
	<div>
		<h1>Contact Manager</h1>
	</div>
	<div class="inputs">
		<a href="Login.jsp">
			<button>Log in</button>
		</a><br> <a href="Register.jsp">
			<button>Register</button>
		</a>
	</div>
</body>
</html>