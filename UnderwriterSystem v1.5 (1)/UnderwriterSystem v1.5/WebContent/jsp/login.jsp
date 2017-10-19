<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/stylev1.0.css">
</head>
<body>

<%
	String display = request.getAttribute("invalid")!=null?request.getAttribute("invalid").toString():"none";
%>

<div class="header">
<h1>UNDERWRITING SYSTEM</h1>
</div>

<div class="section">
<div class="current">
<h2>Login Page :</h2>
</div>

<form action="UserDtlController" method="post">
<table border="1" align="center">

	<tr>
		<td>Username:</td>
		<td><input type="text" name="uname" id="uname"/></td>
	</tr>
	
	<tr>
		<td>Password:</td>
		<td><input type="password" name="password" id="password"/></td>
	</tr>

	<tr>
		<td>Role:</td>
		<td>
			<select name="role" id="role">
				<option value="-1">-Select-</option>
				<option value="Admin">Admin</option>
				<option value="Underwriter">Underwriter</option>
				<option value="Manager">Manager</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center"><input type="submit" class="btn-primary" name="btnSubmit" value="Login" onclick="return validate();"/></td>
	</tr>
	
</table>
	<p align="center" style="color:red;display:<%=display%>">Invalid Credentials</p>
<input type="hidden" name="action" value="login" />
</form>

</div>

<div class="footer">Footer</div>

</body>

<script>

function validate(){

	
	var uName = document.getElementById('uname').value;
	var password = document.getElementById('password').value;
	var uType = document.getElementById('role').value;

	if(uName == ""){

		alert("Please enter Username:");
		return false;
	}
	else if(password == ""){
	
		alert("Please enter Password:");
		return false;
	}
	else if(uType == -1){
		alert("Please Select Role");
		return false;
	}
	else
		return true;	
}
</script>


</html>