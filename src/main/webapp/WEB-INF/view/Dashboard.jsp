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
		
		<hr>
		<a href="/dashboard/AccountInfo">Account Information</a> <br> 
		
		<a href="/dashboard/FundTransfer">Fund Transfer</a> <br> 
	
	</div>
<hr>
	<div align="center">
		<h3>${type}</h3>
		<p>${AccNumber}</p>
		<p>${Balance} ${Currency}</p>
	</div>
	
</body>
</html>


