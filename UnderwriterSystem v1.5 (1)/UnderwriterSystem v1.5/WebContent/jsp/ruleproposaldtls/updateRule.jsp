<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.us.beans.Rule,java.util.ArrayList,
				com.us.beans.InsuranceType"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/stylev1.0.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATE RULE</title>
<script src="../../js/validRule.js" type="text/javascript"></script>
</head>
<body>
	<%
		String occu_others_perc = "";
		String occu_min_nuc_perc = "";
		String gender_female ="";
		String gender_male_perc = "";
		String gov_tax_perc = "";
		String age_below_40_yrs_perc = "";
		String age_bet_60_to_40_yrs_perc = "";
		String age_bet_80_to_60_yrs_perc = "";
		String age_above_80_yrs_perc = "";
		String insurance_type_id = "";
		String flag = request.getParameter("flag");

		Rule rule = null;
		String actionHeader ="";
		String actionPerformed = "";
		if (flag.equals("updateRuleEngine")) {

			rule = (Rule) request.getAttribute("rule");

			insurance_type_id = String.valueOf(rule.getInsurance_type_id());
			age_above_80_yrs_perc = String.valueOf(rule.getAge_above_80_yrs_perc());
			age_bet_80_to_60_yrs_perc = String.valueOf(rule.getAge_bet_80_to_60_yrs_perc());
			age_bet_60_to_40_yrs_perc = String.valueOf(rule.getAge_bet_60_to_40_yrs_perc());
			age_below_40_yrs_perc = String.valueOf(rule.getAge_below_40_yrs_perc());
			gov_tax_perc = String.valueOf(rule.getGov_tax_perc());
			gender_male_perc = String.valueOf(rule. getGender_male_perc());
			gender_female = String.valueOf(rule.getGender_female());
			occu_min_nuc_perc = String.valueOf(rule.getOccu_min_nuc_perc());
			occu_others_perc = String.valueOf(rule.getOccu_others_perc());
			actionHeader = "Update Rule";
			actionPerformed = "updateRule";

			
		} else {
			actionHeader = "Create Rule";
			actionPerformed = "createRule";
		}
	%>
	
	<form action="RuleProposalDtlController" method="post" onsubmit="return validateFormUpdateRuleEngine();">

		<div class="header">
			<h1>UNDERWRITING SYSTEM</h1>
		</div>

		<div class="nav">
			<div class="floatL">
				<a href="homeRule.jsp">Home</a> <a href="homeRule.jsp">Back</a>
			</div>
			<div class="floatR">
				<a href="css.html">Logout</a>
			</div>
		</div>
		<div class="section">

			<h1 align="center">RULE ENGINE</h1>
			<h3 align="center"><%=actionHeader%></h3>
			<div align="center">Insurance Type *: 
			<select id=insuranceType name=insuranceType>
			<option value="">SELECT</option>
			<%
		ArrayList<InsuranceType> ins=(ArrayList<InsuranceType>)request.getAttribute("insuranceList");
			if(ins.size() >0) 
			{
			for(InsuranceType temp:ins) 
			{%>
			<option value="<%=temp.getId() %>"><%=temp.getName() %></option>
				<%}} %>
				</select>
				</div>
			<br>
			<div style="float: left; width: 40%; margin-left: 9%;" align="left">
				<div>
					<table>
						<tr>
							<th align="left">Age Component</th>
						</tr>
						<tr>
							<td align="left">>80 Years</td>
							<td>: <input type=text name="above_80" value=<%=age_above_80_yrs_perc %> id="above_80"></td>
							<td><label style="color: red;" id="above_80A"></label></td>
						</tr>
						<tr>
							<td>Between 60 to 80 Years</td>
							<td>: <input type=text name="bet_60to80" id="bet_60to80" value=<%=age_bet_80_to_60_yrs_perc %>></td>
							<td><label style="color: red;" id="bet_60to80A"></label></td>
						</tr>
						<tr>
							<td>Between 40 to 80 Years</td>
							<td>: <input type=text  name="bet_40to60"
								id="bet_40to60" value=<%=age_bet_60_to_40_yrs_perc %>></td>
							<td><label style="color: red;" id="bet_40to60A"></label></td>
						</tr>
						<tr>
							<td align="left"><40 Years</td>
							<td>: <input type=text  name="below_40" value=<%=age_below_40_yrs_perc %>
								id="below_40"></td>
							<td><label style="color: red;" id="below_40A"></label></td>
						</tr>
					</table>
				</div>
			</div>
			<div style="float: right; width: 40%; margin-right: 10%;"
				align="left">
				<div>
					<table>
						<tr>
							<th>Government Tax Component</th>
						</tr>
						<tr>
							<td align="left">Tax Percentage</td>
							<td>: <input type=text  name="gov_tax" value=<%=gov_tax_perc %>
								id="gov_tax">
							<td><label style="color: red;" id="gov_taxA"></label></td>
							</td>
						</tr>
						<tr>
							<th align="left">Gender Component</th>
						</tr>
						<tr>
							<td align="left">Male</td>
							<td>: <input type=text name="male"  value=<%=gender_male_perc %> id="male">
							</td>
							<td><label style="color: red;" id="maleA"></label></td>
						</tr>
						<tr>
						<tr>
							<td align="left">Female</td>
							<td>: <input type=text  name="female" value=<%=gender_female %> 
								id="female">
							<td><label style="color: red;" id="femaleA"></label></td>
							</td>
						</tr>
						<tr>
					</table>
				</div>
			</div>

			<div
				style="width: 70%; margin-left: 10%; margin-top: 13%; margin-right: 20%;"
				align="center">

				<table>
					<tr>
						<th align="left">Occupation Component</th>
					</tr>

					<tr>
						<td align="left">Mining & Nuclear</td>
						<td>: <input type=text  name="mining" value=<%=occu_min_nuc_perc %> 
							id="mining"></td>
						<td><label style="color: red;" id="miningA"></label></td>
					</tr>
					<tr>
						<td align="left">Others</td>
						<td>: <input type=text  name="others" value=<%=occu_others_perc %> id="others"></td>
						<td><label style="color: red;" id="othersA"></label></td>
					</tr>

				</table>
			</div>
			<div style="margin-top: 5%" align="center">
				<input class="btn btn-primary" type="submit" value=" <%=actionHeader%>"
					name="<%=actionPerformed %>" >
			</div>

		</div>

		<div class="footer">Footer</div>
	</form>
</body>
</html>



