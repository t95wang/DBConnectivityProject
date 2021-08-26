
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <link rel="stylesheet" href="styles/main.css" type="text/css"/>  
   <title>Deleted Employee</title> 
  </head> 
  <body> 
  	 
       <h1>Record Added Successfully</h1> 
         <%int emp_id = (int)request.getAttribute("emp_id"); 
        %>
        
        <h2>Employee id: <%=emp_id %> is Added to Database...</h2>


	<p align="center">To return the page, click on the Back button in
		your browser or the Return button shown below.</p>

	<form action="Employee_List.html" method="get">
		<input type="submit" value="Return">
	</form>
</body> 
</html>