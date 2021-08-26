package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 * Servlet implementation class EditEmployee
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployee() {
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
		Employee Newemp = null;
		ArrayList<String> columns = new ArrayList<String>();
		int flag = 0;
		
		String action = request.getParameter("Button");
		PrintWriter out= response.getWriter();
		
		if(action.equals("Update the Employee")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			//get Employee Details
			try {
				emp = obj.getEmployeesByID(id);

				String fname = request.getParameter("fname");
				if (!emp.getFirstname().equals(fname)) { columns.add("First Name"); }
				
				String lname = request.getParameter("lname");
				if (!emp.getLastname().equals(lname)) { columns.add("Last Name"); }
				
				String email = request.getParameter("email");
				if (!emp.getEmail().equals(email)) { columns.add("Email"); }
				
				String phone = request.getParameter("phone");
				if (!emp.getPhone_number().equals(phone)) { columns.add("Phone Number"); }

				Date date = new Date();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				date = sf.parse(request.getParameter("hireDate"));
				java.sql.Date sqldate = new java.sql.Date(date.getTime());
				if (!emp.getHire_date().equals(date)) { columns.add("Hire Date"); }

				String jobId = request.getParameter("jobId");
				if (!emp.getJob_id().equals(jobId)) { columns.add("Job ID"); }
				
				double salary = Double.parseDouble(request.getParameter("salary"));
				if (emp.getSalary() != salary) { columns.add("Salary"); }
				
				double comm = Double.parseDouble(request.getParameter("comm"));
				if (emp.getCommission_pct() != comm) { columns.add("Commission Pct"); }
				
				int managerId = Integer.parseInt(request.getParameter("managerId"));
				if (emp.getManager_id() != managerId) { columns.add("Manager ID"); }
				
				int deptId = Integer.parseInt(request.getParameter("deptName"));
				if (emp.getDepartment_id() != deptId) { columns.add("Department Name"); }
				

				Newemp = new Employee(id, fname, lname, email, phone, sqldate, jobId, salary, comm, managerId, deptId);
				flag = obj.updateEmployee(Newemp);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if (flag == 1) {
				request.setAttribute("Employee_List", Newemp);
				request.setAttribute("Columns", columns);
				request.getRequestDispatcher("/UpdateDone.jsp").forward(request, response);
			}
			else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/EditEmployee.jsp");
	            out.println("<p style=\"color:red;\">Something Went Wrong."
	            		+ " Record Not Updated.</p>");
	            rd.include(request, response);
			}
		}
		else {
			int id = Integer.parseInt(request.getParameter("id"));
			flag = obj.deleteEmployeeByID(id);
			
			if (flag == 1) {
				request.setAttribute("Deleted_id", id);
				request.getRequestDispatcher("/DeleteDone.jsp").forward(request, response);
			}
			else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/EditEmployee.jsp");
	            out.println("<p style=\"color:red;\">Something Went Wrong."
	            		+ " Record Not Deleted.</p>");
	            rd.include(request, response);
			}
		}
		
		
	}

}


