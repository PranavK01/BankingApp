<html>
<body>
	<h2 align="center"> Welcome to Bank</h2>
	
	<form method="post" action="/dashboard" >
		UserID: 
		<input type="text" name="userID" required></input>
		<br>
		Password:
		<input type="password" name="password" required></input>
		<br>
		<input type="submit" value="Login"></input>
	</form>
	
	<form action="/create/newCustomer/form">
		<input type="submit" value="Open New Account"></input>
	</form>
	
	<form action="/forgotPassword">
		<input type="submit" value="Forgot Password?"></input>
	</form>
</body>
</html>