<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Contact manager</title>
</head>
<body>
	<c:if test="${empty currentUser}">
		<c:redirect url="/index.jsp" />
	</c:if>
	<div>
		<h1>
			Welcome
			<c:out value="${currentUser.name }"></c:out>
		</h1>
	</div>
	<div class="inputs">
			<a href="AddNewContact.jsp"> 
				<input class="menu-button" type="button" value="Add new Contact">
			</a><br> 
			<a href="EditExistingContact.jsp"> 
				<input class="menu-button" type="button" value="Edit existing Contact">
			</a><br> 
			<a href="DeleteExistingContact.jsp"> 
				<input class="menu-button" type="button" value="Delete existing Contact">
			</a><br>
		<form method="post" action="ListAllContacts.do">
				<input class="menu-button" type="submit" value="List all Contacts"><br>
		</form>
		<form method="post" action="Logout.do">
			<input class="menu-button" type="submit"value="Logout"><br>
		</form> 
			<a href="DeleteUser.jsp"><input
			class="delete-button" type="button" value="Delete current user"></a><br>

	</div>
</body>
</html>