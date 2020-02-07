
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Contacts</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<c:if test="${empty currentUser}">
		<c:redirect url="/index.jsp" />
	</c:if>
	<div>
		<h1>Your Contacts</h1>
		<a href="/MainMenuUI.jsp"><input class="inputs" type="button"
			value="Back to main menu"></a>
	</div>
	<table>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Phone number</th>
		</tr>
		<c:forEach items="${contactsList}" var="list">
			<tr>
				<td>${list.name}</td>
				<td>${list.surname}</td>
				<td>${list.phoneNumber}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>