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
			PreparedStatement stmt = con.prepareStatement(
					"update Emp_PayrollService set salary = ? where employee_name = ?");
			  stmt.setDouble(1, salary);
              stmt.setString(2, employee_name);
              stmt.executeUpdate();
              System.out.println("Updated : "+employee_name+" salary successfully" );
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		PayrollServiceDatabase rv = new PayrollServiceDatabase();
		rv.RetriveEmployeePayroll();
		rv.UpdateEmployeeSalary();
	
	}
}
