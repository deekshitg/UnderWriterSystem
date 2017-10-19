<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,com.us.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylev1.0.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View User</title>
</head>
<body>
	<div class="header">
		<h1>UNDERWRITING SYSTEM</h1>
	</div>

	<div class="nav">
		<a class="floatL exp" href="UserDtlController?action=showhome">Home</a> <a class="floatR exp" href="UserDtlController?action=logout">Logout</a>
	</div>

	<div class="section">
		<div class="current" align="center">
			<h2>Welcome to User Details View Page</h2>
		</div>
		<%
			ArrayList<User> userlist = (ArrayList<User>) request.getAttribute("usersList");
			if (userlist!=null && userlist.size() > 0) {
		%>
		<table border="1" align="center">
			<tr>
				<th>ID</th>
				<th>User Name</th>
				<th>Role</th>
				<th>Status</th>
				<th>Password</th>
				<th>Update</th>
			</tr>
			<%
				for (User user : userlist) {
			%>
			<tr>
				<td><%=user.getUserId()%></td>
				<td><%=user.getUserName()%></td>
				<td><%=user.getRole()%></td>
				<td><%=user.getUserStatus()%></td>
				<td><%=user.getPassword()%></td>
				<%
						if (!user.getUserStatus().equals("Active")) {
					%>
					<td>&nbsp;<a class="disableClick" href="UserDtlController?id=<%=user.getUserId()%>&action=updateUser">update</a>&nbsp;&nbsp;<a>delete</a></td>
					<%
						} else {
					%>
					<td>&nbsp;<a href="UserDtlController?id=<%=user.getUserId()%>&action=updateUser">update</a>&nbsp;&nbsp;<a href="UserDtlController?id=<%=user.getUserId()%>&action=deleteUser" onclick="return confirm('do you want to delete Id:<%=user.getUserId()%>')" >delete</a>
					</td>
					<%
						}
					%>
				
			</tr>
			<%
				}
			%>
		</table>
		<%
			} else {
		%>
		No such records found....!!!
		<%
			}
		%>
	</div>

	<div class="footer">Footer</div>

</body>
</html>