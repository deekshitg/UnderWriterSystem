<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@ page import="com.us.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register Insurance Product</title>
<link rel="stylesheet" type="text/css" href="css/stylev1.0.css">
<script src="js/valid.js"></script>
<script src="../../js/valid.js"></script>
</head>
<body>
<%String action=request.getAttribute("action").toString();
String insuranceTypeName="";int insuranceTypeId=0;
String submit="create";
ArrayList<InsuranceProduct> productList=(ArrayList<InsuranceProduct>)request.getAttribute("productList");
InsuranceType insuranceType=(InsuranceType)request.getAttribute("insuranceType");
if(action.equals("autoFill")){
	
	insuranceTypeName=insuranceType.getName();
	
	insuranceTypeId=insuranceType.getId();
	submit="update";
 //productStatus=insuranceProduct.getStatus();

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
				<h3>Creating New Insurance Type</h3>
			</center>

			<table align="center">
			<%if(action.equals("autoFill")){ %>
				<tr>
					<td><label for="insuranceTypeId">InsuranceType Id</label></td>
					<td><input type="text" name="insuranceTypeId" id="insuranceTypeId" value="<%=insuranceTypeId%>" disabled></td>
				</tr>
<%} %>
				<tr>

					<td><label for="insuranceTypeName">InsuranceType Name</label></td>
					<td><input type="text" id="insuranceTypeName" name="insuranceTypeName" value="<%=insuranceTypeName%>"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><label class="alertmsg" id="alertName"></label></td>
				</tr>

				<tr>
					<td><label for="productsAvailable">Products Available</label></td>
					
						<%if(action.equals("autoFill")){%><td><% for(InsuranceProduct insuranceProduct:productList) {
							int temp=0;
							for(int i=0;i<insuranceType.getInsuranceProducts().length;i++){
								
								if(insuranceType.getInsuranceProducts()[i].getName().equals(insuranceProduct.getName())){%>
									<input type="checkbox" name="product" id="<%=insuranceProduct.getName()%>" value="<%=insuranceProduct.getId()%>" checked><%=insuranceProduct.getName()%><br>
									<%temp=1;
							 }
							}
							if(temp==0)
							{
								%><input type="checkbox" name="product" id="<%=insuranceProduct.getName()%>" value="<%=insuranceProduct.getId()%>"><%=insuranceProduct.getName()%><br>
						<% }	}%></td><%
						} 
						%>
						<%if(action.equals("fetchingProductDetails")){
							%><td>
							<%for(InsuranceProduct insuranceProduct:productList) {%> 
							<input type="checkbox" name="product" id="<%=insuranceProduct.getName()%>" value="<%=insuranceProduct.getId()%>"><%=insuranceProduct.getName()%><br>
						<%} %></td><%} %>
					
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><label class="alertmsg" id="alertProduct"></label></td>
				</tr>

				<tr>
					<td><label for="status">Status</label></td>
					<td><input type="radio" name="status" value="Active" id="status" checked></input>Active<br>
					<input type="radio" name="status" value="Inactive" id="status"  ></input>Inactive</td>
									
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="btn btn-primary"
						type="submit" value="<%=submit %>" onclick="return checkType1()"></td>
				</tr>
			</table>
			<br /> <%if(action.equals("fetchingProductDetails")){ %><input type="hidden" name="action" value="createInsuranceType">
			<%}else if(action.equals("autoFill")){
				%><input type="hidden" name="action" value="updateInsuranceType">
				<input type="hidden" name="type_id" value="<%=insuranceTypeId%>">
			<%}%>

			<br />

		</form>
	</div>
</body>
</html>