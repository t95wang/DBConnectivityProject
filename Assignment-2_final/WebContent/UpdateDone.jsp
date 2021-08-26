<%@page import="model.Employee" %>
<%@page import="model.DAManager" %>
<%@page import="java.util.ArrayList"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
  <head> 
   <meta http-equiv="Content-Type" href="styles/main.css" content="text/html; charset=UTF-8"> 
   <link rel="stylesheet" href="styles/main.css" type="text/css"/>  
   <title>Edit Employee</title> 
  </head> 
  <body> 
  	 
       <h1>Record Updated Successfully</h1> 
         <%Employee emp = (Employee)request.getAttribute("Employee_List"); 
        ArrayList<String> col = (ArrayList<String>)request.getAttribute("Columns"); 
        DAManager obj = new DAManager();
        %>
       <h2>Columns updated: </h2>
       <%for(int i=0; i<col.size(); i++) { %>
    	  <p align="center"> <%= col.get(i) %> </p>
       <% } %>
    	<h1>Employee New Information Shows Below:</h1>
        
       
        <table align="center" > 
         <tr> 
          <td><b>Employee ID</b></td> 
          <td><input type="number" name="id" value="<%=emp.getEmployee_id()%>" > </td>
         </tr>
         <tr>
          <td><b>First Name</b></td>
          <td><input type="text" name="fname" value="<%=emp.getFirstname()%>"> </td> 
         </tr>
         <tr> 
          <td><b>Last Name</b></td>
          <td><input type="text" name="lname" value="<%=emp.getLastname()%>"> </td>
         </tr> 
         <tr>
           <td><b>Email</b></td>
           <td><input type="text" name="email" value="<%=emp.getEmail()%>"> </td>
         </tr>
         <tr> 
            <td><b>Phone Number</b></td>
            <td><input type="text" name="phone" value="<%=emp.getPhone_number()%>"> </td>
         </tr>
         <tr>
            <td><b>Hire Date</b></td>
             <td><input type="date" name="hireDate" value="<%=emp.getHire_date()%>"> </td> 
          </tr>
          <tr>
            <td><b>Job ID</b></td>
            <td><input type="text" name="jobId" value="<%=emp.getJob_id()%>"> </td>
           </tr>
           <tr>
            <td><b>Salary</b></td>
            <td><input type="text" name="salary" value="<%=emp.getSalary()%>"> </td>
           </tr>
           <tr>
            <td><b>Commission Pct</b></td>
            <td><input type="text" name="comm" value="<%=emp.getCommission_pct()%>"> </td>
           </tr>
           <tr>
            <td><b>Manager ID</b></td>
             <td><input type="number" name="managerId" value="<%=emp.getManager_id()%>"></td>
           </tr>
           <tr>
            <td><b>Department</b></td>
            <td><input type="text" name="deptId" value="<%=obj.getDeptNameById(emp.getDepartment_id())%>"></td>
         </tr> 
		
        </table>

	<p align="center">To return the page, click on the Back button in
		your browser or the Return button shown below.</p>

	<form action="Employee_List.html" method="get">
		<input type="submit" value="Return">
	</form>
</body> 
</html>


