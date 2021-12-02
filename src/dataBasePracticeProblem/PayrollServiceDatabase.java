package dataBasePracticeProblem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PayrollServiceDatabase {

	public void RetriveEmployeePayroll() {
		String jdbcurl = "jdbc:mysql://localhost:3306/PayrollService?useSSL=false";
		String userName = "root";
		String password = "Tiger@123";
		Connection con;
		Statement statement;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection(jdbcurl, userName, password);
			statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Emp_PayrollService");
			while (resultSet.next()) {

				String employeeName = resultSet.getString("employee_name");
				int employeeSalary = resultSet.getInt("salary");
				System.out.print(employeeName + " ");
				System.out.print(employeeSalary + " ");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertEmployeeDetails() {
		String jdbcurl = "jdbc:mysql://localhost:3306/PayrollService?useSSL=false";
		String userName = "root";
		String password = "Tiger@123";
		Connection con;
		Statement statement;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection(jdbcurl, userName, password);
			statement = con.createStatement();
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter the Employee name");
			String employeeName = userInput.next();
			System.out.println("Enter the Employee Salary");
			Double employeeSalary = userInput.nextDouble();
			PreparedStatement p_stmt = con
					.prepareStatement("insert into Emp_PayrollService (employee_name,salary) values (?,?)");
			p_stmt.setString(1, employeeName);
			p_stmt.setDouble(2, employeeSalary);
			p_stmt.executeUpdate();
			System.out.println("Insert Employee Details Successfully");
			System.out.println("Emp.Name : " + employeeName + " || " + "Salary : " + employeeSalary);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void UpdateEmployeeSalary() {
		String jdbcurl = "jdbc:mysql://localhost:3306/PayrollService?useSSL=false";
		String userName = "root";
		String password = "Tiger@123";
		Connection con;
		Statement statement;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection(jdbcurl, userName, password);
			statement = con.createStatement();
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter the Employee name");
			String employee_name = userInput.next();
			System.out.println("Enter the Employee salary to update");
			double salary = userInput.nextDouble();
			PreparedStatement stmt = con
					.prepareStatement("update Emp_PayrollService set salary = ? where employee_name = ?");
			stmt.setDouble(1, salary);
			stmt.setString(2, employee_name);
			stmt.executeUpdate();
			System.out.println("Updated : " + employee_name + " salary successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void retrieveByDate() {
		String jdbcurl = "jdbc:mysql://localhost:3306/PayrollService?useSSL=false";
		String userName = "root";
		String password = "Tiger@123";
		Connection con;
		Statement statement;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection(jdbcurl, userName, password);
			statement = con.createStatement();
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter the date 'YYYY-MM-DD'");
			String first_emp_joinedDate = userInput.next();
			System.out.println("Enter the date 'YYYY-MM-DD'");
			String third_emp_joinedDate = userInput.next();
			PreparedStatement p_stmt = con
					.prepareStatement("select * from Emp_PayrollService where date between ? and ? ");
			p_stmt.setString(1, first_emp_joinedDate);
			p_stmt.setString(2, third_emp_joinedDate);
			ResultSet resultSet = p_stmt.executeQuery();
			System.out.println("Retrieve Employee details successfully by date range");
			while (resultSet.next()) {
				System.out.println("Emp.Name : " + resultSet.getString("employee_name") + " || " + "Salary : "
						+ resultSet.getDouble("salary") + " || " + "Joined Date :" + " " + resultSet.getDate("date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void retrieveByGender() {
		String jdbcurl = "jdbc:mysql://localhost:3306/PayrollService?useSSL=false";
		String userName = "root";
		String password = "Tiger@123";
		Connection con;
		Statement statement;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection(jdbcurl, userName, password);
			statement = con.createStatement();
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter the Employee Gender -> 'Male' || 'Female'");
			String employee_Gender = userInput.next();
			PreparedStatement p_stmt = con.prepareStatement(
					"Select sum(salary)as sumsalary ,avg(salary)as avgsalary,min(salary)as minsalary,max(salary)as maxsalary,count(salary)as countsalary "
					+ "from Emp_PayrollService where Gender = ? group by Gender");
			p_stmt.setString(1, employee_Gender);
			ResultSet resultSet = p_stmt.executeQuery();
			System.out.println("Retrieve Employee details successfully by Employee Gender");
			while (resultSet.next()) {
				System.out.println("Employee Sum Salary : "+ resultSet.getDouble("sumsalary"));
				System.out.println("Employee Avg Salary : "+ resultSet.getDouble("avgsalary"));
				System.out.println("Employee Min Salary : "+ resultSet.getDouble("minsalary"));
				System.out.println("Employee Max Salary : "+ resultSet.getDouble("maxsalary"));
				System.out.println("Employee Count Salary : "+ resultSet.getInt("countsalary"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PayrollServiceDatabase rv = new PayrollServiceDatabase();
		rv.insertEmployeeDetails();
		rv.RetriveEmployeePayroll();
		rv.UpdateEmployeeSalary();
		rv.retrieveByDate();
		rv.retrieveByGender();

	}
}
