CJV805 Assignment 2 – Winter 2019
Assignment Submission Form
=================================================================
I/we declare that the attached assignment is my/our own work in accordance
with Seneca Academic Policy. No part of this assignment has been copied
manually or electronically from any other source (including web sites) or
distributed to other students.

Name(s) : SALIHA SHAIKH
Student ID(s) : 12501181

Name(s) :
Student ID(s) :
-----------------------------------------------------------------

>>> Brief Description Of Assignment <<<

Assignment-2 is a Dynamic web project, Which performs create, update, delete, etc tasks on database using servlet and html, jsp pages.
Project is running on Tomcat apache Server 9.0 and mysql database.
It requires ojdbc7_g.jar file for database connection.
this project uses MVC architecture. for that all java files are divided into 2 packages : model and controller

>>Package model :-

Employee.java : This is a java bean class having all get and set methods to manipulate database fileds.

User.java : java bean class to get username and password and set it to varibales.

UserDB.java : java class to varify user is valid to login or not.

DAManagaer.java : It is a java class where all the methods are specified to perform any task.

ConnectionPool.java : This java file handles all connection related methods.
		    : which used to load driver and set username, password into connection url string.


>>Package controller :-

Login.java : This java file passes the username and password to user.java and userDB.java.
	   : If user validated to login then it redirct to Employee_List.html page.

Employee_List.java : This java class take user action.
		   : According to that it will pass that input to related method in DAManager.java file.

EditEmployee.java : This class fetch the current employee data display it in a good formate.
		  : User can update or delete the record using this java class.

NewEmployee.java : This class fetch all user inputed data and sent it to addEmployee method in DAManager.java class 


>>WebContent : This folder contain all html and jsp files. 

Login.html : This html file is a first page in assignment.
    	   : This page allow user to enter username and password.

Logout.jsp : This page confirm that session has been closed. and ask user to login again.

Employee_List.html : After successfull login user will redirect to this html page.
		   : on this page user can choose to display employee list by department id and all employees by clicking on the given buttons.
		   : this page also contain link to NewEmployee.jsp and SearchEmployee.html page.
		   : on the right sight it shows logout button from where user can logout the session.

Employee_List.jsp : This page display Employee_list, where user can click on employee id and it will be redirected to edit employee page.

EditEmployee.jsp : on these page current employee data will be displayed.
		: It also include update and delete button from where user can perform update or delete action.

UpdateDone.jsp : if user click update button and data has been updated successfully 
	       : then this page will confirm the action and display updated columns with Employee new record.

DeleteDone.jsp : Like update this page display confirmation message for successfull delete operation.

NewEmployee.jsp : This page display empty input box where user can enter related values and create new Employee Record. 

Add_Done.jsp : This Page gives confirmation of new employee record.

ErrorPage.jsp : If new employee record is not created then this page will dispaly error message and ask user to enter all values again.

SearchEmployee.html : This html page allow user to enter any character pattern and to display matching result.

SearchEmployee.jsp : This jsp page display matching result.

context.xml : this file is very important, it conatins username, password , drivername and all database connection related information.

web.xml : this file is used to indicate default startup page and it also mapps the servlet.

   


