package ca.myseneca.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
		
	/**
	* 
	*/
	private static final long serialVersionUID = -6595616682049814098L;
		private int employee_id;
		private String firstname;
		private String fullname;
		private String lastname;
		private String email;
		private String phone_number;
		private Date hire_date;
		private String job_id;
		private double salary;
		private double commission_pct;
		private int manager_id;
		private int department_id;
		private String department;
		/**
		 * 
		 */
		public Employee() {
		}
		
		/**
		 * @param employee_id
		 * @param firstname
		 * @param fullname
		 * @param lastname
		 * @param email
		 * @param phone_number
		 * @param hire_date
		 * @param job_id
		 * @param salary
		 * @param commission_pct
		 * @param manager_id
		 * @param department_id
		 * @param department
		 */
		public Employee(int employee_id, String firstname, String fullname, String lastname, String email, String phone_number,
				Date hire_date, String job_id, double salary, double commission_pct, int manager_id,
				int department_id, String department) {
			this.employee_id = employee_id;
			this.firstname = firstname;
			this.fullname = fullname;
			this.lastname = lastname;
			this.email = email;
			this.phone_number = phone_number;
			this.hire_date = hire_date;
			this.job_id = job_id;
			this.salary = salary;
			this.commission_pct = commission_pct;
			this.manager_id = manager_id;
			this.department_id = department_id;
			this.department = department;
		}

		/**
		 * @return the employee_id
		 */
		public int getEmployee_id() {
			return employee_id;
		}

		/**
		 * @param employee_id the employee_id to set
		 */
		public void setEmployee_id(int employee_id) {
			this.employee_id = employee_id;
		}

		/**
		 * @return the firstname
		 */
		public String getFullname() {
			return fullname;
		}

		/**
		 * @param firstname the firstname to set
		 */
		public void setFulltname(String firstname, String lastname) {
			this.fullname = firstname + " " + lastname;
		}
		
		/**
		 * @return the firstname
		 */
		public String getFirstname() {
			return firstname;
		}

		/**
		 * @param firstname the firstname to set
		 */
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		/**
		 * @return the lastname
		 */
		public String getLastname() {
			return lastname;
		}

		/**
		 * @param lastname the lastname to set
		 */
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return the phone_number
		 */
		public String getPhone_number() {
			return phone_number;
		}

		/**
		 * @param phone_number the phone_number to set
		 */
		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}

		/**
		 * @return the hire_date
		 */
		public Date getHire_date() {
			return hire_date;
		}

		/**
		 * @param hire_date the hire_date to set
		 */
		public void setHire_date(Date hire_date) {
			this.hire_date = hire_date;
		}

		/**
		 * @return the job_id
		 */
		public String getJob_id() {
			return job_id;
		}

		/**
		 * @param job_id the job_id to set
		 */
		public void setJob_id(String job_id) {
			this.job_id = job_id;
		}

		/**
		 * @return the salary
		 */
		public double getSalary() {
			return salary;
		}

		/**
		 * @param salary the salary to set
		 */
		public void setSalary(double salary) {
			this.salary = salary;
		}

		/**
		 * @return the commission_pct
		 */
		public double getCommission_pct() {
			return commission_pct;
		}

		/**
		 * @param commission_pct the commission_pct to set
		 */
		public void setCommission_pct(double commission_pct) {
			this.commission_pct = commission_pct;
		}

		/**
		 * @return the manager_id
		 */
		public int getManager_id() {
			return manager_id;
		}

		/**
		 * @param manager_id the manager_id to set
		 */
		public void setManager_id(int manager_id) {
			this.manager_id = manager_id;
		}

		/**
		 * @return the department_id
		 */
		public int getDepartment_id() {
			return department_id;
		}

		/**
		 * @param department_id the department_id to set
		 */
		public void setDepartment_id(int department_id) {
			this.department_id = department_id;
		}
		
		/**
		 * @return the department_id
		 */
		public String getDepartment() {
			return department;
		}

		/**
		 * @param department_id the department_id to set
		 */
		public void setDepartment(String department) {
			this.department = department;
		}
		
		//display values
		public String toString () {
			String str;
			str = "Employee ID: " + employee_id + "\n" +
			      "First Name: " + firstname + "\n" +
			      "Last Name: " + lastname + "\n" +
				  "Phone Number: " + phone_number+ "\n" + 
				  "Hire Date: " + hire_date+ "\n" + 
				  "Job ID: " + job_id+ "\n" + 
				  "Salary: " + salary+ "\n" + 
				  "Commission Pct: " + commission_pct+ "\n" + 
				  "Manager ID: " + manager_id+ "\n" + 
				  "Department ID: " + department_id+ "\n" ;
				
			return str;
		}

		
}
