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
		<a href="/dashboard/AccSummary">Account Summary</a> <br>
		<p>Account Information</p>
		<a href="/dashboard/SavingAccountInfo">Saving Account</a> <br> <a
			href="/dashboard/CurrentAccountInfo">Current Account</a> <br>
		<p>Fund Transfer</p>
		<a href="/dashboard/FundTransfer/inter">To Own Account</a> <br> <a
			href="/dashboard/FundTransfer/other">Other Account</a>
	</div>

	<div align="center">
		<button onclick="myFunction()">Saving Account</button>
		<p>${savingAccNumber}</p>
		<p>${savingBalance} ${saveCurrency}</p>
		<p id="account" align="center"></p>
	</div>

	<div align="center">
		<button onclick="myFunction()">Current Account</button>
		<p>${currentAccNumber}</p>
		<p>${currentBalance} ${currentCurrency}</p>
		<p id="account" align="center"></p>
	</div>

</body>
</html>


