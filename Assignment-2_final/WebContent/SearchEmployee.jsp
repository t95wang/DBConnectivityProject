<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="ca.myseneca.model.Employee"%> 
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>SearchEmployee</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>    
</head>

<body>
    <h1>Search Employee</h1>
    <p align="center">Here is the information that you searched:</p><% request.getParameter("word"); %>


	<table align="center" cellpadding="4" cellspacing="4">
		<tr>

		</tr>
		<tr bgcolor="#008000">
			<td><b>Name</b></td>
			<td><b>Department</b></td>
			<td><b>Job ID</b></td>
			<td><b>Salary </b></td>
			<td><b>Email</b></td>
			<td><b>Phone Number</b></td>
		</tr>
		<% ArrayList<Employee> employeeData =(ArrayList<Employee>) request.getAttribute("employee");%>

		<%for (int i=0; i<employeeData.size(); i++){ %>
		<tr bgcolor="#8FBC8F">
			<td><%=employeeData.get(i).getFirstname()%></td>
			<td><%=employeeData.get(i).getDepartment()%></td>
			<td><%=employeeData.get(i).getJob_id()%></td>
			<td><%=employeeData.get(i).getSalary()%></td>
			<td><%=employeeData.get(i).getEmail()%></td>
			<td><%=employeeData.get(i).getPhone_number()%></td>
		</tr>
		<%} %>
	</table>

	<p align="center" >To return the page, click on the Back 
    button in your browser or the Return button shown 
    below.</p>

    <form action="Employee_List.html" method="get">
        <input type="submit" value="Return">
    </form>
</body>
</html>



