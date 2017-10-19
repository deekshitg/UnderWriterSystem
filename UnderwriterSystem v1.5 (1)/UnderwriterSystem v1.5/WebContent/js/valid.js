var flag = "<%=flag%>";

if(flag=='updateUser')
	setValues();

function validate() {
	var x = document.getElementById("name").value;
	var y= document.getElementById("pwd").value;
	var z= document.getElementById("pwd1").value;
	var w=document.getElementById("role").value;
	var s=document.getElementById("status");
	
	if (x == "") {
		 document.getElementById('nameerror').innerHTML="<font color=\"red\">*Please enter a username</font>";
		return false;
	}
	if (y== "") {
		document.getElementById('passworderror').innerHTML="<font color=\"red\">*please enter your password</font>";
		document.getElementById('nameerror').innerHTML="";
		return false;
	}
	if (z == "") {
		document.getElementById('passworderror1').innerHTML="<font color=\"red\">*please fill this field correctly</font>";
		document.getElementById('nameerror').innerHTML="";
		document.getElementById('passworderror').innerHTML="";
		return false;
	}
	if(y!=z){
		document.getElementById('passworderror1').innerHTML="<font color=\"red\">*password mismatch</font>";
		document.getElementById('nameerror').innerHTML="";
		document.getElementById('passworderror').innerHTML="";
		return false;
	}
	if(w == -1){
		document.getElementById('roleerror').innerHTML="<font color=\"red\">*Please assign a role.</font>";
		document.getElementById('nameerror').innerHTML="";
		document.getElementById('passworderror').innerHTML="";
		document.getElementById('passworderror1').innerHTML="";
		return false;
	}
	if (s== "") {
		document.getElementById('statuserror').innerHTML="<font color=\"red\">*please enter status/font>";
		document.getElementById('nameerror').innerHTML="";
		document.getElementById('passworderror').innerHTML="";
		document.getElementById('passworderror1').innerHTML="";
		document.getElementById('stateerror').innerHTML="";
		return false;
	}
	return true;
}

function setValues(){
	document.getElementById("role").value = "<%=user!=null?user.getRole():-1%>";
	}


function validateCoverage_creation(){
	var Errors=["",null];
	var ErrorType=["please enter non empty coverage name","please enter non Integer coverage name"];
	for(var i=0;i<ErrorType.length;i++){
		if(document.getElementById("coveragename").value==Errors[i]){
			 document.getElementById("creationerror").innerHTML=ErrorType[i];
			 return false;
		 }
	}
	 if(!isNaN(document.getElementById("coveragename").value)){
		 document.getElementById("creationerror").innerHTML=ErrorType[1];
		 return false;
	 }
	 return true;
}

function checkType()
{
	 var ans=true;
	var status=document.getElementById("status").checked;
	var insuranceType = document.getElementById("insuranceTypeName").value;
	
	if(insuranceType=="")
	{
		document.getElementById("alertName").innerHTML="Please Enter Name";
		ans= false;
	}
	
	if(document.getElementById('product1').checked == false && document.getElementById('product2').checked == false && document.getElementById('product3').checked == false) {
		
		document.getElementById("alertinsurancetype").innerHTML="Please select product";
		ans= false;
	}
	if(status==false)
	{
		document.getElementById("alertstatus").innerHTML="status should be active";
		ans= false;
	}
	
	return ans;

}
function checkProduct()
{
	var result = true;
	var ProductName=document.getElementById("productName").value;
	var  re=/^[a-z\d\-_\s]+$/i;
	if(!re.test(ProductName))
	{
		document.getElementById("alertName").innerHTML="";
		document.getElementById("alertName").innerHTML="*name field should be alphanumeric";
		document.getElementById("productName").value = "";
		
		result=false;
	}
  else
	{
		document.getElementById("alertName").innerHTML="";
	}
	
	
	if(ProductName=="")
	{
		document.getElementById("alertName").innerHTML="";
		document.getElementById("alertName").innerHTML="*name field should not be empty";
	
		result = false;
		
	}
	
	if(ProductName.length>30)
	{
		document.getElementById("alertName").innerHTML="*name should be max 30 character";
		document.getElementById("productName").value = "";
		
		result = false;
		
	}
	if(!checkOneCheckbox())
		{
		 document.getElementById("alertCoverage").innerHTML="*select coverage";
		 result=false;
		}
	else
		{
		document.getElementById("alertCoverage").innerHTML="";
		}
	
	return result;
}
function checkOneCheckbox (){

	   var checkboxes=document.getElementsByName("coverage"); //all should be same
	   var is_checked=false;
	   for(var i=0;i<checkboxes.length;i++)
	   {
	      if(checkboxes[i].checked)
	      {
	        is_checked=true;
	      }
	   }
	   return is_checked;
}


function checkType1()
{
	var result = true;
	var insuranceTypeName=document.getElementById("insuranceTypeName").value;
	var  re=/^[a-zA-Z]*$/;
	if(!re.test(insuranceTypeName))
	{
		document.getElementById("alertName").innerHTML="";
		document.getElementById("alertName").innerHTML="*name field should not be alphanumeric";
		document.getElementById("insuranceTypeName").value = "";
		
		result=false;
	}
  else
	{
		document.getElementById("alertName").innerHTML="";
	}
	
	if(insuranceTypeName=="")
	{
		document.getElementById("alertName").innerHTML="";
		document.getElementById("alertName").innerHTML="*name field should not be empty";
	
		result=false;
		
	}
	
	if(insuranceTypeName.length>30)
	{
		document.getElementById("alertName").innerHTML="*name should be max 30 character";
		document.getElementById("insuranceTypeName").value = "";
		
		result = false;
		
	}
	if(!checkOneCheckbox1())
		{
		 document.getElementById("alertProduct").innerHTML="*select product";
		 result=false;
		}
	else
		{
		document.getElementById("alertProduct").innerHTML="";
		}
	
	return result;
}
function checkOneCheckbox1 (){

	   var checkboxes=document.getElementsByName("product"); //all should be same
	   var is_checked=false;
	   for(var i=0;i<checkboxes.length;i++)
	   {
	      if(checkboxes[i].checked)
	      {
	        is_checked=true;
	      }
	   }
	   return is_checked;  
}