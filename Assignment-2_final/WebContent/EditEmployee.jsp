<%@page import="model.Employee" %>
<%@page import="model.DAManager" %>
<%@page import="java.util.ArrayList"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
  <link rel="stylesheet" href="styles/main.css" type="text/css" />
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Edit Employee</title> 
  </head> 
  <body> 
  		<h1>Edit Employee Page</h1>
  	   <form action="EditEmployee" method="post" > 
       <%int ids = Integer.parseInt(request.getParameter("id"));
        Employee emp = null;
        DAManager obj = new DAManager();
        emp = obj.getEmployeesByID(ids);
        
        %> 
        <%-- Arranging data in tabular form 
        --%> 
      
      <table > 
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
            <td><input type="number" name="phone" value="<%=emp.getPhone_number()%>"> </td>
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
            <td><input type="number" name="salary" value="<%=emp.getSalary()%>"> </td>
           </tr>
           <tr>
            <td><b>Commission Pct</b></td>
            <td><input type="number" name="comm" value="<%=emp.getCommission_pct()%>" min=0 max=1 step=0.1> </td>
           </tr>
           <tr>
            <td><b>Manager ID</b></td>
             <td><input type="number" name="managerId" value="<%=emp.getManager_id()%>"></td>
           </tr>
           <tr>
            <td><b>Department</b></td>
            <td><%ArrayList<String> deptlist = new ArrayList<String>();
              deptlist = obj.getDepartmentName2(emp.getDepartment_id());%>
              <Select name ="deptName">  
              <option value="<%= emp.getDepartment_id() %>" > <%= obj.getDeptNameById(emp.getDepartment_id()) %> </option>
              <%for ( int i=0; i < deptlist.size(); i++) {	 
               %> 
              <option value="<%= obj.getDeptIdByName(deptlist.get(i)) %>" > <%= deptlist.get(i) %> </option>
               <% } %>
              </Select> </td>
         </tr> 
         <tr>
         	<td> </td>
         	<td><input type="submit" name="Button" value="Update the Employee" class="margin_left">
         		<input type="submit" name="Button" value="Delete the Employee" class="margin_left"> </td>
         </tr>

        </table>  
    	</form>
    	<p align="center">To return the Employee List page click on the back button in your browser or the Return button shown below.</p>

    <form action="Employee_List.html" method="get">
        <input type="submit" value="Return">
    </form>
    	
    </body> 
</html>