<%@page import="model.Employee" %>
<%@page import="model.DAManager" %>
<%@page import="java.util.ArrayList"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html><head>
   <meta charset="utf-8">
   <title>New Employee</title>
   <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
   <link rel="stylesheet" href="styles/main.css" type="text/css" />

</head>
<body>
  	<p style="text-align:right"><b>Susan Mavris</b>
	<a href="Logout.jsp"> <span class="glyphicon glyphicon-log-out"></span> Log out
	</a></p>
   <form action="NewEmployee" method="post">
   	  <nav>
   	  	<a href="Employee_List.html">Employee List</a>
   	  	<a href="NewEmployee.jsp">New Employee</a>
   	  	<a href="SearchEmployee2.html">Search Employee</a>
   	  </nav>  
      
       <h1>New Employee Page</h1> 

      <table > 
         <tr> 
          <td><b>Employee ID</b></td> 
          <td><input type="number" name="id" > </td>
         </tr>
         <tr>
          <td><b>First Name</b></td>
          <td><input type="text" name="fname" > </td> 
         </tr>
         <tr> 
          <td><b>Last Name</b></td>
          <td><input type="text" name="lname" > </td>
         </tr> 
         <tr>
           <td><b>Email</b></td>
           <td><input type="text" name="email" > </td>
         </tr>
         <tr> 
            <td><b>Phone Number</b></td>
            <td><input type="number" name="phone" required pattern="[0-9]" 
             title="Enter numbers and . only"> </td>
         </tr>
         <tr>
            <td><b>Hire Date</b></td>
             <td><input type="date" name="hireDate" placeholder="YYYY-MM-DD"/> </td> 
          </tr>
          <tr>
            <td><b>Job ID</b></td>
            <td><input type="text" name="jobId" > </td>
           </tr>
           <tr>
            <td><b>Salary</b></td>
            <td><input type="number" name="salary" > </td>
           </tr>
           <tr>
            <td><b>Commission Pct</b></td>
            <td><input type="number" name="comm" min="0" max="1" step="0.1"> </td>
           </tr>
           <tr>
            <td><b>Manager ID</b></td>
             <td><input type="number" name="managerId" ></td>
           </tr>
           <tr>
            <td><b>Department</b></td>
            <td><%DAManager obj = new DAManager();
              ArrayList<String> deptlist = new ArrayList<String>();
              deptlist = obj.getDepartmentName();%>
              <Select name ="deptName" style="width: 180px">  
              <%for ( int i=0; i < deptlist.size(); i++) {	 
               %> 
              <option value="<%= obj.getDeptIdByName(deptlist.get(i)) %>" > <%= deptlist.get(i) %> </option>
               <% } %>
              </Select> </td>
         </tr> 
         <tr>
         	<td> </td>
         	<td><input type="submit" name="Button" value="Save the New Employee" class="margin_left">
         		<input type="reset"  value="Clear" class="margin_left"> </td>
         </tr>

        </table> 
         <footer>
      	<p>@ Seneca College CJV805</p>
      </footer> 
    	</form>
    </body> 
</html>