<%@ page import = "java.util.List" %>
<%@ page import = "com.example.model.Employee" %>

<!DOCTYPE html>
<html>
<head>
<title> Employee List </title>
<a href = "add-employee.jsp"> Add New Employee</a><br></br>
</head>
<body>

<h2>Employee List</h2>
<table border = "1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Salary</th>
</tr>

<% List<Employee> employee = (List<Employee>) request.getAttribute("employees");

for( Employee emp : employee){
%>

<tr>
<td> <%= emp.getId() %></td>
<td> <%= emp.getName() %></td>
<td> <%= emp.getEmail() %></td>
<td> <%= emp.getSalary() %></td>
</tr>

<%
}
%>
</table>
</body>
</html>