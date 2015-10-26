package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import domain.Employee;

public class EmployeeManager {

	private Connection connect;
	private final String URL = "jdbc:hsqldb:hsql://localhost/workdb";
	private final String CREATE_TABLE_EMPLOYEE = "CREATE TABLE employee(id bigint GENERATED BY DEFAULT AS IDENTITY, firstname varchar(20), lastname varchar(20), pesel integer)";
	private PreparedStatement addEmployeeStmt;
	private PreparedStatement deleteEmployeeStmt;
	private PreparedStatement deleteAllEmployeesStmt;
	private PreparedStatement getAllEmployeeStmt;

	private Statement statement;
	
	public EmployeeManager(){
		try {
			connect = DriverManager.getConnection(URL);
			statement = connect.createStatement();
	
			ResultSet rs = connect.getMetaData().getTables(null, null, null,null);
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
			
			addEmployeeStmt = connect.prepareStatement("INSERT INTO employee (firstname, lastname, pesel) VALUES (?, ?, ?)");
			deleteEmployeeStmt = connect.prepareStatement("DELETE FROM employee WHERE lastname = ?");
			getAllEmployeeStmt = connect.prepareStatement("SELECT id,firstname,lastname,pesel FROM employee");
			deleteAllEmployeesStmt = connect.prepareStatement("DELETE FROM employee");
			
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return connect;
	}
	
	public int addEmployee(Employee employee){
		int count = 0;
		try {
			addEmployeeStmt.setString(1, employee.getFirstname());
			addEmployeeStmt.setString(2, employee.getLastname());
			addEmployeeStmt.setInt(3, employee.getPesel());
			
			count = addEmployeeStmt.executeUpdate();
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
			deleteAllEmployeesStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		try {
			ResultSet rs = getAllEmployeeStmt.executeQuery();

			while (rs.next()) {
				Employee empl = new Employee();
				empl.setId(rs.getInt("id"));
				empl.setFirstname(rs.getString("firstname"));
				empl.setLastname(rs.getString("lastname"));
				empl.setPesel(rs.getInt("pesel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
}
