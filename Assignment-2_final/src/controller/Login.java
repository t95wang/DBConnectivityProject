package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.User;
import model.UserDB;

@WebServlet("/LOGIN")
public class Login extends HttpServlet {
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
     	// get request parameters for email and password
        String un = request.getParameter("username");
        String pwd = request.getParameter("password");

        // store data in User object
        User user = new User();
        user.setUsername(un);
        user.setPassword(pwd);

        // check the email and password from database
        boolean pass = UserDB.CkeckUser(user);

        if (pass) {
        	// set User object in request object and and forward to LoginSuccess.jsp page
            //request.setAttribute("user", user);
        
            getServletContext().getRequestDispatcher("/Employee_List.html")
            .forward(request, response);
            //response.sendRedirect("F:\\Eclipse_jee\\Eclipse_jee_workspace\\Assignment-2_EmployeeList\\WebContent\\Employee_List.html");
        } else {
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out= response.getWriter();
            out.println("<p style=\"color:red;\">User Name or Password is wrong. "
            		+ "Please try again.</p>");
            rd.include(request, response);
            //rd.forward(request, response);
        }
	}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
    		throws ServletException, IOException {
        doPost(request, response);
    } 
}

