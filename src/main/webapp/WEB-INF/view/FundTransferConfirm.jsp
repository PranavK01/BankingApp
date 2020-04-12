<!DOCTYPE html>
<html>

<body>
	<form action="/" align="right">
		<input type="submit" value="Logout"></input>
	</form>
	<h2 align="center">Welcome ${name}</h2>
	
	<div>
		<p>Remitor Account Number: ${fromAcc}</p>
		<p>Beneficiary Account Number: ${toAcc}</p>
		<p>Amount: ${amount}</p>
		<p>Description: ${Remark}</p>
		
		<form action="/dashboard/FundTransfer/confirm/ack" method="post">
			<input type="submit" value="Submit"></input>
		</form>
	</div>
	
	<div align="left">
			<a href="/dashboard/AccSummary">Home</a>
	</div>
</body>
</html>