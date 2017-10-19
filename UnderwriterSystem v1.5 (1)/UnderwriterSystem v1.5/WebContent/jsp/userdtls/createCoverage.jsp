<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.us.beans.Coverage"%><html>
<head>
<script type="text/javascript" src="js/valid.js"></script>
<link rel="stylesheet" type="text/css" href="css/stylev1.0.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CreateCoverage</title>
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
<% 
String operation=(String)request.getParameter("flag");
if("coverageUpdation".equals(operation)){
	
ArrayList<Coverage> updateCoverage=(ArrayList<Coverage>)request.getAttribute("updateCoverage");	
Coverage coverage=updateCoverage.get(0);
%>

<h2>update Coverage</h2>
</div>
<form action="UserDtlController?coverageid=<%=coverage.getId()%>" method="get">
<table align="center">

<tr>
<td><label>Coverage ID : </label></td>
<td><input type="text" name="coverageId" id="coverageid" maxlength="30" value="<%=coverage.getId() %>" disabled></td>
</tr>
<tr>
<td><label>Coverage Name : </label></td>
<td><input type="text" name="coverageName" id="coveragename" maxlength="30" value="<%=coverage.getName() %>"></td>
</tr>
<tr><td>&nbsp;</td><td><font color="red"> <p id="creationerror"> </p></font></td></tr>
<tr>
<td><label>Status : </label></td>
<td><input type="text" name="status" id="status" value="Active" disabled></td>
</tr>

<tr><td>&nbsp;</td><td>
<input type="hidden" name="coverageid" value="<%=coverage.getId()%>"/>
<input type="hidden" name="action" value="updateCoverage"/>
<input type="submit" value="update" class="btn btn-primary" onclick="return validateCoverage_creation();"></input>
<input type="reset" value="Cancel" class="btn btn-primary"></input>
</td></tr>
</table>
</form>

<%} %>
<%if("coverageCreation".equals(operation)){
%>
<h2>Create Coverage</h2>
</div>
<form action="UserDtlController" method="get">
<table align="center">
<tr>
<td><label>Coverage Name : </label></td>
<td><input type="text" name="coverageName" id="coveragename" maxlength="30"></td>
</tr>
<tr><td>&nbsp;</td><td><font color="red"> <p id="creationerror"> </p></font></td></tr>
<tr>
<td><label>Status : </label></td>
<td><input type="text" name="status" id="status" value="Active" disabled></td>
</tr>

<tr><td>&nbsp;</td><td>
<input type="hidden" name="action" value="createCoverage"/>
<input type="submit" value="Create" class="btn btn-primary" onclick="return validateCoverage_creation();"></input>
<input type="reset" value="Cancel" class="btn btn-primary"></input>
</td></tr>
</table>
</form>
<%} %>
</div>

<div class="footer">
Footer
</div>

</body>
</html>