<html>
<body>
	<form action="/" align="right">
		<input type="submit" value="Logout"></input>
	</form>
	<h2 align="center">Welcome ${name}</h2>
	
	<div>
	<form method="post" action="/dashboard/Profile/update/ack" >
		${field}: 
		<input type="text" name="field" required></input>
		<br>
		<input type="submit" value="Update"></input>
	</form>
	</div>
	
	<div align="left">
			<a href="/dashboard/Profile">Back</a>
			<br>
			<a href="/dashboard/AccSummary">Home</a>
	</div>
	
</body>
</html>