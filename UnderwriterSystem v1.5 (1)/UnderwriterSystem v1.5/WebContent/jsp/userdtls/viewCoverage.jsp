<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.us.beans.Coverage"%><html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylev1.0.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewCoverage.jsp</title>
</head>
<body>

<div class="header">
<h1>UNDERWRITING SYSTEM</h1>
</div>

<div class="nav">
	<a class="floatL exp" href="UserDtlController?action=showhome">Home</a> <a class="floatR exp" href="UserDtlController?action=logout">Logout</a>
</div>

<div class="section">
<a href="jsp/userdtls/coverageHome.html">Coverage Home</a>
<div class="current" align ="center">
<h2>Welcome to View Page</h2>
</div>
<%ArrayList<Coverage> viewList=(ArrayList<Coverage>)request.getAttribute("ViewCoverageList");
%>
<table align="center" border="1">
<tr>
<th>ID</th>
<th>Coverage Name</th>
<th>Status</th>
<th>Update</th>
</tr>
<%for(Coverage coverage:viewList) {%>
<tr align="center">
<td style="weight:10%"><%=coverage.getId() %></td>
<td style="weight:50%"><%=coverage.getName() %></td>
<td style="weight:50%"><%=coverage.getStatus() %></td>

					<%
						if (!coverage.getStatus().equals("Active")) {
					%>
					<td>&nbsp;<a class="disableClick" href="UserDtlController?action=coverageUpdation&id=<%=coverage.getId()%>">update</a>&nbsp;&nbsp;<a>delete</a></td>
					<%
						} else {
					%>
					<td>&nbsp;<a href="UserDtlController?action=coverageUpdation&id=<%=coverage.getId()%>">update</a>&nbsp;&nbsp;<a href="UserDtlController?action=deleteCoverage&id=<%=coverage.getId()%>" onclick="return confirm('do you want to delete Id:<%=coverage.getId()%>')" >delete</a>
					</td>
					<%
						}
					%>
</tr>
<%} %>
</table>
</div>

<div class="footer">
Footer
</div>
</body>
</html>