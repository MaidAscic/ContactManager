<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Contact manager</title>
</head>
<body>
	<div>
		<h1>
			Welcome
			<c:out value="${sessionScope.currentUser.name }"></c:out>
		</h1>
	</div>
	<div class="inputs">
		<form>
			<a href="AddNewContact.html"><input class="menu-button"
				type="button" value="Add new Contact"></a><br> <a
				href="EditExistingContact.html"><input class="menu-button"
				type="button" value="Edit existing Contact"></a><br> <a
				href="DeleteExistingContact.html"><input class="menu-button"
				type="button" value="Delete existing Contact"></a><br>
		</form>
		<form method="post" action="ListAllContacts.do">
			<input class="menu-button" type="button" value="List all Contacts"><br>
		</form>

		<a href="LogOut.html"><input class="menu-button" type="button"
			value="Logout"></a><br> <a href="DeleteUser.html"><input
			class="delete-button" type="button" value="Delete current user"></a><br>

	</div>
</body>
</html>