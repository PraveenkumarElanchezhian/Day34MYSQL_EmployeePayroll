package dataBasePracticeProblem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

	public static void main(String[] args) {
		PayrollServiceDatabase rv = new PayrollServiceDatabase();
		rv.RetriveEmployeePayroll();
	}
}
