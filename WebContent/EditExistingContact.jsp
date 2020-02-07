<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="styles.css">
		<title>Edit contact</title>
	</head>
	<body>
	<c:if test="${empty currentUser}">
		<c:redirect url="/index.jsp" />
	</c:if>
	
		<div>
			<h1>Edit contact</h1>
		</div>
		<div class="inputs">
			<form action="EditContact.do" method="post">
				<input name="oldPhoneNumber" type="text" placeholder="Phone number to replace"><br><br>
				<input name="name" type="text" placeholder="New name"><br><br>
				<input name="surname"
					   type="text" placeholder="new surname"><br><br>
				<input name="phoneNumber" type="text" placeholder="New phone number"><br><br>
				<input class="submit-button" type="submit" value="Edit Contact">
			</form>
		</div>
	</body>
</html>