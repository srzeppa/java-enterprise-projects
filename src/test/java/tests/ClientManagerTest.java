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
		
		clientManager.deleteAllClients();
		assertEquals(1,clientManager.addClient(client));
		
		List<Client> clients = clientManager.getAllClients();
		Client clientRetrieved = clients.get(0);
		
		assertEquals(FIRSTNAME, clientRetrieved.getFirstname());
		assertEquals(LASTNAME, clientRetrieved.getLastname());
		assertEquals(PESEL, clientRetrieved.getPesel());
	}
	
	@Test
	public void checkDeletingAllClients(){
		Client client = new Client(FIRSTNAME,LASTNAME,PESEL);
		
		clientManager.addClient(client);
		clientManager.deleteAllClients();
		List<Client> clients = clientManager.getAllClients();
		assertEquals(0,clients.size());
	}
	
	@Test
	public void checkGettingAllClients(){
		Client client = new Client(FIRSTNAME, LASTNAME, PESEL);
		
		clientManager.addClient(client);
		clientManager.addClient(client);
		clientManager.addClient(client);
		clientManager.addClient(client);
		clientManager.addClient(client);
		
		List<Client> clients = clientManager.getAllClients();
		assertEquals(5,clients.size());
	}
}
