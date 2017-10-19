<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/stylev1.0.css">
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
<title>Admin Home</title>
</head>
<body>
	<div class="header">
		<h1>UNDERWRITING SYSTEM</h1>
	</div>

	<div class="nav">
		<a class="floatR exp" href="UserDtlController?action=logout">Logout</a>
	</div>
	<div class="section">
		<center>
			<h2>Welcome Admin</h2>
			<table>
				<tr>
					<td><a href="jsp/userdtls/userHome.jsp">User Management</a>
					<td>
				</tr>
				<tr>
					<td><a href="jsp/userdtls/coverageHome.html">Coverage Management</a>
					<td>
				</tr>
				<tr>
					<td><a href="jsp/userdtls/insuranceProductHome.jsp">Product Management</a>
					<td>
				</tr>
				<tr>
					<td><a href="jsp/userdtls/insuranceTypeHome.html">Insurance Type Management</a>
					<td>
				</tr>
			</table>
		</center>
	</div>
	
	<div class="footer">Footer</div>

</body>
</html>