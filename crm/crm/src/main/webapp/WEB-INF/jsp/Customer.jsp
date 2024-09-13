<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.util.*" %>
 <%@ page import = "com.example.crm.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<style>

</style>
<script>
function validate(action,id)
{
	var fname=document.form1.fname.value;
	var lname=document.form1.lname.value;
	var email=document.form1.emailid.value;
	var phonenum=document.form1.phonenum.value;
	if ((fname=="")||(lname=="")||(email=="")||(phonenum==""))
		{
		  alert("Please fill all the mandatory fields")
		  return false;
		}
	if(check_email(email) == false)
		{
		   alert("Please enter valid email address");
		   return false;
		}
	if (!checkPhoneNumber(phonenum)) {
        alert("Please enter a valid phone number");
        return false;
    }
	return true;
	}
	
function check_email(val){
    if(!val.match(/\S+@\S+\.\S+/)){ // Jaymon's / Squirtle's solution
        // Do something
        return false;
    }
    if( val.indexOf(' ')!=-1 || val.indexOf('..')!=-1){
        // Do something
        return false;
    }
    return true;
}
function checkPhoneNumber(phoneNumber) {
    // Regular expression for a valid phone number (simple example)
    var phonePattern = /^[0-9]{10}$/; // Example: 1234567890

    // Check if the phone number matches the pattern
    if (!phonePattern.test(phoneNumber)) {
        return false; // Phone number does not match the pattern
    }

    return true; // Phone number is valid
}

</script>
</head>
<body>
<form name="form1" action="/customer/save" method="post">


<h2 style="background-color:#00cc33; padding: 10px 0;color: white">CRM - Customer Relationship Manager</h2>

<p><b>Save Customer</b></p>
<% Customer custObj=(Customer)request.getAttribute("custObj");
   String fName="";
   String lName="";
   String emailId="";
   String phonenum="";
   String id="";
   if (custObj!=null) {
	   fName = custObj.getFirstname();
	   lName = custObj.getLastname();
	   emailId = custObj.getEmailid();
	   phonenum = custObj.getPhonenum();
	   id = String.valueOf(custObj.getId());
   }

%>
<input type="hidden" name="id" value='<%= id %>' >
<table style="width: 40%">

<tr><td width="20%" style="text-align: right">*First Name: </td>  <td><input type="text" maxlength="40" name="fname" value='<%= fName %>'/></td></tr>
<tr><td width="20%" style="text-align: right">*Last Name: </td><td> <input type="text" maxlength="40" name="lname" value='<%= lName %>'/></td></tr>
<tr><td width="20%" style="text-align: right">*Email: </td><td><input type="text" maxlength="100" name="emailid" value='<%= emailId %>'/></td></tr>
<tr><td width="20%" style="text-align: right">*phonenum: </td><td><input type="text" maxlength="100" name="phonenum"  value='<%= phonenum %>'/></td></tr>
</table>
<br>
<div style="margin-left: 20%"><input type="submit" name="save" value="Save" onclick="return validate();" style="padding-left: 40px; padding-right: 40px"/></div> <br><br>

<a href="/customer/list" >Back to List</a>


</form>
</body>
</html>



