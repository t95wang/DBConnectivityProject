package model;
/**
 * @title CJV805 Assignment1
 * 
 * @author Tianbo Wang & Saliha Shaikh
 * 
 * @date 2019-06-12
 */

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import model.Employee;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class DAManager {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DAManager() throws RemoteException{
		super();
	}
	/**
	 * This method insert a new employee row.
	 * 
	 * @param  emp
	 * @throws RemoteException 
	 * @throws SQLException 
	 * @throws Exception
	 */
	
	
	public int addEmployee(Employee emp) {
		int flag = 0;
		try {
			ConnectionPool pool = ConnectionPool.getInstance(); 
			PreparedStatement PreStmt = null;

			// SQL Query Statement
			String query = "INSERT INTO Employees (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) "
					+ "VALUES ( ?, ? ,? ,?, ?, ?, ?, ?, ?, ?, ? ) ";

			// Create a Statement object that will QUERY City table.
			Connection conn = pool.getConnection();
			PreStmt = conn.prepareStatement(query);

			PreStmt.setInt(1, emp.getEmployee_id());
			PreStmt.setString(2, emp.getFirstname());
			PreStmt.setString(3, emp.getLastname());
			PreStmt.setString(4, emp.getEmail());
			PreStmt.setString(5, emp.getPhone_number());
			PreStmt.setDate(6,  (Date) emp.getHire_date());
			PreStmt.setString(7, emp.getJob_id());
			PreStmt.setDouble(8, emp.getSalary());
			PreStmt.setDouble(9, emp.getCommission_pct());
			PreStmt.setInt(10, emp.getManager_id());
			PreStmt.setInt(11, emp.getDepartment_id());

			// Returns a ResultSet object containing results.
			PreStmt.executeUpdate();
			flag = PreStmt.getUpdateCount();
			System.out.println("Record Added Successfully...!!!");

			// closing connection
			pool.freeConnection(conn);
			System.out.println("...........");
			System.out.println(flag);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	} 
	
	/**
	 * This method get all information from all employees.
	 * 
	 * 
	 * @throws Exception
	 */

	public ArrayList<Employee> getAllEmployees() throws SQLException, FileNotFoundException,
			InvalidPropertiesFormatException, IOException, ClassNotFoundException {
		ConnectionPool pool = ConnectionPool.getInstance(); 
		Statement Stmt = null;
		ResultSet result = null;

		String query = "SELECT * FROM Employees ORDER BY Employee_id ";
		Connection conn = pool.getConnection();
		Stmt = conn.createStatement();
		result = Stmt.executeQuery(query);

		ArrayList<Employee> employeeData = new ArrayList<Employee>();

		while (result.next()) {
			Employee emp = new Employee(result.getInt("EMPLOYEE_ID"), result.getString("FIRST_NAME"),
					result.getString("LAST_NAME"), result.getString("EMAIL"), result.getString("PHONE_NUMBER"),
					result.getDate("HIRE_DATE"), result.getString("JOB_ID"), result.getDouble("SALARY"),
					result.getDouble("COMMISSION_PCT"), result.getInt("MANAGER_ID"), result.getInt("DEPARTMENT_ID"));
			employeeData.add(emp);
		}
		pool.freeConnection(conn);
		return employeeData;
	} 
	
	/**
	 * This method get employees information by department ID.
	 * 
	 * @param  depid
	 * @throws Exception
	 */
	public ArrayList<Employee> getEmployeesByDepartmentID(int depid) throws SQLException, FileNotFoundException,
			InvalidPropertiesFormatException, IOException, ClassNotFoundException {
		ConnectionPool pool = ConnectionPool.getInstance(); 
		PreparedStatement PreStmt = null;
		ResultSet result = null;

		System.out.println("depid: " + depid);

		//SQL Query Statement
		String query = "SELECT * FROM Employees WHERE Department_id = ? ORDER BY Employee_id ";

		// Create a Statement object that will QUERY City table.
		Connection conn = pool.getConnection();
		PreStmt = conn.prepareStatement(query);
		PreStmt.setInt(1, depid);

		result = PreStmt.executeQuery();

		ArrayList<Employee> employeeData = new ArrayList<>();

		while (result.next()) {
			Employee emp = new Employee(result.getInt("EMPLOYEE_ID"), result.getString("FIRST_NAME"),
					result.getString("LAST_NAME"), result.getString("EMAIL"), result.getString("PHONE_NUMBER"),
					 result.getDate("HIRE_DATE"), result.getString("JOB_ID"), result.getDouble("SALARY"),
					result.getDouble("COMMISSION_PCT"), result.getInt("MANAGER_ID"), result.getInt("DEPARTMENT_ID"));
			employeeData.add(emp);
		}
		pool.freeConnection(conn);
		return employeeData;
	}
	
	/**
	 * This method get employees information by Employee ID.
	 * 
	 * @param  id
	 * @throws Exception
	 */
	public Employee getEmployeesByID(int id) throws SQLException, FileNotFoundException,
			InvalidPropertiesFormatException, IOException, ClassNotFoundException {
		ConnectionPool pool = ConnectionPool.getInstance(); 
		PreparedStatement PreStmt = null;
		ResultSet result = null;

		System.out.println("id: " + id);

		//SQL Query Statement
		String query = "SELECT * FROM Employees WHERE Employee_id = ? ";

		// Create a Statement object that will QUERY City table.
		Connection conn = pool.getConnection();
		PreStmt = conn.prepareStatement(query);
		PreStmt.setInt(1, id);

		result = PreStmt.executeQuery();

		Employee emp = null;

		while (result.next()) {
			emp = new Employee(result.getInt("EMPLOYEE_ID"), result.getString("FIRST_NAME"),
					result.getString("LAST_NAME"), result.getString("EMAIL"), result.getString("PHONE_NUMBER"),
					result.getDate("HIRE_DATE"), result.getString("JOB_ID"), result.getDouble("SALARY"),
					result.getDouble("COMMISSION_PCT"), result.getInt("MANAGER_ID"), result.getInt("DEPARTMENT_ID"));
		}
		pool.freeConnection(conn);
		return emp;
	}
	
	/**
	 * This method update a new employee row.
	 * 
	 * @param  emp
	 * @throws Exception
	 */

	public int updateEmployee(Employee emp) throws ClassNotFoundException, FileNotFoundException, IOException {
		int flag = 0;
		try {
			ConnectionPool pool = ConnectionPool.getInstance(); 
			Connection conn = pool.getConnection();
			PreparedStatement PreStmt = null;

			//SQL Query Statement
			String query = "UPDATE Employees SET first_name = ?, last_name = ?, email = ?, Phone_Number = ?, Hire_Date = ?, Job_Id = ?, salary = ?, Commission_pct = ?, manager_Id = ?, department_id = ? WHERE Employee_id = ? ";

			// Create a Statement object that will QUERY City table.
			PreStmt = conn.prepareStatement(query);

			PreStmt.setString(1, emp.getFirstname());
			PreStmt.setString(2, emp.getLastname());
			PreStmt.setString(3, emp.getEmail());
			PreStmt.setString(4, emp.getPhone_number());
			PreStmt.setDate(5,  (Date) emp.getHire_date());
			PreStmt.setString(6, emp.getJob_id());
			PreStmt.setDouble(7, emp.getSalary());
			PreStmt.setDouble(8, emp.getCommission_pct());
			PreStmt.setInt(9, emp.getManager_id());
			PreStmt.setInt(10, emp.getDepartment_id());
			PreStmt.setInt(11, emp.getEmployee_id());
			
			// Returns a ResultSet object containing results.
			PreStmt.executeUpdate();
			flag = PreStmt.getUpdateCount();
			
			System.out.println("Record Updated Successfully...!!!");
			pool.freeConnection(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	/**
	 * This method delete a employee row by employee ID.
	 * 
	 * @param  empid
	 * @throws Exception
	 */
	
	public int deleteEmployeeByID(int empid) {
		int flag = 0;
		try {
			ConnectionPool pool = ConnectionPool.getInstance(); 
			Connection conn = pool.getConnection();
			PreparedStatement PreStmt = null;

//SQL Query Statement
			String query = "DELETE FROM Employees WHERE Employee_id = ? ";

// Create a Statement object that will QUERY City table.
			PreStmt = conn.prepareStatement(query);

			PreStmt.setInt(1, empid);

// Returns a ResultSet object containing results.
			PreStmt.executeUpdate();
			flag = PreStmt.getUpdateCount();
			System.out.println("Employee Information Deleted Successfully...!!!");
			pool.freeConnection(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public ArrayList<String> getDepartmentName() throws SQLException, FileNotFoundException,
	InvalidPropertiesFormatException, IOException, ClassNotFoundException {
		ConnectionPool pool = ConnectionPool.getInstance(); 
		Statement Stmt = null;
		ResultSet result = null;
		ArrayList<String> deptName = new ArrayList<String>();

		//SQL Query Statement
		String query = "SELECT Distinct department_name FROM Departments ORDER BY department_name ";

		// Create a Statement object that will QUERY City table.
		Connection conn = pool.getConnection();
		Stmt = conn.createStatement();
	
		result = Stmt.executeQuery(query);

		while (result.next()) {
			deptName.add(result.getString("DEPARTMENT_NAME"));

		}
		System.out.println(deptName);
		pool.freeConnection(conn);
		return deptName;
	}
	/////
	public ArrayList<String> getDepartmentName2(int deptId) throws SQLException, FileNotFoundException,
	InvalidPropertiesFormatException, IOException, ClassNotFoundException {
		ConnectionPool pool = ConnectionPool.getInstance(); 
		PreparedStatement PreStmt = null;
		ResultSet result = null;
		ArrayList<String> deptName = new ArrayList<String>();

		//SQL Query Statement
		String query = "SELECT Distinct department_name FROM Departments WHERE department_id <> ? ORDER BY department_name ";

		// Create a Statement object that will QUERY City table.
		Connection conn = pool.getConnection();
		PreStmt = conn.prepareStatement(query);
		PreStmt.setInt(1, deptId);
		result = PreStmt.executeQuery();

		while (result.next()) {
			deptName.add(result.getString("DEPARTMENT_NAME"));

		}
		System.out.println(deptName);
		pool.freeConnection(conn);
		return deptName;
	}
	
	public String getDeptNameById(int id) throws SQLException, FileNotFoundException,
	InvalidPropertiesFormatException, IOException, ClassNotFoundException {
		ConnectionPool pool = ConnectionPool.getInstance(); 
		PreparedStatement PreStmt = null;
		ResultSet result = null;
		String deptName = null;
		//SQL Query Statement
		String query = "SELECT department_name FROM Departments WHERE Department_id = ? ";

		// Create a Statement object that will QUERY City table.
		Connection conn = pool.getConnection();
		PreStmt = conn.prepareStatement(query);
		PreStmt.setInt(1, id);
		result = PreStmt.executeQuery();

		while (result.next()) {
			deptName = result.getString("DEPARTMENT_NAME");

		}
		System.out.println(deptName);
		pool.freeConnection(conn);
		return deptName;
	}
	
	public int getDeptIdByName(String deptName) throws SQLException, FileNotFoundException,
	InvalidPropertiesFormatException, IOException, ClassNotFoundException {
		ConnectionPool pool = ConnectionPool.getInstance(); 
		PreparedStatement PreStmt = null;
		ResultSet result = null;
		int deptID = 0;
		//SQL Query Statement
		String query = "SELECT department_id FROM Departments WHERE Department_name = ? ";

		// Create a Statement object that will QUERY City table.
		Connection conn = pool.getConnection();
		PreStmt = conn.prepareStatement(query);
		PreStmt.setString(1, deptName);
		result = PreStmt.executeQuery();

		while (result.next()) {
			deptID = result.getInt("DEPARTMENT_ID");

		}
		System.out.println(deptID);
		pool.freeConnection(conn);
		return deptID;
	}

	
}			