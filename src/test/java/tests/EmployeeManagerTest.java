package tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import domain.Employee;
import service.EmployeeManager;

public class EmployeeManagerTest {
	
	EmployeeManager employeeManager = new EmployeeManager();
	private final static String FIRSTNAME = "Jurek";
	private final static String LASTNAME = "Ziomek";
	private final static int PESEL = 1231;

	@Test
	public void checkConnection() {
		assertNotNull(employeeManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		Employee employee = new Employee(FIRSTNAME,LASTNAME,PESEL);
		
		employeeManager.deleteAllEmployees();
		assertEquals(1,employeeManager.addEmployee(employee));
		
		List<Employee> employees = employeeManager.getAllEmployees();
		Employee employeeRetrieved = employees.get(0);
		
		assertEquals(FIRSTNAME, employeeRetrieved.getFirstname());
		assertEquals(LASTNAME, employeeRetrieved.getLastname());
		assertEquals(PESEL, employeeRetrieved.getPesel());
	}
}
