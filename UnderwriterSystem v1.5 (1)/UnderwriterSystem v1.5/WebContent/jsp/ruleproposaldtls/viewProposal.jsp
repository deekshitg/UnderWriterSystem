<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<a class="exp floatL" href="proposalManagement.jsp">Home</a> <a class="exp floatR" href="logout.jsp">Logout</a>
</div>

<div class="section">
<div class="current">
<h2>Proposal Lists</h2>
</div>
<form action="" method="post">
<table border=1>

<tr>
<th>Proposal ID</th>
<th>Customer ID</th>
<th>Insurance Type</th>
<th>Sum Insured</th>
<th>Number Of Years</th>
<th>Insurance Product</th>
<th>Referred By</th>
<th>Update option</th>
<th>Delete option</th>
</tr>


<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td><a href="RuleProposalDtlController?action=updateProposalAction&flag=updateProposalFlag">UPDATE</a></td>
<td><a href="RuleProposalDtlController?action=deleteProposalAction&flag=deleteProposalFlag">DELETE</a></td>
</tr>

</table>
</form>
</div>

<div class="footer">
TCS
</div>


</body>
</html>