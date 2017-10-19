<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Customer Home</title>
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
</head>
<body>
<div class="header">
<h1>UNDERWRITING SYSTEM</h1>
</div>

<div class="nav" >
<a class="floatL exp" href="">Home</a> <a  class="floatR exp" href="login.jsp">Logout</a>
</div>

<div class="section">
<div class="current">
<h2>Creating Customer</h2>
</div>
<div><h4>Do you want to create new customer??? </h4><a href=customerRegistration.jsp>CreateCustomer</a></div>

<div><h4>Do you want to view/update/delete a customer??? </h4><br>
Customer Name:<input type=text name=customerName><br>
<a href="../../RuleProposalDtlController?action=customerViewAction&flag=customerViewFlag">View</a></div>
</div>
<div class="footer">
TCS
</div>

</body>
</html>