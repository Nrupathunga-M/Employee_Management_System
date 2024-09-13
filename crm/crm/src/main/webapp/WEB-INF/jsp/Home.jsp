<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.util.*" %>
 <%@ page import = "com.example.crm.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td {
  border: 1px solid #dddddd;
  text-align: center;
  padding: 8px;
}
 th {
  border: 1px solid #dddddd;
  background-color:#00cc33;
  color: white;
  text-align: center;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<script>
function funAction(action,id)
{
	if(action=="delete") {
		if (confirm("Are you sure you want to delete the customer?") == true) {
			window.location="/customer/delete?id="+id;
		}		
	}
	if(action=="update") {		
			window.location="/customer/update?id="+id;		
	}
}
</script>
</head>
<body>

<h2 style="background-color:#00cc33; padding: 10px 0;color: white">CRM - Customer Relationship Manager</h2>

<input type="button" name="Add" value="Add Customer" onclick="window.location='add'"/><br><br>
<table>
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Phonenum</th>
    <th>Action</th>
  </tr>
  <%
  List<Customer> list=(List<Customer>)request.getAttribute("list");
  for (Customer item : list) {
	  
  %>
  <tr>
    <td><%= item.getFirstname() %></td>
    <td><%= item.getLastname() %></td>
    <td><%= item.getEmailid() %></td>
    <td><%= item.getPhonenum() %></td>
    <td><a href="javascript:funAction('update','<%=item.getId() %>');">Update</a> | <a href="javascript:funAction('delete','<%=item.getId()%>');">Delete</a></td>
  </tr>
  <%
  }
  %>
 
</table>

</body>
</html>

