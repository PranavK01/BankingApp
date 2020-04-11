<html>
<body>
	
	<form action="/" align="right">
		<input type="submit" value="Logout"></input>
	</form>
	<h2 align="center">Welcome ${name}</h2>
	
		<div align="center">
			<h2>Account Number: ${AccNumber}</h2>
			<h2>Current Balance: ${Balance} ${Currency}</h2>
			<h2>Account Status: ${Status}</h2>
		</div>
		<div align="left">
			<a href="/dashboard/AccSummary">Home</a>
		</div>
	 </body>
	 </html>