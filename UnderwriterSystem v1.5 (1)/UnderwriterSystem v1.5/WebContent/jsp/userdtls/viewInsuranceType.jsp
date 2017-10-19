<%@page import="java.util.ArrayList"%>
<%@page import="com.us.beans.*"%><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view insurance type</title>
<link rel="stylesheet" type="text/css" href="css/stylev1.0.css">
</head>
<body>

<div class="header">
<h1>UNDERWRITING SYSTEM</h1>
</div>
<div class="nav">
	<a class="floatL exp" href="UserDtlController?action=showhome">Home</a> <a class="floatR exp" href="UserDtlController?action=logout">Logout</a>
</div>

<div class="section">

<h3 align="center">View Insurance Type</h3>
<%ArrayList<InsuranceType> typelist=(ArrayList<InsuranceType>) request.getAttribute("typelist"); 


%>

<form><br />
<br />

<%if(typelist!=null && typelist.size()>0){ %>

<table border="1" align="center">
	<tr>
		<th>Insurance Type ID</th>
		<th>Insurance Type Name</th>
		<th>Products Name</th>
		<th>Insurance Type Status</th>
		<th>UPDATE/DELETE</th>
	</tr>

	<%
					for (InsuranceType insuranceType : typelist) {
				%>
				<tr>
					<td><%=insuranceType.getId()%></td>
					<td><%=insuranceType.getName()%></td>
					<td>
						<%
							for (int i = 0; i < insuranceType.getInsuranceProducts().length; i++) {%>
						<%=insuranceType.getInsuranceProducts()[i].getName()%>,<%}
						%>
					</td>
					<td><%=insuranceType.getStatus()%></td>
					<%
						if (insuranceType.getStatus().equals("Inactive")) {
					%>
					<td>&nbsp;&nbsp;&nbsp;<a class="disableClick" href="UserDtlController?type_id=<%=insuranceType.getId()%>&action=autoFillInsuranceType">update</a>&nbsp;&nbsp;<a>delete</a></td>
					<%
						} else {
					%>
					<td>&nbsp;&nbsp;&nbsp;<a href="UserDtlController?type_id=<%=insuranceType.getId()%>&action=autoFillInsuranceType">update</a>&nbsp;&nbsp;<a href="UserDtlController?type_id=<%=insuranceType.getId()%>&action=deleteType" onclick="return confirm('Are you sure to delete?')">delete</a>
					</td>
					<%
						}
					%>

				</tr>
				<%
					}	}
				%>
</table>
</form>
</div>


<div class="footer">TCS</div>
</body>
</html>