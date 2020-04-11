<!DOCTYPE html>
<html>

<body>
	<form action="/" align="right">
		<input type="submit" value="Logout"></input>
	</form>
	<h2 align="center">Welcome ${name}</h2>

	<div>
		<form action="/dashboard/Profile/update/firstName" method="post">
			FirstName: ${firstName} <input type="submit" value="Update"
				name="firstName"></input>
		</form>
		<form action="/dashboard/Profile/update/lastName" method="post">
			LastName: ${lastName} <input type="submit" value="Update"
				name="lastName"></input>
		</form>
		<form action="/dashboard/Profile/update/email" method="post">
			Email: ${email} <input type="submit" value="Update" name="email"></input>
		</form>
		<form action="/dashboard/Profile/update/phone" method="post">
			Contact number: ${phone} <input type="submit" value="Update"
				name="phone"></input>
		</form>
	</div>

	<div align="left">
		<a href="/dashboard/AccSummary">Back</a>
	</div>
</body>
</html>