<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View</title>
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
</head>
<body>
<div class="header">
<h1>UNDERWRITING SYSTEM</h1>
</div>

<div class="nav">
<a class="floatL exp" href="">Home</a> <a  class="floatR exp" href="login.jsp">Logout</a>
</div>

<div class="section">
<div class="current">
<h2>Customer Details</h2>
</div>

<form action="" method="post">
<table border=1>

<tr>
<td>Customer Id</td>
<td>Customer Type</td>
<td>Customer Name</td>
<td>Occupation</td>
<td>Age</td>
<td>Gender</td>
<td>Address</td>
<td>City</td>
<td>State</td>
<td>ZipCode</td>
<td>Phone Number</td>
<td>Update Details</td>
<td>Delete Details</td>
</tr><br><br><br>


<!--iterate over customer arraylist%>-->
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td><input type="submit" name=update value="Update"></td>
<td><input type="submit" name=delete value="Delete"></td>
</tr>

</table>
</form>
</div>
<div class="footer">
TCS
</div>


</body>
</html>