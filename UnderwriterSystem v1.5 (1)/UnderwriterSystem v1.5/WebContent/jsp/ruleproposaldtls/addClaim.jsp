<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
  <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
<script src="../../js/validRule.js"></script>
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
<h2 align="center">Adding Claim</h2>
</div>
<center> 
<form action="RuleProposalDtlController" method="post">
<table>
<tr><td align="right">Customer ID :</td>
<td align="left"><select name="customerID" id="customerID" onchange="return cusIDErr();">
	<option value="0"> select</option>
	<option value="1">1</option>
	<option value="2">2</option>
</select></td>
</tr>
<tr>
<td></td>
<td><p class="alertmsg" id="cusIDErr"></p></td>
</tr>
<tr><td align="right">Policy ID :</td>
<td align="left"><select name="policyID" id="policyID" onchange="return policyIDErr();">
	<option value="-1">select</option>
	<option value="1">1</option>
	<option value="2">2</option>
</select></td>
</tr>
<tr>
<td></td>
<td><p class="alertmsg" id="policyIDErr"></p></td>
</tr>
<tr>
    <td align="right">Claim Amount :</td>
    <td align="left"><input type="text" name="claimAmount" id="claimAmount" onchange="return claimAmountErr();"></td>
 </tr>
 <tr>  
   <td></td> 
    <td><p class="alertmsg" id="claimAmountErr"></p></td>
</tr>
<tr>
    <td align="right">Payment Date :</td>
    <td align="left"><input type="text" name="payDate" id="datepicker"></input></td>
</tr>
<tr>
<td>
<input type="hidden" value="addClaim" name="action">
<br>
<button type="button" class="btn btn-primary" onclick="return validateAddClaim();">Submit</button>
<button type="button" class="btn btn-primary"  value="Back" onclick="window.location='viewClaim.jsp'">Back</button>

</td>
</tr>
</table>
</form>
</center>
</div>

<div class="footer">
Footer
</div>

</body>
</html>