<!DOCTYPE html>
<html>
<head>
<title>Add Employee</title>
</head>
<body>

<h2>Add employee</h2>

<form action ="/employee-crud/employees" method = "post">

Name : <input type = "text" name = "name" required> <br><br>
Email : <input type = "text" name = "email" required> <br><br>
Salary : <input type = "number" step = "0.01" name = "salary" required> <br><br>

<button type ="submit">Add Employee</button>
</form>

</body>
</html>