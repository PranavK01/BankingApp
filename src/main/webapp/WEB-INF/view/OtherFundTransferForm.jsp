<html>
<body>
	<form action="/" align="right">
		<input type="submit" value="Logout"></input>
	</form>
	<h2 align="center">Welcome ${name}</h2>
	
	<div>
	<form method="post" action="/dashboard/FundTransfer/confirm" >
		Select Account: 
		<select name="fromAcc" required>
			<option></option>
			<option>${fromSavingAcc}</option>
			<option>${fromCurrentAcc}</option>
		</select>
		<br>
		Beneficiary Account:
		<input type="text" name="toAcc" required></input>
		<br>
		Amount:
		<input type="text" name="amount" required></input>
		<br>
		Description:
		<input type="text" name="Remark"></input>
		<br>
		<input type="submit" value="Confirm"></input>
	</form>
	</div>
	
	<div align="left">
			<br>
			<a href="/dashboard/AccSummary">Home</a>
	</div>
	
</body>
</html>