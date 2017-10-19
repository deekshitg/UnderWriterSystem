<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insurance Product</title>
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">

</head>
<body>

<div class="header">
<h1>UNDERWRITING SYSTEM</h1>
</div>
<div class="nav">
	<a class="floatL exp" href="../../UserDtlController?action=showhome">Home</a> <a class="floatR exp" href="../../UserDtlController?action=logout">Logout</a>
</div >
<div class="section">
<form>
<center>
<h3>Insurance Product Home</h3>
<br>
<a href="../../UserDtlController?action=fetchCoverage"><b>Create Product</b></a><br/><br/>
<a href="../../UserDtlController?action=viewProduct"><b>View/Edit/Delete Product</b></a>
</center>



</form>

</div>
<div class="footer">
TCS
</div>

</body>
</html>