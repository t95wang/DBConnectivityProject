package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.ConnectionPool;
import model.Employee;
import test.DAManager;

/**
 * Servlet implementation class Employee_List
 */
@WebServlet("/Employee_List")
public class Employee_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee_List() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    DataSource dataSource;
	Context initContext;
    
	public void init() throws ServletException {
		try {
			// Get DataSource
			Context initContext  = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/cjv805_191a34");

			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAManager obj = new DAManager();
		ArrayList<Employee> objList = new ArrayList<Employee>();
		
		String action = request.getParameter("List");
		PrintWriter out= response.getWriter();
		
		if(action.equals("Show Department Employees")) {
			int id = Integer.parseInt(request.getParameter("deptID"));
			try {
				objList = obj.getEmployeesByDepartmentID(id);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				objList = obj.getAllEmployees();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		request.setAttribute("Employee_List", objList);
		request.getRequestDispatcher("/Employee_List.jsp").forward(request, response);
	}

}
