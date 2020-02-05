<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="styles.css">
		<title>Add new contact</title>
	</head>
	<body>
		<div>
			<h1>Add new contact</h1>
		</div>
		<div class = "inputs">
		<form method="post" action="NewContact.do">
			<input name="name" type="text" placeholder="Name"><br><br>
			<input name="surname"
					type="text" placeholder="Surname"><br><br>
			<input name="phoneNumber" type="text" placeholder="Phone number"><br><br>
			<input class="submit-button" type="submit" value="Create Contact">
		</form>
		</div>
	</body>
</html>