<%@page import="com.us.beans.Broker"%>
<%@page import="com.us.beans.InsuranceProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.us.beans.Customer"%>
<%@page import="com.us.beans.Proposal"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
<script src="../../js/validRule.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 String proposal_Id="";     
String customer_Id="";        
String insurance_Type_Id="";
String sum_Insured="";
String no_Of_Years="";
String refeBroker="";            
 String proposalStatus="";
String quoteStatus="";
String policy_Id="";
String flag = request.getParameter("flag");

Proposal proposal = null;
String actionHeader ="";
String actionPerformed = "";

if(flag.equals("updateProposalFlag")){
	
	proposal = (Proposal) request.getAttribute("proposal");
	
	proposal_Id=String.valueOf(proposal.getId());
	customer_Id=String.valueOf(proposal.getCustomer().getId());
	insurance_Type_Id =String.valueOf(proposal.getInsuranceType().getId());
	sum_Insured =String.valueOf(proposal.getSumInsured());
	no_Of_Years = String.valueOf(proposal.getNoOfYears());
	refeBroker=String.valueOf(proposal.getRefeBroker().getName());
	proposalStatus=String.valueOf(proposal.getProposalStatus());
	quoteStatus=String.valueOf(proposal.getQuoteStatus());
	policy_Id=String.valueOf(proposal.getPolicyId());
	actionHeader="Update New Proposal";
	actionPerformed = "updateProposal";	
}
else{
	actionHeader="Create New Proposal";
	actionPerformed = "createProposal";
}

%>

<form action="../../RuleProposalDtlController" method="post" onsubmit="return validateProposal();">

<div class="header">
			<h1>UNDERWRITING SYSTEM</h1>
		</div>

		<div class="nav">
			<div class="floatL">
				<a href="proposalManagement.jsp">Home</a> <a href="proposalManagement.jsp">Back</a>
			</div>
			<div class="floatR">
				<a href="css.html">Logout</a>
			</div>
		</div>
		<div class="section">

			<h1 align="center">Proposal</h1>
			<h3 align="center"><%=actionHeader%></h3>
	
	<table align="center">
	
	<% if(flag.equals("updateProposal")){ %>
	<tr><td align="right">Proposal Id:</td>
	<% ArrayList<Proposal> proplist=(ArrayList<Proposal>) request.getAttribute("proposalIdList"); 
	for(Proposal list:proplist){
	%>
	<td align="left"> <%= list.getId()%>
	</td>
	<% } } %>	
	</tr>
	<tr><td align="right">Customer ID :</td>
        <td align="left"><select name="customerID" id="customerID" onchange="return cusIDErr();">
<% 
ArrayList<Customer> custIDList=(ArrayList<Customer>) request.getAttribute("custIDList");
if (custIDList.size()>0)
	for(Customer list:custIDList){
%>	
	<option value="">--select--</option>
	<option value="list.getId()">list.getId()</option>
	<% } %>
</select></td>
</tr>
<tr>
<td></td>
<td><p id="cusIDErr" class="alertmsg"></p></td>
</tr>
<tr>
	<td align="right">Insurance Type :</td>
	<td align="left"><input type="text" name="insuranceType"></td>
</tr>
<tr>
    <td align="right">Sum Insured :</td>
    <td align="left"><input type="text" name="sumInsured" id="sumInsured" onchange="return sumInsuredErr();"></td>
  </tr>
<tr> 
<td></td>
    <td><p id="sumInsuredErr" class="alertmsg"></p></td>
</tr>
<tr>
    <td align="right">No of Years :</td>
    <td align="left"><input type="text" name="years" id="years"  onchange="return yearsErr();"> </td>
   </tr>
<tr>
<td></td>
    <td><p id = "yrsErr" class="alertmsg"></p></td>
</tr>
<tr>
    <td align="right">Insurance Product :</td>
    <td align="left"><select name="insProduct" id="insProduct" onchange="return insProductErr();">
 <% 
ArrayList<InsuranceProduct> productList=(ArrayList<InsuranceProduct>) request.getAttribute("productList");
if (productList.size()>0)
	for(InsuranceProduct list:productList){
%>	   
	<option value="">--select--</option>
	<option value="list.getName()">list.getName()</option>
	<% } %>
</select></td>
</tr>
<tr>
<td></td>
<td><p id="insProductErr" class="alertmsg"></p></td>
</tr>
<tr>
    <td align="right">Referred By :</td>
    <td align="left"><select name="refBy" id="refBy" onchange="return refByErr();">
 <% 
ArrayList<Broker> brokerList=(ArrayList<Broker>) request.getAttribute("brokerList");
if (brokerList.size()>0)
	for(Broker list:brokerList){
%>	     
	<option value="">--select--</option>
	<option value="list.getName()">list.getName()</option>
	<% } %>
</select></td>
</tr>
<tr>
<td></td>
<td><p id="refByErr" class="alertmsg"></p></td>
</tr>
<tr>
<td>

<button type="button" class="btn btn-primary" onclick="return validateProposal();">Submit</button>
 <input type="reset" value="Reset" class="btn btn-primary">
</td>
</tr>
	
</table>
<input type="hidden" name="action" value="<%=actionPerformed %>" />
<input type="hidden" name="propID" value="<%=proposal!=null?proposal.getId():0%>" />

</div>
<div class="footer">TCS</div>
</form>


</body>
</html>