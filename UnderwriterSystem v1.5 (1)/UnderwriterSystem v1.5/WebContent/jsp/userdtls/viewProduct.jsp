<%@page import="java.util.ArrayList"%>
<%@page import="com.us.beans.InsuranceProduct"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylev1.0.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Product</title>

</head>
<body>
	<div class="header">
		<h1>UNDERWRITING SYSTEM</h1>
	</div>
	<div class="nav">
		<a class="floatL exp" href="UserDtlController?action=showhome">Home</a> <a class="floatR exp" href="UserDtlController?action=logout">Logout</a>
	</div>
	<div class="section">
	
	<center>
	
	<h3>View Insurance Product</h3>
	
	</center>
	
		<%
			ArrayList<InsuranceProduct> productList = (ArrayList<InsuranceProduct>) request.getAttribute("productList");
		%>
		<form>
			<br />
			<br />



			<table border="1" align="center">
				<tr>
					<th>PRODUCT ID</th>
					<th>PRODUCT NAME</th>
					<th>COVERAGE ID</th>
					<th>PRODUCT STATUS</th>
					<th>UPDATE/DELETE</th>
				</tr>

				<%
					for (InsuranceProduct product : productList) {
				%>
				<tr>
					<td><%=product.getId()%></td>
					<td><%=product.getName()%></td>
					<td>
						<%
							for (int i = 0; i < product.getCoverage().length; i++) {%>
						<%=product.getCoverage()[i].getName()%>,<%}%>
					</td>
					<td><%=product.getStatus()%></td>
					<%
						if (product.getStatus().equals("Inactive")) {
					%>
					<td>&nbsp;&nbsp;&nbsp;<a class="disableClick" href="UserDtlController?product_id=<%=product.getId()%>&action=autoFill">update</a>&nbsp;&nbsp;<a>delete</a></td>
					<%
						} else {
					%>
					<td>&nbsp;&nbsp;&nbsp;<a href="UserDtlController?product_id=<%=product.getId()%>&action=autoFill">update</a>&nbsp;&nbsp;<a href="UserDtlController?product_id=<%=product.getId()%>&action=deleteProduct">delete</a>
					</td>
					<%
						}
					%>

				</tr>
				<%
					}
				%>
			</table>
		</form>


	</div>

</body>
<div class="footer">TCS</div>
</html>