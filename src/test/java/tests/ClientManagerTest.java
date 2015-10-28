package tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import domain.Client;
import service.ClientManager;

public class ClientManagerTest {
	
	ClientManager clientManager = new ClientManager();
	private final static String FIRSTNAME = "Jurek";
	private final static String LASTNAME = "Ziomek";
	private final static int PESEL = 12342331;
	
	@Test
	public void checkAdding(){
		Client client = new Client(FIRSTNAME,LASTNAME,PESEL);
		
		clientManager.deleteAllEmployees();
		assertEquals(1,clientManager.addEmployee(client));
		
		List<Client> clients = clientManager.getAllEmployees();
		Client employeeRetrieved = clients.get(0);
		
		assertEquals(FIRSTNAME, employeeRetrieved.getFirstname());
		assertEquals(LASTNAME, employeeRetrieved.getLastname());
		assertEquals(PESEL, employeeRetrieved.getPesel());
	}
}
