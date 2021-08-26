package ca.myseneca.model;

import java.io.IOException;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ca.myseneca.model.Employee;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Servlet implementation class RetrieveCountriesByLifeExpectancies
 */
@WebServlet("/SE")
public class SearchEmployeeByWord extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DataSource dataSource;
	private Connection connection;
	private Statement statement;
	
	public void init() throws ServletException {
		try {
			// Get DataSource
			Context initContext  = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/oracle");

			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	//String num1 = request.getParameter("number1");
        //String num2 = request.getParameter("number2");
	/*
     	// get request parameters for email and password
    	 //String email = request.getParameter("email");
         String num1 = request.getParameter("number1");
         String num2 = request.getParameter("number2");

        

        // store data in User object
         //Country country = new Country();
         //user.setEmail(email);
         //user.setFirstName(fname);
         //user.setLastName(lname);

         // check the email and password from database
         boolean pass = ((Integer.parseInt(num1) >= 20) & (Integer.parseInt(num1) <= 100) &
        		 (Integer.parseInt(num2) >= 20) & (Integer.parseInt(num2) <= 100));

         if (pass) {
         // set User object in request object and and forward to LoginSuccess.jsp page
         //request.setAttribute("num1", num1);
         //request.setAttribute("num2", num2);
         
        	 try { 
         // Initialize the database 
         Connection con = DatabaseConnection.initializeDatabase(); 

         // Create a SQL query to insert data into demo table 
         // demo table consists of two columns, so two '?' is used 
         //PreparedStatement st = con.prepareStatement("SELECT * FROM Country WHERE LifeExpectancy BETWEEN ? and ?"); 
         ResultSet resultSet = null; 
         // For the first parameter, 
         // get the data using request object 
         // sets the data to st pointer 
         String sql = "select * from Country "
        		 + "where LifeExpectancy between ? and ? order by 2 desc;";
         PreparedStatement st = con.prepareStatement(sql);
			
         st.setInt(1, Integer.valueOf(request.getParameter("number1"))); 

         // Same for second parameter 
         st.setInt(2, Integer.valueOf(request.getParameter("number2"))); 
         
         
         resultSet = st.executeQuery();
         ArrayList<Country> countryData = new ArrayList<>();

         while (resultSet.next()) {
        	 Country country = new Country(resultSet.getString("Code"), resultSet.getString("Name"),
        			 resultSet.getString("Continent"), resultSet.getString("Region"), resultSet.getString("SurfaceArea"),
        			 resultSet.getString("IndepYear"), resultSet.getString("Population"), resultSet.getString("LifeExpectancy"),
        			 resultSet.getString("GNP"), resultSet.getString("GNPOld"), resultSet.getString("LocalName"),
        			 resultSet.getString("GovernmentForm"), resultSet.getString("HeadOfState"), resultSet.getString("Capital"), resultSet.getString("Code2"));
        	 countryData.add(country);
         }
				
         getServletContext().getRequestDispatcher("/Success.jsp")
         .forward(request, response);}
         //response.sendRedirect("LoginSuccess.jsp");
         catch (Exception e) { 
             e.printStackTrace(); 
         } 

         } else {
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter out= response.getWriter();
            out.println("<p style=\"color:red;\">Numbers should between 20 and 100. "
            		+ "Please try again.</p>");
            rd.include(request, response);
            //rd.forward(request, response);
        }
	}
	*/
    ArrayList<Employee> employeeData = new ArrayList<>();
	ResultSet resultSet = null;
	try {
		// Get Connection and Statement
		/*
		connection = dataSource.getConnection();
		String sql = "select * from Country "
	       		 + "where LifeExpectancy between ? and ? ";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setObject(1, 60); 

        // Same for second parameter 
		st.setObject(2, 90); 
		resultSet = st.executeQuery();
		*/
		connection = dataSource.getConnection();
		//PreparedStatement stmt = (PreparedStatement) connection.createStatement();
        String sql = "SELECT * FROM Employees Join Departments ON (Employees.department_ID = Departments.DEPARTMENT_ID)"
        		+ "WHERE first_name LIKE ? OR last_name LIKE ? OR phone_number LIKE ? OR email LIKE ? OR department_name LIKE ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, "%"+request.getParameter("word")+"%"); 
        stmt.setString(2, "%"+request.getParameter("word")+"%"); 
        stmt.setString(3, "%"+request.getParameter("word")+"%"); 
        stmt.setString(4, "%"+request.getParameter("word")+"%"); 
        stmt.setString(5, "%"+request.getParameter("word")+"%"); 

        
        
        resultSet = stmt.executeQuery();
        
		while (resultSet.next()) {
			Employee employee = new Employee();
			employee.setFirstname(resultSet.getString("first_name")+ " " +resultSet.getString("last_name")); 
			employee.setDepartment(resultSet.getString("department_name"));
			employee.setJob_id(resultSet.getString("job_id")); 
			employee.setSalary(resultSet.getInt("salary"));
			employee.setEmail(resultSet.getString("email"));
			employee.setPhone_number(resultSet.getString("phone_number")); 
			employeeData.add(employee);

		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try { if(null!=resultSet)resultSet.close();} catch (SQLException e) 
		{e.printStackTrace();}
		try { if(null!=statement)statement.close();} catch (SQLException e) 
		{e.printStackTrace();}
		try { if(null!=connection)connection.close();} catch (SQLException e) 
		{e.printStackTrace();}
	}
	ArrayList<Employee> abc = new ArrayList<>();
	Employee ccountry = new Employee();
	ccountry.setFirstname(connection+"0");
	abc.add(ccountry);	
	request.setAttribute("employee", employeeData);
	getServletContext().getRequestDispatcher("/SearchEmployee.jsp").forward(request, response);
}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
    		throws ServletException, IOException {
        doPost(request, response);
    } 
}

