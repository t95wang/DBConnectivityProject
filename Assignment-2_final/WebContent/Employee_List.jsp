<%@page import="model.Employee" %>
<%@page import="java.util.ArrayList"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Country List</title> 
   <link rel="stylesheet" href="styles/main.css" type="text/css"/>
  </head> 
  <body> 
      <h1>Employee List</h1> 
  
      <table align="center" cellpadding="4" cellspacing="4"> 
         <tr bgcolor="#008000"> 
          <th><b>Employee ID</b></th> 
          <th><b>First Name</b></th> 
          <th><b>Last Name</b></th>
           <th><b>Email</b></th>
            <th><b>Phone Number</b></th>
            <th><b>Hire Date</b></th> 
            <th><b>Job ID</b></th>
            <th><b>Salary</b></th>
            <th><b>Commission Pct</b></th>
            <th><b>Manager ID</b></th>
            <th><b>Department ID</b></th>
         </tr> 
        
        <%ArrayList<Employee> std = (ArrayList<Employee>)request.getAttribute("Employee_List"); 
        for(Employee emp :std){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr bgcolor="#8FBC8F"> 
                <td><a href ="EditEmployee.jsp?id=<%=emp.getEmployee_id()%>" > <%= emp.getEmployee_id() %></a> </td>
                <td><%=emp.getFirstname()%> </td>
                <td><%=emp.getLastname()%> </td>
                <td><%=emp.getEmail()%> </td>
                <td><%=emp.getPhone_number()%> </td>
                <td><%=emp.getHire_date()%> </td>
                <td><%=emp.getJob_id()%> </td>
                <td><%=emp.getSalary()%> </td>
                <td><%=emp.getCommission_pct()%> </td>
                <td><%=emp.getManager_id()%> </td>
                <td><%=emp.getDepartment_id()%> </td>
			</tr> 
            <%}
       		 %> 
        </table> 
      <p align="center">To return the page, click on the Back 
    button in your browser or the Return button shown 
    below.</p>
	<div>
    <form action="Employee_List.html" method="get">
        <input type="submit" value="Return">
        </form></div>
    </body> 
</html>