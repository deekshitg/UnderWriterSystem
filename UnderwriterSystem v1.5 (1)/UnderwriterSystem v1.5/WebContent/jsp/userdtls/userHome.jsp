<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Home</title>
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
<link rel="stylesheet" type="text/css" href="css/stylev1.0.css">
</head>
<body>

	<div class="header">
		<h1>UNDERWRITING SYSTEM</h1>
	</div>

	<div class="nav">
		<a class="floatL exp" href="../../UserDtlController?action=showhome">Home</a> <a class="floatR exp" href="../../UserDtlController?action=logout">Logout</a>
	</div>

	<div class="section">
		<center>
			<h2>User Home Page</h2>
			<a href="createUser.jsp?flag=create">Create User</a><br> <a href="../../UserDtlController?action=viewUsers">View User</a>
		</center>
	</div>

	<div class="footer">Footer</div>
</body>
</html>