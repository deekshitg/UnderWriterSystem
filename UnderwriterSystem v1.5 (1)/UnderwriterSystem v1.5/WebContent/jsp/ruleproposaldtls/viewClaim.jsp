<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, com.us.beans.Claim"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="header">
<h1>UNDERWRITING SYSTEM</h1>
</div>

<div class="nav">
<a class="exp" href="css.html">Home</a> <a class="exp" href="css.html">Logout</a>
</div>

<div class="section">
<div class="current">
<h2 align="center">Claim Management</h2>
</div>
<center>
<form action="" method="post">
<table border=1>

<tr>
<th>Claim ID</th>
<th>Customer ID</th>
<th>Policy ID</th>
<th>Claim Amount</th>
<th>Claim Date</th>
</tr>


<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
</table>
</form>
<br>
<button type="button" class="btn btn-primary"  value="New Claim" onclick="window.location='addClaim.jsp'">New Claim</button>
<button type="button" class="btn btn-primary"  value="Back" onclick="window.location='RuleProposalDtlController?action=viewClaimlaimAction&flag=viewClaimFlag'">Back</button>

</center>
</div>

<div class="footer">
Footer
</div>

</body>
</html>