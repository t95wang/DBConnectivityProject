<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ErrorPage</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>    
</head>

<body>
    <h2>New employee was not added successfully due to invalid Job ID, Manager ID or existing Employee ID.</h2>
    
    <p align="center">Please use the botton below to add a new employee again.</p>

    <form action="NewEmployee.jsp" method="get">
        <input type="submit" value="Return">
    </form>
</body>
</html>