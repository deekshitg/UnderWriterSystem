<%@page import="com.us.beans.InsuranceProduct"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="java.util.ArrayList"%>
<%@ page import="com.us.beans.Coverage"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insurance Product</title>
<link rel="stylesheet" type="text/css" href="css/stylev1.0.css">
<script src="js/valid.js"></script>
</head>
<body>
<%String action=request.getAttribute("action").toString();
String productName="";int productId=0;String productStatus="active";
ArrayList<Coverage> arraylist=(ArrayList<Coverage>)request.getAttribute("arraylist");
InsuranceProduct insuranceProduct=(InsuranceProduct)request.getAttribute("insuranceProduct");
String submit="create";
if(action.equals("autoFill")){
	
	productName=insuranceProduct.getName();
	System.out.println(productName);
	 productId=insuranceProduct.getId();
 productStatus=insuranceProduct.getStatus();
 submit="update";

}


%>
	<div class="header">
		<h1>UNDERWRITING SYSTEM</h1>
	</div>
	<div class="nav">
		<a class="floatL exp" href="UserDtlController?action=showhome">Home</a> <a class="floatR exp" href="UserDtlController?action=logout">Logout</a>
	</div>

	<div class="section">
		<form action="UserDtlController" method="post">
			<br />
			<center>
				<h3>Creating New Insurance Product</h3>
			</center>

			<table align="center">
			<%if(action.equals("autoFill")){ %>
				<tr>
					<td><label for="productId">Product Id</label></td>
					<td><input type="text" name="productId" id="productId" value="<%=productId%>" disabled></td>
				</tr>
<%} %>
				<tr>

					<td><label for="productnName">Product Name</label></td>
					<td><input type="text" id="productName" name="productName" value="<%=productName%>"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><label class="alertmsg" id="alertName"></label></td>
				</tr>

				<tr>
					<td><label for="coverages">Coverages</label></td>
					
						<%if(action.equals("autoFill")){%><td><% for(Coverage coverage:arraylist) {
							int temp=0;
							for(int i=0;i<insuranceProduct.getCoverage().length;i++){
								if(insuranceProduct.getCoverage()[i].getName().equals(coverage.getName())){%>
									<input type="checkbox" name="coverage" id="<%=coverage.getName()%>" value="<%=coverage.getId()%>" checked><%=coverage.getName()%><br>
									<%temp=1;
								    
									
								 }
							}
							if(temp==0)
							{
								%><input type="checkbox" name="coverage" id="<%=coverage.getName()%>" value="<%=coverage.getId()%>"><%=coverage.getName()%><br>
						<% }	}%></td><%
						} 
						%>
						<%if(action.equals("fetchCoverage")){
							%><td>
							<%for(Coverage coverage:arraylist) {%> <input type="checkbox"
						name="coverage" id="<%=coverage.getName()%>"
						value="<%=coverage.getId()%>"><%=coverage.getName()%><br>
						<%} %></td><%} %>
					
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><label class="alertmsg" id="alertCoverage"></label></td>
				</tr>

				<tr>
					<td><label for="status">Status</label></td>
					<td> <input type="text" id="status" name="status" value="Active" disabled>
						</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="btn btn-primary"
						type="submit" value="<%=submit%>" onclick="return checkProduct()"></td>
				</tr>
			</table>
			<br /> <%if(action.equals("fetchCoverage")){ %><input type="hidden" name="action" value="createProduct">
			<%}if(action.equals("autoFill")){
				%><input type="hidden" name="action" value="updateProduct">
				<input type="hidden" name="productId" value="<%=productId%>">
			<%}%>

			<br />

		</form>
	</div>
</body>
</html>