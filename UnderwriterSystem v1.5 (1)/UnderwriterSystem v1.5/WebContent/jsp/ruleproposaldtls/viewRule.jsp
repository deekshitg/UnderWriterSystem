<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="com.us.beans.Rule"%>
<head>
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW RULE</title>
</head>
<body>
<%
		String occu_others_perc = "";
		String occu_min_nuc_perc = "";
		String gender_female = "";
		String gender_male_perc = "";
		String gov_tax_perc = "";
		String age_below_40_yrs_perc = "";
		String age_bet_60_to_40_yrs_perc = "";
		String age_bet_80_to_60_yrs_perc = "";
		String age_above_80_yrs_perc = "";
		String insurance_type_id = "";
		String flag = request.getParameter("flag");

		Rule rule = null;
		String actionHeader = "";
		String actionPerformed = "";
		if (flag.equals("view")) {

			rule = (Rule) request.getAttribute("rule");

			insurance_type_id = String.valueOf(rule.getInsurance_type_id());
			age_above_80_yrs_perc = String.valueOf(rule.getAge_above_80_yrs_perc());
			age_bet_80_to_60_yrs_perc = String.valueOf(rule.getAge_above_80_yrs_perc());
			age_bet_60_to_40_yrs_perc = String.valueOf(rule.getAge_above_80_yrs_perc());
			age_below_40_yrs_perc = String.valueOf(rule.getAge_above_80_yrs_perc());
			gov_tax_perc = String.valueOf(rule.getAge_above_80_yrs_perc());
			gender_male_perc = String.valueOf(rule.getAge_above_80_yrs_perc());
			gender_female = String.valueOf(rule.getAge_above_80_yrs_perc());
			occu_min_nuc_perc = String.valueOf(rule.getAge_above_80_yrs_perc());
			occu_others_perc = String.valueOf(rule.getAge_above_80_yrs_perc());
	

			
	
		}
	%>
	<form>
		<div class="header">
			<h1>UNDERWRITING SYSTEM</h1>
		</div>

		<div class="nav">
			<div class="floatL">
				<a href="homeRule.jsp">Home</a>
				<a href="homeRule.jsp">Back</a>
			</div>
			<div class="floatR">
				<a href="css.html">Logout</a>
			</div>
		</div>

<div class="section">
		<h1 align="center">RULE ENGINE</h1>
		<h3 align="center">VIEW RULE</h3>
		<br>
		<table align="center">
			<tr>
				<th>Insurance Type</th>
				<th> *******</th>
			</tr>
			<tr>
				<td>Age Component</td>
			</tr>
			<tr></tr>
			<tr>
				<td>>80 Years</td>
				<td>: ********</td>
			</tr>
			<tr>
				<td>Between 60 to 80 Years</td>
				<td>: ******</td>
			</tr>
			<tr>
				<td>Between 40 to 80 Years</td>
				<td>: ****</td>
			</tr>
			<tr>
				<td><40 Years</td>
				<td>: ******</td>
			</tr>
			<tr></tr>
			<tr>
				<td>Government Tax Component</td>
			</tr>
			<tr>
				<td>Tax Percentage</td>
				<td>: *******</td>
			</tr>
			<tr></tr>
			<tr>
				<td>Gender Component</td>
			</tr>
			<tr>
				<td>Male</td>
				<td>: ******</td>
			</tr>
			<tr>
				<td>Female</td>
				<td>: ******</td>
			</tr>
			<tr></tr>
			<tr>
				<td>Occupation Component</td>
			</tr>
			<tr>
				<td>Mining & Nuclear</td>
				<td>: ******</td>
			</tr>
			<tr>
				<td>Others</td>
				<td>: ******</td>
			</tr>

		</table>
		<br> <br>
		<div style="margin-top: 5%"  align="center">
		<table align="center">
			<tr>
				<td><a href="updateRule.jsp"><input class="btn btn-primary" value="UPDATE" name="update_rule"></a></td>
				<td><input class="btn btn-primary" type="submit" value="DELETE" name="delete_rule"></td>
			</tr>
		</table>
		</div>
		</div>
		<div class="footer">Footer</div>
	</form>
	
</body>
</html>