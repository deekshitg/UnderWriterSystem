<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.us.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/stylev1.0.css">
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
<title>Create User</title>
<script src="../../js/valid.js" type="text/javascript"></script>
<script src="js/valid.js" type="text/javascript"></script>
</head>
<body>
	<%
		String fName = "";
		String flag = (String) request.getAttribute("flag");
		if (flag == null) {
			flag = request.getParameter("flag");
		}
		User user = null;
		String header = "";
		String actionPerformed = "";
		String actionString = "";
		
		if (flag.equals("update")) {

			user = (User) request.getAttribute("user");
			fName = user.getUserName();
			header = "Update User";
			actionPerformed = "updatedUser";
			actionString = "UserDtlController";

		} else {
			header = "Create User";
			actionPerformed = "createUser";
			actionString = "../../UserDtlController";
		}
	%>
	<div class="header">
		<h1>UNDERWRITING SYSTEM</h1>
	</div>

	<div class="nav">
		<a class="floatL exp" href="../../UserDtlController?action=showhome">Home</a> <a class="floatR exp" href="../../UserDtlController?action=logout">Logout</a>
	</div>

	<div class="section">
		<center>
			<form name="CreateUser" onsubmit="return validate();"
				action="<%=actionString %>" method="post">

				<h3><%=header%></h3>
				<table>	
					<%
						if (flag.equals("update")) {
					%>
					<tr>
						<td>User Id:</td>
						<td><input type="text" name="uId" maxlength="10" id="uid"
							value="<%=user.getUserId()%>" disabled></td>
					</tr>
					<%
						}
					%>
					<tr>
						<td>User Name* :</td>
						<td><input type="text" name="name" maxlength="10" id="name"
							value="<%=fName%>"></td>
					</tr>
					<tr>
						<td>&nbsp;
						<td><p id="nameerror"></td>
					</tr>
					<tr>
						<td>Password* :</td>
						<td><input type="password" name="pwd" id="pwd"></td>
					</tr>
					<tr>
						<td>&nbsp;
						<td><p id="passworderror"></p></td>
					</tr>
					<tr>
						<td>Re-Enter Password* :</td>
						<td><input type="password" name="pwd1" id="pwd1"></td>
					</tr>
					<tr>
						<td>&nbsp;
						<td><p id="passworderror1"></p></td>
					</tr>
					<tr>
						<td>Role* :</td>
						<td><select name="role" id="role">
								<option value="-1">Select</option>
								<option value="Admin">Admin</option>
								<option value="Manager">Manager</option>
								<option value="Underwriter">Underwriter</option>
						</select></td>
					</tr>
					<tr>
						<td>&nbsp;
						<td><p id="roleerror"></p></td>
					</tr>
					<tr>
						<td>Status* :</td>
						<td><input type="text" name="status" id="status"
							value="Active" disabled></td>
					</tr>
					<tr>
						<td>&nbsp;
						<td><p id="statuserror"></p></td>
					</tr>
				</table>
				<input type="hidden" name="action" value="<%=actionPerformed%>" />
				<input type="hidden" name="userId"
					value="<%=user != null ? user.getUserId() : 0%>" /> &nbsp; <br>
				<input class="btn btn-primary" type="submit" value="Submit">

			</form>
		</center>
	</div>

	<div class="footer">Footer</div>
	<%
		//}
	%>
</body>

</html>