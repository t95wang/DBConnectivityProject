package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.DAManager;
import model.Employee;

/**
 * Servlet implementation class NewEmployee
 */
@WebServlet("/NewEmployee")
public class NewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int num = 0;
    boolean success = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployee() {
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
		Employee emp = null;
		int flag = 0;
		PrintWriter out= response.getWriter();
	
		int id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		try {
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			date = sf.parse(request.getParameter("hireDate"));
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			//Date hDate = emp.setHire_date(date);

			String jobId = request.getParameter("jobId");
			double salary = Double.parseDouble(request.getParameter("salary"));
			double comm = Double.parseDouble(request.getParameter("comm"));
			int managerId = Integer.parseInt(request.getParameter("managerId"));

			int	deptId = Integer.parseInt(request.getParameter("deptName"));
			

			emp = new Employee(id, fname, lname, email, phone, sqldate, jobId, salary, comm, managerId, deptId);
		} catch (ParseException e) {
			e.printStackTrace();
			
	} 
			flag = obj.addEmployee(emp);
			
			if (flag == 1) {
				request.setAttribute("New_Employee", emp);
				request.setAttribute("emp_id", id);
				request.getRequestDispatcher("/Add_Done.jsp").forward(request, response);
			}
			else {
				request.setAttribute("emp_id", id);
				request.getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
			}

	}

}
