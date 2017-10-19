<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.us.beans.Customer"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration</title>
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
<script src="../../js/validRule.js"></script>
</head>
<body>
	<div class="header">
		<h1>UNDERWRITING SYSTEM</h1>
	</div>

	<div class="nav">
		<a class="floatL exp" href="">Home</a> <a  class="floatR exp" href="login.jsp">Logout</a>
	</div>

	<div class="section">
		<%
String customerName="",address="",city="",state="", customerType="";
String zipCode="";
String age="";
String phoneNumber="";
String flag ="";
//flag = request.getParameter("flag");
Customer customer = null;
String header =  "";
String actionPerformed = "";
if(flag.equals("updateCustomer")){
	
	customer = (Customer) request.getAttribute("customer");
	customerType=customer.getType();
	customerName = customer.getName();
	age =String.valueOf(customer.getAge());
	address = customer.getAddress();
	city = customer.getCity();
	state=customer.getState();
	zipCode=String.valueOf(customer.getZipCode());
	phoneNumber=String.valueOf(customer.getPhoneNumber());
	
	header="Update New Customer";
	actionPerformed = "updateCustomerAction";
}
else{
	header="Create New Customer";
	actionPerformed = "createCustomerAction";
}
%>
		<div class="current">
			<h2><%=header %></h2>
		</div>
<center>
		<form action="../../RuleProposalDtlController" method="post">

			<table>
				<%if(flag.equals("updateCustomer")){ %>
				<tr>
					<td>Customer Id:</td>
					<td><input type="text" name="custId"
						value="<%=customer.getId()%>" disabled></td>
				</tr>
				<%} %>
				<tr>
					<td>Customer Type*:</td>
					<td><select id="customerType" name="customerType"
						onchange="customerTypeErr();">
							<%if(flag.equals("update")){
	%><option value=customerType><%=customerType %></option>
							<option value="Individual">Individual</option>
							<option value=Group>Group</option>
							<option value=Family>Family</option>

							<%}
else {%>
							<option value="0">Select</option>
							<option value="Individual">Individual</option>
							<option value=Group>Group</option>
							<option value=Family>Family</option>
							<%} %>
					</select></td>
					<td><label id="customerTypeP" class=alertmsg></label></td>
				</tr>
				<tr>
					<td>Customer Name*:</td>
					<td><input type=text name=customerName id="customerName"
						maxlength="50" value="<%=customerName %>" /></td>
					<td><label id="customerNameP" class=alertmsg></label></td>
				</tr>
				<tr id="t1">
					<td>Occupation*:</td>
					<td>
						<%if(flag.equals("updateCustomer"))
						{
if(customer.getOccupation().equalsIgnoreCase("m&n"))
{ %> <input type="radio" name="occupation" value=m&n checked>Mining and Nuclear Field
<input type="radio" name="occupation" value="others">Others <%
						} %> <%
						if(customer.getOccupation().equalsIgnoreCase("others"))
						{
							
	
	%> <input type="radio" name="occupation" value="m&n"> Mining and Nuclear Field 
	     <input type="radio" name="occupation" value="others" checked> Others <%
	

	                    }
						}
						
						else
						{
						%>
						<input type="radio" name="occupation" value="m&n">Mining
						and Nuclear Field <input type="radio" name="occupation"
						value="others">Others</td>
						<%} %>

					</td>
					<td><label id="occupationP" class=alertmsg></label></td>
				</tr>
				</tr>
				<tr>
					<td>Age*:</td>
					<td><input type=text name=age id=age value="<%=age %>">(Enter
						Average age if customer type is family/group)</td>
					<td><label id="ageP" class=alertmsg></label></td>
				</tr>


				<tr id="t2">
					<td>Gender*:</td>
					<td>
						<%if(flag.equals("updateCustomer"))
						{
if(customer.getGender().equalsIgnoreCase("male"))
{ %> <input type="radio" name="gender" value="male" checked> Male <input type="radio" name="gender" value="female">Female <%
						} %> <%
						if(customer.getGender().equalsIgnoreCase("female"))
						{
							//if(customer.getGender().equalsIgnoreCase("female"))
	//{ 
	%> <input type="radio" name="gender" value="male"> Male 
	     <input type="radio" name="gender" value="female" checked> Female <%
	
	//}
	                    }
						}
						
						else
						{
						%>
						<input type="radio" name="gender" value="male">Male 
						<input type="radio" name="gender" value="female">Female 
						<%} %>

					</td>
					<td><label id="genderP" class=alertmsg></label></td>
				</tr>
				<tr>
					<td>Address*:</td>
					<td><textarea rows="2" cols="45" id=address name=address
							<%=address %>></textarea></td>
					<td><label id="addressP" class=alertmsg></label></td>
				</tr>
				<tr>
					<td>City*:</td>
					<td><input type=text name=city maxlength="50" id=city
						value="<%=customerName %>" /></td>
					<td><label id="cityP" class=alertmsg></label></td>
				</tr>
				<tr>
					<td>State*:</td>
					<td><input type=text name=state maxlength="50" id=state
						value="<%=state %>" /></td>
					<td><label id="stateP" class=alertmsg></label></td>
				</tr>
				<tr>
					<td>Zip Code*:</td>
					<td><input type=text name=zipcode maxlength="10" id=zipcode
						value="<%=zipCode %>" /></td>
					<td><label id="zipcodeP" class=alertmsg></label></td>
				</tr>
				<tr>
					<td>Phone Number*:</td>
					<td><input type=text name=phnNo maxlength="10" id=phnNo
						value="<%=phoneNumber %>" /></td>
					<td><label id="phnNoP" class=alertmsg></label></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register"
						class="btn btn-primary " onclick="return validateCustomer();">
				</tr>
				<tr>
					<td><input type="hidden" name="action"
						value="<%=actionPerformed %>" /></td>
					<td><input type="hidden" name="custId"
						value="<%=(customer!=null?customer.getId():0)%>"></td>
				</tr>
			</table>
		</form></center>
	</div>
	<div class="footer">TCS</div>
</body>
</html>