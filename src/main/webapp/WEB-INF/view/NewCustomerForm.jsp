<html>

<body>
	<h2 align="center"> Welcome to Bank</h2>
	
	<form method="post" action="/create/newCustomer/ack" >
		First Name:
		<input type="text" name="firstName" required></input><br>
		Last Name:
		<input type="text" name="lastName" required></input><br>
		Email:
		<input type="text" name="email" required></input><br>
		Contact No.:
		<input type="text" name="phone" required></input><br>
		USER ID:
		<input type="text" name="userId" required></input><br>
		Password:
		<input type="password" name="password" required></input><br>
		Current Account: 
		<select name="currentAcc" required>
			<option></option>
			<option>Yes</option>
			<option>No</option>
		</select>
		<br>
		<input type="submit" value="Sign Up"></input>
		<br>
		
	</form>
	
</body>
</html>