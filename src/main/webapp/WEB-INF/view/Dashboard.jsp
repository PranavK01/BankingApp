<html>

<body>

	<form action="/" align="right">
		<input type="submit" value="Logout"></input>
	</form>
	<h2 align="center">Welcome ${name}</h2>

	<div align="right">
		<a href="/dashboard/Profile">Profile</a>
	</div>

	<div align="left">
		<p>Account Information</p>
		<hr>
		<a href="/dashboard/SavingAccountInfo">Saving Account</a> <br> <a
			href="/dashboard/CurrentAccountInfo">Current Account</a> <br>
		<p>Fund Transfer</p>
		<a href="/dashboard/FundTransfer/inter">To Own Account</a> <br> <a
			href="/dashboard/FundTransfer/other">Other Account</a>
	</div>

	<div align="center">
		<h3>Saving Account</h3>
		<p>${savingAccNumber}</p>
		<p>${savingBalance} ${saveCurrency}</p>
	</div>
	<hr>
	<div align="center">
		<h3>Current Account</h3>
		<p>${currentAccNumber}</p>
		<p>${currentBalance} ${currentCurrency}</p>
	</div>

</body>
</html>


