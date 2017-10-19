<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList,com.us.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RULE ENGINE</title>
</head>
<body>
	<form>
		<div class="header">
			<h1>UNDERWRITING SYSTEM</h1>
		</div>

		<div class="nav">
			<div class="floatL">
				<a href="css.html">Home</a>
				</div>
			<div class="floatR">
				<a href="css.html">Logout</a>
			</div>
		</div>

<div class="section">
		<h1 align="center">RULE ENGINE</h1>
		<br><br>
		<h1 align="center">
		<a href="RuleProposalDtlController?action=createRule&flag=createRuleEngine"><input class="btn btn-primary" value="CREATE NEW RULE" name="create_rule"></a>
		</h1>
			<%ArrayList<InsuranceType> ins=(ArrayList<InsuranceType>)request.getAttribute("insuranceList");
			if(ins.size() >0) 
			{%>
			<table align="center"  style="margin-top: 5%" >
			<tr>
				<th>Insurance Type</th>
				<th> Action</th>
				<th> Action</th>
				<th> Action</th>
			</tr>
				<%
			for(InsuranceType temp:ins) 
			{%>
			
			<tr>
				<td><%=temp.getName() %></td>
			    <td><a href="RuleProposalDtlController?action=viewRule&flag=viewRuleEngine"><input class="btn btn-primary" value="View" name="view"></a></td>
				<td><a href="RuleProposalDtlController?action=updateRule&flag=updateRuleEngine"><input class="btn btn-primary" value="Update" name="update"></a></td>
				<td><a href="RuleProposalDtlController?action=deleteRule&flag=deleteRuleEngine"><input class="btn btn-primary" value="Delete" name="delete"></a></td>
			</tr>
			</table>
				<%}} %>
				
		
			</div>
		<div class="footer">Footer</div>
	</form>
	
</body>
</html>