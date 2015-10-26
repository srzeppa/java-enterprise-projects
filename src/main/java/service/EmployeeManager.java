package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Employee;

public class EmployeeManager {

	private Connection connect;
	private final String URL = "jdbc:hsqldb:hsql://localhost/workdb";
	private final String CREATE_TABLE_EMPLOYEE = "CREATE TABLE employee(id bigint GENERATED BY DEFAULT AS IDENTITY, firstname varchar(20), lastname varchar(20), birthDate date)";
	private PreparedStatement addEmployeeStmt;
	private PreparedStatement deleteEmployeeStmt;
	private PreparedStatement deleteAllEmployeesStmt;
	private PreparedStatement getAllEmployeeStmt;

	private Statement statement;
	
	public EmployeeManager(){
		try {
			connect = DriverManager.getConnection(URL);
			statement = connect.createStatement();
	
			ResultSet rs = connect.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("employee".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
	
			if (!tableExists){
				statement.executeUpdate(CREATE_TABLE_EMPLOYEE);
			}
			
			addEmployeeStmt = connect.prepareStatement("INSERT INTO employee(firstname,lastname,birthDate) VALUES (?,?,?);");
			deleteEmployeeStmt = connect.prepareStatement("DELETE FROM employee WHERE lastname = ?;");
			getAllEmployeeStmt = connect.prepareStatement("SELECT * FROM employee;");
			deleteAllEmployeesStmt = connect.prepareStatement("TRUNCATE product;");
			
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public int addEmployee(Employee employee){
		int count = 0;
		try {
			addEmployeeStmt.setString(1, employee.getFirstname());
			addEmployeeStmt.setString(1, employee.getLastname());
			addEmployeeStmt.setString(3, employee.getBirthDate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public void deleteEmployee(Employee employee){
		try {
			deleteEmployeeStmt.setString(1, employee.getLastname());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllEmployees(){
		try {
			deleteAllEmployeesStmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getAllEmployees(){
		try {
			getAllEmployeeStmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
